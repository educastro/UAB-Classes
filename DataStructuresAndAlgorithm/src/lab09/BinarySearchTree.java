package lab09;

public class BinarySearchTree<T extends Comparable> extends BinaryTree {
	private BSTNode<T> root; 
	private BSTNode<T> cursor;

	public BinarySearchTree() {
		this.root = null;
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	public void insert(T value) {
		BSTNode<T> newNode = new BSTNode<T>(value);
		
		if (this.root == null) {
			this.root = newNode;
			return;
		}

		BSTNode<T> auxiliarNode = null;
		BSTNode<T> currentNode = this.root;
		
		while (currentNode != null) {
			auxiliarNode = currentNode;
			
			if (newNode.getValue().compareTo(currentNode.getValue()) == -1) {
				currentNode = currentNode.getLeft();
			} else
				currentNode = currentNode.getRight();
		}
		
		newNode.setParent(auxiliarNode);
		
		if (auxiliarNode == null) {
			this.root = newNode;
		} else if (newNode.getValue().compareTo(auxiliarNode.getValue()) == -1) {
			auxiliarNode.setLeft(newNode);
		} else
			auxiliarNode.setRight(newNode);
	}

	public boolean search(BSTNode<T> binaryTreeNode, T elementToBeFound) {
		if (binaryTreeNode == null) {
			return false;
		}
		
		if (elementToBeFound == binaryTreeNode.getValue()) {
			return true;
		}
		
		if (elementToBeFound.compareTo(binaryTreeNode.getValue()) == -1) {
			return search(binaryTreeNode.getLeft(), elementToBeFound);
		} else {
			return search(binaryTreeNode.getRight(), elementToBeFound);
		}
	}

	public void inOrderTreeWalk(BSTNode<T> x) {
		if (x != null) {
			inOrderTreeWalk(x.getLeft());
			System.out.println(x.getValue());
			inOrderTreeWalk(x.getRight());
		}

	}

	public String toString() {
		if (root != null) {
			return root.toStringPreOrder(".");
		} else {
			return "";
		}
	}

	private void transplant(BSTNode<T> u, BSTNode<T> v) {
		if (u.getParent() == null) {
			this.root = v;
		} else if (u == u.getParent().getLeft()) {
			u.getParent().setLeft(v);
		} else
			u.getParent().setRight(v);

		if (v != null) {
			v.setParent(u.getParent());
		}
	}

	private boolean delete(BSTNode<T> nodeToBeDeleted) {
		if (nodeToBeDeleted.getLeft() == null) {
			transplant(nodeToBeDeleted, nodeToBeDeleted.getRight());
		} else if (nodeToBeDeleted.getRight() == null) {
			transplant(nodeToBeDeleted, nodeToBeDeleted.getLeft());
		} else {
			BSTNode<T> y = treeMinimum(nodeToBeDeleted.getRight());
			if (y.getParent() != nodeToBeDeleted) {
				transplant(y, y.getRight());
				y.setRight(nodeToBeDeleted.getRight());
				y.getRight().setParent(y);
			}
			transplant(nodeToBeDeleted, y);
			y.setLeft(nodeToBeDeleted.getLeft());
			y.getLeft().setParent(y);

		}
		return true;
	}

	private boolean treeSearchForDeleting(BSTNode<T> nodeToBeDeleted, T valueToBeDeleted) {
		if (nodeToBeDeleted == null) {
			return false;
		}
		if (valueToBeDeleted == nodeToBeDeleted.getValue()) {
			return delete(nodeToBeDeleted);
		}
		if (valueToBeDeleted.compareTo(nodeToBeDeleted.getValue()) == -1) {
			return treeSearchForDeleting(nodeToBeDeleted.getLeft(), valueToBeDeleted);
		} else
			return treeSearchForDeleting(nodeToBeDeleted.getRight(), valueToBeDeleted);
	}

	public boolean deleteNode(T value) {
		if (this.root == null) {
			return false;
		} else if (this.search(this.root, value) == false) {
			return false;
		} else {
			return treeSearchForDeleting(this.root, value);
		}
	}

	private BSTNode<T> treeMinimum(BSTNode<T> node) {
		if (node.getLeft() == null) {
			return node;
		} else
			return treeMinimum(node.getLeft());
	}
}
