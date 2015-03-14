package assignment01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EnhancedRangeDoubleTest {
	
	@Test
	public void validateTheInstantiationWithOneParameter() throws Exception{
		EnhancedRangeDouble erd = new EnhancedRangeDouble(1);
		assertEquals(erd.mantissa, 1,0);
	}
	
	@Test
	public void validateTheInstantiationWithTwoParameters() throws Exception{
		EnhancedRangeDouble erd = new EnhancedRangeDouble(1,1);
		assertEquals(erd.mantissa, 1,0);
		assertEquals(erd.exponent, 1);
	}
	
	@Test
	public void validateSumOnePlusOneWithOneParameterInstant() throws Exception{
		EnhancedRangeDouble secondErd = new EnhancedRangeDouble(1);
		EnhancedRangeDouble erd = new EnhancedRangeDouble(1).add(secondErd);
		
		assertEquals(erd.mantissa, 2,0);
		assertEquals(erd.exponent, 1);
	}
	
	@Test
	public void validateSumOnePlusOneWithTwoParameterInstantButExponentOne() throws Exception{
		EnhancedRangeDouble secondErd = new EnhancedRangeDouble(1,1);
		EnhancedRangeDouble erd = new EnhancedRangeDouble(1,1).add(secondErd);
		
		assertEquals(erd.mantissa, 2,0);
		assertEquals(erd.exponent, 1);
	}
	
	@Test
	public void validateSumOnePlusOneWithTwoParameterInstantButExponentTwo() throws Exception{
		EnhancedRangeDouble secondErd = new EnhancedRangeDouble(1,2);
		EnhancedRangeDouble erd = new EnhancedRangeDouble(1,2).add(secondErd);
		
		assertEquals(erd.mantissa, 2,0);
		assertEquals(erd.exponent, 2);
	}
	
	@Test
	public void validateSumOnePlusOneWithTwoParameterInstantButDifferentExponents() throws Exception{
		EnhancedRangeDouble secondErd = new EnhancedRangeDouble(1,3);
		EnhancedRangeDouble erd = new EnhancedRangeDouble(1,2).add(secondErd);
		
		assertEquals(erd.mantissa, 1,1);
		assertEquals(erd.exponent, 3);
	}
	
	@Test
	public void validateSumOnePlusOneWithTwoParameterInstantButDifferentExponents2() throws Exception{
		EnhancedRangeDouble secondErd = new EnhancedRangeDouble(1,3);
		EnhancedRangeDouble erd = new EnhancedRangeDouble(1,5).add(secondErd);
		
		assertEquals(erd.mantissa, 1,01);
		assertEquals(erd.exponent, 5);
	}
	
	@Test
	public void validateSubTwoMinusOneWithOneParameterInstant() throws Exception{
		EnhancedRangeDouble secondErd = new EnhancedRangeDouble(1);
		EnhancedRangeDouble erd = new EnhancedRangeDouble(2).sub(secondErd);
		
		assertEquals(erd.mantissa, 1,0);
		assertEquals(erd.exponent, 1);
	}
	
	@Test
	public void validateSubTwoMinusOneWithTwoParameterInstantButExponentOne() throws Exception{
		EnhancedRangeDouble secondErd = new EnhancedRangeDouble(1,1);
		EnhancedRangeDouble erd = new EnhancedRangeDouble(2,1).sub(secondErd);
		
		assertEquals(erd.mantissa, 1,0);
		assertEquals(erd.exponent, 1);
	}
	
	@Test
	public void validateSubTwoMinusOneWithTwoParameterInstantButExponentTwo() throws Exception{
		EnhancedRangeDouble secondErd = new EnhancedRangeDouble(1,2);
		EnhancedRangeDouble erd = new EnhancedRangeDouble(2,2).sub(secondErd);
		
		assertEquals(erd.mantissa, 1,0);
		assertEquals(erd.exponent, 2);
	}
	
	@Test
	public void validateSubTwoMinusOneWithTwoParameterInstantButDifferentExponents() throws Exception{
		EnhancedRangeDouble secondErd = new EnhancedRangeDouble(1,3);
		EnhancedRangeDouble erd = new EnhancedRangeDouble(2,2).sub(secondErd);
		
		assertEquals(erd.mantissa, 0,8);
		assertEquals(erd.exponent, 3);
	}
	
	@Test
	public void validateSubOneMinusOneWithTwoParameterInstantButDifferentExponents2() throws Exception{
		EnhancedRangeDouble secondErd = new EnhancedRangeDouble(1,3);
		EnhancedRangeDouble erd = new EnhancedRangeDouble(2,5).sub(secondErd);
		
		assertEquals(erd.mantissa, 1,99);
		assertEquals(erd.exponent, 5);
	}
	
	@Test
	public void validateMulTwoXOneWithOneParameterInstant() throws Exception{
		EnhancedRangeDouble secondErd = new EnhancedRangeDouble(1);
		EnhancedRangeDouble erd = new EnhancedRangeDouble(2).mul(secondErd);
		
		assertEquals(erd.mantissa, 2,0);
		assertEquals(erd.exponent, 2);
	}
	
	@Test
	public void validateMulTwoXOneWithTwoParameterInstantButExponentOne() throws Exception{
		EnhancedRangeDouble secondErd = new EnhancedRangeDouble(1,1);
		EnhancedRangeDouble erd = new EnhancedRangeDouble(2,1).mul(secondErd);

		assertEquals(erd.mantissa, 2,0);
		assertEquals(erd.exponent, 2);
	}
	
	@Test
	public void validateMulTwoXOneWithTwoParameterInstantButExponentTwo() throws Exception{
		EnhancedRangeDouble secondErd = new EnhancedRangeDouble(1,2);
		EnhancedRangeDouble erd = new EnhancedRangeDouble(2,2).mul(secondErd);
		
		assertEquals(erd.mantissa, 2,0);
		assertEquals(erd.exponent, 4);
	}
	
	@Test
	public void validateMulTwoXOneWithTwoParameterInstantButDifferentExponents() throws Exception{
		EnhancedRangeDouble secondErd = new EnhancedRangeDouble(1,3);
		EnhancedRangeDouble erd = new EnhancedRangeDouble(2,2).mul(secondErd);

		assertEquals(erd.mantissa, 2,0);
		assertEquals(erd.exponent, 5);
	}
	
	@Test
	public void validateMulTwoXOneWithTwoParameterInstantButDifferentExponents2() throws Exception{
		EnhancedRangeDouble secondErd = new EnhancedRangeDouble(1,3);
		EnhancedRangeDouble erd = new EnhancedRangeDouble(2,5).mul(secondErd);
		System.out.println(erd.mantissa);
		System.out.println(erd.exponent);
		assertEquals(erd.mantissa, 2,0);
		assertEquals(erd.exponent, 8);
	}
	
	@Test
	public void validateDivTwoDivOneWithOneParameterInstant() throws Exception{
		EnhancedRangeDouble secondErd = new EnhancedRangeDouble(1);
		EnhancedRangeDouble erd = new EnhancedRangeDouble(2).div(secondErd);
		
		assertEquals(erd.mantissa, 2,0);
		assertEquals(erd.exponent, 0);
	}
	
	@Test
	public void validateDivTwoDivOneWithTwoParameterInstantButExponentOne() throws Exception{
		EnhancedRangeDouble secondErd = new EnhancedRangeDouble(1,1);
		EnhancedRangeDouble erd = new EnhancedRangeDouble(2,1).div(secondErd);

		assertEquals(erd.mantissa, 2,0);
		assertEquals(erd.exponent, 0);
	}
	
	@Test
	public void validateDivTwoDivOneWithTwoParameterInstantButExponentTwo() throws Exception{
		EnhancedRangeDouble secondErd = new EnhancedRangeDouble(1,2);
		EnhancedRangeDouble erd = new EnhancedRangeDouble(2,2).div(secondErd);
		
		assertEquals(erd.mantissa, 2,0);
		assertEquals(erd.exponent, 0);
	}
	
	@Test
	public void validateDivTwoDivOneWithTwoParameterInstantButDifferentExponents() throws Exception{
		EnhancedRangeDouble secondErd = new EnhancedRangeDouble(1,3);
		EnhancedRangeDouble erd = new EnhancedRangeDouble(2,2).div(secondErd);
		
		assertEquals(erd.mantissa, 2,0);
		assertEquals(erd.exponent, -1);
	}
	
	@Test
	public void validateDivTwoDivOneWithTwoParameterInstantButDifferentExponents2() throws Exception{
		EnhancedRangeDouble secondErd = new EnhancedRangeDouble(1,3);
		EnhancedRangeDouble erd = new EnhancedRangeDouble(2,5).div(secondErd);

		assertEquals(erd.mantissa, 2,0);
		assertEquals(erd.exponent, 2);
	}
	
	@Test (expected = Exception.class)
	public void validateExceptionWithInstantiation() throws Exception{
		EnhancedRangeDouble erd = new EnhancedRangeDouble((Math.pow(2, 31)-1), (int) (Math.pow(2, 31)-1));
	}
	
	@Test (expected = Exception.class)
	public void validateExceptionWithInstantiation2() throws Exception{
		EnhancedRangeDouble erd = new EnhancedRangeDouble((Math.pow(-2, 31)), (int) (Math.pow(2, 31)));
	}
	
	@Test (expected = Exception.class)
	public void validateExceptionWithAdd() throws Exception{
		EnhancedRangeDouble secondErd = new EnhancedRangeDouble((Math.pow(2, 31)-1), (int) (Math.pow(2, 31)-1));
		EnhancedRangeDouble erd = new EnhancedRangeDouble((Math.pow(2, 31)), (int) (Math.pow(2, 31))).add(secondErd);
	}
	
	@Test (expected = Exception.class)
	public void validateExceptionWithAdd2() throws Exception{
		EnhancedRangeDouble secondErd = new EnhancedRangeDouble((Math.pow(-2, 31)), (int) (Math.pow(2, 31)));
		EnhancedRangeDouble erd = new EnhancedRangeDouble((Math.pow(-2, 31)), (int) (Math.pow(2, 31))).add(secondErd);
	}
	
	@Test (expected = Exception.class)
	public void validateExceptionWithSub() throws Exception{
		EnhancedRangeDouble secondErd = new EnhancedRangeDouble((Math.pow(2, 31)-1), (int) (Math.pow(2, 31)-1));
		EnhancedRangeDouble erd = new EnhancedRangeDouble((Math.pow(2, 31)), (int) (Math.pow(2, 31))).sub(secondErd);
	}
	
	@Test (expected = Exception.class)
	public void validateExceptionWithSub2() throws Exception{
		EnhancedRangeDouble secondErd = new EnhancedRangeDouble((Math.pow(-2, 31)), (int) (Math.pow(2, 31)));
		EnhancedRangeDouble erd = new EnhancedRangeDouble((Math.pow(-2, 31)), (int) (Math.pow(2, 31))).sub(secondErd);
	}
	
	@Test (expected = Exception.class)
	public void validateExceptionWithMul() throws Exception{
		EnhancedRangeDouble secondErd = new EnhancedRangeDouble((Math.pow(2, 31)-1), (int) (Math.pow(2, 31)-1));
		EnhancedRangeDouble erd = new EnhancedRangeDouble((Math.pow(2, 31)), (int) (Math.pow(2, 31))).mul(secondErd);
	}
	
	@Test (expected = Exception.class)
	public void validateExceptionWithMul2() throws Exception{
		EnhancedRangeDouble secondErd = new EnhancedRangeDouble((Math.pow(-2, 31)), (int) (Math.pow(2, 31)));
		EnhancedRangeDouble erd = new EnhancedRangeDouble((Math.pow(-2, 31)), (int) (Math.pow(2, 31))).mul(secondErd);
	}
	
	@Test (expected = Exception.class)
	public void validateExceptionWithDiv() throws Exception{
		EnhancedRangeDouble secondErd = new EnhancedRangeDouble((Math.pow(2, 31)-1), (int) (Math.pow(2, 31)-1));
		EnhancedRangeDouble erd = new EnhancedRangeDouble((Math.pow(2, 31)), (int) (Math.pow(2, 31))).div(secondErd);
	}
	
	@Test (expected = Exception.class)
	public void validateExceptionWithDiv2() throws Exception{
		EnhancedRangeDouble secondErd = new EnhancedRangeDouble((Math.pow(-2, 31)), (int) (Math.pow(2, 31)));
		EnhancedRangeDouble erd = new EnhancedRangeDouble((Math.pow(-2, 31)), (int) (Math.pow(2, 31))).div(secondErd);
	}
	
	
}
