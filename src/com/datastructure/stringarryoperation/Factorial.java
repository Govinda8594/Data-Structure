package com.datastructure.stringarryoperation;

public class Factorial {

	public static int factorial(int n) {
//		recusive method
		if (n == 0)
			return 1;
		return n * factorial(n - 1);
	}

	public static void main(String[] args) {
		System.out.println(factorial(5));
		System.out.println(factorial2(6));
	}

	private static int factorial2(int n) {
//		2nd method
		var factorial = 1;
		for (int i = n; i > 1; i--) {
			factorial *= i;
		}
		return factorial;
	}
}
