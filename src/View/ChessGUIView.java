/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Player;
import Model.Square;
import Model.chequePackage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author navjo
 */
public class ChessGUIView extends JFrame implements Observer{

    private JButton[][] buttonSquares = new JButton[8][8];
    private JPanel chessBoard;
    private JPanel chessInformation;
    private JTextArea currentStatus;
    private JButton quitButton;
    private JButton rulesButton;
    private JPanel gameState;
    private JPanel spaceMaker;
    private JLabel[][] labelPieces = new JLabel[8][8];
    private boolean pieceSelected;
    private boolean destinationSelected;
    private JPanel chessTitle;
    private JTextField player1Field;
    private JTextField player2Field;
    private JButton nameAccept;
    private JPanel nameField;
    private JLabel title;
    private JLabel player1;
    private JLabel player2;
    private JLabel currentPlayer;
    public boolean pieceMoved = false;
    private JPanel startingPanel;
    
    
    /**
     * This is the first panel the user will see. From here, the player sets player1 and player2 for the game.
     * 
     */
    public void gameStart()
    {
        this.getContentPane().removeAll();
        displayChessInformation();
        instantiateChessBoard();
        setStartingImages();
        
        this.startingPanel = new JPanel();
        this.startingPanel.setLayout(new BorderLayout());
        
        this.chessTitle = new JPanel();
        this.title = new JLabel("CHESS");
        this.title.setFont(new Font("Arial", Font.BOLD, 100));
        this.chessTitle.add(this.title);
        
        this.startingPanel.add(this.chessTitle, BorderLayout.NORTH);
        
        this.nameField = new JPanel();
       
        this.player1Field = new JTextField(20);
        this.player1Field.setText("Player 1");
        this.player2Field = new JTextField(20);
        this.player2Field.setText("Player 2");
        this.nameAccept = new JButton("Enter");
        
        this.nameField.add(this.player1Field);
        this.nameField.add(this.player2Field);
        this.nameField.add(this.nameAccept);
        
        this.startingPanel.add(this.nameField, BorderLayout.SOUTH);
        
        JLabel startingMessage = new JLabel();
        startingMessage.setVerticalAlignment(SwingConstants.CENTER);
        startingMessage.setHorizontalAlignment(SwingConstants.CENTER);
        startingMessage.setFont(new Font("Arial", Font.BOLD, 15));
        startingMessage.setText("<html>Welcome to Chess. <br/>Please input the names of player 1 and 2 (white and black respectively)<br/> and press enter to begin. If you are a returning player, your data will be recorded appropriately.<html>");
        this.startingPanel.add(startingMessage, BorderLayout.CENTER);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 850, 660);
        this.add(this.startingPanel);
        this.revalidate();
        this.repaint();
    }
    
    
    public ChessGUIView()
    {
        this.gameStart();
    }
    
    /**
     * This is the game itself, including the game board, and game data on the side, with buttons and the JTextArea.
     * 
     */
    public void mainGame()
    {  
        this.remove(this.startingPanel);
        this.currentPlayer = new JLabel();
        this.currentPlayer.setText(this.player1.getText());
        this.currentStatus.setText(this.currentPlayer.getText() + ", it is now your turn");
        this.gameState = new JPanel();
        this.gameState.setLayout(new FlowLayout(FlowLayout.CENTER));
     
        this.gameState.add(this.chessInformation);
        this.gameState.add(this.chessBoard);
        this.add(this.gameState); 
        
        this.revalidate();
        this.repaint();
    }
    
    /**
     * This is a JPanel with a grid layout consisting of everything that is not the game board itself.
     * This includes the JTextArea, the rules button and the reset button.
     * 
     */
    public void displayChessInformation()
    {
        this.chessInformation = new JPanel();
        this.chessInformation.setPreferredSize(new Dimension(200, 600));
        
        GridLayout informationRow = new GridLayout(3, 1);
        this.chessInformation.setLayout(informationRow);
        
        this.currentStatus = new JTextArea();
        this.rulesButton = new JButton("Rules");
        this.quitButton = new JButton("reset");
        
        this.chessInformation.add(this.currentStatus);
        this.chessInformation.add(this.rulesButton);
        this.chessInformation.add(this.quitButton);
    }
    
    /**
     * This sets the names of each of the buttons. The name is a combination of the xLocation
     * and yLocation of the piece.
     * 
     * @param x
     * @param y
     * @return 
     */
    public String setButtonName(int x, int y)
    {
        StringBuilder buttonName = new StringBuilder();
        
        char xName = (char)(x + '0');
        char yName = (char)(y + '0');
        
        buttonName.append(xName);
        buttonName.append(yName);
        
        return buttonName.toString();
    }
  
    /**
     * This sets each of the buttons on the board through a grid layout. It is going in the opposite 
     * direction due to how a gridLayout functions. The button name is set here.
     * 
     */
    public void instantiateChessBoard()
    {
        this.chessBoard = new JPanel();
        this.chessBoard.setPreferredSize(new Dimension(600,600));
        GridLayout chessGrid = new GridLayout(8, 8);
        this.chessBoard.setLayout(chessGrid);

        //opposite order, to account for how a grid layout works.
        for (int y = 7; y > -1; y--)
        {
            for (int x = 0; x < 8; x++)
            {
                String buttonName = this.setButtonName(x, y);
                this.buttonSquares[x][y] = new JButton();
                this.buttonSquares[x][y].setActionCommand(buttonName);
                if (y % 2 != 0)
                {
                    if (x % 2 != 0)
                    {
                        this.buttonSquares[x][y].setBackground(Color.GRAY);
                    }
                    else if (x % 2 == 0)
                    {
                        this.buttonSquares[x][y].setBackground(Color.WHITE);
                    }
                }
                else if (y % 2 == 0)
                {
                    if (x % 2 != 0)
                    {
                        this.buttonSquares[x][y].setBackground(Color.WHITE);
                    }
                    else if (x % 2 == 0)
                    {
                        this.buttonSquares[x][y].setBackground(Color.GRAY);
                    }
                }

                this.buttonSquares[x][y].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            }
       }

            for (int y = 7; y > -1; y--)
            {
                for (int x = 0; x < 8; x++)
                {
                    this.chessBoard.add(this.buttonSquares[x][y]);
                }
            } 
    }
    
    /**
     * This is the final panel the player sees if either player has gotten a checkmate. It will print the player's
     * new score.
     * 
     * @param winnerAndLoser 
     */
    public void gameEnd(Player[] winnerAndLoser)
    {
        JPanel gameEndPanel = new JPanel();
        JLabel gamePlayerData = new JLabel();
        
        if (winnerAndLoser[0].isInCheque())
        {
            gamePlayerData.setText("Well done, " + winnerAndLoser[1].getName() +". Your score has increased to " + winnerAndLoser[1].getScore() + "\n Sorry, " + winnerAndLoser[0].getName() + ", your score has decreased to " + winnerAndLoser[0].getScore());
        }
        else
        {
            gamePlayerData.setText("Well done, " + winnerAndLoser[0].getName() +". Your score has increased to " + winnerAndLoser[0].getScore() + "\n Sorry, " + winnerAndLoser[1].getName() + ", your score has decreased to " + winnerAndLoser[1].getScore());
        }
        
        gameEndPanel.add(gamePlayerData);
        
        this.getContentPane().removeAll();
        this.add(gameEndPanel);
        this.revalidate();
        this.repaint();
    }
    
    /**
     * This method sets the color of the buttons depending on their position on the board. It is important
     * for the colors to mimic that of a traditional chess board.
     * 
     */
    public void resetColours()
    {
        for (int y = 7; y > -1; y--)
        {
            for (int x = 0; x < 8; x++)
            {
                if (y % 2 != 0)
                {
                    if (x % 2 != 0)
                    {
                        this.buttonSquares[x][y].setBackground(Color.GRAY);
                    }
                    else if (x % 2 == 0)
                    {
                        this.buttonSquares[x][y].setBackground(Color.WHITE);
                    }
                }
                else if (y % 2 == 0)
                {
                    if (x % 2 != 0)
                    {
                        this.buttonSquares[x][y].setBackground(Color.WHITE);
                    }
                    else if (x % 2 == 0)
                    {
                        this.buttonSquares[x][y].setBackground(Color.GRAY);
                    }
                }
            }
        }
    }
    
    /**
     * This adds the functionality for the controller to the buttons. Because of the nature of the chess board
     * this needs to be done in a for loop.
     * 
     * @param controller 
     */
    public void addController(ChessGUIController controller) {
        System.out.println("View      : adding controller");
        
        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                this.buttonSquares[x][y].addActionListener(controller);
            }
        }
        
        this.nameAccept.addActionListener(controller);
        this.quitButton.addActionListener(controller);
        this.rulesButton.addActionListener(controller);
    }
    
    /**
     * This sets the opening images to the squares based on the current location of the square. It is the only
     * use of the switch case as it is appropriate here.
     * 
     */
    public void setStartingImages()
    {
        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                this.labelPieces[x][y] = new JLabel();
            }
        }
        
        ChessGUIPieceSetter establishPieces = new ChessGUIPieceSetter();
        
        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                if (y == 0)
                {
                    switch (x) {
                        case 0:
                            this.labelPieces[x][y] = establishPieces.updateWhiteRook();
                            this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                            break;
                        case 1:
                            this.labelPieces[x][y] = establishPieces.updateWhiteKnight();
                            this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                            break;
                        case 2:
                            this.labelPieces[x][y] = establishPieces.updateWhiteBishop();
                            this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                            break;
                        case 3:
                            this.labelPieces[x][y] = establishPieces.updateWhiteQueen();
                            this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                            break;
                        case 4:
                            this.labelPieces[x][y] = establishPieces.updateWhiteKing();
                            this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                            break;
                        case 5:
                            this.labelPieces[x][y] = establishPieces.updateWhiteBishop();
                            this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                            break;
                        case 6:
                            this.labelPieces[x][y] = establishPieces.updateWhiteKnight();
                            this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                            break;
                        case 7:
                            this.labelPieces[x][y] = establishPieces.updateWhiteRook();
                            this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                            break;
                        default:
                            break;
                    }
                }
                else if (y == 1)
                {
                    this.labelPieces[x][y] = establishPieces.updateWhitePawn();
                    this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                }
                else if (y == 6)
                {
                    this.labelPieces[x][y] = establishPieces.updateBlackPawn();
                    this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                }
                else if (y == 7)
                {
                    switch (x) {
                        case 0:
                            this.labelPieces[x][y] = establishPieces.updateBlackRook();
                            this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                            break;
                        case 1:
                            this.labelPieces[x][y] = establishPieces.updateBlackKnight();
                            this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                            break;
                        case 2:
                            this.labelPieces[x][y] = establishPieces.updateBlackBishop();
                            this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                            break;
                        case 3:
                            this.labelPieces[x][y] = establishPieces.updateBlackQueen();
                            this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                            break;
                        case 4:
                            this.labelPieces[x][y] = establishPieces.updateBlackKing();
                            this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                            break;
                        case 5:
                            this.labelPieces[x][y] = establishPieces.updateBlackBishop();
                            this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                            break;
                        case 6:
                            this.labelPieces[x][y] = establishPieces.updateBlackKnight();
                            this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                            
                            break;
                        case 7:
                            this.labelPieces[x][y] = establishPieces.updateBlackRook();
                            this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }
    
    /**
     * This updates the view based on what was manipulated in the controller and what changed in the model.
     * As a result, it uses several if statements based on what the class of the object is.
     * 
     * @param arg0
     * @param arg1 
     */
    @Override
    public void update(Observable arg0, Object arg1) {
        
        if (!this.isPieceSelected())
        {
            if ((Square)arg1 == null)
            {
                JLabel notApplicable = new JLabel();
                notApplicable.setText("You cannot select a piece at this \nlocation");
                
                this.currentStatus.setText(notApplicable.getText());
            }
            else
            {
                System.out.println("Printing colour");
                Square lightUpSquare = (Square)arg1;
                this.buttonSquares[lightUpSquare.getX_location()][lightUpSquare.getY_location()].setBackground(Color.GREEN);
                this.setPieceSelected(true);
                this.pieceMoved = false;
            }
        }
        else if (!this.isDestinationSelected())
        {
            if (arg1 == null)
            {
                JLabel cannotMoveHere = new JLabel();
                cannotMoveHere.setText("You cannot move here. Please\n choose another location \nor select another piece");
                
                this.currentStatus.setText(cannotMoveHere.getText());
                this.resetColours();
                this.setPieceSelected(false);
            }
            else if (arg1.getClass() == Square[][].class)
            {
                if ((Square[][])arg1 == null)
                {
                    this.currentStatus.setText("You cannot move here. Please choose \nanother location or select another piece");
                    this.resetColours();
                    this.setPieceSelected(false);
                }
                else if ((Square[][])arg1 != null)
                {
                    this.pieceMoved = true;
                    this.resetColours();
                    this.updateBoard((Square[][])arg1);  
                }
            }
            else if (arg1.getClass() == chequePackage.class)
            {
                chequePackage chequeView = (chequePackage)arg1;
                
                if (!chequeView.getChequeBoolean()[0])
                {
                    if (this.currentPlayer.getText().contains(this.player1.getText()))
                    {
                    this.currentStatus.setText(this.player2.getText() + ", it is now your turn");
                    this.currentPlayer.setText(this.player2.getText());
                    }
                    else
                    {
                    this.currentStatus.setText(this.player1.getText() + ", it is now your turn");
                    this.currentPlayer.setText(this.player1.getText());
                    }
                
                    this.setPieceSelected(false);
                }
                else if (chequeView.getChequeBoolean()[0])
                {
                    this.updateBoard(chequeView.getBoard());
                    this.currentStatus.setText(this.currentPlayer.getText() + ", you're in cheque");
                    this.setPieceSelected(false);
                }
                
                if (chequeView.getChequeBoolean()[1])
                {
                    this.setVisible(false);
                    dispose();
                }   
            }
        }
    }
    
    
    /**
     * This updates the board after every move, regardless of the player is in cheque or not. The latter detail is
     * important as if the player is in cheque, the view must be immediately changed back to represent
     * the returned position of the pieces.
     * 
     * @param board 
     */
    public void updateBoard(Square[][] board)
    {
        ChessGUIPieceSetter updatePieces = new ChessGUIPieceSetter();
        
        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                this.labelPieces[x][y].setIcon(null);
                this.buttonSquares[x][y].add(this.labelPieces[x][y]);
            }
        }
        
        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                if (board[x][y].getPiece() != null)
                {
                    if (board[x][y].getPiece().pieceName.contains("whiteRook"))
                    {
                        this.labelPieces[x][y] = updatePieces.updateWhiteRook();
                        this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                    }
                    else if (board[x][y].getPiece().pieceName.contains("whiteKnight")) 
                    {
                        this.labelPieces[x][y] = updatePieces.updateWhiteKnight();
                        this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                    }
                    else if (board[x][y].getPiece().pieceName.contains("whiteBishop")) 
                    {
                        this.labelPieces[x][y] = updatePieces.updateWhiteBishop();
                        this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                    }
                    else if (board[x][y].getPiece().pieceName.contains("whiteKing")) 
                    {
                        this.labelPieces[x][y] = updatePieces.updateWhiteKing();
                        this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                    }
                    else if (board[x][y].getPiece().pieceName.contains("whiteQueen")) 
                    {
                        this.labelPieces[x][y] = updatePieces.updateWhiteQueen();
                        this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                    }
                    else if (board[x][y].getPiece().pieceName.contains("whitePawn"))
                    {
                        this.labelPieces[x][y] = updatePieces.updateWhitePawn();
                        this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                    }
                    else if (board[x][y].getPiece().pieceName.contains("blackPawn"))
                    {
                        this.labelPieces[x][y] = updatePieces.updateBlackPawn();
                        this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                    }
                    else if (board[x][y].getPiece().pieceName.contains("blackRook"))
                    {
                        this.labelPieces[x][y] = updatePieces.updateBlackRook();
                        this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                    }
                    else if (board[x][y].getPiece().pieceName.contains("blackKnight")) 
                    {
                        this.labelPieces[x][y] = updatePieces.updateBlackKnight();
                        this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                    }
                    else if (board[x][y].getPiece().pieceName.contains("blackBishop")) 
                    {
                        this.labelPieces[x][y] = updatePieces.updateBlackBishop();
                        this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                    }
                    else if (board[x][y].getPiece().pieceName.contains("blackKing")) 
                    {
                        this.labelPieces[x][y] = updatePieces.updateBlackKing();
                        this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                    }
                    else if (board[x][y].getPiece().pieceName.contains("blackQueen")) 
                    {
                        this.labelPieces[x][y] = updatePieces.updateBlackQueen();
                        this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                    }
                }   
            }
        }
    }

    /**
     * @return the pieceSelected
     */
    public boolean isPieceSelected() {
        return pieceSelected;
    }

    /**
     * @param pieceSelected the pieceSelected to set
     */
    public void setPieceSelected(boolean pieceSelected) {
        this.pieceSelected = pieceSelected;
    }

    /**
     * @return the destinationSelected
     */
    public boolean isDestinationSelected() {
        return destinationSelected;
    }

    /**
     * @param destinationSelected the destinationSelected to set
     */
    public void setDestinationSelected(boolean destinationSelected) {
        this.destinationSelected = destinationSelected;
    }

    /**
     * @return the player1
     */
    public JLabel getPlayer1() {
        return player1;
    }

    /**
     * @param player1 the player1 to set
     */
    public void setPlayer1(JLabel player1) {
        this.player1 = player1;
    }

    /**
     * @return the player2
     */
    public JLabel getPlayer2() {
        return player2;
    }

    /**
     * @param player2 the player2 to set
     */
    public void setPlayer2(JLabel player2) {
        this.player2 = player2;
    }

    /**
     * @return the player1Field
     */
    public JTextField getPlayer1Field() {
        return player1Field;
    }

    /**
     * @param player1Field the player1Field to set
     */
    public void setPlayer1Field(JTextField player1Field) {
        this.player1Field = player1Field;
    }

    /**
     * @return the player2Field
     */
    public JTextField getPlayer2Field() {
        return player2Field;
    }

    /**
     * @param player2Field the player2Field to set
     */
    public void setPlayer2Field(JTextField player2Field) {
        this.player2Field = player2Field;
    }
    
    
    
            
}
