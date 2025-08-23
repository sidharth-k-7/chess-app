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
        Assertions.assertTrue(moves.isEmpty(), "No valid moves available at the \" +\n" +
                "                            \"given position. Try some other.!");
    }

    @Test
    public void kingSuccessTest(){
        ChessPiece king = PieceFactory.create("King", new Position('A', 1));
        List<Direction> list = List.of(Direction.values());
        List<String> moves = king.generateMoves(list, true);
        Assertions.assertTrue(moves.contains("A2"));
        Assertions.assertTrue(moves.contains("B1"));
        Assertions.assertTrue(moves.contains("B2"));
    }

    @Test
    public void kingFailureTest(){
        ChessPiece king = PieceFactory.create("King", new Position('E', 4));
        List<Direction> list = List.of(Direction.values());
        List<String> moves = king.generateMoves(list, true);
        Assertions.assertFalse(moves.contains("E6"));
        Assertions.assertFalse(moves.contains("G6"));
    }

    @Test
    public void queenSuccessTest(){
        ChessPiece queen = PieceFactory.create("Queen", new Position('E', 4));
        List<Direction> list = List.of(Direction.values());
        List<String> moves = queen.generateMoves(list, false);
        Assertions.assertTrue(moves.contains("E8"));
        Assertions.assertTrue(moves.contains("A4"));
        Assertions.assertTrue(moves.contains("H4"));
        Assertions.assertTrue(moves.contains("E1"));
        Assertions.assertTrue(moves.contains("H4"));
        Assertions.assertTrue(moves.contains("A8"));
    }

    @Test
    public void queenFailureTest(){
        ChessPiece king = PieceFactory.create("Queen", new Position('A', 1));
        List<Direction> list = List.of(Direction.values());
        List<String> moves = king.generateMoves(list, false);
        Assertions.assertFalse(moves.contains("B3"));
        Assertions.assertFalse(moves.contains("G8"));
        Assertions.assertFalse(moves.contains("G2"));
        Assertions.assertFalse(moves.contains("C8"));
    }

}