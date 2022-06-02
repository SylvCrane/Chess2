 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Player;
import Model.PlayerColour;
import Model.PlayerInput;
import Model.Square;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author navjo
 */
public class ChessGUIController implements ActionListener{
    
    ChessGUIView view;
    ChessGUIModel model;
    
    ChessGUIController()
    {
        //Because it is not called in the conventional sense, data here is unecessary. Furthermore, it is not necessary in an MVC observable GUI.
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        
        //The following string is used to differentiate between buttons. Specifically, the named buttons and the nameless buttons (The square buttons).
        String buttonName = arg0.getActionCommand();
        
        if (buttonName.equals("Enter"))
        {
            //This will initialize the game with the paremeters in the player fields.
            this.view.setPlayer1(new JLabel());
            this.view.getPlayer1().setText(this.view.getPlayer1Field().getText());
            this.view.setPlayer2(new JLabel());
            this.view.getPlayer2().setText(this.view.getPlayer2Field().getText());
            this.view.mainGame();
            
            model.setPlayer1(new Player(this.view.getPlayer1().getText(), PlayerColour.WHITE, 0));
            model.setPlayer2(new Player(this.view.getPlayer2().getText(), PlayerColour.BLACK, 0));
            model.newPlayerTurn();
        }
        else if (buttonName.equals("reset"))
        {
            //This allows the user to reset the program at any time.
            
            System.out.println("You pressed the reset button");
            
            this.view.dispose();
            ChessGUIView newView = new ChessGUIView();
            this.addView(newView);
            this.model.addObserver(newView);
            this.view.addController(this);
            this.view.setVisible(true);
        }
        else if (buttonName.equals("Rules"))
        {
            //This opens the rules frame. If closed, the main frame will remain.
            
            RulesFrame rules = new RulesFrame();
            rules.setVisible(true);
        }
        else
        {
            //This is in the case that the user pressed a square button. In this case, the name of the button (The coordinates) are recorded and used in the model.
            
            int x = Integer.valueOf(buttonName.charAt(0)) - 48;
            int y = Integer.valueOf(buttonName.charAt(1)) - 48;
            
            
            //This is used to differrentiate between piece selection and destination selection.
            if (!this.view.isPieceSelected())
            {
                this.model.selectPiece(x, y);
            }
            else if (!this.view.isDestinationSelected())
            {
                this.model.selectDestination(x, y);
                
                if (this.view.pieceMoved)
                {
                    try {
                        this.model.chequePlayer();
                    } catch (SQLException ex) {
                        Logger.getLogger(ChessGUIController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }
        }
    }
    
    public void addView(ChessGUIView view)
    {
        this.view = view;
    }
    
    public void addModel(ChessGUIModel model)
    {
        this.model = model;
    }
    
    
}
