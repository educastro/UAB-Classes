package lab09;


public class RBTree<T extends Comparable>{
	private RBNode<T> root;
	private RBNode<T> cursor;
	private RBNode<T> nil = new RBNode();

	public RBTree() {
		this.root = nil;
	}
	
	public void newNode(int theData){
		RBNode newNode = new RBNode(theData);
		newNode.setParent(nil);
		newNode.setRight(nil);
		newNode.setLeft(nil);
	}
	
	public RBNode<T> getRoot(){
		return this.root;
	}
	
	public T getRootValue(){
		return this.root.getValue();
	}
	
//	public boolean searchTree(RBNode<T> nodeToBeSearch, T value) {
//		RBNode currentNode = root;
//		
//		if (currentNode == nil) {
//			return false;
//		}
//		
//		if (value == currentNode.getValue()) {
//			return true;
//		}
//		
//		if (value.compareTo(currentNode.getValue()) == -1) {
//			return searchTree(currentNode.getLeft(), value);
//		} else {
//			return searchTree(currentNode.getRight(), value);
//		}
//	}
	
	public boolean treeSearch(RBNode<T> x, T k) {
		if (x == nil) {
			return false;
		}
		if (k == x.getValue()) {
			return true;
		}
		if (k.compareTo(x.getValue()) == -1) {
			return treeSearch(x.getLeft(), k);
		} else
			return treeSearch(x.getRight(), k);
	}
	
	public void inOrderTreeWalk(RBNode<T> node) {
		if (node != nil) {
			inOrderTreeWalk(node.getLeft());
			
			System.out.println(node.getValue());
			inOrderTreeWalk(node.getRight());
		}

	}
	
	private void leftRotate(RBNode<T> x) {
		RBNode<T> y = x.getRight(); // set y
		
		x.setRight(y.getLeft()); // turn y's left subtree into x's right subtree
		
		if(!(y.getLeft().equals(nil))) {
			y.getLeft().setParent(x);
		}
		
		y.setParent(x.getParent()); // link x's parents to y
		
		if(x.getParent().equals(nil)) {
			this.root = y;
		}
		
		else if(x == x.getParent().getLeft()) {
			x.getParent().setLeft(y);
		}
		
		else {
			x.getParent().setRight(y);
		}
		
		y.setLeft(x); // put x on y's left
		x.setParent(y);
	}
	
	private void rightRotate(RBNode<T> x){
		RBNode<T> y = x.getLeft(); // set y
		
		x.setLeft(y.getRight()); // turn y's left subtree into x's right subtree
		
		if(!(y.getRight().equals(nil))){
			y.getRight().setParent(x);
		}
		
		y.setParent(x.getParent()); // link x's parents to y
		
		if(x.getParent().equals(nil)) {
			this.root = y;
		}
		
		else if(x == x.getParent().getRight()) {
			x.getParent().setRight(y);
		}
		
		else {
			x.getParent().setLeft(y);
		}
		
		y.setRight(x); // put y on y's right
		x.setParent(y);
	}
	
	public void rbInsert(RBNode<T> z){
		if(this.root == nil){
			this.root = z;
			root.setParent(nil);
			root.setRight(nil);
			root.setLeft(nil);
			root.makeBlack();
			return;
		}
		
		RBNode<T> y = nil;
		RBNode<T> x = this.root;
		
		while(x != nil){
			y = x;
			if(z.getValue().compareTo(x.getValue()) == -1){
				x = x.getLeft();
			}
			else {x = x.getRight();}
		}
		
		z.setParent(y);
		
		if(y.equals(nil)) {
			this.root = z;
		}
		
		else if(z.getValue().compareTo(y.getValue())== -1) {
			y.setLeft(z);
		}
		
		else {
			y.setRight(z);
		}
		
		z.setLeft(nil);
		z.setRight(nil);
		z.makeRed();
		z.setParent(y);
		rbInsertFixup(z);
	}
	
	public String toString() {
		if (this.root != nil) {
			return this.root.toStringPreOrder(".");
		} else {
			return "";
		}
	}
	
	public void rbInsertFixup(RBNode<T> z){
		while(z.getParent().isBlack() == false) {
			if(z.getParent() == z.getParent().getParent().getLeft()) {
				RBNode<T> y = z.getParent().getParent().getRight();
				
				if(y.isBlack() == false) {
					z.getParent().makeBlack();
					y.makeBlack();
					z.getParent().getParent().makeRed();
				}
				
				else {
					if (z == z.getParent().getRight()) {
						z = z.getParent();
						leftRotate(z);
					}
				}
			
				z.getParent().makeBlack();
				z.getParent().getParent().makeRed();
				rightRotate(z.getParent().getParent());
			}
			
			else {
				RBNode<T> y = z.getParent().getParent().getLeft();
				
				if(y.isBlack() == false) {
					z.getParent().makeBlack();
					y.makeBlack();
					z.getParent().getParent().makeRed();
				}
				
				else {
					if (z == z.getParent().getLeft()) {
						z = z.getParent();
						rightRotate(z);
					}
				
					z.getParent().makeBlack();
					z.getParent().getParent().makeRed();
					leftRotate(z.getParent().getParent());
				}
			}
		}
		
		this.root.makeBlack();
	}
}
