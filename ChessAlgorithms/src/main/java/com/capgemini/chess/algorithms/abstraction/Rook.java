package com.capgemini.chess.algorithms.abstraction;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidRookMoveException;
import com.capgemini.chess.algorithms.implementation.exceptions.PathIsNoClearException;

public class Rook extends PieceAbstraction implements MovesAllowed {

	public Rook(Color color) {
		super(color);
	}

	@Override
	public MoveType checkMoveValid(Board board, Coordinate from, Coordinate to) throws InvalidMoveException {

		validateMoveDirection(from, to);
		int pathToPiece;
		if (from.getX() - to.getX() != 0) {
			pathToPiece = Math.abs(from.getX() - to.getX());
		} else {
			pathToPiece = Math.abs(from.getY() - to.getY());
		}
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
				|| isWestDirection(deltaX, deltaY)))
			throw new InvalidRookMoveException();
	}

}
