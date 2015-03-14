package lab09;


public class RBTreeTest {

	public static void main(String[] args) {
		RBTree<Integer> rbTree = new RBTree<Integer>();
		RBNode node1 = new RBNode(1);
		RBNode node2 = new RBNode(2);
		RBNode node3 = new RBNode(3);
		RBNode node4 = new RBNode(4);
		RBNode node5 = new RBNode(5);
		RBNode node6 = new RBNode(6);
		RBNode node7 = new RBNode(7);
		
		System.out.println("Inserting elements 1,2,3,4,5,6,7");
		rbTree.rbInsert(node1);
		rbTree.rbInsert(node2);
		rbTree.rbInsert(node3);
		rbTree.rbInsert(node4);
		rbTree.rbInsert(node5);
		rbTree.rbInsert(node6);
		rbTree.rbInsert(node7);
		
		System.out.println("Printing the tree");
		System.out.println(rbTree.toString());
		
		System.out.println("5 is in tree: " + rbTree.treeSearch(rbTree.getRoot(), 5));
		System.out.println("50 is in tree: " + rbTree.treeSearch(rbTree.getRoot(), 50));
		
		
	}
}
