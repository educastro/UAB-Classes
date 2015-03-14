package lab07;

public class SortLabTest {



	public static void main(String[] args) {
		int[] array = {5, 2, 6, 9, 10};
		System.out.println("Original array: {5, 2, 6, 9, 10}");
		SortLab sortLab = new SortLab();
		sortLab.sortRecursively(array, 0, array.length-1, array.length);
		System.out.println("Sorted array: {" + array[0] + ", " + array[1] + ", " + array[2] + ", " + array[3] + ", " + array[4] + "}");
		
	}
}
