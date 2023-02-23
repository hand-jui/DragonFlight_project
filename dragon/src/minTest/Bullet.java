package minTest;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bullet extends JLabel {

	private int x;
	private int y;

	private boolean up;

	private int state;

	private ImageIcon bullet;

	private Player player;
	private Enemy enemy;

	public Bullet(Player player, Enemy enemy) {
		this.enemy = enemy;
		this.player = player;
		initDate();
		setInitLayout();
		initThread();
	}

	private void initDate() {
		bullet = new ImageIcon("images/gun.png");
		up = false;
		state = 0;
	}

	private void setInitLayout() {
		x = player.getX();
		y = player.getY();
		setIcon(bullet);
		setSize(10, 10);
		setLocation(x, y);
	}

	private void initThread() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				up();
			}
		}).start();
	}

	public void up() {
		while (true) {
			y--;
			setLocation(x + 20, y);
			if (Math.abs(x - enemy.getX()) < 80 && Math.abs(y - enemy.getY()) < 80) {
				if (enemy.getState() == 0) {
					crash();
				}
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void crash() {
		enemy.setState(1);
		state = 1;
		enemy.setIcon(null);
		enemy.remove(enemy);
		enemy.repaint();
	}
}
