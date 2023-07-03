package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	static Scanner ikeyboard = new Scanner(System.in);
	private static ChessMatch chessMatch = new ChessMatch();
	private static boolean[][] possibleMoves = null;
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		while (true) {
			try {
				UI.printBoard(chessMatch.getPieces());
				System.out.print("\nSource: ");
				ChessPosition src = UI.readChessPosition(ikeyboard);
				possibleMoves = chessMatch.possibleMoves(src);
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				System.out.print("Target: ");
				ChessPosition tgt = UI.readChessPosition(ikeyboard);
				ChessPiece captured = chessMatch.performChessMove(src, tgt);
			} catch (ChessException e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
}
