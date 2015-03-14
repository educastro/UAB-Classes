package lab06;

public class PriorityQueue {

	int[] priorityQueueArray;
	int numberOfElementsAtThePriorityQueue;
	
	public PriorityQueue(int size){
		priorityQueueArray = new int[size + 1];
		numberOfElementsAtThePriorityQueue = 0;
	}
	
	public PriorityQueue(){
		this(1);
	}
	
	public PriorityQueue(int[] arrayOfElements){
		numberOfElementsAtThePriorityQueue = arrayOfElements.length;
		priorityQueueArray = new int[arrayOfElements.length + 1];
		
		for(int iterator = 0; iterator < numberOfElementsAtThePriorityQueue; iterator++){
			priorityQueueArray[iterator + 1] = arrayOfElements[iterator];		
		}
		
		for(int secondIterator = numberOfElementsAtThePriorityQueue/2; secondIterator >= 1; secondIterator--){
			sink(secondIterator);
		}
	}
	
	public int getElement(int position){
		return priorityQueueArray[position];
	}
	
	public int insert(int value){
		if(numberOfElementsAtThePriorityQueue < priorityQueueArray.length - 1){
			resizeArray(priorityQueueArray.length * 2);
		}
		
		priorityQueueArray[++numberOfElementsAtThePriorityQueue] = value;
		swim(value);
		return numberOfElementsAtThePriorityQueue - 1;
	}
	
	public boolean delete(int value){
		if((numberOfElementsAtThePriorityQueue == 0) || (priorityQueueArray[1] != value))
			return false;
		else{
			swap(1, numberOfElementsAtThePriorityQueue);
			sink(1);
			if((numberOfElementsAtThePriorityQueue > 0) && (numberOfElementsAtThePriorityQueue == (priorityQueueArray.length - 1)/4)){
				resizeArray(priorityQueueArray.length/2);
			}
			return true;
		}
	}

	public void resizeArray(int newSize) {
		int[] tempArray = new int[newSize];
		for(int iterator = 1; iterator <= numberOfElementsAtThePriorityQueue; iterator++){
			tempArray[iterator] = priorityQueueArray[iterator];
		}
		priorityQueueArray = tempArray;
	}
	
	public void swap(int i, int j){
		int temp = priorityQueueArray[i];
		priorityQueueArray[i] = priorityQueueArray[j];
		priorityQueueArray[j] = temp;
	}
	
	private void swim(int value) {
		while((value > 1) && (priorityQueueArray[value/2] > priorityQueueArray[value])){
			swap(value, value/2);
			value = value/2;
		}
	}
	
	public void sink(int value){
		while(2 * value <= numberOfElementsAtThePriorityQueue){
			int j = 2 * value;
			
			if((j < numberOfElementsAtThePriorityQueue) && (priorityQueueArray[j] > priorityQueueArray[j+1]))
				j++;
			if(priorityQueueArray[j] > priorityQueueArray[value])
				break;
			
			swap(value, j);
			value = j;
		}
	}
	
}
