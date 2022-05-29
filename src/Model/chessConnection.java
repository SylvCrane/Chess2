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
<<<<<<< HEAD
=======
import java.util.HashSet;
>>>>>>> Development

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
<<<<<<< HEAD
=======
            
            table = "playerPieces";
            
            if (!checkTableExisting(table))
            {
                statement.executeUpdate("CREATE TABLE "  + table + " (pieceName VARCHAR(20), colour VARCHAR(5), potentialMoves INT)");
            }
            
>>>>>>> Development
        }
        catch(Exception e)
        {
            System.out.println("Database connection is compromised");
        }
    }
    
<<<<<<< HEAD
    public boolean nameChecker(String username)
    {
        boolean nameChecker = false;
=======
    public void writePieces() throws SQLException
    {
        int count = 0;
        
        Statement statement = conn.createStatement();
        ResultSet rowCounter = statement.executeQuery("SELECT pieceName, colour, potentialMoves FROM playerPieces");
        if (rowCounter.next())
        {
            count++;
        }
        
        if (count == 0)
        {
            statement.addBatch("INSERT INTO playerPieces VALUES ('whiteRook1', 'white', 8),\n"
                    + "('whiteKnight1', 'white', 0),\n"
                    + "('whiteBishop1', 'white', 8),\n"
                    + "('whiteQueen', 'white', 8),\n"
                    + "('whiteKing', 'white', 1),\n"
                    + "('whiteBishop2', 'white', 8),\n"
                    + "('whiteKnight2', 'white', 0),\n"
                    + "('whiteRook2', 'white', 2),\n"
                    + "('whitePawn1', 'white', 2),\n"
                    + "('whitePawn2', 'white', 2),\n"
                    + "('whitePawn3', 'white', 2),\n"
                    + "('whitePawn4', 'white', 2),\n"
                    + "('whitePawn5', 'white', 2),\n"
                    + "('whitePawn6', 'white', 2),\n"
                    + "('whitePawn7', 'white', 2),\n"
                    + "('whitePawn8', 'white', 2),\n"
                    + "('blackPawn1', 'black', 2),\n"
                    + "('blackPawn2', 'black', 2),\n"
                    + "('blackPawn3', 'black', 2),\n"
                    + "('blackPawn4', 'black', 2),\n"
                    + "('blackPawn5', 'black', 2),\n"
                    + "('blackPawn6', 'black', 2),\n"
                    + "('blackPawn7', 'black', 2),\n"
                    + "('blackPawn8', 'black', 2),\n"
                    + "('blackRook1', 'black', 8),\n"
                    + "('blackKnight1', 'black', 0),\n"
                    + "('blackBishop1', 'black', 8),\n"
                    + "('blackQueen', 'black', 8),\n"
                    + "('blackKing', 'black', 1),\n"
                    + "('blackBishop2', 'black', 8),\n"
                    + "('blackKnight2', 'black', 0),\n"
                    + "('blackRook2', 'black', 8),\n");
            
            statement.executeBatch();
        }
    }
    
    public Player nameChecker(String username)
    {
        boolean nameChecker = false;
        Player playerIfFound = null;
>>>>>>> Development
        
        try
        {
            Statement statement = conn.createStatement();
<<<<<<< HEAD
            ResultSet rs = statement.executeQuery("SELECT Name FROM userData WHERE Name = '" + username + "'");
            
            if (rs.next())
            {
                String currentName
=======
            ResultSet rs = statement.executeQuery("SELECT Name, score FROM userData WHERE Name = '" + username + "'");
            
            if (rs.next())
            {
                String currentName = rs.getString("Name");
                if (username.compareTo(currentName) == 0)
                {
                    nameChecker = true;
                    playerIfFound.setName(username);
                    playerIfFound.setScore(rs.getInt("score"));
                }
            }
        }
        catch (SQLException e)
        {
            
        }
        
        return playerIfFound;
    }
    
    public void readPieces(HashSet<Piece> PlayerPieces)
    {
        try
        {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT pieceName, colour, potentialMoves FROM playerPieces");
            
            if (rs.next())
            {
                this.pieceName = rs.getString("pieceName");
                this.pieceColour = rs.getString("colour");
                this.potentialMoves = rs.getInt("potentialMoves");
                
                if (this.pieceName.contains("Pawn"))
                {
                    if (this.pieceColour.contains("white"))
                    {
                        PlayerPieces.add(new Pawn(this.pieceName, this.potentialMoves, PlayerColour.WHITE));
                    }
                    else
                    {
                        PlayerPieces.add(new Pawn(this.pieceName, this.potentialMoves, PlayerColour.BLACK));
                    }
                }
                else if (this.pieceName.contains("Rook"))
                {
                    if (this.pieceColour.contains("white"))
                    {
                        PlayerPieces.add(new Rook(this.pieceName, this.potentialMoves, PlayerColour.WHITE));
                    }
                    else
                    {
                        PlayerPieces.add(new Rook(this.pieceName, this.potentialMoves, PlayerColour.BLACK));
                    }
                }
                else if (this.pieceName.contains("Knight"))
                {
                    if (this.pieceColour.contains("white"))
                    {
                        PlayerPieces.add(new Knight(this.pieceName, this.potentialMoves, PlayerColour.WHITE));
                    }
                    else
                    {
                        PlayerPieces.add(new Knight(this.pieceName, this.potentialMoves, PlayerColour.BLACK));
                    }
                }
                else if (this.pieceName.contains("Bishop"))
                {
                    if (this.pieceColour.contains("white"))
                    {
                        PlayerPieces.add(new Bishop(this.pieceName, this.potentialMoves, PlayerColour.WHITE));
                    }
                    else
                    {
                        PlayerPieces.add(new Bishop(this.pieceName, this.potentialMoves, PlayerColour.BLACK));
                    }
                }
                else if (this.pieceName.contains("Queen"))
                {
                    if (this.pieceColour.contains("white"))
                    {
                        PlayerPieces.add(new Queen(this.pieceName, this.potentialMoves, PlayerColour.WHITE));
                    }
                    else
                    {
                        PlayerPieces.add(new Queen(this.pieceName, this.potentialMoves, PlayerColour.BLACK));
                    }
                }
                else if (this.pieceName.contains("King"))
                {
                    if (this.pieceColour.contains("white"))
                    {
                        PlayerPieces.add(new King(this.pieceName, this.potentialMoves, PlayerColour.WHITE));
                    }
                    else
                    {
                        PlayerPieces.add(new King(this.pieceName, this.potentialMoves, PlayerColour.BLACK));
                    }
                }
>>>>>>> Development
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
