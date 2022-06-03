/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package View;

import Model.Bishop;
import Model.Cheque;
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
public class ChessTest {
    
    private Square[][] board;
    private Player player;
    private PlayerInput input;
    private Square pieceToMove;
    private Square destination;
    private Square deadPiece;
    private chequePackage chequePackage;
    private ChessGUIModel model;
   
    public ChessTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws SQLException, IOException {
        
        ChessGUIModel model = new ChessGUIModel();
        this.model = model;
        
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
        this.model.setBoard(this.board);
        this.model.instantiateBoard();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * The following test works for both the connection and making sure the board is set correctly.
     */
    @Test
    public void testFalsePieceSelection(){
        
        this.pieceToMove = new Square(null, 0, 0);
        Player player1 = new Player("Navjot", PlayerColour.BLACK, 0);
        
        this.pieceToMove.setX_location(0);
        this.pieceToMove.setY_location(1);
        this.pieceToMove.setPiece(this.board[this.pieceToMove.getX_location()][this.pieceToMove.getY_location()].getPiece());
        
        this.input = new PlayerInput(player1, this.pieceToMove.getPiece().potential_moves, 0, 0, this.pieceToMove);
 
        assertEquals("Invalid location", false, this.input.appropriatePiece(this.board, this.pieceToMove));
    }
    
    @Test
    public void testTruePieceSelection(){
        
        this.pieceToMove = new Square(null, 0, 0);
        Player player1 = new Player("Navjot", PlayerColour.WHITE, 0);
        
        this.pieceToMove.setX_location(0);
        this.pieceToMove.setY_location(1);
        this.pieceToMove.setPiece(this.board[this.pieceToMove.getX_location()][this.pieceToMove.getY_location()].getPiece());
        
        this.input = new PlayerInput(player1, this.pieceToMove.getPiece().potential_moves, 0, 0, this.pieceToMove);
        
        assertEquals("Valid location", true, this.input.appropriatePiece(this.board, this.pieceToMove));
    }
    
    @Test
    public void testFalsePieceDirection(){
        
        this.pieceToMove = new Square(null, 0, 0);
        Player player1 = new Player("Navjot", PlayerColour.WHITE, 0);
        
        this.pieceToMove.setX_location(0);
        this.pieceToMove.setY_location(1);
        this.pieceToMove.setPiece(this.board[this.pieceToMove.getX_location()][this.pieceToMove.getY_location()].getPiece());
        
        this.input = new PlayerInput(player1, this.pieceToMove.getPiece().potential_moves, 0, 0, this.pieceToMove);
        this.input.setX_direction(3);
        this.input.setY_direction(0);
        this.input.setPieceToMove(this.pieceToMove);
        
        assertEquals("Invalid direction", false, this.input.directionCheck(this.board));
    }
    
    @Test
    public void testTruePieceDirection(){
        
        this.pieceToMove = new Square(null, 0, 0);
        Player player1 = new Player("Navjot", PlayerColour.WHITE, 0);
        
        this.pieceToMove.setX_location(0);
        this.pieceToMove.setY_location(1);
        this.pieceToMove.setPiece(this.board[this.pieceToMove.getX_location()][this.pieceToMove.getY_location()].getPiece());
        
        this.input = new PlayerInput(player1, this.pieceToMove.getPiece().potential_moves, 0, 0, this.pieceToMove);
        this.input.setX_direction(0);
        this.input.setY_direction(3);
        this.input.setPieceToMove(this.pieceToMove);
        
        assertEquals("Valid direction", true, this.input.directionCheck(this.board));
    }
    
    @Test
    public void testFalseCheque(){
        
        Player player1 = new Player("Navjot", PlayerColour.WHITE, 0);
        
        Cheque youreInCheque = new Cheque(player1);
        youreInCheque.findKing(this.board, player1);
        
        assertEquals("Player is not in cheque", false, youreInCheque.checkForCheque(this.board, player1));
    }
    
    @Test
    public void testTrueCheque(){
        
        Player player1 = new Player("Navjot", PlayerColour.WHITE, 0);
        
        this.board[3][1].setPiece(new Bishop("Bishop", 8, PlayerColour.BLACK));
        
        Cheque youreInCheque = new Cheque(player1);
        youreInCheque.findKing(this.board, player1);
        
        assertEquals("Player is in cheque", true, youreInCheque.checkForCheque(this.board, player1));
    }
    
    @Test
    public void testFalseCheckMate(){
        
        Player player1 = new Player("Navjot", PlayerColour.WHITE, 0);
        
        this.board[3][1].setPiece(new Bishop("Bishop", 8, PlayerColour.BLACK));
        
        Cheque youreInCheque = new Cheque(player1);
        youreInCheque.findKing(this.board, player1);
        
        assertEquals("Player is not checkmated", false, youreInCheque.checkMate(this.board, player1));
    }
    
    @Test
    public void testTrueCheckMate(){
        
        Player player1 = new Player("Navjot", PlayerColour.WHITE, 0);
        
        this.board[3][1].setPiece(new Bishop("Bishop", 8, PlayerColour.BLACK));
        this.board[3][4].setPiece(new Queen("Queen", 8, PlayerColour.BLACK));
        
        Cheque youreInCheque = new Cheque(player1);
        youreInCheque.findKing(this.board, player1);
        
        assertEquals("Player is checkmated", true, youreInCheque.checkMate(this.board, player1));
    }
    
}

    