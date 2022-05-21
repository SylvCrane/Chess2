package Model;

/**
 * This is used for determining the direction the piece will take when it needs to move. Some are exclusive to one piece, such as the NNE, NEE, SSE etc. commands.
 * These are used exclusively by the knight as a result of its unique movement style.
 * 
 * @author navjo
 */
public enum Direction {
    
    STILL, NORTH, EAST, WEST, SOUTH, NORTHWEST, NORTHNORTHWEST, NORTHWESTWEST, NORTHEAST, NORTHNORTHEAST, NORTHEASTEAST, SOUTHWEST, SOUTHSOUTHWEST, SOUTHWESTWEST,  SOUTHEAST, SOUTHSOUTHEAST, SOUTHEASTEAST;
    
}
