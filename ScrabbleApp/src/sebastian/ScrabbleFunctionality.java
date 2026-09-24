package sebastian;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.JTextArea;

/**
 * Class that holds the functions for the Scrabble combination
 * application class. Methods recursively loop through the
 * letters to find and display all combinations.
 */
public class ScrabbleFunctionality {
	
	public JTextField InputArea;
	public JTextArea OutputTextArea;
	public List<String> combinations;
	
	public ScrabbleFunctionality() {
		
	}
	
	/**
	 * Runs the scrabble combination generation script.
	 * Grabs the input and recursively generates all of the 
	 * combinations before displaying them to the output text area.
	 * 
	 * @param thisInputArea the text field with the input word
	 * @param thisOutputTextArea the text area where the output will be displayed
	 * @param thisCombinations list of combinations
	 * @param wordLength determines the length of the word you want to be put in, has to be that exact amount
	 */
	
	public void runScript(JTextField thisInputArea, JTextArea thisOutputTextArea, List<String> thisCombinations, int wordLength) {
		InputArea = thisInputArea;
		OutputTextArea = thisOutputTextArea;
		combinations = thisCombinations;
		
		String input = InputArea.getText();
		
		int inputLength = wordLength;
		if(input.length() > inputLength | input.length() < inputLength) {
			OutputTextArea.setText("Error: Only choose " + inputLength + " characters!");
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
	
	/**
	 * Recursive method for generating the Scrabble combinations.
	 * 
	 * @param currentString the current string being iterated on
	 * @param charList a list of all of the characters in the input that have been used in the form of their char indexs
	 */
	
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
	
	/**
	 * Displays the combinations on the text area
	 */
	private void displayCombinations() {
		String output = "";
		for(int i = 0; i < combinations.size(); i++) {
			output += combinations.get(i) + "\n";
		}
		OutputTextArea.setText(output);
	}
}
