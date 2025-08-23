package org.chess.enums;

import java.util.Collections;
import java.util.List;

public enum Direction {

    UP(0, 1), //move up (increase row)
    DOWN(0, -1), //move down (decrease row)
    LEFT(-1, 0), //move left (decrease col)
    RIGHT(1, 0), //move right (increase col)
    UP_LEFT(-1, 1), //move diagonally up-left
    UP_RIGHT(1, 1), //move diagonally up-right
    DOWN_LEFT(-1, -1), //move diagonally down-left
    DOWN_RIGHT(1, -1); //move diagonally down-right

    //horizontal movement
    public final int dc;
    //vertical movement
    public final int dr;

    Direction(int dc, int dr) {
        this.dc = dc;
        this.dr = dr;
    }

    /**
     * Method for the vertical forward movement
     * Useful for Pawn movement
     * @return list UP direction
     */
    public static List<Direction> forwardOnly() {
        return Collections.singletonList(UP);
    }

}
