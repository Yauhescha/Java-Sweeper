package main.sweeper;

public class Coord {
	private int x;
	private int y;

	Coord(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Coord))
			return false;

		Coord to = (Coord) obj;
		return to.x == x && to.y == y;
	}
}
