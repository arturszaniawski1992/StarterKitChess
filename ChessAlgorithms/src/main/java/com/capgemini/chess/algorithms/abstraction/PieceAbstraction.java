package com.capgemini.chess.algorithms.abstraction;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public abstract class PieceAbstraction {
	protected Color color;

	public PieceAbstraction(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setColorOfPiece(Color color) {
		this.color = color;
	}

	public abstract MoveType checkMoveValid(Board board, Coordinate from, Coordinate to) throws InvalidMoveException;

	protected abstract void validateMoveDirection(Coordinate from, Coordinate to) throws InvalidMoveException;

	protected MoveType getMoveType(Board board, Coordinate from, Coordinate to) throws InvalidMoveException {
		Color color = board.getPieceAt(from).getColor();
		if (board.getPieceAt(to) == null) {
			return MoveType.ATTACK;
		} else if (board.getPieceAt(to).getColor() != color) {
			return MoveType.CAPTURE;
		} else {
			throw new InvalidMoveException("This is your piece, you can not put in here");
		}
	}

}
