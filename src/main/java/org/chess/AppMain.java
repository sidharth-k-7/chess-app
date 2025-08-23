package org.chess;

import org.chess.models.Position;
import org.chess.movements.ChessPiece;
import org.chess.movements.PieceFactory;
import org.chess.utils.Validator;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AppMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input (e.g:- Pawn, G1):");

        String input = scanner.nextLine();

        // Delegate all validation to the validator
        Optional<Validator.ValidInput> validInput = Validator.validateInput(input);

        if (validInput.isEmpty()) {
            return;
        }

        Validator.ValidInput parsedInput = validInput.get();
        ChessPiece piece = PieceFactory.create(parsedInput.getPieceType(), parsedInput.getPosition());
        List<String> moves = piece.getMoves();

        System.out.println(String.join(", ", moves));
    }
}
