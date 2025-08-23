package org.chess.movements;

import org.chess.enums.Direction;
import org.chess.models.Position;

import java.util.Collections;
import java.util.List;

public class Pawn extends ChessPiece{

    Pawn(Position position) {
        super(position);
    }

    @Override
    public List<String> getMoves() {
        //validating the last position movement for pawn (Ex. H8 no forward movement)
        Position position = getPosition();
        if(position.getRow()==8){
            System.out.println("No valid moves available at the " +
                    "given position. Try some other.!");
            return Collections.emptyList();
        }
        return generateMoves(Direction.forwardOnly(), true);
    }
}
