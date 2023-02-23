package Background;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class resultPanel extends JPanel{

	JLabel gameLabel;  // 게임
	JLabel overLabel;  // 오버
	JLabel resultLabel;  // 점수
	
	
	private int resultScore;


	public void setResultScore(int resultScore) {
		resultLabel.setText(resultScore+"");
	}
	
	
	public resultPanel() {
		gameLabel = new JLabel("GAME");
		gameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gameLabel.setFont(new Font("SB 어그로 굵게" ,Font.PLAIN ,37));
		gameLabel.setBounds(90,120,400,200);
		
		
		overLabel = new JLabel("OVER");
		overLabel.setHorizontalAlignment(SwingConstants.CENTER);
		overLabel.setFont(new Font("SB 어그로 굵게" ,Font.PLAIN ,37));
		overLabel.setBounds(90,300,400,200);
		
		add(overLabel);
		add(gameLabel);
	
	}


	
	

}
