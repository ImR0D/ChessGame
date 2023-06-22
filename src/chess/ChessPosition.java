package chess;

import boardgame.Position;

public class ChessPosition {
	
	private int row;
	private char column;
	
	public int getRow() {
		return this.row;
	}
	public char getColumn() {
		return this.column;
	}
	
	public ChessPosition(char column, int row) {
		Character col = Character.toLowerCase(column);
		if ( !(col < 'a' || col > 'h' || row < 1 || row > 8) ) {
			this.column = column;
			this.row = row;
		} else {
			throw new ChessException("Error instantiating ChessPosition. Valid values are from A1 to H8");
		}
	}
	
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	protected ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
	}
	
	@Override
	public String toString() {
		return String.format("(%s, %s)", row, column);
	}
}
