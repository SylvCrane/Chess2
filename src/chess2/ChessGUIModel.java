/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess2;

import Model.Cheque;
import Model.Player;
import Model.PlayerInput;
import Model.Square;
import Model.chequePackage;
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
    private Square deadPiece;
    private chequePackage chequePackage;
    
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
    
    public void newPlayerTurn()
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
        
        
    }
      
    public void selectPiece(int x, int y)
    {
        PlayerInput input = new PlayerInput(this.currentPlayer, this.board[x][y].getPiece().potential_moves, 0, 0, this.board[x][y]);
        this.setInput(input);
        boolean appropriate = this.getInput().appropriatePiece(this.board, this.board[x][y]);
        
        if (!appropriate)
        {
            this.setPieceToMove(null);
        }
        else
        {
            this.setPieceToMove(this.board[x][y]);
        }
        
        setChanged();
        notifyObservers(this.getPieceToMove());
    }
    
    public void selectDestination(int x, int y)
    {
        this.input.setX_direction(x);
        this.input.setY_direction(y);
        
        boolean directionOkay = this.input.directionCheck(this.board);
        
        if (directionOkay)
        {
            this.deadPiece = new Square(null, 0, 0);
            boolean killAndTake = this.input.killAndTake(this.board, this.deadPiece);
            
            if (killAndTake)
            {
                setChanged();
                notifyObservers(this.board);
            }
            else
            {
                int checker = this.getPieceToMove().getPiece().CheckMove(x, y, this.getPieceToMove(), this.getBoard());
                
                if (checker == 1)
                {
                    this.getPieceToMove().getPiece().MakeMove(x, y, this.getPieceToMove(), this.getBoard());
                    setChanged();
                    notifyObservers(this.board);
                }
                else
                {
                    setChanged();
                    notifyObservers(null);
                }
            }
        }
        else
        {
            setChanged();
            this.notifyObservers(null);
        }     
    }
    
    public void chequePlayer()
    {
        this.setChequePackage(new chequePackage(this.getBoard(), new boolean[2]));
        
        boolean[] cheque = new boolean[2];
        
        this.getChequePackage().setChequeBoolean(cheque);
        
        Player oppositePlayer;
        
        if (this.currentPlayer == this.player1)
        {
            oppositePlayer = this.player2;
        }
        else
        {
            oppositePlayer = this.player1;
        }
        
        Cheque youreInCheque = new Cheque(this.currentPlayer);
        youreInCheque.findKing(this.board, this.currentPlayer);
        this.getChequePackage().getChequeBoolean()[0] = youreInCheque.checkForCheque(this.board, this.currentPlayer);
        
        if (this.getChequePackage().getChequeBoolean()[0])
        {
            this.board[this.getPieceToMove().getX_location()][this.getPieceToMove().getY_location()].setPiece(this.getPieceToMove().getPiece());
            
            if (this.deadPiece.getPiece() != null)
            {
                this.board[this.deadPiece.getX_location()][this.deadPiece.getY_location()].setPiece(this.deadPiece.getPiece());
            }
            setChanged();
            notifyObservers(this.getChequePackage());
        }
        else
        {
            Cheque theyreInCheque = new Cheque(oppositePlayer);
            theyreInCheque.findKing(this.board, oppositePlayer);
            boolean oppositePlayerInCheque = theyreInCheque.checkForCheque(this.board, oppositePlayer);
            
            if (oppositePlayerInCheque)
            {
                this.getChequePackage().getChequeBoolean()[1] = theyreInCheque.checkMate(this.board, oppositePlayer);
            }
            
            
            this.newPlayerTurn();
            setChanged();
            notifyObservers(this.getChequePackage());
        }
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

    /**
     * @return the deadPiece
     */
    public Square getDeadPiece() {
        return deadPiece;
    }

    /**
     * @param deadPiece the deadPiece to set
     */
    public void setDeadPiece(Square deadPiece) {
        this.deadPiece = deadPiece;
    }

    /**
     * @return the chequePackage
     */
    public chequePackage getChequePackage() {
        return chequePackage;
    }

    /**
     * @param chequePackage the chequePackage to set
     */
    public void setChequePackage(chequePackage chequePackage) {
        this.chequePackage = chequePackage;
    }
}
