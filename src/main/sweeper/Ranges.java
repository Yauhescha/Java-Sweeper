package main.sweeper;

public class Ranges {
	private static Coord size;

	public static void setSize(int cols, int rows) {
		size = new Coord(cols, rows);
		setSize(size);
	}

	static void setSize(Coord size) {
		Ranges.size = size;
	}

	public static Coord getSize() {
		return size;
	}

}
