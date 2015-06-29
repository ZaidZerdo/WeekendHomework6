package main;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Task2 extends JFrame {
	private static final long serialVersionUID = 5774196681915979382L;
	
	private JButton firstNameButton = new JButton("First Name");
	private JButton lastNameButton = new JButton("Last Name");
	private JLabel textLabel = new JLabel("");
	private FirstName firstName = new FirstName();
	private LastName lastName = new LastName();
	private Font font1 = new Font("Cambria", Font.PLAIN, 20);
	private Font font2 = new Font("Cambria", Font.BOLD, 20);
	
	public Task2() {
		firstNameButton.addActionListener(new Action());
		lastNameButton.addActionListener(new Action());
		
		firstNameButton.setFont(font1);
		lastNameButton.setFont(font1);
		textLabel.setFont(font2);
		
		textLabel.setHorizontalAlignment(JLabel.CENTER);
		
		setLayout(new BorderLayout());
		add(firstNameButton, BorderLayout.WEST);
		add(lastNameButton, BorderLayout.EAST);
		add(textLabel);
		
		setSize(600, 200);
		setLocationRelativeTo(null);
		setTitle("Task 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private static class FirstName {
		private final static String[] names = {"NameA", "NameB", "NameC"};
		private String name;
		
		public FirstName() {
			name = null;
		}
		
		public void generateName() {
			name = names[(int) (Math.random() * names.length)];
		}
		
		public String toString() {
			return name;
		}
	}
	
	private static class LastName {
		private final static String[] names = {"LNameA", "LNameB", "LNameC"};
		private String name;
		
		public LastName() {
			name = null;
		}
		
		public void generateName() {
			name = names[(int) (Math.random() * names.length)];
		}
		
		public String toString() {
			return name;
		}
	}
	
	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == firstNameButton) {
				firstName.generateName(); 
			} else if (e.getSource() == lastNameButton) {
				lastName.generateName();
			}
			
			textLabel.setText(firstName + " " + lastName);
		}		
	}
	
	public static void main(String[] args) {
		new Task2();
	}

}
