package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.sweeper.Box;

public class Main extends JFrame {

	private static final int IMAGE_SIZE = 50;
	private static final int COLS = 15;
	private static final int ROWS = 10;

	private JPanel panel;

	public static void main(String[] args) {
		new Main();
	}

	private Main() {
		setImages();
		initPanel();
		initFrame();
	}

	private void initPanel() {
		panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				for(Box box:Box.values())
				g.drawImage((Image) box.getImage(),
						box.ordinal()*IMAGE_SIZE, 0, this);
			}
		};

		panel.setPreferredSize(new Dimension(COLS * IMAGE_SIZE, ROWS * IMAGE_SIZE));
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
		String fileName="/img/" + name + ".png";
		ImageIcon icon = new ImageIcon(getClass().getResource(fileName));
		return icon.getImage();
	}

	private void setImages() {
		for(Box box:Box.values())
			box.setImage(getImage(box.name().toLowerCase()));
	}
}
