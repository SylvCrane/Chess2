/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author navjo
 */
public class KillandTakePieces {
    
    //This class involves the individual killing and taking of pieces depending on the piece
    
    private int xDirection;
    private int yDirection;
    
    public KillandTakePieces(int x, int y)
    {
        this.xDirection = x;
        this.yDirection = y;
    }
    
    
    /**
     * This method involves if the current piece, a pawn, is capable of attacking, done by detecting if there is an opposing piece in each diagonal direction.
     * 
     * @param board
     * @param pieceToMove
     * @param deadPieceStore
     * @return 
     */
    public boolean killAndTakePawn(Square[][] board, Square pieceToMove, Square deadPieceStore)
    {
        boolean opposingFound = false;
        
        if (pieceToMove.getPiece().colour.equals(PlayerColour.WHITE))
        {
            if (pieceToMove.getPiece().direction == Direction.NORTHWEST)
            {
                deadPieceStore.setX_location(pieceToMove.getX_location() - 1);
                deadPieceStore.setY_location(pieceToMove.getY_location() + 1);
                deadPieceStore.setPiece(board[this.xDirection][this.xDirection].getPiece());
                board[this.xDirection][this.yDirection].setPiece(pieceToMove.getPiece());
                board[pieceToMove.getX_location()][pieceToMove.getY_location()].setPiece(null);
                opposingFound = true;
            }
            else if (pieceToMove.getPiece().direction == Direction.NORTHEAST)
            {
                deadPieceStore.setX_location(pieceToMove.getX_location() + 1);
                deadPieceStore.setY_location(pieceToMove.getY_location() + 1);
                deadPieceStore.setPiece(board[this.xDirection][this.yDirection].getPiece());
                board[this.xDirection][this.yDirection].setPiece(pieceToMove.getPiece());
                board[pieceToMove.getX_location()][pieceToMove.getY_location()].setPiece(null);
                opposingFound = true;
            }
        }
        else if (pieceToMove.getPiece().colour.equals(PlayerColour.BLACK))
        {
            if (pieceToMove.getPiece().direction == Direction.SOUTHWEST)
            {
                deadPieceStore.setX_location(pieceToMove.getX_location() - 1);
                deadPieceStore.setY_location(pieceToMove.getY_location() - 1);
                deadPieceStore.setPiece(board[this.xDirection][this.yDirection].getPiece());
                board[this.xDirection][this.yDirection].setPiece(pieceToMove.getPiece());
                board[pieceToMove.getX_location()][pieceToMove.getY_location()].setPiece(null);
                opposingFound = true;
            }
            else if (pieceToMove.getPiece().direction == Direction.SOUTHEAST)
            {
                deadPieceStore.setX_location(pieceToMove.getX_location() + 1);
                deadPieceStore.setY_location(pieceToMove.getY_location() - 1);
                deadPieceStore.setPiece(board[this.xDirection][this.yDirection].getPiece());
                board[this.xDirection][this.yDirection].setPiece(pieceToMove.getPiece());
                board[pieceToMove.getX_location()][pieceToMove.getY_location()].setPiece(null);
                opposingFound = true;
            }
        }
    
        return opposingFound;
    }
    
    
    
    /**
     * The following method is used in the case of the current piece, a rook, wanting to attack the opposing piece in its destination. To do this, it checks each position up to but not including the destination piece.
     * 
     * @param board
     * @param pieceToMove
     * @param deadPieceStore
     * @return 
     */
    public boolean killAndTakeRook(Square[][] board, Square pieceToMove, Square deadPieceStore)
    {
        boolean opposingFound = false;
        
        if (pieceToMove.getPiece().direction == Direction.NORTH)
        {
            int moveChecker = pieceToMove.getPiece().CheckMove(this.xDirection, this.yDirection - 1, pieceToMove, board);

            if (moveChecker == 1)
            {
                deadPieceStore.setX_location(this.xDirection);
                deadPieceStore.setY_location(this.yDirection);
                deadPieceStore.setPiece(board[this.xDirection][this.yDirection].getPiece());
                board[this.xDirection][this.yDirection].setPiece(pieceToMove.getPiece());
                board[pieceToMove.getX_location()][pieceToMove.getY_location()].setPiece(null);
                opposingFound = true;
            }
        }
        else if (pieceToMove.getPiece().direction == Direction.EAST)
        {
            int moveChecker = pieceToMove.getPiece().CheckMove(this.xDirection - 1, this.yDirection, pieceToMove, board);

            if (moveChecker == 1)
            {
                deadPieceStore.setX_location(this.xDirection);
                deadPieceStore.setY_location(this.yDirection);
                deadPieceStore.setPiece(board[this.xDirection][this.yDirection].getPiece());
                board[this.xDirection][this.yDirection].setPiece(pieceToMove.getPiece());
                board[pieceToMove.getX_location()][pieceToMove.getY_location()].setPiece(null);
                opposingFound = true;
            }
        }
        else if (pieceToMove.getPiece().direction == Direction.WEST)
        {
            int moveChecker = pieceToMove.getPiece().CheckMove(this.xDirection + 1, this.yDirection - 1, pieceToMove, board);

            if (moveChecker == 1)
            {
                deadPieceStore.setX_location(this.xDirection);
                deadPieceStore.setY_location(this.yDirection);
                deadPieceStore.setPiece(board[this.xDirection][this.yDirection].getPiece());
                board[this.xDirection][this.yDirection].setPiece(pieceToMove.getPiece());
                board[pieceToMove.getX_location()][pieceToMove.getY_location()].setPiece(null);
                opposingFound = true;
            }
        }
        else if (pieceToMove.getPiece().direction == Direction.SOUTH)
        {
            int moveChecker = pieceToMove.getPiece().CheckMove(this.xDirection, this.yDirection + 1, pieceToMove, board);

            if (moveChecker == 1)
            {
                deadPieceStore.setX_location(this.xDirection);
                deadPieceStore.setY_location(this.yDirection);
                deadPieceStore.setPiece(board[this.xDirection][this.yDirection].getPiece());
                board[this.xDirection][this.yDirection].setPiece(pieceToMove.getPiece());
                board[pieceToMove.getX_location()][pieceToMove.getY_location()].setPiece(null);
                opposingFound = true;
            }
        }
        
        return opposingFound;
    }
    
    //Because the following methods identify killing and taking but for subsequent pieces, it is redundant to repeat information.
    //However, in the case of both the knight and the king, these check the destination itself to find an opposing piece. 
    
    public boolean killAndTakeBishop(Square[][] board, Square pieceToMove, Square deadPieceStore)
    {
        boolean opposingFound = false;
        
        if (pieceToMove.getPiece().direction == Direction.NORTHEAST)
        {
            int moveChecker = pieceToMove.getPiece().CheckMove(this.xDirection - 1, this.yDirection - 1, pieceToMove, board);

            if (moveChecker == 1)
            {
                deadPieceStore.setX_location(this.xDirection);
                deadPieceStore.setY_location(this.yDirection);
                deadPieceStore.setPiece(board[this.xDirection][this.yDirection].getPiece());
                board[this.xDirection][this.yDirection].setPiece(pieceToMove.getPiece());
                board[pieceToMove.getX_location()][pieceToMove.getY_location()].setPiece(null);
                opposingFound = true;
            }
        }
        else if (pieceToMove.getPiece().direction == Direction.SOUTHEAST)
        {
            int moveChecker = pieceToMove.getPiece().CheckMove(this.xDirection - 1, this.yDirection + 1, pieceToMove, board);

            if (moveChecker == 1)
            {
                deadPieceStore.setX_location(this.xDirection);
                deadPieceStore.setY_location(this.yDirection);
                deadPieceStore.setPiece(board[this.xDirection][this.yDirection].getPiece());
                board[this.xDirection][this.yDirection].setPiece(pieceToMove.getPiece());
                board[pieceToMove.getX_location()][pieceToMove.getY_location()].setPiece(null);
                opposingFound = true;
            }
        }
        else if (pieceToMove.getPiece().direction == Direction.SOUTHWEST)
        {
            int moveChecker = pieceToMove.getPiece().CheckMove(this.xDirection + 1, this.yDirection + 1, pieceToMove, board);

            if (moveChecker == 1)
            {
                deadPieceStore.setX_location(this.xDirection);
                deadPieceStore.setY_location(this.yDirection);
                deadPieceStore.setPiece(board[this.xDirection][this.yDirection].getPiece());
                board[this.xDirection][this.yDirection].setPiece(pieceToMove.getPiece());
                board[pieceToMove.getX_location()][pieceToMove.getY_location()].setPiece(null);
                opposingFound = true;
            }
        }
        else if (pieceToMove.getPiece().direction == Direction.NORTHWEST)
        {
            int moveChecker = pieceToMove.getPiece().CheckMove(this.xDirection + 1, this.yDirection - 1, pieceToMove, board);

            if (moveChecker == 1)
            {
                deadPieceStore.setX_location(this.xDirection);
                deadPieceStore.setY_location(this.yDirection);
                deadPieceStore.setPiece(board[this.xDirection][this.yDirection].getPiece());
                board[this.xDirection][this.yDirection].setPiece(pieceToMove.getPiece());
                board[pieceToMove.getX_location()][pieceToMove.getY_location()].setPiece(null);
                opposingFound = true;
            }
        }
        
        return opposingFound;
    }
    
    public boolean killAndTakeKnight(Square[][] board, Square pieceToMove, Square deadPieceStore)
    {
        boolean opposingFound = false;
        
        int moveChecker = pieceToMove.getPiece().CheckMove(this.xDirection + 1, this.yDirection - 1, pieceToMove, board);
        
        if (moveChecker == 1)
        {
            deadPieceStore.setX_location(this.xDirection);
            deadPieceStore.setY_location(this.yDirection);
            deadPieceStore.setPiece(board[this.xDirection][this.yDirection].getPiece());
            board[this.xDirection][this.yDirection].setPiece(pieceToMove.getPiece());
            board[pieceToMove.getX_location()][pieceToMove.getY_location()].setPiece(null);
            opposingFound = true;
        }
        
        return opposingFound;
    }
    
    public boolean killAndTakeQueen(Square[][] board, Square pieceToMove, Square deadPieceStore)
    {
           boolean opposingFound = false;
        
        if (pieceToMove.getPiece().direction == Direction.NORTHEAST)
        {
            int moveChecker = pieceToMove.getPiece().CheckMove(this.xDirection - 1, this.yDirection - 1, pieceToMove, board);

            if (moveChecker == 1)
            {
                deadPieceStore.setX_location(this.xDirection);
                deadPieceStore.setY_location(this.yDirection);
                deadPieceStore.setPiece(board[this.xDirection][this.yDirection].getPiece());
                board[this.xDirection][this.yDirection].setPiece(pieceToMove.getPiece());
                board[pieceToMove.getX_location()][pieceToMove.getY_location()].setPiece(null);
                opposingFound = true;
            }
        }
        else if (pieceToMove.getPiece().direction == Direction.SOUTHEAST)
        {
            int moveChecker = pieceToMove.getPiece().CheckMove(this.xDirection - 1, this.yDirection + 1, pieceToMove, board);

            if (moveChecker == 1)
            {
                deadPieceStore.setX_location(this.xDirection);
                deadPieceStore.setY_location(this.yDirection);
                deadPieceStore.setPiece(board[this.xDirection][this.yDirection].getPiece());
                board[this.xDirection][this.yDirection].setPiece(pieceToMove.getPiece());
                board[pieceToMove.getX_location()][pieceToMove.getY_location()].setPiece(null);
                opposingFound = true;
            }
        }
        else if (pieceToMove.getPiece().direction == Direction.SOUTHWEST)
        {
            int moveChecker = pieceToMove.getPiece().CheckMove(this.xDirection + 1, this.yDirection + 1, pieceToMove, board);

            if (moveChecker == 1)
            {
                deadPieceStore.setX_location(this.xDirection);
                deadPieceStore.setY_location(this.yDirection);
                deadPieceStore.setPiece(board[this.xDirection][this.yDirection].getPiece());
                board[this.xDirection][this.yDirection].setPiece(pieceToMove.getPiece());
                board[pieceToMove.getX_location()][pieceToMove.getY_location()].setPiece(null);
                opposingFound = true;
            }
        }
        else if (pieceToMove.getPiece().direction == Direction.NORTHWEST)
        {
            int moveChecker = pieceToMove.getPiece().CheckMove(this.xDirection + 1, this.yDirection - 1, pieceToMove, board);

            if (moveChecker == 1)
            {
                deadPieceStore.setX_location(this.xDirection);
                deadPieceStore.setY_location(this.yDirection);
                deadPieceStore.setPiece(board[this.xDirection][this.yDirection].getPiece());
                board[this.xDirection][this.yDirection].setPiece(pieceToMove.getPiece());
                board[pieceToMove.getX_location()][pieceToMove.getY_location()].setPiece(null);
                opposingFound = true;
            }
        }
        else if (pieceToMove.getPiece().direction == Direction.NORTH)
        {
            int moveChecker = pieceToMove.getPiece().CheckMove(this.xDirection, this.yDirection - 1, pieceToMove, board);

            if (moveChecker == 1)
            {
                deadPieceStore.setX_location(this.xDirection);
                deadPieceStore.setY_location(this.yDirection);
                deadPieceStore.setPiece(board[this.xDirection][this.yDirection].getPiece());
                board[this.xDirection][this.yDirection].setPiece(pieceToMove.getPiece());
                board[pieceToMove.getX_location()][pieceToMove.getY_location()].setPiece(null);
                opposingFound = true;
            }
        }
        else if (pieceToMove.getPiece().direction == Direction.EAST)
        {
            int moveChecker = pieceToMove.getPiece().CheckMove(this.xDirection - 1, this.yDirection, pieceToMove, board);

            if (moveChecker == 1)
            {
                deadPieceStore.setX_location(this.xDirection);
                deadPieceStore.setY_location(this.yDirection);
                deadPieceStore.setPiece(board[this.xDirection][this.yDirection].getPiece());
                board[this.xDirection][this.yDirection].setPiece(pieceToMove.getPiece());
                board[pieceToMove.getX_location()][pieceToMove.getY_location()].setPiece(null);
                opposingFound = true;
            }
        }
        else if (pieceToMove.getPiece().direction == Direction.WEST)
        {
            int moveChecker = pieceToMove.getPiece().CheckMove(this.xDirection + 1, this.yDirection - 1, pieceToMove, board);

            if (moveChecker == 1)
            {
                deadPieceStore.setX_location(this.xDirection);
                deadPieceStore.setY_location(this.yDirection);
                deadPieceStore.setPiece(board[this.xDirection][this.yDirection].getPiece());
                board[this.xDirection][this.yDirection].setPiece(pieceToMove.getPiece());
                board[pieceToMove.getX_location()][pieceToMove.getY_location()].setPiece(null);
                opposingFound = true;
            }
        }
        else if (pieceToMove.getPiece().direction == Direction.SOUTH)
        {
            int moveChecker = pieceToMove.getPiece().CheckMove(this.xDirection, this.yDirection + 1, pieceToMove, board);

            if (moveChecker == 1)
            {
                deadPieceStore.setX_location(this.xDirection);
                deadPieceStore.setY_location(this.yDirection);
                deadPieceStore.setPiece(board[this.xDirection][this.yDirection].getPiece());
                board[this.xDirection][this.yDirection].setPiece(pieceToMove.getPiece());
                board[pieceToMove.getX_location()][pieceToMove.getY_location()].setPiece(null);
                opposingFound = true;
            }
        }
        
        return opposingFound;     
    }
    
    
    //A noteworthy observation to make with the king is that it cannot take the opposing player's king as this would prevent the ame from being won.
    public boolean killAndTakeKing(Square[][] board, Square pieceToMove, Square deadPieceStore)
    {
        boolean opposingFound = false;
        int moveChecker = pieceToMove.getPiece().CheckMove(this.xDirection, this.yDirection + 1, pieceToMove, board);
        
        if (moveChecker == 1)
        {
            deadPieceStore.setX_location(this.xDirection);
            deadPieceStore.setY_location(this.yDirection);
            deadPieceStore.setPiece(board[this.xDirection][this.yDirection].getPiece());
            board[this.xDirection][this.yDirection].setPiece(pieceToMove.getPiece());
            board[pieceToMove.getX_location()][pieceToMove.getY_location()].setPiece(null);
            opposingFound = true;
        }
        
        return opposingFound;
    }
    
    
    
    
    
}
