package sebastian;
import java.util.ArrayList;

public class BinarySearchTree {
	
	Node root;
	
	public BinarySearchTree() {}
	
	//returns the node with the same word as the input
	//if it doesnt exist, returns the parent that node 
	//would have if it were in the tree
	//return null if tree is empty;
	public Node findNodeOrPotentialParent(String word) {
		Node inputNode = new Node(word);
		
		if(root == null) {
			//tree empty
			return null;
		}
		
		Node pointer = root;
		while(true) {
			Node leftChild = pointer.left();
			Node rightChild = pointer.right();
			int compareNodes = inputNode.isEqualTo(pointer);
			
			if(compareNodes < 0) {
				if(leftChild == null) {
					break;
				} else {
					pointer = leftChild;
				}
			} else if(compareNodes > 0) {
				if(rightChild == null) {
					break;
				} else {
					pointer = rightChild;
				}
			} else {
				break;
			}
		}
		
		return pointer;
	}
	
	public void insertWordNode(String word){
		
		Node inputNode = new Node(word);
		
		if(root == null) {
			root = inputNode;
		}
		
		Node parentNode = findNodeOrPotentialParent(word);
		int compareNodes = inputNode.isEqualTo(parentNode);
		
		if(compareNodes < 0) {
			parentNode.setLeft(inputNode);
		} else if(compareNodes > 0) {
			parentNode.setRight(inputNode);
		} else {
			return;
		}
	}
	
	public void checkWord(String word) {
		Node inputNode = new Node(word);
		Node nodeFound = findNodeOrPotentialParent(word);
		
		if(nodeFound.isEqualTo(inputNode) == 0) {
			
		}
		
	}
	
	
	public boolean spellCheck(String word){
		
		Node potentialNode = findNodeOrPotentialParent(word);
		Node inputNode = new Node(word);
		
		int compareNodes = inputNode.isEqualTo(potentialNode);
		
		if(compareNodes == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
}
