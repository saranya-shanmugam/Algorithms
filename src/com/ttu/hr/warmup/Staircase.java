package com.ttu.hr.warmup;

import java.util.Scanner;

public class Staircase {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		buildStaircase(n);
       
		// Another approach
		int spaceCnt = 0;
        for (int i = 0; i < n; i++) {
            spaceCnt = n - (i + 1);
            System.out.print(new String(new char[spaceCnt]) + new String(new char[n - spaceCnt]).replace("\0", "#") + "\n");
        }
		scan.close();
	}

	private static void buildStaircase(int n) {
		if (n <= 0)
			return;
		int j = n - 1;
		while (j >= 0) {
			for (int i = 0; i < n; i++) {
				if (i < j) {
					System.out.print(" ");
				} else {
					System.out.print("#");
				}
			}
			System.out.println();
			j--;
		}
	}
}

