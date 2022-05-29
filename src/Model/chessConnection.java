/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    
    public void chessSetup()
    {
        try
        {
            conn = DriverManager.getConnection(url, dbusername, dbpassword);
            Statement statement = conn.createStatement();
            
            String table = "userData";
            
            if (!checkTableExisting(table))
            {
                statement.executeUpdate("CREATE TABLE "  + table + " (Name VARCHAR(20), score INT)");
            }
        }
        catch(Exception e)
        {
            System.out.println("Database connection is compromised");
        }
    }
    
    public boolean nameChecker(String username)
    {
        boolean nameChecker = false;
        
        try
        {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT Name FROM userData WHERE Name = '" + username + "'");
            
            if (rs.next())
            {
                String currentName
            }
        }
        catch (SQLException e)
        {
            
        }
    }
    
    public boolean checkTableExisting(String newTableName) {
        boolean flag = false;
        
        try {
            System.out.println("check existing tables.... ");
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);//types);
            //Statement dropStatement=null;
            while (rsDBMeta.next()) {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                if (tableName.compareToIgnoreCase(newTableName) == 0) {
                    System.out.println(tableName + "  is there");
                    flag = true;
                }
            }
            if (rsDBMeta != null) {
                rsDBMeta.close();
            }
        } catch (SQLException ex) {
        }
        return flag;
    }
    
}
