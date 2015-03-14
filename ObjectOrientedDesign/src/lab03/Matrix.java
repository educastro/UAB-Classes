package lab03;

public class Matrix {
	
	private Double[][] matrix;
	private int rowSize = 0;
	private int columnSize = 0;
	private boolean matrixInitializated = false;
	
	/*
	 * Method for creating the local matrix based on an matrix provided as parameter
	 ** @preconditions: matrixParameter can't be null or empty
	 ** @post-conditions: matrixInitializated must be true, local matrix created and row and column sizes calculated
	 */
	
	public void readMatrix(Double[][] matrixParameter) throws Exception{
		if(matrixParameter.length <= 0)
			throw new Exception("Matrix doesnt exist. Size equal or less than 0");
		
		this.setRowSize(matrixParameter.length);
		this.setColumnSize(matrixParameter[0].length);
		
		matrix = matrixParameter;
		setInitializated();
	}

	/*
	 * Sets the matrixInitializated as true during the execution of readMatrix method
	 ** @preconditions: none
	 ** @post-conditions: matrixInitializated must be true
	 */
	
	public void setInitializated(){
		this.matrixInitializated = true;
	}
	
	/*
	 * Returns true or not saying if the matrix was initializated or not
	 ** @preconditions: none
	 ** @post-conditions: return must be true or false
	 */
	
	public boolean isInitializated(){
		return matrixInitializated;
	}
	
	/*
	 * Prints the matrix on the console
	 ** @preconditions: matrix must have been initializated
	 ** @post-conditions: none
	 */
	
	public void displayMatrix() throws Exception{
		if(!isInitializated())
			throw new Exception("Matrix doesnt exist");
		
		for(int rowIterator = 0; rowIterator < this.getRowSize(); rowIterator++){
			System.out.println();
			System.out.print("[");
			for(int columnIterator = 0; columnIterator < this.getColumnSize(); columnIterator++){
				System.out.print(" " + matrix[rowIterator][columnIterator] + " ");
			}
			System.out.print("]");
		}
	}
	
	/*
	 * Returns the matrix
	 ** @preconditions: matrix must have been initializated
	 ** @post-conditions: return != 0
	 */
	
	public Double[][] getMatrix() throws Exception{
		if(!isInitializated())
			throw new Exception("Matrix doesnt exist");
		
		return matrix;
	}
	
	/*
	 * Returns how many rows
	 ** @preconditions: matrix must have been initializated
	 ** @post-conditions: return != 0
	 */
	
	public int getRowSize() throws Exception{
		if(!isInitializated())
			throw new Exception("Matrix doesnt exist");
		
		return rowSize;
	}
	
	/*
	 * Sets how many rows
	 ** @preconditions: value must be provided as parameter
	 ** @post-conditions: value must be assigned
	 */
	
	public void setRowSize(int rowSize){
		this.rowSize = rowSize;
	}
	
	/*
	 * Returns how many columns
	 ** @preconditions: matrix must have been initializated
	 ** @post-conditions: return != 0
	 */
	
	public int getColumnSize() throws Exception{
		if(!isInitializated())
			throw new Exception("Matrix doesnt exist");
		
		return columnSize;
	}
	
	/*
	 * Sets how many columns
	 ** @preconditions: value must be provided as parameter
	 ** @post-conditions: value must be assigned
	 */
	
	public void setColumnSize(int columnSize){
		this.columnSize = columnSize;
	}
	
	/*
	 * Sets a given value to a given position on the matrix
	 ** @preconditions: matrix must have been initializated and the values needs to be insided the allowed ranges
	 ** @post-conditions: the new value must be assigned to the given position
	 */
	
	public void setValueAtPosition(double value, int rowPosition, int columnPosition) throws Exception{
		if(!isInitializated())
			throw new Exception("Matrix doesnt exist");
		
		if((rowPosition < 0) || (columnPosition < 0) || (rowPosition >= this.getRowSize()) || (columnPosition >= this.getColumnSize()))
			throw new Exception("Out of range position values");
		
		matrix[rowPosition][columnPosition] = value;
	}
	
	/*
	 * Returns the value from a given position
	 ** @preconditions: matrix must have been initializated and the values needs to be insided the allowed ranges 
	 ** @post-conditions: none
	 */
	
	public double getValueAtPosition(int rowPosition, int columnPosition) throws Exception{
		if(!isInitializated())
			throw new Exception("Matrix doesnt exist");
		
		if((rowPosition < 0) || (columnPosition < 0) || (rowPosition >= this.getRowSize()) || (columnPosition >= this.getColumnSize()))
			throw new Exception("Out of range position values");
		
		return matrix[rowPosition][columnPosition];
	}
	
	/*
	 * Performs a sum between two matrixes and return the result as a new Matrix instance
	 ** @preconditions: matrix must have been initializated and the values needs to be inside the allowed ranges
	 ** @post-conditions: resultantMatrixObject != null
	 ** @invariants:  
	 */
	
	public Matrix plusAnotherMatrix(Matrix matrixParameter) throws Exception{
		if((!isInitializated()) || (!matrixParameter.isInitializated()))
			throw new Exception("Matrix doesnt exist");
		
		if((this.getRowSize() != matrixParameter.getRowSize()) || (this.getColumnSize() != matrixParameter.getColumnSize()))
			throw new Exception("Size or Column Sizes different");
		
		Double[][] resultantMatrix = new Double[this.rowSize][this.columnSize];
		
		for(int rowIterator = 0; rowIterator < this.getRowSize(); rowIterator++){
			for(int columnIterator = 0; columnIterator < this.getColumnSize(); columnIterator++){
				resultantMatrix[rowIterator][columnIterator] = this.getValueAtPosition(rowIterator, columnIterator) + 
						matrixParameter.getValueAtPosition(rowIterator, columnIterator);
			}
		}
		
		Matrix resultantMatrixObject = new Matrix();
		resultantMatrixObject.readMatrix(resultantMatrix);

		return resultantMatrixObject;
	}
	
	/*
	 * Performs a multiplication between two matrixes 
	 ** @preconditions: matrix must have been initializated and the values needs to be inside the allowed ranges
	 ** @post-conditions: resultantMatrixObject != null
	 */
	
	public Matrix timesAnotherMatrix(Matrix matrixParameter) throws Exception{
		if((!isInitializated()) || (!matrixParameter.isInitializated()))
			throw new Exception("Matrix doesnt exist");
		
		if(this.getRowSize() != matrixParameter.getColumnSize())
			throw new Exception("Row Size from one Matrix different from Column Size from the other");
		
		Double[][] resultantMatrix = new Double[this.getRowSize()][matrixParameter.getColumnSize()];
		
		/*
		 * Sets the value 0 for all the positions of the matrix. This will be important for the multiplication step. 
		 */
		
		for(int rowIterator = 0; rowIterator < this.matrix.length; rowIterator++){
			for(int columnIterator = 0; columnIterator < matrixParameter.matrix[0].length; columnIterator++){
				resultantMatrix[rowIterator][columnIterator] = 0.0;
			}
		}		
		
		for(int resultantMatrixRowIterator = 0; resultantMatrixRowIterator < this.getRowSize(); resultantMatrixRowIterator++){
			for(int resultantMatrixColumnIterator = 0; resultantMatrixColumnIterator < matrixParameter.getColumnSize(); resultantMatrixColumnIterator++){
				for(int sumIterator = 0; sumIterator < this.getColumnSize(); sumIterator++){
					resultantMatrix[resultantMatrixRowIterator][resultantMatrixColumnIterator] += 
							this.getValueAtPosition(resultantMatrixRowIterator, sumIterator) * 
							matrixParameter.getValueAtPosition(sumIterator, resultantMatrixColumnIterator);
				}
			}
		}

		Matrix resultantMatrixObject = new Matrix();
		resultantMatrixObject.readMatrix(resultantMatrix);

		return resultantMatrixObject;	
	}
	
}
