
public class SalesItem {
	
	private String name;
	private double price;
	private int quantity;
	
	public SalesItem(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		formatPrice();
		this.quantity = quantity;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setPrice(double price) {
		this.price = price;
		formatPrice();
	}
	
	public double getPrice() {
		return this.price;
	}
	
	private void formatPrice() {
		price = Math.round(price * 100.0) / 100.0;
		//price = Double.valueOf(String.format("$%.2f", price));
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public String toString() {
		String output = String.format("%-20s $%7.2f %5d", name, price, quantity);
		System.out.println("erfw");
		//String output = name + " " + price + " " + quantity;
		
		return output;
	}
	
	
}
