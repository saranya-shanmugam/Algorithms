package com.ttu.algorithms;

public class URLModify  {

	public static void main(String[] args) {
		URLModify modifyURL = new URLModify();
		modifyURL.doModifyURL("Mr John Smith  ", 13);
		modifyURL.doModifyURLInPlace("Mr John Smith  ", 13);
	}

	/**
	 * This method replaces space by %20 in-place
	 * @param string
	 * @param length
	 */
	private void doModifyURLInPlace(String str, int length) {
		int count = 0;
		for (int i = 0; i < length; i++) {
			if (str.charAt(i) == ' ') {
				count++;
			}
		}
		if(count == 0) {
			System.out.println(str);
			return;
		}
		
		int index = length + 2*count;
		
		// Assuming this char array(string with extra space) is already available, we manipulate it in-place to replace space with %20
		char[] charArr = new char[index];
		for (int i = 0; i < length; i++) {
			charArr[i] = str.charAt(i);
		}
		for(int i = length-1; i >= 0; i--) {
			if(charArr[i] == ' ') {
				charArr[--index] = '0';
				charArr[--index] = '2';
				charArr[--index] = '%';
				continue;
			}
			charArr[--index] = charArr[i]; 
		}
		System.out.println(String.valueOf(charArr));
	}

	/**
	 * This method creates a new char array and copies the characters of the given string into it by
	 * replacing space by %20.
	 * @param str
	 * @param length
	 */
	private void doModifyURL(String str, int length) {
		// System.out.println(str.replaceAll(" ", "%20"));
		int count = 0;
		for (int i = 0; i < length; i++) {
			if (str.charAt(i) == ' ') {
				count++;
			}
		}
		if(count == 0) {
			System.out.println(str);
			return;
		}
		char[] charArr = new char[length + 2*count];
		int j = 0;
		for (int i = 0; i < length; i++) {
			if (str.charAt(i) == ' ') {
				charArr[j++] = '%';
				charArr[j++] = '2';
				charArr[j++] = '0';
				continue;
			}
			charArr[j++] = str.charAt(i);
		}
		System.out.println(String.valueOf(charArr));
	}

}
