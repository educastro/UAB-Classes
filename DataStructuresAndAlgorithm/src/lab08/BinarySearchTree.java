package lab08;

public class BinarySearchTree {
	
	public void delete(BinaryTree binaryTree, BinaryTreeNode nodeToBeDeleted){
		if(nodeToBeDeleted.getLeft() == null)
			transplant(binaryTree, nodeToBeDeleted, nodeToBeDeleted.getRight());
		else if(nodeToBeDeleted.getRight() == null)
			transplant(binaryTree, nodeToBeDeleted, nodeToBeDeleted.getLeft());
		else {
			BinaryTreeNode minimumNode = treeMinimum(nodeToBeDeleted);
			
			if(minimumNode.getParent() != nodeToBeDeleted){
				transplant(binaryTree, minimumNode, minimumNode.getRight());
				minimumNode.setRight(nodeToBeDeleted.getRight());
				minimumNode.getRight().setParent(minimumNode);
			}
			
			transplant(binaryTree, nodeToBeDeleted, minimumNode);
			minimumNode.setLeft(nodeToBeDeleted.getLeft());
			minimumNode.getLeft().setParent(minimumNode);
		}
	}
	
	public BinaryTreeNode treeMinimum(BinaryTreeNode node){
		BinaryTreeNode currentNode = node;
		while(node.getLeft() != null){
			currentNode = node.getLeft();
		}
		return currentNode;
	}
	
	public void transplant(BinaryTree binaryTree, BinaryTreeNode u, BinaryTreeNode v){
		if (u.getParent() == null)
			binaryTree.setRoot(v);
		else if(u == u.getParent().getLeft())
			u.getParent().setLeft(v);
		else
			u.getParent().setRight(v);
		
		if (v != null)
			v.setParent(u.getParent());
	}
	
	public void insert(BinaryTree binaryTree, BinaryTreeNode newNode){
		BinaryTreeNode auxiliarNode = null;
		BinaryTreeNode currentNode = binaryTree.getRoot(); 
		
		while(currentNode != null){
			auxiliarNode = currentNode;
			if((int) newNode.getData() < (int) currentNode.getData()){
				currentNode = currentNode.getLeft();
			} else{
				currentNode = currentNode.getRight();
			}
		}
		
		newNode.setParent(binaryTree.getRoot());
		
		if(auxiliarNode == null){
			binaryTree.setRoot(newNode);
		} else if((int) newNode.getData() < (int) auxiliarNode.getData()){
			auxiliarNode.setLeft(newNode);
		} else{
			auxiliarNode.setRight(newNode);
		}						
	}
	
	public boolean search(BinaryTreeNode binaryTreeNode, int elementToBeFound){
		if((binaryTreeNode == null))
			return false; 
		if(elementToBeFound == (int) binaryTreeNode.getData()){
			return true;
		}
		
		if(elementToBeFound < (int) binaryTreeNode.getData()){
			return search(binaryTreeNode.getLeft(), elementToBeFound);
		} else{
			return search(binaryTreeNode.getRight(), elementToBeFound);
		}
	}
	
	public void indorderTreeWalk(BinaryTreeNode node){
		if(node != null){
			indorderTreeWalk(node.getLeft());
			System.out.println(node.getData().toString());
			indorderTreeWalk(node.getRight());
		}
	}
		
}
	
	


