package com.capgemini.chess.algorithms.implementation.exceptions;

public class InvalidMoveTheSamePositionException extends Exception {

	private static final long serialVersionUID = 4273966627303812541L;

	public InvalidMoveTheSamePositionException() {
		System.out.println("You can not move the piece to the same position!");
	}
}
