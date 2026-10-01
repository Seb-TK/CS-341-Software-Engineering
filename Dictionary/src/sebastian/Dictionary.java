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
			return;
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
		ArrayList<String> outputList = new ArrayList<String>();
		
		if(root == null) {
			return "Empty";
		}
		
		Node pointer = root;
		outputList.add(root.getWord());
		
		for(int i = 0; i < 10; i ++) {
			
			System.out.println("The current pointer is: " + pointer.getWord());
			System.out.println("The current output is: " + outputList.toString());
			
			try {
				System.out.println("The current pointer left is: " + pointer.left().getWord());
			} catch(Exception e) {
				System.out.println("Pointer left null is: " + (pointer.left() == null));
			}
			
			try {
				System.out.println("The current pointer right is: " + pointer.right().getWord());
			} catch(Exception e) {
				System.out.println("Pointer right null is: " + (pointer.right() == null));
			}
			
			try {
				System.out.println("The current pointer parent is: " + pointer.parent().getWord());
			} catch(Exception e) {
				System.out.println("Pointer parent " + (pointer.parent() == null));
			}
			System.out.println();
			
			
			if(pointer.left() != null & !outputList.contains(pointer.left().getWord())) {
				System.out.println("I am now going left to pointer: " + pointer.left().getWord());
				pointer = pointer.left();
				outputList.add(pointer.getWord());
			} else if(pointer.right() != null & !outputList.contains(pointer.right().getWord())) {
				System.out.println("I am now going right to pointer: " + pointer.right().getWord());
				pointer = pointer.right();
				outputList.add(pointer.getWord());
			} else if(pointer.parent() != null){
				System.out.println("I am now going up to parent: " + pointer.parent().getWord());
				pointer = pointer.parent();
			} else {
				break;
			}
			
		}
		
		//formats it
		String output = "";
		for(int i = 0; i < outputList.size(); i ++) {
			if(i > 0) {
				output += ", ";
			}
			output += outputList.get(i);
		}
		return String.valueOf(output);
	}
	
	
	
	
}