package com.capgemini.chess.algorithms.data.generated;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.BoardState;
import com.capgemini.chess.algorithms.data.enums.Piece;

/**
 * Board representation. Board objects are generated based on move history.
 * 
 * @author Michal Bejm
 *
 */
public class Board {

	public static final int SIZE = 8;

	private Piece[][] pieces = new Piece[SIZE][SIZE];
	private List<Move> moveHistory = new ArrayList<>();
	private BoardState state;

	public Board() {
	}

	public List<Move> getMoveHistory() {
		return moveHistory;
	}

	public Piece[][] getPieces() {
		return pieces;
	}

	public BoardState getState() {
		return state;
	}

	public void setState(BoardState state) {
		this.state = state;
	}

	/**
	 * Sets chess piece on board based on given coordinates
	 * 
	 * @param piece
	 *            chess piece
	 * @param board
	 *            chess board
	 * @param coordinate
	 *            given coordinates
	 */
	public void setPieceAt(Piece piece, Coordinate coordinate) {
		pieces[coordinate.getX()][coordinate.getY()] = piece;
	}

	/**
	 * Gets chess piece from board based on given coordinates
	 * 
	 * @param coordinate
	 *            given coordinates
	 * @return chess piece
	 */
	public Piece getPieceAt(Coordinate coordinate) {
		return pieces[coordinate.getX()][coordinate.getY()];
	}

}
