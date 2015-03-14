package lab05;

import java.io.FileNotFoundException;

public class QuickSortMedianOfThree {
	
	public void quickSort(int[] arrayOfElements, int firstElement, int lastElement){
//		if(firstElement < lastElement){
//			int middleElement = partition(arrayOfElements, firstElement, lastElement);
//			quickSort(arrayOfElements, firstElement, middleElement-1);
//			quickSort(arrayOfElements, middleElement+1, lastElement);
//		}
		int CUTOFF = 8;
		int n = lastElement - firstElement + 1;
		if(n <= CUTOFF){
			insertionSort(arrayOfElements, firstElement, lastElement);
			return;
		}
		else{
		
		int m = median3(arrayOfElements, firstElement, firstElement + n/2, lastElement);
		swapElements(arrayOfElements, firstElement, lastElement);
		
		int j = partition(arrayOfElements, firstElement, lastElement);
		quickSort(arrayOfElements, firstElement, j-1);
		quickSort(arrayOfElements, j+1, lastElement);
		}
	}
	
	public int median3(int[] arrayOfElements, int firstElement, int i,
			int lastElement) {
		return (arrayOfElements[firstElement] < arrayOfElements[i] ?
	               (arrayOfElements[i] < arrayOfElements[lastElement] ? i : arrayOfElements[firstElement] < arrayOfElements[lastElement] ? lastElement : firstElement) :
	               (arrayOfElements[lastElement] < arrayOfElements[i] ? i : arrayOfElements[lastElement] < arrayOfElements[i] ? lastElement : firstElement));
	}

	public int partition(int[] arrayOfElements, int firstElement, int lastElement){
		int i = firstElement;
        int j = lastElement + 1;
        int x = arrayOfElements[firstElement];
        while (true) { 
            // find item on lo to swap
            while (arrayOfElements[++i] < x){
                if (i == lastElement) break;
            }
            // find item on hi to swap
            while (x < arrayOfElements[--j]){
                if (j == firstElement) break;     
            }
            // check if pointers cross
            if (i >= j) break;

            swapElements(arrayOfElements, i, j);
        }

        // put partitioning item v at a[j]
        swapElements(arrayOfElements, firstElement, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
	}
	
	public void swapElements(int[] A, int firstElement, int secondElement){
		int tempNumber = A[firstElement];
		A[firstElement] = A[secondElement];
		A[secondElement] = tempNumber;
	}
	
	public void insertionSort(int[] arrayOfElements, int firstElement, int lastElement){
		for(int i = firstElement; i <= lastElement; i++){
			for(int j = i; ((j > firstElement) && (arrayOfElements[j] < arrayOfElements[j-1])); j--){
				swapElements(arrayOfElements, j, j-1);
			}
		}
	}
	


	

}
