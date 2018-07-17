package com.capgemini.chess.algorithms.implementation;

import java.awt.Color;

import com.capgemini.chess.algorithms.abstraction.King;
import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.generated.Board;

public class KingInCheckManager {

	public Coordinate findKing(com.capgemini.chess.algorithms.data.enums.Color color) {
		Coordinate coordinateOfKing = null;
		Board board = new Board();
		for (int boardX = 0; boardX < Board.SIZE; boardX++) {
			for (int boardY = 0; boardY < Board.SIZE; boardY++) {
				if (board.getPieces()[boardX][boardY] != null
						&& board.getPieces()[boardX][boardY].equals(new King(color))) {
					coordinateOfKing = new Coordinate(boardX, boardY);
				}

			}

		}
		return coordinateOfKing;
	}

	public Color findOppositePiecesColor(Color color) {
		if (Color.BLACK == color) {
			return Color.WHITE;
		} else {
			return Color.BLACK;
		}
	}

}
