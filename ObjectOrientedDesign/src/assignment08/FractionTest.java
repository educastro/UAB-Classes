package assignment08;

import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest {

	@Test
	public void testGetNumeratorForInteger() {
		int numberOne = 5;
		int numberTwo = 10;
		
		Fraction fraction = new Fraction(numberOne, numberTwo);
		
		assertTrue(fraction.getNumerator().getClass() == Integer.class);
		assertTrue(fraction.getNumerator().intValue() == 5);
		
		assertTrue(fraction.getDenominator().getClass() == Integer.class);
		assertTrue(fraction.getDenominator().intValue() == 10);
	}

}
