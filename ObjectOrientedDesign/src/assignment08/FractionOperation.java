package assignment08;

import java.math.BigInteger;

/**
 * Class that defines arithmetic operations for the Fraction class
 * @author educastro
 *
 * @param <E>
 */
public class FractionOperation<E extends Number> implements Arithmetic {

	/** Variable that stores the operation */
	private IntegerArithmetic<E> operation;


	/**
	 * Constructor for this class. 
	 * @param operations
	 */
	public FractionOperation(IntegerArithmetic integerArithmetic) {
		this.operation = integerArithmetic;
	}

	/**
	 * Computes the greatest common divisor for a and b.
	 * @param a an Number
	 * @param b an Number
	 * @return greatest common divisor of a and b
	 */
	private Number gcd(Number a, Number b)
	{
		if (0 == b.doubleValue()) return a;

		return gcd(b, a.doubleValue() % b.doubleValue());
	}

	@SuppressWarnings("unchecked")
	private Fraction<E> simplify(Number num, Number denom) {
		Number gcd        = gcd(num, denom);
		Number nomSimpl   = num.doubleValue() / gcd.doubleValue();
		Number denomSimpl = denom.doubleValue() / gcd.doubleValue();

		return new Fraction(nomSimpl, denomSimpl);
	}

	/**
	 * Adds to fractions
	 * @param lhs is expected to be a fraction
	 * @param rhs is expected to be a fraction
	 * @return a new fraction simplified
	 */
	@SuppressWarnings("unchecked")
	public Number add(Number lhs, Number rhs) {
		if(lhs instanceof Fraction) {
			if(rhs instanceof Fraction) {
				return simplify(operation.add(operation.mul(((Fraction<E>) lhs).getNumerator(), 
						((Fraction<E>) rhs).getDenominator()), operation.mul(((Fraction<E>) rhs).getNumerator(), 
								((Fraction<E>) lhs).getDenominator())), operation.mul(((Fraction<E>) lhs).getDenominator(), 
										((Fraction<E>) rhs).getDenominator()));
			}
		}
		return 0;
	}

	/**
	 * Subtracts one fraction from other
	 */
	@SuppressWarnings("unchecked")
	public Number sub(Number lhs, Number rhs) {
		if(lhs instanceof Fraction) {
			if(rhs instanceof Fraction) {
				return simplify(operation.sub(operation.mul(((Fraction<E>) lhs).getNumerator(), 
						((Fraction<E>) rhs).getDenominator()), operation.mul(((Fraction<E>) rhs).getNumerator(), 
								((Fraction<E>) lhs).getDenominator())), operation.mul(((Fraction<E>) lhs).getDenominator(), 
										((Fraction<E>) rhs).getDenominator()));
			}
		}
		return 0;
	}

	/**
	 * Multiplies one fraction to other
	 */
	@SuppressWarnings("unchecked")
	public Number mul(Number lhs, Number rhs) {
		if(lhs instanceof Fraction) {
			if(rhs instanceof Fraction) {
				return simplify(operation.mul(((Fraction<E>) lhs).getNumerator(), 
						((Fraction<E>) rhs).getNumerator()), operation.mul(((Fraction<E>) lhs).getDenominator(), 
								((Fraction<E>) rhs).getDenominator()));
			}
		}
		return 0;
	}

	/**
	 * Divides one fraction to other
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Number div(Number lhs, Number rhs) {
		if(lhs instanceof Fraction) {
			if(rhs instanceof Fraction) {
				return simplify(operation.mul(((Fraction<E>) lhs).getNumerator(), 
						((Fraction<E>) rhs).getDenominator()), operation.mul(((Fraction<E>) lhs).getDenominator(), 
								((Fraction<E>) rhs).getNumerator()));
			}
		}	
		return 0;
	}

	/**
	 * Negates an Fraction
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Number negate(Number operand) {
		if(operand instanceof Fraction) {
			return new Fraction(-((Fraction<E>) operand).getNumerator().doubleValue(), ((Fraction<E>) operand).getDenominator().doubleValue());
			}
		return 0;
	}

	/**
	 * Returns fraction that values 1
	 */
	@Override
	public Number one() {
		return new Fraction(1, 1);
	}

	/**
	 * Returns an fraction that values 0
	 */
	@Override
	public Number zero() {
		return new Fraction(0, 1);
	}

}