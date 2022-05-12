/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess2;

/**
 *
 * @author navjo
 */
public class Knight extends Piece{
    
    public Knight(String pieceName, int potential_moves, Direction direction, PlayerColour colour)
    {
        super(pieceName);
        this.pieceName = pieceName;
        this.potential_moves = potential_moves;
        this.direction = direction;
        this.colour = colour;
    }
    
    @Override
    public int CheckMove(Piece piece, int x_direction, int y_direction, int potential_moves, Square[][] board) 
    {
        int check = 1;
        
        /**
         * Because of the knight's special moving situation, wherein it moves in an L-Shape straight to its
         * destination, it only needs to check its destination and none of the spots between.
         */
        
       if (piece.direction == Direction.NORTHNORTHEAST)
       {
           if (board[x_direction + 1][y_direction + 2].getPiece() != null && board[x_direction + 1][y_direction + 2].getPiece().colour == piece.colour)
           {
               System.out.println("The knight cannot move here");
               check = 0;
           }
       }
       else if (piece.direction == Direction.NORTHEASTEAST)
       {
           if (board[x_direction + 2][y_direction + 1].getPiece() != null && board[x_direction + 2][y_direction + 1].getPiece().colour == piece.colour)
           {
               System.out.println("The knight cannot move here");
               check = 0;
           }
       }
       else if (piece.direction == Direction.SOUTHEASTEAST)
       {
           if (board[x_direction + 2][y_direction - 1].getPiece() != null && board[x_direction + 2][y_direction - 1].getPiece().colour == piece.colour)
           {
               System.out.println("The knight cannot move here");
               check = 0;
           }
       }
       else if (piece.direction == Direction.SOUTHSOUTHEAST)
       {
           if (board[x_direction + 1][y_direction - 2].getPiece() != null && board[x_direction + 1][y_direction - 2].getPiece().colour == piece.colour)
           {
               System.out.println("The knight cannot move here");
               check = 0;
           }
       }
       else if (piece.direction == Direction.SOUTHSOUTHWEST)
       {
           if (board[x_direction - 1][y_direction - 2].getPiece() != null && board[x_direction - 1][y_direction - 2].getPiece().colour == piece.colour)
           {
               System.out.println("The knight cannot move here");
               check = 0;
           }
       }
       else if (piece.direction == Direction.SOUTHWESTWEST)
       {
           if (board[x_direction - 2][y_direction - 1].getPiece() != null && board[x_direction - 2][y_direction - 1].getPiece().colour == piece.colour)
           {
               System.out.println("The knight cannot move here");
               check = 0;
           }
       }
       else if (piece.direction == Direction.NORTHWESTWEST)
       {
           if (board[x_direction - 2][y_direction + 1].getPiece() != null && board[x_direction - 2][y_direction + 1].getPiece().colour == piece.colour)
           {
               System.out.println("The knight cannot move here");
               check = 0;
           }
       }
       else if (piece.direction == Direction.SOUTHWESTWEST)
       {
           if (board[x_direction - 1][y_direction + 2].getPiece() != null && board[x_direction - 1][y_direction + 2].getPiece().colour == piece.colour)
           {
               System.out.println("The knight cannot move here");
               check = 0;
           }
       }
       
       return check;
    }

    @Override
    public void MakeMove(Piece piece, int x_direction, int y_direction, int potential_moves, Square[][] board) 
    { 
        if (piece.direction == direction.NORTHNORTHEAST)
        {
            board[x_direction + 1][y_direction + 2].setPiece(piece);
        }
        else if (piece.direction == direction.NORTHEASTEAST)
        {
            board[x_direction + 2][y_direction + 1].setPiece(piece);
        }
        else if (piece.direction == direction.SOUTHEASTEAST)
        {
            board[x_direction + 2][y_direction - 1].setPiece(piece);
        }
        else if (piece.direction == direction.SOUTHSOUTHEAST)
        {
            board[x_direction + 1][y_direction - 2].setPiece(piece);
        }
        else if (piece.direction == direction.SOUTHSOUTHWEST)
        {
            board[x_direction - 1][y_direction - 2].setPiece(piece);
        }
        else if (piece.direction == direction.SOUTHWESTWEST)
        {
            board[x_direction - 2][y_direction - 1].setPiece(piece);
        }
        else if (piece.direction == direction.NORTHWESTWEST)
        {
            board[x_direction - 2][y_direction + 1].setPiece(piece);
        }
        else if (piece.direction == direction.NORTHNORTHWEST)
        {
            board[x_direction - 1][y_direction + 2].setPiece(piece);
        }
        
        board[x_direction][y_direction].setPiece(null);
        
    }
     
}

