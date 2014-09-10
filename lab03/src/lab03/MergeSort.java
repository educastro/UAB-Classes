package lab03;

public class MergeSort {
		
	public void mergeSort(int[] A, int[] temp, int p, int r){
		if(p < r){
			int q = (p+r)/2;
			mergeSort(A, temp, p, q);
			mergeSort(A, temp, q + 1, r);
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
	
}