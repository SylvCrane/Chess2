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
    
    private Square[][] board;
    private boolean[] chequeBoolean;
    
    public chequePackage(Square[][] board, boolean[] chequeBoolean)
    {
        board = this.board;
        chequeBoolean = this.chequeBoolean;
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
    
    
    
}
