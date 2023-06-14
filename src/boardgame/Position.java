package boardgame;

public class Position {
	
	private int row = 0;
	private int column = 0;
	
	public Position() {}
	
	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public void setValues(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	protected void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	protected void setColumn(int column) {
		this.column = column;
	}
	
	@Override
	public String toString() {
		return String.format("Position: (x: %02d, y: %02d)", this.row, this.column);
	}
}
