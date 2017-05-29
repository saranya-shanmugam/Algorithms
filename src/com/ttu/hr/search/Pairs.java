package com.ttu.hr.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

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
		
		findPairsWithTreeSet(inputIntArr, difference);
		
		// Instead of sorting, TreeSet(O(log N) for add/contains) was used in the findPairsWithTreeSet method instead of HashSet in findPairs
		Arrays.sort(inputIntArr); 
		findPairs(inputIntArr,difference);
	}

	/**
	 * Finds pairs in the given integer list based on the difference provided
	 * @param inputIntArr
	 * @param difference
	 */
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
	
	/**
	 * Finds pairs in the given integer list based on the difference provided
	 * @param inputIntArr
	 * @param difference
	 */
	private static void findPairsWithTreeSet(int[] inputIntArr,int difference) {
		TreeSet<Integer> inputSet = new TreeSet<>();
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

