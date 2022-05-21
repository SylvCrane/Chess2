package Model;

public class Pawn extends Piece{
    
    public Pawn(String pieceName, int potential_moves, PlayerColour colour)
    {
        super(pieceName);
        this.pieceName = pieceName;
        this.potential_moves = potential_moves;
        this.colour = colour;
        this.direction = Direction.STILL;
    }
    /*
    The following method will check if the move can be made. Mainly, it is checking if there is another piece in the position
    that the pawn now wants to move to. If there is, the pawn will not move to this position (In chess rules, the pawn
    cannot attack from the front).
    */
    @Override
    public int CheckMove(int x_direction, int y_direction, Square pieceToMove, Square[][] board)
    {
        int check = 0;
        
        if (pieceToMove.getPiece().colour == PlayerColour.WHITE)
        {
            if (board[x_direction][y_direction].getPiece() == null)
            {
                check = 1;
            }
        }
        else if (pieceToMove.getPiece().colour == PlayerColour.BLACK)
        {
            if (board[x_direction][y_direction].getPiece() == null)
            {
                check = 1;
            }
        }
   
        return check;
    }
    
    
    @Override
    public void MakeMove(int x_direction, int y_direction, Square pieceToMove, Square[][] board)
    {
        if (pieceToMove.getPiece().colour == PlayerColour.WHITE)
        {
            board[x_direction][y_direction].setPiece(pieceToMove.getPiece());
            board[pieceToMove.getX_location()][pieceToMove.getY_location()].setPiece(null); 
            
            //It is important that the original position is set to null as, otherwise, the board would be filled with duplicate pieces.
              
        }
        else if (pieceToMove.getPiece().colour == PlayerColour.BLACK)
        {
            board[x_direction][y_direction].setPiece(pieceToMove.getPiece());
            board[pieceToMove.getX_location()][pieceToMove.getY_location()].setPiece(null);
        }
        
        if (pieceToMove.getPiece().potential_moves == 2)
        {
            pieceToMove.getPiece().potential_moves -= 1;
        }
        
        //This is in the case that a pawn reaches the other end of the board. As is traditional in chess, it becomes a queen.
        if (pieceToMove.getPiece().colour == PlayerColour.WHITE)
        {
            if ((y_direction) == 7)
            {
                board[x_direction][y_direction].setPiece(new Queen("whiteQueen", 7, PlayerColour.WHITE));
            }
        }
        else if (pieceToMove.getPiece().colour == PlayerColour.BLACK)
        {
            if ((y_direction) == 0)
            {
                board[x_direction][y_direction].setPiece(new Queen("blackQueen", 7, PlayerColour.BLACK));
            }
        }
       
    }
}
