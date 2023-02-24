package dragonF;

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
				// bulletRemove();
			}
		}).start();
	}

	public void up() {
		while (true) {
			y--;
			setLocation(x + 20, y);
			for (int i = 0; i < mContext.enemyList.size(); i++) {
				if (search()) {
					mContext.enemyList.get(i).remove(mContext.enemyList.get(i));
					mContext.enemyList.get(i).repaint();
				}
<<<<<<< Updated upstream
				if(mContext.enemyList.get(i).getY() > 800) {
					mContext.enemyList.get(i).setIcon(null);
					mContext.enemyList.get(i).remove(mContext.enemyList.get(i));
=======
				
				// 이 부분 지울 것 
				if(mContext.enemyList.get(i).getY() > 800) {
//					mContext.enemyList.get(i).setIcon(null);
//					mContext.enemyList.get(i).remove(mContext.enemyList.get(i));
				}
			}
			
			
			// 총알 객체 지우는 부분 
			if (y < 100) {
				setIcon(null);
				bullet = null;
				System.out.println(y);
				if (y < 300) {
					System.out.println(bullet);
					break;
>>>>>>> Stashed changes
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
		for (int i = 0; i < mContext.enemyList.size(); i++) {
			if (Math.abs(x - mContext.enemyList.get(i).getX() - 35) < 70 && Math.abs(y -mContext.enemyList.get(i).getY()) < 70) {
				mContext.enemyList.get(i).setIcon(null);
			}
		}
		return true;
	}
}