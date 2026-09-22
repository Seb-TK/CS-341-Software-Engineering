import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class ScrabbleApp {

	private JFrame frame;
	private JTextField InputArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScrabbleApp window = new ScrabbleApp();
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
	public ScrabbleApp() {
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
		
		JLabel Title = new JLabel("Scrabble Combination Application");
		Title.setBounds(121, 19, 228, 16);
		frame.getContentPane().add(Title);
		
		InputArea = new JTextField();
		InputArea.setBounds(177, 84, 138, 26);
		frame.getContentPane().add(InputArea);
		InputArea.setColumns(10);
		
		JLabel InputLabel = new JLabel("7 Letter Word:");
		InputLabel.setBounds(77, 89, 95, 16);
		frame.getContentPane().add(InputLabel);
		
		JButton OutputButton = new JButton("Generate Combinations");
		OutputButton.setBounds(132, 135, 197, 29);
		frame.getContentPane().add(OutputButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(92, 172, 278, 81);
		frame.getContentPane().add(scrollPane);
	}
}
