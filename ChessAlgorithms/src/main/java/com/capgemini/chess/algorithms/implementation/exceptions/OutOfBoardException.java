package com.capgemini.chess.algorithms.implementation.exceptions;

public class OutOfBoardException extends Exception {

	private static final long serialVersionUID = 5984670876112265780L;

	public OutOfBoardException() {
		System.out.println("The Piece is out of board! Is illegal!");
	}

}
