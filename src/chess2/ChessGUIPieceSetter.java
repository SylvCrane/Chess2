/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess2;

import java.awt.Image;
import javax.swing.ImageIcon;

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
