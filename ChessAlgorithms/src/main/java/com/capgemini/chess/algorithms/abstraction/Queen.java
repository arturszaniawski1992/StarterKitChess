package com.capgemini.chess.algorithms.abstraction;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidQueenMoveException;

public class Queen extends PieceAbstraction implements MovesAllowed {

	public Queen(Color color) {
		super(color);
	}

	@Override
	public MoveType checkMoveValid(Board board, Coordinate from, Coordinate to) throws InvalidMoveException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void validateMoveDirection(Coordinate from, Coordinate to) throws InvalidMoveException {
		int deltaX = from.getX() - to.getX();
		int deltaY = from.getY() - to.getY();
		if (!(isNorthDirection(deltaX, deltaY) || isSouthDirection(deltaX, deltaY) || isEastDirection(deltaX, deltaY)
				|| isWestDirection(deltaX, deltaY) || isNorthEastDirection(deltaX, deltaY)
				|| isNorthWestDirection(deltaX, deltaY) || isSouthEastDirection(deltaX, deltaY)
				|| isSouthWestDirection(deltaX, deltaY)))
			throw new InvalidQueenMoveException();

	}

}
