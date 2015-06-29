package main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Task3 extends JFrame {
	private static final long serialVersionUID = -6990324055740303158L;

	private JButton[] buttons = new JButton[10];
	private Integer[] array = new Integer[buttons.length / 2];
	private Integer counter = 0;

	private Task3() {
		setLayout(new GridLayout(2, 5, 5, 5));
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton("" + i);
			buttons[i].addActionListener(new Action());
			add(buttons[i]);
		}

		setSize(400, 100);
		setLocationRelativeTo(null);
		setTitle("Task 3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Task3();
	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < buttons.length; i++) {
				if (buttons[i] == e.getSource() && array[i % 5] == null) {
					buttons[i].setEnabled(false);
					array[i % 5] = i;
					counter++;

					if (counter == array.length) {
						JOptionPane.showMessageDialog(null,
								Arrays.toString(array));
						System.exit(0);
					}

				}
			}
		}

	}
}
