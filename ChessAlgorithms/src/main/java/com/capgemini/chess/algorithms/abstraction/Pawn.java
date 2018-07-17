package com.capgemini.chess.algorithms.abstraction;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidPawnMoveException;

public class Pawn extends PieceAbstraction {

	public Pawn(Color color) {
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
		if (!((Math.abs(deltaY) == 2 && deltaX == 0) || Math.abs(deltaY) == 1) && deltaX == 0) {
			throw new InvalidPawnMoveException();
		}
		// pawn moze ruszac sie o maksymalnie 2 pola jezeli to jest jego
		// pierwszy ruch +do sprawdyenia warunki
	}
}