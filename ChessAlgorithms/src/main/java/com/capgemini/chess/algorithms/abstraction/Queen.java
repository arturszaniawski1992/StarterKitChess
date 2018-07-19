package com.capgemini.chess.algorithms.abstraction;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidQueenMoveException;
import com.capgemini.chess.algorithms.implementation.exceptions.PathIsNoClearException;

public class Queen extends PieceAbstraction implements MovesAllowed {

	public Queen(Color color) {
		super(color);
	}
	int deltaX;
	int deltaY;

	@Override
	public MoveType checkMoveValid(Board board, Coordinate from, Coordinate to) throws InvalidMoveException {
		validateMoveDirection(from, to);
		int pathToPiece = Math.abs(from.getX()) - Math.abs(to.getX());
		try {
			validateMoveAndClearPath(board, from, to, pathToPiece);
		} catch (PathIsNoClearException e) {
			e.printStackTrace();
		}
		return getMoveType(board, from, to);
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
