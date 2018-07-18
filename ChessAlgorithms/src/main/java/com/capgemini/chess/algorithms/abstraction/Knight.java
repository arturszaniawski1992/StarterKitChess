package com.capgemini.chess.algorithms.abstraction;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class Knight extends PieceAbstraction implements MovesAllowed {
	int deltaX;
	int deltaY;

	public Knight(Color color) {
		super(color);
	}

	@Override
	public MoveType checkMoveValid(Board board, Coordinate from, Coordinate to) throws InvalidMoveException {
		setDeltaXAndDeltaY(from, to);
		validateMoveDirection(from, to);
		return getMoveType(board, from, to);
	}

	private void setDeltaXAndDeltaY(Coordinate from, Coordinate to) {
		this.deltaX = from.getX() - to.getX();
		this.deltaY = from.getY() - to.getY();
	}

	@Override
	protected void validateMoveDirection(Coordinate from, Coordinate to) throws InvalidMoveException {

		if ((Math.abs(deltaX) == 2 && Math.abs(deltaY) == 1) || (Math.abs(deltaX) == 1 && Math.abs(deltaY) == 2)) {
		} else {
			throw new InvalidMoveException("Knight cant move that way!");
		}
	}

}