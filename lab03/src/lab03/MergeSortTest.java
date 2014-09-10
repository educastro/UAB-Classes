package lab03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MergeSortTest {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		// Gets the input file address and stores into a Scanner instance. Each position is one file.
		String[] inputAddressFile = new String[10];
		inputAddressFile[0] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_16.txt";
		inputAddressFile[1] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_32.txt";
		inputAddressFile[2] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_64.txt";
		inputAddressFile[3] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_128.txt";
		inputAddressFile[4] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_256.txt";
		inputAddressFile[5] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_512.txt";
		inputAddressFile[6] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_1024.txt";
		inputAddressFile[7] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_2048.txt";
		inputAddressFile[8] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_4096.txt";
		inputAddressFile[9] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_8192.txt";
		
		// Execute the algorithm for each input file and returns if the sort is right or not for each one of them
		for(int iteratorInputAddress = 0; iteratorInputAddress < 10; iteratorInputAddress++){
			Scanner inputFile = new Scanner(new FileReader(inputAddressFile[iteratorInputAddress]));
			
			// Calls the function to discover how many elements are in the file of inputs
			int sizeOfTheArrayOfInputs = getHowManyElementsOnTheInputsFile(inputAddressFile[iteratorInputAddress]);
					
			/*
			 *  Creates an array with the right size and inserts all the elements
			 *  from the file into the array of inputs and temp array 
			 */
			int[] arrayOfInputs = new int[sizeOfTheArrayOfInputs];
			int[] tempArray = new int[sizeOfTheArrayOfInputs];

			for(int iteratorNumber = 0; iteratorNumber < sizeOfTheArrayOfInputs; iteratorNumber++){
				int tempNumber = inputFile.nextInt();
				arrayOfInputs[iteratorNumber] = tempNumber;
				tempArray[iteratorNumber] = tempNumber;
				
			}
			
			// Sets the initial position and the last position
			int initialPosition = 0;
			int lastPosition = sizeOfTheArrayOfInputs - 1;
			
			// Close the Scanner instance
			inputFile.close();
			
			// Creates an InsertionSort instance and calls the sortAnArray method
			MergeSort insertionSort = new MergeSort();
			insertionSort.mergeSort(arrayOfInputs, tempArray, initialPosition, lastPosition);
			
			// For each call that the algorithm made it prints if the sorting was right or wrong
			System.out.println("Sort from input file number #" + iteratorInputAddress + ": " + sortCheckAsc(arrayOfInputs));
		}
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