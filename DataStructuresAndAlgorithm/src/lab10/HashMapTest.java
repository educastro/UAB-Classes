package lab10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class HashMapTest {

	public static void main(String[] args) throws FileNotFoundException {

		HashMap hashTest = new HashMap();

		System.out.println("Inserting key 100");
		hashTest.put(100, "String key 100");
		System.out.println("Inserting key 1000");
		hashTest.put(1000, "String for key 1000");
		System.out.println("Inserting key 5");
		hashTest.put(5, "String key 5");

		System.out.println("------------------------------------------------------------");

		System.out.println("Result of getting key 100: " + hashTest.get(100));
		System.out.println("Result of getting key 1000: " + hashTest.get(1000));
		System.out.println("Result of getting key 5: " + hashTest.get(5));
		System.out.println("Result of getting key 10(that doesnt exist): " + hashTest.get(10));

		System.out.println("------------------------------------------------------------");

		HashMap hashTestForLinearProbing = new HashMap();

		System.out.println("Linear Probing for key 10000");
		hashTestForLinearProbing.linearProbe(10000, "String for key 10000");
		hashTestForLinearProbing.linearProbe(100, "String for key 100");
		hashTestForLinearProbing.linearProbe(10, "String for key 10");
		System.out.println("Result from position 0 from array: " + hashTestForLinearProbing.getValuePosition(0));
		System.out.println("Result from position 1 from array: " + hashTestForLinearProbing.getValuePosition(1));


		System.out.println("------------------------------------------------------------");

		HashMap hashTestForQuadraticProbing = new HashMap();

		System.out.println("Linear Probing for key 10000");
		hashTestForQuadraticProbing.linearProbe(10000, "String for key 10000");
		hashTestForQuadraticProbing.linearProbe(100, "String for key 100");
		hashTestForQuadraticProbing.linearProbe(10, "String for key 10");
		System.out.println("Result from position 0 from array: " + hashTestForQuadraticProbing.getValuePosition(0));
		System.out.println("Result from position 1 from array: " + hashTestForQuadraticProbing.getValuePosition(1));

		System.out.println("------------------------------------------------------------");

		System.out.println("Starting question 4");

		// Gets the input file address and stores into a Scanner instance. Each position is one file.
		String inputAddressFile = "/Users/educastro/Documents/programming/java/workspace/CS303/lab09/src/lab10/upc.txt";
		Scanner inputFile = new Scanner(new FileReader(inputAddressFile));

		// Calls the function to discover how many elements are in the file of inputs
		int sizeOfTheArrayOfInputs = getHowManyElementsOnTheInputsFile(inputAddressFile);

		// Creates an array with the right size and inserts all the elements from the file into the array of inputs
		String[] arrayOfInputsPartOne = new String[sizeOfTheArrayOfInputs];

		for(int iteratorNumber = 0; iteratorNumber < sizeOfTheArrayOfInputs; iteratorNumber++){
			arrayOfInputsPartOne[iteratorNumber] = inputFile.findInLine("\\w+(?=,)");
			inputFile.nextLine();
		}

		// Close the Scanner instance
		inputFile.reset();
		inputFile.close();

		// Gets the input file address and stores into a Scanner instance. Each position is one file.
		String inputAddressFile2 = "/Users/educastro/Documents/programming/java/workspace/CS303/lab09/src/lab10/upc.txt";
		Scanner inputFile2 = new Scanner(new FileReader(inputAddressFile2));

		// Calls the function to discover how many elements are in the file of inputs
		int sizeOfTheArrayOfInputs2 = getHowManyElementsOnTheInputsFile(inputAddressFile2);

		// Creates an array with the right size and inserts all the elements from the file into the array of inputs
		String[] arrayOfInputsPartTwo = new String[sizeOfTheArrayOfInputs2];

		for(int iteratorNumber = 0; iteratorNumber < sizeOfTheArrayOfInputs2; iteratorNumber++){
			arrayOfInputsPartTwo[iteratorNumber] = inputFile2.nextLine();
		}

		// Close the Scanner instance
		inputFile2.reset();
		inputFile2.close();

		// Gets the input file address and stores into a Scanner instance. Each position is one file.
		String inputAddressFile3 = "/Users/educastro/Documents/programming/java/workspace/CS303/lab09/src/lab10/input.txt";
		Scanner inputFile3 = new Scanner(new FileReader(inputAddressFile2));

		// Calls the function to discover how many elements are in the file of inputs
		int sizeOfTheArrayOfInputs3 = getHowManyElementsOnTheInputsFile(inputAddressFile3);

		// Creates an array with the right size and inserts all the elements from the file into the array of inputs
		String[] arrayOfSearchInputs = new String[sizeOfTheArrayOfInputs3];

		for(int iteratorNumber = 0; iteratorNumber < sizeOfTheArrayOfInputs3; iteratorNumber++){
			arrayOfSearchInputs[iteratorNumber] = inputFile3.nextLine();
		}

		HashMap newHashTest = new HashMap();

		// Stores the current time of the computer system
		long startTime = System.nanoTime();

		for(int iteratorNumber = 0; iteratorNumber < sizeOfTheArrayOfInputs3; iteratorNumber++){
			newHashTest.get(Integer.parseInt(arrayOfSearchInputs[iteratorNumber]));
		}

		for(int iteratorNumber = 0; iteratorNumber < sizeOfTheArrayOfInputs; iteratorNumber++){
			
		}

			// Stores the current time of the computer system
		long stopTime = System.nanoTime();

		// Calculates the elapsed time using the time stores at the beggining and at the end of this execution
		long elapsedTime = stopTime - startTime;

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
		while(inputFile.hasNextLine()){
			sizeOfTheArrayOfInputs++;
			inputFile.nextLine();
		}

		// Close the Scanner instance
		inputFile.close();

		// Return how many elements there are in the input file for the creation of the array
		return sizeOfTheArrayOfInputs;
	}
}
