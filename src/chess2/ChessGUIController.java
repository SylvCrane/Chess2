/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess2;

import Model.PlayerInput;
import Model.Square;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        
        String buttonName = arg0.getActionCommand();
        
        if (buttonName.equals("Enter"))
        {
            this.view.setPlayer1(new JLabel());
            this.view.getPlayer1().setText(this.view.getPlayer1Field().getText());
            this.view.setPlayer2(new JLabel());
            this.view.getPlayer2().setText(this.view.getPlayer2Field().getText());
            this.view.mainGame();
        }
        else if (buttonName.equals("quit"))
        {
            System.out.println("You pressed the quit button");
        }
        else
        {
            int x = Integer.valueOf(buttonName.charAt(0)) - 48;
            int y = Integer.valueOf(buttonName.charAt(1)) - 48;
            
       
            
            if (!this.view.isPieceSelected())
            {
                this.model.selectPiece(x, y);
            }
            else if (!this.view.isDestinationSelected())
            {
                this.model.selectDestination(x, y);
                
                if (this.view.pieceMoved)
                {
                    this.model.chequePlayer();
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
