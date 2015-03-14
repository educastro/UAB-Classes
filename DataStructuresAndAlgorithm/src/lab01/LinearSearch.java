package lab01;

public class LinearSearch {
	
	/*
	 *  Function that searches for a number. It receives the array, the size of the array and the number
	 *  that it needs to be found
	 */
	public void lookForTheNumber(int[] arrayOfNumbers, int sizeOfArrayOfNumbers, int key){
		
		/*
		 *  Basically iterates between all the elements from the list searching for the key.
		 *  If the key is found than we close the procedure and print it. If doesnt than the
		 *  procedure closes itself at the end of the algorithm and print that it found nothing
		 */
		for(int iteratorNumber = 0; iteratorNumber < sizeOfArrayOfNumbers; iteratorNumber++) {
			if(arrayOfNumbers[iteratorNumber] == key){
				System.out.println(key + " is in the list");
				return;
			}
		}
		System.out.println(key + " is not in the list");
	}
}