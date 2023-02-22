package test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable {

	private int x;
	private int y;
	private ImageIcon player;

//	플레이어의 현재 움직임 상태
	private boolean left;
	private boolean right;
//	private boolean up;
//	private boolean down;

	private final int SPEED = 2;

	public Player() {
		initData();
		setInitLayout();
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	private void initData() {
		player = new ImageIcon("images/player.png");

		left = false;
		right = false;
	}

	private void setInitLayout() {
		x = 80;
		y = 750;
		setSize(100, 100);
		setLocation(x, y);
		setIcon(player);

	}

	@Override
	public void left() {
		left = true;
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (left) {
					x -= SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	@Override
	public void right() {
		right = true;
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (right) {
					x += SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	@Override
	public void up() {

	}

	@Override
	public void down() {

	}
} // end of class
