/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Cheque;
import Model.Direction;
import Model.Piece;
import Model.Player;
import Model.PlayerColour;
import Model.PlayerInput;
import Model.Square;
import Model.chequePackage;
import Model.chessConnection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Observable;

/**
 *
 * @author navjo
 */
public class ChessGUIModel extends Observable{
    
    //This is the observable class of the program and is essentially where the hidden data for the game takes place.
    
    private Player player1; 
    private Player player2;
    private Player currentPlayer;
    private Square[][] board;
    private PlayerInput input;
    private Square pieceToMove;
    private Square destination;
    private Square deadPiece;
    private chequePackage chequePackage;
    private chessConnection chessConn;
    private HashSet<Piece> playerPieces;
    
    //This records the pieces from the connection and places them on the board based on the name of the piece and its color.
    public void instantiateBoard()
    {
        
        for (Piece currentPiece : this.getPlayerPieces())
        {
            if (currentPiece.pieceName.contains("Pawn"))
            {
                char currentPos = currentPiece.pieceName.charAt(9);
                int currentPosInt = Integer.valueOf(currentPos) - 48;
                
                if (currentPiece.colour.equals(PlayerColour.WHITE))
                {
                    this.board[currentPosInt - 1][1].setPiece(currentPiece);
                }
                else
                {
                    this.board[currentPosInt - 1][6].setPiece(currentPiece);
                }
            }
            else if (currentPiece.pieceName.contains("Rook"))
            {
                char currentPos = currentPiece.pieceName.charAt(9);
                int currentPosInt = Integer.valueOf(currentPos) - 48;
                
                if (currentPosInt == 1)
                {
                    currentPosInt = 0;
                }
                else
                {
                    currentPosInt = 7;
                }
                
                if (currentPiece.colour.equals(PlayerColour.WHITE))
                {
                    this.board[currentPosInt][0].setPiece(currentPiece);
                }
                else
                {
                    this.board[currentPosInt][7].setPiece(currentPiece);
                }
            }
            else if (currentPiece.pieceName.contains("Knight"))
            {
                char currentPos = currentPiece.pieceName.charAt(11);
                int currentPosInt = Integer.valueOf(currentPos) - 48;
                
                if (currentPosInt == 1)
                {
                    currentPosInt = 1;
                }
                else
                {
                    currentPosInt = 6;
                }
                
                if (currentPiece.colour.equals(PlayerColour.WHITE))
                {
                    this.board[currentPosInt][0].setPiece(currentPiece);
                }
                else
                {
                    this.board[currentPosInt][7].setPiece(currentPiece);
                }
            }
            else if (currentPiece.pieceName.contains("Bishop"))
            {
                char currentPos = currentPiece.pieceName.charAt(11);
                int currentPosInt = Integer.valueOf(currentPos) - 48;
                
                if (currentPosInt == 1)
                {
                    currentPosInt = 2;
                }
                else
                {
                    currentPosInt = 5;
                }
                
                if (currentPiece.colour.equals(PlayerColour.WHITE))
                {
                    this.board[currentPosInt][0].setPiece(currentPiece);
                }
                else
                {
                    this.board[currentPosInt][7].setPiece(currentPiece);
                }
            }
            else if (currentPiece.pieceName.contains("Queen"))
            {
                if (currentPiece.colour.equals(PlayerColour.WHITE))
                {
                    this.board[3][0].setPiece(currentPiece);
                }
                else
                {
                    this.board[3][7].setPiece(currentPiece);
                }
            }
            else if (currentPiece.pieceName.contains("King"))
            {
                if (currentPiece.colour.equals(PlayerColour.WHITE))
                {
                    this.board[4][0].setPiece(currentPiece);
                }
                else
                {
                    this.board[4][7].setPiece(currentPiece);
                }
            }
        }
    }

    //This will switch the player's turn or initialize the current player that is used throughout the program.
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
    
    //This is used to record the score of teh player if their score has been initlaized already in the database.
    public void familiarScore(Player player) throws SQLException
    {
        boolean playerFound = false;
        
        playerFound = this.chessConn.nameChecker(player);
        
        if (!playerFound)
        {
            player.setScore(0);
        }
    }
    
    /**
     * This is used to find if the current player can select a piece on the board. If it can, it will update the board. If not, nothing changes.
     * 
     * @param x
     * @param y 
     */
    public void selectPiece(int x, int y)
    {
        if(this.board[x][y].getPiece() == null)
        {
            this.setPieceToMove(null);
        }
        else
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
        }
        
        setChanged();
        notifyObservers(this.getPieceToMove());
    }
    
    /**
     * This determines if the destination of the player's piece is appropriate. If it is, it will then check
     * if the destination has an opposing piece. In either case, the move is made and the board is updated.
     * 
     * @param x
     * @param y 
     */
    public void selectDestination(int x, int y)
    {
        this.destination = new Square(null, 0, 0);
        
        this.input.setX_direction(x);
        this.input.setY_direction(y);
        
        boolean directionOkay = this.input.directionCheck(this.board);
        
        if (directionOkay)
        {
            this.destination.setX_location(x);
            this.destination.setY_location(y);
            this.destination.setPiece(this.getPieceToMove().getPiece());
            
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
    
    /**
     * This determines if either the current player or the opposing player are in cheque. If the current player is in cheque, they cannot finish their move and
     * any moved pieces, as well as killed pieces, are returned to their original positions. If the opposing player is in cheque, the program
     * will check further for a checkmate.
     * 
     * @throws SQLException 
     */
    public void chequePlayer() throws SQLException
    {
        this.setChequePackage(new chequePackage(this.getBoard(), new boolean[2], null));
        boolean[] cheque = new boolean[2];
        this.getChequePackage().setChequeBoolean(cheque);
        
        Player oppositePlayer;
        
        if (this.currentPlayer == this.player1)
        {
            oppositePlayer = this.player2;
            Player[] winnerAndLoser = new Player[2];
            winnerAndLoser[0] = this.player1;
            winnerAndLoser[1] = this.player2;
            this.getChequePackage().setWinnerAndLoser(winnerAndLoser);
        }
        else
        {
            oppositePlayer = this.player1;
            Player[] winnerAndLoser = new Player[2];
            winnerAndLoser[0] = this.player2;
            winnerAndLoser[1] = this.player1;
            this.getChequePackage().setWinnerAndLoser(winnerAndLoser);
        }
        
        Cheque youreInCheque = new Cheque(this.currentPlayer);
        youreInCheque.findKing(this.board, this.currentPlayer);
        this.getChequePackage().getChequeBoolean()[0] = youreInCheque.checkForCheque(this.board, this.currentPlayer);
        
        if (this.getChequePackage().getChequeBoolean()[0])
        {
            this.currentPlayer.setInCheque(true);
            
            this.board[this.getPieceToMove().getX_location()][this.getPieceToMove().getY_location()].setPiece(this.destination.getPiece());
            
            if (this.deadPiece.getPiece() != null)
            {
                this.board[this.deadPiece.getX_location()][this.deadPiece.getY_location()].setPiece(this.deadPiece.getPiece());
            }
            else
            {
                this.board[this.destination.getX_location()][this.destination.getY_location()].setPiece(null);
            }
            
            setChanged();
            notifyObservers(this.getChequePackage());
        }
        else
        {
            this.currentPlayer.setInCheque(false);
            Cheque theyreInCheque = new Cheque(oppositePlayer);
            theyreInCheque.findKing(this.board, oppositePlayer);
            boolean oppositePlayerInCheque = theyreInCheque.checkForCheque(this.board, oppositePlayer);
            
            if (oppositePlayerInCheque)
            {
                this.getChequePackage().getChequeBoolean()[1] = theyreInCheque.checkMate(this.board, oppositePlayer);
                
                if (this.getChequePackage().getChequeBoolean()[1] == true)
                {
                    this.currentPlayer.setScore(this.currentPlayer.getScore() + 1);
                    oppositePlayer.setScore(oppositePlayer.getScore() - 1);
                    this.chessConn.writeScores(this.currentPlayer);
                    this.chessConn.writeScores(oppositePlayer);
                    oppositePlayer.setInCheque(true);
                }
                
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

    /**
     * @return the chessConn
     */
    public chessConnection getChessConn() {
        return chessConn;
    }

    /**
     * @param chessConn the chessConn to set
     */
    public void setChessConn(chessConnection chessConn) {
        this.chessConn = chessConn;
    }

    /**
     * @return the playerPieces
     */
    public HashSet<Piece> getPlayerPieces() {
        return playerPieces;
    }

    /**
     * @param playerPieces the playerPieces to set
     */
    public void setPlayerPieces(HashSet<Piece> playerPieces) {
        this.playerPieces = playerPieces;
    }
}
