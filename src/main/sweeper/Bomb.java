package main.sweeper;

class Bomb {
	private Matrix bombMap;
	private int totalBomb;

	Bomb(int totalBomb) {
		this.totalBomb = totalBomb;
		fixBombsCount();
	}

	public void start() {
		bombMap = new Matrix(Box.ZERO);
		for (int i = 0; i < totalBomb; i++)
			placeBomb();
	}

	Box get(Coord coord) {
		return bombMap.get(coord);
	}

	private void placeBomb() {
		while(true) {
			Coord coord = Ranges.getRandomCoord();
			if(Box.BOMB== bombMap.get(coord))
				continue;
				bombMap.set(coord, Box.BOMB);
				incNumbersAroundBomb(coord);
				break;
		}

	}
	private void fixBombsCount() {
		int maxBombs = Ranges.getSize().getX()*Ranges.getSize().getY()/2;
		if (totalBomb>maxBombs)totalBomb=maxBombs;
	}
	private void incNumbersAroundBomb(Coord coord) {
		for (Coord around : Ranges.getCoordsAround(coord))
			if (Box.BOMB != bombMap.get(around))
				bombMap.set(around, bombMap.get(around).nextNumberBox());
	}

	public int getTotalBomb() {
		return totalBomb;
	}

}
