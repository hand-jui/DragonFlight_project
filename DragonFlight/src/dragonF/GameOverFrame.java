package dragonF;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOverFrame extends JFrame {

	ImageIcon imageicon;
	Image image;
	JPanel panel;
	JLabel gameover;

	JButton startbutton;
	JButton closebutton;

	JButton startPbutton;
	JButton closePbutton;

	public GameOverFrame() {

		initData();
		setInitLayout();
		addEventListener();
	}

	public void initData() {

		setTitle("GameOver");
		setSize(600, 900);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 게임오버
		gameover = new JLabel(new ImageIcon("images/.png"));

		panel = new JPanel();
		startbutton = new JButton(new ImageIcon("images/Re_button.png"));
		closebutton = new JButton(new ImageIcon("images/Close_button.png"));

		// 버튼 테두리 없애기
		startbutton.setBorderPainted(false);
		startbutton.setContentAreaFilled(false);
		startbutton.setFocusPainted(false);

		closebutton.setBorderPainted(false);
		closebutton.setContentAreaFilled(false);
		closebutton.setFocusPainted(false);
		// 배경이미지
		imageicon = new ImageIcon("images/GameBackground1.png");
		image = imageicon.getImage();
		panel = new MyPanel();

	}

	public void setInitLayout() {

		setResizable(false);
		setVisible(true);
		panel.setLayout(null);

		add(gameover);
		gameover.setSize(400, 154);
		gameover.setLocation(40, 80);

		add(panel);

		panel.add(startbutton);
		panel.add(closebutton);

		startbutton.setSize(200, 70);
		closebutton.setSize(200, 70);

		startbutton.setLocation(70, 700);
		closebutton.setLocation(330, 700);
	}

	public void addEventListener() {
		startbutton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				startPbutton = (JButton) e.getSource();
				startPbutton.setIcon(new ImageIcon("images/Re_Pbutton.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startbutton = (JButton) e.getSource();
				startbutton.setIcon(new ImageIcon("images/Re_button.png"));
			}
		});

		closebutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				closePbutton = (JButton) e.getSource();
				closePbutton.setIcon(new ImageIcon("images/Close_Pbutton.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				closebutton = (JButton) e.getSource();
				closebutton.setIcon(new ImageIcon("images/Close_button.png"));
			}
		});

		// 버튼 : 캐릭터 선택창으로
		startbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectCharacterFrame();
				setVisible(false);
			}
		});

		// 버튼 : 프로그램 종료
		closebutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

	// JPanel 내부 클래스 (배경 이미지)
	class MyPanel extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			g.setFont(new Font("SB 어그로 BOLD", Font.PLAIN, 100));
			g.setColor(Color.white);
			g.drawString("Game", 100, 120);
			g.drawString("Over", 120, 220);
		}
	}

	public static void main(String[] args) {
		new GameOverFrame();
	}

}
