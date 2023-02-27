package Background;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// 첫 화면 (로고 수정)

public class StartWindow extends JFrame {

	ImageIcon imageicon;
	Image image;
	MyPanel panel;
	JLabel logo;


	public StartWindow() {
		initData();
		setInitLayout();
		addEventListener();
	}

	public void initData() {

		setTitle("Start");
		 setSize(600, 900);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 로고
		logo = new JLabel(new ImageIcon("images/Dragon_Flight_logo.png"));
		logo.setSize(500, 298);
		// 배경
		imageicon = new ImageIcon("images/GameBackground1.png");
		image = imageicon.getImage();
		panel = new MyPanel();
	}

	public void setInitLayout() {

		setResizable(false);
		setVisible(true);
		panel.setLayout(null);
		//로고 
		add(logo);
		logo.setLocation(40, 80);
		add(panel);
	}

	public void addEventListener() {

		// 캐릭터 선택창으로 		
		panel.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				new SelectCharacter();
				setVisible(false);
			}
		});		
	}


	// JPanel 내부 클래스 (배경 이미지)
	class MyPanel extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		    g.setFont(new Font("SB 어그로 BOLD", Font.PLAIN, 30));
//			g.setFont(new Font("함초롱바탕", Font.BOLD, 30));
			g.setColor(Color.white);
			g.drawString("화면을 클릭해주세요", 160, 630);
//			g.drawString("화면을 클릭해주세요", 160, 700);

		}
	}

	public static void main(String[] args) {
		new StartWindow();

	}

}
