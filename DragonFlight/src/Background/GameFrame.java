package Background;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import dragonF.BackgroundPlayerService;
import dragonF.Enemy;
import dragonF.Player;

public class GameFrame extends JFrame {

	private GameFrame mContext = this;
	private FallingBackPanel fallingBackPanel;
	private Player player;
	private Enemy enemy;

	Enemy[] enemies = new Enemy[5];
	private int[] enemyX = { 50, 150, 250, 350, 450 };
	private int enemyY = 100;

	public GameFrame() {
		initData();
		setInitLayout();
		addEventListener();
//		player가 메모리에 올라간 상태
		new Thread(new BackgroundPlayerService(player)).start();
	}

	public Player getPlayer() {
		return player;
	}

	public Enemy getEnemy() {
		return enemy;
	}

	private void initData() {
		fallingBackPanel = new FallingBackPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(fallingBackPanel);
		setSize(600, 900);

		player = new Player(mContext);

//		적군 배열생성
//		enemy = new Enemy();
//		for (int i = 0; i < enemies.length; i++) {
//			enemies[i] = new Enemy();
//			enemies[i].setX(enemyX[i]);
//			enemies[i].setY(enemyY);
//			enemies[i].setLocation(enemies[i].getX(), enemies[i].getY());
//		}

	}

	private void setInitLayout() {
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

		fallingBackPanel.add(player);
		fallingBackPanel.add(enemy);
		for (int i = 0; i < enemies.length; i++) {
			fallingBackPanel.add(enemies[i]);
		}
		mContext.add(fallingBackPanel);
	}

	private void addEventListener() {
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if (player.isLeft() == false && player.isLeftWallCrash() == false) {
						player.left();
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (player.isRight() == false && player.isRightWallCrash() == false) {
						player.right();
					}
					break;
//				case KeyEvent.VK_SPACE:
//					player.attack();
//					break;
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
		new GameFrame();
	} // end of main

}
