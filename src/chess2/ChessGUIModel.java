/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess2;

import Model.Player;
import Model.PlayerInput;
import Model.Square;
import java.util.Observable;

/**
 *
 * @author navjo
 */
public class ChessGUIModel extends Observable{
    
    private Player player1; 
    private Player player2;
    private Player currentPlayer;
    private Square[][] board;
    private PlayerInput input;
    private Square pieceToMove;
    private Square destination;
    
    public void instantiatePlayer(Player player)
    {
        if (this.getPlayer1() == null)
        {
            this.setPlayer1(player);
        }
        else
        {
            this.setPlayer2(player);
        }
        
        
    }
    
    public void setCurrentPlayer()
    {
        if (this.currentPlayer == null)
        {
          this.currentPlayer = this.player1;  
        }
        else if (this.currentPlayer == this.player1)
        {
            this.currentPlayer = this.player2;
        }
        else if (this.currentPlayer == this.player2)
        {
            this.currentPlayer = this.player1;
        }   
        
        notifyObservers(this.currentPlayer);
    }
      
    public void selectPiece(int x, int y)
    {
        this.setPieceToMove(this.board[x][y]);
        notifyObservers(this.getPieceToMove());
    }
    
    public void selectDestination(int x, int y)
    {
        this.setDestination(this.board[x][y]);
        notifyObservers(this.getDestination());
    }

    /**
     * @return the player1
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     * @param player1 the player1 to set
     */
    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    /**
     * @return the player2
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * @param player2 the player2 to set
     */
    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    /**
     * @return the currentPlayer
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * @param currentPlayer the currentPlayer to set
     */
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    /**
     * @return the board
     */
    public Square[][] getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(Square[][] board) {
        this.board = board;
    }

    /**
     * @return the input
     */
    public PlayerInput getInput() {
        return input;
    }

    /**
     * @param input the input to set
     */
    public void setInput(PlayerInput input) {
        this.input = input;
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
     * @return the destination
     */
    public Square getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(Square destination) {
        this.destination = destination;
    }
}
