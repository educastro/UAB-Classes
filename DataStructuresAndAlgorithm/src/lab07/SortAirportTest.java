package lab07;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SortAirportTest {

	public static void main(String[] args) throws FileNotFoundException  {
		Scanner inputFile = new Scanner(new FileReader("/Users/educastro/Documents/programming/java/workspace/CS303/lab07/src/lab07/log.txt"));

		// Calls the function to discover how many elements are in the file of inputs
		int sizeOfTheArrayOfInputs = getHowManyElementsOnTheInputsFile("/Users/educastro/Documents/programming/java/workspace/CS303/lab07/src/lab07/log.txt");

		// Creates an array with the right size and inserts all the elements from the file into the array of inputs
		String[] arrayOfInputs = new String[sizeOfTheArrayOfInputs];
		for(int iteratorNumber = 0; iteratorNumber < sizeOfTheArrayOfInputs; iteratorNumber++){
			arrayOfInputs[iteratorNumber] = inputFile.nextLine();
		}
		
		SortAirport sortAirport = new SortAirport();
		sortAirport.sortAirportList(arrayOfInputs);

		for(int i = 0; i < sizeOfTheArrayOfInputs; i++){
			System.out.println(arrayOfInputs[i]);
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
