package Background;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import minTest.Frame;

public class SelectCharacter extends JFrame {

	private JPanel jPanel;
	private JButton button;

	public SelectCharacter() {
		initData();
		setInitLayout();
		addEventListener();

	}

	public void initData() {

		setTitle("SelectCharacter");
		setSize(600, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jPanel = new JPanel();
		button = new JButton("Select");

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
				new Frame();

			}
		});

	}

	public static void main(String[] args) {
		// new SelectCharacter();
	}

}
