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
       
        boolean northProtected = false;
        boolean northeastProtected = false;
        boolean eastProtected = false;
        boolean southEastProtected = false;
        boolean southProtected = false;
        boolean southWestProtected = false;
        boolean westProtected = false;
        boolean northWestProtected = false;
        //Each of these boolean instances are used for the directional checks. If these are true (as in there is a piece of the same colour as the king preventing
        //another piece from taking it), then the boolean is true and the king is safe at this direction.
        
        
        
        //Pawn check
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
            
       //North Check
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
                                for (int northIndexProtected = 1; northIndexProtected < northIndex + 1; northIndexProtected++)
                                {
                                    if (board[this.getxDirection()][this.getyDirection() + northIndexProtected].getPiece() != null)
                                    {
                                         if (board[this.getxDirection()][this.getyDirection() + northIndexProtected].getPiece().colour == this.getPlayer().getColour())
                                         {
                                             northProtected = true;
                                             break;
                                         }  
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
                                for (int northIndexProtected = 1; northIndexProtected < northIndex + 1; northIndexProtected++)
                                {
                                    if (board[this.getxDirection()][this.getyDirection() + northIndexProtected].getPiece() != null)
                                    {
                                         if (board[this.getxDirection()][this.getyDirection() + northIndexProtected].getPiece().colour == this.getPlayer().getColour())
                                         {
                                             northProtected = true;
                                             break;
                                         }  
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
       
       //EastCheck
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
                                for (int eastIndexProtected = 1; eastIndexProtected < eastIndex + 1; eastIndexProtected++)
                                {
                                    if (board[this.getxDirection() + eastIndexProtected][this.getyDirection()].getPiece() != null)
                                    {
                                        if (board[this.getxDirection() + eastIndexProtected][this.getyDirection()].getPiece().colour == this.getPlayer().getColour())
                                        {
                                            eastProtected = true;
                                            break;
                                        } 
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
                                for (int eastIndexProtected = 1; eastIndexProtected < eastIndex + 1; eastIndexProtected++)
                                {
                                   if (board[this.getxDirection() + eastIndexProtected][this.getyDirection()].getPiece() != null)
                                    {
                                        if (board[this.getxDirection() + eastIndexProtected][this.getyDirection()].getPiece().colour == this.getPlayer().getColour())
                                        {
                                            eastProtected = true;
                                            break;
                                        } 
                                    }
                                }
                            }
                            else
                            {
                               chequeCheck = true; 
                               break;
                            }

                            if (northProtected = false)
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
       
       //South Check
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
                                for (int southIndexProtected = 1; southIndexProtected < southIndex + 1; southIndexProtected++)
                                {
                                    if (board[this.getxDirection()][this.getyDirection() - southIndexProtected].getPiece() != null)
                                    {
                                       if (board[this.getxDirection()][this.getyDirection() - southIndexProtected].getPiece().colour == this.getPlayer().getColour())
                                        {
                                            southProtected = true;
                                            break;
                                        } 
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
                                for (int southIndexProtected = 1; southIndexProtected < southIndex + 1; southIndexProtected++)
                                {
                                     if (board[this.getxDirection()][this.getyDirection() - southIndexProtected].getPiece() != null)
                                    {
                                       if (board[this.getxDirection()][this.getyDirection() - southIndexProtected].getPiece().colour == this.getPlayer().getColour())
                                        {
                                            southProtected = true;
                                            break;
                                        } 
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
       
       //West Check
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
                                for (int westIndexProtected = 1; westIndexProtected < westIndex + 1; westIndexProtected++)
                                {
                                    if (board[this.getxDirection() - westIndexProtected][this.getyDirection()].getPiece() != null)
                                    {
                                        if (board[this.getxDirection() - westIndexProtected][this.getyDirection()].getPiece().colour == this.getPlayer().getColour())
                                        {
                                            westProtected = true;
                                            break;
                                        } 
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
                                for (int westIndexProtected = 1; westIndexProtected < westIndex + 1; westIndexProtected++)
                                {
                                    if (board[this.getxDirection() - westIndexProtected][this.getyDirection()].getPiece() != null)
                                    {
                                        if (board[this.getxDirection() - westIndexProtected][this.getyDirection()].getPiece().colour == this.getPlayer().getColour())
                                        {
                                            westProtected = true;
                                            break;
                                        } 
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
       
       //NorthEeastCheck
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
                                for (int northEastIndexProtected = 1; northEastIndexProtected < northEastIndex + 1; northEastIndexProtected++)
                                {
                                    if (board[this.getxDirection() + northEastIndexProtected][this.getyDirection() + northEastIndexProtected].getPiece() != null)
                                    {
                                        if (board[this.getxDirection() + northEastIndexProtected][this.getyDirection() + northEastIndexProtected].getPiece().colour == this.getPlayer().getColour())
                                        {
                                            northeastProtected = true;
                                            break;
                                        }
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
                                for (int northEastIndexProtected = 1; northEastIndexProtected < northEastIndex + 1; northEastIndexProtected++)
                                {
                                    if (board[this.getxDirection() + northEastIndexProtected][this.getyDirection() + northEastIndexProtected].getPiece() != null)
                                    {
                                        if (board[this.getxDirection() + northEastIndexProtected][this.getyDirection() + northEastIndexProtected].getPiece().colour == this.getPlayer().getColour())
                                        {
                                            northeastProtected = true;
                                            break;
                                        }
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
       
       //SouthEastCheck
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
                                for (int southEastIndexProtected = 1; southEastIndexProtected < southEastIndex + 1; southEastIndexProtected++)
                                {
                                    if (board[this.getxDirection() + southEastIndexProtected][this.getyDirection() - southEastIndexProtected].getPiece() != null)
                                    {
                                        if (board[this.getxDirection() + southEastIndexProtected][this.getyDirection() - southEastIndexProtected].getPiece().colour == this.getPlayer().getColour())
                                        {
                                            southEastProtected = true;
                                            break;
                                        } 
                                    }
                                   
                                }
                            }
                            else
                            {
                               chequeCheck = true; 
                               break;
                            }

                            if (southEastProtected == false)
                            {
                               chequeCheck = true; 
                               break;
                            }
                        }
                        else if ((board[this.getxDirection() + southEastIndex][this.getyDirection() - southEastIndex].getPiece().getClass().equals(Queen.class)) && (board[this.getxDirection() + southEastIndex][this.getyDirection() - southEastIndex].getPiece().colour != this.getPlayer().getColour()))
                        {
                            if (southEastIndex > 1)
                            {
                                for (int southEastIndexProtected = 1; southEastIndexProtected < southEastIndex + 1; southEastIndexProtected++)
                                {
                                    if (board[this.getxDirection() + southEastIndexProtected][this.getyDirection() - southEastIndexProtected].getPiece() != null)
                                    {
                                        if (board[this.getxDirection() + southEastIndexProtected][this.getyDirection() - southEastIndexProtected].getPiece().colour == this.getPlayer().getColour())
                                        {
                                            southEastProtected = true;
                                            break;
                                        } 
                                    }
                                }
                            }
                            else
                            {
                               chequeCheck = true; 
                               break;
                            }

                            if (southEastProtected == false)
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
       
       //southWestCheck
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
                                for (int southWestIndexProtected = 1; southWestIndexProtected < southWestIndex + 1; southWestIndexProtected++)
                                {
                                    if (board[this.getxDirection() - southWestIndexProtected][this.getyDirection() - southWestIndexProtected].getPiece() != null)
                                    {
                                        if (board[this.getxDirection() - southWestIndexProtected][this.getyDirection() - southWestIndexProtected].getPiece().colour == this.getPlayer().getColour())
                                        {
                                            southWestProtected = true;
                                            break;
                                        }
                                    }
                                    
                                }
                            }
                            else
                            {
                               chequeCheck = true; 
                               break;
                            }

                            if (southWestProtected == false)
                            {
                               chequeCheck = true; 
                               break;
                            }
                        }
                        else if ((board[this.getxDirection() - southWestIndex][this.getyDirection() - southWestIndex].getPiece().getClass().equals(Queen.class)) && (board[this.getxDirection() - southWestIndex][this.getyDirection() - southWestIndex].getPiece().colour != this.getPlayer().getColour()))
                        {
                            if (southWestIndex > 1)
                            {
                                for (int southWestIndexProtected = 1; southWestIndexProtected < southWestIndex + 1; southWestIndexProtected++)
                                {
                                    if (board[this.getxDirection() - southWestIndexProtected][this.getyDirection() - southWestIndexProtected].getPiece() != null)
                                    {
                                        if (board[this.getxDirection() - southWestIndexProtected][this.getyDirection() - southWestIndexProtected].getPiece().colour == this.getPlayer().getColour())
                                        {
                                            southWestProtected = true;
                                            break;
                                        }
                                    }
                                }
                            }
                            else
                            {
                               chequeCheck = true; 
                               break;
                            }

                            if (southWestProtected == false)
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
       
       //northWestCheck
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
                                for (int northWestIndexProtected = 1; northWestIndexProtected < northWestIndex + 1; northWestIndexProtected++)
                                {
                                    if (board[this.getxDirection() - northWestIndexProtected][this.getyDirection() + northWestIndexProtected].getPiece() != null)
                                    {
                                       if (board[this.getxDirection() - northWestIndexProtected][this.getyDirection() + northWestIndexProtected].getPiece().colour == this.getPlayer().getColour())
                                        {
                                            northWestProtected = true;
                                            break;
                                        } 
                                    }
                                    
                                }
                            }
                            else
                            {
                               chequeCheck = true; 
                               break;
                            }

                            if (northWestProtected == false)
                            {
                               chequeCheck = true; 
                               break;
                            }
                        }
                        else if ((board[this.getxDirection() - northWestIndex][this.getyDirection() + northWestIndex].getPiece().getClass().equals(Queen.class)) && (board[this.getxDirection() - northWestIndex][this.getyDirection() + northWestIndex].getPiece().colour != this.getPlayer().getColour()))
                        {
                            if (northWestIndex > 1)
                            {
                                for (int northWestIndexProtected = 1; northWestIndexProtected < northWestIndex + 1; northWestIndexProtected++)
                                {
                                    if (board[this.getxDirection() - northWestIndexProtected][this.getyDirection() + northWestIndexProtected].getPiece() != null)
                                    {
                                       if (board[this.getxDirection() - northWestIndexProtected][this.getyDirection() + northWestIndexProtected].getPiece().colour == this.getPlayer().getColour())
                                        {
                                            northWestProtected = true;
                                            break;
                                        } 
                                    }
                                }
                            }
                            else
                            {
                               chequeCheck = true; 
                               break;
                            }

                            if (northWestProtected == false)
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
       
       //Knight Check
       //NNE
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
        
        //Finally, king check
        try
        {
            if (board[this.getxDirection()][this.getyDirection() + 1] != null)
            {
                if (board[this.getxDirection()][this.getyDirection() + 1].getPiece() != null)
                {
                    if ((board[this.getxDirection()][this.getyDirection() + 1].getPiece().getClass().equals(King.class)) && (board[this.getxDirection()][this.getyDirection() + 1].getPiece().colour != this.getPlayer().getColour()))
                    {
                        chequeCheck = true;
                    }
                }
            }
        }
        catch(Exception e)
        {
            
        }
        
        try
        {
            if (board[this.getxDirection() + 1][this.getyDirection() + 1] != null)
            {
                if (board[this.getxDirection() + 1][this.getyDirection() + 1].getPiece() != null)
                {
                    if ((board[this.getxDirection() + 1][this.getyDirection() + 1].getPiece().getClass().equals(King.class)) && (board[this.getxDirection() + 1][this.getyDirection() + 1].getPiece().colour != this.getPlayer().getColour()))
                    {
           
                        chequeCheck = true;
                    }
                }
            }
            
        }
        catch(Exception e)
        {
            
        }
        
        try
        {
            if (board[this.getxDirection() + 1][this.getyDirection()] != null)
            {
                if (board[this.getxDirection() + 1][this.getyDirection()].getPiece() != null)
                {
                    if ((board[this.getxDirection() + 1][this.getyDirection()].getPiece().getClass().equals(King.class)) && (board[this.getxDirection() + 1][this.getyDirection()].getPiece().colour != this.getPlayer().getColour()))
                    {
                        chequeCheck = true;
                    }
                }
            }  
        }
        catch(Exception e)
        {
            
        }
        
        try
        {
            if (board[this.getxDirection() + 1][this.getyDirection() - 1] != null)
            {
                if (board[this.getxDirection() + 1][this.getyDirection() - 1].getPiece() != null)
                {
                    if ((board[this.getxDirection() + 1][this.getyDirection() - 1].getPiece().getClass().equals(King.class)) && (board[this.getxDirection() + 1][this.getyDirection() - 1].getPiece().colour != this.getPlayer().getColour()))
                    {
                        chequeCheck = true;
                    }
                }
            }
         
        }
        catch(Exception e)
        {
            
        }
        
        try
        {
            if (board[this.getxDirection()][this.getyDirection() - 1] != null)
            {
                if (board[this.getxDirection()][this.getyDirection() - 1].getPiece() != null)
                {
                    if ((board[this.getxDirection()][this.getyDirection() - 1].getPiece().getClass().equals(King.class)) && (board[this.getxDirection()][this.getyDirection() - 1].getPiece().colour != this.getPlayer().getColour()))
                    {
                        chequeCheck = true;
                    }
                }
            }
         
         
        }
        catch(Exception e)
        {
            
        }
        
        try
        {
            if (board[this.getxDirection() - 1][this.getyDirection() - 1] != null)
            {
                if (board[this.getxDirection() - 1][this.getyDirection() - 1].getPiece() != null)
                {
                    if ((board[this.getxDirection() - 1][this.getyDirection() - 1].getPiece().getClass().equals(King.class)) && (board[this.getxDirection() - 1][this.getyDirection() - 1].getPiece().colour != this.getPlayer().getColour()))
                    {
                        chequeCheck = true;
                    }
                }
            }

        }
        catch(Exception e)
        {
            
        }
        
        try
        {
            if (board[this.getxDirection() - 1][this.getyDirection()] != null)
            {
                if (board[this.getxDirection()][this.getyDirection()].getPiece() != null)
                {
                    if ((board[this.getxDirection() - 1][this.getyDirection()].getPiece().getClass().equals(King.class)) && (board[this.getxDirection() - 1][this.getyDirection()].getPiece().colour != this.getPlayer().getColour()))
                    {
                        chequeCheck = true;
                    }
                }
            }
          
        }
        catch(Exception e)
        {
            
        }
        
        try
        {
            if (board[this.getxDirection() - 1][this.getyDirection() + 1] != null)
            {
                if (board[this.getxDirection()][this.getyDirection() + 1].getPiece() != null)
                {
                    if ((board[this.getxDirection() - 1][this.getyDirection() + 1].getPiece().getClass().equals(King.class)) && (board[this.getxDirection() - 1][this.getyDirection() + 1].getPiece().colour != this.getPlayer().getColour()))
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
