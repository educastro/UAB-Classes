package lab03;

public class MatrixMain {

	public static void main(String[] args) throws Exception {
		/*
		 * Creates a matrix for the sum
		 */
		
		Matrix matrix = new Matrix();
		Double[][] matrixParameter = {{1.0, 2.0, 3.0, 4.0}, {5.0,6.0,7.0,8.0}};
		
		matrix.readMatrix(matrixParameter);
		
		/*
		 * Creates another matrix for the sum
		 */
		
		Matrix matrix2 = new Matrix();
		Double[][] matrixParameter2 = {{1.0, 2.0, 3.0, 4.0}, {5.0,6.0,7.0,8.0}};
		
		matrix2.readMatrix(matrixParameter2);
		
		/*
		 * Variable that receives the resultant matrix from the sum
		 */
		
		Matrix resultantMatrixPlus = matrix.plusAnotherMatrix(matrix2);
		
		/*
		 * Creates a matrix for the multiplication
		 */
		
		Matrix matrix3 = new Matrix();
		Double[][] matrixParameter3 = {{1.0, 2.0, 3.0}, {4.0,5.0,6.0}};
		
		matrix3.readMatrix(matrixParameter3);
		
		/*
		 * Creates another matrix for the multiplication
		 */
		
		Matrix matrix4 = new Matrix();
		Double[][] matrixParameter4 = {{7.0,8.0}, {9.0,10.0}, {11.0,12.0}};
		
		matrix4.readMatrix(matrixParameter4);
		
		/*
		 * Variable that receives the resultant matrix from the multiplication
		 */
		
		Matrix resultantMatrixTimes = matrix3.timesAnotherMatrix(matrix4);
		
		/*
		 * Displaying the sum
		 */
		
		System.out.println("Sum:");
		matrix.displayMatrix();
		System.out.println("\n\n\t  +");
		matrix2.displayMatrix();
		System.out.println("\n\n\t  =");
		resultantMatrixPlus.displayMatrix();
		
		/*
		 * Displaying the multiplication
		 */
		
		System.out.println("\n\nMultiplication:");
		matrix3.displayMatrix();
		System.out.println("\n\n\t  *");
		matrix4.displayMatrix();
		System.out.println("\n\n\t  =");
		resultantMatrixTimes.displayMatrix();
		
		/*
		 * Displaying informations about the matrix from the multiplication
		 */
		
		System.out.println("\n\nThe last matrix has " + resultantMatrixTimes.getColumnSize() + " colums and " + resultantMatrixTimes.getRowSize() + " rows.");
		System.out.println("The original value from the position [0][0] is " + resultantMatrixTimes.getValueAtPosition(0, 0) + " and now we are changing it"
				+ " the value 5.0.");
		resultantMatrixTimes.setValueAtPosition(5.0, 0, 0);
		System.out.println("The original value from the position [0][0] is " + resultantMatrixTimes.getValueAtPosition(0, 0) + ".");
		

	}

}
