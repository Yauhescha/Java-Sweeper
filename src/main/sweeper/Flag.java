package main.sweeper;

class Flag {
	private Matrix flagMap;

	void start() {
		flagMap = new Matrix(Box.CLOSED);
	}

	Box get(Coord coord) {
		return flagMap.get(coord);
	}

	void setOpenedToBox(Coord coord) {
		flagMap.set(coord, Box.OPENED);
	}

	private void setFlagetToBox(Coord coord) {
		flagMap.set(coord, Box.FLAGED);
	}

	private void setCloseedToBox(Coord coord) {
		flagMap.set(coord, Box.CLOSED);
	}

	void toggleFlagetToBox(Coord coord) {
		switch (flagMap.get(coord)) {
		case FLAGED:
			setCloseedToBox(coord);
			break;
		case CLOSED:
			setFlagetToBox(coord);
			break;
		default:
			break;
		}
	}


}
