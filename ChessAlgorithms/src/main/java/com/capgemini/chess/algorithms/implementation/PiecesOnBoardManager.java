package com.capgemini.chess.algorithms.implementation;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.implementation.exceptions.KingInCheckException;

public class PiecesOnBoardManager {
	Board board;

	public PiecesOnBoardManager(Board board) {
		this.board = board;
	}

	public Coordinate findKing(Color color) {
		Coordinate kingsCoordinate = null;
		Piece kingPiece;
		if (color == Color.WHITE) {
			kingPiece = Piece.WHITE_KING;
		} else {
			kingPiece = Piece.BLACK_KING;
		}

		for (int rowBoard = 0; rowBoard < Board.SIZE; rowBoard++) {
			for (int columnBoard = 0; columnBoard < Board.SIZE; columnBoard++) {

				if (board.getPieces()[rowBoard][columnBoard] != null
						&& board.getPieces()[rowBoard][columnBoard].equals(kingPiece)) {
					kingsCoordinate = new Coordinate(rowBoard, columnBoard);
					return kingsCoordinate;
				}
			}
		}
		return kingsCoordinate;
	}

	public List<Coordinate> findOpponentPieces(Color color) {
		return findPieces(getOppositColor(color));
	}

	public List<Coordinate> findPieces(Color color) {
		Coordinate pieceCoordinate;
		List<Coordinate> piecesCoordinates = new ArrayList<>();
		for (int row = 0; row < Board.SIZE; row++) {
			for (int column = 0; column < Board.SIZE; column++) {
				Piece actualPiece = board.getPieces()[row][column];
				if (actualPiece != null && actualPiece.getColor() == color) {
					pieceCoordinate = new Coordinate(row, column);
					piecesCoordinates.add(pieceCoordinate);
				}
			}
		}
		return piecesCoordinates;
	}

	private Color getOppositColor(Color color) {
		if (Color.BLACK == color) {
			return Color.WHITE;
		} else {
			return Color.BLACK;
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
