package com.capgemini.chess.algorithms.implementation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class KingInCheckManagerTest {

	@Test
	public void shouldThrowInvalidMoveExceptionWhenKingIsInCheck() {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(0, 7));
		board.setPieceAt(Piece.WHITE_PAWN, new Coordinate(1, 6));
		board.setPieceAt(Piece.WHITE_BISHOP, new Coordinate(2, 5));
		boolean exceptionThrown = false;
		KingInCheckManager checkKing = new KingInCheckManager(board);
		// when
		try {
			checkKing.validateIfKingIsInCheck(Color.BLACK);
		} catch (InvalidMoveException ex) {
			exceptionThrown = true;
		}
		// then
		assertTrue(exceptionThrown);
	}

	@Test
	public void shouldNotThrowInvalidMoveExceptionWhenKingIsNotOnCheckByTwoOpponents() {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(0, 7));
		board.setPieceAt(Piece.WHITE_ROOK, new Coordinate(2, 7));
		board.setPieceAt(Piece.WHITE_BISHOP, new Coordinate(2, 5));
		boolean exceptionThrown = false;
		KingInCheckManager checkKing = new KingInCheckManager(board);
		// when
		try {
			checkKing.validateIfKingIsInCheck(Color.BLACK);
		} catch (InvalidMoveException ex) {
			exceptionThrown = true;
		}
		// then
		assertTrue(exceptionThrown);
	}
	
	@Test
	public void shouldNotThrowInvalidMoveExceptionWhenKingIsNotInCheck() {
		//given
		Board board = new Board();
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(0, 7));
		board.setPieceAt(Piece.WHITE_PAWN, new Coordinate(1, 6));
		board.setPieceAt(Piece.WHITE_BISHOP, new Coordinate(2, 5));
		boolean exceptionThrown=false;
		KingInCheckManager checkKing = new KingInCheckManager(board);
		//when
		try{
			checkKing.validateIfKingIsInCheck(Color.BLACK);
		} catch(InvalidMoveException ex){
			exceptionThrown = true;
		}
		//then
		assertTrue(exceptionThrown);
	}

}