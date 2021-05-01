package com.datastructure.stack;

import java.util.Arrays;

public class Stack {
	private int[] items = new int[5];
	private int count;

	public void push(int item) {
		if (count == items.length)
			throw new StackOverflowError();
		items[count++] = item;

	}

	public int pop() {
		if (count == 0)
			throw new IllegalStateException();
		return items[--count];
	}

	public int peek() {
		if (count == 0)
			throw new IllegalStateException();
		return items[count - 1];
	}

	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public String toString() {
		var content = Arrays.copyOfRange(items, 0, count);
		return Arrays.toString(content);
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.pop();

		System.out.println(stack.peek());
		stack.pop();
	}
}
