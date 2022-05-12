package chess2;


public abstract class Piece{
    
    /**
     * This is the name of the piece, used to differentiate between players and identical pieces.
     */
    public String pieceName = "";
    
    /**
     * This is the number of squares the piece is able to move.
     */
    public int potential_moves;
    
    /**
     * This is the direction of the piece, denoted by the enumerated type. 
     */
    public Direction direction;
    
    /**
     * This is the colour of the piece, used to differentiate between player pieces.
     */
    public PlayerColour colour;
    
    public Piece(String pieceName)
    {
        this.pieceName = pieceName;
    }
    
    /**
     * This abstract method is used to check if the move made by the piece can be completed, with the condition that
     * there is not another piece of the same colour in the destination spot or between the starting and ending positions.
     * 
     * 
     * 
     * 
     * @param piece: The piece that needs to be moved
     * @param x_direction: The x_location of the piece
     * @param y_direction: The y_location of the piece
     * @param potential_moves: The inputted potential moves the piece can make. This is dependent on the potential moves of the piece, with some exceptions.
     * @param board: The game board, a two-dimensional array of the Square class.
     * @return: an integer which states whether the move can be completed. If 1, then yes. If 0, then no.
     */
    public abstract int CheckMove(Piece piece, int x_direction, int y_direction, int potential_moves, Square[][] board);
    
    /**
     * This abstract method is used to move the piece after all other checks have been completed, excluding check.
     * 
     * @param piece: The piece that needs to be moved
     * @param x_direction: The x_location of the piece
     * @param y_direction: The y_location of the piece
     * @param potential_moves: The inputted potential moves the piece can make. This is dependent on the potential moves of the piece, with some exceptions.
     * @param board: The game board, a two-dimensional array of the Square class.
     * 
     */
    public abstract void MakeMove(Piece piece, int x_direction, int y_direction, int potential_moves, Square[][] board);

    /**
     * @return the pieceName
     */
    public String getPieceName() {
        return pieceName;
    }

    /**
     * @param pieceName the pieceName to set
     */
    public void setPieceName(String pieceName) {
        this.pieceName = pieceName;
    }

    /**
     * @return the potential_moves
     */
    public int getPotential_moves() {
        return potential_moves;
    }

    /**
     * @param potential_moves the potential_moves to set
     */
    public void setPotential_moves(int potential_moves) {
        this.potential_moves = potential_moves;
    }

    /**
     * @return the direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * @return the colour
     */
    public PlayerColour getColour() {
        return colour;
    }

    /**
     * @param colour the colour to set
     */
    public void setColour(PlayerColour colour) {
        this.colour = colour;
    }
    
   
}
