package com.datastructure.algorithm;

import java.util.Arrays;

public class BubbleSort {
	public void sort(int[] array) {
		boolean isSorted;
		for (var i = 0; i < array.length; i++) {
			isSorted = true;
			for (var j = 1; j < array.length - i; j++) {
				if (array[j] < array[j - 1]) {
					swap(array, j);
					isSorted = false;
				}
				if (isSorted)
					return;
			}
		}
	}

	private void swap(int[] array, int j) {
		var temp = array[j];
		array[j] = array[j - 1];
		array[j - 1] = temp;
	}

	public static void main(String[] args) {
		int[] numbers = { 7, 5, 4, 1, 2, 3, 1, 8 };
		var sorter = new BubbleSort();
		sorter.sort(numbers);
		System.out.println(Arrays.toString(numbers));
	}

}
