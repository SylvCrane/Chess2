/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chess2;

import Model.Piece;
import Model.Player;
import Model.PlayerColour;
import Model.Square;
import Model.chessConnection;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;

/**
 *
 * @author navjo
 */
public class Chess2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException {
        Chess2 chess = new Chess2();
    }
    
    public Chess2() throws IOException, SQLException
    {
         ChessGUIView view = new ChessGUIView();
        view.setVisible(true);
        
        chessConnection connection = new chessConnection();
        connection.chessSetup();
        
        ChessGUIModel model = new ChessGUIModel();
        model.setPlayer1(new Player("Navjot", PlayerColour.WHITE, 0));
        model.setPlayer2(new Player("Dylan", PlayerColour.BLACK, 0));
        model.newPlayerTurn();
        model.addObserver(view);
        model.setChessConn(connection);
        model.getChessConn().writePieces();
        
        HashSet<Piece> playerPieces = new HashSet<Piece>();
        model.setPlayerPieces(playerPieces);
        model.getChessConn().readPieces(playerPieces);
        
        Square setUpSquare = new Square(null, 0, 0);
        Square[][] board = new Square[8][8];
        setUpSquare.setUpBoard(board);
        model.setBoard(board);
        model.instantiateBoard();
        
        ChessGUIController controller = new ChessGUIController();
        controller.addView(view);
        view.addController(controller);
        controller.addModel(model);
        
        
    }
    
}
