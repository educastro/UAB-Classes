package lab09;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RBTreeTestHW {

	public static void main(String[] args) throws FileNotFoundException {
		// Gets the input file address and stores into a Scanner instance. Each position is one file.
		String inputAddressFile = "/Users/educastro/Documents/programming/java/workspace/CS303/lab09Old/src/upc.txt";
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
		String inputAddressFile2 = "/Users/educastro/Documents/programming/java/workspace/CS303/lab09Old/src/upc.txt";
		Scanner inputFile2 = new Scanner(new FileReader(inputAddressFile2));
		
		// Calls the function to discover how many elements are in the file of inputs
		int sizeOfTheArrayOfInputs2 = getHowManyElementsOnTheInputsFile(inputAddressFile2);

		// Creates an array with the right size and inserts all the elements from the file into the array of inputs
		String[] arrayOfInputsPartTwo = new String[sizeOfTheArrayOfInputs2];
			
		for(int iteratorNumber = 0; iteratorNumber < sizeOfTheArrayOfInputs2; iteratorNumber++){
			arrayOfInputsPartTwo[iteratorNumber] = inputFile2.nextLine();
			//inputFile2.nextLine();
		}
				
		// Close the Scanner instance
		inputFile2.reset();
		inputFile2.close();
		
		// Gets the input file address and stores into a Scanner instance. Each position is one file.
		String inputAddressFile3 = "/Users/educastro/Documents/programming/java/workspace/CS303/lab09Old/src/input.txt";
		Scanner inputFile3 = new Scanner(new FileReader(inputAddressFile2));
		
		// Calls the function to discover how many elements are in the file of inputs
		int sizeOfTheArrayOfInputs3 = getHowManyElementsOnTheInputsFile(inputAddressFile3);

		// Creates an array with the right size and inserts all the elements from the file into the array of inputs
		String[] arrayOfSearchInputs = new String[sizeOfTheArrayOfInputs3];
			
		for(int iteratorNumber = 0; iteratorNumber < sizeOfTheArrayOfInputs3; iteratorNumber++){
			arrayOfSearchInputs[iteratorNumber] = inputFile3.nextLine();
		}
		
		RBTree<Integer> rbTree = new RBTree<Integer>();
		RBNode[] node = new RBNode[sizeOfTheArrayOfInputs];
				
		for(int iteratorNumber = 0; iteratorNumber < sizeOfTheArrayOfInputs; iteratorNumber++){
			node[iteratorNumber] = new RBNode(Integer.parseInt(arrayOfInputsPartOne[iteratorNumber]));
			rbTree.rbInsert(node[iteratorNumber]);
		}
		
		System.out.println("Printing the tree");
		System.out.println(rbTree.toString());
		
		// Stores the current time of the computer system
		long startTime = System.nanoTime();
		
		// Search that doesn't work
		for(int iteratorNumber = 0; iteratorNumber < sizeOfTheArrayOfInputs3; iteratorNumber++){
			System.out.println(rbTree.treeSearch(rbTree.getRoot(), Integer.parseInt(arrayOfSearchInputs[iteratorNumber])));				
		}
		
		long stopTime = System.nanoTime();

		// Calculates the elapsed time using the time stores at the beggining and at the end of this execution
		long elapsedTime = stopTime - startTime;
		
		System.out.println(elapsedTime);
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
