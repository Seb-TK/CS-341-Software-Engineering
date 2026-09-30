package sebastian;

public class Node {
	
	String word;
	Node leftChild;
	Node rightChild;
	
	public Node(String word) {
		this.word = word;
	}
	
	public void setLeft(Node child) {
		leftChild = child;
	}
	
	public void setRight(Node child) {
		rightChild = child;
	}
	
	public Node getLeft() {
		return leftChild;
	}
	public Node getRight() {
		return leftChild;
	}
	
	
}
