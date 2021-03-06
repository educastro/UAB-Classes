package lab04;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class HeapSortTest {

	public static void main(String[] args) throws FileNotFoundException {
		// Gets the input file address and stores into a Scanner instance. Each position is one file.
		String[] inputAddressFile = new String[31];
		inputAddressFile[0] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_16.txt";
		inputAddressFile[1] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_32.txt";
		inputAddressFile[2] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_128.txt";
		inputAddressFile[3] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_128.txt";
		inputAddressFile[4] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_256.txt";
		inputAddressFile[5] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_512.txt";
		inputAddressFile[6] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_1024.txt";
		inputAddressFile[7] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_2048.txt";
		inputAddressFile[8] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_4096.txt";
		inputAddressFile[9] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_8192.txt";
		inputAddressFile[10] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_2_4.txt";
		inputAddressFile[11] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_2_5.txt";
		inputAddressFile[12] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_2_6.txt";
		inputAddressFile[13] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_2_7.txt";
		inputAddressFile[14] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_2_8.txt";
		inputAddressFile[15] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_2_9.txt";
		inputAddressFile[16] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_2_10.txt";
		inputAddressFile[17] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_2_11.txt";
		inputAddressFile[18] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_2_12.txt";
		inputAddressFile[19] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_2_13.txt";
		inputAddressFile[20] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_2_14.txt";
		inputAddressFile[21] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_2_15.txt";
		inputAddressFile[22] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_2_16.txt";
		inputAddressFile[23] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_2_17.txt";
		inputAddressFile[24] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_2_18.txt";
		inputAddressFile[25] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_2_19.txt";
		inputAddressFile[26] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_2_20.txt";
		inputAddressFile[27] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_2_21.txt";
		inputAddressFile[28] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_2_22.txt";
		inputAddressFile[29] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_2_23.txt";
		inputAddressFile[30] = "/Users/educastro/Documents/programming/java/workspace/CS303/lab03/src/lab03/input_2_24.txt";

		// Execute the algorithm for each input file and returns if the sort is right or not for each one of them
		for(int iteratorInputAddress = 0; iteratorInputAddress < 31; iteratorInputAddress++){
			Scanner inputFile = new Scanner(new FileReader(inputAddressFile[iteratorInputAddress]));
		
			// Calls the function to discover how many elements are in the file of inputs
			int sizeOfTheArrayOfInputs = getHowManyElementsOnTheInputsFile(inputAddressFile[iteratorInputAddress]);

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

			if(sortCheckAsc(arrayOfInputs)){
				System.out.println("It's sorted. The elapsed time for file #" + (iteratorInputAddress + 1) + " is: " + elapsedTime);
			}
			else{	
				System.out.println("It's not sorted.");
			}

			System.out.println("--------");
		}
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
		int N = a.length;
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