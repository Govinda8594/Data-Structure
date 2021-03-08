package com.datastructure;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {
	private final List<Character> rightBracket = Arrays.asList(')', '>', ']', '}');
	private final List<Character> leftBracket = Arrays.asList('(', '<', '[', '{');

	public boolean isBalanced(String input) {
		Stack<Character> stack = new Stack<Character>();
		for (char ch : input.toCharArray()) {
			if (isLeftBracket(ch)) {
				stack.push(ch);
			}
			if (isRightBracket(ch)) {
				if (stack.empty())
					return false;
				var top = stack.pop();
				if (bracketsMatch(ch, top)) {
					return false;
				}

			}
		}
		return stack.empty();
	}

	private boolean bracketsMatch(char right, char left) {
		return leftBracket.indexOf(left) == rightBracket.indexOf(right);
	}

	private boolean isRightBracket(char ch) {

		return rightBracket.contains(ch);
	}

	private boolean isLeftBracket(char ch) {

		return leftBracket.contains(ch);
	}
}
