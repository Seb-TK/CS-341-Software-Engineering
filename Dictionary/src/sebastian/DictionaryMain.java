package sebastian;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DictionaryMain {
	
	public static void main (String[]args) {
		Dictionary dict = new Dictionary();
		dict = new Dictionary();
		dict.insertWordNode("hi");
		dict.insertWordNode("hello");
	    
		assertEquals("apple, hello, hi, zebra", dict.toString());
	
	}
}
