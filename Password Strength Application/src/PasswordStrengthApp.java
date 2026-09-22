import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

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
		AppLabel.setBounds(150, 25, 165, 16);
		frame.getContentPane().add(AppLabel);
	}
}
