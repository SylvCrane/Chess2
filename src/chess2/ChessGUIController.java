/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author navjo
 */
public class ChessGUIController implements ActionListener{
    
    ChessGUIView view;
    
    ChessGUIController()
    {
        
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        
        String buttonName = arg0.getActionCommand();
        
        if (buttonName.equals("quit"))
        {
            System.out.println("You pressed the quit button");
        }
        else
        {
            StringBuilder x = new StringBuilder();
            StringBuilder y = new StringBuilder();
            
            StringBuilder squareName = new StringBuilder();
            
            int index = 0;
            
            x.append(buttonName.charAt(index));
            index++;
            y.append(buttonName.charAt(index));
            
            System.out.println("You pressed square[" + x.toString() + "][" + y.toString() + "]");
          
        }
        
    }
    
    public void addView(ChessGUIView view)
    {
        this.view = view;
    }
    
    
}
