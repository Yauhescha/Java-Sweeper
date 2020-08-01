package main.sweeper;

public class Game {
	private Bomb bomb;
	private Flag flag;
	private GameState state;

	public Game(int cols, int rows, int bombs) {
		Ranges.setSize(new Coord(cols, rows));
		bomb = new Bomb(bombs);
		flag = new Flag();
	}

	public Box getBox(Coord coord) {
		if (Box.OPENED == flag.get(coord))
			return bomb.get(coord);
		else
			return flag.get(coord);
	}

	public void start() {
		bomb.start();
		flag.start();
		state=GameState.PLAYED;
	}

	public void pressLeftButton(Coord coord) {
		openBox(coord);
	}

	private void openBox(Coord coord) {
		switch (flag.get(coord)) {
		case OPENED:		
			break;
		case FLAGED:		
			break;
		case CLOSED:		
			switch (bomb.get(coord)) {
				case ZERO:openBoxesAroundZero(coord);break;
				case BOMB:break;
				default: flag.setOpenedToBox(coord);break;
			}

		}
	}

	private void openBoxesAroundZero(Coord coord) {
		flag.setOpenedToBox(coord);
		for(Coord around:Ranges.getCoordsAround(coord))
			openBox(around);
	}

	public void pressRightButton(Coord coord) {
		flag.toggleFlagetToBox(coord);
	}

	public GameState getState() {
		return state;
	}
	public int getTotalBomb() {
		return bomb.getTotalBomb();
	}
	public int getTotalFlaget() {
		return flag.getTotalFlaget();
	}
	
}
