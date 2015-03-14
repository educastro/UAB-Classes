package lab06;

import java.io.FileNotFoundException;

public class PriorityQueueTest {
	
	public static void main(String[] args){
		PriorityQueue priorityQueue = new PriorityQueue();
		System.out.println("Number of Elements at the begin: " + priorityQueue.numberOfElementsAtThePriorityQueue);
		priorityQueue.insert(1);
		priorityQueue.insert(2);
		priorityQueue.insert(3);
		priorityQueue.insert(4);
		int position = priorityQueue.insert(5);
		System.out.println("Number of Elements after adding {1,2,3,4,5}: " + priorityQueue.numberOfElementsAtThePriorityQueue);
		System.out.println("Position from the element {5}: " + position);
		System.out.println("Tentative of delete element 4: " + priorityQueue.delete(4));
		System.out.println("Tentative of delete element 5: " + priorityQueue.delete(5));
		System.out.println("Tentative of delete element 1: " + priorityQueue.delete(1));
		System.out.println("Tentative of delete element 3: " + priorityQueue.delete(3));



	}
}
