/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author navjo
 */
public class kingNearPosition {
    
    private Square pieceToMove;
    private int x_direction;
    private int y_direction;
    private Player player;
    
    public kingNearPosition(Square pieceToMove, int x_direction, int y_direction, Player player)
    {
        this.pieceToMove = pieceToMove;
        this.x_direction = x_direction;
        this.y_direction = y_direction;
        this.player = player;
    }
    
    public boolean kingNearPositionEast(Square[][] board)
    {
        boolean directionOkay = false;
        
        if (this.getPieceToMove().getPiece().direction == Direction.EAST)
        {
            try
            {
                if (board[this.getX_direction() + 1][this.getY_direction() + 1] != null)
                {
                    if (board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
            
            try
            {
                if (board[this.getX_direction() + 1][this.getY_direction()] != null)
                {
                    if (board[this.getX_direction() + 1][this.getY_direction()].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
            
            try
            {
                if (board[this.getX_direction() + 1][this.getY_direction() - 1] != null)
                {
                    if (board[this.getX_direction() + 1][this.getY_direction() - 1].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
        }

        return directionOkay;
    }
    
    public boolean kingNearPositionWest(Square[][] board)
    {
        boolean directionOkay = false;
        
        if (this.getPieceToMove().getPiece().direction == Direction.WEST)
        {
            try
            {
                if (board[this.getX_direction() - 1][this.getY_direction() + 1] != null)
                {
                    if (board[this.getX_direction() - 1][this.getY_direction() + 1].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
            
            try
            {
                if (board[this.getX_direction() - 1][this.getY_direction()] != null)
                {
                    if (board[this.getX_direction() - 1][this.getY_direction()].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
            
            try
            {
                if (board[this.getX_direction() - 1][this.getY_direction() - 1] != null)
                {
                    if (board[this.getX_direction() - 1][this.getY_direction() - 1].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
        }
        
        return directionOkay;
    }
    
    public boolean kingNearPositionNorth(Square[][] board)
    {
        boolean directionOkay = false;
        
        if (this.getPieceToMove().getPiece().direction == Direction.NORTH)
        {
            try
            {
                if (board[this.getX_direction() - 1][this.getY_direction() + 1] != null)
                {
                    if (board[this.getX_direction() - 1][this.getY_direction() + 1].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
            
            try
            {
                if (board[this.getX_direction()][this.getY_direction() + 1] != null)
                {
                    if (board[this.getX_direction()][this.getY_direction() + 1].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
            
            try
            {
                if (board[this.getX_direction() + 1][this.getY_direction() + 1] != null)
                {
                    if (board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
        }
        else if (this.getPieceToMove().getPiece().direction == Direction.WEST)
        {
            
        }
        
        return directionOkay;
    }
    
    public boolean kingNearPositionSouth(Square[][] board)
    {
        boolean directionOkay = false;
        
        if (this.getPieceToMove().getPiece().direction == Direction.SOUTH)
        {
            try
            {
                if (board[this.getX_direction() - 1][this.getY_direction() - 1] != null)
                {
                    if (board[this.getX_direction() - 1][this.getY_direction() - 1].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
            
            try
            {
                if (board[this.getX_direction()][this.getY_direction() - 1] != null)
                {
                    if (board[this.getX_direction()][this.getY_direction() - 1].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
            
            try
            {
                if (board[this.getX_direction() + 1][this.getY_direction() - 1] != null)
                {
                    if (board[this.getX_direction() + 1][this.getY_direction() - 1].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
        }
        else if (this.getPieceToMove().getPiece().direction == Direction.WEST)
        {
            
        }
        
        return directionOkay;
    }
    
    public boolean kingNearPositionNorthEast(Square[][] board)
    {
        boolean directionOkay = false;
        
        if (this.getPieceToMove().getPiece().direction == Direction.NORTHEAST)
        {
            try
            {
                if (board[this.getX_direction() - 1][this.getY_direction() + 1] != null)
                {
                    if (board[this.getX_direction() - 1][this.getY_direction() + 1].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
            
            try
            {
                if (board[this.getX_direction()][this.getY_direction() + 1] != null)
                {
                    if (board[this.getX_direction()][this.getY_direction() + 1].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
            
            try
            {
                if (board[this.getX_direction() + 1][this.getY_direction() + 1] != null)
                {
                    if (board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
            
            try
            {
                if (board[this.getX_direction() + 1][this.getY_direction()] != null)
                {
                    if (board[this.getX_direction() + 1][this.getY_direction()].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
            
            try
            {
                if (board[this.getX_direction() + 1][this.getY_direction() - 1] != null)
                {
                    if (board[this.getX_direction() + 1][this.getY_direction() - 1].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
        }
        
        return directionOkay;
    }
    
    public boolean kingNearPositionSouthEast(Square[][] board)
    {
        boolean directionOkay = false;
        
        if (this.getPieceToMove().getPiece().direction == Direction.SOUTHEAST)
        {
            try
            {
                if (board[this.getX_direction() + 1][this.getY_direction() + 1] != null)
                {
                    if (board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
            
            try
            {
                if (board[this.getX_direction() + 1][this.getY_direction()] != null)
                {
                    if (board[this.getX_direction() + 1][this.getY_direction()].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
            
            try
            {
                if (board[this.getX_direction() + 1][this.getY_direction() - 1] != null)
                {
                    if (board[this.getX_direction() + 1][this.getY_direction() - 1].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
            
            try
            {
                if (board[this.getX_direction()][this.getY_direction() - 1] != null)
                {
                    if (board[this.getX_direction()][this.getY_direction() - 1].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
            
            try
            {
                if (board[this.getX_direction() - 1][this.getY_direction() - 1] != null)
                {
                    if (board[this.getX_direction() -1][this.getY_direction() - 1].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
        }
        
        return directionOkay;
    }
    
    public boolean kingNearPositionSouthWest(Square[][] board)
    {
        boolean directionOkay = false;
        
        if (this.getPieceToMove().getPiece().direction == Direction.SOUTHEAST)
        {
            try
            {
                if (board[this.getX_direction() - 1][this.getY_direction() + 1] != null)
                {
                    if (board[this.getX_direction() - 1][this.getY_direction() + 1].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
            
            try
            {
                if (board[this.getX_direction() - 1][this.getY_direction()] != null)
                {
                    if (board[this.getX_direction() - 1][this.getY_direction()].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
            
            try
            {
                if (board[this.getX_direction() - 1][this.getY_direction() - 1] != null)
                {
                    if (board[this.getX_direction() - 1][this.getY_direction() - 1].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
            
            try
            {
                if (board[this.getX_direction()][this.getY_direction() - 1] != null)
                {
                    if (board[this.getX_direction()][this.getY_direction() - 1].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
            
            try
            {
                if (board[this.getX_direction() + 1][this.getY_direction() - 1] != null)
                {
                    if (board[this.getX_direction() + 1][this.getY_direction() - 1].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
        }
        
        return directionOkay;
    }
    
    public boolean kingNearPositionNorthWest(Square[][] board)
    {
        boolean directionOkay = false;
        
        if (this.getPieceToMove().getPiece().direction == Direction.SOUTHEAST)
        {
            try
            {
                if (board[this.getX_direction() + 1][this.getY_direction() + 1] != null)
                {
                    if (board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
            
            try
            {
                if (board[this.getX_direction()][this.getY_direction() + 1] != null)
                {
                    if (board[this.getX_direction()][this.getY_direction() + 1].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
            
            try
            {
                if (board[this.getX_direction() - 1][this.getY_direction() + 1] != null)
                {
                    if (board[this.getX_direction() - 1][this.getY_direction() + 1].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
            
            try
            {
                if (board[this.getX_direction() - 1][this.getY_direction()] != null)
                {
                    if (board[this.getX_direction() - 1][this.getY_direction()].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
            
            try
            {
                if (board[this.getX_direction() - 1][this.getY_direction() - 1] != null)
                {
                    if (board[this.getX_direction() - 1][this.getY_direction() - 1].getPiece() != null && board[this.getX_direction() + 1][this.getY_direction() + 1].getPiece().getClass().equals(King.class))
                    {
                        directionOkay = false;
                    }
                }
            }
            catch (Exception e)
            {
                
            }
        }
        
        return directionOkay;
    }
    
    /**
     * @return the pieceToMove
     */
    public Square getPieceToMove() {
        return pieceToMove;
    }

    /**
     * @param pieceToMove the pieceToMove to set
     */
    public void setPieceToMove(Square pieceToMove) {
        this.pieceToMove = pieceToMove;
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

    /**
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(Player player) {
        this.player = player;
    }
    
    
}
