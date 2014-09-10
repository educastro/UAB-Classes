package lab02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class InsertinoSortTest {

	public static void main(String[] args) throws FileNotFoundException {
		
		// Make the Insertion Sort 10 times for measuring time purposes
		for(int iterator = 0; iterator < 10; iterator++){
			// Gets the input file address and stores into a Scanner instance
			String inputAddressFile = "/Users/educastro/Documents/programming/java/workspace/CS303/lab02/src/lab02/input1.txt";
			Scanner inputFile = new Scanner(new FileReader(inputAddressFile));
			
			// Calls the function to discover how many elements are in the file of inputs
			int sizeOfTheArrayOfInputs = getHowManyElementsOnTheInputsFile(inputAddressFile);
			System.out.println(sizeOfTheArrayOfInputs);
					
			// Creates an array with the right size and inserts all the elements from the file into the array of inputs
			int[] arrayOfInputs = new int[sizeOfTheArrayOfInputs];
			for(int iteratorNumber = 0; iteratorNumber < sizeOfTheArrayOfInputs; iteratorNumber++){
				arrayOfInputs[iteratorNumber] = inputFile.nextInt();
			}
			
			// Close the Scanner instance
			inputFile.reset();
			inputFile.close();
			
			// Creates an InsertionSort instance and calls the sortAnArray method
			InsertionSort insertionSort = new InsertionSort();
			insertionSort.sortAnArray(arrayOfInputs, sizeOfTheArrayOfInputs);
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

}
