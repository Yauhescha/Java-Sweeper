package main;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;

public class Main extends JFrame {

	private JPanel panel;

	public static void main(String[] args) {
		new Main();
	}

	private Main() {
		initPanel();
		initFrame();
	}

	private void initPanel() {
		panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawLine(0, 0, 500, 300);
			}
		};
		
		panel.setPreferredSize(new Dimension(500, 300));
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

}
