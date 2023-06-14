package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public class ChessPiece extends Piece {
	
	private Color color;
	private int moveCount;
	
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	protected boolean isThereOponnentPiece(Position position) {
		return false; // not deployed yet!
	}

	public int getMoveCount() {
		return moveCount;
	}
	
	protected void increaseMoveCount() {
		this.moveCount++;
	}
	
	protected void decreaseMoveCount() {
		this.moveCount--;
	}
}
