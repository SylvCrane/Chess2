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
    The following method will check if the move can be made. It does not check if there is an opposing piece as this was already done.
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
            int xOrigin = pieceToMove.getX_location();
            int yOrigin = pieceToMove.getY_location();
        
            board[x_direction][y_direction].setPiece(pieceToMove.getPiece());
            board[xOrigin][yOrigin].setPiece(null);
            
            //It is important that the original position is set to null as, otherwise, the board would be filled with duplicate pieces.
              
        }
        else if (pieceToMove.getPiece().colour == PlayerColour.BLACK)
        {
            int xOrigin = pieceToMove.getX_location();
            int yOrigin = pieceToMove.getY_location();
        
            board[x_direction][y_direction].setPiece(pieceToMove.getPiece());
            board[xOrigin][yOrigin].setPiece(null);
        }
        
        if (board[x_direction][y_direction].getPiece().potential_moves == 2)
        {
            board[x_direction][y_direction].getPiece().potential_moves -= 1;
        }
        
        //This is in the case that a pawn reaches the other end of the board. As is traditional in chess, it becomes a queen.
        if (board[x_direction][y_direction].getPiece().colour == PlayerColour.WHITE)
        {
            if ((y_direction) == 7)
            {
                board[x_direction][y_direction].setPiece(new Queen("whiteQueen", 7, PlayerColour.WHITE));
            }
        }
        else if (board[x_direction][y_direction].getPiece().colour == PlayerColour.BLACK)
        {
            if ((y_direction) == 0)
            {
                board[x_direction][y_direction].setPiece(new Queen("blackQueen", 7, PlayerColour.BLACK));
            }
        }  
    }
}
