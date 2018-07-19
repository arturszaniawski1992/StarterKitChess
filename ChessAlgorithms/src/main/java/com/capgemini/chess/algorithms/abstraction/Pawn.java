package com.capgemini.chess.algorithms.abstraction;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidPawnMoveException;

public class Pawn extends PieceAbstraction implements MovesAllowed {

	public Pawn(Color color) {
		super(color);
	}

	int deltaX;
	int deltaY;

	@Override
	public MoveType checkMoveValid(Board board, Coordinate from, Coordinate to) throws InvalidMoveException {
		initialPawnValidation(from, to);
		return getMoveType(board, from, to);

	}

	@Override
	protected void validateMoveDirection(Coordinate from, Coordinate to) throws InvalidMoveException {
		if (color.equals(Color.BLACK)) {
			if (!(isWestDirection(deltaX, deltaY) || isSouthWestDirection(deltaX, deltaY)
					|| isNorthWestDirection(deltaX, deltaY))) {
				throw new InvalidPawnMoveException();
			}
		} else {
			if (!(isNorthEastDirection(deltaX, deltaY) || isEastDirection(deltaX, deltaY)
					|| isSouthEastDirection(deltaX, deltaY))) {
				throw new InvalidPawnMoveException();
			}
		}

	}

	private void initialPawnValidation(Coordinate from, Coordinate to) throws InvalidMoveException {
		setDeltaXAndDeltaY(from, to);
		validateMoveDirection(from, to);
		validateDistanceForPawn(from, to);
	}

	private void setDeltaXAndDeltaY(Coordinate from, Coordinate to) {
		deltaX = from.getX() - to.getX();
		deltaY = from.getY() - to.getY();
	}

	private void validateDistanceForPawn(Coordinate from, Coordinate to) throws InvalidMoveException {
		if (!((Math.abs(deltaY) == 2 && deltaX == 0) || Math.abs(deltaY) == 1)) {
			throw new InvalidMoveException("Pawn cant move more than 2 square");
		}
	}

}
