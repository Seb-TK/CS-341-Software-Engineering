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

public class ScrabbleApp {

	private JFrame frame;
	private JTextField InputArea;
	private JTextArea OutputTextArea;
	private List<String> combinations;

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
		OutputButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				combinations = new ArrayList<String>();
				runScript();
			}
		});
		OutputButton.setBounds(132, 135, 197, 29);
		frame.getContentPane().add(OutputButton);
		
		JScrollPane OutputScrollPane = new JScrollPane();
		OutputScrollPane.setBounds(121, 188, 228, 64);
		frame.getContentPane().add(OutputScrollPane);
		
		OutputTextArea = new JTextArea();
		OutputTextArea.setEditable(false);
		OutputScrollPane.setViewportView(OutputTextArea);
	}
	
	private void runScript() {
		String input = InputArea.getText();
		
		int inputLength = 7;
		if(input.length() > inputLength | input.length() < inputLength) {
			OutputTextArea.setText("Error: Only choose 7 characters!");
			return;
		} else {
			for(int i = 0; i < inputLength; i ++) {
				if(!Character.isLetter(input.charAt(i))){
					OutputTextArea.setText("Error: Only choose letters!");
					return;
				}
			}
		}
		List<Integer> charList = new ArrayList<Integer>();
		charList.add(-1);
		generateCombinations("", charList);
		displayCombinations();
	}
	
	private void generateCombinations(String currentString, List<Integer> charList){
		String inputString = InputArea.getText();
		int currentDigit = currentString.length();
		List<Integer> newCharList = new ArrayList<>(charList);
		
		if(currentDigit == inputString.length()) {
			if(!combinations.contains(currentString)) {
				combinations.add(currentString);
				System.out.println(currentString + newCharList.toString());
			}
			return;
		}
		
		for(int i = 0; i < inputString.length(); i++) {
			String targetDigit = String.valueOf(inputString.charAt(i));
			
			if(!newCharList.contains(i)) {
				List<Integer> myCharList = new ArrayList<>(newCharList);
				myCharList.add(i);
				generateCombinations(currentString + targetDigit, myCharList);
			}
		}
	}
	
	private void displayCombinations() {
		String output = "";
		for(int i = 0; i < combinations.size(); i++) {
			output += combinations.get(i) + "\n";
		}
		OutputTextArea.setText(output);
	}
	
}
