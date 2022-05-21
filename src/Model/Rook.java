/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author navjo
 */
public class Rook extends Piece{
    
    public Rook(String pieceName, int potential_moves, PlayerColour colour)
    {
        super(pieceName);
        this.pieceName = pieceName;
        this.potential_moves = potential_moves;
        this.colour = colour;
        this.direction = Direction.STILL;
    }
    

    @Override
    public int CheckMove(int x_direction, int y_direction, Square pieceToMove, Square[][] board) {
       
        int check = 1;
        
        if (board[finalPosition.getX_location()][finalPosition.getY_location()].isValidLocation() == false)
            {
                check = 1;
            }
        
        return check;
    }

    @Override
    public void MakeMove(int x_direction, int y_direction, Square pieceToMove, Square[][] board) {
        
        board[finalPosition.getX_location()][finalPosition.getY_location()].setPiece(piece);
        board[x_direction][y_direction].setPiece(null); 
        
    }
}
