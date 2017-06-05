package com.ttu.hr.implementation;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/breaking-best-and-worst-records
public class BreakingRecords {

	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int[] s = new int[n];
	        for(int s_i=0; s_i < n; s_i++){
	            s[s_i] = in.nextInt();
	        }
	        in.close();
	        int[] result = getRecord(s);
	        String separator = "", delimiter = " ";
	        for (Integer val : result) {
	            System.out.print(separator + val);
	            separator = delimiter;
	        }
	        System.out.println("");
	    }
	 
	 private static int[] getRecord(int[] s){
		 int min = s[0], max = s[0];
		 int minCount = 0, maxCount = 0;
	        for(int i = 1; i < s.length; i++) {
	        	if(s[i] > max) {
	        		max = s[i];
	        		maxCount ++;
	        	} else if(s[i] < min) {
	        		min = s[i];
	        		minCount++;
	        	}
	        }
	        return new int[]{maxCount, minCount};
	    }
}
