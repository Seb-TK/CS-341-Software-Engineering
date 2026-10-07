package sebastian;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a linked list of integer values and provides methods for
 * calculating statistics about the values in the list.
 */
public class NumberReaderList {

	Node head;
	double totalValue;
	int listLength;
	
	/**
	 * Constructs an empty NumberReaderList.
	 */
	public NumberReaderList() {
		totalValue = 0;
		listLength = 0;
	}
	
	/**
	 * Adds a new node containing the specified value to the end of the list.
	 *
	 * @param value the integer value to add to the list
	 */
	public void addNode(double value) {
		Node newNode = new Node(value);
		totalValue += value;
		listLength ++;
		if(head == null) {
			head = newNode;
		} else {
			Node temp = head;
			while(temp.getChild() != null) {
				temp = temp.getChild();
			}
			temp.setChild(newNode);
		}
	}
	
	/**
	 * Returns the total of all values stored in the list.
	 *
	 * @return the total value of all elements in the list
	 */
	public double getTotalValue() {
		return totalValue;
	}
	
	/**
	 * Returns the number of values stored in the list.
	 *
	 * @return the length of the list
	 */
	public int getListLength() {
		return listLength;
	}
	
	/**
	 * Calculates and returns the mean of the values in the list.
	 *
	 * @return the mean of the values in the list
	 */
	public double getMean() {
		return (double) totalValue / listLength;
	}
	
	/**
	 * Calculates and returns the standard deviation of the values in the list.
	 *
	 * @return the standard deviation of the values in the list, or 0 if the
	 *         list is empty
	 */
	public double getStandardDerivative() {
		double variance = 0;
		Node pointer = head;
		double mean = getMean();
		double currentValue;
		if(pointer==null) {
			return 0;
		}
		
		while(pointer != null) {
			currentValue = mean - pointer.getValue();
			currentValue = currentValue * currentValue;
			variance += currentValue;
			pointer = pointer.getChild();
		}
		
		variance = variance / listLength;
		double standardDeviation = Math.sqrt(variance);
		return standardDeviation;
	}
	
	/**
	 * Creates and returns an ArrayList containing all the integer values
	 * stored in the linked list.
	 *
	 * @return an ArrayList containing the values in the list
	 */
	public ArrayList<Double> getList() {
		ArrayList<Double> list = new ArrayList<Double>();
		Node temp = head;
		
		if(temp==null) {
			return list;
		}
		while(temp != null) {
			list.add(temp.getValue());
			temp = temp.getChild();
		}
		return list;
	}
}