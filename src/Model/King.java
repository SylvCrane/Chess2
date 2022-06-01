/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author navjo
 */
public class King extends Piece{
    
    public King(String pieceName, int potential_moves, PlayerColour colour)
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
        
        if (pieceToMove.getPiece().direction == Direction.NORTH)
        {
            
            if (board[pieceToMove.getX_location()][pieceToMove.getY_location() + 1].getPiece() != null && board[pieceToMove.getX_location()][pieceToMove.getY_location() + 1].getPiece().colour == pieceToMove.getPiece().colour)
            {
                check = 0;
            }
            
        }
        else if (pieceToMove.getPiece().direction == Direction.EAST)
        {
            
            if (board[pieceToMove.getX_location() + 1][pieceToMove.getY_location()].getPiece() != null && board[pieceToMove.getX_location() + 1][pieceToMove.getY_location()].getPiece().colour == pieceToMove.getPiece().colour)
            {
                check = 0;
            }
            
        }
        else if (pieceToMove.getPiece().direction == Direction.SOUTH)
        {
            
            if (board[pieceToMove.getX_location()][pieceToMove.getY_location() - 1].getPiece() != null && board[pieceToMove.getX_location()][pieceToMove.getY_location() - 1].getPiece().colour == pieceToMove.getPiece().colour)
            {
                check = 0;
            }
            
        }
        else if (pieceToMove.getPiece().direction == Direction.WEST)
        {
            
            if (board[pieceToMove.getX_location() - 1][pieceToMove.getY_location()].getPiece() != null && board[pieceToMove.getX_location() - 1][pieceToMove.getY_location()].getPiece().colour == pieceToMove.getPiece().colour)
            {
                check = 0;
            } 
            
        }
        else if (pieceToMove.getPiece().direction == Direction.NORTHEAST)
        {
            
            if (board[pieceToMove.getX_location() + 1][pieceToMove.getY_location() + 1].getPiece() != null && board[pieceToMove.getX_location() + 1][pieceToMove.getY_location() + 1].getPiece().colour == pieceToMove.getPiece().colour)
            {
                check = 0;
            }
            
        }
        else if (pieceToMove.getPiece().direction == Direction.SOUTHEAST)
        {
            
            if (board[pieceToMove.getX_location() + 1][pieceToMove.getY_location() - 1].getPiece() != null && board[pieceToMove.getX_location() + 1][pieceToMove.getY_location() - 1].getPiece().colour == pieceToMove.getPiece().colour)
            {
                check = 0;
            }

        }
        else if (pieceToMove.getPiece().direction == Direction.SOUTHWEST)
        {
            
            if (board[pieceToMove.getX_location() - 1][pieceToMove.getY_location() - 1].getPiece() != null && board[pieceToMove.getX_location() - 1][pieceToMove.getY_location() - 1].getPiece().colour == pieceToMove.getPiece().colour)
            {
                check = 0;
            }
            
        }
        else if (pieceToMove.getPiece().direction == Direction.NORTHWEST)
        {
            
            if (board[pieceToMove.getX_location() - 1][pieceToMove.getY_location() + 1].getPiece() != null && board[pieceToMove.getX_location() - 1][pieceToMove.getY_location() + 1].getPiece().colour == pieceToMove.getPiece().colour)
            {
                check = 0;
            }
            
        }
       
       return check;
    }

    @Override
    public void MakeMove(int x_direction, int y_direction, Square pieceToMove, Square[][] board) 
    {
        int xOrigin = pieceToMove.getX_location();
        int yOrigin = pieceToMove.getY_location();
        
        board[x_direction][y_direction].setPiece(pieceToMove.getPiece());
        board[xOrigin][yOrigin].setPiece(null);
       
    }
     
}
