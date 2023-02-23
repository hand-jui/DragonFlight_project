package dragonflite_ex;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bullet2 extends JLabel {

	private int x;
	private int y;

	private boolean up;

	private int state;

	private ImageIcon bullet;

	private Frame mContext;
	
	

	public Bullet2(Frame mContext) {
		this.mContext = mContext;
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
		x = mContext.getPlayer().getX();
		y = mContext.getPlayer().getY();
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
			if (Math.abs(x - mContext.getEnemy().getX()) < 80 && Math.abs(y - mContext.getEnemy().getY()) < 80) {
				if (mContext.getEnemy().getState() == 0) {
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
		mContext.getEnemy().setState(1);
		state = 1;
		mContext.getEnemy().setIcon(null);
		mContext.remove(mContext.getEnemy());
		mContext.repaint();
	}
}
