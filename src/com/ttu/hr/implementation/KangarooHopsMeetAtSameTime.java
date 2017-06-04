package com.ttu.hr.implementation;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/kangaroo

public class KangarooHopsMeetAtSameTime {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        in.close();
        
        if((x1 == x2 && v1 == v2) || (x1-x2 >=0 && v1-v2 >=0) || (x1-x2 <=0 && v1-v2 <=0)) {
        	System.out.println("NO");
        	return;
        }
        
        int distanceDiff = Math.abs(x1-x2);
        int speedDiff = Math.abs(v1-v2);
        
        if(distanceDiff % speedDiff == 0) {
        	System.out.println("YES");
        } else {
        	System.out.println("NO");
        }
	}
}
