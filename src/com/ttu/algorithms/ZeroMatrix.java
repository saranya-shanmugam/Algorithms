package com.ttu.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * An algorithm such that if an element in an MxN matrix is 0, its entire row
 * and column are set to 0.
 */
public class ZeroMatrix {

	public static void main(String[] args) {
		ZeroMatrix zeroMatrix = new ZeroMatrix();
		int[][] matrix1 = new int[][] { { 1, 2, 3, 0, 5, 6 }, { 5, 6, 7, 8, 8, 8 }, { 9, 10, 11, 12, 12, 12 },
				{ 13, 14, 15, 16, 16, 16 }, { 17, 18, 19, 20, 20, 20 }, { 21, 22, 23, 24, 25, 0 } };
		int[][] matrix = new int[][] { { 0, 2, 3, 4 }, { 0, 2, 3, 4 }, { 1, 2, 0, 4 }, };
		zeroMatrix.formZeroMatrix(matrix1);
		zeroMatrix.formZeroMatrix(matrix);
	}

	private void formZeroMatrix(int[][] matrix) {
		int rowLength = matrix.length;
		if (rowLength == 0) {
			System.out.println("Matrix is empty");
			return;
		}
		int colLength = matrix[0].length;
		Set<Integer> rowSet = new HashSet<>();
		Set<Integer> colSet = new HashSet<>();
		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < colLength; j++) {
				if (matrix[i][j] == 0) {
					if (rowSet.contains(i) || colSet.contains(j))
						continue;
					rowSet.add(i);
					makeZerosInRowOrCol(matrix, i, colLength, true);
					colSet.add(j);
					makeZerosInRowOrCol(matrix, j, rowLength, false);
				}

			}
		}
		System.out.println(Arrays.deepToString(matrix));
	}

	private void makeZerosInRowOrCol(int[][] matrix, int rowColIndex, int rowColSize, boolean isRow) {
		if (isRow) {
			for (int i = 0; i < rowColSize; i++) {
				matrix[rowColIndex][i] = 0;
			}
		} else {
			for (int i = 0; i < rowColSize; i++) {
				matrix[i][rowColIndex] = 0;
			}
		}

	}
}
