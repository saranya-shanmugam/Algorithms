package com.ttu.hr.implementation;

import java.util.Scanner;

public class BirthdayChocolate {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] s = new int[n];
		for (int s_i = 0; s_i < n; s_i++) {
			s[s_i] = in.nextInt();
		}
		int d = in.nextInt();
		int m = in.nextInt();
		in.close();
		int result = solve(n, s, d, m);
		System.out.println(result);

		result = solveInLessTime(n, s, d, m);
		System.out.println(result);
	}

	static int solveInLessTime(int n, int[] s, int d, int m) {
		int count = 0;
		for (int i = 1; i < s.length; i++) {
			s[i] += s[i - 1];
		}
		if (m <= n && s[m - 1] == d) {
			count++;
		}

		for (int i = m; i < s.length; i++) {
			if ((s[i] - s[i - m]) == d) {
				count++;
			}
		}
		return count;
	}

	static int solve(int n, int[] s, int d, int m) {
		int sum = 0, count = 0;
		for (int i = 0; i <= s.length - m; i++) {
			sum = 0;
			for (int j = 0; j < m; j++) {
				sum += s[j + i];
			}
			if (sum == d) {
				count++;
			}
		}
		return count;
	}

}
