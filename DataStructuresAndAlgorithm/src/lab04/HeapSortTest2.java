package lab04;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class HeapSortTest2 {

	public static void main(String[] args) throws FileNotFoundException {

		String inputAddressFile = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_32.txt";
		Scanner inputFile = new Scanner(new FileReader(inputAddressFile));

		// Calls the function to discover how many elements are in the file of inputs
		int sizeOfTheArrayOfInputs = getHowManyElementsOnTheInputsFile(inputAddressFile);

		// Creates an array with the right size and inserts all the elements from the file into the array of inputs
		int[] arrayOfInputs = new int[sizeOfTheArrayOfInputs];
		for(int iteratorNumber = 0; iteratorNumber < sizeOfTheArrayOfInputs; iteratorNumber++){
			arrayOfInputs[iteratorNumber] = inputFile.nextInt();
		}

		// Close the Scanner instance
		inputFile.reset();
		inputFile.close();

		// Creates an InsertionSort instance and calls the sortAnArray method
		HeapSort heapSort = new HeapSort();
		long startTime = System.nanoTime();

		heapSort.heapSort(arrayOfInputs);

		// Stores the current time of the computer system
		long stopTime = System.nanoTime();

		// Calculates the elapsed time using the time stores at the beggining and at the end of this execution
		long elapsedTime = stopTime - startTime;
		
		for(int x = 0; x < 31; x++){
			System.out.println(arrayOfInputs[x]);
		}

		if(sortCheckAsc(arrayOfInputs)){
			System.out.println("It's sorted. The elapsed time for file # is: " + elapsedTime);
		}
		else{	
			System.out.println("It's not sorted.");
		}

		System.out.println("--------");

		System.out.println("End");

	}

	// Calculates how many elements there are at the inputs file
	private static int getHowManyElementsOnTheInputsFile(String inputAddressFile) throws FileNotFoundException{
		Scanner inputFile = new Scanner(new FileReader(inputAddressFile));

		// Variable that will be incremented for each element at the input file
		int sizeOfTheArrayOfInputs = 0;

		/*
		 *  Everytime that there is a next element then increment the sizeOfTheArrayOfInputs variable
		 *  and goes to the next element
		 */
		while(inputFile.hasNextInt()){
			sizeOfTheArrayOfInputs++;
			inputFile.nextInt();
		}

		// Close the Scanner instance
		inputFile.close();

		// Return how many elements there are in the input file for the creation of the array
		return sizeOfTheArrayOfInputs;
	}

	// Checks if the sorting was made correctly
	public static boolean sortCheckAsc(int[] a) {
		int  N = a.length;
		int prev = a[0];
		boolean isSorted = true;
		for(int i=1; i< N; i++){
			if(a[i] >= prev) {
				continue;
			}
			else {
				isSorted = false;
				return isSorted;
			}
		}
		return isSorted;
	}


}