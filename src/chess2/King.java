/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess2;

/**
 *
 * @author navjo
 */
public class King extends Piece{
    
    public King(String pieceName, int potential_moves, Direction direction, PlayerColour colour)
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
        
       if (piece.direction == Direction.NORTH)
       {
            if (board[x_direction][y_direction + 1].getPiece() != null && board[x_direction][y_direction + 1].getPiece().colour == piece.colour)
               {
                   System.out.println("You cannot move the king here");
                   check = 0;
               }
           
       }
       if (piece.direction == Direction.NORTHEAST)
       {
           if (board[x_direction + 1][y_direction + 1].getPiece() != null && board[x_direction + 1][y_direction + 1].getPiece().colour == piece.colour)
               {
                   System.out.println("You cannot move the king here");
                   check = 0;
               }
       }
       if (piece.direction == Direction.EAST)
       {
           if (potential_moves == 3)
           {
               //Do nothing as, at this point, the king can castle and this input is appropriate.
           }
           else if (board[x_direction + 1][y_direction].getPiece() != null && board[x_direction + 1][y_direction].getPiece().colour == piece.colour)
               {
                   System.out.println("You cannot move the king here");
                   check = 0;
               }
       }
       if (piece.direction == Direction.SOUTHEAST)
       {
           if (board[x_direction + 1][y_direction - 1].getPiece() != null && board[x_direction + 1][y_direction - 1].getPiece().colour == piece.colour)
               {
                   System.out.println("You cannot move the king here");
                   check = 0;
               }
       }
       if (piece.direction == Direction.SOUTH)
       {
           if (board[x_direction][y_direction - 1].getPiece() != null && board[x_direction][y_direction - 1].getPiece().colour == piece.colour)
               {
                   System.out.println("You cannot move the king here");
                   check = 0;
               }
       }
       if (piece.direction == Direction.SOUTHWEST)
       {
          if (board[x_direction - 1][y_direction - 1].getPiece() != null && board[x_direction - 1][y_direction - 1].getPiece().colour == piece.colour)
               {
                   System.out.println("You cannot move the king here");
                   check = 0;
               }
       }
       if (piece.direction == Direction.WEST)
       {
           if (potential_moves == 2)
           {
               //Do nothing as, at this point, the king can castle and this input is appropriate.
           }
           else if (board[x_direction - 1][y_direction].getPiece() != null && board[x_direction - 1][y_direction].getPiece().colour == piece.colour)
            {
                System.out.println("You cannot move the king here");
                check = 0;
            }
       }
       if (piece.direction == Direction.NORTHWEST)
       {
            if (board[x_direction - 1][y_direction + 1].getPiece() != null && board[x_direction - 1][y_direction + 1].getPiece().colour == piece.colour)
             {
                 System.out.println("You cannot move the king here");
                 check = 0;
             }
       }
       
       
       
       return check;
    }

    @Override
    public void MakeMove(Piece piece, int x_direction, int y_direction, int potential_moves, Square[][] board) 
    {
         if (piece.direction == Direction.NORTH)
        {
            board[x_direction][y_direction + potential_moves].setPiece(piece);
        }
        else if (piece.direction == Direction.NORTHEAST)
        {
            board[x_direction + potential_moves][y_direction + potential_moves].setPiece(piece);
        }
        else if (piece.direction == Direction.EAST)
        {
            if (potential_moves == 3)
            {
                castlingMove kingCastle = new castlingMove(board[x_direction][y_direction].getPiece(), x_direction, y_direction);
                kingCastle.castleKing(piece, x_direction, y_direction, potential_moves, board);
                
                //This situation only occurs if the castling input is registered, which is in turn only registered if
                //the player had the potential to castle. 
            }
            else
            {
                board[x_direction + potential_moves][y_direction].setPiece(piece);
            }
        }
        else if (piece.direction == Direction.SOUTHEAST)
        {
            board[x_direction + potential_moves][y_direction - potential_moves].setPiece(piece);
        }
        else if (piece.direction == Direction.SOUTH)
        {
            board[x_direction][y_direction - potential_moves].setPiece(piece);
        }
        else if (piece.direction == Direction.SOUTHWEST)
        {
            board[x_direction - potential_moves][y_direction - potential_moves].setPiece(piece);
        }
        else if (piece.direction == Direction.WEST)
        {
            if (potential_moves == 2)
            {
                castlingMove kingCastle = new castlingMove(board[x_direction][y_direction].getPiece(), x_direction, y_direction);
                kingCastle.castleKing(piece, x_direction, y_direction, potential_moves, board);
                
                //This situation only occurs if the castling input is registered, which is in turn only registered if
                //the player had the potential to castle. 
            }
            
            board[x_direction - potential_moves][y_direction].setPiece(piece);
        }
        else if (piece.direction == Direction.NORTHWEST)
        {
            board[x_direction - potential_moves][y_direction + potential_moves].setPiece(piece);
        }
        
        board[x_direction][y_direction].setPiece(null);
       
    }
     
}
