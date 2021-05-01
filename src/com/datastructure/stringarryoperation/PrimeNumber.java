package com.datastructure.stringarryoperation;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

//Java program to print 
//all primes less than N 
public class PrimeNumber {
//	function check whether 
	// a number is prime or not
	static boolean isPrime(int n) {
		// Corner case
		if (n <= 1)
			return false;

		// Check from 2 to n-1
		for (int i = 2; i < n; i++)
			if (n % i == 0)
				return false;

		return true;
	}

	// Function to print primes
	static void printPrime(int n) {
		for (int i = 2; i <= n; i++) {
			if (isPrime(i))
				System.out.print(i + " ");
		}
	}

	// Driver Code
	public static void main(String[] args) {
		int n = 7;
		printPrime(n);
	}

	// Declarative approach
	private static boolean isPrime1(int number) {
		return number > 1 && IntStream.range(2, number).noneMatch(index -> number % index == 0);
	}

	private static boolean isPrime2(int number) {
		IntPredicate isDivisible = index -> number % index == 0;

		return number > 1 && IntStream.range(2, number).noneMatch(isDivisible);
	}
}
