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
    
    public Rook(String pieceName, int potential_moves, Direction direction, PlayerColour colour)
    {
        super(pieceName);
        this.pieceName = pieceName;
        this.potential_moves = potential_moves;
        this.direction = direction;
        this.colour = colour;
    }
    

    @Override
    public int CheckMove(Piece piece, int x_direction, int y_direction, int potential_moves, Square[][] board) {
       
        int check = 1;
        if (piece.direction == Direction.EAST)
        {
            for (int i = 1; i < potential_moves + 1; i++)
            {
                if (board[x_direction + i][y_direction].getPiece() != null && board[x_direction + i][y_direction].getPiece().colour == piece.colour)
                {
                    System.out.println("There is another piece here");
                    check = 0;
                    break;
                }
            }
        }
        
        if (piece.direction == Direction.WEST)
        {
            for (int i = 1; i < potential_moves + 1; i++)
            {
                if (board[x_direction - i][y_direction].getPiece() != null && board[x_direction - i][y_direction].getPiece().colour == piece.colour)
                {
                    System.out.println("There is another piece here");
                    check = 0;
                    break;
                }
            }
        }
        
        if (piece.direction == Direction.SOUTH)
        {
            for (int i = 1; i < potential_moves + 1; i++)
            {
                if (board[x_direction][y_direction - i].getPiece() != null && board[x_direction][y_direction - i].getPiece().colour == piece.colour)
                {
                    System.out.println("There is another piece here");
                    check = 0;
                    break;
                }
            }
        }
        
        if (piece.direction == Direction.NORTH)
        {
            for (int i = 1; i < potential_moves + 1; i++)
            {
                if (board[x_direction][y_direction + i].getPiece() != null && board[x_direction][y_direction + i].getPiece().colour == piece.colour)
                {
                    System.out.println("There is another piece here");
                    check = 0;
                    break;
                }
            }
        }
        
        return check;
    }

    @Override
    public void MakeMove(Piece piece, int x_direction, int y_direction, int potential_moves, Square[][] board) {
        
        if (piece.direction == Direction.EAST)
        {
            board[x_direction + potential_moves][y_direction].setPiece(piece); 
        }
        else if(piece.direction == Direction.WEST)
        {
            board[x_direction - potential_moves][y_direction].setPiece(piece);
        }
        else if(piece.direction == Direction.SOUTH)
        {
            board[x_direction][y_direction - potential_moves].setPiece(piece); 
        }
        else if(piece.direction == Direction.NORTH)
        {
            board[x_direction][y_direction + potential_moves].setPiece(piece); 
        }
        
        board[x_direction][y_direction].setPiece(null);
    }
}
