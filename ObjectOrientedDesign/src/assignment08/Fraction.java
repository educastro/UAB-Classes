package assignment08;

/**
 * A class that represents a Fraction
 * @author educastro
 * @param <E>
 *
 */

public class Fraction<E extends Number> extends java.lang.Number {
	
	/**
	 * 
	 */
	/** the numerator */
	private E numerator;
	/** the denominator */
	private E denominator;
	
	/**
	 * Constructor for a Fraction
	 * @param numerator 
	 * @param denominator
	 * @precondition numerator != null && denominator != null && denominator != 0
	 */
	public Fraction(E numerator, E denominator) {
		assert numerator != null && denominator != null : "arguments cannot be null";
	    assert (int) denominator != 0 : "denominator must not be zero";
		
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	/**
	 * Returns the numerator number
	 * @return numerator
	 */
	public E getNumerator() {
		return numerator;
	}
	
	/**
	 * Returns the denominator number
	 * @return denominator
	 */
	public E getDenominator() {
		return denominator;
	}
	
	/**
	 * Returns a string that represents the fraction
	 * @return string with the fraction
	 */
	public String toString() {
		String returnString = getNumerator() + "/" + getDenominator(); 
		return returnString;
	}
	
	/**
	 * Returns the value for this fraction in float type. It transforms the numerator and denominator
	 * to float type before the operation
	 * @return numerator/denominator in float type
	 */
	public float floatValue() {
		/** converts the numerator to float type */
		float numerator = (float) getNumerator();
		/** converts the denominator to float type */
		float denominator = (float) getDenominator();
		
		return numerator/denominator;
	}
	
	/**
	 * Returns the value for this fraction in double type. It transforms the numerator and denominator
	 * to double type before the operation
	 * @return numerator/denominator in double type
	 */
	public double doubleValue() {
		/** converts the numerator to double type */
		double numerator = (double) getNumerator();
		/** converts the denominator to double type */
		double denominator = (double) getDenominator();
		
		return numerator/denominator;
	}
	
	/**
	 * Returns the value for this fraction in long type. It transforms the numerator and denominator
	 * to long type before the operation
	 * @return numerator/denominator in long type
	 */
	public long longValue() {
		/** converts the numerator to long type */
		long numerator = (long) getNumerator();
		/** converts the denominator to long type */
		long denominator = (long) getDenominator();
		
		return numerator/denominator;
	}
	
	/**
	 * Returns the value for this fraction in int type. It transforms the numerator and denominator
	 * to int type before the operation
	 * @return numerator/denominator in int type
	 */
	public int intValue() {
		/** converts the numerator to double type */
		int numerator = (int) getNumerator();
		/** converts the denominator to double type */
		int denominator = (int) getDenominator();
		
		return numerator/denominator;
	}
	
	/**
	 * Returns true if the object passed as parameters is equal to this one and false if it isn't
	 * @param o, any object
	 * @return true if both objects are equal and false if it isnt
	 */
	@SuppressWarnings("unchecked")
	public boolean equals(Object o) {
		Fraction<E> comparatorFraction;
		
		if(o.getClass() == this.getClass()) {
			comparatorFraction = (Fraction<E>) o;
			if(comparatorFraction.getDenominator() == this.getDenominator() && comparatorFraction.getNumerator() == this.getNumerator()){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * Returns a hash code of this object
	 * @return an int number that represents the hash code of this object
	 */
	public int hashCode() {
		return this.hashCode();
	}

}
