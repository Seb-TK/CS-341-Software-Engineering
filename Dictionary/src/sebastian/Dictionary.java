package sebastian;
import java.util.ArrayList;

public class Dictionary {
	
	Node root;
	
	/**
	 * Creates a dictionary
	 */
	public Dictionary() {}
	
	/**
	 * Finds the node containing the specified word.
	 * If the word does not exist, returns the node that would
	 * become its parent if the word were inserted.
	 *
	 * @param word the word to search for
	 * @return the matching node, the potential parent node,
	 *         or null if the dictionary is empty
	 */
	private Node findNodeOrPotentialParent(String word) {
		Node inputNode = new Node(word);
		
		if(root == null) {
			//tree empty
			return null;
		}
		
		Node pointer = root;
		while(true) {
			Node leftChild = pointer.left();
			Node rightChild = pointer.right();
			int nodeComparason = inputNode.compareTo(pointer);
			
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
		int nodeComparason = inputNode.compareTo(parentNode);
		
		if(nodeComparason < 0) {
			parentNode.setLeft(inputNode);
		} else if(nodeComparason > 0) {
			parentNode.setRight(inputNode);
		} else {
			return;
		}
		inputNode.setParent(parentNode);
	}
	
	
	public void insertWordNodeLong(String text){
		String[] textAsList = text.split("[^a-zA-Z]+");
		for(int i = 0; i < textAsList.length; i++) {
			insertWordNode(textAsList[i]);
		}
	}
	
	
	public void checkWord(String word) {
		Node inputNode = new Node(word);
		Node nodeToRemove = findNodeOrPotentialParent(word);
		
		int nodeComparison = nodeToRemove.compareTo(inputNode);
		
		if(nodeComparison == 0) {
			//node found now remove
			//multistep
			//decide which child node should be brought up
			//left checked first if not then right
			//if there are no children then you can just leave
			Node childToMove;
			if(nodeToRemove.left() != null) {
				childToMove = nodeToRemove.left();
			} else if(nodeToRemove.right() != null) {
				childToMove = nodeToRemove.right();
			} else {
				return;
			}
			//ask which child this removed node is
			//whichever it is, take replace that child with the
			//new and improved child to move
			Node parent = nodeToRemove.parent();
			if(parent.left() != null) {
				if(parent.left().compareTo(nodeToRemove) == 0) {
					parent.setLeft(childToMove);
				}
			} else if(parent.right().compareTo(nodeToRemove) == 0) {
				parent.setRight(childToMove);
			}
			childToMove.setParent(parent);
		}
	}
	
	public void checkWordLong(String text){
		String[] textAsList = text.split(" ");
		for(int i = 0; i < textAsList.length; i++) {
			checkWord(textAsList[i]);
		}
	}
	
	private boolean spellCheckWord(String word){
		
		Node potentialNode = findNodeOrPotentialParent(word);
		Node inputNode = new Node(word);
		
		if(potentialNode == null) {
			return false;
		}
		
		int compareNodes = inputNode.compareTo(potentialNode);
		
		if(compareNodes == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	//decided to make it work for text in general
	public boolean spellCheck(String text) {
		boolean output = true;
		String[] textAsList = text.split(" ");
		for(int i = 0; i < textAsList.length; i++) {
			output = spellCheckWord(textAsList[i]);
			if(output == false) {
				break;
			}
		}
		return output;
	}
	
	
	
	
	public String toString() {
		ArrayList<String> outputList = new ArrayList<String>();
		
		if(root == null) {
			return null;
		}
		
		Node pointer = root;
		
		while(true) {
			
			
			if(pointer.left() != null) {
				
				if(!outputList.contains(pointer.left().getWord())) {
					
					pointer = pointer.left();
					continue;
				}
			} 
			
			if(!outputList.contains(pointer.getWord())) {
				outputList.add(pointer.getWord());
			}
			
			if(pointer.right() != null) {
				
				if(!outputList.contains(pointer.right().getWord())){
					
					pointer = pointer.right();
					continue;
				}
			}
			if(pointer.parent() != null) {
				pointer = pointer.parent();
				continue;
			}
			break;
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