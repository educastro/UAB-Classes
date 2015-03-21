package lab11;

import java.util.List;

/**
 * Utility class for deriving pairs.
 * 
 * @author spoudel
 * 
 */
public class PairUtility {
	/**
	 * Return a pair with first part as the first element in the list and the
	 * second part as the last element in the list.
	 * 
	 * @param list
	 *            non-empty list of elements
	 * @return pair with elements (first element of list,last element of list)
	 */
	public static <E> Pair<E> getPair(List<E> list) {

		// take the 1st element from list 
		E firstElement = list.get(0);
		// take the last element from the list
		E secondElement = list.get(list.size()-1);
		// generate instance of Pair<E> object
		Pair <E> pair = new Pair <E> (firstElement, secondElement);
		return pair;  // you need to replace null with the instance of Pair<E> class
	}

}
