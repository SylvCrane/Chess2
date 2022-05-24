/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess2;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author navjo
 */
public class ChessGUIPieceSetter {
    
    private Image img;
    private ImageIcon imgico;
    
    public ChessGUIPieceSetter()
    {
        this.img = null;
        this.imgico = null;
    }
    
    public void updateWhiteRook(JLabel pieceSquare)
    {
        this.img = new ImageIcon("./resources/whiteRook.png").getImage();
        this.imgico = new ImageIcon(img);
        pieceSquare = new JLabel();
        pieceSquare.setIcon(imgico);
    }
    
    public void updateWhiteKnight(JLabel pieceSquare)
    {
        this.img = new ImageIcon("./resources/whiteKnight.png").getImage();
        this.imgico = new ImageIcon(img);
        pieceSquare = new JLabel();
        pieceSquare.setIcon(imgico);
    }
    
    public void updateWhiteBishop(JLabel pieceSquare)
    {
        this.img = new ImageIcon("./resources/whiteBishop.png").getImage();
        this.imgico = new ImageIcon(img);
        pieceSquare = new JLabel();
        pieceSquare.setIcon(imgico);
    }
    
    public void updateWhiteKing(JLabel pieceSquare)
    {
        this.img = new ImageIcon("./resources/whiteKing.png").getImage();
        this.imgico = new ImageIcon(img);
        pieceSquare = new JLabel();
        pieceSquare.setIcon(imgico);
    }
    
    public void updateWhiteQueen(JLabel pieceSquare)
    {
        this.img = new ImageIcon("./resources/whiteQueen.png").getImage();
        this.imgico = new ImageIcon(img);
        pieceSquare = new JLabel();
        pieceSquare.setIcon(imgico);
    }
    
    public void updateWhitePawn(JLabel pieceSquare)
    {
        this.img = new ImageIcon("./resources/whitePawn.png").getImage();
        this.imgico = new ImageIcon(img);
        pieceSquare = new JLabel();
        pieceSquare.setIcon(imgico);
    }
    
    public void updateBlackPawn(JLabel pieceSquare)
    {
        this.img = new ImageIcon("./resources/blackPawn.png").getImage();
        this.imgico = new ImageIcon(img);
        pieceSquare = new JLabel();
        pieceSquare.setIcon(imgico);
    }
    
    public void updateBlackRook(JLabel pieceSquare)
    {
        this.img = new ImageIcon("./resources/blackRook.png").getImage();
        this.imgico = new ImageIcon(img);
        pieceSquare = new JLabel();
        pieceSquare.setIcon(imgico);
    }
    
    public void updateBlackKnight(JLabel pieceSquare)
    {
        this.img = new ImageIcon("./resources/blackKnight.png").getImage();
        this.imgico = new ImageIcon(img);
        pieceSquare = new JLabel();
        pieceSquare.setIcon(imgico);
    }
    
    public void updateBlackBishop(JLabel pieceSquare)
    {
        this.img = new ImageIcon("./resources/blackBishop.png").getImage();
        this.imgico = new ImageIcon(img);
        pieceSquare = new JLabel();
        pieceSquare.setIcon(imgico);
    }
    
    public void updateBlackKing(JLabel pieceSquare)
    {
        this.img = new ImageIcon("./resources/blackKing.png").getImage();
        this.imgico = new ImageIcon(img);
        pieceSquare = new JLabel();
        pieceSquare.setIcon(imgico);
    }
    
    public void updateBlackQueen(JLabel pieceSquare)
    {
        this.img = new ImageIcon("./resources/blackQueen.png").getImage();
        this.imgico = new ImageIcon(img);
        pieceSquare = new JLabel();
        pieceSquare.setIcon(imgico);
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
