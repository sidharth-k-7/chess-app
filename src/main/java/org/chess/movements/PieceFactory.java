package org.chess.movements;

import org.chess.models.Position;

public class PieceFactory {

    /**
     * Creates a ChessPiece instance based on pieceType and position.
     * Throws IllegalArgumentException for nulls and unsupported types.
     *
     * @param pieceType The type of chess piece (Pawn, King, Queen)
     * @param position The initial position of the piece (A1, H1)
     * @return Chess piece instance based on the type provided
     */
    public static ChessPiece create(String pieceType, Position position) {

        if (pieceType == null || position == null) {
            throw new IllegalArgumentException("Piece type and position must not be null.");
        }

        switch (pieceType.trim().toLowerCase()) {
            case "pawn":
                return new Pawn(position);
            default:
                throw new IllegalArgumentException("Unsupported piece type: " + pieceType);
        }
    }
}
