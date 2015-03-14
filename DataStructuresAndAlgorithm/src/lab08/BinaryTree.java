package lab08;

public class BinaryTree<T> {
	private BinaryTreeNode<T> root; // the root of the tree
	private BinaryTreeNode<T> cursor; // the current node

	public BinaryTreeNode getRoot(){
		return root;
	}
	
	public void setRoot(BinaryTreeNode root){
		this.root = root;
	}
	
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
		return cursor.getData();
	}

	public void set(T data) {
		cursor.setData(data);
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