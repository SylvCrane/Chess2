/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess2;

/**
 *
 * @author navjo
 */
public class Bishop extends Piece{
    
    public Bishop(String pieceName, int potential_moves, Direction direction, PlayerColour colour)
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
        
        //For loops are used to iterate between the original position of the bishop and its desired location.
        if (piece.direction == Direction.NORTHEAST)
        {
            for (int i = 1; i < potential_moves; i++)
            {
                if (board[x_direction + i][y_direction + i].getPiece() != null && board[x_direction + i][y_direction + i].getPiece().colour == piece.colour)
                {
                    System.out.println("The bishop cannot move here");
                    check = 0;
                    break;
                }
            }
        }
        
        if (piece.direction == Direction.SOUTHEAST)
        {
            for (int i = 1; i < potential_moves; i++)
            {
                if (board[x_direction + i][y_direction - i].getPiece() != null && board[x_direction + i][y_direction - i].getPiece().colour == piece.colour)
                {
                    System.out.println("The bishop cannot move here");
                    check = 0;
                    break;
                }
            }
        }
        
        if (piece.direction == Direction.SOUTHWEST)
        {
            for (int i = 1; i < potential_moves; i++)
            {
                if (board[x_direction - i][y_direction - i].getPiece() != null && board[x_direction - i][y_direction - i].getPiece().colour == piece.colour)
                {
                    System.out.println("The bishop cannot move here");
                    check = 0;
                    break;
                }
            }
        }
        
        if (piece.direction == Direction.NORTHWEST)
        {
            for (int i = 1; i < potential_moves; i++)
            {
                if (board[x_direction - i][y_direction + i].getPiece() != null && board[x_direction - i][y_direction + i].getPiece().colour == piece.colour)
                {
                    System.out.println("The bishop cannot move here");
                    check = 0;
                    break;
                }
            }
        }
        
        return check;
    }

    @Override
    public void MakeMove(Piece piece, int x_direction, int y_direction, int potential_moves, Square[][] board) 
    {
       if (piece.direction == direction.NORTHEAST)
       {
           board[x_direction + potential_moves][y_direction + potential_moves].setPiece(piece);
       }
       else if (piece.direction == direction.SOUTHEAST)
       {
           board[x_direction + potential_moves][y_direction - potential_moves].setPiece(piece);
       }
       else if (piece.direction == direction.SOUTHWEST)
       {
           board[x_direction - potential_moves][y_direction - potential_moves].setPiece(piece);
       }
       else if (piece.direction == direction.NORTHWEST)
       {
           board[x_direction - potential_moves][y_direction + potential_moves].setPiece(piece);
       }
       
       board[x_direction][y_direction].setPiece(null);
    }
     
}
