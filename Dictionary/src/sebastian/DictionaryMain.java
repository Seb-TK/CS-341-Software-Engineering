package sebastian;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DictionaryMain {
	
	public static void main (String[]args) {
		Dictionary dict = new Dictionary();
		
		String inputText = "Build the dictionary of words during a runtime configuration using a sample paragraph of words.\n"
				+ "Assume all of the sample words are spelled correctly and will constitute the entire dictionary of\n"
				+ "words. Note that words in the dictionary are used exclusively for the spellchecker. As part of\n"
				+ "preliminary testing, it is important that you verify the dictionary by displaying all the words in\n"
				+ "sorted order.";
		
		dict.insertWordNodeLong(inputText);
		
		System.out.println("The following text has been fed into the dictionary: " + inputText);
		System.out.println("Here is the dictionary printed out: ");
		System.out.println(dict.toString());
		}
}
