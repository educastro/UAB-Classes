package lab06;

public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList linkedList = new LinkedList();
		System.out.println("Size before adding: " + linkedList.getSizeOfTheList());
		System.out.println("Adding {1, 2, 3}.");
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		System.out.println("Size after adding: " + linkedList.getSizeOfTheList());
		System.out.println("Value from the first position: " + linkedList.getValue(1));
		System.out.println("Value from the second position: " + linkedList.getValue(2));
		System.out.println("Value from the third position: " + linkedList.getValue(3));
		System.out.println("Value from the 4th position: " + linkedList.getValue(4));
		System.out.println();
		
		System.out.println("Adding the element 10 at the second position.");
		linkedList.add(10, 2);
		System.out.println("Size after adding the element 10: " + linkedList.getSizeOfTheList());
		System.out.println("Value from the first position: " + linkedList.getValue(1));
		System.out.println("Value from the second position: " + linkedList.getValue(2));
		System.out.println("Value from the third position: " + linkedList.getValue(3));
		System.out.println("Value from the 4th position: " + linkedList.getValue(4));
		System.out.println();

		System.out.println("Removing the first element");
		linkedList.removeElement(1);
		System.out.println("Size after removing the first element: " + linkedList.getSizeOfTheList());
		System.out.println("Value from the first position: " + linkedList.getValue(1));
		System.out.println("Value from the second position: " + linkedList.getValue(2));
		System.out.println("Value from the third position: " + linkedList.getValue(3));
		System.out.println("Value from the 4th position: " + linkedList.getValue(4));
	}

}
