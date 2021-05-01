package com.datastructure.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {
	public void sort(int[] array, int numberOfBuckets) {

		var i = 0;
		for (var bucket : createBuckets(array, numberOfBuckets)) {
			Collections.sort(bucket);
			for (var item : bucket) {
				array[i++] = item;
			}
		}
	}

	private List<List<Integer>> createBuckets(int[] array, int numberOfBuckets) {
		List<List<Integer>> buckets = new ArrayList<>();

		for (int i = 0; i < numberOfBuckets; i++) {
			buckets.add(new ArrayList<Integer>());
		}

		for (var item : array)
			buckets.get(item / numberOfBuckets).add(item);
		return buckets;
	}

	public static void main(String[] args) {
		int[] numbers = { 7, 5, 4, 1, 2, 3, 1, 8 };
		var sorter = new BucketSort();
		sorter.sort(numbers, 3);
		System.out.println(Arrays.toString(numbers));

	}
}
