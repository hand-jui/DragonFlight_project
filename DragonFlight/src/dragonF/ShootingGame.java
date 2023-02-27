package dragonF;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ShootingGame extends JFrame implements ActionListener {

	private BufferedImage backgroundImage;
	private int backgroundY = 0;
	private int backgroundSpeed = 5; // 5 스피드로 이동
	
	private Image bufferImage;
	private Graphics screenGraphic;
	private Audio backgroundMusic;

	private boolean isMainScreen, isLoadingScreen, isGameScreen; // 화면 관련 불리언 플래그 3개

	private Game game = new Game(); //

	public ShootingGame() {
		flowBackGround(); // 주이 타이머 코드
		initData();
		setInitLayout();
		addEventListener();
		gameStart();
	}

	private void initData() {
		backgroundMusic = new Audio("Audio/dragon_flight.wav", true);
		backgroundMusic.start();
		setTitle("Shooting Game");
		// setUndecorated(true);
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(600, 900);
	}

	private void setInitLayout() {
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
	}

	private void addEventListener() {
		isGameScreen = true;
		addKeyListener(new KeyListener());
	}

	// 게임 시작 메서드
	private void gameStart() {
		isGameScreen = true;
		game.start(); // game에 런 메서드 실행
	}

	public void flowBackGround() {
		try {
			backgroundImage = ImageIO.read(new File("images/GameBackground1.png"));
		} catch (IOException e) {
			System.out.println("이미지경로확인");
		}
		javax.swing.Timer timer = new javax.swing.Timer(30, this);
		timer.start(); // 시간 초 스타트

	}

	// 이부분 모름
	public void paint(Graphics g) {
		bufferImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = bufferImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(bufferImage, 0, 0, null);
	}

	// 실행되면 화면 그려주는 부분
	public void screenDraw(Graphics g) {
		// true일 때 실행, 배경이미지 그려주는 곳
		if (isGameScreen) {
			// g.drawImage(gameScreen, 0, 0, null);
			g.drawImage(backgroundImage, 0, -backgroundY, null);
			g.drawImage(backgroundImage, 0, -backgroundY - backgroundImage.getHeight(), null);
			game.gameDraw(g);
		}
		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		backgroundY -= backgroundSpeed;
		if (backgroundY <= -backgroundImage.getHeight()) {
			backgroundY = 0;
		}
		repaint();
	}

	// 키 입력 받아 처리하는 내부 클래스
	class KeyListener extends KeyAdapter {

		// 키 누를 때 true로 만들어 실행
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
//			case KeyEvent.VK_UP:
//				game.setUp(true);
//				break;
//			case KeyEvent.VK_DOWN:
//				game.setDown(true);
//				break;
			case KeyEvent.VK_LEFT:
				game.setLeft(true);
				break;
			case KeyEvent.VK_RIGHT:
				game.setRight(true);
				break;
			// 리셋 키
			case KeyEvent.VK_R:
				if (game.isOver())
					game.reset();
				break;
			case KeyEvent.VK_SPACE:
				game.setShooting(true);
				break;
			case KeyEvent.VK_ESCAPE:
				System.exit(0);
				break;
			}
		}

		// 키 뗄 떄 false로 만듬
		public void keyReleased(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				game.setUp(false);
				break;
			case KeyEvent.VK_DOWN:
				game.setDown(false);
				break;
			case KeyEvent.VK_LEFT:
				game.setLeft(false);
				break;
			case KeyEvent.VK_RIGHT:
				game.setRight(false);
				break;
			case KeyEvent.VK_SPACE:
				game.setShooting(false);
				break;
			}
		}
	}
}
