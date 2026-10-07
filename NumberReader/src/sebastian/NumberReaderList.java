package sebastian;

import java.util.ArrayList;
import java.util.List;

public class NumberReaderList {

	Node head;
	int totalValue;
	int listLength;
	
	public NumberReaderList() {
		totalValue = 0;
		listLength = 0;
	}
	
	public void addNode(int value) {
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
	
	public int getTotalValue() {
		return totalValue;
	}
	
	public int getListLength() {
		return listLength;
	}
	
	public double getMean() {
		return (double) totalValue / listLength;
	}
	
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
	
	public ArrayList<Integer> getList() {
		ArrayList<Integer> list = new ArrayList<Integer>();
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
