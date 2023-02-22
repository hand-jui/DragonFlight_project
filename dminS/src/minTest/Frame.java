package minTest;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	public Frame() {
		initDate();
		setInitLayout();
		addEventListener();
		new Thread(new BackgroundAirplaneService(player)).start();
	}

	private void initDate() {
		backgroundMap = new JLabel(new ImageIcon("images/background3.png"));
		setTitle("Galaga");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(backgroundMap);
		setSize(600, 900);
		player = new Player();
	}

	private void setInitLayout() {
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		add(player);
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
				case KeyEvent.VK_SPACE:
					Bullet bullet = new Bullet(player); 
					add(bullet);
					break;
				}
			}
		});
	}
	public static void main(String[] args) {
		new Frame();
	}
}
