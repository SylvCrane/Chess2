/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author navjo
 */
public class Player {
    /**
     * The name of the player
     */
    private String name;
    
    /**
     * The player's colour, used to select pieces exclusive to this player.
     */
    private PlayerColour colour;
    
    /**
     * The player's score, which is updated after the game. This only changed once at the end. If the player wins, it is incremented by one. Otherwise, it changed to 0.
     */
    private int score;
    
    public Player(String name, PlayerColour colour, int score)
    {
        this.name = name;
        this.colour = colour;
        this.score = score;
    }
    
    /**
     * This stores the pieces that the player can currently move at the start of every turn, changing dynamically in regard to position changes. 
     * 
     * @param player: The current player
     * @param playerPieces: A collection that stores the player's pieces
     * @param board: A two-dimensional square array
     * @throws IOException 
     */
    public void resetPlayerPieces (Player player, HashSet<Piece> playerPieces, Square[][] board) throws IOException
    {
        playerPieces.clear();
        this.setColour(player.getColour());
        
        for (int yIndex = 0; yIndex < 8; yIndex++)
        {
            for (int xIndex = 0; xIndex < 8; xIndex++ )
            {
                if ((board[xIndex][yIndex].getPiece() != null) && (board[xIndex][yIndex].getPiece().colour == player.getColour()))
                {
                    playerPieces.add(board[xIndex][yIndex].getPiece());
                }
            }
        }
        
        /**
         * This instance of file input and output makes it substantially easier to print the pieces, 
         * as otherwise a printing chain would be required elsewhere.
         */
        fileInputOutput playerIO = new fileInputOutput(null, null);
        playerIO.writePlayerPieces(playerPieces, board);
        
    }
    
    /**
     * This switches the nullPlayer to the values of the playerToSwitch. It is mainly used to switch who teh current player is.
     * 
     * @param nullPlayer: The player that needs to switch out
     * @param playerToSwitch: The player that needs to switch in
     */
    public void switchPlayer(Player nullPlayer, Player playerToSwitch)
    {
        nullPlayer.setName(playerToSwitch.getName());
        nullPlayer.setColour(playerToSwitch.getColour());
        nullPlayer.setScore(playerToSwitch.getScore());
    }
    
    
    

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the colour
     */
    public PlayerColour getColour() {
        return colour;
    }

    /**
     * @param colour the colour to set
     */
    public void setColour(PlayerColour colour) {
        this.colour = colour;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }
    
    @Override
    public String toString()
    {
        return this.getName() + " " + this.score;
    }
    
    
        
    
}
