package org.chess.movements;

import org.chess.enums.Direction;
import org.chess.models.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MovementTest {

    @Test
    public void pawnSuccessTest() {
        ChessPiece pawn = PieceFactory.create("Pawn", new Position('G', 7));
        List<Direction> list = List.of(Direction.UP);
        List<String> moves = pawn.generateMoves(list, true);
        Assertions.assertTrue(moves.contains("G8"));
    }

    @Test
    public void pawnFailureTest() {
        ChessPiece pawn = PieceFactory.create("Pawn", new Position('H', 8));
        List<Direction> list = List.of(Direction.UP);
        List<String> moves = pawn.generateMoves(list, true);
        Assertions.assertFalse(moves.equals("H9"));
    }

}