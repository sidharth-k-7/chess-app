package org.chess.movements;

import org.chess.enums.Direction;
import org.chess.interfaces.Movable;
import org.chess.models.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class ChessPiece implements Movable {

    private final Position position;

    public ChessPiece(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Position must not be null.");
        }
        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }

    /**
     * Generates all possible moves for the pieces based on the provided direction.
     * Throws IllegalArgumentException if directions are null.
     *
     * @param directions List of directions that a piece can move
     * @param singleStep If true, only one step per direction (Eg: 1 step for Pawn, King)
     * @return List of Strings of valid move positions
     */
    List<String> generateMoves(List<Direction> directions, boolean singleStep) {

        if (directions == null) {
            throw new IllegalArgumentException("Directions must not be null.");
        }

        List<String> moves = new ArrayList<>();
        for (Direction dir : directions) {
            int step = 1;
            while (true) {
                Position next = position.move(dir.dc * step, dir.dr * step);
                if (next == null || !next.isValid()) break;
                moves.add(next.toString());
                if (singleStep) break;
                step++;
            }
        }
        return moves;
    }

}
