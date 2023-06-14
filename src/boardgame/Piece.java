package boardgame;

public abstract class Piece {

	protected Position position = null;
	private Board board;
	
	
	public Piece(Board board) {
		this.board = board;
	}
	
	protected Board getBoard() {
		return this.board;
	}
	
	public Piece[][] possibleMoves() {
		return new Piece[0][0]; // not deployed yet!
	}
	
	public boolean possibleMove(Position position) {
		return false;
	}
	
	public boolean isThereAnyPossibleMove() {
		return false;
	}
	
	
}
