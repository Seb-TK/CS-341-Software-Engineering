package sebastian;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * A simple application that tests the strength of a password
 * 
 * @author Sebastian Tucker-Kyriakos
 * @version 1.0
 */
public class PasswordStrengthApp {

	private JFrame frame;
	private JTextArea InputField;
	private JTextArea OutputText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordStrengthApp window = new PasswordStrengthApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PasswordStrengthApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel AppLabel = new JLabel("Password Strength App");
		AppLabel.setBounds(150, 46, 151, 16);
		frame.getContentPane().add(AppLabel);
		
		JLabel PasswordLabel = new JLabel("Password:");
		PasswordLabel.setBounds(85, 106, 79, 16);
		frame.getContentPane().add(PasswordLabel);
		
		JLabel OutputLabel = new JLabel("Output:");
		OutputLabel.setBounds(103, 185, 72, 16);
		frame.getContentPane().add(OutputLabel);
		
		InputField = new JTextArea();
		InputField.setBounds(166, 106, 188, 16);
		frame.getContentPane().add(InputField);
		
		JButton RunButton = new JButton("Calculate Strength");
		RunButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPressed();
			}
		});
		RunButton.setBounds(150, 139, 151, 29);
		frame.getContentPane().add(RunButton);
		
		OutputText = new JTextArea();
		OutputText.setWrapStyleWord(true);
		OutputText.setLineWrap(true);
		OutputText.setEditable(false);
		OutputText.setBounds(163, 185, 191, 73);
		frame.getContentPane().add(OutputText);

	}
	/**
	 * Button pressed event
	 */
	private void buttonPressed() {
		PasswordStrengthCalculator calc = new PasswordStrengthCalculator();
		String input = InputField.getText();
		System.out.println("input");
		String output = calc.calculateStrength(input);
		OutputText.setText(output);
	}
}