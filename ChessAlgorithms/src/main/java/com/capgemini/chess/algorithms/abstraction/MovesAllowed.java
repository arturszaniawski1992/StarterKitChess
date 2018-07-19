package com.capgemini.chess.algorithms.abstraction;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.PathIsNoClearException;

public interface MovesAllowed {

	default boolean isNorthDirection(int deltaX, int deltaY) {
		return deltaX > 0 && deltaY == 0;
	}

	default boolean isSouthDirection(int deltaX, int deltaY) {
		return deltaX < 0 && deltaY == 0;
	}

	default boolean isWestDirection(int deltaX, int deltaY) {
		return deltaX == 0 && deltaY > 0;
	}

	default boolean isEastDirection(int deltaX, int deltaY) {
		return deltaX == 0 && deltaY < 0;
	}

	default boolean isNorthEastDirection(int deltaX, int deltaY) {
		return deltaX > 0 && deltaY < 0 && Math.abs(deltaX) == Math.abs(deltaY);
	}

	default boolean isNorthWestDirection(int deltaX, int deltaY) {
		return deltaX > 0 && deltaY > 0 && Math.abs(deltaX) == Math.abs(deltaY);
	}

	default boolean isSouthEastDirection(int deltaX, int deltaY) {
		return deltaX < 0 && deltaY < 0 && Math.abs(deltaX) == Math.abs(deltaY);
	}

	default boolean isSouthWestDirection(int deltaX, int deltaY) {
		return deltaX < 0 && deltaY > 0 && Math.abs(deltaX) == Math.abs(deltaY);
	}

	default void validatePathIsClear(Board board, Coordinate from, Coordinate to, int boardX, int boardY,
			int pathToPiece) throws PathIsNoClearException {
		for (int iterator = 1; iterator < pathToPiece; iterator++) {
			if (board.getPieceAt(
					new Coordinate(from.getX() + boardX * iterator, from.getY() + boardY * iterator)) != null)
				throw new PathIsNoClearException();

		}
	}

	default void validateMoveAndClearPath(Board board, Coordinate from, Coordinate to, int pathToPiece)
			throws PathIsNoClearException {
		int deltaX = from.getX() - to.getX();
		int deltaY = from.getY() - to.getY();

		if (isNorthDirection(deltaX, deltaY)) {
			validatePathIsClear(board, from, to, -1, 0, pathToPiece);
		} else if (isSouthDirection(deltaX, deltaY)) {
			validatePathIsClear(board, from, to, 1, 0, pathToPiece);
		} else if (isEastDirection(deltaX, deltaY)) {
			validatePathIsClear(board, from, to, 0, 1, pathToPiece);
		} else if (isWestDirection(deltaX, deltaY)) {
			validatePathIsClear(board, from, to, 0, -1, pathToPiece);
		} else if (isNorthEastDirection(deltaX, deltaY)) {
			validatePathIsClear(board, from, to, -1, 1, pathToPiece);
		} else if (isNorthWestDirection(deltaX, deltaY)) {
			validatePathIsClear(board, from, to, -1, -1, pathToPiece);
		} else if (isSouthEastDirection(deltaX, deltaY)) {
			validatePathIsClear(board, from, to, 1, 1, pathToPiece);
		} else if (isSouthWestDirection(deltaX, deltaY)) {
			validatePathIsClear(board, from, to, 1, -1, pathToPiece);
		}

	}

}
