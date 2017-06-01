package com.ttu.hr.warmup;

import java.util.Scanner;

/**
 * Min-Max Sum - Find sum and subtract min and max value to get max and min sum value respective of all values except one 
 *
 */
public class MinMaxSum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long a = in.nextLong();
		long b = in.nextLong();
		long c = in.nextLong();
		long d = in.nextLong();
		long e = in.nextLong();
		in.close();
		
		long sum = 0l;
		long[] longArr = { a, b, c, d, e };
		long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
		for (long longValue : longArr) {
			sum += longValue;
			if (longValue < min) {
				min = longValue;
			}
			if (longValue > max) {
				max = longValue;
			}
		}
		System.out.println((sum - max) + " " + (sum - min));
	}
}
