package com.capgemini.chess.algorithms.implementation.exceptions;

public class PathIsNoClearException extends Exception {

	private static final long serialVersionUID = 711938257365594574L;

	public PathIsNoClearException() {
		System.out.println("There is piece on the path!");
	}

}
