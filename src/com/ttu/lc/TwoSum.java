package com.ttu.lc;

import java.util.Arrays;
import java.util.HashMap;

// Two sum - target should add to two given numbers in the array. Return the indices of those two numbers.
public class TwoSum {

	public static void main(String[] args) {
	int num[] =	twoSum(new int[]{3,2,4}, 6);
	System.out.println(Arrays.toString(num));
	}
	
	// https://leetcode.com/problems/two-sum/#/description
	static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> intValIndexMap = new HashMap<>();
        int num1, num2;
        for(int i = 0; i < nums.length ; i++) {
        	num1 = nums[i];
        	num2 = target - num1;
        	if(intValIndexMap.containsKey(num2)) {
        		return new int[]{intValIndexMap.get(num2),i};
        	} else {
        		intValIndexMap.put(num1,i);
        	}
        }
        return new int[]{};
    }
}
