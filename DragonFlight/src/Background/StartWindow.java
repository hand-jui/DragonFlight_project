package Background;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// 첫 화면 

public class StartWindow extends JFrame {
	
	ImageIcon imageicon;
	Image image;
	MyPanel panel;
	JButton button; 
	
	public StartWindow() {
		
		initData();
		setInitLayout();	
		addEventListener();
		
	}
	
	public void initData() {
		
		setTitle("Start");
		setSize(600, 900);			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		button = new JButton("Gamestart");
		imageicon = new ImageIcon("images/GameBackground1.png");
		image = imageicon.getImage();
		panel = new MyPanel();
		
	}
	
	public void setInitLayout() {
		
		setVisible(true);
		panel.setLayout(new FlowLayout());
		add(panel);
		panel.add(button);
		
	}
	

	
	public void addEventListener() {

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 두번째 창
				new SelectCharacter();
				setVisible(false);

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
		new StartWindow();
	}

}
