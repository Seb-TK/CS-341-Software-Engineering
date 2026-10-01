package testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import sebastian.Dictionary;
import sebastian.Node;

class DictionaryTest {
	
	Dictionary dict;

    @BeforeEach
    void setup() {
        dict = new Dictionary();
    }

    @Test
    void emptyDictionaryTest() {
        assertFalse(dict.spellCheck("hello"));
        assertNull(dict.toString());
    }

    @Test
    void oneItemTest() {
        dict.insertWordNode("hello");

        assertTrue(dict.spellCheck("hello"));
        assertFalse(dict.spellCheck("hi"));
        assertEquals("hello", dict.toString());
    }

    @Test
    void multipleItemsTest() {
        dict.insertWordNode("zebra");
        dict.insertWordNode("hello");
        dict.insertWordNode("hi");
        dict.insertWordNode("apple");
        dict.insertWordNode("banana");
        dict.insertWordNode("computer");
        dict.insertWordNode("dog");
        dict.insertWordNode("elephant");
        dict.insertWordNode("grape");
        dict.insertWordNode("orange");
        dict.insertWordNode("pizza");
        dict.insertWordNode("school");

        assertEquals(
            "apple, banana, computer, dog, elephant, grape, hello, hi, orange, pizza, school, zebra",
            dict.toString()
        );
    }

    @Test
    void spellCheckTest() {
        dict.insertWordNode("hello");
        dict.insertWordNode("world");
        dict.insertWordNode("apple");

        assertTrue(dict.spellCheck("hello"));
        assertTrue(dict.spellCheck("world"));
        assertTrue(dict.spellCheck("apple"));

        assertFalse(dict.spellCheck("hi"));
        assertFalse(dict.spellCheck("banana"));
        assertFalse(dict.spellCheck("zebra"));
    }

    @Test
    void duplicateTest() {
        dict.insertWordNode("hello");
        dict.insertWordNode("hello");
        dict.insertWordNode("hello");

        assertEquals("hello", dict.toString());
    }    

    @Test
    void nodeComparisonTest() {
        Node apple = new Node("apple");
        Node banana = new Node("banana");

        assertTrue(apple.compareTo(banana) < 0);
        assertTrue(banana.compareTo(apple) > 0);
        assertEquals(0, apple.compareTo(new Node("apple")));
    }

    @Test
    void nodeChildTest() {
        Node parent = new Node("hello");
        Node left = new Node("apple");
        Node right = new Node("zebra");

        parent.setLeft(left);
        parent.setRight(right);

        assertEquals(left, parent.left());
        assertEquals(right, parent.right());
    }

    @Test
    void nodeParentTest() {
        Node parent = new Node("hello");
        Node child = new Node("apple");

        child.setParent(parent);

        assertEquals(parent, child.parent());
    }

    @Test
    void largeTreeSpellCheckTest() {
        dict.insertWordNode("m");
        dict.insertWordNode("c");
        dict.insertWordNode("t");
        dict.insertWordNode("a");
        dict.insertWordNode("h");
        dict.insertWordNode("r");
        dict.insertWordNode("z");
        dict.insertWordNode("b");
        dict.insertWordNode("f");
        dict.insertWordNode("j");

        assertTrue(dict.spellCheck("m"));
        assertTrue(dict.spellCheck("c"));
        assertTrue(dict.spellCheck("t"));
        assertTrue(dict.spellCheck("a"));
        assertTrue(dict.spellCheck("h"));
        assertTrue(dict.spellCheck("r"));
        assertTrue(dict.spellCheck("z"));
        assertTrue(dict.spellCheck("b"));
        assertTrue(dict.spellCheck("f"));
        assertTrue(dict.spellCheck("j"));

        assertFalse(dict.spellCheck("d"));
        assertFalse(dict.spellCheck("x"));
        assertFalse(dict.spellCheck("q"));
    }

    @Test
    void largeTreeOrderTest() {
        dict.insertWordNode("m");
        dict.insertWordNode("c");
        dict.insertWordNode("t");
        dict.insertWordNode("a");
        dict.insertWordNode("h");
        dict.insertWordNode("r");
        dict.insertWordNode("z");
        dict.insertWordNode("b");
        dict.insertWordNode("f");
        dict.insertWordNode("j");

        assertEquals(
            "a, b, c, f, h, j, m, r, t, z",
            dict.toString()
        );
    }

    @Test
    void multipleWordsTest() {
        dict.insertWordNodeLong(
            "zebra hello apple banana computer dog elephant grape orange pizza school hi"
        );

        assertEquals(
            "apple, banana, computer, dog, elephant, grape, hello, hi, orange, pizza, school, zebra",
            dict.toString()
        );
    }

    @Test
    void duplicateWordsTest() {
        dict.insertWordNodeLong("apple banana apple banana");

        assertEquals(
            "apple, banana",
            dict.toString()
        );
    }

    @Test
    void spellCheckExistingWordTest() {
        dict.insertWordNodeLong("apple banana computer dog");

        assertTrue(dict.spellCheck("apple"));
        assertTrue(dict.spellCheck("computer"));
        assertTrue(dict.spellCheck("dog"));
    }

    @Test
    void spellCheckMissingWordTest() {
        dict.insertWordNodeLong("apple banana computer dog");

        assertFalse(dict.spellCheck("elephant"));
    }

    @Test
    void spellCheckLongTextAllWordsExistTest() {
        dict.insertWordNodeLong("apple banana computer dog");

        assertTrue(
            dict.spellCheck("apple banana computer")
        );
    }

    @Test
    void spellCheckLongTextMissingWordTest() {
        dict.insertWordNodeLong("apple banana computer dog");

        assertFalse(
            dict.spellCheck("apple banana elephant")
        );
    }

    @Test
    void spellCheckLongTextFirstWordMissingTest() {
        dict.insertWordNodeLong("apple banana computer dog");

        assertFalse(
            dict.spellCheck("elephant apple banana")
        );
    }

    @Test
    void insertWordNodeLongTest() {
        dict.insertWordNodeLong("zebra apple hello banana");

        assertEquals(
            "apple, banana, hello, zebra",
            dict.toString()
        );
    }

    @Test
    void checkWordLongTest() {
        dict.insertWordNodeLong("apple banana computer dog");

        dict.checkWordLong("banana computer");

        assertTrue(dict.spellCheck("apple"));
        assertTrue(dict.spellCheck("dog"));
    }
    
    @Test
    void punctuationSplitTest() {
        dict.insertWordNodeLong("hello, world! apple.");
        
        assertEquals(
            "apple, hello, world",
            dict.toString()
        );
    }

    @Test
    void multiplePunctuationSplitTest() {
        dict.insertWordNodeLong("hello!!!world???apple...banana");
        
        assertEquals(
            "apple, banana, hello, world",
            dict.toString()
        );
    }

    @Test
    void numbersSplitTest() {
        dict.insertWordNodeLong("hello123world456apple");
        
        assertEquals(
            "apple, hello, world",
            dict.toString()
        );
    }

    @Test
    void mixedSeparatorsTest() {
        dict.insertWordNodeLong("hello,world!apple-banana;computer");
        
        assertEquals(
            "apple, banana, computer, hello, world",
            dict.toString()
        );
    }

    @Test
    void spacesAndPunctuationTest() {
        dict.insertWordNodeLong("hello   world,   apple!!! banana");
        
        assertEquals(
            "apple, banana, hello, world",
            dict.toString()
        );
    }

    @Test
    void punctuationSpellCheckTest() {
        dict.insertWordNodeLong("hello world apple");
        
        assertTrue(dict.spellCheck("hello, world!"));
        assertTrue(dict.spellCheck("apple."));
    }

    @Test
    void punctuationMissingWordTest() {
        dict.insertWordNodeLong("hello world apple");
        
        assertFalse(dict.spellCheck("hello, elephant!"));
    }

}
