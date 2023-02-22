package test;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame extends JFrame {

	private JLabel background;
	private Player player;

	public Frame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
//		background = new JLabel(new ImageIcon(""));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setContentPane(background);
		setSize(600, 900);

		player = new Player();
	}

	private void setInitLayout() {
		setLayout(null);
		setVisible(true);
		setResizable(false);

		add(player);
	}

	private void addEventListener() {
		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					player.left();
					break;
				case KeyEvent.VK_RIGHT:
					player.right();
					break;
				}
			} // end of pressed

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					player.setLeft(false);
					break;
				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;
				}
			} // end of released

		});

	}

	public static void main(String[] args) {
		new Frame();
	} // end of main

} // end of class
