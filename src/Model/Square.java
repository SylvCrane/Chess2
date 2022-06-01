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
 
    public Square(Piece piece, int x_location, int y_location)
    {
        this.x_location = x_location;
        this.y_location = y_location;
        this.piece = piece;
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
    
  
    /**
     * This sets up the board that will be used for the duration of the program. It simply initializes each location, as otherwise it would be null.
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
    } 
}
