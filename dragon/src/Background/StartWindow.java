package Background;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartWindow extends JFrame {

	private JPanel jPanel;
	private JButton button;

	public StartWindow() {
		initData();
		setInitLayout();
		addEventListener();

	}

	public void initData() {

		setTitle("GameStart");
		setSize(300, 200);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jPanel = new JPanel();
		button = new JButton("GameStart");

	}

	public void setInitLayout() {

		setVisible(true);

		add(jPanel);
		jPanel.add(button);

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

	public static void main(String[] args) {
		new StartWindow();
	}

}
