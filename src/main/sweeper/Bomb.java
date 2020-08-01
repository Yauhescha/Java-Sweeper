package main.sweeper;

class Bomb {
	private Matrix bombMap;
	private int totalBomb;

	Bomb(int totalBomb) {
		this.totalBomb = totalBomb;
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

		bombMap.set(Ranges.getRandomCoord(), Box.BOMB);
	}

}
