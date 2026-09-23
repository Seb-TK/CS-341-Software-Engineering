package sebastian;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PasswordStrengthApp {

	private JFrame frame;

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
		AppLabel.setBounds(150, 46, 165, 16);
		frame.getContentPane().add(AppLabel);
		
		JLabel PasswordLabel = new JLabel("Password:");
		PasswordLabel.setBounds(97, 115, 79, 16);
		frame.getContentPane().add(PasswordLabel);
		
		JLabel OutputLabel = new JLabel("Output:");
		OutputLabel.setBounds(97, 142, 72, 16);
		frame.getContentPane().add(OutputLabel);
		
		JTextArea InputField = new JTextArea();
		InputField.setBounds(178, 115, 188, 16);
		frame.getContentPane().add(InputField);
		
		JTextArea OutputField = new JTextArea();
		OutputField.setBounds(178, 143, 188, 16);
		frame.getContentPane().add(OutputField);
	}
}
