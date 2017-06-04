package com.ttu.algorithms;

import java.util.Arrays;

public class RotateMatrix90Degree {
	public static void main(String[] args) {
		RotateMatrix90Degree rotate = new RotateMatrix90Degree();
		int[][] matrix = new int[][] { { 1, 2, 3, 4, 5, 6}, { 5, 6, 7, 8, 8, 8}, { 9, 10, 11, 12, 12, 12}, 
			{ 13, 14, 15, 16, 16, 16},  { 17, 18, 19, 20, 20, 20},  { 21, 22, 23, 24, 25, 25} };
		int[][] matrix2 = new int[][] {{ 1, 2, 3, 4, 5, 6, 7, 8},{ 12, 2, 3, 4, 5, 6, 7, 8},{ 13, 2, 3, 4, 5, 6, 7, 8},{ 14, 2, 3, 4, 5, 6, 7, 8},
			{ 15, 2, 3, 4, 5, 6, 7, 8},{ 16, 2, 3, 4, 5, 6, 7, 8},{ 17, 2, 3, 4, 5, 6, 7, 8},{ 18, 2, 3, 4, 5, 6, 7, 8}};
		
//		System.out.println(Arrays.deepToString(matrix));
		rotate.rotateMatrix90(matrix);
		rotate.rotateMatrix90(matrix2);
	}

	private void rotateMatrix90(int[][] matrix) {
		int n = matrix.length;
		if(n == 0 || n != matrix[0].length) {
			System.out.println("It is not a NxN matrix");
			return;
		}
		System.out.println("Input matrix:");
		for (int[] a : matrix)
		{
		    System.out.println(Arrays.toString(a));
		}
		int temp;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i, k = j; j < ((n - 1) - i); j++) {
				temp = matrix[j][k];
				matrix[j][k] = matrix[(n - 1) - k][j];
				matrix[(n - 1) - k][j] = matrix[(n - 1) - j][(n - 1) - k];
				matrix[(n - 1) - j][(n - 1) - k] = matrix[k][(n - 1) - j];
				matrix[k][(n - 1) - j] = temp;
			}
		}
		//System.out.println(Arrays.deepToString(matrix));
		System.out.println("Result matrix:");
		for (int[] a : matrix)
		{
		    System.out.println(Arrays.toString(a));
		}
	}
}
