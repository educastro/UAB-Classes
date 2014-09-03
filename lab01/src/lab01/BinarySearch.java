package lab01;

public class BinarySearch {
	
	/*
	 *  Function that searches for a number. It receives the array, the size of the array and the number
	 *  that it needs to be found
	 */
	
	public void lookForTheNumber(int[] arrayOfNumbers, int sizeOfArrayOfNumbers, int key){
		// Stores the position of the first element of the array
		int firstElement = 0;
		
		// Stores the last element of the array
		int lastElement = sizeOfArrayOfNumbers - 1;
		
		// Calculates the middle element of the array
		int middleElement = (firstElement + lastElement) / 2;
		
		// It will iterate the array until check all the elements recursively
		while(firstElement <= lastElement){
			
			/*
			 *  If the key is bigger than the middle element than we set that the new first element
			 *  of the array is the next one after the middle, doing this we "ignore" everything that
			 *  is on the left side of the array(or is smaller than the middle) and start working with a new data set
			 *  that it is the right side of the array
			 */
	    	if(arrayOfNumbers[middleElement] <= key){
	    		firstElement = middleElement + 1;
	    	}
	    	
	    	// If the number is found then we stop the execution
	    	else if(arrayOfNumbers[middleElement] == key){
				System.out.println(key + " is in the list");
				return;
	    	}
	    	
	    	/* 
	    	 * If the number was not found or the key is smaller than the middle than we set that the new
	    	 * last element is the number that came right before the middle one, doing this we "ignore"
	    	 * everything that is on the right side of the array(or is bigger than the middle) and start working
	    	 * with a new data set that it is the left side of the array
	    	 */
	    	else {
	    		lastElement = middleElement - 1;
	    	}
    		
	    	/*
	    	 *  Everytime that the number was not found then we calculate the new middle element creating a new
	    	 *  data set of elements that will be the right or left side of the array. This will be done everytime 
	    	 *  until the algorithm iterates into all the elements or the number be found
	    	 */
	    	middleElement = (firstElement + lastElement)/2;
	    }	    
		
		/* 
		 *  If the while is over and the compiler reaches this point than it means that the algorithm iterated
		 *  between all the elements from the list and didnt find the key
		 */
		System.out.println(key + " is not in the list");
	}
}
