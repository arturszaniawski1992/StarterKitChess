package com.capgemini.chess.algorithms.abstraction;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidBishopMoveException;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class Bishop extends PieceAbstraction implements MovesAllowed {

	public Bishop(Color color) {
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
		int deltaY = from.getY() - from.getY();

		if (!(isNorthDirection(deltaX, deltaY) || isSouthDirection(deltaX, deltaY) || isEastDirection(deltaX, deltaY)
				|| isWestDirection(deltaX, deltaY)))
			throw new InvalidBishopMoveException();
	}

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