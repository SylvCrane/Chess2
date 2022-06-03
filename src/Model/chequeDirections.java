/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author navjo
 */
public class chequeDirections {
    
    private int xDirection;
    private int yDirection;
    private Player player;
    
    public chequeDirections (Player player, int x_direction, int y_direction)
    {
        this.player = player;
        this.xDirection = x_direction;
        this.yDirection = y_direction;
        
    }
    
    public boolean chequePawn(Square[][] board)
    {
        boolean chequeCheck = false;
        
        if (this.getPlayer().getColour() == PlayerColour.WHITE)
        {
            try
            {
                if (board[this.getxDirection() - 1][this.getyDirection() + 1] != null)
                {
                    if (board[this.getxDirection() - 1][this.getyDirection() + 1].getPiece() != null)
                    {
                        if ((board[this.getxDirection() - 1][this.getyDirection() + 1].getPiece().getClass().equals(Pawn.class)) && (board[this.getxDirection() - 1][this.getyDirection() + 1].getPiece().colour != this.getPlayer().getColour()))
                        {
                            chequeCheck = true;
                        }
                    }
                }  
            }
            catch (Exception e)
            {
                //These are empty as, if the square position is out of the array, the king is safe. Therefore, the further checks can begin.
            }
            
            try
            {
                if (board[this.getxDirection() + 1][this.getyDirection() + 1] != null)
                {
                    if (board[this.getxDirection() + 1][this.getyDirection() + 1].getPiece() != null)
                    {
                        if ((board[this.getxDirection() + 1][this.getyDirection() + 1].getPiece().getClass().equals(Pawn.class)) && (board[this.getxDirection() + 1][this.getyDirection() + 1].getPiece().colour != this.getPlayer().getColour()))
                        {
                            chequeCheck = true;
                        }
                    }
                } 
            }
            catch (Exception e)
            {
                
            } 
        }
        else if (this.getPlayer().getColour() == PlayerColour.BLACK)
        {
            try
            {
                if (board[this.getxDirection() - 1][this.getyDirection() - 1] != null)
                {
                    if (board[this.getxDirection() - 1][this.getyDirection() - 1].getPiece() != null)
                    {
                        if ((board[this.getxDirection() - 1][this.getyDirection() - 1].getPiece().getClass().equals(Pawn.class)) && (board[this.getxDirection() - 1][this.getyDirection() - 1].getPiece().colour != this.getPlayer().getColour()))
                        {
                            chequeCheck = true;
                        }
                    }
                }   
            }
            catch (Exception e)
            {

            }
            
            try
            {
                if (board[this.getxDirection() + 1][this.getyDirection() - 1] != null)
                {
                    if (board[this.getxDirection() + 1][this.getyDirection() - 1].getPiece() != null)
                    {
                        if ((board[this.getxDirection() + 1][this.getyDirection() - 1].getPiece().getClass().equals(Pawn.class)) && (board[this.getxDirection() + 1][this.getyDirection() - 1].getPiece().colour != this.getPlayer().getColour()))
                        {
                            chequeCheck = true;
                        }
                    }

                }
            }
            catch (Exception e)
            {
            
            }
        }
        
        return chequeCheck;
    }
    
    boolean northCheque(Square[][] board)
    {
        boolean chequeCheck = false;
        boolean northProtected = false;
        
        for (int northIndex = 1; northIndex < (8 - this.getyDirection()); northIndex++)
        {
            try
            {
                 if (board[this.getxDirection()][this.getyDirection() + northIndex] != null)
                 {
                     if (board[this.getxDirection()][this.getyDirection() + northIndex].getPiece() != null)
                     {
                         if ((board[this.getxDirection()][this.getyDirection() + northIndex].getPiece().getClass().equals(Rook.class)) && (board[this.getxDirection()][this.getyDirection() + northIndex].getPiece().colour != this.getPlayer().getColour()))
                         {
                             if (northIndex > 1)
                             {
                                 for (int northIndexProtected = 1; northIndexProtected < northIndex; northIndexProtected++)
                                 {
                                     if (board[this.getxDirection()][this.getyDirection() + northIndexProtected].getPiece() != null)
                                     {
                                          
                                              northProtected = true;
                                              break;
                                           
                                     }
                                 }
                             }
                             else
                             {
                                chequeCheck = true; 
                                break;
                             }

                             if (northProtected == false)
                             {
                                chequeCheck = true; 
                                break;
                             }
                          }
                          else if ((board[this.getxDirection()][this.getyDirection() + northIndex].getPiece().getClass().equals(Queen.class)) && (board[this.getxDirection()][this.getyDirection() + northIndex].getPiece().colour != this.getPlayer().getColour()))
                          {
                             if (northIndex > 1)
                             {
                                 for (int northIndexProtected = 1; northIndexProtected < northIndex; northIndexProtected++)
                                 {
                                     if (board[this.getxDirection()][this.getyDirection() + northIndexProtected].getPiece() != null)
                                     {
                                          
                                              northProtected = true;
                                              break;
                                          
                                     }
                                 }
                             }
                             else
                             {
                                chequeCheck = true; 
                                break;
                             }

                             if (northProtected == false)
                             {
                                chequeCheck = true; 
                                break;
                             }
                         }

                      }    
                 }
            }
            catch (Exception e)
            {

            }

        }
        
        return chequeCheck;
    }
    
    boolean eastCheque(Square[][] board)
    {
        boolean chequeCheck = false;
        boolean eastProtected = false;
        
        for (int eastIndex = 1; eastIndex < (8 - this.getxDirection()); eastIndex++)
       {
           try
           {
                if (board[this.getxDirection() + eastIndex][this.getyDirection()] != null)
                {
                    if (board[this.getxDirection() + eastIndex][this.getyDirection()].getPiece() != null)
                    {
                        if ((board[this.getxDirection() + eastIndex][this.getyDirection()].getPiece().getClass().equals(Rook.class)) && (board[this.getxDirection() + eastIndex][this.getyDirection()].getPiece().colour != this.getPlayer().getColour()))
                        {
                            if (eastIndex > 1)
                            {
                                for (int eastIndexProtected = 1; eastIndexProtected < eastIndex; eastIndexProtected++)
                                {
                                    if (board[this.getxDirection() + eastIndexProtected][this.getyDirection()].getPiece() != null)
                                    {
                                        
                                            eastProtected = true;
                                            break;
                                         
                                    }
                                    
                                }
                            }
                            else
                            {
                               chequeCheck = true; 
                               break;
                            }

                            if (eastProtected == false)
                            {
                               chequeCheck = true; 
                               break;
                            }
                        }
                        else if ((board[this.getxDirection() + eastIndex][this.getyDirection()].getPiece().getClass().equals(Queen.class)) && (board[this.getxDirection() + eastIndex][this.getyDirection()].getPiece().colour != this.getPlayer().getColour()))
                        {
                           if (eastIndex > 1)
                            {
                                for (int eastIndexProtected = 1; eastIndexProtected < eastIndex; eastIndexProtected++)
                                {
                                   if (board[this.getxDirection() + eastIndexProtected][this.getyDirection()].getPiece() != null)
                                    {
                                        
                                            eastProtected = true;
                                            break;
                                         
                                    }
                                }
                            }
                            else
                            {
                               chequeCheck = true; 
                               break;
                            }

                            if (eastProtected = false)
                            {
                               chequeCheck = true; 
                               break;
                            }
                        }  
                    }    
                }
           }
           catch (Exception e)
           {
               
           }
           
        }
        
        return chequeCheck;
    }
    
    boolean southCheque(Square[][] board)
    {
        boolean chequeCheck = false;
        boolean southProtected = false;
        
        for (int southIndex = 1; southIndex < this.getyDirection(); southIndex++)
       {
           try
           {
                if (board[this.getxDirection()][this.getyDirection() - southIndex] != null)
                {
                    if (board[this.getxDirection()][this.getyDirection() - southIndex].getPiece() != null)
                    {
                        if ((board[this.getxDirection()][this.getyDirection() - southIndex].getPiece().getClass().equals(Rook.class)) && (board[this.getxDirection()][this.getyDirection() - southIndex].getPiece().colour != this.getPlayer().getColour()))
                        {
                            if (southIndex > 1)
                            {
                                for (int southIndexProtected = 1; southIndexProtected < southIndex; southIndexProtected++)
                                {
                                    if (board[this.getxDirection()][this.getyDirection() - southIndexProtected].getPiece() != null)
                                    {
                                       
                                            southProtected = true;
                                            break;
                                         
                                    }
                                    
                                }
                            }
                            else
                            {
                               chequeCheck = true; 
                               break;
                            }

                            if (southProtected == false)
                            {
                               chequeCheck = true; 
                               break;
                            }
                        }
                        else if ((board[this.getxDirection()][this.getyDirection() - southIndex].getPiece().getClass().equals(Queen.class)) && (board[this.getxDirection()][this.getyDirection() - southIndex].getPiece().colour != this.getPlayer().getColour()))
                        {
                           if (southIndex > 1)
                            {
                                for (int southIndexProtected = 1; southIndexProtected < southIndex; southIndexProtected++)
                                {
                                     if (board[this.getxDirection()][this.getyDirection() - southIndexProtected].getPiece() != null)
                                    {
                                       
                                            southProtected = true;
                                            break;
                                         
                                    }
                                }
                            }
                            else
                            {
                               chequeCheck = true; 
                               break;
                            }

                            if (southProtected = false)
                            {
                               chequeCheck = true; 
                               break;
                            }
                        }  
                     }    
                 }
           }
           catch (Exception e)
           {
               
           }
           
        }
        
        return chequeCheck;
    }
    
    boolean westCheque(Square[][] board)
    {
        boolean chequeCheck = false;
        boolean westProtected = false;
        
        for (int westIndex = 1; westIndex < this.getxDirection(); westIndex++)
       {
           try
           {
               if (board[this.getxDirection() - westIndex][this.getyDirection()] != null)
                {
                    if (board[this.getxDirection() - westIndex][this.getyDirection()].getPiece() != null)
                    {
                        if ((board[this.getxDirection() - westIndex][this.getyDirection()].getPiece().getClass().equals(Rook.class)) && (board[this.getxDirection() - westIndex][this.getyDirection()].getPiece().colour != this.getPlayer().getColour()))
                        {
                            if (westIndex > 1)
                            {
                                for (int westIndexProtected = 1; westIndexProtected < westIndex; westIndexProtected++)
                                {
                                    if (board[this.getxDirection() - westIndexProtected][this.getyDirection()].getPiece() != null)
                                    {
                                        
                                            westProtected = true;
                                            break;
                                         
                                    }
                                }
                            }
                            else
                            {
                               chequeCheck = true; 
                               break;
                            }

                            if (westProtected == false)
                            {
                               chequeCheck = true; 
                               break;
                            }
                        }
                        else if ((board[this.getxDirection() - westIndex][this.getyDirection()].getPiece().getClass().equals(Queen.class)) && (board[this.getxDirection() - westIndex][this.getyDirection()].getPiece().colour != this.getPlayer().getColour()))
                        {
                           if (westIndex > 1)
                            {
                                for (int westIndexProtected = 1; westIndexProtected < westIndex; westIndexProtected++)
                                {
                                    if (board[this.getxDirection() - westIndexProtected][this.getyDirection()].getPiece() != null)
                                    {
                                        
                                            westProtected = true;
                                            break;
                                         
                                    }
                                }
                            }
                            else
                            {
                               chequeCheck = true; 
                               break;
                            }

                            if (westProtected == false)
                            {
                               chequeCheck = true; 
                               break;
                            }
                        }  
                     }    
                 }
           }
           catch (Exception e)
           {
               
           }
           
        }
        
        return chequeCheck;
    }
    
    boolean northEastCheque(Square[][] board)
    {
        boolean chequeCheck = false;
        boolean northeastProtected = false;
        
        int northEastNumber = 0;
       
       for (int countingIndex = 1; countingIndex < 8; countingIndex++)
       {
           try
           {
               if (board[this.getxDirection() + countingIndex][this.getyDirection() + countingIndex] != null)
                {
                    northEastNumber++;
                }
               
           }
           catch (Exception e)
           {
               break;
           } 
       }
       
       for (int northEastIndex = 1; northEastIndex < (northEastNumber + 1); northEastIndex++)
       {
           try
           {
               if (board[this.getxDirection() + northEastIndex][this.getyDirection() + northEastIndex] != null)
                {
                    if (board[this.getxDirection() + northEastIndex][this.getyDirection() + northEastIndex].getPiece() != null)
                    {
                        if ((board[this.getxDirection() + northEastIndex][this.getyDirection() + northEastIndex].getPiece().getClass().equals(Bishop.class)) && (board[this.getxDirection() + northEastIndex][this.getyDirection() + northEastIndex].getPiece().colour != this.getPlayer().getColour()))
                        {
                            if (northEastIndex > 1)
                            {
                                for (int northEastIndexProtected = 1; northEastIndexProtected < northEastIndex; northEastIndexProtected++)
                                {
                                    if (board[this.getxDirection() + northEastIndexProtected][this.getyDirection() + northEastIndexProtected].getPiece() != null)
                                    {
                                        
                                            northeastProtected = true;
                                            break;
                                        
                                    }
                                }
                            }
                            else
                            {
                               chequeCheck = true; 
                               break;
                            }

                            if (northeastProtected == false)
                            {
                               chequeCheck = true; 
                               break;
                            }
                        }
                        else if ((board[this.getxDirection() + northEastIndex][this.getyDirection() + northEastIndex].getPiece().getClass().equals(Queen.class)) && (board[this.getxDirection() + northEastIndex][this.getyDirection() + northEastIndex].getPiece().colour != this.getPlayer().getColour()))
                        {
                            if (northEastIndex > 1)
                            {
                                for (int northEastIndexProtected = 1; northEastIndexProtected < northEastIndex; northEastIndexProtected++)
                                {
                                    if (board[this.getxDirection() + northEastIndexProtected][this.getyDirection() + northEastIndexProtected].getPiece() != null)
                                    {
                                        
                                            northeastProtected = true;
                                            break;
                                        
                                    }
                                }
                            }
                            else
                            {
                               chequeCheck = true; 
                               break;
                            }

                            if (northeastProtected == false)
                            {
                               chequeCheck = true; 
                               break;
                            }
                         } 
                     }    
                 }
           }
           catch (Exception e)
           {
               
           }
           
        }
       
        return chequeCheck;
    }
    
    boolean southEastCheque(Square[][] board)
    {
        boolean chequeCheck = false;
        boolean southeastProtected = false;
        
        int southEastNumber = 0;
       
       for (int countingIndex = 1; countingIndex < 8; countingIndex++)
       {
           try
           {
                if (board[this.getxDirection() + countingIndex][this.getyDirection() - countingIndex] != null)
                {
                    southEastNumber++;
                }
               
           }
           catch (Exception e)
           {
               break;
           }
            
       }
       
       for (int southEastIndex = 1; southEastIndex < (southEastNumber + 1); southEastIndex++)
       {
           try
           {
               if (board[this.getxDirection() + southEastIndex][this.getyDirection() - southEastIndex] != null)
                {
                    if (board[this.getxDirection() + southEastIndex][this.getyDirection() - southEastIndex].getPiece() != null)
                    {
                        if ((board[this.getxDirection() + southEastIndex][this.getyDirection() - southEastIndex].getPiece().getClass().equals(Bishop.class)) && (board[this.getxDirection() + southEastIndex][this.getyDirection() - southEastIndex].getPiece().colour != this.getPlayer().getColour()))
                        {
                            if (southEastIndex > 1)
                            {
                                for (int southEastIndexProtected = 1; southEastIndexProtected < southEastIndex; southEastIndexProtected++)
                                {
                                    if (board[this.getxDirection() + southEastIndexProtected][this.getyDirection() - southEastIndexProtected].getPiece() != null)
                                    {
                                        
                                            southeastProtected = true;
                                            break;
                                         
                                    }
                                   
                                }
                            }
                            else
                            {
                               chequeCheck = true; 
                               break;
                            }

                            if (southeastProtected == false)
                            {
                               chequeCheck = true; 
                               break;
                            }
                        }
                        else if ((board[this.getxDirection() + southEastIndex][this.getyDirection() - southEastIndex].getPiece().getClass().equals(Queen.class)) && (board[this.getxDirection() + southEastIndex][this.getyDirection() - southEastIndex].getPiece().colour != this.getPlayer().getColour()))
                        {
                            if (southEastIndex > 1)
                            {
                                for (int southEastIndexProtected = 1; southEastIndexProtected < southEastIndex; southEastIndexProtected++)
                                {
                                    if (board[this.getxDirection() + southEastIndexProtected][this.getyDirection() - southEastIndexProtected].getPiece() != null)
                                    {
                                        
                                            southeastProtected = true;
                                            break;
                                         
                                    }
                                }
                            }
                            else
                            {
                               chequeCheck = true; 
                               break;
                            }

                            if (southeastProtected == false)
                            {
                               chequeCheck = true; 
                               break;
                            }
                         } 
                     }    
                 }
           }
           catch (Exception e)
           {
               
           }
           
        }
       
        
        return chequeCheck;
    }
    
    boolean southWestCheque(Square[][] board)
    {
        boolean chequeCheck = false;
        boolean southwestProtected = false;
        
        int southWestNumber = 0;
       
       for (int countingIndex = 1; countingIndex < 8; countingIndex++)
       {
           try
           {
               if (board[this.getxDirection() - countingIndex][this.getyDirection() - countingIndex] != null)
                {
                    southWestNumber++;
                }
               
           }
           catch (Exception e)
           {
               break;
           }
           
           
       }
       
       for (int southWestIndex = 1; southWestIndex < (southWestNumber + 1); southWestIndex++)
       {
           try
           {
               if (board[this.getxDirection() - southWestIndex][this.getyDirection() - southWestIndex] != null)
                {
                    if (board[this.getxDirection() - southWestIndex][this.getyDirection() - southWestIndex].getPiece() != null)
                    {
                        if ((board[this.getxDirection() - southWestIndex][this.getyDirection() - southWestIndex].getPiece().getClass().equals(Bishop.class)) && (board[this.getxDirection() - southWestIndex][this.getyDirection() - southWestIndex].getPiece().colour != this.getPlayer().getColour()))
                        {
                            if (southWestIndex > 1)
                            {
                                for (int southWestIndexProtected = 1; southWestIndexProtected < southWestIndex; southWestIndexProtected++)
                                {
                                    if (board[this.getxDirection() - southWestIndexProtected][this.getyDirection() - southWestIndexProtected].getPiece() != null)
                                    {
                                        southwestProtected = true;
                                        break;
                                    }
                                    
                                }
                            }
                            else
                            {
                               chequeCheck = true; 
                               break;
                            }

                            if (southwestProtected == false)
                            {
                               chequeCheck = true; 
                               break;
                            }
                        }
                        else if ((board[this.getxDirection() - southWestIndex][this.getyDirection() - southWestIndex].getPiece().getClass().equals(Queen.class)) && (board[this.getxDirection() - southWestIndex][this.getyDirection() - southWestIndex].getPiece().colour != this.getPlayer().getColour()))
                        {
                            if (southWestIndex > 1)
                            {
                                for (int southWestIndexProtected = 1; southWestIndexProtected < southWestIndex; southWestIndexProtected++)
                                {
                                    if (board[this.getxDirection() - southWestIndexProtected][this.getyDirection() - southWestIndexProtected].getPiece() != null)
                                    {
                                        
                                            southwestProtected = true;
                                            break;
                                        
                                    }
                                }
                            }
                            else
                            {
                               chequeCheck = true; 
                               break;
                            }

                            if (southwestProtected == false)
                            {
                               chequeCheck = true; 
                               break;
                            }
                         } 
                     }    
                 }
               
           }
           catch (Exception e)
           {
               break;
           }
         
        }
       
        return chequeCheck;
    }
    
    boolean northWestCheque(Square[][] board)
    {
        boolean chequeCheck = false;
        boolean northwestProtected = false;
        
        int northWestNumber = 0;
       
       for (int countingIndex = 1; countingIndex < 8; countingIndex++)
       {
           try
           {
               if (board[this.getxDirection() - countingIndex][this.getyDirection() + countingIndex] != null)
                {
                    northWestNumber++;
                }
               
           }
           catch (Exception e)
           {
               break;
           }
           
       }
       
       for (int northWestIndex = 1; northWestIndex < (northWestNumber + 1); northWestIndex++)
       {
           try
           {
               if (board[this.getxDirection() - northWestIndex][this.getyDirection() + northWestIndex] != null)
                {
                    if (board[this.getxDirection() - northWestIndex][this.getyDirection() + northWestIndex].getPiece() != null)
                    {
                        if ((board[this.getxDirection() - northWestIndex][this.getyDirection() + northWestIndex].getPiece().getClass().equals(Bishop.class)) && (board[this.getxDirection() - northWestIndex][this.getyDirection() + northWestIndex].getPiece().colour != this.getPlayer().getColour()))
                        {
                            if (northWestIndex > 1)
                            {
                                for (int northWestIndexProtected = 1; northWestIndexProtected < northWestIndex; northWestIndexProtected++)
                                {
                                    if (board[this.getxDirection() - northWestIndexProtected][this.getyDirection() + northWestIndexProtected].getPiece() != null)
                                    {
                                       
                                            northwestProtected = true;
                                            break;
                                         
                                    }
                                    
                                }
                            }
                            else
                            {
                               chequeCheck = true; 
                               break;
                            }

                            if (northwestProtected == false)
                            {
                               chequeCheck = true; 
                               break;
                            }
                        }
                        else if ((board[this.getxDirection() - northWestIndex][this.getyDirection() + northWestIndex].getPiece().getClass().equals(Queen.class)) && (board[this.getxDirection() - northWestIndex][this.getyDirection() + northWestIndex].getPiece().colour != this.getPlayer().getColour()))
                        {
                            if (northWestIndex > 1)
                            {
                                for (int northWestIndexProtected = 1; northWestIndexProtected < northWestIndex; northWestIndexProtected++)
                                {
                                    if (board[this.getxDirection() - northWestIndexProtected][this.getyDirection() + northWestIndexProtected].getPiece() != null)
                                    {
                                       
                                            northwestProtected = true;
                                            break;
                                        
                                    }
                                }
                            }
                            else
                            {
                               chequeCheck = true; 
                               break;
                            }

                            if (northwestProtected == false)
                            {
                               chequeCheck = true; 
                               break;
                             }
                         } 
                     }    
                 }
           }
           catch (Exception e)
           {
               
           }
           
        }
       
        return chequeCheck;
    }
    
    public boolean knightCheque(Square[][] board)
    {
        boolean chequeCheck = false;
        
        chequeKnight knight = new chequeKnight(this.getPlayer(), this.getxDirection(), this.getyDirection());
        
        chequeCheck = knight.nneCheque(board);
        
        if (!chequeCheck)
        {
            chequeCheck = knight.neeCheque(board);
            
            if (!chequeCheck)
            {
                chequeCheck = knight.seeCheque(board);
                
                if (!chequeCheck)
                {
                    chequeCheck = knight.sseCheque(board);
                    
                    if (!chequeCheck)
                    {
                        chequeCheck = knight.sswCheque(board);
                        
                        if (!chequeCheck)
                        {
                            chequeCheck = knight.swwCheque(board);
                            
                            if (!chequeCheck)
                            {
                                chequeCheck = knight.nwwCheque(board);
                                
                                if (!chequeCheck)
                                {
                                    chequeCheck = knight.nnwCheque(board);
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
