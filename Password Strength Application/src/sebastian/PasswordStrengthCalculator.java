package sebastian;

/**
 * The functionality for the password strength application.
 * Takes an input and loops through to find "blocks" which 
 * are consecutive characters, case sensitive, then gives
 * A suggestion depending on the biggest block's length.
 * Includes error checks for length of password and doesn't allow spaces. 
 * 
 * @author Sebastian Tucker-Kyriakos
 * @version 1.0
 */
public class PasswordStrengthCalculator {
	
	private int minLength = 8;
	private int maxLength = 12;
	private int minBlockLength = 2;
	
	/**
	 * Default constructor for password strength calculator
	 */
	public PasswordStrengthCalculator() {}
	
	/**
	 * Calculates the strength of a password by finding blocks of similar characters
	 * 
	 * @param input The password input as a string
	 * @return Returns a string about the password strength
	 */
	public String calculateStrength(String input) {
		System.out.println(input);
		System.out.println(input.length());
		if (input.length() < minLength) {
			return "Invalid input, please enter a string greater than " + minLength + " characters";
		} 
		if (input.length() > maxLength) {
			return "Invalid input, please enter a string less than " + maxLength + " characters";
		} 
		if(input.contains(" ")) {
			return "Invalid input, please enter a string without any spaces";
		}
		
		int blockLength = findBlock(input);
		
		 String output = "The largest block in the password is " 
					 	+ blockLength
						+ ". ";
		
		if(blockLength <= minBlockLength) {
			output += "This is a decent password";
		} else {
			output += "This password can be made stronger by "
					+ "reducing this block by "
					+ (blockLength - minBlockLength);
		}
			
		return output;
	}
	/**
	 * Using an input string, finds the length of the longest
	 * consequtive string of characters. Case sensitive.
	 * 
	 * @param input Takes in the password as a string
	 * @return Returns the biggest block of consequtive identical characters
	 */
	private int findBlock(String input) {
		int biggestBlockLength = 0;
		int blockLength = 0;
		for (int i = 0; i < input.length(); i ++) {
			char currentChar = input.charAt(i);
			char previousChar = input.charAt(0);
			
			if(i !=0) {
				previousChar = input.charAt(i - 1);
			}
			
			if(currentChar == previousChar) {
				blockLength++;
				if(blockLength > biggestBlockLength) {
					biggestBlockLength = blockLength;
				}
			} else {
				blockLength = 1;
			}
		}
		
		return biggestBlockLength;
	}
}
