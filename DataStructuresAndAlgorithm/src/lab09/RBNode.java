package lab09;



public class RBNode<T extends Comparable>{
private boolean blackColor = true;
private RBNode<T> leftNode = null; 
private RBNode<T> rightNode = null; 
private T value; 
private RBNode<T> parentNode = null;
private T description;

public RBNode() {
	this.value = null;
	this.description = null;
	this.rightNode = null;
	this.leftNode = null;
	this.blackColor = true;
	
}

public RBNode(T theData) {
	this.value = theData;
	this.leftNode = null;
	this.rightNode = null;
	this.makeBlack();
}

public RBNode(T theData, T description) {
	this.value = theData;
	this.description = description;
	this.leftNode = null;
	this.rightNode = null;
	this.makeBlack();
}


public T getValue() {
	return value;
}

public T getDescription() {
	return description;
}

public RBNode<T> getParent() {
	return this.parentNode;
}

public void setParent(RBNode newNode) {
	this.parentNode = newNode;
}

public RBNode<T> getLeft() {
	return leftNode;
}

public RBNode<T> getRight() {
	return rightNode;
}

public void setLeft(RBNode<T> newNode) {
	leftNode = newNode;

}

public void setRight(RBNode<T> newNode) {
	rightNode = newNode;

}

public void preOrder() {
	if(value!=null){
	System.out.println(value);}

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

	if (leftNode.getValue() != null) {
		treeString += leftNode.toStringPreOrder(pathString + "L");
	}

	if (rightNode.getValue() != null) {
		treeString += rightNode.toStringPreOrder(pathString + "R");
	}

	return treeString;
}

public void makeBlack(){
	this.blackColor = true;
}
public void makeRed(){
	this.blackColor = false;
}
public boolean isBlack(){
	return this.blackColor;
}

}
