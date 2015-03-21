package lab11;

/**
 * Class representing paired object.
 * 
 * @author spoudel
 * 
 * @param <E>
 *            Type of object to pair.
 */
public class Pair<E> {
	/**
	 * First element of the pair
	 */
	E firstElement;

	/**
	 * second element of the pair
	 */
	E secondElement;

	/**
	 * Constructor for creating a pair with two elements.
	 * 
	 * @param firstElement
	 *            the first element
	 * @param secondElement
	 *            the second element
	 */
	public Pair(E firstElement, E secondElement) {
		this.firstElement = firstElement;
		this.secondElement = secondElement;
	}

	/**
	 * Set the first value of a Pair.
     * @param value the value to be set
	 */
	public void setFirst(E element) {
		this.firstElement = element;
	}
	
	/**
	 * Get the first element.
	 * 
	 * @return first element
	 */
	public E getFirst() {
		return firstElement;
	}
	
	/**
	 * Set the second value of a Pair.
     * @param value the value to be set
	 */
	public void setSecond(E element) {
		this.secondElement = element;
	}

	/**
	 * Get the second element.
	 * 
	 * @return second element
	 */
	public E getSecond() {
		return secondElement;
	}

	/**
	 * Checking if this pair equals the other pair.
	 * 
	 * @param other
	 *            the pair object to be compared with
	 * 
	 * @return true if both pair have same set of elements in same order i.e
	 *         first element of both pair are equal and the second element of
	 *         both pair are equal
	 */
	public boolean equals(Object other) {
		if (other instanceof Pair)
			return (getFirst().equals(((Pair) other).getFirst()) && getSecond().equals(((Pair) other).getSecond()));
		else
			return false;	
			
	}

	/**
	 * Return the hash code of the object.
	 * 
	 * @return hash code for the object
	 * @postcondition if pair1 equals pair2 hashCode(pair1) must equal
	 *                hashCode(pair2)
	 */
	public int hashCode() {
		/**
		 * XOR is good for combining two hashcodes because XOR has two outputs
		 * as 0 and two outputs as 1 for different combination of 0 & 1 thus
		 * making distribution uniform. 0 0 -> 0 0 1 -> 1 1 0 -> 1 1 1 -> 0
		 */
		
		// the hash value of the first and second element . XOR those value. Then return the output 
		// XOR operator: ^
		return firstElement.hashCode() ^ secondElement.hashCode();
	}
	
	/**
	 * Return the string as (first element, second element)
	 */
	public String toString() {
		String returnString = "First Element: " + firstElement.toString() + "\nSecond Element: " + secondElement.toString() + "\n";
		return returnString; // null is to avoid temporary. replace null with your actual value		
	}
}
