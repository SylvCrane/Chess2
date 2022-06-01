/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author navjo
 */
public class Cheque {
    
    private int xDirection;
    private int yDirection;
    private Player player;
    
    public Cheque (Player player)
    {
        this.player = player;
    }
    
    /**
     * This checks if the player's king is in cheque. It does this through several steps. Firstly, it finds the player's king. Then. it checks if there is 
     * a pawn that has placed the king in cheque. Pawn is separate as a result of its special situation regarding taking pieces. Then, it checks each
     * direction from the king that a king can take (N, E, S, W, NE, SE, SW, NW). If there is a piece capable of moving straight to the king at these
     * locations, the method checks for a 'protecting' piece (A piece of the same colour as the king). If yes, the king is not in cheque. Finally, the method
     * checks for knights and other kings capable of taking the player's king.
     * 
     *
     * 
     * @param board: The playing board, a two-dimensional array of squares.
     * @param player: The current player.
     * @return 
     */
    
    public void findKing(Square[][] board, Player player)
    {
        this.setPlayer(player);
        
        for (int xIndex = 0; xIndex < 8; xIndex++)
        {
            for (int yIndex = 0; yIndex < 8; yIndex++)
            {
                if (board[xIndex][yIndex].getPiece() != null)
                {
                    if (board[xIndex][yIndex].getPiece().getClass().equals(King.class) && board[xIndex][yIndex].getPiece().colour == player.getColour())
                    {
                        this.setxDirection(xIndex);
                        this.setyDirection(yIndex);
                    }
                }   
            }
        }
    }
    
    public boolean checkForCheque(Square[][] board, Player player)
    {
        this.setPlayer(player);
        
        boolean chequeCheck = false;
       
        chequeDirections directionCheque = new chequeDirections(this.getPlayer(), this.getxDirection(), this.getyDirection());
        
        chequeCheck = directionCheque.chequePawn(board);
        
        if (!chequeCheck)
        {
            chequeCheck = directionCheque.northCheque(board);
            
            if (!chequeCheck)
            {
                chequeCheck = directionCheque.northEastCheque(board);
                
                if (!chequeCheck)
                {
                    chequeCheck = directionCheque.eastCheque(board);
                    
                    if (!chequeCheck)
                    {
                        chequeCheck = directionCheque.southEastCheque(board);
                        
                        if (!chequeCheck)
                        {
                            chequeCheck = directionCheque.southCheque(board);
                            
                            if (!chequeCheck)
                            {
                                chequeCheck = directionCheque.southWestCheque(board);
                                
                                if (!chequeCheck)
                                {
                                    chequeCheck = directionCheque.westCheque(board);
                                    
                                    if (!chequeCheck)
                                    {
                                        chequeCheck = directionCheque.northWestCheque(board);
                                        
                                        if (!chequeCheck)
                                        {
                                            chequeCheck = directionCheque.knightCheque(board);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
      
        return chequeCheck;
    }
    
    /**
     * This checks if the current player is in checkmate. It does this by identifying if the player's king can move
     * in any of the cardinal directions. If not, the player is in checkmate and the game is over.
     * 
     * @param board
     * @param player
     * @return 
     */
    public boolean checkMate(Square[][] board, Player player)
    {
        boolean checkMate = false;
        
        boolean northCheque = true;
        boolean northEastCheque = true;
        boolean eastCheque = true;
        boolean southEastCheque = true;
        boolean southCheque = true;
        boolean southWestCheque = true;
        boolean westCheque = true;
        boolean northWestCheque = true;
        
        
        int xDirection = this.getxDirection();
        int yDirection = this.getyDirection();
        
        if ((xDirection - 1) != -1)
        {
            this.setxDirection(xDirection - 1);
            westCheque = this.checkForCheque(board, player);
            this.setxDirection(xDirection);
        }
        
        if ((xDirection + 1) != 8)
        {
            this.setxDirection(xDirection + 1);
            eastCheque = this.checkForCheque(board, player);
            this.setxDirection(xDirection);
        }
        
        if ((yDirection - 1) != -1)
        {
            this.setyDirection(yDirection - 1);
            southCheque = this.checkForCheque(board, player);
            this.setyDirection(yDirection);
        }
        
        if ((yDirection + 1) != 8)
        {
            this.setyDirection(yDirection + 1);
            northCheque = this.checkForCheque(board, player);
            this.setyDirection(yDirection);
        }
        
        if (((xDirection + 1) != 8) && ((yDirection + 1) != 8))
        {
            this.setxDirection(xDirection + 1);
            this.setyDirection(yDirection + 1);
            northEastCheque = this.checkForCheque(board, player);
            this.setxDirection(xDirection);
            this.setyDirection(yDirection);
        }
        
        if (((xDirection + 1) != 8) && ((yDirection - 1) != -1))
        {
            this.setxDirection(xDirection + 1);
            this.setyDirection(yDirection - 1);
            southEastCheque = this.checkForCheque(board, player);
            this.setxDirection(xDirection);
            this.setyDirection(yDirection);
        }
        
        if (((xDirection - 1) != -1) && ((yDirection - 1) != -1))
        {
            this.setxDirection(xDirection - 1);
            this.setyDirection(yDirection - 1);
            southWestCheque = this.checkForCheque(board, player);
            this.setxDirection(xDirection);
            this.setyDirection(yDirection);
        }
        
        if (((xDirection - 1) != -1) && ((yDirection + 1) != 8))
        {
            this.setxDirection(xDirection - 1);
            this.setyDirection(yDirection + 1);
            northWestCheque = this.checkForCheque(board, player);
            this.setxDirection(xDirection);
            this.setyDirection(yDirection);
        }
        
        if ((!northCheque) && (!northEastCheque) && (!eastCheque) && (!southEastCheque) && (!southCheque) && (!southWestCheque) && (!westCheque) && (!northWestCheque))
        {
            checkMate = true;
        }
        
        return checkMate;
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
