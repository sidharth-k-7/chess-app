package org.chess.models;

public class Position {

    private final char col;
    private final int row;

    public Position(char col, int row) {
        this.col = col;
        this.row = row;
    }

    /**
     * For finding the new position by moving from the current position
     *
     * @param dc column
     * @param dr row
     * @return new position after the movement calc
     */
    public Position move(int dc, int dr){
        return new Position((char) (col + dc), row + dr);
    }

    public boolean isValid() {
        return col >= 'A' && col <= 'H' && row >= 1 && row <= 8;
    }

    @Override
    public String toString() {
        return "" + col + row;
    }
}
