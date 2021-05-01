package com.datastructure.stringarryoperation;

/*Java program to print longest palindrome 
word in a sentence and its length*/
public class LongestPalindrome {
	// Function to check if a
	// word is palindrome
	static boolean checkPalin(String word) {
		int n = word.length();

		// making the check case
		// case insensitive
		word = word.toLowerCase();

		// loop to check palindrome
		for (int i = 0; i < n; i++, n--)
			if (word.charAt(i) != word.charAt(n - 1))
				return false;

		return true;
	}

	// Function to find longest
	// palindrome word
	static String longestPalin(String str) {
		// to check last word for palindrome
		str = str + " ";

		// to store each word
		String longestword = "", word = "";

		int length, length1 = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			// extracting each word
			if (ch != ' ')
				word = word + ch;
			else {
				length = word.length();
				if (checkPalin(word) && length > length1) {
					length1 = length;
					longestword = word;
				}

				word = "";
			}
		}

		return longestword;
	}

	// Driver code
	public static void main(String args[]) {
		String s = new String("My name is ava " + "and i love Geeksforgeeks");

		if (longestPalin(s) == "")
			System.out.println("No Palindrome" + " Word");
		else
			System.out.println(longestPalin(s));
	}
}
