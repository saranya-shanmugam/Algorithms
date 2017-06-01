package com.ttu.algorithms;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Checks the given String if it is a permutation of a palindrome 
 *
 */
public class PermutationPalindrome {

	public static void main(String[] args) {
		PermutationPalindrome permutationPalindrome = new PermutationPalindrome();
		permutationPalindrome.checkPermutationOfAPalindrome("Tact Coa");
		permutationPalindrome.checkPermutationOfAPalindromeASCII("Tact/. Coa");
		permutationPalindrome.checkPermutationOfAPalindromeOnTheGo("Tact oCoa");
	}

	/**
	 * Checks the given String if it is a permutation of a palindrome
	 * It works nevertheless the String is of ASCII or UNICODE characters
	 * @param string
	 */
	private void checkPermutationOfAPalindrome(String str) {
		HashMap<Character, Integer> charCountMap = new HashMap<>();
		Character ch;
		Integer count;
		String strLower = str.toLowerCase().replaceAll(" ", "");
		for(int i = 0; i < strLower.length(); i++) {
			ch = strLower.charAt(i);
			count = charCountMap.get(ch);
			if(count == null) {
				charCountMap.put(ch, 1);
				continue;
			}
			charCountMap.put(ch, count + 1);
		}
		
		boolean oneOddAllowed = false;
		for(Entry<Character, Integer> entry:charCountMap.entrySet()) {
			if(entry.getValue() % 2 == 0) continue;
			if(!oneOddAllowed) {
				oneOddAllowed = true;
				continue;
			}
			System.out.println("No permutation of a palindrome");
			return;
		}
		System.out.println("Permutation of a palindrome is available");
	}
	
	/**
	 * Checks the given String if it is a permutation of a palindrome
	 * Considering only the ASCII characters to form a permutation of palindrome
	 * @param string
	 */
	private void checkPermutationOfAPalindromeASCII(String str) {
		HashMap<Character, Integer> charCountMap = new HashMap<>();
		Character ch;
		Integer count;
		String strLower = str.toLowerCase().replaceAll(" ", "");
		for(int i = 0; i < strLower.length(); i++) {
			ch = strLower.charAt(i);
			if(!isChar(ch)) continue;
			count = charCountMap.get(ch);
			if(count == null) {
				charCountMap.put(ch, 1);
				continue;
			}
			charCountMap.put(ch, count + 1);
		}
		
		boolean oneOddAllowed = false;
		for(Entry<Character, Integer> entry:charCountMap.entrySet()) {
			if(entry.getValue() % 2 == 0) continue;
			if(!oneOddAllowed) {
				oneOddAllowed = true;
				continue;
			}
			System.out.println("No permutation of a palindrome");
			return;
		}
		System.out.println("Permutation of a palindrome is available");
	}

	/**
	 * Checks if it is a lower case ASCII character
	 * @param ch
	 * @return
	 */
	private boolean isChar(Character ch) {
		if('a' <= ch && ch <= 'z') {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks the given String if it is a permutation of a palindrome
	 * Keeps track of a countOdd variable value which is incremented if the count of a particular character is odd
	 * and decremented if it is even. 
	 * This method does not use extra operation to check the count after populating the map as above methods.
	 * @param string
	 */
	private void checkPermutationOfAPalindromeOnTheGo(String str) {
		Character ch;
		int count, countOdd = 0;
		int[] charCount = new int[26]; // lowercase a - z 
		String strLower = str.toLowerCase().replaceAll(" ", "");
		for(int i = 0; i < strLower.length(); i++) {
			ch = strLower.charAt(i);
			if(!isChar(ch)) continue;
			count = ++charCount[ch - 'a'];
			if(count % 2 == 1) {
				countOdd++;
			} else {
				countOdd--;
			}
		}
		if(countOdd <= 1) {
			System.out.println("Permutation of a palindrome is available");
		} else {
			System.out.println("No permutation of a palindrome");
		}
	}
}
