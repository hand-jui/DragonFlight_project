package test;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class puccaFrame extends JFrame{
	
	private JLabel background;
//	private Pucca pucca;
	public puccaFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,900);
	}
	private void setInitLayout() {
		setLayout(null);
		setVisible(true);
		setResizable(false);
	}
	private void addEventListener() {
		
	}

	public static void main(String[] args) {
		new puccaFrame();
	}
	
}
