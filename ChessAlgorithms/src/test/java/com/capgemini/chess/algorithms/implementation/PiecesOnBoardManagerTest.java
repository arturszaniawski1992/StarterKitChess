package com.capgemini.chess.algorithms.implementation;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class PiecesOnBoardManagerTest {

	@Test
	public void shouldFindCooridinatesOfKing() {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(5, 2));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(2, 1));
		PiecesOnBoardManager piecesOnBoardManager = new PiecesOnBoardManager(board);
		// when
		Coordinate kingsCoordinateWhite = piecesOnBoardManager.findKing(Color.WHITE);
		Coordinate kingsCoordinateBlack = piecesOnBoardManager.findKing(Color.BLACK);
		// then
		assertEquals(new Coordinate(5, 2), kingsCoordinateWhite);
		assertEquals(new Coordinate(2, 1), kingsCoordinateBlack);
	}

	@Test
	public void shouldGiveSizeOfList() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_QUEEN, new Coordinate(0, 0));
		board.setPieceAt(Piece.WHITE_ROOK, new Coordinate(1, 0));
		board.setPieceAt(Piece.WHITE_PAWN, new Coordinate(2, 0));
		board.setPieceAt(Piece.WHITE_PAWN, new Coordinate(3, 0));
		board.setPieceAt(Piece.WHITE_PAWN, new Coordinate(4, 0));
		board.setPieceAt(Piece.WHITE_PAWN, new Coordinate(5, 0));
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(7, 0));
		board.setPieceAt(Piece.BLACK_BISHOP, new Coordinate(0, 1));
		board.setPieceAt(Piece.BLACK_ROOK, new Coordinate(0, 2));
		board.setPieceAt(Piece.BLACK_BISHOP, new Coordinate(0, 3));
		board.setPieceAt(Piece.BLACK_PAWN, new Coordinate(0, 4));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(0, 5));
		PiecesOnBoardManager piecesOnBoardManager = new PiecesOnBoardManager(board);

		// when
		List<Coordinate> blackPieces = piecesOnBoardManager.findPieces(Color.BLACK);
		List<Coordinate> whitePieces = piecesOnBoardManager.findPieces(Color.WHITE);

		// then
		assertEquals(5, blackPieces.size());
		assertEquals(7, whitePieces.size());
	}

}
