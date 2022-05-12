package chess2;

public class Pawn extends Piece{
    
    public Pawn(String pieceName, int potential_moves, Direction direction, PlayerColour colour)
    {
        super(pieceName);
        this.pieceName = pieceName;
        this.potential_moves = potential_moves;
        this.direction = direction;
        this.colour = colour;
    }
    /*
    The following method will check if the move can be made. Mainly, it is checking if there is another piece in the position
    that the pawn now wants to move to. If there is, the pawn will not move to this position (In chess rules, the pawn
    cannot attack from the front).
    */
    @Override
    public int CheckMove(Piece pawn, int x_direction, int y_direction, int potential_moves, Square[][] board)
    {
        int check = 0;
        
        if (pawn.colour == PlayerColour.WHITE)
        {
            if (pawn.direction == Direction.NORTH)
            {
                if ((board[x_direction][y_direction + potential_moves].getPiece() != null) &&(board[x_direction][y_direction + potential_moves].getPiece().colour == PlayerColour.WHITE))
                {
                    System.out.println("There is a piece at this position, you cannot move here");

                }
                else
                {
                    check = 1;
                }   
            }
            else if (pawn.direction == Direction.NORTHWEST)
            {
                if ((board[x_direction - potential_moves][y_direction + potential_moves].getPiece() != null) &&(board[x_direction - potential_moves][y_direction + potential_moves].getPiece().colour == PlayerColour.WHITE))
                {
                    System.out.println("There is a piece at this position, you cannot move here");

                }
                else
                {
                    check = 1;
                }
            }
            else if (pawn.direction == Direction.NORTHEAST)
            {
                if ((board[x_direction + potential_moves][y_direction + potential_moves].getPiece() != null) &&(board[x_direction+ potential_moves][y_direction + potential_moves].getPiece().colour == PlayerColour.WHITE))
                {
                    System.out.println("There is a piece at this position, you cannot move here");

                }
                else
                {
                    check = 1;
                } 
            }
        }
        else if (pawn.colour == PlayerColour.BLACK)
        {
            if (pawn.direction == Direction.SOUTH)
            {
                if ((board[x_direction][y_direction - potential_moves].getPiece() != null) &&(board[x_direction][y_direction - potential_moves].getPiece().colour == PlayerColour.BLACK))
                {
                    System.out.println("There is a piece at this position, you cannot move here");

                }
                else
                {
                    check = 1;
                }   
            }
            else if (pawn.direction == Direction.SOUTHWEST)
            {
                if ((board[x_direction - potential_moves][y_direction - potential_moves].getPiece() != null) &&(board[x_direction - potential_moves][y_direction + potential_moves].getPiece().colour == PlayerColour.BLACK))
                {
                    System.out.println("There is a piece at this position, you cannot move here");

                }
                else
                {
                    check = 1;
                }
            }
            else if (pawn.direction == Direction.SOUTHEAST)
            {
                if ((board[x_direction + potential_moves][y_direction - potential_moves].getPiece() != null) &&(board[x_direction + potential_moves][y_direction - potential_moves].getPiece().colour == PlayerColour.BLACK))
                {
                    System.out.println("There is a piece at this position, you cannot move here");

                }
                else
                {
                    check = 1;
                } 
            }
        }
        
        
        return check;
    }
    
    
    @Override
    public void MakeMove(Piece pawn, int x_direction, int y_direction, int potential_moves, Square[][] board)
    {
        if (pawn.colour == PlayerColour.WHITE)
        {
            board[x_direction][y_direction + potential_moves].setPiece(pawn);
            board[x_direction][y_direction].setPiece(null); 
            
            //It is important that the original position is set to null as, otherwise, the board would be filled with duplicate pieces.
              
        }
        else if (pawn.colour == PlayerColour.BLACK)
        {
            board[x_direction][y_direction - potential_moves].setPiece(pawn);
            board[x_direction][y_direction].setPiece(null); 
        }
        
        if (pawn.potential_moves == 2)
        {
            pawn.potential_moves -= 1;
        }
        
        //This is in the case that a pawn reaches the other end of the board. As is traditional in chess, it becomes a queen.
        if (pawn.colour == PlayerColour.WHITE)
        {
            if ((y_direction + potential_moves) == 7)
            {
                board[x_direction][y_direction + potential_moves].setPiece(new Queen("whiteQueen", 7, Direction.STILL, PlayerColour.WHITE));
            }
        }
        else if (pawn.colour == PlayerColour.BLACK)
        {
            if ((y_direction - potential_moves) == 0)
            {
                board[x_direction][y_direction - potential_moves].setPiece(new Queen("blackQueen", 7, Direction.STILL, PlayerColour.BLACK));
            }
        }
       
    }
}
