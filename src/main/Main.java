package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.sweeper.Box;
import main.sweeper.Coord;
import main.sweeper.Ranges;

public class Main extends JFrame {

	private static final int IMAGE_SIZE = 50;
	private static final int COLS = 15;
	private static final int ROWS = 10;

	private JPanel panel;

	public static void main(String[] args) {
		new Main();
	}

	private Main() {
		Ranges.setSize(COLS, ROWS);
		setImages();
		initPanel();
		initFrame();
	}

	private void initPanel() {
		panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				for (Box box : Box.values()) {
					Coord coord = new Coord(box.ordinal(), 0);
					g.drawImage((Image) box.getImage(), coord.getX() * IMAGE_SIZE, coord.getY() * IMAGE_SIZE, this);
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
	}
}
