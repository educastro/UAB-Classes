package lab09;


public class BinaryTreeNode<T extends Comparable> {
	private BinaryTreeNode<T> leftNode; 
	private BinaryTreeNode<T> rightNode;
	private T value; 

	public BinaryTreeNode() {
		this(null, null, null);
	}

	public BinaryTreeNode(T theData) {
		this(theData, null, null);
	}

	public BinaryTreeNode(T value, BinaryTreeNode<T> leftNode,
			BinaryTreeNode<T> rightNode) {
		this.value = value;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}

	public T getValue() {
		return value;
	}

	public BinaryTreeNode<T> getLeft() {
		return leftNode;
	}

	public BinaryTreeNode<T> getRight() {
		return rightNode;
	}

	public void setLeft(BinaryTreeNode<T> newNode) {
		this.leftNode = newNode;
	}

	public void setRight(BinaryTreeNode<T> newNode) {
		this.rightNode = newNode;
	}

	public void setValue(T newValue) {
		this.value = newValue;
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