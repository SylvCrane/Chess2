/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;

/**
 *
 * @author navjo
 */
public class chessConnection 
{
    Connection conn = null;
    String url = "jdbc:derby:chessDB;create=true";
    String dbusername = "pdc";
    String dbpassword = "pdc";
    
    public String name = null;
    public int score = 0;
    
    public String pieceName = null;
    public String pieceColour = null;
    public Direction pieceDirection = Direction.STILL;
    public int potentialMoves = 0;
    
    
    
}
