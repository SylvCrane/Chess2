/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Scanner;

/**
 * A major class, this is used to translate the player inputs into directions and moves that the pieces will use.
 *
 * @author navjo
 */
public class PlayerInput {
    
    private Player player;
    private int potential_moves;
    private int x_direction;
    private int y_direction;
    private Square pieceToMove;
    private boolean pieceKilled;
    
    public PlayerInput(Player player, int potential_moves, int x_direction, int y_direction, Square pieceToMove, boolean pieceKilled) {
        this.player = player;
        this.potential_moves = potential_moves;
        this.x_direction = x_direction;
        this.y_direction = y_direction;
        this.pieceToMove = pieceToMove;
    }
<<<<<<< HEAD

=======
   
>>>>>>> Development
    public boolean playerQuit (String input)
    {
        boolean playerQuits = false;
        
        if (input.equals("x"))
        {
            playerQuits = true;
        }
        return playerQuits;
    }

    /**
     * This prints the direction rules fo the piece selected by the user through their x and y locations.
     * 
     * @param board: The two-dimensional square array that represents the board.
     */
    public String directionPrint (Square[][] board)
    {
        String directionString = "";
        
        if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(Pawn.class))
        {
            directionString = "You can move this piece forward\nand diagonally to the left or right.\nIt can only move diagonally if there\nis an enemy piece in this location.";
            
        }
        else if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(Rook.class))
        {
            directionString = "You can move this piece) \nnorth \neast \nsouth \nwest.";
           
        }
        else if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(Knight.class))
        {
            directionString = "This piece moves in an L-Shape in the following directions: \nNorth North East \nNorth East East \nSouth East East \nSouth South East\nSouth South West\nSouth West West\nNorth West West\nNorth North West";
           
        }
        else if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(Bishop.class))
        {
            directionString = "You can move this piece in the following directions\nNorth East \nSouth East \nSouth West \nNorth West ";
            
        }
        else if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(Queen.class))
        {
            directionString = "This piece moves in the following directions: \nNorth \nNorth East \nEast \nSouth East \nSouth \nSouth West \nWest \nNorth West ";
            
        }
        else if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(King.class))
        {
            directionString = "This piece moves one space in the following directions: \nNorth \nNorth East \nEast \nSouth East \nSouth \nSouth West \nWest \nNorth West ";
            
        }
        
        return directionString;
    }
    
    public boolean appropriatePiece (Square[][] board, Square pieceToMove)
    {
        this.setPieceToMove(pieceToMove);
        boolean appropriateToMove = false;
        
        if (board[this.getPieceToMove().getX_location()][this.getPieceToMove().getY_location()].getPiece() != null)
        {
            if (board[this.getPieceToMove().getX_location()][this.getPieceToMove().getY_location()].getPiece().colour == this.getPlayer().getColour())
            {
                appropriateToMove = true;
            }
        }
        
        return appropriateToMove;
    }
    
    /**
     * This checks the direction of the piece based on the second set of coordinates inputted by the user. If it is appropriate, it returns a positive boolean. If not, it will return false.
     * 
     * @param board
     * @param directionInput
     * @return 
     */
    public boolean directionCheck (Square[][] board)
    {
        boolean directionOkay = false;
        
        if (board[this.getPieceToMove().getX_location()][this.getPieceToMove().getY_location()].getPiece().getClass().equals(Pawn.class))
        {
            if (this.getPieceToMove().getPiece().getColour() == PlayerColour.WHITE)
            {
                if ((this.getPieceToMove().getX_location() - 1) == (this.getX_direction()) && (this.getPieceToMove().getY_location() + 1) == this.getY_direction())
                {
                    if (board[this.getX_direction()][this.getY_direction()].getPiece() != null && board[this.getX_direction()][this.getY_direction()].getPiece().getColour() != this.player.getColour())
                    {
                        directionOkay = true;
                        this.getPieceToMove().getPiece().direction = Direction.NORTHWEST;
                    }
                }
                else if ((this.getPieceToMove().getX_location() + 1) == (this.getX_direction()) && (this.getPieceToMove().getY_location() + 1) == this.getY_direction())
                {
                    if (board[this.getX_direction()][this.getY_direction()].getPiece() != null && board[this.getX_direction()][this.getY_direction()].getPiece().getColour() != this.player.getColour())
                    {
                        directionOkay = true;
                        this.getPieceToMove().getPiece().direction = Direction.NORTHEAST;
                    }
                }
                else if ((this.getPieceToMove().getY_location() + 1) == this.getY_direction())
                {
                    directionOkay = true;
                    this.getPieceToMove().getPiece().direction = Direction.NORTH;
                }
            }
            else if (this.getPieceToMove().getPiece().getColour() == PlayerColour.BLACK)
            {
                if ((this.getPieceToMove().getX_location() - 1) == (this.getX_direction()) && (this.getPieceToMove().getY_location() - 1) == this.getY_direction())
                {
                    if (board[this.getX_direction()][this.getY_direction()].getPiece() != null && board[this.getX_direction()][this.getY_direction()].getPiece().getColour() != this.player.getColour())
                    {
                        directionOkay = true;
                        this.getPieceToMove().getPiece().direction = Direction.SOUTHWEST;
                    }
                }
                else if ((this.getPieceToMove().getX_location() + 1) == (this.getX_direction()) && (this.getPieceToMove().getY_location() - 1) == this.getY_direction())
                {
                    if (board[this.getX_direction()][this.getY_direction()].getPiece() != null && board[this.getX_direction()][this.getY_direction()].getPiece().getColour() != this.player.getColour())
                    {
                        directionOkay = true;
                        this.getPieceToMove().getPiece().direction = Direction.SOUTHEAST;
                    }
                }
                else if ((this.getPieceToMove().getY_location() - 1) == this.getY_direction())
                {
                    directionOkay = true;
                    this.getPieceToMove().getPiece().direction = Direction.SOUTH;
                }
            }
        }
        else if (board[this.getPieceToMove().getX_location()][this.getPieceToMove().getY_location()].getPiece().getClass().equals(Rook.class))
        {
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
        }
        else if (board[this.getPieceToMove().getX_location()][this.getPieceToMove().getY_location()].getPiece().getClass().equals(Knight.class))
        {
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
            else if (((this.getPieceToMove().getX_location() - 1) == (this.getX_direction())) && ((this.getPieceToMove().getY_location() - 2) == (this.getY_direction())))
            {
                directionOkay = true;
                this.getPieceToMove().getPiece().direction = Direction.NORTHNORTHWEST;
            }
        }
        else if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(Bishop.class))
        {
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
                if ((this.getPieceToMove().getX_location() - this.getX_direction()) == (this.getPieceToMove().getY_location() - this.getY_direction()))
                {
                    directionOkay = true;
                    this.getPieceToMove().getPiece().direction = Direction.NORTHWEST;
                }
            }
        }
        else if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(Queen.class))
        {
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
                if ((this.getPieceToMove().getX_location() - this.getX_direction()) == (this.getPieceToMove().getY_location() - this.getY_direction()))
                {
                    directionOkay = true;
                    this.getPieceToMove().getPiece().direction = Direction.NORTHWEST;
                }
            }
        }
        else if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(King.class))
        {
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
                if ((this.getPieceToMove().getX_location() - this.getX_direction()) == (this.getPieceToMove().getY_location() - this.getY_direction()))
                {
                    directionOkay = true;
                    this.getPieceToMove().getPiece().direction = Direction.NORTHWEST;
                }
            }
        }
        
        return directionOkay;
    }
    
    public boolean killAndTake(Square[][] board, Square deadPieceStore)
    {
        boolean opposingFound = false;
        
        if (this.getPieceToMove().getPiece().getClass().equals(Pawn.class))
        {
            if (this.getPieceToMove().getPiece().colour.equals(PlayerColour.WHITE))
            {
                if (this.getPieceToMove().getPiece().direction == Direction.NORTHWEST)
                {
                    deadPieceStore.setX_location(this.getPieceToMove().getX_location() - 1);
                    deadPieceStore.setY_location(this.getPieceToMove().getX_location() + 1);
                    board[this.getX_direction()][this.getY_direction()].setPiece(this.getPieceToMove().getPiece());
                    opposingFound = true;
                }
                else if (this.getPieceToMove().getPiece().direction == Direction.NORTHEAST)
                {
                    deadPieceStore.setX_location(this.getPieceToMove().getX_location() + 1);
                    deadPieceStore.setY_location(this.getPieceToMove().getX_location() + 1);
                    board[this.getX_direction()][this.getY_direction()].setPiece(this.getPieceToMove().getPiece());
                    opposingFound = true;
                }
            }
            else if (this.getPieceToMove().getPiece().colour.equals(PlayerColour.BLACK))
            {
                if (this.getPieceToMove().getPiece().direction == Direction.SOUTHWEST)
                {
                    deadPieceStore.setX_location(this.getPieceToMove().getX_location() - 1);
                    deadPieceStore.setY_location(this.getPieceToMove().getX_location() - 1);
                    board[this.getX_direction()][this.getY_direction()].setPiece(this.getPieceToMove().getPiece());
                    opposingFound = true;
                }
                else if (this.getPieceToMove().getPiece().direction == Direction.SOUTHEAST)
                {
                    deadPieceStore.setX_location(this.getPieceToMove().getX_location() - 1);
                    deadPieceStore.setY_location(this.getPieceToMove().getX_location() + 1);
                    board[this.getX_direction()][this.getY_direction()].setPiece(this.getPieceToMove().getPiece());
                    opposingFound = true;
                }
            }
        }
        else if (this.getPieceToMove().getPiece().getClass().equals(Rook.class))
        {
            if ((this.getPieceToMove().getX_location() > this.getX_direction()) && (this.getPieceToMove().getY_location() == this.getY_direction()))
            {
                if (board[this.getX_direction()][this.getY_direction()].getPiece() != null && board[this.getX_direction()][this.getY_direction()].getPiece().colour != this.getPlayer().getColour())
                {
                    boolean moveChecker = this.getPieceToMove().getPiece().CheckMove(piece, this.getX_direction(), this.getY_direction(), this.getPieceToMove(), board);
                }
            }
        }
        
        return opposingFound;
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

   

    /**
     * @return the potential_moves
     */
    public int getPotential_moves() {
        return potential_moves;
    }

    /**
     * @param potential_moves the potential_moves to set
     */
    public void setPotential_moves(int potential_moves) {
        this.potential_moves = potential_moves;
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
     * @return the pieceKilled
     */
    public boolean isPieceKilled() {
        return pieceKilled;
    }

    /**
     * @param pieceKilled the pieceKilled to set
     */
    public void setPieceKilled(boolean pieceKilled) {
        this.pieceKilled = pieceKilled;
    }

}
