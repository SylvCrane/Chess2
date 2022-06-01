/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author navjo
 */
public class chequeKnight {
    
    private int xDirection;
    private int yDirection;
    private Player player;
    
    public chequeKnight (Player player, int x_direction, int y_direction)
    {
        this.player = player;
        this.xDirection = x_direction;
        this.yDirection = y_direction;
    }
    
    public boolean nneCheque(Square[][] board)
    {
        boolean chequeCheck = false;
        
        try
        {
             if (board[this.getxDirection() + 1][this.getyDirection() + 2] != null)
             {
                 if (board[this.getxDirection() + 1][this.getyDirection() + 2].getPiece() != null)
                 {
                     if ((board[this.getxDirection() + 1][this.getyDirection() + 2].getPiece().getClass().equals(Knight.class)) && (board[this.getxDirection() + 1][this.getyDirection() + 2].getPiece().colour != this.getPlayer().getColour()))
                     {
                         chequeCheck = true;   
                     }
                 }
             } 
        }
        catch (Exception e)
        {

        }
        
        return chequeCheck;
    }
    
    public boolean neeCheque(Square[][] board)
    {
        boolean chequeCheck = false;
        
        try 
        {
            if (board[this.getxDirection() + 2][this.getyDirection() + 1] != null)
             {
                 if (board[this.getxDirection() + 2][this.getyDirection() + 1].getPiece() != null)
                 {
                     if ((board[this.getxDirection() + 2][this.getyDirection() + 1].getPiece().getClass().equals(Knight.class)) && (board[this.getxDirection() + 2][this.getyDirection() + 1].getPiece().colour != this.getPlayer().getColour()))
                     {
                         chequeCheck = true;   
                     }
                 }
             }

        }
        catch (Exception e)
        {

        }
        
        return chequeCheck;
    }
    
    public boolean seeCheque(Square[][] board)
    {
        boolean chequeCheck = false;
        
        try
        {
            if (board[this.getxDirection() + 2][this.getyDirection() - 1] != null)
             {
                 if (board[this.getxDirection() + 2][this.getyDirection() - 1].getPiece() != null)
                 {
                     if ((board[this.getxDirection() + 2][this.getyDirection() - 1].getPiece().getClass().equals(Knight.class)) && (board[this.getxDirection() + 2][this.getyDirection() - 1].getPiece().colour != this.getPlayer().getColour()))
                     {
                         chequeCheck = true;   
                     }
                 }
             }
        }
        catch(Exception e)
        {

        }
        
        return chequeCheck;
    }
    
    public boolean sseCheque(Square[][] board)
    {
        boolean chequeCheck = false;
        
        try
        {
            if (board[this.getxDirection() + 1][this.getyDirection() - 2] != null)
             {
                 if (board[this.getxDirection() + 1][this.getyDirection() - 2].getPiece() != null)
                 {
                     if ((board[this.getxDirection() + 1][this.getyDirection() - 2].getPiece().getClass().equals(Knight.class)) && (board[this.getxDirection() + 1][this.getyDirection() - 2].getPiece().colour != this.getPlayer().getColour()))
                     {
                         chequeCheck = true;   
                     }
                 }
             }

        }
        catch(Exception e)
        {

        }
        
        return chequeCheck;
    }
    
    public boolean sswCheque(Square[][] board)
    {
        boolean chequeCheck = false;
        
        try
        {
            if (board[this.getxDirection() - 1][this.getyDirection() - 2] != null)
            {
                if (board[this.getxDirection() - 1][this.getyDirection() - 2].getPiece() != null)
                {
                    if ((board[this.getxDirection() - 1][this.getyDirection() - 2].getPiece().getClass().equals(Knight.class)) && (board[this.getxDirection() - 1][this.getyDirection() - 2].getPiece().colour != this.getPlayer().getColour()))
                    {
                        chequeCheck = true;   
                    }
                }
            }
            
        }
        catch(Exception e)
        {
            
        }
        
        return chequeCheck;
    }
    
    public boolean swwCheque(Square[][] board)
    {
        boolean chequeCheck = false;
        
        try
        {
            if (board[this.getxDirection() - 2][this.getyDirection() - 1] != null)
            {
                if (board[this.getxDirection() - 2][this.getyDirection() - 1].getPiece() != null)
                {
                    if ((board[this.getxDirection() - 2][this.getyDirection() - 1].getPiece().getClass().equals(Knight.class)) && (board[this.getxDirection() - 2][this.getyDirection() - 1].getPiece().colour != this.getPlayer().getColour()))
                    {
                        chequeCheck = true;   
                    }
                }
            }
        }
        catch (Exception e)
        {
            
        }
        
        return chequeCheck;
    }
    
    public boolean nwwCheque(Square[][] board)
    {
        boolean chequeCheck = false;
        
        try
        {
            if (board[this.getxDirection() - 2][this.getyDirection() + 1] != null)
            {
                if (board[this.getxDirection() - 2][this.getyDirection() + 1].getPiece() != null)
                {
                    if ((board[this.getxDirection() - 2][this.getyDirection() + 1].getPiece().getClass().equals(Knight.class)) && (board[this.getxDirection() - 2][this.getyDirection() + 1].getPiece().colour != this.getPlayer().getColour()))
                    {
                        chequeCheck = true;   
                    }
                }
            }
            
        }
        catch(Exception e)
        {
            
        }
        
        return chequeCheck;
    }
    
    public boolean nnwCheque(Square[][] board)
    {
        boolean chequeCheck = false;
        
        try
        {
            if (board[this.getxDirection() - 1][this.getyDirection() + 2] != null)
            {
                if (board[this.getxDirection() - 1][this.getyDirection() + 2].getPiece() != null)
                {
                    if ((board[this.getxDirection() - 1][this.getyDirection() + 2].getPiece().getClass().equals(Knight.class)) && (board[this.getxDirection() - 1][this.getyDirection() + 2].getPiece().colour != this.getPlayer().getColour()))
                    {
                        chequeCheck = true;   
                    }
                }
            }
            
        }
        catch(Exception e)
        {
            
        }
        
        return chequeCheck;
    }

    /**
     * @return the xDirection
     */
    public int getxDirection() {
        return xDirection;
    }

    /**
     * @param xDirection the xDirection to set
     */
    public void setxDirection(int xDirection) {
        this.xDirection = xDirection;
    }

    /**
     * @return the yDirection
     */
    public int getyDirection() {
        return yDirection;
    }

    /**
     * @param yDirection the yDirection to set
     */
    public void setyDirection(int yDirection) {
        this.yDirection = yDirection;
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
