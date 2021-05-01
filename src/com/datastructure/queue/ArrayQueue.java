package com.datastructure.queue;

import java.util.Arrays;

public class ArrayQueue {
	private int[] items;
	private int rear;
	private int count;
	private int front;

	public ArrayQueue(int capacity) {
		items = new int[capacity];
	}

	public void enqueue(int item) {
		if (count == items.length)
			throw new IllegalStateException();
		items[rear] = item;
//		circular array => setting rear 
		rear = (rear + 1) % items.length;
		count++;
	}

	public int dequeue() {
		var item = items[front];
		items[front] = 0;
		front = (front + 1) % items.length;
		count--;
		return item;

	}

	@Override
	public String toString() {
		return Arrays.toString(items);
	}

	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(5);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(50);
		queue.enqueue(60);
		queue.dequeue();
		queue.enqueue(70);
		queue.enqueue(80);
		queue.dequeue();
		queue.enqueue(90);
		System.out.println(queue.toString());

	}

}
