package main.sweeper;

public class Game {
	Matrix bombMap;

	public Game(int cols, int rows) {
		Ranges.setSize(new Coord(cols, rows));
	}

	public Box getBox(Coord coord) {
		return bombMap.get(coord);
	}

	public void start() {
		bombMap = new Matrix(Box.ZERO);
		bombMap.set(new Coord(0, 0), Box.BOMB);
		bombMap.set(new Coord(1, 0), Box.NUM1);
		bombMap.set(new Coord(1, 1), Box.NUM1);
		bombMap.set(new Coord(0, 1), Box.NUM1);
	}
}
