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
    
    /**
     * Prints the number of moves the piece can take based on its class. It also informs the user if their king is capable of castling.
     * 
     * @param board 
     */
    public void numMovesPrint (Square[][] board)
    {
        if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(Pawn.class))
        {
            System.out.println("This piece can two spaces forward on the first turn and then one space forward for further turns. It can also move diagonally to the left or right one space");
            System.out.println("Please input a number according to the rules previously mentioned.");
        }
        else if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(Rook.class))
        {
            System.out.println("This piece can move up to 7 spaces in the aforementioned directions.");
            System.out.println("Please input a number according to the rules previously mentioned.");
        }
        else if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(Knight.class))
        {
            System.out.println("Because this piece does not incorporate the number of spaces moved, the number of moves is not necessary.");
            System.out.println("Please input 0.");
        }
        else if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(Bishop.class))
        {
            System.out.println("This piece can move up to 7 spaces in the aforementioned directions.");
            System.out.println("Please input a number according to the rules previously mentioned.");  
        }
        else if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(Queen.class))
        {
            System.out.println("This piece can move up to 7 spaces in the aforementioned directions.");
            System.out.println("Please input a number according to the rules previously mentioned.");
        }
        else if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(King.class))
        {
            System.out.println("This piece moves one space in the following directions: \nNorth\nNorth East\nEast\nSouth East\nSouth\nSouth West\nWest\nNorth West");
            System.out.println("Please input 1.");
            
            castlingMove kingCheck = new castlingMove(board[this.getX_direction()][this.getY_direction()].getPiece(), this.getX_direction(), this.getY_direction());
            int kingChecker = kingCheck.checkforCastling(board[this.getX_direction()][this.getY_direction()].getPiece(), this.getX_direction(), this.getY_direction(), board);
            
            switch (kingChecker) {
                case 1:
                    System.out.println("You can castle to the left. Please input 2 for this case.");
                    break;
                case 2:
                    System.out.println("You can castle to the right. Please input 3 for this case");
                    break;
                case 3:
                    System.out.println("You can castle to the left or right. Please input 2 or 3 for the respective direction you want to castle.");
                    break;
                default:
                    break;
            }
            
        }
    }
    
    /**
     * Checks and then changes the potential moves of the piece to be the number inputted by the user. If it is within the conditions, it is acceptable.
     * In the case of the king, if castling is an option, the castling input is accepted.
     * 
     * @param board
     * @param userMoves
     * @return 
     */
    public boolean numMovesCheck (Square[][] board, int userMoves)
    {
        boolean movesChecked = false;
        
        if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(Pawn.class))
        {
            
            if (userMoves > 0 && userMoves < 3)
            {
                if (userMoves <= board[this.getX_direction()][this.getY_direction()].getPiece().potential_moves)
                {
                    System.out.println("This piece can move this amount of steps. Checking route...");
                    movesChecked = true;
                    this.setPotential_moves(userMoves);
                }
                
            }
            else 
            {
                System.out.println("Sorry, this piece cannot move that number of steps. Please input a valid number for this piece.");
            }
            
            
        }
        else if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(Rook.class))
        {
            if (userMoves > 0 && userMoves < 8)
            {
                System.out.println("This piece can move this amount of steps. Checking route...");
                movesChecked = true;
                this.setPotential_moves(userMoves);
            }
            else
            {
                System.out.println("Sorry, this piece cannot move that number of steps. Please input a valid number for this piece");
            }
        }
        else if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(Knight.class))
        {
            if (userMoves == 0)
            {
                System.out.println("As this is the knight, only the direction matters. Checking route...");
                movesChecked = true;
                this.setPotential_moves(userMoves);
            }
            else 
            {
                System.out.println("As stated previously, please input 0 for the number of steps you want the knight to take.");
            }
        }
        else if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(Bishop.class))
        {
            if (userMoves > 0 && userMoves < 8)
            {
                System.out.println("This piece can move this amount of steps. Checking route...");
                movesChecked = true;
                this.setPotential_moves(userMoves);
            }
            else
            {
                System.out.println("Sorry, this piece cannot move that number of steps. Please input a valid number for this piece.");
            }
        }
        else if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(Queen.class))
        {
            if (userMoves > 0 && userMoves < 8)
            {
                System.out.println("This piece can move this amount of steps. Checking route...");
                movesChecked = true;
                this.setPotential_moves(userMoves);
            }
            else
            {
                System.out.println("Sorry, this piece cannot move that number of steps. Please input a valid number for this piece.");
            }
        }
        else if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(King.class))
        {
            if (userMoves == 1)
            {
                System.out.println("This piece can move this amount of steps. Checking route...");
                movesChecked = true;
                this.setPotential_moves(userMoves);
            }
            else
            {
                castlingMove kingCheck = new castlingMove(board[this.getX_direction()][this.getY_direction()].getPiece(), this.getX_direction(), this.getY_direction());
                int kingChecker = kingCheck.checkforCastling(board[this.getX_direction()][this.getY_direction()].getPiece(), this.getX_direction(), this.getY_direction(), board);
                
                if (kingChecker == 1)
                {
                    if (userMoves == 2)
                    {
                        System.out.println("You can castle at this instance.");
                        movesChecked = true;
                        this.setPotential_moves(userMoves);
                    }
                    else
                    {
                        System.out.println("Sorry, this piece cannot move that number of steps. Please input a valid number for this piece.");
                    }
                }
                else if (kingChecker == 2)
                {
                    if (userMoves == 3)
                    {
                        System.out.println("You can castle at this instance.");
                        movesChecked = true;
                        this.setPotential_moves(userMoves);
                    }
                    else
                    {
                        System.out.println("Sorry, this piece cannot move that number of steps. Please input a valid number for this piece.");
                    }
                }
                else if (kingChecker == 3)
                {
                    if (userMoves == 2 || userMoves == 3)
                    {
                        System.out.println("You can castle at this instance.");
                        movesChecked = true;
                        this.setPotential_moves(userMoves);
                    }
                    else
                    {
                        System.out.println("Sorry, this piece cannot move that number of steps. Please input a valid number for this piece.");
                    }
                }
                else
                {
                    System.out.println("Sorry, you cannot castle this way. Please input a valid number.");
                }
            
            }
        }
        
        return movesChecked;
    }
    
    
    /**
     * Checks if the piece selected by the player at this point is the same colour as the player's colour.
     * 
     * @param player: The current player
     * @param board
     * @return 
     */
    public boolean sameColour(Player player, Square[][] board)
    {
        boolean sameColour = false;
        
        
        if (board[this.getX_direction()][this.getY_direction()].getPiece() != null)
        {
            if (board[this.getX_direction()][this.getY_direction()].getPiece().colour != this.getPlayer().getColour())
            {
                System.out.println("You cannot move this piece, it is not your colour. Please select a different piece.");
            }
            else
            {
                sameColour = true;
            }
            
        }
        else
        {
            System.out.println("There is not piece here, please pick a spot with a piece that you can move.");
        }
        
        
        return sameColour;
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
