package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.sweeper.Box;
import main.sweeper.Coord;
import main.sweeper.Game;
import main.sweeper.Ranges;

public class Main extends JFrame {
	private JPanel panel;
	private Game game;
	private JLabel label;

	private static final int IMAGE_SIZE = 50;
	private static final int COLS = 9;
	private static final int ROWS = 9;
	private static final int BOMBS = 10;

	public static void main(String[] args) {
		System.out.println("Start programm");
		new Main();
		System.out.println("End programm");
	}

	private Main() {
		game = new Game(COLS, ROWS, BOMBS);
		game.start();
		setImages();
		initPanel();
		initLabel();
		initFrame();
	}

	private void initLabel() {
		label = new JLabel(getMessage());
		Font font = new Font("Tahoma", Font.BOLD, 20);
		label.setFont(font);
		add(label, BorderLayout.SOUTH);
	}

	private void initPanel() {
		panel = new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				for (Coord coord : Ranges.getAllCoords()) {
					g.drawImage((Image) game.getBox(coord).getImage(), coord.getX() * IMAGE_SIZE,
							coord.getY() * IMAGE_SIZE, this);
				}
			}
		};

		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX() / IMAGE_SIZE;
				int y = e.getY() / IMAGE_SIZE;
				Coord coord = new Coord(x, y);

				switch (e.getButton()) {
				case MouseEvent.BUTTON1:
					game.pressLeftButton(coord);
					break;
				case MouseEvent.BUTTON3:
					game.pressRightButton(coord);
					break;
				case MouseEvent.BUTTON2:
					game.start();
					break;
				}
				label.setText(getMessage());
				panel.repaint();
			}
		});

		panel.setPreferredSize(
				new Dimension(Ranges.getSize().getX() * IMAGE_SIZE, Ranges.getSize().getY() * IMAGE_SIZE));
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

	private String getMessage() {
		switch (game.getState()) {

		case BOMBED:
			return "Ba-Da-Boom! You lose!";
		case WINNER:
			return "Congratulation! All bombs have been marked!";
		case PLAYED:
			default:
				if(game.getTotalFlaget()==0)return "Welcome!";
				return "Think twice! Flagget "
						+game.getTotalFlaget()+" of "
						+game.getTotalBomb();
		}
	}
}
