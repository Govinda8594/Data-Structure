package com.datastructure.stringarryoperation;

import java.util.Scanner;

public class LastDigitMultiplicationInArray {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int K = s.nextInt();
		int[] A = new int[K];
		int lastdigit = 0;
		int result = 1;
		for (int i = 0; i <= A.length - 1; i++) {
			A[i] = s.nextInt();
		}
		for (int i = 0; i <= A.length - 1; i++) {
			lastdigit = A[i] % 10;
			result *= lastdigit;

		}
		System.out.println("modulo " + result);

	}

}
