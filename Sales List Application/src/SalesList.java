import java.util.LinkedList;

public class SalesList {
	
	LinkedList<SalesItem> salesListList;
	float total;
	
	public SalesList() {
		salesListList = new LinkedList<SalesItem>();
	}
	
	public void addItem(SalesItem item) {
		salesListList.add(item);
		total += item.getPrice() * item.getQuantity();
	}
	
	public String toString() {
		String output = "";
		for(SalesItem item : salesListList) {
			output += item.toString() + "\n";
		}
		
		return output;
	}
	
	public String getTotalSales() {
		String output = String.format("$%.2f", total);
		return output;
	}
	
}
