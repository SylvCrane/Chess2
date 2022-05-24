/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chess2;

/**
 *
 * @author navjo
 */
public class Chess2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Chess2 chess = new Chess2();
    }
    
    public Chess2()
    {
        ChessGUIView view = new ChessGUIView();
        view.setVisible(true);
        
        ChessGUIController controller = new ChessGUIController();
        controller.addView(view);
        view.addController(controller);
    }
    
}
