package com.ttu.algorithms;

import java.util.HashSet;

public class UniqueChars {

	public static void main(String[] args) {
		UniqueChars arrAndStr = new UniqueChars();
		// Check if its a ASCII or UNICODE. here we have coded for ASCII. UNICODE takes more space but logic is same
		// Check if whitespace, case of characters need to be considered. here, different cases of same character is different
		
		//  extended ASCII - 256 characters
		// ASCII - 128 characters
		arrAndStr.stringHasUniqueChars("abcd");
		arrAndStr.stringHasUniqueCharsWithBoolean("aAbcd");
		arrAndStr.stringHasUniqueCharsBookCode("bdcba");
		arrAndStr.stringHasUniqueCharsIfUNICODE("aabcde");
	}
	
	// O(n logn) - sort the string and linearly check the String for neighboring characters

	
	private void stringHasUniqueCharsIfUNICODE(String str) {
		if(str == null) return;
		char[] charArr = str.toCharArray();
		HashSet<Character> strSet = new HashSet<>();
		for(Character c : charArr) {  //O(N) or O(C) - C - size of character set
			if(strSet.contains(c)) {  //O(1)
				System.out.println("Not unique");
				return;
			}
			strSet.add(c);
		}
		System.out.println("Unique");
	}

	/**
	 * ASCII - if given string is greater than 256 length, then its not unique.
	 * Using int array to check the count of characters and if the count is greater than one then its not unique
	 * @param str
	 */
	void stringHasUniqueChars(String str){
		// edge case
		if(str.length() > 256) System.out.println("Not unique");
		
		char[] charArr = str.toCharArray();
		int[] charCount = new int[256];
		for(char c:charArr) {
			if(charCount[c] >= 1){
				System.out.println(false);
				return;
			}
				charCount[c]++;
		}
		System.out.println(true);
	}
	
	void stringHasUniqueCharsWithBoolean(String str){
		// edge case
		if(str.length() > 256) System.out.println(false);
		
		char[] charArr = str.toCharArray();
		boolean[] charAvail = new boolean[256];
		for(char c:charArr) {
			if(charAvail[c]){
				System.out.println(false);
				return;
			}
			charAvail[c] = true;
		}
		System.out.println(true);
	}
	// bitwise to reduce space
	void stringHasUniqueCharsBookCode(String str){
		int checker = 0;
		for(int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if((checker & (1 << val)) > 0) {
				System.out.println(false);
				return;
			}
			checker |= (1 << val);
		}
		System.out.println(true);
	}
}
