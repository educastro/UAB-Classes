package assignment01;

/**
 * EnhancedRangeDouble (ERD) is a class featuring double precision floating point ∗ arithmetic with an enhanced exponent range.
 */

public class EnhancedRangeDouble {

	public double mantissa = 0;
	public int exponent = 1;

	/**
	 * Constructs a new ERD object from a double.
	 * @param initialVal the inital value
	 * @throws Exception 
	 */

	EnhancedRangeDouble(double initialVal) throws Exception { 
		this.mantissa = initialVal;
		
		/**
		 * In case of overflow or underflow it returns an exception
		 */
		
		if(((this.mantissa) * (Math.pow(10, this.exponent))) > (Math.pow(2, 31) - 1))
			throw new Exception("out of range");
	}

	/**
	 * Constructs a new ERD object from a normalized double and an exponent 
	 * @param mantissa mantissa of the new double
	 * @param exponent exponent of the new double
	 * @throws Exception 
	 */

	EnhancedRangeDouble(double mantissa, int exponent) throws Exception { 
		this.mantissa = mantissa;
		this.exponent = exponent;
		
		/**
		 * In case of overflow or underflow it returns an exception
		 */
		
		if(((this.mantissa) * (Math.pow(10, this.exponent))) > (Math.pow(2, 31) - 1))
			throw new Exception("out of range");
		
		if(((this.mantissa) * (Math.pow(10, this.exponent))) < (Math.pow(-2, 31)))
			throw new Exception("out of range");
	}

	/**
	 * Computes this+other and returns the result in a new object. 
	 ∗ @param other addend
	 */

	EnhancedRangeDouble add(EnhancedRangeDouble other) throws Exception { 
		/**
		 * If the exponents are the same just return an instance with the sum of the mantissas and one of the exponents
		 */
		
		if(this.exponent == other.exponent)
			return new EnhancedRangeDouble(this.mantissa + other.mantissa, exponent);
		
		/**
		 * If it is not so we need adjust the numbers in order of both have the same exponential so we can make a simple
		 * adding with the mantissas and return an instance with the sum of the mantissas(after adjustment) and the bigger 
		 * exponent. 
		 */
		
		else{
			if(this.exponent < other.exponent){
				int differenceBetweenExponent = other.exponent - exponent;
				for(int x = 0; x < differenceBetweenExponent; x++){
					this.mantissa = this.mantissa/10;
				}
				
				/**
				 * In case of overflow or underflow it returns an exception
				 */
				
				if(((this.mantissa + other.mantissa) * (Math.pow(10, other.exponent)) > (Math.pow(2, 31) - 1)))
					throw new Exception("out of range");
				if(((this.mantissa + other.mantissa) * (Math.pow(10, other.exponent)) < (Math.pow(-2, 31))))
					throw new Exception("out of range");
				
				return new EnhancedRangeDouble(this.mantissa + other.mantissa, other.exponent);
			}
			else{
				int differenceBetweenExponent = exponent - other.exponent;
				for(int x = 0; x < differenceBetweenExponent; x++){
					other.mantissa = other.mantissa/10;
				}
				
				/**
				 * In case of overflow or underflow it returns an exception
				 */
				
				if(((this.mantissa + other.mantissa) * (Math.pow(10, this.exponent)) > (Math.pow(2, 31) - 1)))
					throw new Exception("out of range");
				if(((this.mantissa + other.mantissa) * (Math.pow(10, this.exponent)) < (Math.pow(-2, 31))))
					throw new Exception("out of range");
				
				return new EnhancedRangeDouble(this.mantissa + other.mantissa, this.exponent);
			}	
		}
	}

	/**
	 * Computes this−other and returns the result in a new object. 
	 * @param other subtrahend
	 */

	EnhancedRangeDouble sub(EnhancedRangeDouble other) throws Exception { 
		/**
		 * If the exponents are the same just return an instance with the subtraction of the mantissas and one of the exponents
		 */
		if(this.exponent == other.exponent)
			return new EnhancedRangeDouble(this.mantissa - other.mantissa, this.exponent);
		
		/**
		 * If it is not so we need adjust the numbers in order of both have the same exponential so we can make a simple
		 * subtraction with the mantissas and return an instance with the sum of the mantissas(after adjustment) and the bigger 
		 * exponent. 
		 */
		
		else{
			if(this.exponent < other.exponent){
				int differenceBetweenExponent = other.exponent - exponent;
				for(int x = 0; x < differenceBetweenExponent; x++){
					this.mantissa = this.mantissa/10;
					this.exponent++;
				}
				
				/**
				 * In case of overflow or underflow it returns an exception
				 */
				
				if(((this.mantissa - other.mantissa) * (Math.pow(10, other.exponent)) > (Math.pow(2, 31) - 1)))
					throw new Exception("out of range");
				if(((this.mantissa - other.mantissa) * (Math.pow(10, other.exponent)) < (Math.pow(-2, 31))))
					throw new Exception("out of range");
				
				return new EnhancedRangeDouble(this.mantissa - other.mantissa, other.exponent);
			}
			else{
				int differenceBetweenExponent = exponent - other.exponent;
				for(int x = 0; x < differenceBetweenExponent; x++){
					other.mantissa = other.mantissa/10;
					other.exponent++;
				}
				
				/**
				 * In case of overflow or underflow it returns an exception
				 */
				
				if(((this.mantissa - other.mantissa) * (Math.pow(10, this.exponent)) > (Math.pow(2, 31) - 1)))
					throw new Exception("out of range");
				if(((this.mantissa - other.mantissa) * (Math.pow(10, this.exponent)) < (Math.pow(-2, 31))))
					throw new Exception("out of range");
				
				return new EnhancedRangeDouble(this.mantissa - other.mantissa, this.exponent);
			}	
		}
	}

	/**
	 * Computes this∗other and returns the result in a new object. 
	 * @param other multiplier
	 */

	EnhancedRangeDouble mul(EnhancedRangeDouble other) throws Exception {
		/**
		 * In case of overflow or underflow it returns an exception
		 */
		
		if(((this.mantissa * other.mantissa) * (Math.pow(10, this.exponent + other.exponent)) > (Math.pow(2, 31) - 1)))
			throw new Exception("out of range");
		if(((this.mantissa * other.mantissa) * (Math.pow(10, this.exponent + other.exponent)) < (Math.pow(-2, 31))))
			throw new Exception("out of range");
		
		return new EnhancedRangeDouble(this.mantissa * other.mantissa, this.exponent + other.exponent);
	}

	/**
	 *  Computes this/other and returns the result in a new object.
	 *  @param other divisor
	 */

	EnhancedRangeDouble div(EnhancedRangeDouble other) throws Exception { 
		/**
		 * In case of overflow or underflow it returns an exception
		 */
		
		if(((this.mantissa / other.mantissa) * (Math.pow(10, this.exponent - other.exponent)) > (Math.pow(2, 31) - 1)))
			throw new Exception("out of range");
		if(((this.mantissa / other.mantissa) * (Math.pow(10, this.exponent - other.exponent)) < (Math.pow(-2, 31))))
			throw new Exception("out of range");
		
		return new EnhancedRangeDouble(this.mantissa / other.mantissa, this.exponent - other.exponent);
	}

	/**
	 * Returns the normalized representation of this ERD as String.
	 * The normalized representation starts with the negative sign (if any),
	 * followed by the mantissa (single non−zero digit to the left of the period) ∗ and the exponent.
	 * e.g., 1.89e−1999, −4.3e8888, 0.0e0
	 * but not: 0.7e10, −182.2e9999
	 */

	public String toString() { 
		return String.valueOf((this.mantissa * (Math.pow(10, this.exponent))));
	}

	/**
	 *  Compares this with other
	 *  @param other the other EHR
	 *  @return −1, iff this < other
	 *		1, iff this > other
	 * 		0, otherwise 
	 */

	int compareTo(EnhancedRangeDouble other) { 
		if((this.mantissa * (Math.pow(10, this.exponent))) < (other.mantissa * (Math.pow(10, this.exponent))))
			return -1;
		else if((this.mantissa * (Math.pow(10, this.exponent))) > (other.mantissa * (Math.pow(10, this.exponent))))
			return 1;
		else
			return 0;
	} 
}