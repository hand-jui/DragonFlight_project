package dragonF;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Enemy extends JLabel {

	private int state;// 상태 값 죽은지 살았는지

	private int x;
	private int y;

	private boolean down;

	private final int SPEED = 3;

	private ImageIcon enemyP;

	public Enemy() {
		initDate();
		setInitLayout();
		downThread();
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public ImageIcon getEnemyP() {
		return enemyP;
	}

	public void setEnemyP(ImageIcon enemyP) {
		this.enemyP = enemyP;
	}

	public int getSPEED() {
		return SPEED;
	}

	private void initDate() {
		enemyP = new ImageIcon("images/Enemypink.png");
		x = 275;
		y = 100;
		down = false;
		state = 0;// 상태값
	}

	private void setInitLayout() {
		setIcon(enemyP);
		setSize(100, 100);
		setLocation(x, y);
	}

	private void downThread() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				down = true;
				while (true) {
					y = y + SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

}
