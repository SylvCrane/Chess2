/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author navjo
 */
public class ChessGUIPieceSetter {
    
    //This class is used by the GUI view to update the board with images of the pieces used on the board,
    //separated by their type and the color of the piece.
    
    private Image img;
    private ImageIcon imgico;
    
    public ChessGUIPieceSetter()
    {
        this.img = null;
        this.imgico = null;
    }
    
    //Because the only difference in each method is the image itself, they are virtually the same.
    
    public JLabel updateWhiteRook()
    {
        this.img = new ImageIcon("./resources/whiteRook.png").getImage();
        this.imgico = new ImageIcon(img);
        JLabel pieceSquare = new JLabel();
        pieceSquare.setIcon(imgico);
        
        return pieceSquare;
    }
    
    public JLabel updateWhiteKnight()
    {
        this.img = new ImageIcon("./resources/whiteKnight.png").getImage();
        this.imgico = new ImageIcon(img);
        JLabel pieceSquare = new JLabel();
        pieceSquare.setIcon(imgico);
        
        return pieceSquare;
    }
    
    public JLabel updateWhiteBishop()
    {
        this.img = new ImageIcon("./resources/whiteBishop.png").getImage();
        this.imgico = new ImageIcon(img);
        JLabel pieceSquare = new JLabel();
        pieceSquare.setIcon(imgico);
        
        return pieceSquare;
    }
    
    public JLabel updateWhiteKing()
    {
        this.img = new ImageIcon("./resources/whiteKing.png").getImage();
        this.imgico = new ImageIcon(img);
        JLabel pieceSquare = new JLabel();
        pieceSquare.setIcon(imgico);
        
        return pieceSquare;
    }
    
    public JLabel updateWhiteQueen()
    {
        this.img = new ImageIcon("./resources/whiteQueen.png").getImage();
        this.imgico = new ImageIcon(img);
        JLabel pieceSquare = new JLabel();
        pieceSquare.setIcon(imgico);
        
        return pieceSquare; 
    }
    
    public JLabel updateWhitePawn()
    {
        this.img = new ImageIcon("./resources/whitePawn.png").getImage();
        this.imgico = new ImageIcon(img);
        JLabel pieceSquare = new JLabel();
        pieceSquare.setIcon(imgico);
        
        return pieceSquare; 
    }
    
    public JLabel updateBlackPawn()
    {
        this.img = new ImageIcon("./resources/blackPawn.png").getImage();
        this.imgico = new ImageIcon(img);
        JLabel pieceSquare = new JLabel();
        pieceSquare.setIcon(imgico);
        
        return pieceSquare; 
    }
    
    public JLabel updateBlackRook()
    {
        this.img = new ImageIcon("./resources/blackRook.png").getImage();
        this.imgico = new ImageIcon(img);
        JLabel pieceSquare = new JLabel();
        pieceSquare.setIcon(imgico);
        
        return pieceSquare; 
    }
    
    public JLabel updateBlackKnight()
    {
        this.img = new ImageIcon("./resources/blackKnight.png").getImage();
        this.imgico = new ImageIcon(img);
        JLabel pieceSquare = new JLabel();
        pieceSquare.setIcon(imgico);
        
        return pieceSquare; 
    }
    
    public JLabel updateBlackBishop()
    {
        this.img = new ImageIcon("./resources/blackBishop.png").getImage();
        this.imgico = new ImageIcon(img);
        JLabel pieceSquare = new JLabel();
        pieceSquare.setIcon(imgico);
        
        return pieceSquare; 
    }
    
    public JLabel updateBlackKing()
    {
        this.img = new ImageIcon("./resources/blackKing.png").getImage();
        this.imgico = new ImageIcon(img);
        JLabel pieceSquare = new JLabel();
        pieceSquare.setIcon(imgico);
        
        return pieceSquare; 
    }
    
    public JLabel updateBlackQueen()
    {
        this.img = new ImageIcon("./resources/blackQueen.png").getImage();
        this.imgico = new ImageIcon(img);
        JLabel pieceSquare = new JLabel();
        pieceSquare.setIcon(imgico);
        
        return pieceSquare; 
    }

    /**
     * @return the img
     */
    public Image getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(Image img) {
        this.img = img;
    }

    /**
     * @return the imgico
     */
    public ImageIcon getImgico() {
        return imgico;
    }

    /**
     * @param imgico the imgico to set
     */
    public void setImgico(ImageIcon imgico) {
        this.imgico = imgico;
    }
    
    
    
}
