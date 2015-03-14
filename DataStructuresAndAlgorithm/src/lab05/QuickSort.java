package lab05;

public class QuickSort {
	
	public void quickSort(int[] arrayOfElements, int firstElement, int lastElement){
		if(firstElement < lastElement){
			int middleElement = partition(arrayOfElements, firstElement, lastElement);
			quickSort(arrayOfElements, firstElement, middleElement-1);
			quickSort(arrayOfElements, middleElement+1, lastElement);
		}
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

}
