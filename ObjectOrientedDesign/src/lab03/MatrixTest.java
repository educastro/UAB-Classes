package lab03;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixTest {
	@SuppressWarnings("deprecation")

	@Test
	public void testGetMatrixMethod() throws Exception{
		Matrix matrix = new Matrix();
		Double[][] matrixParameter = {{1.0}};
		
		matrix.readMatrix(matrixParameter);
		
		assertEquals(matrix.getMatrix(), matrixParameter);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testReadMethodIfItIsStoringCorrectly() throws Exception{
		Matrix matrix = new Matrix();
		Double[][] matrixParameter = {{1.0}};
		
		matrix.readMatrix(matrixParameter);
		
		assertEquals(matrix.getMatrix(), matrixParameter);
	}
	
	@Test
	public void testReadMethodIfItStoresSizesCorrectly() throws Exception{
		Matrix matrix = new Matrix();
		Double[][] matrixParameter = {{1.0, 2.0, 3.0, 4.0}, {5.0,6.0,7.0,8.0}};
		
		matrix.readMatrix(matrixParameter);
		
		assertEquals(matrix.getRowSize(), 2);
		assertEquals(matrix.getColumnSize(), 4);
	}
	
	@Test
	public void testGetRowSizeMethod() throws Exception{
		Matrix matrix = new Matrix();
		Double[][] matrixParameter = {{1.0, 2.0, 3.0, 4.0}, {5.0,6.0,7.0,8.0}};
		
		matrix.readMatrix(matrixParameter);
		
		assertEquals(matrix.getRowSize(), 2);
	}
	
	@Test
	public void testGetColumnSizeMethod() throws Exception{
		Matrix matrix = new Matrix();
		Double[][] matrixParameter = {{1.0, 2.0, 3.0, 4.0}, {5.0,6.0,7.0,8.0}};
		
		matrix.readMatrix(matrixParameter);
		
		assertEquals(matrix.getColumnSize(), 4);
	}
	
	@Test (expected = Exception.class)
	public void testSetValueMethodWithLessThanZeroRowPosition() throws Exception{
		Matrix matrix = new Matrix();
		Double[][] matrixParameter = {{1.0, 2.0, 3.0, 4.0}, {5.0,6.0,7.0,8.0}};
		
		matrix.readMatrix(matrixParameter);
		matrix.setValueAtPosition(99.0, -5, 0);
	}
	
	@Test (expected = Exception.class)
	public void testSetValueMethodWithLessThanZeroColumnPosition() throws Exception{
		Matrix matrix = new Matrix();
		Double[][] matrixParameter = {{1.0, 2.0, 3.0, 4.0}, {5.0,6.0,7.0,8.0}};
		
		matrix.readMatrix(matrixParameter);
		matrix.setValueAtPosition(99.0, 5, -3);
	}
	
	@Test (expected = Exception.class)
	public void testSetValueMethodWithLessThanZeroRowAndColumnPosition() throws Exception{
		Matrix matrix = new Matrix();
		Double[][] matrixParameter = {{1.0, 2.0, 3.0, 4.0}, {5.0,6.0,7.0,8.0}};
		
		matrix.readMatrix(matrixParameter);
		matrix.setValueAtPosition(99.0, -5, -10);
	}
	
	@Test (expected = Exception.class)
	public void testSetValueMethodWithBiggerRowSizePosition() throws Exception{
		Matrix matrix = new Matrix();
		Double[][] matrixParameter = {{1.0, 2.0, 3.0, 4.0}, {5.0,6.0,7.0,8.0}};
		
		matrix.readMatrix(matrixParameter);
		matrix.setValueAtPosition(99.0, matrix.getRowSize(), 0);
	}
	
	@Test (expected = Exception.class)
	public void testSetValueMethodWithBiggerColumnSizePosition() throws Exception{
		Matrix matrix = new Matrix();
		Double[][] matrixParameter = {{1.0, 2.0, 3.0, 4.0}, {5.0,6.0,7.0,8.0}};
		
		matrix.readMatrix(matrixParameter);
		matrix.setValueAtPosition(99.0, 0, matrix.getColumnSize());
	}
	
	@Test (expected = Exception.class)
	public void testSetValueMethodWithBiggerRowAndColumnSizePosition() throws Exception{
		Matrix matrix = new Matrix();
		Double[][] matrixParameter = {{1.0, 2.0, 3.0, 4.0}, {5.0,6.0,7.0,8.0}};
		
		matrix.readMatrix(matrixParameter);
		matrix.setValueAtPosition(99.0, matrix.getRowSize(), matrix.getColumnSize());
	}
	
	@Test (expected = Exception.class)
	public void testSetValueMethodWithUnitializedArray() throws Exception{
		Matrix matrix = new Matrix();

		matrix.setValueAtPosition(5.0, matrix.getRowSize(), matrix.getColumnSize());
	}
	
	@Test
	public void testSetValueMethod() throws Exception{
		Matrix matrix = new Matrix();
		Double[][] matrixParameter = {{1.0, 2.0, 3.0, 4.0}, {5.0,6.0,7.0,8.0}};
		
		matrix.readMatrix(matrixParameter);
		matrix.setValueAtPosition(99.0, 0, 0);
		matrix.setValueAtPosition(53.0, 1, 2);
		
		assertTrue(matrix.getMatrix()[0][0] == 99.0);
		
		assertTrue(matrix.getMatrix()[1][2] == 53.0);
	}
	
	@Test (expected = Exception.class)
	public void testGetValueMethodWithBiggerRowSizePosition() throws Exception{
		Matrix matrix = new Matrix();
		Double[][] matrixParameter = {{1.0, 2.0, 3.0, 4.0}, {5.0,6.0,7.0,8.0}};
		
		matrix.readMatrix(matrixParameter);
		matrix.getValueAtPosition(matrix.getRowSize(), 0);
	}
	
	@Test (expected = Exception.class)
	public void testGetValueMethodWithBiggerColumnSizePosition() throws Exception{
		Matrix matrix = new Matrix();
		Double[][] matrixParameter = {{1.0, 2.0, 3.0, 4.0}, {5.0,6.0,7.0,8.0}};
		
		matrix.readMatrix(matrixParameter);
		matrix.getValueAtPosition(0, matrix.getColumnSize());
	}
	
	@Test (expected = Exception.class)
	public void testGetValueMethodWithBiggerRowAndColumnSizePosition() throws Exception{
		Matrix matrix = new Matrix();
		Double[][] matrixParameter = {{1.0, 2.0, 3.0, 4.0}, {5.0,6.0,7.0,8.0}};
		
		matrix.readMatrix(matrixParameter);
		matrix.getValueAtPosition(matrix.getRowSize(), matrix.getColumnSize());
	}
	
	@Test (expected = Exception.class)
	public void testGetValueMethodWithUnitializedArray() throws Exception{
		Matrix matrix = new Matrix();

		matrix.getValueAtPosition(matrix.getRowSize(), matrix.getColumnSize());
	}
	
	@Test
	public void testGetValueMethod() throws Exception{
		Matrix matrix = new Matrix();
		Double[][] matrixParameter = {{1.0, 2.0, 3.0, 4.0}, {5.0,6.0,7.0,8.0}};
		
		matrix.readMatrix(matrixParameter);
		assertTrue(matrix.getValueAtPosition(0,0) == 1.0);
		assertTrue(matrix.getValueAtPosition(0,1) == 2.0);
		assertTrue(matrix.getValueAtPosition(0,2) == 3.0);
		assertTrue(matrix.getValueAtPosition(0,3) == 4.0);
		assertTrue(matrix.getValueAtPosition(1,0) == 5.0);
		assertTrue(matrix.getValueAtPosition(1,1) == 6.0);
		assertTrue(matrix.getValueAtPosition(1,2) == 7.0);
		assertTrue(matrix.getValueAtPosition(1,3) == 8.0);
	}
	
	@Test
	public void testPlusAnotherMatrixMethod() throws Exception{
		Matrix matrix = new Matrix();
		Double[][] matrixParameter = {{1.0, 2.0, 3.0, 4.0}, {5.0,6.0,7.0,8.0}};
		
		matrix.readMatrix(matrixParameter);
		
		Matrix matrix2 = new Matrix();
		Double[][] matrixParameter2 = {{1.0, 2.0, 3.0, 4.0}, {5.0,6.0,7.0,8.0}};
		
		matrix2.readMatrix(matrixParameter2);
		
		Matrix resultantMatrix = matrix.plusAnotherMatrix(matrix2);
		
		assertTrue(resultantMatrix.getValueAtPosition(0,0) == 2.0);
		assertTrue(resultantMatrix.getValueAtPosition(0,1) == 4.0);
		assertTrue(resultantMatrix.getValueAtPosition(0,2) == 6.0);
		assertTrue(resultantMatrix.getValueAtPosition(0,3) == 8.0);
		assertTrue(resultantMatrix.getValueAtPosition(1,0) == 10.0);
		assertTrue(resultantMatrix.getValueAtPosition(1,1) == 12.0);
		assertTrue(resultantMatrix.getValueAtPosition(1,2) == 14.0);
		assertTrue(resultantMatrix.getValueAtPosition(1,3) == 16.0);
	}
	
	@Test (expected = Exception.class)
	public void testPlusAnotherMatrixWithUnitializatedMatrix() throws Exception{
		Matrix matrix = new Matrix();
		
		Matrix matrix2 = new Matrix();
		Double[][] matrixParameter2 = {{1.0, 2.0, 3.0, 4.0}, {5.0,6.0,7.0,8.0}};
		
		matrix2.readMatrix(matrixParameter2);
		
		matrix.plusAnotherMatrix(matrix2);
		
	}
	
	@Test (expected = Exception.class)
	public void testPlusAnotherMatrixWithUnitializatedMatrixAsParameter() throws Exception{
		Matrix matrix = new Matrix();
		Double[][] matrixParameter = {{1.0, 2.0, 3.0, 4.0}, {5.0,6.0,7.0,8.0}};
		
		matrix.readMatrix(matrixParameter);
		
		Matrix matrix2 = new Matrix();
				
		matrix.plusAnotherMatrix(matrix2);	
	}
	
	@Test (expected = Exception.class)
	public void testPlusAnotherMatrixWithDifferentSizeMatrixes() throws Exception{
		Matrix matrix = new Matrix();
		Double[][] matrixParameter = {{1.0, 2.0, 3.0, 4.0}, {5.0,6.0,7.0,8.0}};
		
		matrix.readMatrix(matrixParameter);
		
		Matrix matrix2 = new Matrix();
		Double[][] matrixParameter2 = {{1.0, 2.0, 3.0, 4.0, 5.0}, {5.0,6.0,7.0,8.0,9.0}};
		
		matrix2.readMatrix(matrixParameter2);
		
		matrix.plusAnotherMatrix(matrix2);
	}
	
	@Test (expected = Exception.class)
	public void testTimesAnotherMatrixMethodWithEqualSizesMatrixes() throws Exception{
		Matrix matrix = new Matrix();
		Double[][] matrixParameter = {{1.0, 2.0, 3.0, 4.0}, {5.0,6.0,7.0,8.0}};
		
		matrix.readMatrix(matrixParameter);
		
		Matrix matrix2 = new Matrix();
		Double[][] matrixParameter2 = {{1.0, 2.0, 3.0, 4.0}, {5.0,6.0,7.0,8.0}};
		
		matrix2.readMatrix(matrixParameter2);
		
		Matrix resultantMatrix = matrix.timesAnotherMatrix(matrix2);
		
		assertTrue(resultantMatrix.getValueAtPosition(0,0) == 2.0);
		assertTrue(resultantMatrix.getValueAtPosition(0,1) == 4.0);
		assertTrue(resultantMatrix.getValueAtPosition(0,2) == 6.0);
		assertTrue(resultantMatrix.getValueAtPosition(0,3) == 8.0);
		assertTrue(resultantMatrix.getValueAtPosition(1,0) == 10.0);
		assertTrue(resultantMatrix.getValueAtPosition(1,1) == 12.0);
		assertTrue(resultantMatrix.getValueAtPosition(1,2) == 14.0);
		assertTrue(resultantMatrix.getValueAtPosition(1,3) == 16.0);
	}

	@Test (expected = Exception.class)
	public void testTimesAnotherMatrixMethodWithNotAsllowedSizesMatrixes() throws Exception{
		Matrix matrix = new Matrix();
		Double[][] matrixParameter = {{1.0, 2.0, 3.0}, {5.0,6.0,7.0}};
		
		matrix.readMatrix(matrixParameter);
		
		Matrix matrix2 = new Matrix();
		Double[][] matrixParameter2 = {{1.0, 2.0, 3.0, 4.0}, {5.0,6.0,7.0,8.0}};
		
		matrix2.readMatrix(matrixParameter2);
		
		Matrix resultantMatrix = matrix.timesAnotherMatrix(matrix2);
		
		assertTrue(resultantMatrix.getValueAtPosition(0,0) == 2.0);
		assertTrue(resultantMatrix.getValueAtPosition(0,1) == 4.0);
		assertTrue(resultantMatrix.getValueAtPosition(0,2) == 6.0);
		assertTrue(resultantMatrix.getValueAtPosition(0,3) == 8.0);
		assertTrue(resultantMatrix.getValueAtPosition(1,0) == 10.0);
		assertTrue(resultantMatrix.getValueAtPosition(1,1) == 12.0);
		assertTrue(resultantMatrix.getValueAtPosition(1,2) == 14.0);
		assertTrue(resultantMatrix.getValueAtPosition(1,3) == 16.0);
	}
	
	@Test
	public void testTimesAnotherMatrixMethod() throws Exception{
		Matrix matrix = new Matrix();
		Double[][] matrixParameter = {{1.0, 2.0, 3.0}, {4.0,5.0,6.0}};
		
		matrix.readMatrix(matrixParameter);
		
		Matrix matrix2 = new Matrix();
		Double[][] matrixParameter2 = {{7.0,8.0}, {9.0,10.0}, {11.0,12.0}};
		
		matrix2.readMatrix(matrixParameter2);
		
		Matrix resultantMatrix = matrix.timesAnotherMatrix(matrix2);
		
		assertTrue(resultantMatrix.getValueAtPosition(0,0) == 58.0);
		assertTrue(resultantMatrix.getValueAtPosition(0,1) == 64.0);
		assertTrue(resultantMatrix.getValueAtPosition(1,0) == 139.0);
		assertTrue(resultantMatrix.getValueAtPosition(1,1) == 154.0);
	}
}
