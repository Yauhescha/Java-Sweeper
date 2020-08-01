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
		flag.setOpenedToBox(coord);
	}

	public void pressRightButton(Coord coord) {
		flag.toggleFlagetToBox(coord);
	}

	public GameState getState() {
		return state;
	}
	
}
