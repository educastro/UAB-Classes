package assignment08;

/**
 * Defines an interface for arithmetic operations on Numbers.
 * A concrete class will implement arithmetic operations for a class N.
 * @param <N> a numeric type
 */
public interface Arithmetic<N extends Number>
{
  /* binary operations */

  /**
   * Computes lhs+rhs.
   * @param lhs left hand side argument
   * @param rhs right hand side argument
   * @return lhs+rhs
   */
  N add(N lhs, N rhs);

  /**
   * Computes minuend-subtrahend.
   * @param minuend left hand side argument
   * @param subtrahend right hand side argument
   * @return minuend-subtrahend
   */
  N sub(N minuend, N subtrahend);

  /**
   * Computes lhs*rhs.
   * @param lhs left hand side argument
   * @param rhs right hand side argument
   * @return lhs*rhs
   */
  N mul(N lhs, N rhs);

  /**
   * Computes numerator/denominator.
   * @param numerator left hand side argument
   * @param denominator right hand side argument
   * @return dividend/denominator
   */
  N div(N numerator, N denominator);

  /* unary operations */

  /**
   * Computes -operand.
   * @param operand argument for sign reversal
   * @return -operand
   */
  N negate(N operand);

  /* values */

  /**
   * Returns a representation for the value 1.
   * @return a value of typo N representing 1
   */
  N one();

  /**
   * Returns a representation for the value 0.
   *
   * Note, this is for convenience only, because zero() == one() - one()
   * @return a value of typo N representing 0
   */
  N zero();

}


