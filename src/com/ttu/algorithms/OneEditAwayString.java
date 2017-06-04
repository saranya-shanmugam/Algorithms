package com.ttu.algorithms;

import java.util.HashMap;
import java.util.Map.Entry;

public class OneEditAwayString {
	public static void main(String[] args) {
		OneEditAwayString oneEditAway = new OneEditAwayString();
		oneEditAway.isOneEditAway("Pales", "pale");
	}

	private void isOneEditAway(String str1, String str2) {
		if(str1.toLowerCase().equals(str2.toLowerCase())) {
			System.out.println("Both strings are same");
			return;
		}
		HashMap<Character, Integer> charCount = new HashMap<>();
		fillCharMap(charCount, str1, 1);
		fillCharMap(charCount, str2, -1);

		boolean oneCounted = false, negativeCounted = false;
		for (Entry<Character, Integer> entry : charCount.entrySet()) {
			if (entry.getValue() == 1) {
				if (!oneCounted) {
					oneCounted = true;
				} else {
					System.out.println("Not valid for one edit check");
					return;
				}
			} else if (entry.getValue() == -1) {
				if (!negativeCounted) {
					negativeCounted = true;
				} else {
					System.out.println("Not valid for one edit check");
					return;
				}
			}
		}
		if ((oneCounted && negativeCounted)) {
			System.out.println("Edit");
		} else if (oneCounted) {
			System.out.println("Remove");
		} else if (negativeCounted) {
			System.out.println("Insert");
		}
	}

	private void fillCharMap(HashMap<Character, Integer> charCount, String str1, int incrementOrDecrement) {
		Character ch;
		Integer count;
		for (int i = 0; i < str1.length(); i++) {
			ch = str1.toLowerCase().charAt(i);
			count = charCount.get(ch);
			if (count != null) {
				charCount.put(ch, count + incrementOrDecrement);
				continue;
			} else {
				charCount.put(ch, incrementOrDecrement);
			}
		}
	}
}
