package main.sweeper;

public class Game {

	public Game(int cols, int rows) {
		Ranges.setSize(new Coord(cols, rows));
	}

	public Box getBox(Coord coord) {
		return Box.values()[(coord.getX() + coord.getY()) % Box.values().length];
	}
}
