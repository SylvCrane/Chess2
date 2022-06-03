/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;


/**
 *
 * @author navjo
 */
public class chessConnection 
{
    //This class establishes a connection with the chess database or connects a new one if it has not been initialized.
    
    Connection conn = null;
    
    //The following string denotes an embedded database, meaning its location is with the program and not dependant on the location of derby.
    String url = "jdbc:derby:chessDB;create=true";
    String dbusername = "pdc";
    String dbpassword = "pdc";
    
    public String name = null;
    public int score = 0;
    
    //The following variables are used as temporary stores for writing and reading pieces.
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
            
            String table = "USERDATA";
            
            //Of course, if the tables do not exist, tehy must be created.
            if (!checkTableExisting(table))
            {
                statement.executeUpdate("CREATE TABLE "  + table + " (NAME VARCHAR(20), SCORE INT)");
            }
   
            table = "PLAYERPIECES";
            
            if (!checkTableExisting(table))
            {
                statement.executeUpdate("CREATE TABLE "  + table + " (PIECENAME VARCHAR(20), COLOUR VARCHAR(5), POTENTIALMOVES INT)");
            }

        }
        catch(Exception e)
        {
            System.out.println("Database connection is compromised");
        }
    }

 
    /**
     * This method writes the pieces to the playerPieces table, but only if they do not exist beforehand.
     * 
     * @throws SQLException 
     */
    public void writePieces() throws SQLException
    {
        int count = 0;
        
        try
        {
            Statement statement = conn.createStatement();
            ResultSet rowCounter = statement.executeQuery("SELECT PIECENAME, COLOUR, POTENTIALMOVES FROM PLAYERPIECES");
            if (rowCounter.next())
            {
                count++;
            }

            
            //Storing the pieces using a batch as this is significantly more convenient.
            if (count == 0)
            {
                statement.addBatch("INSERT INTO PLAYERPIECES VALUES ('whiteRook1', 'white', 8),\n"
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
                        + "('blackRook2', 'black', 8)");

                statement.executeBatch();
            }
        }
        catch (SQLException e)
        {
            SQLException nextException = e.getNextException();
            System.out.println(nextException);
        } 
    }
    
    /**
     * This method writes the scores of the player to the userData table in the case that the game had been won
     * 
     * @param player
     * @throws SQLException 
     */
    public void writeScores(Player player) throws SQLException
    {
        int unchangedScore = player.getScore();
        boolean nameCheck = this.nameChecker(player);
        player.setScore(unchangedScore);
        
        Statement statement = conn.createStatement();
        
        if (nameCheck)
        {
            String scoreUpdater = "UPDATE USERDATA SET SCORE=" + unchangedScore +" WHERE NAME = '"+ player.getName() + "'";
            statement.executeUpdate(scoreUpdater);
        }
        else
        {
            String scoreUpdater = "INSERT INTO USERDATA VALUES('" + player.getName() +"', " + player.getScore() + ")";
            statement.executeUpdate(scoreUpdater);
        }
        
    }
    
    /**
     * This checks if the player is present in the database already. If this is the case, their score is registered as the player's current score.
     * 
     * @param player
     * @return
     * @throws SQLException 
     */
    public boolean nameChecker(Player player) throws SQLException
    {
        boolean nameChecker = false;
       
        try
        {
            Statement statement = conn.createStatement();      
            ResultSet rs = statement.executeQuery("SELECT NAME, SCORE FROM USERDATA WHERE NAME = '" + player.getName() + "'");
            
            while (rs.next())
            {
                String currentName = rs.getString("NAME");
                if (player.getName().compareTo(currentName) == 0)
                {
                    nameChecker = true;
                    player.setScore(rs.getInt("SCORE"));
                    break;
                }
                else
                {
                    player.setScore(0);
                }
            }
        }
        catch (SQLException e)
        {
            
        }
        
        return nameChecker;
    }
    
    /**
     * This reads the player pieces from the playerPieces database and sets them into a hashSet.
     *
     * @param PlayerPieces
     */
    public void readPieces(HashSet<Piece> PlayerPieces)
    {
        try
        {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT PIECENAME, COLOUR, POTENTIALMOVES FROM PLAYERPIECES");
            
            while (rs.next())
            {
                this.pieceName = rs.getString("PIECENAME");
                this.pieceColour = rs.getString("COLOUR");
                this.potentialMoves = rs.getInt("POTENTIALMOVES");
                
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

            }
        }
        catch (SQLException e)
        {
            
        }
    }
    
    /**
     * This method checks if the table exists in the database already to avoid a potential SQL error for overwriting a database.
     * 
     * @param newTableName
     * @return 
     */
    public boolean checkTableExisting(String newTableName) {
        boolean tableExists = false;
        
        try {
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);
            
            while (rsDBMeta.next()) {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                
                if (tableName.compareToIgnoreCase(newTableName) == 0) 
                {
                    tableExists = true;
                }
            }
            if (rsDBMeta != null) 
            {
                rsDBMeta.close();
            }
        } catch (SQLException ex) 
        {
            
        }
        
        return tableExists;
    }
    
}
