package sebastian;

public class Node {
	
	private String word;
	private Node leftChild;
	private Node rightChild;
	private Node parent;
	
	public Node(String word) {
		this.word = word;
	}
	
	public int isEqualTo(Node node) {
		return word.compareTo(node.getWord());
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public String getWord() {
		return word;
	}
	
	public void setLeft(Node child) {
		leftChild = child;
	}
	
	public void setRight(Node child) {
		rightChild = child;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public Node left() {
		return leftChild;
	}
	public Node right() {
		return rightChild;
	}
	public Node parent() {
		return parent;
	}
	
	
}
