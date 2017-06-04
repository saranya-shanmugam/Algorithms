package com.ttu.algorithms;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class StringCompression {
	public static void main(String[] args) {
		StringCompression stringCompression = new StringCompression();
		stringCompression.getCompressedString("aabcccccaaa"); //output: a2b1c5a3
		stringCompression.getCompressedString("abcd"); //output: abcd
	}
	
	private void getCompressedString(String str1) {
		Character ch,  prevCh = str1.charAt(0);
		Integer count;
		boolean isProcessString = isProcessString(str1);
		if(!isProcessString) {
			System.out.println(str1);
			return;
		}
		StringBuilder compressedString = new StringBuilder();
		LinkedHashMap<Character, Integer> charCount = new LinkedHashMap<>();
		for (int i = 0; i < str1.length(); i++) {
			ch = str1.toLowerCase().charAt(i);
			count = charCount.get(ch);
			if (count != null) {
				charCount.put(ch, count+1);
			} else {
				charCount.put(ch, 1);
			}

			if(prevCh != ch || i == str1.length()-1) {
				count = charCount.remove(prevCh);
				compressedString.append(prevCh);
				compressedString.append(count);
			}
			if(prevCh != ch && i == str1.length()-1) {
				count = charCount.remove(ch);
				compressedString.append(ch);
				compressedString.append(count);
			}
			prevCh = ch;	
		}
		System.out.println(compressedString);
	}

	/**
	 * Returns true if a character appears more than once in the given string so that the string will be compressed.
	 * 
	 * @param str1
	 * @return
	 */
	private boolean isProcessString(String str1) {
		Character ch;
		Integer count;
		HashMap<Character, Integer> charCount = new HashMap<>();
		for (int i = 0; i < str1.length(); i++) {
			ch = str1.toLowerCase().charAt(i);
			count = charCount.get(ch);
			if (count != null) {
				return true;
			} else {
				charCount.put(ch, 1);
			}
		}
		return false;
	}
}
