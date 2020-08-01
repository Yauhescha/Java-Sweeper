package main.sweeper;

import java.util.ArrayList;
import java.util.Random;

public class Ranges {
	private static Coord size;
	private static ArrayList<Coord> allCoords;
	private static Random random = new Random();

	static void setSize(Coord size) {
		Ranges.size = size;
		allCoords = new ArrayList<Coord>();
		for (int x = 0; x < size.getX(); x++) {
			for (int y = 0; y < size.getY(); y++) {
				allCoords.add(new Coord(x, y));
			}
		}
	}

	public static Coord getSize() {
		return size;
	}

	public static ArrayList<Coord> getAllCoords() {
		return allCoords;
	}

	static boolean inRange(Coord coord) {
		return coord.getX() >= 0 && coord.getX() < size.getX() && coord.getY() >= 0 && coord.getY() < size.getY();
	}

	public static Coord getRandomCoord() {
		return new Coord(random.nextInt(size.getX()), random.nextInt(size.getY()));
	}

	static ArrayList<Coord> getCoordsAround(Coord coord) {
		Coord around;
		ArrayList<Coord> list = new ArrayList<Coord>();
		
		for(int x=coord.getX()-1;x<=coord.getX()+1;x++)
			for(int y=coord.getY()-1;y<=coord.getY()+1;y++)
				if(Ranges.inRange(around =new Coord(x, y)))
					if(!around.equals(coord))
						list.add(around);
		return list;
	}

	public static int getSquare() {
		return size.getX()*size.getY();
	}
}
