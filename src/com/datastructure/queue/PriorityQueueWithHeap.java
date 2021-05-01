package com.datastructure.queue;

import com.datastructure.heap.Heap;

public class PriorityQueueWithHeap {
	private Heap heap = new Heap();

	public void enqueue(int item) {
		heap.insert(item);
	}

	public int dequeue() {
		return heap.remove();
	}

	public boolean isEmpty() {
		return heap.isEmpty();
	}

	public static void main(String[] args) {
		PriorityQueue queue = new PriorityQueue();
		queue.add(5);
		queue.add(3);
		queue.add(6);
		queue.add(1);
		queue.add(4);
		var removexd = queue.remove();
		System.out.println(removexd);
		System.out.println(queue);
		while (!queue.isEmpty()) {
			System.out.println(queue.toString());

		}
	}
}
