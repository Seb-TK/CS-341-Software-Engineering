package testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import sebastian.Dictionary;

class DictionaryTest {
	
	Dictionary dict = new Dictionary();
	
	@Test
	void emptyTest() {
		dict = new Dictionary();
		assertEquals("Empty", dict.toString());
	}
	
	@Test
	void oneItemTest() {
		dict = new Dictionary();
		dict.insertWordNode("hi");
		assertEquals("hi", dict.toString());
	}
	
	@Test
	void multiItemTest() {
		dict = new Dictionary();
		dict.insertWordNode("hi");
		dict.insertWordNode("hello");
	    
		assertEquals("apple, hello, hi, zebra", dict.toString());
	}
	
	
	

}
