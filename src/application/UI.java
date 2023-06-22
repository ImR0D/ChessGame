package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class UI {

	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
	
	public static ChessPosition readChessPosition(Scanner keyboardInput) {
		try {
			String input = keyboardInput.nextLine();
			char column = input.charAt(0);
			int row = Integer.parseInt(input.substring(1));
			return new ChessPosition(column, row);
		} catch(RuntimeException e) {
			throw new InputMismatchException("Error on reading chess position. Valid values are from A1 to H8");
		}
	}
	
	public static void printBoard(ChessPiece[][] pieces) {
		System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLACK);
		System.out.println(" ┌───────────────────────────────────────────────────────────┐\t┌──────────────────┐ ");
		System.out.println(" │                          Pieces                           │\t│     Consider     │ ");
		System.out.println(" ├───────────────────┬───────────────────┬───────────────────┤\t├──────────────────┤ ");
		System.out.println(" │ B: Bishop (Bispo) │ K: King  (Rei)    │ N: Knight (Cavalo)│\t│ " 
		+ ANSI_BLUE_BACKGROUND + ANSI_BLACK + "   " + ANSI_WHITE_BACKGROUND + ANSI_BLACK + " White Piece " 
		+ ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "\t│ ");
		System.out.println(" │ P: Pawn   (Peão)  │ Q: Queen (Rainha) │ R: Rook   (Torre) │\t│ " 
		+ ANSI_RED_BACKGROUND + ANSI_BLACK + "   " + ANSI_BLACK_BACKGROUND + ANSI_WHITE + " Black Piece " 
		+ ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "\t│ ");
		System.out.println(" └───────────────────┴───────────────────┴───────────────────┘\t└──────────────────┘ ");

		System.out.println(ANSI_RESET);
		System.out.println("\t\t\t\t   CHESS GAME BOARD\n");

		System.out.println("\t\t\t   " + ANSI_WHITE + ANSI_BLACK_BACKGROUND + " A   B   C   D   E   F   G   H " + ANSI_RESET + " ");
		for (int i = 0; i < pieces.length; i++) {
			System.out.print("\n\t\t\t" + ANSI_WHITE + ANSI_BLACK_BACKGROUND + " " + (8 - i) + " " + ANSI_RESET);
			for (int j = 0; j < pieces[i].length; j++) {
				printPiece(pieces[i][j]);
			}
			System.out.println("\n");
		}
		System.out.println("\t\t\t   " + ANSI_WHITE + ANSI_BLACK_BACKGROUND + " A   B   C   D   E   F   G   H " + ANSI_RESET + " ");
	}

	private static void printPiece(ChessPiece piece) {
		if (piece == null) {
			System.out.print(ANSI_WHITE_BACKGROUND + ANSI_BLACK + " ▫ " + ANSI_RESET);
		} else {
			if (piece.getColor() == Color.WHITE) {
				System.out.print(ANSI_BLUE_BACKGROUND + ANSI_WHITE + String.format(" %s ", piece) + ANSI_RESET);
			} else {
				System.out.print(ANSI_RED_BACKGROUND + ANSI_WHITE + String.format(" %s ", piece) + ANSI_RESET);
			}
		}
		System.out.print(" ");
	}

}
