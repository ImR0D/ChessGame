package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Queen;
import chess.pieces.Rook;

public class ChessMatch {

	private Board board;
	
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}
		
	public ChessPiece[][] getPieces() {
		ChessPiece[][] chessPiece = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				chessPiece[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return chessPiece;
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		Piece capturedPosition = makeMove(source, target);
		return (ChessPiece) capturedPosition;
	}
	
	private void validateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position");
		}
	}
	
	private Piece makeMove(Position source, Position target) {
		
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		
		return capturedPiece;
	}
	
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(Character.toLowerCase(column), row).toPosition());
	}
	
	private void initialSetupWhitePiece() {
		placeNewPiece('A', 1, new Rook(board, Color.WHITE));
		placeNewPiece('B', 1, new Knight(board, Color.WHITE));
		placeNewPiece('C', 1, new Bishop(board, Color.WHITE));
		placeNewPiece('D', 1, new Queen(board, Color.WHITE));
		placeNewPiece('E', 1, new King(board, Color.WHITE));
		placeNewPiece('F', 1, new Bishop(board, Color.WHITE));
		placeNewPiece('G', 1, new Knight(board, Color.WHITE));
		placeNewPiece('H', 1, new Rook(board, Color.WHITE));
		Pawn whitePawn = new Pawn(board, Color.WHITE);
		for (int i = 0; i < 8; i++) {
			placeNewPiece((char)('a' + i), 2, whitePawn);
		}
	}
	
	private void initialSetupBlackPiece() {
		placeNewPiece('A', 8, new Rook(board, Color.BLACK));
		placeNewPiece('B', 8, new Knight(board, Color.BLACK));
		placeNewPiece('C', 8, new Bishop(board, Color.BLACK));
		placeNewPiece('D', 8, new Queen(board, Color.BLACK));
		placeNewPiece('E', 8, new King(board, Color.BLACK));
		placeNewPiece('F', 8, new Bishop(board, Color.BLACK));
		placeNewPiece('G', 8, new Knight(board, Color.BLACK));
		placeNewPiece('H', 8, new Rook(board, Color.BLACK));
		Pawn blackPawn = new Pawn(board, Color.BLACK);
		for (int i = 0; i < 8; i++) {
			placeNewPiece((char)('a' + i), 7, blackPawn);
		}
	}
	
	private void initialSetup() {
		initialSetupWhitePiece();
		initialSetupBlackPiece();
	}
	
}
