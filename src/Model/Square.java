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
    public void setUpBoard(Square[][] board, int x_direction, int y_direction) throws IOException
    {
        this.setX_location(x_direction);
        this.setY_location(y_direction);
        
        for (int xIndex = 0; xIndex < this.getY_location() + 1; xIndex++)
        {
            for (int yIndex = 0; yIndex < this.getX_location() + 1; yIndex++)
            {
                board[xIndex][yIndex] = new Square(null, xIndex, yIndex);
            }
        } 
    } 
}
