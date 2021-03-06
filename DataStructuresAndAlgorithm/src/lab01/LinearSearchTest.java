package lab01;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.junit.Test;

public class LinearSearchTest {
	
	int sizeOfTheArrayOfInputs = 0;
	int sizeOfTheArrayOfKeys = 0;
	int[] arrayOfInputs;
	int[] arrayOfKeys;
	
	private Scanner getInputFile() throws FileNotFoundException{
		String inputAdressFile = "/Users/educastro/Documents/programming/java/workspace/CS303/DataStructuresAndAlgorithm/src/lab01/input100.txt";
		Scanner inputFile = new Scanner(new FileReader(inputAdressFile));
		return inputFile;
	}
	
	private Scanner getKeyFile() throws FileNotFoundException{
		String keyAddressFile = "/Users/educastro/Documents/programming/java/workspace/CS303/DataStructuresAndAlgorithm/src/lab01/keys.txt";
		Scanner inputKeyFile = new Scanner(new FileReader(keyAddressFile));
		return inputKeyFile;
	}
	
	private int getHowManyElementsOnTheInputsFile() throws FileNotFoundException{
		String inputAdressFile = "/Users/educastro/Documents/programming/java/workspace/CS303/DataStructuresAndAlgorithm/src/lab01/input100.txt";
		Scanner inputFile = new Scanner(new FileReader(inputAdressFile));
		while(inputFile.hasNextInt()){
			sizeOfTheArrayOfInputs++;
			inputFile.nextInt();
		}
		inputFile.close();
		return sizeOfTheArrayOfInputs;
	}
	
	private void populateTheArrayWithAllTheInputsOfTheFile() throws FileNotFoundException{
		String inputAdressFile = "/Users/educastro/Documents/programming/java/workspace/CS303/DataStructuresAndAlgorithm/src/lab01/input100.txt";
		
		@SuppressWarnings("resource")
		Scanner inputFile = new Scanner(new FileReader(inputAdressFile));
		
		getHowManyElementsOnTheInputsFile();
		arrayOfInputs = new int[sizeOfTheArrayOfInputs];
		for(int iteratorNumber = 0; iteratorNumber < sizeOfTheArrayOfInputs; iteratorNumber++){
			arrayOfInputs[iteratorNumber] = inputFile.nextInt();
		}
	}
	
	private int getHowManyElementsOnTheKeysFile() throws FileNotFoundException{
		String keyAddressFile = "/Users/educastro/Documents/programming/java/workspace/CS303/DataStructuresAndAlgorithm/src/lab01/keys.txt";
		Scanner inputKeyFile = new Scanner(new FileReader(keyAddressFile));
		while(inputKeyFile.hasNextInt()){
			sizeOfTheArrayOfKeys++;
			inputKeyFile.nextInt();
		}
		inputKeyFile.close();
		return sizeOfTheArrayOfKeys;
	}
	
	private void populateTheArrayWithAllTheKeysOfTheFile() throws FileNotFoundException{
		String keyAddressFile = "/Users/educastro/Documents/programming/java/workspace/CS303/DataStructuresAndAlgorithm/src/lab01/keys.txt";
		
		@SuppressWarnings("resource")
		Scanner inputKeyFile = new Scanner(new FileReader(keyAddressFile));
		
		getHowManyElementsOnTheKeysFile();
		arrayOfKeys = new int[sizeOfTheArrayOfKeys];
		for(int iteratorNumber = 0; iteratorNumber < sizeOfTheArrayOfKeys; iteratorNumber++){
			arrayOfKeys[iteratorNumber] = inputKeyFile.nextInt();
		}
	}
	
	@Test
	public void testFirstElementOfTheInputFile() throws FileNotFoundException {
		assertEquals(1, getInputFile().nextInt());
	}
	
	@Test
	public void testFirstElementOfTheKeysFile() throws FileNotFoundException{
		assertEquals(15, getKeyFile().nextInt());
	}
	
	@Test
	public void testSizeOfTheArrayOfInputs() throws FileNotFoundException{
		populateTheArrayWithAllTheInputsOfTheFile();
		assertEquals(100, sizeOfTheArrayOfInputs);
	}
	
	@Test
	public void testArrayWithAllTheInputsOfTheFile() throws FileNotFoundException{
		populateTheArrayWithAllTheInputsOfTheFile();
		assertEquals(1, arrayOfInputs[0]);
		assertEquals(987, arrayOfInputs[99]);
		assertEquals(196, arrayOfInputs[24]);
	}
	
	@Test
	public void testSizeOfTheArrayOfKeys() throws FileNotFoundException{
		populateTheArrayWithAllTheKeysOfTheFile();
		assertEquals(7, sizeOfTheArrayOfKeys);
	}
	
	@Test
	public void testArrayWithAllTheKeysOfTheFile() throws FileNotFoundException{
		populateTheArrayWithAllTheKeysOfTheFile();
		assertEquals(15, arrayOfKeys[0]);
		assertEquals(566, arrayOfKeys[6]);
		assertEquals(987, arrayOfKeys[3]);
	}
	
//	@Test
//	public void testLinearSearch() throws FileNotFoundException{
//		LinearSearch linearSearch = new LinearSearch();
//		populateTheArrayWithAllTheInputsOfTheFile();
//		populateTheArrayWithAllTheKeysOfTheFile();
//		assertEquals("15 is not in the list", linearSearch.lookForTheNumber(arrayOfInputs, sizeOfTheArrayOfInputs, arrayOfKeys[0]));
//		assertEquals(linearSearch.lookForTheNumber(arrayOfInputs, sizeOfTheArrayOfInputs, arrayOfKeys[1]), "55 is not in the list");
//		assertEquals(linearSearch.lookForTheNumber(arrayOfInputs, sizeOfTheArrayOfInputs, arrayOfKeys[2]), "900 is not in the list");
//		assertEquals(linearSearch.lookForTheNumber(arrayOfInputs, sizeOfTheArrayOfInputs, arrayOfKeys[3]), "987 is in the list");
//		assertEquals(linearSearch.lookForTheNumber(arrayOfInputs, sizeOfTheArrayOfInputs, arrayOfKeys[4]), "1 is in the list");
//		assertEquals(linearSearch.lookForTheNumber(arrayOfInputs, sizeOfTheArrayOfInputs, arrayOfKeys[5]), "25 is not in the list");
//		assertEquals(linearSearch.lookForTheNumber(arrayOfInputs, sizeOfTheArrayOfInputs, arrayOfKeys[6]), "566 is in the list");
//	}
}