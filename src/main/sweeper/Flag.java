package main.sweeper;

public class Flag {
	private Matrix flagMap;

	void start() {
		flagMap = new Matrix(Box.CLOSED);
		Coord coord = new Coord(4, 4);
		for (Coord crd : Ranges.getCoordsAround(coord))
			flagMap.set(crd, Box.OPENED);
	}

	Box get(Coord coord) {
		return flagMap.get(coord);
	}

}
