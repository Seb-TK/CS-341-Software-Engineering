package sebastian;

public class Node {

	private int value;
	private Node child;
	
	public Node(int value) {
		this.value = value;
	}
	
	public void setChild(Node child) {
		this.child = child;
	}
	
	public int getValue() {
		return value;
	}
	
	public Node getChild() {
		return child;
	}
}
