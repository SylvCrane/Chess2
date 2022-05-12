/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess2;

/**
 * This is used for the unique scenario wherein a king can move to be protected by its rook, given that there are no pieces between.
 *
 * @author navjo
 */
public class castlingMove {
    
    private Piece king;
    private int x_direction;
    private int y_direction;
    
    public castlingMove(Piece king, int x_direction, int y_direction)
    {
        this.king = king;
        this.x_direction = x_direction;
        this.y_direction = y_direction;
    }
    
    /**
     * This checks if the king can castle to either the left or right.
     * 
     * @param king
     * @param x_direction
     * @param y_direction
     * @param board
     * @return 
     */
    public int checkforCastling(Piece king, int x_direction, int y_direction, Square[][] board)
    {
        int canCastle = 0;
        this.setKing(king);
        this.setX_direction(x_direction);
        this.setY_direction(y_direction);
        
        boolean castleToTheLeft = false;
        boolean castleToTheRight = false;
        
        
        if (this.getKing().colour == PlayerColour.WHITE)
        {
            //This checks to the left of the king
            if (board[4][0].getPiece() != null)
            {
                if (board[4][0].getPiece().equals(this.getKing()))
                {
                    if (board[0][0].getPiece() != null)
                    {
                        if (board[0][0].getPiece().pieceName.equals("whiteRook1"))
                        {
                            if (board[1][0].getPiece() == null && board[2][0].getPiece() == null && board[3][0].getPiece() == null)
                            {
                                castleToTheLeft = true;
                            }
                        }
                    }
                    
                } 
            }   
            
            //This checks to the right of the king
            if (board[4][0].getPiece() != null)
            {
                if (board[4][0].getPiece().equals(this.getKing()))
                {
                    if (board[7][0].getPiece() != null)
                    {
                        if (board[7][0].getPiece().pieceName.equals("whiteRook2"))
                        {
                            if (board[6][0].getPiece() == null && board[5][0].getPiece() == null)
                            {
                                castleToTheRight = true;
                            }
                        }
                    } 
                } 
            }
        }
        else if (this.getKing().colour == PlayerColour.BLACK)
        {
            if (board[4][7].getPiece() != null)
            {
                if (board[4][7].getPiece().equals(this.getKing()))
                {
                    if (board[0][7].getPiece() != null)
                    {
                        if (board[0][7].getPiece().pieceName.equals("blackRook1"))
                        {
                            if (board[1][7].getPiece() == null && board[2][7].getPiece() == null && board[3][7].getPiece() == null)
                            {
                                castleToTheLeft = true;
                            }
                        }
                    }
                }
            }
            
            if (board[4][7].getPiece() != null)
            {
                if (board[4][7].getPiece().equals(this.getKing()))
                {
                    if (board[7][7].getPiece() != null)
                    {
                        if (board[7][7].getPiece().pieceName.equals("blackRook2"))
                        {
                            if (board[6][7].getPiece() == null && board[5][7].getPiece() == null)
                            {
                                castleToTheRight = true;
                            }
                        }
                    }
                }
            }
        }
        
        if (castleToTheLeft)
        {
            if (castleToTheRight)
            {
                //This is in the situation that the king can be castled to the left AND right.
                canCastle = 3;
            }
            else
            {
                canCastle = 1;
            }
        }
        else if (castleToTheRight)
        {
            canCastle = 2;
        }
        
        return canCastle;
    }
    
    /**
     * This castles the king, in the case that the castle can be done. The method is only called if this is the case.
     * 
     * @param king
     * @param x_direction
     * @param y_direction
     * @param castleInput
     * @param board 
     */
    public void castleKing(Piece king, int x_direction, int y_direction, int castleInput, Square[][] board)
    {
        this.setKing(king);
        this.setX_direction(x_direction);
        this.setY_direction(y_direction);
        
        if (this.getKing().colour == PlayerColour.WHITE)
        {
            if (castleInput == 2)
            {
                board[2][0].setPiece(king);
                board[3][0].setPiece(board[0][0].getPiece());
                
                board[4][0].setPiece(null);
                board[0][0].setPiece(null);
            }
            else if (castleInput == 3)
            {
                board[6][0].setPiece(king);
                board[5][0].setPiece(board[7][0].getPiece());
                
                board[4][0].setPiece(null);
                board[7][0].setPiece(null);
            }
        }
        else if (this.getKing().colour == PlayerColour.BLACK)
        {
            if (castleInput == 2)
            {
                board[2][7].setPiece(king);
                board[3][7].setPiece(board[0][7].getPiece());
                
                board[4][7].setPiece(null);
                board[0][7].setPiece(null);
            }
            else if (castleInput == 3)
            {
                board[6][7].setPiece(king);
                board[5][7].setPiece(board[7][0].getPiece());
                
                board[4][7].setPiece(null);
                board[7][7].setPiece(null);
            }
        }
    }

    /**
     * @return the king
     */
    public Piece getKing() {
        return king;
    }

    /**
     * @param king the king to set
     */
    public void setKing(Piece king) {
        this.king = king;
    }

    /**
     * @return the x_direction
     */
    public int getX_direction() {
        return x_direction;
    }

    /**
     * @param x_direction the x_direction to set
     */
    public void setX_direction(int x_direction) {
        this.x_direction = x_direction;
    }

    /**
     * @return the y_direction
     */
    public int getY_direction() {
        return y_direction;
    }

    /**
     * @param y_direction the y_direction to set
     */
    public void setY_direction(int y_direction) {
        this.y_direction = y_direction;
    }
    
    
    
}
