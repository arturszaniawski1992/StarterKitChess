package com.capgemini.chess.algorithms.implementation.exceptions;

public class InvalidRookMoveException extends InvalidMoveException {

	private static final long serialVersionUID = -3327363644980178151L;

	public InvalidRookMoveException() {
		System.out.println("Rook can not do this move!");
	}

}
