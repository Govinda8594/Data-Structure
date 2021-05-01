package com.datastructure.linkedlist;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class LinkedList {
// Inner class for implementation details
	private class Node {
		private int value;
		private Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	private Node first;
	private Node last;
	private int size;

	public void addLast(int item) {
		var node = new Node(item);
//		if list is empty or not->update last node
		if (isEmpty()) {
			first = last = node;
		} else {
			last.next = node;
			last = node;
		}

		size++;
	}

	public void addFirst(int item) {

		var node = new Node(item);
//		if empty or not->update first node
		if (isEmpty()) {
			first = last = node;
		} else {
			node.next = first;
			first = node;
		}
		size++;
	}

	private boolean isEmpty() {
		return first == null;
	}

	public int indexOf(int item) {
//		to keep track of node
		int index = 0;
//		to keep tract of current node
		var current = first;
//		untill current not pointing to null
		while (current != null) {
//			if value contains return index 
			if (current.value == item)
				return index;
//			else update current and index
			current = current.next;
			index++;
		}
		return -1;
	}

	public boolean contains(int item) {
//		when item doesn't exits
		return indexOf(item) != -1;
	}

	public void removeFirst() {
//		check if empty
		if (isEmpty())
			throw new NoSuchElementException();
//		check if there is only one item
		if (first == last) {
			first = last = null;
		} else {
			var second = first.next; // store second item
			first.next = null; // unlink the reference
			first = second; // set as first item
		}
		size--;
	}

	public void removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		if (first == last) {
			first = last = null;

		} else {
//			store previous
			var previous = getPrevious(last);
//			set previous to last
			last = previous;
//			unlink the last item
			last.next = null;
		}
		size--;

	}

	private Node getPrevious(Node node) {
//		store first item
		var current = first;
//		untill current is not empty
		while (current != null) {
//			get previous item to last item and return or continue
			if (current.next == node) {
				return current;
			}
			current = current.next;

		}
//		no item exists
		return null;
	}

	public int size() {
		return size;
	}

	public int[] toArray() {
		int[] array = new int[size];
//		store first item
		var current = first;
		var index = 0; // track index of item
		while (current != null) {
//			set item to index 
			array[index++] = current.value;
//			move forward
			current = current.next;
		}
		return array;
	}

	public void reverse() {
		if (isEmpty())
			return; // f l
//		store first two items    [10 -> 20 -> 30]
		var previous = first;// p c n
		var current = first.next;
//		untill current is not empty
		while (current != null) {
//			maintain the third item
			var next = current.next;
//			previous is set to current.next
			current.next = previous; // [10 <- 20 -> 30]
			previous = current; // p c n set to c to p
			current = next;
		} // l f
		last = first; // [10 <- 20 <- 30]
		last.next = null;
		first = previous;
	}

	public int getKthNode(int k) {
//		(k-l) distance apart to find kth node in one pass
//		if k = 3 => (3-1) => 2 distance apart			
		if (isEmpty())
			throw new IllegalStateException();
		var a = first;
		var b = first;
		for (int i = 0; i < k - 1; i++) {
			b = b.next; // [10 -> 20 -> 30 -> 40 -> 50]
						// a b
			if (b == null) {
				throw new IllegalArgumentException();
			}
		}
		while (b != last) {
			b = a.next;
			b = b.next;
		}

		return a.value;
	}

	public static void main(String[] args) {
		var list = new LinkedList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.removeLast();
		System.out.println();
		System.out.println(list.contains(10));
		list.removeLast();
		System.out.println(list.size());
		var array = list.toArray();
		System.out.println(Arrays.toString(array));

	}

}
