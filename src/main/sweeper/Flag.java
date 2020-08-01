package main.sweeper;

class Flag {
	private Matrix flagMap;
	private int totalFlaget;
	private int totalClosed;

	void start() {
		flagMap = new Matrix(Box.CLOSED);
		totalFlaget=0;
		totalClosed=Ranges.getSquare();
	}

	Box get(Coord coord) {
		return flagMap.get(coord);
	}

	void setOpenedToBox(Coord coord) {
		flagMap.set(coord, Box.OPENED);
		totalClosed--;
	}

	private void setFlagetToBox(Coord coord) {
		flagMap.set(coord, Box.FLAGED);
		totalFlaget++;
	}

	private void setCloseedToBox(Coord coord) {
		flagMap.set(coord, Box.CLOSED);
		totalFlaget--;
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

	int getTotalFlaget() {
		return totalFlaget;
	}

	int getTotalClosed() {
		return totalClosed;
	}

	void setFlagetToLastClosedBoxes() {
		for(Coord coord:Ranges.getAllCoords())
			if(Box.CLOSED==flagMap.get(coord))
				setFlagetToBox(coord);
	}

	void setBombedToBox(Coord coord) {
		flagMap.set(coord, Box.BOMBED);
	}

	void setOpenedToCloseBox(Coord coord) {
		if(Box.CLOSED==flagMap.get(coord))
			flagMap.set(coord, Box.OPENED);
	}

	void setNobombToFlagetBomb(Coord coord) {
		if(Box.FLAGED==flagMap.get(coord))
			flagMap.set(coord, Box.NOBOMB);
	}

	int getCountOfFlagedBoxesAround(Coord coord) {
		int count=0;
		for(Coord around:Ranges.getCoordsAround(coord))
			if(Box.FLAGED==flagMap.get(around))
				count++;
		return count;
	}

	

}

