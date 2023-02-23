package dragonflite_ex;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bullet extends JLabel {

	private int x;
	private int y;

	private boolean up;

	private int state;

	private ImageIcon bullet;

	private Frame mContext;

	public Bullet(Frame mContext) {
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
			setLocation(x+20, y);
			for (int i = 0; i < mContext.enemyes.length; i++) {
			if(search()) {
				mContext.enemyes[i].remove(mContext.enemyes[i]);
				mContext.enemyes[i].repaint();
			}
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean search() {
		for (int i = 0; i < mContext.enemyes.length; i++) {
			if (Math.abs(x - mContext.enemyes[i].getX()-35) < 70 && Math.abs(y - mContext.enemyes[i].getY()) < 70) {
				mContext.enemyes[i].setIcon(null); 			
				}
			}
		return true;
	}
}
