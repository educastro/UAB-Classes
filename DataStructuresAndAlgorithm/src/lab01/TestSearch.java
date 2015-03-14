package lab01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TestSearch {
	
	public static void main(String[] args) throws FileNotFoundException {
		// Stores the current time of the computer system
		long startTime = System.currentTimeMillis();
		
		// Calls the function that prepares and calls LinearSearch or BinarySearch algorithms 
		makeABinarySearch();
		
		// Stores the current time of the computer system
		long stopTime = System.currentTimeMillis();
		
		// Calculates the elapsed time using the time stores at the beggining and at the end of this execution
		long elapsedTime = stopTime - startTime;
		
		// Prints the execution time
		System.out.println("execution time for binary search with 100 elements: " + elapsedTime);
		
		
	}
	
	// Creates and object, prepares all the data and call the function for a Linear Search
	@SuppressWarnings("unused")
	private static void makeALinearSearch() throws FileNotFoundException{
		// LinearSearch instance
		LinearSearch linearSearch = new LinearSearch();
		
		// Sets the Scanner instance for reading the txt file of inputs
		String inputAdressFile = "/Users/educastro/Documents/programming/java/workspace/CS303/DataStructuresAndAlgorithm/src/lab01/input10000.txt";
		
		@SuppressWarnings("resource")
		Scanner inputFile = new Scanner(new FileReader(inputAdressFile));
		
		// Calls the function to discover how many elements are in the file of inputs
		getHowManyElementsOnTheInputsFile();
		
		// Creates an array with the right size and inserts all the elements from the file into the array of inputs
		int[] arrayOfInputs = new int[sizeOfTheArrayOfInputs];
		for(int iteratorNumber = 0; iteratorNumber < sizeOfTheArrayOfInputs; iteratorNumber++){
			arrayOfInputs[iteratorNumber] = inputFile.nextInt();
		}
	
		// Sets the Scanner instance for reading the txt file of keys
		String keyAddressFile = "/Users/educastro/Documents/programming/java/workspace/CS303/DataStructuresAndAlgorithm/src/lab01/keys.txt";
		
		@SuppressWarnings("resource")
		Scanner inputKeyFile = new Scanner(new FileReader(keyAddressFile));
		
		// Calls the function to discover how many elements are in the file of keys
		getHowManyElementsOnTheKeysFile();
		
		// Creates an array with the right size and inserts all the elements from the file into the array of keys
		arrayOfKeys = new int[sizeOfTheArrayOfKeys];
		for(int iteratorNumber = 0; iteratorNumber < sizeOfTheArrayOfKeys; iteratorNumber++){
			arrayOfKeys[iteratorNumber] = inputKeyFile.nextInt();
		}
		
		// Calls the linearSearch function that searches for all the keys
		linearSearch.lookForTheNumber(arrayOfInputs, sizeOfTheArrayOfInputs, arrayOfKeys[0]);
		linearSearch.lookForTheNumber(arrayOfInputs, sizeOfTheArrayOfInputs, arrayOfKeys[1]);
		linearSearch.lookForTheNumber(arrayOfInputs, sizeOfTheArrayOfInputs, arrayOfKeys[2]);
		linearSearch.lookForTheNumber(arrayOfInputs, sizeOfTheArrayOfInputs, arrayOfKeys[3]);
		linearSearch.lookForTheNumber(arrayOfInputs, sizeOfTheArrayOfInputs, arrayOfKeys[4]);
		linearSearch.lookForTheNumber(arrayOfInputs, sizeOfTheArrayOfInputs, arrayOfKeys[5]);
		linearSearch.lookForTheNumber(arrayOfInputs, sizeOfTheArrayOfInputs, arrayOfKeys[6]);
		
	}
	
	private static void makeABinarySearch() throws FileNotFoundException{
		// BinarySearch instance
		BinarySearch binarySearch = new BinarySearch();
		
		// Sets the Scanner instance for reading the txt file of inputs
		String inputAdressFile = "/Users/educastro/Documents/programming/java/workspace/CS303/DataStructuresAndAlgorithm/src/lab01/input10000.txt";
		
		@SuppressWarnings("resource")
		Scanner inputFile = new Scanner(new FileReader(inputAdressFile));

		// Calls the function to discover how many elements are in the file of inputs
		getHowManyElementsOnTheInputsFile();
		
		// Creates an array with the right size and inserts all the elements from the file into the array of inputs
		int[] arrayOfInputs = new int[sizeOfTheArrayOfInputs];
		for(int iteratorNumber = 0; iteratorNumber < sizeOfTheArrayOfInputs; iteratorNumber++){
			arrayOfInputs[iteratorNumber] = inputFile.nextInt();
		}
	
		// Sets the Scanner instance for reading the txt file of keys
		String keyAddressFile = "/Users/educastro/Documents/programming/java/workspace/CS303/DataStructuresAndAlgorithm/src/lab01/keys.txt";
		
		@SuppressWarnings("resource")
		Scanner inputKeyFile = new Scanner(new FileReader(keyAddressFile));
		
		// Calls the function to discover how many elements are in the file of keys
		getHowManyElementsOnTheKeysFile();
		
		// Creates an array with the right size and inserts all the elements from the file into the array of keys
		arrayOfKeys = new int[sizeOfTheArrayOfKeys];
		for(int iteratorNumber = 0; iteratorNumber < sizeOfTheArrayOfKeys; iteratorNumber++){
			arrayOfKeys[iteratorNumber] = inputKeyFile.nextInt();
		}
		
		// Calls the binarySearch function that searches for all the keys
		binarySearch.lookForTheNumber(arrayOfInputs, sizeOfTheArrayOfInputs, arrayOfKeys[0]);
		binarySearch.lookForTheNumber(arrayOfInputs, sizeOfTheArrayOfInputs, arrayOfKeys[1]);
		binarySearch.lookForTheNumber(arrayOfInputs, sizeOfTheArrayOfInputs, arrayOfKeys[2]);
		binarySearch.lookForTheNumber(arrayOfInputs, sizeOfTheArrayOfInputs, arrayOfKeys[3]);
		binarySearch.lookForTheNumber(arrayOfInputs, sizeOfTheArrayOfInputs, arrayOfKeys[4]);
		binarySearch.lookForTheNumber(arrayOfInputs, sizeOfTheArrayOfInputs, arrayOfKeys[5]);
		binarySearch.lookForTheNumber(arrayOfInputs, sizeOfTheArrayOfInputs, arrayOfKeys[6]);
	}

	static int sizeOfTheArrayOfInputs = 0;
	static int sizeOfTheArrayOfKeys = 0;
	static int[] arrayOfInputs;
	static int[] arrayOfKeys;
	
	// Function that returns how many elements are into the input text file
	private static int getHowManyElementsOnTheInputsFile() throws FileNotFoundException{
		String inputAdressFile = "/Users/educastro/Documents/programming/java/workspace/CS303/DataStructuresAndAlgorithm/src/lab01/input100.txt";
		Scanner inputFile = new Scanner(new FileReader(inputAdressFile));
		while(inputFile.hasNextInt()){
			sizeOfTheArrayOfInputs++;
			inputFile.nextInt();
		}
		inputFile.close();
		return sizeOfTheArrayOfInputs;
	}
	
	// Function that returns how many elements are into the key text file
	private static int getHowManyElementsOnTheKeysFile() throws FileNotFoundException{
		String keyAddressFile = "/Users/educastro/Documents/programming/java/workspace/CS303/DataStructuresAndAlgorithm/src/lab01/keys.txt";
		Scanner inputKeyFile = new Scanner(new FileReader(keyAddressFile));
		while(inputKeyFile.hasNextInt()){
			sizeOfTheArrayOfKeys++;
			inputKeyFile.nextInt();
		}
		inputKeyFile.close();
		return sizeOfTheArrayOfKeys;
	}
}