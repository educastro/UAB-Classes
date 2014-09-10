package lab02;

import java.io.FileNotFoundException;

public class InsertionSort {

	public void sortAnArray(int[] arrayOfInputs, int sizeOfTheArrayOfInputs) throws FileNotFoundException{
		
		int key = 0;
		int j = 1;
		int i = 0;

		// Stores the current time of the computer system
		long startTime = System.currentTimeMillis();

		for(j = 1; j < sizeOfTheArrayOfInputs ; j++){
			key = arrayOfInputs[j];
			 for(i = j - 1; ((i >= 0) && (arrayOfInputs[i] > key)); i--) 
	          {
				 arrayOfInputs[i+1] = arrayOfInputs[i];
	          }
			 arrayOfInputs[i+1] = key;
		}
		
		// Stores the current time of the computer system
		long stopTime = System.currentTimeMillis();

		// Calculates the elapsed time using the time stores at the beggining and at the end of this execution
		long elapsedTime = stopTime - startTime;

		
		if(FileReadSortCheck.sortCheckAsc(arrayOfInputs)){
			System.out.println("It's sorted. The elapsed time is: " + elapsedTime);
		}
		else{	
			System.out.println("It's not sorted.");
			}
		
		
	}
	

}