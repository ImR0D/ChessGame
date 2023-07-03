package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
	
	public King(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "K";
	}
	
	
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return (p == null) || !(p.getColor() == getColor());
	}
	
	
	@Override
	public boolean[][] possibleMoves() {
		boolean moves[][] = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);
		
		// North Movement
		p.setValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			moves[p.getRow()][p.getColumn()] = true;
		}
		
		// NorthEast Movement
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			moves[p.getRow()][p.getColumn()] = true;
		}
		
		// East Movement
		p.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			moves[p.getRow()][p.getColumn()] = true;
		}
		
		// SouthEast Movement
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			moves[p.getRow()][p.getColumn()] = true;
		}

		// South Movement
		p.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			moves[p.getRow()][p.getColumn()] = true;
		}

		// SouthWest Movement
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			moves[p.getRow()][p.getColumn()] = true;
		}

		// West Movement
		p.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			moves[p.getRow()][p.getColumn()] = true;
		}
		
		// NorthWest Movement
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			moves[p.getRow()][p.getColumn()] = true;
		}
		
		
		return moves;
	}
}
