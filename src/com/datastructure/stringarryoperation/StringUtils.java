package com.datastructure.stringarryoperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class StringUtils {
	public static int countVowels(String str) {
		if (str == null)
			return -1;
		String vowels = "aeiou";
		int count = 0;
		for (var ch : str.toLowerCase().toCharArray()) {
			if (vowels.contains(Character.toString(ch)))
				count++;
		}
		return count;
	}

//  1st way to reverse
	public static String reverse(String str) {
		Stack<Character> wordToReverse = new Stack<>();
		List<Character> reversed = new ArrayList<Character>();
		for (Character ch : str.toCharArray()) {
			wordToReverse.push(ch);
		}
		for (int i = wordToReverse.size() - 1; i >= 0; i--) {
			reversed.add(wordToReverse.pop());
		}

		return wordToReverse.toString();
	}

//	2nd way to reverse
	private static String reverse2(String str) {
		if (str == null)
			return "";
		StringBuilder reversed = new StringBuilder();

		for (int i = str.length() - 1; i >= 0; i--) {
			reversed.append(str.charAt(i));

		}
		return reversed.toString();
	}

	public static String reverseWords(String sentence) {
		if (sentence == null)
			return "";
		String[] words = sentence.trim().split(" ");
		Collections.reverse(Arrays.asList(words));
		return String.join(" ", words);
//	StringBuilder reversed = new StringBuilder();
//	for (int i = words.length-1; i >= 0; i--) 
//		reversed.append(words[i]+" ");
//	
//	return reversed.toString().trim();
	}

	public static boolean areRotation(String str1, String str2) {
		if (str1 == null || str2 == null)
			return false;
		return (str1.length() == str2.length() && (str1 + str2).contains(str2));

	}

	public static String removeDuplicates(String str) {
		if (str == null)
			return "";

		StringBuilder output = new StringBuilder();

		Set<Character> seen = new HashSet<>();
		for (var ch : str.toCharArray()) {
			if (!seen.contains(ch)) {
				seen.add(ch);
				output.append(ch);
			}
		}
		return output.toString();
	}

	public static char getMaxOccuringChar(String str) {
		if (str == null || str.isEmpty())
			throw new IllegalArgumentException();
		final int ASCII_SIZE = 256;
		int[] frequencies = new int[ASCII_SIZE];
		for (var ch : str.toCharArray()) {
			frequencies[ch]++;
		}
		int max = 0;
		char result = ' ';
		for (int i = 0; i < frequencies.length; i++) {
			if (frequencies[i] > max) {
				max = frequencies[i];
				result = (char) i;
			}
		}
		return result;
	}

	private static Character getMaxOccuringChar2(String str) {
		Map<Character, Integer> frequencies = new HashMap<>();
		for (var ch : str.toCharArray()) {
			if (frequencies.containsKey(ch)) {
				frequencies.replace(ch, frequencies.get(ch) + 1);
			} else
				frequencies.put(ch, 1);
		}
		for (var frequency : frequencies.entrySet()) {
			if (frequency.getValue() > 1)
				return frequency.getKey();
		}
		return Character.MIN_VALUE;
	}

	public static String capitalize(String sentence) {
		if (sentence == null || sentence.trim().isEmpty())
			return "";
		String[] words = sentence.trim().replaceAll(" +", " ").split(" ");
		for (int i = 0; i < words.length; i++) {
			words[i] = words[i].substring(0, 1).toUpperCase().concat(words[i].substring(1).toLowerCase());

		}
		return String.join(" ", words);
	}

//	O(n log n)
	public static boolean areAnagram(String first, String second) {

		if (first == null || second == null || first.length() != second.length())
			return false;
//		O(n)
		var array1 = first.toCharArray();
//		O(n log n)
		Arrays.sort(array1);
		var array2 = second.toCharArray();
		Arrays.sort(array2);
		return Arrays.equals(array1, array2);
	}

	public static boolean areAnagram2(String first, String second) {

		if (first == null || second == null)
			return false;
		final int ENGLISH_ALPHABETS = 26;
		int[] frequencies = new int[ENGLISH_ALPHABETS];
//		a b c d e f g h ..
//		1 14
//		a n a g r a m m
//		0 1 2 3 4 5 6 7
//		marganaa
		first = first.toLowerCase();
//		O(n)
		for (int i = 0; i < first.length(); i++) {
			frequencies[first.charAt(i) - 'a']++;
		}
//		O(n)
		second = second.toLowerCase();
		for (int i = 0; i < second.length(); i++) {
			var index = second.charAt(i) - 'a';
			if (frequencies[index] == 0)
				return false;
			frequencies[index]--;
		}
		return true;
	}

	public static boolean isPalindrome(String word) {
//		1st way
		char[] arrayword = word.toCharArray();
		char[] reverseWord = new char[arrayword.length];

		for (int i = arrayword.length - 1; i >= 0; i--) {
			reverseWord[arrayword.length - 1 - i] = arrayword[i];
		}
		if (Arrays.equals(arrayword, reverseWord))
			System.out.println("Palindrome");
		else
			System.out.println("Not Palindrome");

//		2nd Way
		StringBuilder input = new StringBuilder(word);
		if (input.reverse().toString().equals(word))
			System.out.println("Palindrome");
		else
			System.out.println("Not Palindrome");

// 		3rd More efficient way(memory - inplace)
		if (word == null)
			return false;

		int left = 0;
		int right = word.length() - 1;
		while (left < right) {
			if (word.charAt(left++) != word.charAt(right--))
				return false;
		}
		return true;

	}

	public static void main(String[] args) {
		var word = "iloveprogramming";
		var count = StringUtils.isPalindrome("");
		System.out.println(count);

		isPalindrome("bnanb");
		String reversed = StringUtils.reverse(word);
		System.out.println(reversed);
		System.out.println(reverse2(word));

		System.out.println(getMaxOccuringChar2(word));
	}

}
