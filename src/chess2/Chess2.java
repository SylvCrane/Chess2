/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chess2;

import Model.Player;
import Model.PlayerColour;
import Model.Square;
import java.io.IOException;

/**
 *
 * @author navjo
 */
public class Chess2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Chess2 chess = new Chess2();
    }
    
    public Chess2() throws IOException
    {
        ChessGUIView view = new ChessGUIView();
        view.setVisible(true);
        
        ChessGUIModel model = new ChessGUIModel();
        model.setPlayer1(new Player("Navjot", PlayerColour.WHITE, 0));
        model.setPlayer2(new Player("Dylan", PlayerColour.BLACK, 0));
        model.newPlayerTurn();
        model.addObserver(view);
        
        Square setUpSquare = new Square(null, 0, 0);
        Square[][] board = new Square[8][8];
        setUpSquare.setUpBoard(board);
        model.setBoard(board);
        
        ChessGUIController controller = new ChessGUIController();
        controller.addView(view);
        view.addController(controller);
        controller.addModel(model);
        
        
    }
    
}
