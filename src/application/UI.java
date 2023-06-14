package application;

import chess.ChessPiece;

public class UI {

	public static void printBoard(ChessPiece[][] pieces) {
		
		System.out.println("Pieces: ");
		System.out.println(" B: Bishop (Bispo) | K: King  (Rei)    | N: Knight (Cavalo)");
		System.out.println(" P: Pawn   (Peão)  | Q: Queen (Rainha) | R: Rook   (Torre)\n");
		
		System.out.println("\t\t CHESS GAME BOARD\n");
		
		System.out.println("\t    a   b   c   d   e   f   g   h");
		for (int i = 0; i < pieces.length; i++) {
			System.out.print("\n\t" + (8 - i) + "  ");
			for (int j = 0; j < pieces[i].length; j++) {
				printPiece(pieces[i][j]);
			}
			System.out.println("\n");
		}
		System.out.println("\t    a   b   c   d   e   f   g   h");
	}
	
	private static void printPiece(ChessPiece piece) {
		if (piece == null) {
			System.out.print(" ▫ ");
		} else {
			System.out.print(String.format(" %s ", piece));
		}
		System.out.print(" ");
	}
	
}
