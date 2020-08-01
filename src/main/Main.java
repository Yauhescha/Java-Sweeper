package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.sweeper.Box;
import main.sweeper.Coord;
import main.sweeper.Game;
import main.sweeper.Ranges;

public class Main extends JFrame {
	private JPanel panel;
	private Game game;
	
	private static final int IMAGE_SIZE = 50;
	private static final int COLS = 9;
	private static final int ROWS = 9;


	public static void main(String[] args) {
		System.out.println("Start programm");
		new Main();
		System.out.println("End programm");
	}

	private Main() {
		game = new Game(COLS, ROWS);
		setImages();
		initPanel();
		initFrame();
	}

	private void initPanel() {
		panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				for (Coord coord:Ranges.getAllCoords()) {
					g.drawImage((Image) game.getBox(coord).getImage(), 
							coord.getX() * IMAGE_SIZE, 
							coord.getY() * IMAGE_SIZE, this);
				}
			}
		};

		panel.setPreferredSize(new Dimension(Ranges.getSize().getX() * IMAGE_SIZE, 
				Ranges.getSize().getY() * IMAGE_SIZE));
		add(panel);
	}

	private void initFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Java Sweeper");
		setVisible(true);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
	}

	private Image getImage(String name) {
		String fileName = "/img/" + name + ".png";
		ImageIcon icon = new ImageIcon(getClass().getResource(fileName));
		return icon.getImage();
	}

	private void setImages() {
		for (Box box : Box.values())
			box.setImage(getImage(box.name().toLowerCase()));
		setIconImage(getImage("icon"));
	}
}
