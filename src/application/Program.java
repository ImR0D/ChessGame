package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	static Scanner ikeyboard = new Scanner(System.in);
	
	public static void main(String[] args) {
		ChessMatch chessMatch = new ChessMatch();
		
		while (true) {
			try {
				UI.printBoard(chessMatch.getPieces());
				System.out.print("\nSource: ");
				ChessPosition src = UI.readChessPosition(ikeyboard);
				System.out.print("\nTarget: ");
				ChessPosition tgt = UI.readChessPosition(ikeyboard);
				ChessPiece captured = chessMatch.performChessMove(src, tgt); 
			} catch (Exception e) {
				System.out.println(e.getMessage());
				ikeyboard.next();
			}
		}
	}
}
