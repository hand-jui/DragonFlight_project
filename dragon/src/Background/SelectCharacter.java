package Background;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Background.StartWindow.MyPanel;
import minTest.Frame;

public class SelectCharacter extends JFrame {


	ImageIcon imageicon;
	Image image;
	MyPanel mypanel;	
		
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;


	public SelectCharacter() {
		
		initData();
		setInitLayout();
		addEventListener();

	}

	public void initData() {

		setTitle("SelectCharacter");
		setSize(800, 850);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
				
		button1 = new JButton(new ImageIcon("images/Character_Nella.png"));
		button2 = new JButton(new ImageIcon("images/Character_Rose.png"));
		button3 = new JButton(new ImageIcon("images/Character_Roxy.png"));
		button4 = new JButton(new ImageIcon("images/Character_Chloe.png"));
		
		// 캐릭터 테두리에 맞게 버튼
//		button1.setBorderPainted(false);
//		button2.setBorderPainted(false);
//		button3.setBorderPainted(false);
//		button4.setBorderPainted(false);
//		
//		button1.setContentAreaFilled(false);
//		button2.setContentAreaFilled(false);
//		button3.setContentAreaFilled(false);
//		button4.setContentAreaFilled(false);
//		
//		button1.setFocusPainted(false);
//		button2.setFocusPainted(false);
//		button3.setFocusPainted(false);
//		button4.setFocusPainted(false);
		
		
		imageicon = new ImageIcon("images/GameBackground1.png");
		image = imageicon.getImage();
		mypanel = new MyPanel();
		

	}

	public void setInitLayout() {

		setVisible(true);
		setResizable(false);		

		mypanel.add(button1);
		mypanel.add(button2);
		mypanel.add(button3);
		mypanel.add(button4);		
		mypanel.setLayout(new FlowLayout(FlowLayout.CENTER,80,80));		
		add(mypanel);


	}
	
	// 게임창으로 넘어감 
	public void addEventListener() {

		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Frame();

			}
		});
		
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Frame();

			}
		});
		
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Frame();

			}
		});
		
		button4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Frame();

			}
		});

	}
	
	// JPanel 내부 클래스 (배경 이미지)
	class MyPanel extends JPanel{
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, getWidth(), getHeight(),this);
		}
	}

	public static void main(String[] args) {
		 new SelectCharacter();
	}

}
