/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess2;

import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author navjo
 */
public class ChessGUIPanel extends JPanel
{
    public Image image;
    public JPanel panel;
    
    public ChessGUIPanel(Image image, JPanel panel)
    {
        this.image = image;
        this.panel = panel;
    }
    
    public void setUpGUIBoard(ChessGUIPanel[][] GUIBoard, Square[][] board)
    {
        
        for (int yIndex = 0; yIndex < 8; yIndex++)
        {
            for (int xIndex = 0; xIndex < 8; xIndex++)
            {
                GUIBoard[xIndex][yIndex] = new ChessGUIPanel(null, new JPanel());
                
                if (board[xIndex][yIndex].getPiece() != null)
                {
                    StringBuilder fileLocation = new StringBuilder();
                    fileLocation.append("./resources/");
                    fileLocation.append(board[xIndex][yIndex].getPiece().pieceName);
                    fileLocation.append(".jpg");
                }
            }
        }
    }
    
    
    
}
