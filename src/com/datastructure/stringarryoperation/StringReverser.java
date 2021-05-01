package com.datastructure.stringarryoperation;

import java.util.Stack;

public class StringReverser {
	public String reverse(String input) {
		if (input == null) {
			throw new NullPointerException();
		}
		Stack<Character> stack = new Stack<>();

//		Other way to push
//		for(int i= 0;i<input.length();i++) {
//			stack.push(input.charAt(i));
//		}

		for (char ch : input.toCharArray()) {
			stack.push(ch);
		}
		StringBuffer reversed = new StringBuffer();
		while (!stack.empty()) {
			reversed.append(stack.pop());
		}
		return reversed.toString();
	}

	public static void main(String[] args) {
		String str = "(1+2)";
		StringReverser reverser = new StringReverser();
		System.out.println(reverser.reverse(str));
	}

}
