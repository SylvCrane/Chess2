/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author navjo
 */
public class DirectionPieces {
    
    private Square pieceToMove;
    private int x_direction;
    private int y_direction;
    private Player player;
    
    public DirectionPieces(Square pieceToMove, int x_direction, int y_direction, Player player)
    {
        this.pieceToMove = pieceToMove;
        this.x_direction = x_direction;
        this.y_direction = y_direction;
        this.player = player;
    }
    
    public boolean directionPawn(Square[][] board)
    {
        boolean directionOkay = false;
        
        if (this.getPieceToMove().getPiece().getColour() == PlayerColour.WHITE)
        {
            if ((this.getPieceToMove().getX_location() - 1) == (this.getX_direction()) && (this.getPieceToMove().getY_location() + 1) == this.getY_direction())
            {
                if (board[this.getX_direction()][this.getY_direction()].getPiece() != null && board[this.getX_direction()][this.getY_direction()].getPiece().getColour() != this.getPlayer().getColour())
                {
                    directionOkay = true;
                    this.getPieceToMove().getPiece().direction = Direction.NORTHWEST;
                }
            }
            else if ((this.getPieceToMove().getX_location() + 1) == (this.getX_direction()) && (this.getPieceToMove().getY_location() + 1) == this.getY_direction())
            {
                if (board[this.getX_direction()][this.getY_direction()].getPiece() != null && board[this.getX_direction()][this.getY_direction()].getPiece().getColour() != this.getPlayer().getColour())
                {
                    directionOkay = true;
                    this.getPieceToMove().getPiece().direction = Direction.NORTHEAST;
                }
            }
            else if ((this.getPieceToMove().getY_location() + 1) == this.getY_direction() && (this.getPieceToMove().getX_location() == this.getX_direction()))
            {
                directionOkay = true;
                this.getPieceToMove().getPiece().direction = Direction.NORTH;
            }
            else if ((this.getPieceToMove().getY_location() + 2) == this.getY_direction() && (this.getPieceToMove().getX_location() == this.getX_direction()))
            {
                if (this.getPieceToMove().getPiece().potential_moves == 2)
                {
                    directionOkay = true;
                    this.getPieceToMove().getPiece().direction = Direction.NORTH;
                }

            }
        }
        else if (this.getPieceToMove().getPiece().getColour() == PlayerColour.BLACK)
        {
            if ((this.getPieceToMove().getX_location() - 1) == (this.getX_direction()) && (this.getPieceToMove().getY_location() - 1) == this.getY_direction())
            {
                if (board[this.getX_direction()][this.getY_direction()].getPiece() != null && board[this.getX_direction()][this.getY_direction()].getPiece().getColour() != this.getPlayer().getColour())
                {
                    directionOkay = true;
                    this.getPieceToMove().getPiece().direction = Direction.SOUTHWEST;
                }
            }
            else if ((this.getPieceToMove().getX_location() + 1) == (this.getX_direction()) && (this.getPieceToMove().getY_location() - 1) == this.getY_direction())
            {
                if (board[this.getX_direction()][this.getY_direction()].getPiece() != null && board[this.getX_direction()][this.getY_direction()].getPiece().getColour() != this.getPlayer().getColour())
                {
                    directionOkay = true;
                    this.getPieceToMove().getPiece().direction = Direction.SOUTHEAST;
                }
            }
            else if ((this.getPieceToMove().getY_location() - 1) == this.getY_direction() && (this.getPieceToMove().getX_location() == this.getX_direction()))
            {
                directionOkay = true;
                this.getPieceToMove().getPiece().direction = Direction.NORTH;
            }
            else if ((this.getPieceToMove().getY_location() - 2) == this.getY_direction() && (this.getPieceToMove().getX_location() == this.getX_direction()))
            {
                if (this.getPieceToMove().getPiece().potential_moves == 2)
                {
                    directionOkay = true;
                    this.getPieceToMove().getPiece().direction = Direction.SOUTH;
                }

            }
        }
        
        return directionOkay;
    }
    
    public boolean directionRook(Square[][] board)
    {
        boolean directionOkay = false;
        
        if ((this.getPieceToMove().getX_location() > this.getX_direction()) || (this.getPieceToMove().getX_location() < this.getX_direction()))
        {
            if (this.getY_direction() == this.getPieceToMove().getY_location())
            {
                directionOkay = true;

                if (this.getPieceToMove().getX_location() > this.getX_direction())
                {
                    this.getPieceToMove().getPiece().direction = Direction.WEST;
                }
                else if (this.getPieceToMove().getX_location() < this.getX_direction())
                {
                    this.getPieceToMove().getPiece().direction = Direction.EAST;
                }
            }
        }
        else if ((this.getPieceToMove().getY_location() > this.getY_direction()) || (this.getPieceToMove().getY_location() < this.getY_direction()))
        {
             if (this.getX_direction() == this.getPieceToMove().getX_location())
            {
                directionOkay = true;

                if (this.getPieceToMove().getY_location() > this.getY_direction())
                {
                    this.getPieceToMove().getPiece().direction = Direction.SOUTH;
                }
                else if (this.getPieceToMove().getY_location() < this.getY_direction())
                {
                    this.getPieceToMove().getPiece().direction = Direction.NORTH;
                }
            }
        }
        
        return directionOkay;
    }
    
    public boolean directionKnight(Square[][] board)
    {
        boolean directionOkay = false;
        
        if (((this.getPieceToMove().getX_location() + 1) == (this.getX_direction())) && ((this.getPieceToMove().getY_location() + 2) == (this.getY_direction())))
        {
            directionOkay = true; 
            this.getPieceToMove().getPiece().direction = Direction.NORTHNORTHEAST;
        }
        else if (((this.getPieceToMove().getX_location() + 2) == (this.getX_direction())) && ((this.getPieceToMove().getY_location() + 1) == (this.getY_direction())))
        {
            directionOkay = true;
            this.getPieceToMove().getPiece().direction = Direction.NORTHEASTEAST;
        }
        else if (((this.getPieceToMove().getX_location() + 2) == (this.getX_direction())) && ((this.getPieceToMove().getY_location() - 1) == (this.getY_direction())))
        {
            directionOkay = true;
            this.getPieceToMove().getPiece().direction = Direction.SOUTHEASTEAST;
        }
        else if (((this.getPieceToMove().getX_location() + 1) == (this.getX_direction())) && ((this.getPieceToMove().getY_location() - 2) == (this.getY_direction())))
        {
            directionOkay = true;
            this.getPieceToMove().getPiece().direction = Direction.SOUTHSOUTHEAST;
        }
        else if (((this.getPieceToMove().getX_location() - 1) == (this.getX_direction())) && ((this.getPieceToMove().getY_location() - 2) == (this.getY_direction())))
        {
            directionOkay = true;
            this.getPieceToMove().getPiece().direction = Direction.SOUTHSOUTHWEST;
        }
        else if (((this.getPieceToMove().getX_location() - 2) == (this.getX_direction())) && ((this.getPieceToMove().getY_location() - 1) == (this.getY_direction())))
        {
            directionOkay = true;
            this.getPieceToMove().getPiece().direction = Direction.SOUTHWESTWEST;
        }
        else if (((this.getPieceToMove().getX_location() - 2) == (this.getX_direction())) && ((this.getPieceToMove().getY_location() + 1) == (this.getY_direction())))
        {
            directionOkay = true;
            this.getPieceToMove().getPiece().direction = Direction.NORTHWESTWEST;
        }
        else if (((this.getPieceToMove().getX_location() - 1) == (this.getX_direction())) && ((this.getPieceToMove().getY_location() + 2) == (this.getY_direction())))
        {
            directionOkay = true;
            this.getPieceToMove().getPiece().direction = Direction.NORTHNORTHWEST;
        }
        
        return directionOkay;
    }
    
    public boolean directionBishop(Square[][] board)
    {
        boolean directionOkay = false;
        
        if ((this.getPieceToMove().getX_location() < this.getX_direction()) && (this.getPieceToMove().getY_location() < this.getY_direction()))
        {
            if ((this.getX_direction() - this.getPieceToMove().getX_location()) == (this.getY_direction() - this.getPieceToMove().getY_location()))
            {
                directionOkay = true;
                this.getPieceToMove().getPiece().direction = Direction.NORTHEAST;
            }
        }
        else if ((this.getPieceToMove().getX_location() < this.getX_direction()) && (this.getPieceToMove().getY_location() > this.getY_direction()))
        {
            if ((this.getX_direction() - this.getPieceToMove().getX_location()) == (this.getPieceToMove().getY_location() - this.getY_direction()))
            {
                directionOkay = true;
                this.getPieceToMove().getPiece().direction = Direction.SOUTHEAST;
            }
        }
        else if ((this.getPieceToMove().getX_location() > this.getX_direction()) && (this.getPieceToMove().getY_location() > this.getY_direction()))
        {
            if ((this.getPieceToMove().getX_location() - this.getX_direction()) == (this.getPieceToMove().getY_location() - this.getY_direction()))
            {
                directionOkay = true;
                this.getPieceToMove().getPiece().direction = Direction.SOUTHWEST;
            }
        }
        else if ((this.getPieceToMove().getX_location() > this.getX_direction()) && (this.getPieceToMove().getY_location() < this.getY_direction()))
        {
            if ((this.getX_direction()) - this.getPieceToMove().getX_location() == (this.getPieceToMove().getY_location() - this.getY_direction()))
            {
                directionOkay = true;
                this.getPieceToMove().getPiece().direction = Direction.NORTHWEST;
            }
        }
        
        return directionOkay;
    }
    
    public boolean directionQueen(Square[][] board)
    {
        boolean directionOkay = false;
        
        if ((this.getPieceToMove().getX_location() > this.getX_direction()) && (this.getPieceToMove().getY_location() == this.getY_direction()))
        {
            directionOkay = true;
            this.getPieceToMove().getPiece().direction = Direction.WEST;             
        }
        else if ((this.getPieceToMove().getX_location() < this.getX_direction()) && (this.getPieceToMove().getY_location() == this.getY_direction()))
        {
            directionOkay = true;
            this.getPieceToMove().getPiece().direction = Direction.EAST; 
        }
        else if ((this.getPieceToMove().getY_location() > this.getY_direction()) && (this.getPieceToMove().getX_location() == this.getX_direction()))
        {
            directionOkay = true;
            this.getPieceToMove().getPiece().direction = Direction.SOUTH; 
        }
        else if ((this.getPieceToMove().getY_location() < this.getY_direction()) && (this.getPieceToMove().getX_location() == this.getX_direction()))
        {
            directionOkay = true;
            this.getPieceToMove().getPiece().direction = Direction.NORTH; 
        }
        else if ((this.getPieceToMove().getX_location() < this.getX_direction()) && (this.getPieceToMove().getY_location() < this.getY_direction()))
        {
            if ((this.getX_direction() - this.getPieceToMove().getX_location()) == (this.getY_direction() - this.getPieceToMove().getY_location()))
            {
                directionOkay = true;
                this.getPieceToMove().getPiece().direction = Direction.NORTHEAST;
            }
        }
        else if ((this.getPieceToMove().getX_location() < this.getX_direction()) && (this.getPieceToMove().getY_location() > this.getY_direction()))
        {
            if ((this.getX_direction() - this.getPieceToMove().getX_location()) == (this.getPieceToMove().getY_location() - this.getY_direction()))
            {
                directionOkay = true;
                this.getPieceToMove().getPiece().direction = Direction.SOUTHEAST;
            }
        }
        else if ((this.getPieceToMove().getX_location() > this.getX_direction()) && (this.getPieceToMove().getY_location() > this.getY_direction()))
        {
            if ((this.getPieceToMove().getX_location() - this.getX_direction()) == (this.getPieceToMove().getY_location() - this.getY_direction()))
            {
                directionOkay = true;
                this.getPieceToMove().getPiece().direction = Direction.SOUTHWEST;
            }
        }
        else if ((this.getPieceToMove().getX_location() > this.getX_direction()) && (this.getPieceToMove().getY_location() < this.getY_direction()))
        {
            if ((this.getX_direction() - this.getPieceToMove().getX_location()) == (this.getPieceToMove().getY_location() - this.getY_direction()))
            {
                directionOkay = true;
                this.getPieceToMove().getPiece().direction = Direction.NORTHWEST;
            }
        }
        
        return directionOkay;
    }
    
    public boolean directionKing(Square[][] board)
    {
        boolean directionOkay = false;
        
        if (((this.getPieceToMove().getX_location() + 1) == (this.getX_direction())) && ((this.getPieceToMove().getY_location() == this.getY_direction())))
        {
            directionOkay = true;
            this.getPieceToMove().getPiece().direction = Direction.EAST;
        }
        else if (((this.getPieceToMove().getX_location() - 1) == (this.getX_direction())) && ((this.getPieceToMove().getY_location() == this.getY_direction())))
        {
            directionOkay = true;
            this.getPieceToMove().getPiece().direction = Direction.WEST;
        }
        else if (((this.getPieceToMove().getY_location() - 1) == (this.getY_direction())) && ((this.getPieceToMove().getX_location() == this.getX_direction())))
        {
            directionOkay = true;
            this.getPieceToMove().getPiece().direction = Direction.SOUTH;
        }
        else if (((this.getPieceToMove().getY_location() + 1) == (this.getY_direction())) && ((this.getPieceToMove().getX_location() == this.getX_direction())))
        {
            directionOkay = true;
            this.getPieceToMove().getPiece().direction = Direction.NORTH;
        }
        else if ((this.getPieceToMove().getX_location() + 1 == this.getX_direction()) && (this.getPieceToMove().getY_location() + 1 == this.getY_direction()))
        {
            if ((this.getX_direction() - this.getPieceToMove().getX_location()) == (this.getY_direction() - this.getPieceToMove().getY_location()))
            {
                directionOkay = true;
                this.getPieceToMove().getPiece().direction = Direction.NORTHEAST;
            }
        }
        else if ((this.getPieceToMove().getX_location() + 1 == this.getX_direction()) && (this.getPieceToMove().getY_location() - 1 == this.getY_direction()))
        {
            if ((this.getX_direction() - this.getPieceToMove().getX_location()) == (this.getPieceToMove().getY_location() - this.getY_direction()))
            {
                directionOkay = true;
                this.getPieceToMove().getPiece().direction = Direction.SOUTHEAST;
            }
        }
        else if ((this.getPieceToMove().getX_location() - 1 == this.getX_direction()) && (this.getPieceToMove().getY_location() - 1 == this.getY_direction()))
        {
            if ((this.getPieceToMove().getX_location() - this.getX_direction()) == (this.getPieceToMove().getY_location() - this.getY_direction()))
            {
                directionOkay = true;
                this.getPieceToMove().getPiece().direction = Direction.SOUTHWEST;
            }
        }
        else if ((this.getPieceToMove().getX_location() - 1 == this.getX_direction()) && (this.getPieceToMove().getY_location() + 1 == this.getY_direction()))
        {
            if ((this.getX_direction() - this.getPieceToMove().getX_location()) == (this.getPieceToMove().getY_location() - this.getY_direction()))
            {
                directionOkay = true;
                this.getPieceToMove().getPiece().direction = Direction.NORTHWEST;
            }
        }
        
        if (board[this.getX_direction()][this.getY_direction()].getPiece() != null)
        {
            if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(King.class))
            {
                directionOkay = false;
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
