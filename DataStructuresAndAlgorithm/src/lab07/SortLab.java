package lab07;

public class SortLab {

	public void sort(int[] array){
		int sizeOfTheArray = array.length;
		int firstPosition = 0;
		int lastPosition = sizeOfTheArray - 1;

		while(sizeOfTheArray > 0){
			for(int i = firstPosition; i <= lastPosition; i++){
				if(array[firstPosition] > array[i])
					swap(array, firstPosition, i);
			}

			for(int j = lastPosition; j >= firstPosition; j--){
				if(array[lastPosition] < array[j])
					swap(array, lastPosition, j);
			}

			sizeOfTheArray = sizeOfTheArray - 2;
			firstPosition++;
			lastPosition--;
		}
	}

	public void swap(int[] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public void sortRecursively(int[] array, int first, int last, int size){
		if(size <= 0){
			return;
		}
		else{
			getSmallest(array, first, last);
			getBiggest(array, first, last);
			size = size - 2;
			first++;
			last--;
			sortRecursively(array, first, last, size);
		}
		
	}
	
	public void getBiggest(int[] array, int first, int last){
		for(int j = last; j >= first; j--){
			if(array[last] < array[j])
				swap(array, last, j);
		}
	}
	
	public void getSmallest(int[] array, int first, int last){
		for(int i = first; i <= last; i++){
			if(array[first] > array[i])
				swap(array, first, i);
		}
		
	}
	
}
