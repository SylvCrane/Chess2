/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author navjo
 */
public class Rook extends Piece{
    
    public Rook(String pieceName, int potential_moves, PlayerColour colour)
    {
        super(pieceName);
        this.pieceName = pieceName;
        this.potential_moves = potential_moves;
        this.colour = colour;
        this.direction = Direction.STILL;
    }
    

    /**
     * Like with the bishop, this method will check every location up to and including the destination. This is because
     * it cannot move to a location with another piece. Furthermore, the for loops go up to the difference of the 
     * location (y_direction or x_direction) and the current piece's location.
     * 
     * @param x_direction
     * @param y_direction
     * @param pieceToMove
     * @param board
     * @return 
     */
    @Override
    public int CheckMove(int x_direction, int y_direction, Square pieceToMove, Square[][] board) {
       
        int check = 1;
        
        if (pieceToMove.getPiece().direction == Direction.NORTH)
        {
            for (int i = 1; i < (y_direction - pieceToMove.getY_location()); i++)
            {
                if (board[pieceToMove.getX_location()][pieceToMove.getY_location() + i].getPiece() != null)
                {
                    check = 0;
                }
            }
        }
        else if (pieceToMove.getPiece().direction == Direction.EAST)
        {
            for (int i = 1; i < (x_direction - pieceToMove.getX_location()); i++)
            {
                if (board[pieceToMove.getX_location() + i][pieceToMove.getY_location()].getPiece() != null)
                {
                    check = 0;
                }
            }
        }
        else if (pieceToMove.getPiece().direction == Direction.SOUTH)
        {
            for (int i = 1; i < (pieceToMove.getY_location() - y_direction); i++)
            {
                if (board[pieceToMove.getX_location()][pieceToMove.getY_location() - i].getPiece() != null)
                {
                    check = 0;
                }
            }
        }
        else if (pieceToMove.getPiece().direction == Direction.WEST)
        {
            for (int i = 1; i < (pieceToMove.getX_location() - x_direction); i++)
            {
                if (board[pieceToMove.getX_location() - i][pieceToMove.getY_location()].getPiece() != null)
                {
                    check = 0;
                } 
            }
        }
        
        return check;
    }

    @Override
    public void MakeMove(int x_direction, int y_direction, Square pieceToMove, Square[][] board) {
        
        int xOrigin = pieceToMove.getX_location();
        int yOrigin = pieceToMove.getY_location();
        
        board[x_direction][y_direction].setPiece(pieceToMove.getPiece());
        board[xOrigin][yOrigin].setPiece(null); 
    }
}
