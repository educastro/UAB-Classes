package lab06;

import java.util.Arrays;

public class PriorityQueueLinkedList {
	
//	public int insertIntoPriorityQueue(int[] priorityQueue, int element){
//		int lastElement = priorityQueue.length - 1;
//		priorityQueue[lastElement] = element;
//		return lastElement;
//	}
//	
//	public boolean delete(int[] priorityQueue, int element){
//		int size = priorityQueue.length;
//		for(int iterator = )
//			
//		
//	}
	
	public int insert(int element){
		add(element);
		return sizeOfTheList;
	}
	
	public boolean delete(int element){
		Node currentNode = head;
		int position = 0;
			
		while(currentNode.getNext() != null){
			currentNode = currentNode.getNext();	
			if((int) currentNode.getValue() == element){
				removeElement(position);
				return true;
			}		
			position++;
		}	
		
		return false;
	}
	
	// Starts the implementation of a LinkedList
	private Node head;
	private int sizeOfTheList;
	
	public PriorityQueueLinkedList() {
		head = new Node(null);
		sizeOfTheList = 0;
	}
	
	public int getSizeOfTheList(){
			return sizeOfTheList;
	}
	
	public boolean isTheListEmpty(){
		if(sizeOfTheList > 0)
			return false;
		else
			return true;
	}
	
	public void add(Object value){
		Node currentNode = head;
		Node newNode = new Node(value);
		
		while(currentNode.getNext() != null){
			currentNode = currentNode.getNext();
		}
		
		currentNode.setNext(newNode);
		sizeOfTheList++;
	}
	
	public void add(Object value, int position){
		Node currentNode = head;
		Node newNode = new Node(value);
		
		if(position > sizeOfTheList)
			return;
		
		for(int iterator = 1; iterator < position; iterator++){
			currentNode = currentNode.getNext();
		}
		
		newNode.setNext(currentNode.getNext());
		currentNode.setNext(newNode);
		sizeOfTheList++;
	}
	
	public void removeElement(){
		Node currentNode = head;
		
		if(sizeOfTheList == 0){
			return;
		}
		
		currentNode.getNext();
		
		for(int iterator = 1; iterator < sizeOfTheList; iterator++){
			currentNode = currentNode.getNext();
		}
		
		currentNode.setNext(null);
		sizeOfTheList--;
	}
	
	public void removeElement(int position){
		Node currentNode = head;
		
		if((sizeOfTheList == 0) || (position > sizeOfTheList)){
			return;
		}
				
		for(int iterator = 1; iterator < position; iterator++){
			currentNode = currentNode.getNext();
		}
		
		currentNode.setNext(currentNode.getNext().getNext());
		sizeOfTheList--;
		
	}
	
	public Object getValue(int position){
		if(position <= 0)
			return null;
		
		Node currentNode = head.getNext();
		for(int iterator = 1; iterator < position; iterator++){
			if(currentNode.getNext() == null)
				return null;
			
			currentNode = currentNode.getNext();
		}
		
		return currentNode.getValue();
	}
	
	public int containsElement(int value){
		Node currentNode = head;
		int position = 0;
		
		while(currentNode.getNext() != null){
			currentNode = currentNode.getNext();
			
			if((int) currentNode.getValue() == value)
				return position;
			
			position++;
		}
		
		return 0;
	}
	

}
