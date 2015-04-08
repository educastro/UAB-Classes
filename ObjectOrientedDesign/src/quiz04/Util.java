package quiz04;

import java.util.List;

public class Util {
	/**
	 * removeLessThan method removes all the elements in a List that are less than the referenceObject passed 
	 * as parameter.
	 * @param list
	 * @param referenceObject
	 */
	public static <E extends Comparable<? super E>> void removeLessThan(List<E> list, E referenceObject) {
		/** Iterates through every element of the list. */
		for(E element : list) {
			/** If an element is less than the referenceObject than the compareTo method returns -1. 
			 * If it is equal it will return 0 and if it is greater it will return 1 */
			if (element.compareTo(referenceObject) < 0) {
				/** If the element is less than the referenceObject than we remove it from the list. */
				list.remove(element);
			}
		}
	}
}
