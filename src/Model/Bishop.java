/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author navjo
 */
public class Bishop extends Piece{
    
    public Bishop(String pieceName, int potential_moves, PlayerColour colour)
    {
        super(pieceName);
        this.pieceName = pieceName;
        this.potential_moves = potential_moves;
        this.colour = colour;
        this.direction = Direction.STILL;
    }

    @Override
    public int CheckMove(int x_direction, int y_direction, Square pieceToMove, Square[][] board) 
    {
        int check = 1;
        
        if (pieceToMove.getPiece().direction == Direction.NORTHEAST)
        {
            for (int i = 1; i < x_direction; i++)
            {
                if (board[pieceToMove.getX_location() + i][pieceToMove.getY_location() + i].getPiece() != null)
                {
                    check = 0;
                }
            }
        }
        else if (pieceToMove.getPiece().direction == Direction.SOUTHEAST)
        {
            for (int i = 1; i < x_direction; i++)
            {
                if (board[pieceToMove.getX_location() + i][pieceToMove.getY_location() - i].getPiece() != null)
                {
                    check = 0;
                }
            }
        }
        else if (pieceToMove.getPiece().direction == Direction.SOUTHWEST)
        {
            for (int i = 1; i < (x_direction); i++)
            {
                if (board[pieceToMove.getX_location() - i][pieceToMove.getY_location() - i].getPiece() != null)
                {
                    check = 0;
                }
            }
        }
        else if (pieceToMove.getPiece().direction == Direction.NORTHWEST)
        {
            for (int i = 1; i < (x_direction); i++)
            {
                if (board[pieceToMove.getX_location() - i][pieceToMove.getY_location() + i].getPiece() != null)
                {
                    check = 0;
                }
            }
        }
        
        return check;
    }

    @Override
    public void MakeMove(int x_direction, int y_direction, Square pieceToMove, Square[][] board) 
    {
        board[x_direction][y_direction].setPiece(pieceToMove.getPiece());
        board[pieceToMove.getX_location()][pieceToMove.getY_location()].setPiece(null);
    }
     
}
