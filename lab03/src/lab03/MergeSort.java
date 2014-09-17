package lab03;

import java.io.FileNotFoundException;

public class MergeSort {
		
	public void mergeSort(int[] A, int[] temp, int p, int r, int sizeOfTheArrayOfInputs) throws FileNotFoundException{
		if(sizeOfTheArrayOfInputs < 512){
			insertionSort(A, sizeOfTheArrayOfInputs);
			return;
		}
		if(p < r){
			int q = (p+r)/2;
			mergeSort(A, temp, p, q, sizeOfTheArrayOfInputs);
			mergeSort(A, temp, q + 1, r, sizeOfTheArrayOfInputs);
			merge(A, temp, p, q, r);
		}
	}
	
	public void merge(int[] A, int[] temp, int p, int q, int r){
		// merge A[p..q] with A[q+1..r]
		int i = p;
		int j = q + 1;
		
		// copy A[p..r] to temp[p..r]
		for(int k = p; k < r; k++){
			temp[k] = A[k];
		}
		
		// merge back to A[p..r]
		for(int k = p; k < r; k++){
			if(i > q){
				A[k] = temp[j];
				j = j + 1;
			}
			
			else if(j > r){
				A[k] = temp[i]; 
				i = i + 1;
			}
			
			else if(temp[j] < temp[i]){
				A[k] = temp[j]; 
				j = j + 1;  
			}
			
			else{
				A[k] = temp[i];
				i = i + 1;
			}
		}
		
	}
	
	public void insertionSort(int[] A, int sizeOfTheArrayOfInputs) throws FileNotFoundException{
		
		int key = 0;
		int j = 1;
		int i = 0;

		for(j = 1; j < sizeOfTheArrayOfInputs ; j++){
			key = A[j];
			 for(i = j - 1; ((i >= 0) && (A[i] > key)); i--) 
	          {
				 A[i+1] = A[i];
	          }
			 A[i+1] = key;
		}
		
		
	}

	
}