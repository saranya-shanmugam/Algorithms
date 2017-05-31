package com.ttu.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class StringAnagrams {

	public static void main(String[] args) {
		StringAnagrams permutationOfOther = new StringAnagrams();
		permutationOfOther.checkPermutations("ab c", "bca");
		permutationOfOther.checkPermutations1("a   bc", "bca");
		permutationOfOther.checkPermutationsWithHashMap("aA   bc", "bbca");
	}

	/**
	 * check Anagrams
	 */
	private void checkPermutations(String str1, String str2) {
		if (str1 == null || str2 == null) {
			System.out.println("Not anagrams");
			return;
		}
		/*
		 * // If spaces are considered if(str1.length() != str2.length()) {
		 * System.out.println("Not anagrams"); return; }
		 */
		char[] strLower1 = str1.replace(" ", "").toLowerCase().toCharArray();
		char[] strLower2 = str2.replace(" ", "").toLowerCase().toCharArray();

		if (strLower1.length != strLower2.length) {
			System.out.println("Not anagrams");
			return;
		}

		Arrays.sort(strLower1);
		Arrays.sort(strLower2);
		// Can use any of the below methods of Arrays class
		if (Arrays.equals(strLower1, strLower2)) {
			System.out.println("Anagrams");
			return;
		}
		/*
		 * if(Arrays.toString(strLower1).equals(Arrays.toString(strLower2))){
		 * System.out.println("Anagrams"); return; }
		 */
		System.out.println("Not Anagrams");
	}

	/**
	 * ASCII - check Anagrams - needn't sort as above
	 * 
	 * @param str1
	 * @param str2
	 */
	private void checkPermutations1(String str1, String str2) {

		if (str1 == null || str2 == null) {
			System.out.println("Not anagrams");
			return;
		}
		/*
		 * // If spaces are considered if(str1.length() != str2.length()) {
		 * System.out.println("Not anagrams"); return; }
		 */

		String strLower1 = str1.replaceAll("\\s", "").toLowerCase();
		String strLower2 = str2.replaceAll("\\s+", "").toLowerCase();

		if (strLower1.length() != strLower2.length()) {
			System.out.println("Not anagrams");
			return;
		}

		// ASCII
		int[] charCount = new int[256];
		for (int i = 0; i < strLower1.length(); i++) {
			charCount[strLower1.charAt(i)]++;
			charCount[strLower2.charAt(i)]--;
		}
		for (int i = 0; i < charCount.length; i++) {
			if (charCount[i] != 0) {
				System.out.println("Not Anagrams");
				return;
			}
		}
		System.out.println("Anagrams");
	}

	/**
	 * After processing the strings to remove the spaces and checking the length, use a hashmap to keep track of 
	 * count of characters in each string. Increase the count for string one and decrease the count for string two
	 * thereby the hashmap entries will not have any zeroes for anagrams
	 * 
	 * Can be used for ASCII or UNICODE
	 * @param str1
	 * @param str2
	 */
	private void checkPermutationsWithHashMap(String str1, String str2) {

		if (str1 == null || str2 == null) {
			System.out.println("Not anagrams");
			return;
		}
		/*
		 * // If spaces are considered if(str1.length() != str2.length()) {
		 * System.out.println("Not anagrams"); return; }
		 */

		String strLower1 = str1.replaceAll(" ", "").toLowerCase();
		String strLower2 = str2.replaceAll(" ", "").toLowerCase();

		if (strLower1.length() != strLower2.length()) {
			System.out.println("Not anagrams");
			return;
		}
		
		HashMap<Character, Integer> charCount = new HashMap<>();
		Character char1, char2;
		Integer count;
		for (int i = 0; i < strLower1.length(); i++) {
			char1 = strLower1.charAt(i);
			char2 = strLower2.charAt(i);
			count = charCount.get(char1);
			if (count == null) {
				charCount.put(char1, 1);
			} else {
				charCount.put(char1, count + 1);
			}

			count = charCount.get(char2);
			if (count == null) {
				charCount.put(char2, -1);
			} else {
				charCount.put(char2, count - 1);
			}
		}

		Set<Entry<Character, Integer>> countEntrySet = charCount.entrySet();
		for (Entry<Character, Integer> entry : countEntrySet) {
			if (entry.getValue() != 0) {
				System.out.println("Not Anagrams");
				return;
			}
		}
		System.out.println("Anagrams");
	}
}
