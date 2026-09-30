package sebastian;
import java.util.ArrayList;

public class BinarySearchTree {
	
	Node root;
	
	public BinarySearchTree() {}
	
	public void addNode(String word){
		Node node = new Node(word);
		
		if(root == null) {
			root = node;
			return;
		} 
		
		Node pointer = root;
		while(true) {
			Node leftChild = pointer.left();
			Node rightChild = pointer.right();
			int compare = word.compareTo(pointer.getWord());
			if(compare < 0) {
				if(leftChild == null) {
					leftChild = node;
					node.setParent(pointer);
					return;
				} else {
					pointer = leftChild;
				}
			} else if(compare > 0) {
				if(rightChild == null) {
					rightChild = node;
					node.setParent(pointer);
					return;
				} else {
					pointer = rightChild;
				}
			} else {
				return;
			}
		}
	}
	
	public String toString() {
		
		if(root == null) {
			return "Tree Empty";
		}
		String treeAsString = "";
		Node pointer = root;

		while(true) {
			//maybe do it recursively or add a stack
			//add to stack and reverse your way back up
			treeAsString += pointer.getWord();
			if(pointer.left() != null) {
				pointer = pointer.left();
			} else if (pointer.right() != null) {
				pointer = pointer.right();
			} else {
				pointer = pointer.parent();
			}
		}
		
		
		
	}
}
