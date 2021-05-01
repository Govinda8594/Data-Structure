package com.datastructure.heap;

import java.util.Arrays;

public class MaxHeap {

	public static void heapify(int[] array) {
		var lastParentIndex = array.length / 2 - 1;
		for (int i = lastParentIndex; i >= 0; i--) {
			heapify(array, i);
		}
	}

	private static void heapify(int[] array, int index) {
		var largerIndex = index;
		var leftIndex = index * 2 + 1;
		if (leftIndex < array.length && array[leftIndex] > array[largerIndex])
			largerIndex = leftIndex;

		var rightIndex = index * 2 + 2;
		if (rightIndex < array.length && array[rightIndex] > array[leftIndex])
			largerIndex = rightIndex;
		if (index == largerIndex)
			return;
		swap(array, index, largerIndex);
		heapify(array, largerIndex);
	}

	public static void swap(int[] array, int first, int second) {
		var temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}

	public static int getKthLargest(int[] array, int k) {
		if (k < 1 || k > array.length)
			throw new IllegalStateException();
		var heap = new Heap();
		for (var i : array) {
			heap.insert(i);
		}
		for (int i = 0; i < k - 1; i++) {
			heap.remove();
		}
		return heap.max();
	}

	public static void main(String[] args) {
		int[] numbers2 = { 5, 3, 8, 4, 1, 2 };
		MaxHeap.heapify(numbers2);
		System.out.println(Arrays.toString(numbers2));
		System.out.println(MaxHeap.getKthLargest(numbers2, 1));
	}
}
