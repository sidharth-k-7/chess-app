package org.chess.utils;

import org.chess.models.Position;

import java.util.Optional;

public class Validator {

    private Validator() {
    }

    /**
     * Validates the full input string: "<Piece>, <Position>"
     */
    public static Optional<ValidInput> validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            printError("Input cannot be empty. Expected format: PieceType, Position (e.g., King, D5)");
            return Optional.empty();
        }

        String[] parts = input.split(",");
        if (parts.length != 2) {
            printError("Invalid input format. Expected format: PieceType, Position (e.g:- King, D5)");
            return Optional.empty();
        }

        String pieceType = parts[0].trim();
        String posStr = parts[1].trim();

        if (!isValidPieceType(pieceType)) {
            printError("Invalid piece type. Supported pieces: Pawn, King, Queen");
            return Optional.empty();
        }

        if (!isValidPosition(posStr)) {
            printError("Invalid position. Valid columns: A-H, rows: 1-8");
            return Optional.empty();
        }

        Position position = parsePosition(posStr);

        return Optional.of(new ValidInput(pieceType, position));
    }

    private static void printError(String message) {
        System.out.println(message);
    }

    /**
     * Validates the input piece type (Allows Pawn, King, Queen only)
     */
    public static boolean isValidPieceType(String pieceType) {
        if (pieceType == null) return false;
        String lower = pieceType.toLowerCase();
        return lower.equals("pawn") || lower.equals("king") || lower.equals("queen");
    }

    /**
     * Validates the input position (Ex: "A1", "H8")
     */
    public static boolean isValidPosition(String posStr) {
        if (posStr == null || posStr.length() != 2) return false;
        char col = Character.toUpperCase(posStr.charAt(0));
        char rowChar = posStr.charAt(1);
        return (col >= 'A' && col <= 'H') && (rowChar >= '1' && rowChar <= '8');
    }

    /**
     * Parse string into Position
     */
    public static Position parsePosition(String posStr) {
        char col = Character.toUpperCase(posStr.charAt(0));
        int row = Character.getNumericValue(posStr.charAt(1));
        return new Position(col, row);
    }

    public static class ValidInput {
        private final String pieceType;
        private final Position position;

        public ValidInput(String pieceType, Position position) {
            this.pieceType = pieceType;
            this.position = position;
        }

        public String getPieceType() {
            return pieceType;
        }

        public Position getPosition() {
            return position;
        }
    }
}
