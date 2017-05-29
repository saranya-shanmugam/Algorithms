package com.ttu.hr.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Pairs {

	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String[] strArr = input.split(" ");
		int inputSize = Integer.parseInt(strArr[0]);
		int difference = Integer.parseInt(strArr[1]);
		
		int i = 0;
		int[] inputIntArr = new int[inputSize];
		while(i < inputSize) {
			inputIntArr[i++] = scan.nextInt();
		}
		scan.close();
		// System.out.println(Arrays.toString(inputIntArr));
		
		Arrays.sort(inputIntArr); // Instead of sorting, TreeSet can be used in the findPairs method instead of HashSet
		findPairs(inputIntArr,difference);
	}

	private static void findPairs(int[] inputIntArr,int difference) {
		HashSet<Integer> inputSet = new HashSet<>();
		for (int inputInt : inputIntArr) {
			inputSet.add(inputInt);
		}
		int count = 0;
		for(int inputInt : inputIntArr) {
			if(inputSet.contains(inputInt + difference)) {
				count++;
			} 
		}
		System.out.println(count);
	}
}

