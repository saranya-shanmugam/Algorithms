package com.ttu.hr.implementation;

import java.util.Scanner;

/**
 * Any grade less than 40 is a failing grade.
 * If the difference between the grade and the next multiple of 5 is less than 3, round up to the next multiple of 5.
 * If the value of grade is less than 38, no rounding occurs as the result will still be a failing grade. 
 */
public class GradingMethod {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] grades = new int[n];
		for (int grades_i = 0; grades_i < n; grades_i++) {
			grades[grades_i] = in.nextInt();
		}
		in.close();
		int[] result = solve(grades);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	private static int[] solve(int[] grades) {
		 int[] outputGrades = new int[grades.length];
	        int remainder, grade;
	        for(int i = 0; i < grades.length ; i++) {
	             grade = grades[i];
	            if(grade < 38)  {
	                outputGrades[i] = grade;
	                continue;
	            }
	            remainder = grade % 5;
	            if(remainder >= 3) {
	                outputGrades[i] = grade + (5-remainder);
	                }  else {
	                outputGrades[i] = grade;
	            }
	            }
	        
	        return outputGrades;
	}

}
