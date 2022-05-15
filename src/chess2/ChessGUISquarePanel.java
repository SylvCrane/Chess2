/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess2;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author navjo
 */
public class ChessGUISquarePanel extends JPanel
{
    public Image image;
    
    
    public ChessGUISquarePanel(Image image)
    {
        this.image = image;
    }
    
    public void setUpGUIBoard(ChessGUISquarePanel[][] GUIBoard, Square[][] board)
    {
        
        for (int yIndex = 0; yIndex < 8; yIndex++)
        {
            for (int xIndex = 0; xIndex < 8; xIndex++)
            {
                GUIBoard[xIndex][yIndex] = new ChessGUISquarePanel(null);
                
                if (board[xIndex][yIndex].getPiece() != null)
                {
                    StringBuilder fileLocation = new StringBuilder();
                    fileLocation.append("./resources/");
                    fileLocation.append(board[xIndex][yIndex].getPiece().pieceName);
                    fileLocation.append(".jpg");
                    GUIBoard[xIndex][yIndex].image = new ImageIcon(fileLocation.toString()).getImage();
                }
            }
        }
    }
    
    
    
}
