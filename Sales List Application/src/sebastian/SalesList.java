package sebastian;
import java.util.LinkedList;

/**
 * Represets a list of sales containing sale item objects.
 * Items are stored as a linked list, and each item contains 
 * an item object. This object has the name, price and quantity 
 * of the item as well as some of it's own functions.
 * 
 * @author Sebastian Tucker-Kyriakos
 * @version 1.0
 */
public class SalesList {
	
	LinkedList<SalesItem> salesListList;
	float total;
	
	/**
	 * Constructor for sales list, creates a new sales list linked list
	 */
	public SalesList() {
		salesListList = new LinkedList<SalesItem>();
	}
	
	/**
	 * Adds an item to the sales list and increases total price appropriately
	 * @param item SalesItem object that will be added
	 */
	public void addItem(SalesItem item) {
		salesListList.add(item);
		total += item.getPrice() * item.getQuantity();
	}
	
	/**
	 * Returns the entire sales list as a string formatted
	 */
	public String toString() {
		String output = "";
		for(SalesItem item : salesListList) {
			output += item.toString() + "\n";
		}
		
		return output;
	}
	
	/**
	 * Returns the total sales amount as a string
	 * @return Formatted total sales value
	 */
	public String getTotalSales() {
		String output = String.format("$%.2f", total);
		return output;
	}
	
}
