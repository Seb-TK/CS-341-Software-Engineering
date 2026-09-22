package tester;

import sebastian.SalesListApplication;

import java.awt.EventQueue;

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
