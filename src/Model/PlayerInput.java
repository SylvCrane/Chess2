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
    
    public PlayerInput(Player player, int potential_moves, int x_direction, int y_direction, Square pieceToMove) {
        this.player = player;
        this.potential_moves = potential_moves;
        this.x_direction = x_direction;
        this.y_direction = y_direction;
        this.pieceToMove = pieceToMove;
    }

    /**
     * This method identifies if the piece can be moved by the current player by comparing the colour of the piece to the player's assigned colour.
     * 
     * @param board: The chess board
     * @param pieceToMove: The current piece that needs to be moved.
     * @return 
     */
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
     * This checks the direction of the piece based on the second chess button selected by the user. If it is appropriate, it returns a positive boolean. If not, it will return false.
     * 
     * @param board
     * @param directionInput
     * @return 
     */
    public boolean directionCheck (Square[][] board)
    {
        boolean directionOkay = false;
        DirectionPieces checkDirection = new DirectionPieces(this.getPieceToMove(), this.getX_direction(), this.getY_direction(), this.getPlayer());
        
        if (board[this.getPieceToMove().getX_location()][this.getPieceToMove().getY_location()].getPiece().getClass().equals(Pawn.class))
        {
            directionOkay = checkDirection.directionPawn(board);
        }
        else if (board[this.getPieceToMove().getX_location()][this.getPieceToMove().getY_location()].getPiece().getClass().equals(Rook.class))
        {
            directionOkay = checkDirection.directionRook(board);
        }
        else if (board[this.getPieceToMove().getX_location()][this.getPieceToMove().getY_location()].getPiece().getClass().equals(Knight.class))
        {
            directionOkay = checkDirection.directionKnight(board);
        }
        else if (board[this.getPieceToMove().getX_location()][this.getPieceToMove().getY_location()].getPiece().getClass().equals(Bishop.class))
        {
            directionOkay = checkDirection.directionBishop(board);
        }
        else if (board[this.getPieceToMove().getX_location()][this.getPieceToMove().getY_location()].getPiece().getClass().equals(Queen.class))
        {
            directionOkay = checkDirection.directionQueen(board);
        }
        else if (board[this.getPieceToMove().getX_location()][this.getPieceToMove().getY_location()].getPiece().getClass().equals(King.class))
        {
            directionOkay = checkDirection.directionKing(board);
        }
        
        return directionOkay;
    }
    
    
    /**
     * This method checks if the destination of the piece to move has an opposing piece. If this is the case, the dead piece and its original locations are stored in the square.
     * 
     * @param board
     * @param deadPieceStore
     * @return true if an opposing piece was found.
     */
    public boolean killAndTake(Square[][] board, Square deadPieceStore)
    {
        boolean opposingFound = false;
        
        KillandTakePieces piecesKill = new KillandTakePieces(this.getX_direction(), this.getY_direction());
        
        if (board[this.getX_direction()][this.getY_direction()].getPiece() != null)
        {
            if (board[this.getX_direction()][this.getY_direction()].getPiece().colour != this.getPieceToMove().getPiece().colour)
            {
                if (this.getPieceToMove().getPiece().getClass().equals(Pawn.class))
                {
                    opposingFound = piecesKill.killAndTakePawn(board, this.getPieceToMove(), deadPieceStore);
                }
                else if (this.getPieceToMove().getPiece().getClass().equals(Rook.class))
                {
                    opposingFound = piecesKill.killAndTakeRook(board, this.getPieceToMove(), deadPieceStore);
                }
                else if (this.getPieceToMove().getPiece().getClass().equals(Knight.class))
                {
                    opposingFound = piecesKill.killAndTakeKnight(board, this.getPieceToMove(), deadPieceStore);
                }
                else if (this.getPieceToMove().getPiece().getClass().equals(Bishop.class))
                {
                    opposingFound = piecesKill.killAndTakeBishop(board, this.getPieceToMove(), deadPieceStore);
                }
                else if (this.getPieceToMove().getPiece().getClass().equals(Queen.class))
                {
                    opposingFound = piecesKill.killAndTakeQueen(board, this.getPieceToMove(), deadPieceStore);
                }
                else if (this.getPieceToMove().getPiece().getClass().equals(King.class))
                {
                    opposingFound = piecesKill.killAndTakeKing(board, this.getPieceToMove(), deadPieceStore);
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
