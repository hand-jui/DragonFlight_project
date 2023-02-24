package dragonF;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame extends JFrame {

	
	private Frame mContext = this;
	private JLabel backgroundMap;
	private Player player;
	private Enemy enemy;
	

	Enemy[] enemyes = new Enemy[5];
	private int[] enX = {50,150,250,350,450};
	private int enY = 100;
	
	public Player getPlayer() {
		return player;
	}

	public Enemy getEnemy() {
		return enemy;
	}

	public Frame() {
		initDate();
		setInitLayout();
		addEventListener();
		new Thread(new BackgroundPlayerService(player)).start();
		autoFire(); // 자동발사 프레임 생성할 때 자동실행
		
	}

	private void initDate() {
		backgroundMap = new JLabel(new ImageIcon("images/background3.png"));
		setTitle("Galaga");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(backgroundMap);
		setSize(600, 900);
		player = new Player(mContext);
		enemy = new Enemy();
		for (int i = 0; i < enemyes.length; i++) {
			enemyes[i] = new Enemy();
			enemyes[i].setX(enX[i]);
			enemyes[i].setY(enY);
			enemyes[i].setLocation(enemyes[i].getX(), enemyes[i].getY());
		}
	}

	private void setInitLayout() {
		Bullet bullet = new Bullet(mContext);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		add(player);
		//add(enemy);
		for (int i = 0; i < enemyes.length; i++) {
			add(enemyes[i]);
		}
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
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					// 위버튼을떄면 멈춰야해
					player.setLeft(false);
					break;

				case KeyEvent.VK_RIGHT:
					// 아래 버튼을 때면 멈춰야해
					player.setRight(false);
					break;
				}
			}
		});
	}

	// 새로 추가한 자동 발사 메서드
	private void autoFire() {
		while (true) {
			Bullet bullet = new Bullet(mContext);
			add(bullet);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new Frame();
	}
}

