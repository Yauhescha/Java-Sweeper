package main.sweeper;

public enum Box {
	ZERO, NUM1, NUM2, NUM3, NUM4, NUM5, NUM6, NUM7, NUM8, BOMB,

	OPENED, CLOSED, FLAGED, BOMBED, NOBOMB;

	private Object image;

	public Object getImage() {
		return image;
	}

	public void setImage(Object image) {
		this.image = image;
	}

	Box nextNumberBox() {
		return Box.values()[this.ordinal() + 1];
	}

	int getNumber() {
		int nr = ordinal();
		if (nr >= NUM1.ordinal() && nr <= NUM8.ordinal())
			return ordinal();
		return -1;
	}
}
