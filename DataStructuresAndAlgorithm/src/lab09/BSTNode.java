package lab09;


public class BSTNode<T extends Comparable> extends BinaryTreeNode {
	private BSTNode<T> leftNode; // the left child
	private BSTNode<T> rightNode; // the right child
	private T value; // the data in this node
	private BSTNode<T> parentNode;

	public BSTNode() {
		this(null, null, null);
	}

	public BSTNode(T value) {
		this(value, null, null);
	}

	public BSTNode(T value, BSTNode<T> leftNode, BSTNode<T> rightNode) {
		this.value = value;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}

	public T getValue() {
		return value;
	}

	public BSTNode<T> getParent() {
		return this.parentNode;
	}

	public void setParent(BSTNode newParent) {
		this.parentNode = newParent;
	}

	public BSTNode<T> getLeft() {
		return leftNode;
	}

	public BSTNode<T> getRight() {
		return rightNode;
	}

	public void setLeft(BSTNode<T> newNode) {
		leftNode = newNode;

	}

	public void setRight(BSTNode<T> newNode) {
		rightNode = newNode;

	}

	public void preOrder() {
		System.out.println(value);

		if (leftNode != null) {
			leftNode.preOrder();
		}

		if (rightNode != null) {
			rightNode.preOrder();
		}
	}

	public int height() {
		int leftHeight = 0; 
		int rightHeight = 0;
		int height = 0; 

		// If there is a left subtree, determine the height
		if (leftNode != null) {
			leftHeight = leftNode.height();
		}

		// If there is a right subtree, determine the height
		if (rightNode != null) {
			rightHeight = rightNode.height();
		}

		if (leftHeight > rightHeight) {
			height = 1 + leftHeight;
		} else {
			height = 1 + rightHeight;
		}

		// Return the answer
		return height;
	}

	public String toStringPreOrder(String pathString) {
		String treeString = pathString + " : " + value + "\n";

		if (leftNode != null) {
			treeString += leftNode.toStringPreOrder(pathString + "L");
		}

		if (rightNode != null) {
			treeString += rightNode.toStringPreOrder(pathString + "R");
		}

		return treeString;
	}
}
