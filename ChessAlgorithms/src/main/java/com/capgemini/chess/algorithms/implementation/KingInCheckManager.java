package com.capgemini.chess.algorithms.implementation;

import java.util.List;

import com.capgemini.chess.algorithms.abstraction.PieceAbstraction;
import com.capgemini.chess.algorithms.abstraction.PieceFactory;
import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.implementation.exceptions.KingInCheckException;

public class KingInCheckManager {

	private Board board;

	public KingInCheckManager(Board board) {
		this.board = board;
	}

	public void validateIfKingIsInCheck(Color actualPieceColor) throws InvalidMoveException, KingInCheckException {
		PiecesOnBoardManager piecesOnBoardManager = new PiecesOnBoardManager(board);
		List<Coordinate> opponentPiecesCoordinates = piecesOnBoardManager.findOpponentPieces(actualPieceColor);
		Coordinate kingsCoordinate = piecesOnBoardManager.findKing(actualPieceColor);
		boolean kingInCheck;
		for (Coordinate coord : opponentPiecesCoordinates) {
			try {
				Piece actualPiece = board.getPieceAt(coord);
				PieceAbstraction abstarctionPiece = PieceFactory.createPiece(actualPiece.getType(),
						actualPiece.getColor());
				abstarctionPiece.checkMoveValid(board, coord, kingsCoordinate);
				kingInCheck = true;
			} catch (InvalidMoveException ex) {
				kingInCheck = false;
			}
			if (kingInCheck) {
				throw new KingInCheckException();

			}
		}
	}

	public void validateKingAfterMove(Coordinate from, Coordinate to)
			throws KingInCheckException, InvalidMoveException {
		Board boardAfterMove = createTemproraryBoard(board, from, to);
		new KingInCheckManager(boardAfterMove).validateIfKingIsInCheck(board.getPieceAt(from).getColor());
	}

	private Board createTemproraryBoard(Board board, Coordinate from, Coordinate to) {
		Board temproraryBoard = new Board();

		for (int row = 0; row < board.SIZE; row++) {
			for (int column = 0; column < board.SIZE; column++) {
				Coordinate coordinate = new Coordinate(row, column);
				Piece tempPiece = board.getPieceAt(coordinate);
				temproraryBoard.setPieceAt(tempPiece, coordinate);
			}

		}

		return temproraryBoard;
	}
}