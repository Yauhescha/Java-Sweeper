package main;

import java.awt.Dimension;

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
		panel = new JPanel();
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
