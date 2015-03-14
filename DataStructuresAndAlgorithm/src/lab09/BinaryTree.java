package lab09;


public class BinaryTree<T extends Comparable> {
	private BinaryTreeNode<T> root; // the root of the tree
	private BinaryTreeNode<T> cursor; // the current node

	public void toRoot() {
		cursor = root;
	}

	public boolean hasLeftChild() {
		return cursor.getLeft() != null;
	}

	public boolean hasRightChild() {
		return cursor.getRight() != null;
	}

	public void toLeftChild() {
		cursor = cursor.getLeft();
	}

	public void toRightChild() {
		cursor = cursor.getRight();
	}


	public T get() {
		return cursor.getValue();
	}

	public void set(T value) {
		cursor.setValue(value);
	}

	public int height() {
		if (root != null) {
			return root.height();
		} else {
			return 0;
		}
	}

	public String toString() {
		if (root != null) {
			return root.toStringPreOrder(".");
		} else {
			return "";
		}
	}
}