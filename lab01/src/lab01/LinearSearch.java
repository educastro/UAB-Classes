package lab01;

public class LinearSearch {

	public boolean lookForTheNumber(int[] arrayOfNumbers, int sizeOfArrayOfNumbers, int key){
		
		for(int iteratorNumber = 0; iteratorNumber < sizeOfArrayOfNumbers; iteratorNumber++) {
			if(arrayOfNumbers[iteratorNumber] == key){
				return true;
			}
		}
		
		return false;
	}
}