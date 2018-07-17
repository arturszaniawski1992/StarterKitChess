package com.capgemini.chess.algorithms.implementation.exceptions;

public class InvalidPawnMoveException extends InvalidMoveException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -74513436407498767L;

	public InvalidPawnMoveException() {
		System.out.println("Pawn can not do this move!");
	}

}
