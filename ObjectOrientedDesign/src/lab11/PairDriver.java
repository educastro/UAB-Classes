package lab11;

import java.util.ArrayList;

public class PairDriver {

	public static void main(String[] args) {
		Pair<Integer> coordinate = new Pair<Integer>(10, 5);
		//Display the coordinate
		System.out.println(coordinate.toString());
		
		//Add items to the arraylist
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			arrayList.add(i);
		}
		
		//Form a pair from the first and the last element
		Pair<Integer> pair = PairUtility.getPair(arrayList);
		System.out.println(pair);
		//check equals function
		assert pair.equals(new Pair<Integer>(0, 9));
			
		//check hashcode function
		assert pair.hashCode() == (new Pair<Integer>(0, 9)).hashCode();
	}
}
