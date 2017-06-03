package com.ttu.hr.implementation;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/apple-and-orange

public class AppleAndOrange {

	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int s = in.nextInt();
	        int t = in.nextInt();
	        int a = in.nextInt();
	        int b = in.nextInt();
	        int m = in.nextInt();
	        int n = in.nextInt();
	        int[] apple = new int[m];
	        for(int apple_i=0; apple_i < m; apple_i++){
	            apple[apple_i] = in.nextInt();
	        }
	        int[] orange = new int[n];
	        for(int orange_i=0; orange_i < n; orange_i++){
	            orange[orange_i] = in.nextInt();
	        }
	        in.close();
	        int countApple = 0, countOrange = 0;
	        int dist;
	        for(int appDist: apple) {
	            dist = appDist + a;
	           if(dist >= s && dist <= t)
	            countApple++;
	        }
	        
	        for(int orDist: orange) {
	              dist = orDist + b;
	           if(dist >= s && dist <= t)
	            countOrange++;
	        }
	        System.out.println(countApple);
	        System.out.println(countOrange);
	    }
}
