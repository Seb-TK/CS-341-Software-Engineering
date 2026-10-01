package sebastian;
import java.util.ArrayList;

public class Dictionary {
	
	Node root;
	
	public Dictionary() {}
	
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
			int nodeComparason = inputNode.isEqualTo(pointer);
			
			if(nodeComparason < 0) {
				if(leftChild == null) {
					break;
				} else {
					pointer = leftChild;
				}
			} else if(nodeComparason > 0) {
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
		int nodeComparason = inputNode.isEqualTo(parentNode);
		
		if(nodeComparason < 0) {
			parentNode.setLeft(inputNode);
		} else if(nodeComparason > 0) {
			parentNode.setRight(inputNode);
		} else {
			return;
		}
		inputNode.setParent(parentNode);
	}
	
	public void checkWord(String word) {
		Node inputNode = new Node(word);
		Node removedNode = findNodeOrPotentialParent(word);
		
		int nodeComparison = removedNode.isEqualTo(inputNode);
		
		if(nodeComparison == 0) {
			//node found now remove
			//multistep
			//decide which child node should be brought up
			//left checked first if not then right
			//if there are no children then you can just leave
			Node childToMove;
			if(removedNode.left() != null) {
				childToMove = removedNode.left();
			} else if(removedNode.right() != null) {
				childToMove = removedNode.right();
			} else {
				return;
			}
			//ask which child this removed node is
			//whichever it is, take replace that child with the
			//new and improved child to move
			Node parent = removedNode.parent();
			if(parent.left().isEqualTo(removedNode) == 0) {
				parent.setLeft(childToMove);
			} else if(parent.right().isEqualTo(removedNode) == 0) {
				parent.setRight(childToMove);
			}
			childToMove.setParent(parent);
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
	
	public String toString() {
		ArrayList<String> output = new ArrayList<String>();
		
		if(root == null) {
			return "Empty";
		}
		
		Node pointer = root;
		output.add(root.getWord());
		
		while(true) {
			
			if(pointer.left() != null) {
				pointer = pointer.left();
				output.add(pointer.getWord());
			} else if(pointer.right() != null) {
				pointer = pointer.right();
				output.add(pointer.getWord());
			} else if(pointer.parent() != null){
				pointer = pointer.parent();
			} else {
				break;
			}
		}
		
		return output.toString();
	}
	
	
	
	
}