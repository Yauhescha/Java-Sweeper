package main.sweeper;

import java.util.ArrayList;

public class Ranges {
	private static Coord size;
	private static ArrayList<Coord> allCoords;

	static void setSize(Coord size) {
		Ranges.size = size;
		allCoords = new ArrayList<Coord>();
		for (int x = 0; x < size.getX(); x++) {
			for (int y = 0; y < size.getY(); y++) {
				allCoords.add(new Coord(x, y));
			}
		}
	}

	public static Coord getSize() {
		return size;
	}

	public static ArrayList<Coord> getAllCoords() {
		return allCoords;
	}

	public static boolean inRange(Coord coord) {
		return coord.getX() >= 0 && coord.getX() < size.getX() && coord.getY() >= 0 && coord.getY() < size.getY();
	}
}
