package lab08;

public class BinarySearchTreeTest {

	public static void main(String[] args) {
		BinaryTree test = new BinaryTree();
		BinarySearchTree searchTest = new BinarySearchTree();
		BinaryTreeNode node = new BinaryTreeNode(5);
		BinaryTreeNode node2 = new BinaryTreeNode(10);
		BinaryTreeNode node3 = new BinaryTreeNode(3);
		BinaryTreeNode node4 = new BinaryTreeNode(50);
		
		searchTest.insert(test, node);
		searchTest.insert(test, node2);
		searchTest.insert(test, node3);
		searchTest.insert(test, node4);
		System.out.println("Printing all the tree after the insertions:");
		searchTest.indorderTreeWalk(test.getRoot());
		searchTest.delete(test, node2);
		System.out.println("Now printing all the tree after the deletion:");
		searchTest.indorderTreeWalk(test.getRoot());
		if(searchTest.search(test.getRoot(), 10))
			System.out.println("true");
		else
			System.out.println("false");

	}

}
