package com.capgemini.chess.algorithms.abstraction;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class King extends PieceAbstraction implements MovesAllowed {
	public King(Color color) {
		super(color);
	}

	@Override
	public MoveType checkMoveValid(Board board, Coordinate from, Coordinate to) throws InvalidMoveException {
		validateMoveDirection(from, to);
		return getMoveType(board, from, to);
	}

	@Override
	protected void validateMoveDirection(Coordinate from, Coordinate to) throws InvalidMoveException {
		int deltaX = from.getX() - to.getX();
		int deltaY = from.getY() - from.getY();
		if (Math.abs(deltaX) > 1 || Math.abs(deltaY) > 1) {
			throw new InvalidMoveException("King cant move there. It is against rules for this piece");
		}
	}

}
