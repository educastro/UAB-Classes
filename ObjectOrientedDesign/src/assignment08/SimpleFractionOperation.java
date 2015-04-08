package assignment08;

/**
 * A simple Fraction class based on Integers
 *
 * Note, the class does not guard against arithmetic overflow!
 */
public class SimpleFractionOperation implements Arithmetic<SimpleFraction>
{
  /** Constructor. */
  SimpleFractionOperation() { }

  /**
   * Computes the greatest common divisor for a and b.
   * @param a an integer
   * @param b an integer
   * @return greatest common divisor of a and b
   */
  private Integer gcd(Integer a, Integer b)
  {
    if (0 == b) return a;

    return gcd(b, a % b);
  }

  /**
   * Simplifies the fraction num/denom by dividing both by their greates common divisor.
   * @param num numerator
   * @param denom denominator
   * @return new fraction (num / gcd(num,denom)) / (denom / gcd(num,denom))
   */
  private SimpleFraction simplify(Integer num, Integer denom)
  {
    Integer gcd        = gcd(num, denom);
    Integer nomSimpl   = num / gcd;
    Integer denomSimpl = denom / gcd;

    return new SimpleFraction(nomSimpl, denomSimpl);
  }

  /**
   * adds two fraction and simplifies the result.
   * @param lhs left hand side argument
   * @param rhs right hand side argument
   * @return lhs+rhs (simplified)
   */
  public SimpleFraction add(SimpleFraction lhs, SimpleFraction rhs)
  {
    Integer nom   = (  lhs.getNumerator() * rhs.getDenominator()
                    +  rhs.getNumerator() * lhs.getDenominator()
                    );
    Integer denom = lhs.getDenominator() * rhs.getDenominator();

    return simplify(nom, denom);
  }

  /**
   * subtracts two fraction and simplifies the result.
   * @param lhs left hand side argument
   * @param rhs right hand side argument
   * @return lhs-rhs (simplified)
   */
  public SimpleFraction sub(SimpleFraction lhs, SimpleFraction rhs)
  {
    Integer nom   = (  lhs.getNumerator() * rhs.getDenominator()
                    -  rhs.getNumerator() * lhs.getDenominator()
                    );
    Integer denom = lhs.getDenominator() * rhs.getDenominator();

    return simplify(nom, denom);
  }

  /**
   * multiplies two fraction and simplifies the result.
   * @param lhs left hand side argument
   * @param rhs right hand side argument
   * @return lhs*rhs (simplified)
   */
  public SimpleFraction mul(SimpleFraction lhs, SimpleFraction rhs)
  {
    Integer nom   = lhs.getNumerator() * rhs.getNumerator();
    Integer denom = lhs.getDenominator() * rhs.getDenominator();

    return simplify(nom, denom);
  }

  /**
   * divides two fraction and simplifies the result.
   * @param lhs left hand side argument
   * @param rhs right hand side argument
   * @return lhs/rhs (simplified)
   */
  public SimpleFraction div(SimpleFraction lhs, SimpleFraction rhs)
  {
    Integer nom   = lhs.getNumerator() * rhs.getDenominator();
    Integer denom = lhs.getDenominator() * rhs.getNumerator();

    return simplify(nom, denom);
  }

  // unary operations

  /**
   * flips sign of the fraction by flipping the sign of the numerator.
   * @param operand a fraction object
   * @return -operand
   */
  public SimpleFraction negate(SimpleFraction operand)
  {
    Integer nom   = -operand.getNumerator();
    Integer denom = operand.getDenominator();

    // simplify not needed
    return new SimpleFraction(nom, denom);
  }

  // values

  /**
   * returns a representation for 0.
   * @return 0
   */
  public SimpleFraction zero()
  {
    return new SimpleFraction(0, 1);
  }

  /**
   * returns a representation for 1.
   * @return 1
   */
  public SimpleFraction one()
  {
    return new SimpleFraction(1, 1);
  }
}