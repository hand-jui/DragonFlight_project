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

	public Bullet(Player player) {
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
				while(true) {
					y--;
					setLocation(x, y);
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}
