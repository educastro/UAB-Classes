package lab04;

public class HeapSort {
	
	private static int heapSize;
	
	public void heapSort(int[] A){
		buildMaxHeap(A);
		for(int i = heapSize; i >= 1 ; i--){
			swap(A, 0, i);
			heapSize = heapSize - 1;
			maxHeapify(A, 0);
		}
	}
	
	public void buildMaxHeap(int[] A){
		heapSize = A.length - 1;
		for(int i = (heapSize/2); i > 0; i--){
			maxHeapify(A, i);
		}
	}
	
	public void maxHeapify(int[] A, int i){
		int left = left(i);
		int right = right(i);
		int largest = i;
		if((left <= heapSize) && (A[left] > A[i])){
			largest = left;
		}
		if((right <= heapSize) && (A[right] > A[largest])){
			largest = right;
		}
		if(largest != i){
			swap(A, i, largest);
			maxHeapify(A, largest);
		}
	}
	
	public void swap(int[] A, int firstElement, int secondElement){
		int tempNumber = A[firstElement];
		A[firstElement] = A[secondElement];
		A[secondElement] = tempNumber;
	}
	
	public int left(int i){
		return 2*i + 1;
	}
	
	public int right(int i){
		return 2*i + 2;
	}

}
