package algstudent.session0;

import java.util.Random;

public class MatrixOperations {

	private Random random = new Random();
	private int[][] matrix;
	private int size;

	/**
	 * Creates a new matrix of size n x n and fills it with random values. These
	 * random values must be parameterizable between a maximum (max) and a
	 * minimum (min) value.
	 * 
	 * @param n the size of the matrix.
	 * @param min
	 * @param max
	 */
	public MatrixOperations(int n, int min, int max) {
		if (n < 0) {
			throw new RuntimeException("The size cannot be less than zero.");
		}
		if (min < 0) {
			throw new RuntimeException("The size cannot be less than zero.");
		}
		size = n;
		fillMatrix(min, max);
	}

	private void fillMatrix(int min, int max) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				int r = random.nextInt(max + 1) + min;
				matrix[i][j] = r;
			}
		}
	}

	/**
	 * Creates a matrix using data of the file provided as parameter. This file
	 * must have 1 integer number as the first line. Following lines contain n
	 * values to represent every element of the matrix row. Each of the values
	 * will be separated by a tabulator.
	 * 
	 * @param String with the name of the file.
	 */
	public MatrixOperations(String fileName) {
		
	}

	/**
	 * Returns the matrix size (n).
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Prints in the console all the matrix elements.
	 */
	public void write() {
		
	}

	/**
	 * Computes the summation of all the elements of the matrix diagonal. This
	 * implementation must iterate over all the matrix elements, but only sums
	 * appropriate elements. So, the complexity is quadratic.
	 * 
	 * @return int with the result of the sum.
	 */
	public int sumDiagonal1() {
		int result = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == j){
					result += matrix[i][j];
                }
			}
		}
		return result;
	}

	/**
	 * Computes the summation of all the elements of the matrix diagonal. This
	 * second version should only consider the elements of the main diagonal.
	 * So, the complexity is linear.
	 * 
	 * @return int with the result of the sum.
	 */
	public int sumDiagonal2() {
		int result = 0;
		for (int i = 0; i < size; i++) {
			result += matrix[i][i]; // The matrix is square
		}
		return result;
	}

	/**
	 * Given a matrix with integer numbers between 1 and 4, this method iterates
	 * through the matrix starting at position (i, j) according to the following
	 * number meanings: 1 – move up; 2 – move right; 3 – move down; 4 – move
	 * left. Traversed elements would be set to -1 value. The process will
	 * finish if it goes beyond the limits of the matrix or an already traversed
	 * position is reached.
	 * 
	 * @param i
	 * @param j
	 */
	public void travelPath(int i, int j) {
		
	}
}
