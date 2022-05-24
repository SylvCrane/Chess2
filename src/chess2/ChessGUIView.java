/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess2;

import Model.Square;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
    private JLabel[][] labelPieces;
    private boolean pieceSelected;
    private boolean destinationSelected;
    
    public ChessGUIView()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 850, 660);
        
        displayChessInformation();
        setStartingImages();
        instantiateChessBoard();
        setPieces();
        
        this.gameState = new JPanel();
        this.gameState.setLayout(new FlowLayout(FlowLayout.CENTER));
     
        this.gameState.add(this.chessInformation);
        this.gameState.add(this.chessBoard);
        this.add(this.gameState); 
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
    
    public void addController(ChessGUIController controller) {
        System.out.println("View      : adding controller");
        
        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                this.buttonSquares[x][y].addActionListener(controller);
            }
        }
        
        this.quitButton.addActionListener(controller);
    }
    
    public void setPieces()
    {
        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                if (this.labelPieces[x][y] != null)
                {
                    this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                }
            }
        }
    }
    
    public void setStartingImages()
    {
        this.labelPieces = new JLabel[8][8];
        ChessGUIPieceSetter establishPieces = new ChessGUIPieceSetter();
        
        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                if (y == 0)
                {
                    switch (x) {
                        case 0:
                            establishPieces.updateWhiteRook(this.labelPieces[x][y]);
                            break;
                        case 1:
                            establishPieces.updateWhiteKnight(this.labelPieces[x][y]);
                            break;
                        case 2:
                            establishPieces.updateWhiteBishop(this.labelPieces[x][y]);
                            break;
                        case 3:
                            establishPieces.updateWhiteKing(this.labelPieces[x][y]);
                            break;
                        case 4:
                            establishPieces.updateWhiteQueen(this.labelPieces[x][y]);
                            break;
                        case 5:
                            establishPieces.updateWhiteBishop(this.labelPieces[x][y]);
                            break;
                        case 6:
                            establishPieces.updateWhiteKnight(this.labelPieces[x][y]);
                            break;
                        case 7:
                            establishPieces.updateWhiteRook(this.labelPieces[x][y]);
                            break;
                        default:
                            break;
                    }
                }
                else if (y == 1)
                {
                    establishPieces.updateWhitePawn(this.labelPieces[x][y]);
                }
                else if (y == 6)
                {
                    establishPieces.updateBlackPawn(this.labelPieces[x][y]);
                }
                else if (y == 7)
                {
                    switch (x) {
                        case 0:
                            establishPieces.updateBlackRook(this.labelPieces[x][y]);
                            break;
                        case 1:
                            establishPieces.updateBlackKnight(this.labelPieces[x][y]);
                            break;
                        case 2:
                            establishPieces.updateBlackBishop(this.labelPieces[x][y]);
                            break;
                        case 3:
                            establishPieces.updateBlackKing(this.labelPieces[x][y]);
                            break;
                        case 4:
                            establishPieces.updateBlackQueen(this.labelPieces[x][y]);
                            break;
                        case 5:
                            establishPieces.updateBlackBishop(this.labelPieces[x][y]);
                            break;
                        case 6:
                            establishPieces.updateBlackKnight(this.labelPieces[x][y]);
                            break;
                        case 7:
                            establishPieces.updateBlackRook(this.labelPieces[x][y]);
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
                JLabel notApplicable = new JLabel("You cannot select a piece at this location");
                
                this.currentStatus.add(notApplicable);
            }
            else
            {
                Square lightUpSquare = (Square)arg1;
                this.buttonSquares[lightUpSquare.getX_location()][lightUpSquare.getY_location()].setBackground(Color.GREEN);
                this.setPieceSelected(true);
            }
        }
        else if (!this.isDestinationSelected())
        {
            if ((Square)arg1 == null)
            {
                JLabel moveNotApplicable = new JLabel("You cannot move here");
                this.currentStatus.add(moveNotApplicable);
            }
            else
            {
                this.setPieceSelected(true);
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
                if (board[x][y].getPiece() == null)
                {
                    this.labelPieces[x][y].setIcon(null);
                    this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                }
                else
                {
                    if (board[x][y].getPiece().pieceName.contains("whiteRook"))
                    {
                        updatePieces.updateWhiteRook(this.labelPieces[x][y]);
                        this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                    }
                    else if (board[x][y].getPiece().pieceName.contains("whiteKnight")) 
                    {
                        updatePieces.updateWhiteKnight(this.labelPieces[x][y]);
                        this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                    }
                    else if (board[x][y].getPiece().pieceName.contains("whiteBishop")) 
                    {
                        updatePieces.updateWhiteBishop(this.labelPieces[x][y]);
                        this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                    }
                    else if (board[x][y].getPiece().pieceName.contains("whiteKing")) 
                    {
                        updatePieces.updateWhiteKing(this.labelPieces[x][y]);
                        this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                    }
                    else if (board[x][y].getPiece().pieceName.contains("whiteQueen")) 
                    {
                        updatePieces.updateWhiteQueen(this.labelPieces[x][y]);
                        this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                    }
                    else if (board[x][y].getPiece().pieceName.contains("whitePawn"))
                    {
                        updatePieces.updateWhitePawn(this.labelPieces[x][y]);
                        this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                    }
                    else if (board[x][y].getPiece().pieceName.contains("blackPawn"))
                    {
                        updatePieces.updateBlackPawn(this.labelPieces[x][y]);
                        this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                    }
                    else if (board[x][y].getPiece().pieceName.contains("blackRook"))
                    {
                        updatePieces.updateBlackRook(this.labelPieces[x][y]);
                        this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                    }
                    else if (board[x][y].getPiece().pieceName.contains("blackKnight")) 
                    {
                        updatePieces.updateBlackKnight(this.labelPieces[x][y]);
                        this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                    }
                    else if (board[x][y].getPiece().pieceName.contains("blackBishop")) 
                    {
                        updatePieces.updateBlackBishop(this.labelPieces[x][y]);
                        this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                    }
                    else if (board[x][y].getPiece().pieceName.contains("blackKing")) 
                    {
                        updatePieces.updateBlackKing(this.labelPieces[x][y]);
                        this.buttonSquares[x][y].add(this.labelPieces[x][y]);
                    }
                    else if (board[x][y].getPiece().pieceName.contains("blackQueen")) 
                    {
                         updatePieces.updateBlackQueen(this.labelPieces[x][y]);
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
    
    
    
            
}
