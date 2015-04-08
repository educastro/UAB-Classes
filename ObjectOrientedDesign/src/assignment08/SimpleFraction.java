package assignment08;

/**
 * A class representing fraction of Integer.
 */
public class SimpleFraction extends java.lang.Number
{
  /**
   * Constructs a new SimpleFraction.
   *
   * @param n numerator
   * @param d denominator
   * @precondition n != null && d != null && d != Integer(0)
   */
  public SimpleFraction(Integer n, Integer d)
  {
    assert n != null && d != null : "arguments cannot be null";
    assert d != 0 : "denominator must not be zero";

    num = n;
    denom = d;
  }

  /**
   * returns a String representation for the SimpleFraction.
   * @return a textual representation of this fraction
   */
  public String toString()
  {
    // do not print Fraction, if denom is 1
    if ("1".equals(denom.toString())) return num.toString();

    return "(" + num + " / " + denom + ")";
  }

  /* Methods required by Number */

  /**
   * calculates double value of this SimpleFraction.
   * @return double value of this fraction
   */
  public double doubleValue()
  {
    return ((double)num) / denom;
  }

  /**
   * calculates float value of this SimpleFraction.
   * @return float value of this fraction
   */
  public float floatValue() { return (float)doubleValue(); }

  /**
   * calculates long value of this SimpleFraction.
   * @return long value of this fraction
   */
  public long  longValue()  { return (long)doubleValue(); }

  /**
   * calculates int value of this SimpleFraction.
   * @return int value of this fraction
   */
  public int   intValue()   { return (int)doubleValue(); }

  /* equals and hashCode */

  /**
   * equals returns true, iff numerator and denominator are equal.
   *
   * note, this is not numeric equality.
   *
   * @param o object to which this is compared
   * @return true, iff numerator and denominator are equal.
   */
  public boolean equals(Object o)
  {
    if (o == null) return false;
    if (getClass() != o.getClass()) return false;

    SimpleFraction that = (SimpleFraction)o;
    return (  this.getNumerator().intValue()   == that.getNumerator().intValue()
           && this.getDenominator().intValue() == that.getDenominator().intValue()
           );
  }

  /**
   * hashCode implementation in line with equals.
   * @return hash code for this fraction
   */
  public int hashCode()
  {
    return this.getNumerator().hashCode() ^ this.getDenominator().hashCode();
  }

  /* getter methods */

  /**
   * returns the numerator.
   * @return numerator
   */
  public Integer getNumerator()   { return num; }

  /**
   * returns the denominator.
   * @return denominator
   */
  public Integer getDenominator() { return denom; }

  /* fields */

  /** the numerator. */
  private Integer num;

  /** the denominator. */
  private Integer denom;

  /** serial version UID for serialization. */
  private static final long serialVersionUID = 161146059432882814L;
}