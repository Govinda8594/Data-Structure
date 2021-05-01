package com.datastructure.stringarryoperation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {
	public char findFirstNonRepeatingChar(String str) {
		Map<Character, Integer> map = new HashMap<>();

		var chars = str.toCharArray();
		for (var ch : chars) {
			var count = map.containsKey(ch) ? map.get(ch) : 0;
			map.put(ch, count + 1);
		}

		for (char ch : chars) {
			if (map.get(ch) == 1)
				return ch;
		}

		System.out.println(map);
		return Character.MIN_VALUE;
	}

	public char findFirstRepeatingChar(String str) {
		Set<Character> set = new HashSet<>();

		for (char ch : str.toCharArray()) {
			if (set.contains(ch))
				return ch;
			set.add(ch);
		}
		return Character.MIN_VALUE;
	}

	public static void main(String[] args) {
		CharFinder finder = new CharFinder();
		var ch = finder.findFirstNonRepeatingChar("a green apple");
		System.out.println(ch);

		var chr = finder.findFirstRepeatingChar("green apple");
		System.out.println(chr);
	}
}
