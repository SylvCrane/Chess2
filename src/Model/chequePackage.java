/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author navjo
 */
public class chequePackage {
    
    //This class stores information to pass to the GUI of the program. Specifically, the board, cheque booleans and the players.
    //The booleans have an order. The first [0] is for a simple cheque. The second [1] is used for checkmate.
    
    private Square[][] board;
    private boolean[] chequeBoolean;
    private Player[] winnerAndLoser;
    
    public chequePackage(Square[][] board, boolean[] chequeBoolean, Player[] winnerAndLoser)
    {
        this.board = board;
        this.chequeBoolean = chequeBoolean;
        this.winnerAndLoser = winnerAndLoser;
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
     * @return the chequeBoolean
     */
    public boolean[] getChequeBoolean() {
        return chequeBoolean;
    }

    /**
     * @param chequeBoolean the chequeBoolean to set
     */
    public void setChequeBoolean(boolean[] chequeBoolean) {
        this.chequeBoolean = chequeBoolean;
    }

    /**
     * @return the winnerAndLoser
     */
    public Player[] getWinnerAndLoser() {
        return winnerAndLoser;
    }

    /**
     * @param winnerAndLoser the winnerAndLoser to set
     */
    public void setWinnerAndLoser(Player[] winnerAndLoser) {
        this.winnerAndLoser = winnerAndLoser;
    }
    
    
    
}
