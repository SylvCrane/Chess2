package Model;

import Model.Piece;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class establishes the square that the pieces are 'on' in the game. The board is also initialized here
 *
 * @author navjo
 */
public class Square {

    private Piece piece;
    private int x_location;
    private int y_location;
    private boolean validLocation;
 
    public Square(Piece piece, int x_location, int y_location)
    {
        this.x_location = x_location;
        this.y_location = y_location;
        this.piece = piece;
        this.validLocation = false;
    }
    
    
    
    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

   
    public int getX_location() {
        return x_location;
    }

    
    public void setX_location(int x_location) {
        this.x_location = x_location;
    }

    
    public int getY_location() {
        return y_location;
    }

    
    public void setY_location(int y_location) {
        this.y_location = y_location;
    }
    
    public boolean isValidLocation() {
        return validLocation;
    }

    public void setValidLocation(boolean validLocation) {
        this.validLocation = validLocation;
    }
    
    /**
     * This sets up the board that will be used for the duration of the program. Specifically, it reads from the pieces text file and initializes each piece, 
     * which includes its name, color and direction. Their location is also set.
     * 
     * @param board
     * @param x_direction
     * @param y_direction
     * @throws IOException 
     */
    public void setUpBoard(Square[][] board) throws IOException
    {
        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                board[x][y] = new Square(null, x, y);
            }
        }
        
        board[0][0].setPiece(new Rook("whiteRook1", 8, PlayerColour.WHITE));
        board[1][0].setPiece(new Knight("whiteKnight1", 0, PlayerColour.WHITE));
        board[2][0].setPiece(new Bishop("whiteBishop1", 8, PlayerColour.WHITE));
        board[3][0].setPiece(new King("whiteKing", 1, PlayerColour.WHITE));
        board[4][0].setPiece(new Queen("whiteQueen", 8, PlayerColour.WHITE));
        board[5][0].setPiece(new Bishop("whiteBishop2", 8, PlayerColour.WHITE));
        board[6][0].setPiece(new Knight("whiteKnight2", 0, PlayerColour.WHITE));
        board[7][0].setPiece(new Rook("whiteRook2", 8, PlayerColour.WHITE));
        
        board[0][1].setPiece(new Pawn("whitePawn1", 2, PlayerColour.WHITE));
        board[1][1].setPiece(new Pawn("whitePawn2", 2, PlayerColour.WHITE));
        board[2][1].setPiece(new Pawn("whitePawn3", 2, PlayerColour.WHITE));
        board[3][1].setPiece(new Pawn("whitePawn4", 2, PlayerColour.WHITE));
        board[4][1].setPiece(new Pawn("whitePawn5", 2, PlayerColour.WHITE));
        board[5][1].setPiece(new Pawn("whitePawn6", 2, PlayerColour.WHITE));
        board[6][1].setPiece(new Pawn("whitePawn7", 2, PlayerColour.WHITE));
        board[7][1].setPiece(new Pawn("whitePawn8", 2, PlayerColour.WHITE));
        
        board[0][6].setPiece(new Pawn("blackPawn1", 2, PlayerColour.BLACK));
        board[1][6].setPiece(new Pawn("blackPawn2", 2, PlayerColour.BLACK));
        board[2][6].setPiece(new Pawn("blackPawn3", 2, PlayerColour.BLACK));
        board[3][6].setPiece(new Pawn("blackPawn4", 2, PlayerColour.BLACK));
        board[4][6].setPiece(new Pawn("blackPawn5", 2, PlayerColour.BLACK));
        board[5][6].setPiece(new Pawn("blackPawn6", 2, PlayerColour.BLACK));
        board[6][6].setPiece(new Pawn("blackPawn7", 2, PlayerColour.BLACK));
        board[7][6].setPiece(new Pawn("blackPawn8", 2, PlayerColour.BLACK));
        
        board[0][7].setPiece(new Rook("blackRook1", 8, PlayerColour.BLACK));
        board[1][7].setPiece(new Knight("blackKnight1", 0, PlayerColour.BLACK));
        board[2][7].setPiece(new Bishop("blackBishop1", 8, PlayerColour.BLACK));
        board[3][7].setPiece(new King("blackKing", 1, PlayerColour.BLACK));
        board[4][7].setPiece(new Queen("blackQueen", 8, PlayerColour.BLACK));
        board[5][7].setPiece(new Bishop("blackBishop2", 8, PlayerColour.BLACK));
        board[6][7].setPiece(new Knight("blackKnight2", 0, PlayerColour.BLACK));
        board[7][7].setPiece(new Rook("blackRook2", 8, PlayerColour.BLACK));
        
    } 
}
