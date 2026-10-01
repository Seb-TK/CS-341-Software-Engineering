package sebastian;

/**
 * Represents a node in a binary search tree.
 *
 * <p>Each node stores a word and references to its left child,
 * right child, and parent node.</p>
 */
public class Node {

    private String word;

    private Node leftChild;

    private Node rightChild;

    private Node parent;

    /**
     * Creates a new Node containing the specified word.
     *
     * @param word the word to store in the node
     */
    public Node(String word) {
        this.word = word;
    }

    /**
     * Compares the word stored in this node with the word
     * stored in another node.
     *
     * @param node the node to compare this node with
     * @return a negative value if this node's word comes before
     *         the other word alphabetically, zero if the words
     *         are equal, or a positive value if this node's word
     *         comes after the other word
     */
    public int compareTo(Node node) {
        return word.compareTo(node.getWord());
    }

    /**
     * Changes the word stored in this node.
     *
     * @param word the new word to store
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * Gets the word stored in this node.
     *
     * @return the word stored in the node
     */
    public String getWord() {
        return word;
    }

    /**
     * Sets the left child of this node.
     *
     * @param child the node to set as the left child
     */
    public void setLeft(Node child) {
        leftChild = child;
    }

    /**
     * Sets the right child of this node.
     *
     * @param child the node to set as the right child
     */
    public void setRight(Node child) {
        rightChild = child;
    }

    /**
     * Sets the parent of this node.
     *
     * @param parent the node to set as the parent
     */
    public void setParent(Node parent) {
        this.parent = parent;
    }

    /**
     * Gets the left child of this node.
     *
     * @return the left child node, or null if there is no left child
     */
    public Node left() {
        return leftChild;
    }

    /**
     * Gets the right child of this node.
     *
     * @return the right child node, or null if there is no right child
     */
    public Node right() {
        return rightChild;
    }

    /**
     * Gets the parent of this node.
     *
     * @return the parent node, or null if this node has no parent
     */
    public Node parent() {
        return parent;
    }
}