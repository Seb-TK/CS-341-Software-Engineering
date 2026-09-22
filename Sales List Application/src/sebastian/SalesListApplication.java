package sebastian;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class SalesListApplication {

	public JFrame frame;
	private JTextField NameTextField;
	private JTextField PriceTextField;
	private JTextField QuantityTextField;
	private JTextArea TotalSalesOutput;
	private JTextPane SalesListOutput; 
	private SalesList SalesListObject = new SalesList();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the application.
	 */
	public SalesListApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel SalesListLabel = new JLabel("Sales List");
		SalesListLabel.setBounds(196, 14, 61, 16);
		frame.getContentPane().add(SalesListLabel);
		
		JLabel ItemLabel = new JLabel("Item:");
		ItemLabel.setBounds(103, 49, 43, 16);
		frame.getContentPane().add(ItemLabel);
		
		NameTextField = new JTextField();
		NameTextField.setBounds(168, 42, 222, 26);
		frame.getContentPane().add(NameTextField);
		NameTextField.setColumns(10);
		
		JLabel CostLabel = new JLabel("Cost: $");
		CostLabel.setBounds(103, 82, 53, 16);
		frame.getContentPane().add(CostLabel);
		
		PriceTextField = new JTextField();
		PriceTextField.setColumns(10);
		PriceTextField.setBounds(168, 75, 222, 26);
		frame.getContentPane().add(PriceTextField);
		
		JLabel QuantityLabel = new JLabel("Quantity:");
		QuantityLabel.setBounds(103, 115, 68, 16);
		frame.getContentPane().add(QuantityLabel);
		
		QuantityTextField = new JTextField();
		QuantityTextField.setColumns(10);
		QuantityTextField.setBounds(168, 108, 222, 26);
		frame.getContentPane().add(QuantityTextField);
		
		
		JButton AddItem = new JButton("Add Item To Sales List");
		AddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addItem();
			}
		});
		
		AddItem.setBounds(103, 137, 247, 29);
		frame.getContentPane().add(AddItem);
		
		TotalSalesOutput = new JTextArea();
		TotalSalesOutput.setBounds(206, 238, 105, 16);
		frame.getContentPane().add(TotalSalesOutput);
		
		JLabel TotalSalesLabel = new JLabel("Total Sales:");
		TotalSalesLabel.setBounds(114, 238, 80, 16);
		frame.getContentPane().add(TotalSalesLabel);
		
		JScrollPane SalesListOutputScrollPane = new JScrollPane();
		SalesListOutputScrollPane.setBounds(102, 167, 288, 66);
		frame.getContentPane().add(SalesListOutputScrollPane);
		
		SalesListOutput = new JTextPane();
		SalesListOutput.setEditable(false);
		SalesListOutputScrollPane.setViewportView(SalesListOutput);
	}
	
	private void addItem() {
		try {
			String name = NameTextField.getText();
			double price = 0.00;
			price = Double.valueOf(PriceTextField.getText());
			int quantity = Integer.valueOf(QuantityTextField.getText());
			SalesItem NewSalesItem = new SalesItem(name, price, quantity);
			SalesListObject.addItem(NewSalesItem);
			
			SalesListOutput.setText(SalesListObject.toString());
			TotalSalesOutput.setText(SalesListObject.getTotalSales());
			
		} catch (Exception e) {}
		
		
	}
}
