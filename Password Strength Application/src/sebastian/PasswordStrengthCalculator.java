package sebastian;

public class PasswordStrengthCalculator {
	
	private int minLength = 8;
	private int maxLength = 12;
	private int minBlockLength = 2;
	
	public PasswordStrengthCalculator() {}
	
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
