package main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Task1 extends JFrame {
	private static final long serialVersionUID = -995199956205934258L;
	
	private JButton[] buttons = new JButton[10];
	private Integer constructedNumber = 0;
	
	public Task1() {
		setLayout(new GridLayout(10, 1, 5, 5));
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton("" + i);
			buttons[i].addActionListener(new Action());
			add(buttons[i]);
		}
		
		pack();
		setLocationRelativeTo(null);
		setTitle("Task 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Task1();
	}
	
	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < buttons.length; i++) {
				if (buttons[i] == e.getSource()) {
					buttons[i].setEnabled(false);
					
					constructedNumber = constructedNumber * 10 + i;
					if (constructedNumber > 100) {
						JOptionPane.showMessageDialog(null, "Number: " + constructedNumber);
						System.exit(0);
					}
				}
			}
		}
		
	}
}
