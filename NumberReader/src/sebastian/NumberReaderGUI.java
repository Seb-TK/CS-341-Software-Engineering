package sebastian;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import sebastian.NumberReader.Result;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class NumberReaderGUI {

	private JFrame frame;
	private JTextArea textArea;
	private NumberReader reader = new NumberReader();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumberReaderGUI window = new NumberReaderGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NumberReaderGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Number Reader App");
		lblNewLabel.setBounds(153, 23, 132, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Choose a file to get its mean and standard derivative");
		lblNewLabel_1.setBounds(53, 45, 339, 16);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Pick File");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NumberReader reader = new NumberReader();
				File file = reader.chooseFile();
				Result result = reader.addFileToList(file);
				if(result != Result.SUCCESS){
					textArea.setText(result.getErrorMessage());
				} else {
					NumberReaderList numberList = reader.getNumberList();
					double mean = numberList.getMean();	
					double standardDerivative = numberList.getStandardDerivative();
					String outputMessage;
					outputMessage = "The mean of your list of numbers is " + mean +
									"\nThe standard derivative of your list of numbers is "
									+ standardDerivative;
					textArea.setText(outputMessage);
				}
			}
		});
		btnNewButton.setBounds(154, 99, 117, 29);
		panel.add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(53, 141, 339, 89);
		panel.add(textArea);
		
		
	}
}
