package assignment08;

/**
 * Defines an interface for operations on integral types.
 *
 * Compared to Arithmetic<N>, IntegerArithmetic<N> also offers a mod method.
 * @param <N> an integral type
 */
public interface IntegerArithmetic<N extends Number> extends Arithmetic<N>
{
  /**
   * Computes numerator % denominator.
   * @param numerator left hand side argument
   * @param denominator right hand side argument
   * @return numerator%denominator
   */
  N mod(N numerator, N denominator);
}

