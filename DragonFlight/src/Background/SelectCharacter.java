package Background;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dragonF.Frame;

public class SelectCharacter extends JFrame {


	private JPanel panel1;
	private JPanel panel2;	
	
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
		setSize(800, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel1 = new JPanel();
		panel2 = new JPanel();				
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

	}

	public void setInitLayout() {

		setVisible(true);
		setResizable(false);
		add(panel1,BorderLayout.NORTH);
		add(panel2,BorderLayout.CENTER);

		panel1.add(button1);
		panel1.add(button2);
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER,80,80));
		panel2.add(button3);
		panel2.add(button4);
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER,80,60));

	}

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

	public static void main(String[] args) {
		 new SelectCharacter();
	}

}
