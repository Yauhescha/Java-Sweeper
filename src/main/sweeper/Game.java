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
		state = GameState.PLAYED;
	}

	public void pressLeftButton(Coord coord) {
		if (isGameOver())
			return;
		openBox(coord);
		checkWinner();
	}

	public void pressRightButton(Coord coord) {
		if (isGameOver())
			return;
		flag.toggleFlagetToBox(coord);
	}

	private void checkWinner() {
		if (GameState.PLAYED == state)
			if (flag.getTotalClosed() == bomb.getTotalBomb()) {
				state = GameState.WINNER;
				flag.setFlagetToLastClosedBoxes();
			}
	}

	private void openBox(Coord coord) {
		switch (flag.get(coord)) {
		case OPENED:
			setOpenedToCloseBoxesAroundNumber(coord);
			break;
		case FLAGED:
			break;
		case CLOSED:
			switch (bomb.get(coord)) {
			case ZERO:
				openBoxesAroundZero(coord);
				break;
			case BOMB:
				openBombs(coord);
				break;
			default:
				flag.setOpenedToBox(coord);
				break;
			}
		default:
			break;

		}
	}

	void setOpenedToCloseBoxesAroundNumber(Coord coord) {
		if (Box.BOMB != bomb.get(coord))
			if (bomb.get(coord).getNumber() == flag.getCountOfFlagedBoxesAround(coord))
				for (Coord around : Ranges.getCoordsAround(coord))
					if (flag.get(around) == Box.CLOSED)
						openBox(around);
	}

	private void openBombs(Coord bombedCoord) {
		flag.setBombedToBox(bombedCoord);
		for (Coord coord : Ranges.getAllCoords())
			if (Box.BOMB == bomb.get(coord)) {
				flag.setOpenedToCloseBox(coord);
			} else {
				flag.setNobombToFlagetBomb(coord);
			}
		state = GameState.BOMBED;
	}

	private void openBoxesAroundZero(Coord coord) {
		flag.setOpenedToBox(coord);
		for (Coord around : Ranges.getCoordsAround(coord))
			openBox(around);
	}

	private boolean isGameOver() {
		if (GameState.PLAYED != state) {
			start();
			return true;
		}
		return false;
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
