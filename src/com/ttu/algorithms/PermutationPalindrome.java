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
}

