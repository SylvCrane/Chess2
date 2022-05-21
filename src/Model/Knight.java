/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author navjo
 */
public class Knight extends Piece{
    
    public Knight(String pieceName, int potential_moves, PlayerColour colour)
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
        
        /**
         * Because of the knight's special moving situation, wherein it moves in an L-Shape straight to its
         * destination, it only needs to check its destination and none of the spots between.
         */
        if (pieceToMove.getPiece().direction == Direction.NORTHNORTHEAST)
        {
            if (board[x_direction][y_direction].getPiece() != null && board[x_direction][y_direction].getPiece().colour == pieceToMove.getPiece().colour)
            {
                check = 0;
            }
        }
        else if (pieceToMove.getPiece().direction == Direction.NORTHEASTEAST)
        {
            if (board[x_direction][y_direction].getPiece() != null && board[x_direction][y_direction].getPiece().colour == pieceToMove.getPiece().colour)
            {
                check = 0;
            }
        }
        else if (pieceToMove.getPiece().direction == Direction.SOUTHEASTEAST)
        {
            if (board[x_direction][y_direction].getPiece() != null && board[x_direction][y_direction].getPiece().colour == pieceToMove.getPiece().colour)
            {
                check = 0;
            }
        }
        else if (pieceToMove.getPiece().direction == Direction.SOUTHSOUTHEAST)
        {
            if (board[x_direction][y_direction].getPiece() != null && board[x_direction][y_direction].getPiece().colour == pieceToMove.getPiece().colour)
            {
                check = 0;
            }
        }
        else if (pieceToMove.getPiece().direction == Direction.SOUTHSOUTHWEST)
        {
            if (board[x_direction][y_direction].getPiece() != null && board[x_direction][y_direction].getPiece().colour == pieceToMove.getPiece().colour)
            {
                check = 0;
            }
        }
        else if (pieceToMove.getPiece().direction == Direction.SOUTHWESTWEST)
        {
            if (board[x_direction][y_direction].getPiece() != null && board[x_direction][y_direction].getPiece().colour == pieceToMove.getPiece().colour)
            {
                check = 0;
            }
        }
        else if (pieceToMove.getPiece().direction == Direction.NORTHWESTWEST)
        {
            if (board[x_direction][y_direction].getPiece() != null && board[x_direction][y_direction].getPiece().colour == pieceToMove.getPiece().colour)
            {
                check = 0;
            }
        }
        else if (pieceToMove.getPiece().direction == Direction.NORTHNORTHWEST)
        {
            if (board[x_direction][y_direction].getPiece() != null && board[x_direction][y_direction].getPiece().colour == pieceToMove.getPiece().colour)
            {
                check = 0;
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

