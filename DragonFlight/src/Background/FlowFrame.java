package Background;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FlowFrame extends JFrame implements ActionListener {

	static final int MAX_FRAME = 900;

	int frameNumber;
	Image background;

	class MyPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(background, 0, frameNumber, this);
		}
	}

	public FlowFrame() {
		ImageIcon bg = new ImageIcon("images/GameBackground1.png");
		background = bg.getImage();
		setSize(600, 900);
		Timer timer = new Timer(1, this);
		timer.start();
		add(new MyPanel());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frameNumber = (++frameNumber) % MAX_FRAME;
		repaint();
	}

	public static void main(String[] args) {
		new FlowFrame();
	}

}
