/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package View;

import Model.Bishop;
import Model.King;
import Model.Knight;
import Model.Pawn;
import Model.Piece;
import Model.Player;
import Model.PlayerColour;
import Model.PlayerInput;
import Model.Queen;
import Model.Rook;
import Model.Square;
import Model.chequePackage;
import Model.chessConnection;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author navjo
 */
public class ChessGUIModelTest {
    
    private Square[][] board;
    private Player player;
    private PlayerInput input;
    private Square pieceToMove;
    private Square destination;
    private Square deadPiece;
    private chequePackage chequePackage;
    private ChessGUIModel model;
   
    public ChessGUIModelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws SQLException, IOException {
        
        chessConnection connection = new chessConnection();
        connection.chessSetup();
        
        this.model.setChessConn(connection);
        this.model.getChessConn().writePieces();
        
        HashSet<Piece> playerPieces = new HashSet<>();
        this.model.setPlayerPieces(playerPieces);
        this.model.getChessConn().readPieces(playerPieces);
        Square initiateBoard = new Square(null, 0, 0);
        this.board = new Square[8][8];
        initiateBoard.setUpBoard(this.board);
        model.setBoard(this.board);
        model.instantiateBoard();
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * The following test works for both the connection and making sure the board is set correctly.
     */
    @Test
    public void testInstantiateBoard() throws SQLException, IOException {
        
        ChessGUIModel model = new ChessGUIModel();
        
        chessConnection connection = new chessConnection();
        connection.chessSetup();
        
        model.setChessConn(connection);
        model.getChessConn().writePieces();
        
        HashSet<Piece> playerPieces = new HashSet<>();
        model.setPlayerPieces(playerPieces);
        model.getChessConn().readPieces(playerPieces);
        Square setUpSquare = new Square(null, 0, 0);
        Square[][] boardTest = new Square[8][8];
        setUpSquare.setUpBoard(boardTest);
        model.setBoard(boardTest);
        model.instantiateBoard();
        
        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                if (this.board[x][y].getPiece().equals(boardTest[x][y].getPiece()))
                {
                    System.out.println("The same");
                }
            }
        }
    }
}

    