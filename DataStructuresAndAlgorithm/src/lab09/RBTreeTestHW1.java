package lab09;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class RBTreeTestHW1 {

	public static void main(String[] args) throws FileNotFoundException {
		String inputAddressFile = "/Users/educastro/Documents/programming/java/workspace/CS303/lab09Old/src/inputTest.txt";
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
		String inputAddressFile3 = "/Users/educastro/Documents/programming/java/workspace/CS303/lab09Old/src/input.txt";
		Scanner inputFile3 = new Scanner(new FileReader(inputAddressFile3));
		
		// Calls the function to discover how many elements are in the file of inputs
		int sizeOfTheArrayOfInputs3 = getHowManyElementsOnTheInputsFile(inputAddressFile3);

		// Creates an array with the right size and inserts all the elements from the file into the array of inputs
		int[] arrayOfSearchInputs = new int[sizeOfTheArrayOfInputs3];
			
		for(int iteratorNumber = 0; iteratorNumber < sizeOfTheArrayOfInputs3; iteratorNumber++){
			arrayOfSearchInputs[iteratorNumber] = inputFile3.nextInt();
		}
		

		RBTree<Integer> rbTree = new RBTree<Integer>();
		RBNode[] node = new RBNode[sizeOfTheArrayOfInputs];

		for(int iteratorNumber = 0; iteratorNumber < sizeOfTheArrayOfInputs; iteratorNumber++){
			node[iteratorNumber] = new RBNode(Integer.parseInt(arrayOfInputsPartOne[iteratorNumber]));
		}
		
		for(int iteratorNumber = 0; iteratorNumber < sizeOfTheArrayOfInputs; iteratorNumber++){
			rbTree.rbInsert(node[iteratorNumber]);
			
		}
		
		rbTree.inOrderTreeWalk(rbTree.getRoot());
		System.out.println(rbTree.treeSearch(rbTree.getRoot(), 161));
		for(int iteratorNumber = 0; iteratorNumber < sizeOfTheArrayOfInputs3; iteratorNumber++){
			System.out.println(arrayOfSearchInputs[iteratorNumber] + " is in tree: " + rbTree.treeSearch(rbTree.getRoot(), arrayOfSearchInputs[iteratorNumber]));
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
