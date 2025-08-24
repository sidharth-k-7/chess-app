package org.chess.movements;


import org.chess.enums.Direction;
import org.chess.models.Position;

import java.util.List;

public class King extends ChessPiece {

    public King(Position position) {
        super(position);
    }

    @Override
    public List<String> getMoves() {
        return generateMoves(Direction.allDirection(), true);
    }

}
