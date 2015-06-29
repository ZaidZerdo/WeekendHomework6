package main;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Task4 extends JFrame {
	private static final long serialVersionUID = 9148410145901917533L;
	private JButton leftButton = new JButton("<");
	private JButton rightButton = new JButton(">");
	private JButton insertButton = new JButton("Insert");
	private JButton chooseCharacterButton = new JButton("Char: a");
	private JLabel textLabel = new JLabel("_");
	private String constructedString = "";
	private Character selectedCharacter = 'a';
	private Integer selectedIndex = 0;
	private Font font1 = new Font("Consolas", Font.PLAIN, 18);

	private Task4() {
		setLayout(new BorderLayout());
		add(leftButton, BorderLayout.WEST);
		add(rightButton, BorderLayout.EAST);
		add(chooseCharacterButton, BorderLayout.NORTH);
		add(insertButton, BorderLayout.SOUTH);
		add(textLabel);

		leftButton.setFont(font1);
		rightButton.setFont(font1);
		chooseCharacterButton.setFont(font1);
		insertButton.setFont(font1);
		textLabel.setFont(font1);
		
		textLabel.setHorizontalAlignment(JLabel.CENTER);

		leftButton.addActionListener(new Action());
		rightButton.addActionListener(new Action());
		chooseCharacterButton.addActionListener(new Action());
		insertButton.addActionListener(new Action());

		setSize(400, 200);
		setLocationRelativeTo(null);
		setTitle("Task 4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Task4();
	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == insertButton) {
				String preString = constructedString.substring(0, selectedIndex);
				String postString = selectedCharacter + "";
				if (selectedIndex != constructedString.length()) {
					postString += constructedString.substring(selectedIndex);
				}
				
				constructedString = preString + postString;
				textLabel.setText(preString + "_" + postString);
			} else if (e.getSource() == leftButton) {
				if (selectedIndex > 0) {
					selectedIndex--;
					String preString = constructedString.substring(0, selectedIndex);
					String postString = constructedString.substring(selectedIndex);
										
					textLabel.setText(preString + "_" + postString);
				}
			} else if (e.getSource() == rightButton) {
				if (selectedIndex < constructedString.length()) {
					selectedIndex++;
					String preString = constructedString.substring(0, selectedIndex);
					String postString = constructedString.substring(selectedIndex);
										
					textLabel.setText(preString + "_" + postString);
				}
			} else if (e.getSource() == chooseCharacterButton) {
				selectedCharacter = (char) ((int) (Math.random() * (123 - 97)) + 97);
			
				chooseCharacterButton.setText("Char: " + selectedCharacter);
			}
		}

	}

}
