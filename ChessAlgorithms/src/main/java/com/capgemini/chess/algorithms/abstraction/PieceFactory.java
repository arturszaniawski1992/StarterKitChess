package com.capgemini.chess.algorithms.abstraction;

import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.PieceType;

public class PieceFactory {
	public static PieceAbstraction createPiece(PieceType type, Color color) {

		PieceAbstraction piece = null;

		if ((PieceType.KING).equals(type)) {
			piece = new King(color);
		} else if ((PieceType.QUEEN).equals(type)) {
			piece = new Queen(color);
		} else if ((PieceType.KNIGHT).equals(type)) {
			piece = new Knight(color);
		} else if ((PieceType.BISHOP).equals(type)) {
			piece = new Bishop(color);
		} else if ((PieceType.PAWN).equals(type)) {
			piece = new Pawn(color);
		} else if ((PieceType.ROOK).equals(type)) {
			piece = new Rook(color);
		}

		return piece;
	}

}
