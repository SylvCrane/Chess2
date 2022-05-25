/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess2;

import Model.Square;
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
    
    
    public ChessGUIView()
    {
        displayChessInformation();
        instantiateChessBoard();
        setStartingImages();
        
        this.chessTitle = new JPanel();
        this.title = new JLabel("CHESS");
        this.title.setFont(new Font("Arial", Font.BOLD, 50));
        this.chessTitle.add(this.title);
        this.add(this.chessTitle, BorderLayout.CENTER);
        
        this.nameField = new JPanel();
       
        this.player1Field = new JTextField(20);
        this.player1Field.setText("Navjot");
        this.player2Field = new JTextField(20);
        this.player2Field.setText("Dylan");
        this.nameAccept = new JButton("Enter");
        
        this.nameField.add(this.player1Field);
        this.nameField.add(this.player2Field);
        this.nameField.add(this.nameAccept);
        
        this.add(this.nameField, BorderLayout.SOUTH);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 850, 660);
    }
    
    public void mainGame()
    {
        this.remove(this.chessTitle);
        this.remove(this.nameField);
        this.currentStatus.setText(this.player1.getText() + ", it is now your turn");
        this.gameState = new JPanel();
        this.gameState.setLayout(new FlowLayout(FlowLayout.CENTER));
     
        this.gameState.add(this.chessInformation);
        this.gameState.add(this.chessBoard);
        this.add(this.gameState); 
        
        this.revalidate();
        this.repaint();
    }
    
    public void displayChessInformation()
    {
        this.chessInformation = new JPanel();
        this.chessInformation.setPreferredSize(new Dimension(200, 600));
        
        GridLayout informationRow = new GridLayout(3, 1);
        this.chessInformation.setLayout(informationRow);
        
        this.currentStatus = new JTextArea();
        this.spaceMaker = new JPanel();
        this.quitButton = new JButton("quit");
        
        this.chessInformation.add(this.currentStatus);
        this.chessInformation.add(this.spaceMaker);
        this.chessInformation.add(this.quitButton);
    }
    
    public String setButtonName(int x, int y)
    {
        StringBuilder buttonName = new StringBuilder();
        
        char xName = (char)(x + '0');
        char yName = (char)(y + '0');
        
        buttonName.append(xName);
        buttonName.append(yName);
        
        return buttonName.toString();
    }
  
    public void instantiateChessBoard()
    {
        this.chessBoard = new JPanel();
        this.chessBoard.setPreferredSize(new Dimension(600,600));
        GridLayout chessGrid = new GridLayout(8, 8);
        this.chessBoard.setLayout(chessGrid);

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
    }
    
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
                            this.labelPieces[x][y] = establishPieces.updateWhiteKing();
                            this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                            break;
                        case 4:
                            this.labelPieces[x][y] = establishPieces.updateWhiteQueen();
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
                            this.labelPieces[x][y] = establishPieces.updateBlackKing();
                            this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                            break;
                        case 4:
                            this.labelPieces[x][y] = establishPieces.updateBlackQueen();
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
    
    @Override
    public void update(Observable arg0, Object arg1) {
        if (!this.isPieceSelected())
        {
            if ((Square)arg1 == null)
            {
                JLabel notApplicable = new JLabel();
                notApplicable.setText("You cannot select a piece at this location");
                
                this.currentStatus.setText(notApplicable.getText());
            }
            else
            {
                System.out.println("Printing colour");
                Square lightUpSquare = (Square)arg1;
                this.buttonSquares[lightUpSquare.getX_location()][lightUpSquare.getY_location()].setBackground(Color.GREEN);
                this.setPieceSelected(true);
            }
        }
        else if (!this.isDestinationSelected())
        {
            if ((Square[][])arg1 == null)
            {
                this.currentStatus.setText("You cannot move here");
            }
            else
            {
                this.setPieceSelected(false);
                this.updateBoard((Square[][])arg1);
                this.resetColours();
                if (this.currentStatus.getText().contains(this.player1.getText()))
                {
                    this.currentStatus.setText(this.player2.getText() + ", it is now your turn");
                }
                else
                {
                    this.currentStatus.setText(this.player1.getText() + ", it is now your turn");
                }
            }
        }
    }
    
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
