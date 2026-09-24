package tester;

import sebastian.SalesListApplication;

import java.awt.EventQueue;
/**
 * Test file for the sales application
 * 
 * @author Sebastian Tucker-Kyriakos
 * @version 1.0
 */
public class SalesAppTester {
	public static void main (String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesListApplication window = new SalesListApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
