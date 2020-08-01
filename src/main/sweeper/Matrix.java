package main.sweeper;

public class Matrix {

	private Box[][] matrix;

	Matrix(Box box) {
		matrix = new Box[Ranges.getSize().getX()][Ranges.getSize().getY()];
		for (Coord coord : Ranges.getAllCoords())
			matrix[coord.getX()][coord.getY()] = box;
	}

	Box get(Coord coord) {
		if (Ranges.inRange(coord))
			return matrix[coord.getX()][coord.getY()];
		else
			return null;
	}

	void set(Coord coord, Box box) {
		if (Ranges.inRange(coord))
			matrix[coord.getX()][coord.getY()] = box;
	}
}
