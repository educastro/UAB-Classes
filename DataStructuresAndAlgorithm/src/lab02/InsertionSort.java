package lab02;

import java.io.FileNotFoundException;

public class InsertionSort {
	public void sortAnArray(int[] arrayOfInputs, int sizeOfTheArrayOfInputs) throws FileNotFoundException{
		int key = 0;
		int j = 1;
		int i = 0;

		for(j = 1; j < sizeOfTheArrayOfInputs ; j++){
			key = arrayOfInputs[j];
			for(i = j - 1; ((i >= 0) && (arrayOfInputs[i] > key)); i--) 
			{
				arrayOfInputs[i+1] = arrayOfInputs[i];
			}
			arrayOfInputs[i+1] = key;
		}
	}
}