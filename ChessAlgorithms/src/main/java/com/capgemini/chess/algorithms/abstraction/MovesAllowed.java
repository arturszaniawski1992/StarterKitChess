package com.capgemini.chess.algorithms.abstraction;

public interface MovesAllowed {
	// stworzenie koordynatow do poruszania sie w kazdym kierunku na planszy,
	// czy dany kierunek jest mozliwy dla pionka

	// deltaX = from.getX - to.getX
	// deltaY = from.getX - to.getY

	default boolean isNorthDirection(int deltaX, int deltaY) {
		return deltaX == 0 && deltaY > 0;
	}

	default boolean isSouthDirection(int deltaX, int deltaY) {
		return deltaX == 0 && deltaY < 0;
	}

	default boolean isWestDirection(int deltaX, int deltaY) {
		return deltaX > 0 && deltaY == 0;
	}

	default boolean isEastDirection(int deltaX, int deltaY) {
		return deltaX < 0 && deltaY == 0;
	}

	default boolean isNorthEastDirection(int deltaX, int deltaY) {
		return deltaX < 0 && deltaY > 0 && Math.abs(deltaX) == Math.abs(deltaY);
	}

	default boolean isNorthWestDirection(int deltaX, int deltaY) {
		return deltaX > 0 && deltaY > 0 && Math.abs(deltaX) == Math.abs(deltaY);
	}

	default boolean isSouthEastDirection(int deltaX, int deltaY) {
		return deltaX < 0 && deltaY < 0 && Math.abs(deltaX) == Math.abs(deltaY);
	}

	default boolean isSouthWestDirection(int deltaX, int deltaY) {
		return deltaX > 0 && deltaY < 0 && Math.abs(deltaX) == Math.abs(deltaY);

	}

}
