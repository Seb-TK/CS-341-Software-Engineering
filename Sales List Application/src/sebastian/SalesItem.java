package sebastian;

/**
 * Class used for sales item objects that store information about an item
 * Used in the sales list application
 * 
 * @author Sebastian Tucker-Kyriakos
 */
public class SalesItem {
	
	private String name;
	private double price;
	private int quantity;
	
	/**
	 * Constructor for the sales item object.
	 * The object is used as a data structure for sales item for the sales list class
	 * 
	 * @param name Name of the item as a string
	 * @param price Price of the item as a double
	 * @param quantity Quantity of the item as an int
	 */
	public SalesItem(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		formatPrice();
		this.quantity = quantity;
	}
	
	/**
	 * Sets the name of the item
	 * 
	 * @param name Name of item
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the name of the item
	 * 
	 * @return Returns the name of the item
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Sets the price of the item
	 * 
	 * @param price Price of item
	 */
	public void setPrice(double price) {
		this.price = price;
		formatPrice();
	}
	
	/**
	 * Gets the price of the item
	 * 
	 * @return Returns the price of the item
	 */
	public double getPrice() {
		return this.price;
	}
	/**
	 * Formats the price variable
	 */
	private void formatPrice() {
		price = Math.round(price * 100.0) / 100.0;
	}
	
	/**
	 * Sets the quantity of the item
	 * 
	 * @param quantity Quantity of item
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Gets the quantity of the item
	 * 
	 * @return Returns the quantity of the item
	 */
	public int getQuantity() {
		return this.quantity;
	}
	
	/**
	 * Returns all the information of the sales item as a string formatted
	 */
	public String toString() {
		String output = String.format("%-20s $%7.2f %5d", name, price, quantity);
		
		return output;
	}
	
	
}
