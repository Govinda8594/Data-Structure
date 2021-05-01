package com.datastructure.stringarryoperation;

import java.util.Scanner;

public class SmallestAndLargestSubString {
	String from0To255 = "(25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])";
	String pattern = String.format("%s.%s.%s.%s", from0To255, from0To255, from0To255, from0To255);

	public static String getSmallestAndLargest(String s, int k) {
		String smallest = "";
		String largest = "";

		// Complete the function
		// 'smallest' must be the lexicographically smallest substring of length 'k'
		// 'largest' must be the lexicographically largest substring of length 'k'
		for (int i = 0; i <= s.length() - k; i++) {
			String substring = s.substring(i, i + k);
			if (i == 0)
				smallest = substring;
			if (substring.compareTo(largest) > 0)
				largest = substring;
			else if (substring.compareTo(smallest) < 0)
				smallest = substring;
		}
		return smallest + "\n" + largest;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String IP = in.next();
			System.out.println(IP.matches(new SmallestAndLargestSubString().pattern));
		}

	}
}
