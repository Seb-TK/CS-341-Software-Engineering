package sebastian;

/**
 * Represents a node containing an integer value and a reference to another
 * node as its child.
 */
public class Node {

	private double value;

	private Node child;

	/**
	 * Constructs a Node with the specified integer value.
	 *
	 * @param value the integer value stored in this node
	 */
	public Node(double value) {

		this.value = value;

	}

	/**
	 * Sets the child node.
	 *
	 * @param child the node to set as this node's child
	 */
	public void setChild(Node child) {

		this.child = child;

	}

	/**
	 * Returns the integer value stored in this node.
	 *
	 * @return the value stored in this node
	 */
	public double getValue() {

		return value;

	}

	/**
	 * Returns the child node.
	 *
	 * @return this node's child node
	 */
	public Node getChild() {

		return child;

	}

}