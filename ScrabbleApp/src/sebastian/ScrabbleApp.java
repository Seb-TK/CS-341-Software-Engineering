package sebastian;
import java.util.List;
import java.util.ArrayList;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Scrabble Application: Takes a 7 letter word and generates
 * all of the combinations that the letters in that word creates.
 * Displays these combinations in a scrollable text area below
 */
public class ScrabbleApp {

	public JFrame frame;
	public JTextField InputArea;
	public JTextArea OutputTextArea;
	public List<String> combinations;
	private int wordLength;

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
		
		JScrollPane OutputScrollPane = new JScrollPane();
		OutputScrollPane.setBounds(121, 188, 228, 64);
		frame.getContentPane().add(OutputScrollPane);

		OutputTextArea = new JTextArea();
		OutputTextArea.setEditable(false);
		OutputScrollPane.setViewportView(OutputTextArea);
		
		JButton OutputButton = new JButton("Generate Combinations");
		OutputButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				combinations = new ArrayList<String>();
				ScrabbleFunctionality scrabble = new ScrabbleFunctionality();
				wordLength = 7;
				scrabble.runScript(InputArea, OutputTextArea, combinations, wordLength);
			}
		});
		OutputButton.setBounds(132, 135, 197, 29);
		frame.getContentPane().add(OutputButton);
	}
	
	
	
}
