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
    
    public PlayerInput(Player player, int potential_moves, int x_direction, int y_direction) {
        this.player = player;
        this.potential_moves = potential_moves;
        this.x_direction = x_direction;
        this.y_direction = y_direction;
    }
    
    /**
     * Boolean method that checks if the input is the quit input, being 'x'. This is important to allow the user to quit the program at any point.
     * 
     * @param input
     * @return 
     */
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
    public void directionPrint (Square[][] board)
    {
        if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(Pawn.class))
        {
            System.out.println("You can move this piece forward (1), and diagonally to the left (2) or right (3). It can only move diagonally if there is an enemy piece in this location..");
            System.out.println("To move this piece in any of these directions, input a number from 1 -> 3, each number corresponding to the directions previously mentioned. ");
        }
        else if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(Rook.class))
        {
            System.out.println("You can move this piece) \nnorth (1) \neast (2) \nsouth (3) \nwest (4).");
            System.out.println("To move this piece in any of these directions, input a number from 1 -> 4, each number corresponding to the directions previously mentioned.");
        }
        else if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(Knight.class))
        {
            System.out.println("This piece moves in an L-Shape in the following directions: \nNorth North East (1)\nNorth East East (2)\nSouth East East (3)\nSouth South East(4)\nSouth South West(5)\nSouth West West(6)\nNorth West West(7)\nNorth North West(8)");
            System.out.println("To move this piece in any of these directions, input a number from 1->8, each number corresponding to the directions previously mentioned.");
        }
        else if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(Bishop.class))
        {
            System.out.println("You can move this piece in the following directions\nNorth East (1)\nSouth East (2)\nSouth West (3)\nNorth West (4)");
            System.out.println("To move this piece in any of these directions, input a number from 1 -> 4, each number corresponding to the directions previously mentioned.");  
        }
        else if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(Queen.class))
        {
            System.out.println("This piece moves in the following directions: \nNorth (1)\nNorth East (2)\nEast (3)\nSouth East (4)\nSouth (5)\nSouth West (6)\nWest (7)\nNorth West (8)");
            System.out.println("To move this piece in any of these directions, input a number from 1 -> 8, each nubmer corresponding to the directions previously mentioned.");
        }
        else if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(King.class))
        {
            System.out.println("This piece moves one space in the following directions: \nNorth (1)\nNorth East (2)\nEast (3)\nSouth East (4)\nSouth (5)\nSouth West (6)\nWest (7)\nNorth West (8)");
            System.out.println("To move this piece in any of these directions, input a number from 1 -> 8, each nubmer corresponding to the directions previously mentioned.");
        }
    }
    
    /**
     * This changed the direction of the piece based on the number the user inputted. If it is appropriate, it returns a positive boolean. If not, it will return false.
     * 
     * @param board
     * @param directionInput
     * @return 
     */
    public boolean directionChange (Square[][] board, int directionInput)
    {
        boolean directionOkay = false;
        
        if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(Pawn.class))
        {
            if (directionInput == 2 || directionInput == 3)
            {
               KillandTake opposingCheck = new KillandTake(board[this.getX_direction()][this.getY_direction()].getPiece(), this.getX_direction(), this.getY_direction(), 1);
               
               //As stated in this method's comment declaration, it needs to check at this point in order to verify if the pawn can move diagonally or not.
               if (opposingCheck.CheckForOpposingPawn(board[this.getX_direction()][this.getY_direction()].getPiece(), this.getX_direction(), this.getY_direction(), 1, board, directionInput))
               {
                   System.out.println("You can move this piece diagonally");
                   directionOkay = true;
                   
                   switch (directionInput)
                   {
                       case 2:
                           if (board[this.getX_direction()][this.getY_direction()].getPiece().colour == PlayerColour.WHITE)
                           {
                               board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.NORTHWEST;
                           }
                           else if (board[this.getX_direction()][this.getY_direction()].getPiece().colour == PlayerColour.BLACK)
                           {
                               board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.SOUTHWEST;
                           }
                           break;
                       case 3:
                           if (board[this.getX_direction()][this.getY_direction()].getPiece().colour == PlayerColour.WHITE)
                           {
                               board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.NORTHEAST;
                           }
                           else if (board[this.getX_direction()][this.getY_direction()].getPiece().colour == PlayerColour.BLACK)
                           {
                               board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.SOUTHEAST;
                           }
                           break;
                   }
               }
               else
               {
                   System.out.println("Sorry, you cannot move the pawn this way");
               }
            }
            else if (directionInput == 1)
            {
                System.out.println("You can move the piece this way");
                directionOkay = true;
                
                if (board[this.getX_direction()][this.getY_direction()].getPiece().colour == PlayerColour.WHITE)
                {
                    board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.NORTH;
                }
                else if (board[this.getX_direction()][this.getY_direction()].getPiece().colour == PlayerColour.BLACK)
                {
                    board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.SOUTH;
                }
            }
            else
            {
                System.out.println("Please enter a valid input for the direction.");
            }
        }
        else if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(Rook.class))
        {
            if (directionInput > 0 && directionInput < 5)
            {
                System.out.println("You can move the piece this way");
                directionOkay = true;
                
                switch (directionInput)
                {
                    case 1:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.NORTH;
                        break;
                    case 2:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.EAST;
                        break;
                    case 3:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.SOUTH;
                        break;
                    case 4:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.WEST;
                        break;
                }
            }
            else
            {
                System.out.println("Please input a valid input for the direction.");
            }
        }
        else if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(Knight.class))
        {
            if (directionInput > 0 && directionInput < 9)
            {
                System.out.println("You can move the piece this way");
                directionOkay = true;
                
                switch (directionInput)
                {
                    case 1:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.NORTHNORTHEAST;
                        break;
                    case 2:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.NORTHEASTEAST;
                        break;
                    case 3:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.SOUTHEASTEAST;
                        break;
                    case 4:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.SOUTHSOUTHEAST;
                        break;
                    case 5:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.SOUTHSOUTHWEST;
                        break;
                    case 6:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.SOUTHWESTWEST;
                        break;
                    case 7:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.NORTHWESTWEST;
                        break;
                    case 8:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.NORTHNORTHWEST;
                        break;
                }
            }
            else
            {
                System.out.println("Please input a valid input for the direction.");
            }
        
        }
        else if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(Bishop.class))
        {
            if (directionInput > 0 && directionInput < 5)
            {
                System.out.println("You can move the piece this way");
                directionOkay = true;
                
                switch (directionInput)
                {
                    case 1:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.NORTHEAST;
                        break;           
                    case 2:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.SOUTHEAST;
                        break;
                    case 3:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.SOUTHWEST;
                        break;
                    case 4:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.NORTHWEST;
                        break;
                }
            }
            else 
            {
                System.out.println("Please input a valid input for the direction.");
            }
        }
        else if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(Queen.class))
        {
            if (directionInput > 0 && directionInput < 9)
            {
                System.out.println("You can move the piece this way");
                directionOkay = true;
                
                switch (directionInput)
                {
                    case 1:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.NORTH;
                        break;
                    case 2:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.NORTHEAST;
                        break;
                    case 3:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.EAST;
                        break;
                    case 4:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.SOUTHEAST;
                        break;
                    case 5:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.SOUTH;
                        break;
                    case 6:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.SOUTHWEST;
                        break;
                    case 7:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.WEST;
                        break;
                    case 8:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.NORTHWEST;
                        break;
                }
            }
            else
            {
                System.out.println("Please input a valid input for the direction.");
            }
                    
        }
        else if (board[this.getX_direction()][this.getY_direction()].getPiece().getClass().equals(King.class))
        {
            if (directionInput > 0 && directionInput < 9)
            {
                System.out.println("You can move the piece this way");
                directionOkay = true;
                
                switch (directionInput)
                {
                    case 1:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.NORTH;
                        break;
                    case 2:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.NORTHEAST;
                        break;
                    case 3:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.EAST;
                        break;
                    case 4:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.SOUTHEAST;
                        break;
                    case 5:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.SOUTH;
                        break;
                    case 6:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.SOUTHWEST;
                        break;
                    case 7:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.WEST;
                        break;
                    case 8:
                        board[this.getX_direction()][this.getY_direction()].getPiece().direction = Direction.NORTHWEST;
                        break;
                }
            }
            else
            {
                System.out.println("Please input a valid input for the direction.");
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
     * Checks if the square location selected by the user is out of bounds. If this is the case, it returns false. It is in a try() function as once it catched
     * the out of bounds exception, it returns the catch code.
     * 
     * @param board
     * @return 
     */
    public boolean squareOutOfBounds(Square[][] board)
    {
        boolean validSquare = false;
        
        try{
            if (board[this.getX_direction()][this.getY_direction()] != null)
            {
                System.out.println("There is a square here");
                validSquare = true;
            }
        }
        catch (Exception e)
        {
            System.out.println("This is not a valid square");
        }
        
        return validSquare;
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
    
    
    
    
    
}
