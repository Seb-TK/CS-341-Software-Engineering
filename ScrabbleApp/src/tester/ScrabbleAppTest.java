package tester;

import sebastian.ScrabbleApp;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.EventQueue;

import org.junit.jupiter.api.Test;

/**
 * test script for the scrabble application
 */
class ScrabbleAppTest {
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

}
