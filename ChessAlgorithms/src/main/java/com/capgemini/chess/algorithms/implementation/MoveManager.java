package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.abstraction.PieceAbstraction;
import com.capgemini.chess.algorithms.abstraction.PieceFactory;
import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class MoveManager {
	private Board board;

	public MoveManager(Board board) {
		this.board = board;
	}

	public Move validateMove(Coordinate from, Coordinate to) throws InvalidMoveException {
		new MoveManager(board).initialValidation(from, to);
		Piece actualPiece = board.getPieceAt(from);
		PieceAbstraction abstarctionPiece = PieceFactory.createPiece(actualPiece.getType(), actualPiece.getColor());
		MoveType actualMoveType = abstarctionPiece.checkMoveValid(board, from, to);
		Move move = new Move();
		move.setFrom(from);
		move.setTo(to);
		new KingInCheckManager(board).validateKingAfterMove(from, to);

		return move;
	}

	public boolean isMoveValid(Coordinate from, Coordinate to) {
		try {
			validateMove(from, to);
			return true;
		} catch (InvalidMoveException e) {
			return false;
		}
	}

	private void initialValidation(Coordinate from, Coordinate to) throws InvalidMoveException {
		validateIfCoordinateIsOutOfBoard(from);
		validateIfCoordinateIsOutOfBoard(to);
		validateIfPieceIsNotNull(from);
		validateIfFromEqualsTo(from, to);
	}

	private void validateIfFromEqualsTo(Coordinate from, Coordinate to) throws InvalidMoveException {
		if (from.equals(to)) {
			throw new InvalidMoveException();
		}
	}

	private void validateIfPieceIsNotNull(Coordinate from) throws InvalidMoveException {
		if (board.getPieceAt(from) == null) {
			throw new InvalidMoveException();
		}
	}

	private void validateIfCoordinateIsOutOfBoard(Coordinate coordinate) throws InvalidMoveException {
		if (coordinate.getX() < 0 || coordinate.getX() >= Board.SIZE || coordinate.getY() < 0
				|| coordinate.getY() >= Board.SIZE) {
			throw new InvalidMoveException();
		}
	}
}