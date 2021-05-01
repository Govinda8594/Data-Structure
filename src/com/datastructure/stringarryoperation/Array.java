package com.datastructure.stringarryoperation;

// Vector ^ 100% -> Synchronized -> only one thread can access at one time
// ArrayList ^ 50% -> NonSynchronized -> mutiple thread can access at one time
public class Array {
//	array of items
	private int[] items;

//	keep track of item
	private int count;

	public Array(int length) {
		items = new int[length];
	}

	public void insert(int item) {
//		If array size is full
		if (items.length == count) {

//			create new array of twice the size
			int[] newItems = new int[count * 2];

//			copy the old array to new array and assign to old array
			for (int i = 0; i < count; i++) {
				newItems[i] = items[i];
				items = newItems;

			}
		}
//		If new item is inserted
		items[count++] = item;
	}

	public void removeAt(int index) {
//		validate index at which to remove item
		if (index < 0 || index >= count)
			throw new IllegalArgumentException();
//		shift the item index = 1
//		1 -> 2
//		2 -> 3
		for (int i = index; i < count; i++) {
			items[i] = items[i + 1];
		}
//		decrement count
		count--;
	}

	public int indexOf(int item) {
//		O(n)
//		If we find it,return index
		for (int i = 0; i < count; i++) {
			if (items[i] == item) {
				return i;
			}

		}
//		else return -1
		return -1;
	}

	public void print() {
		for (int i = 0; i < count; i++) {
			System.out.println(items[i]);
		}
	}

	public static void main(String[] args) {
		Array number = new Array(3);
		number.insert(5);
		number.insert(2);
		number.insert(1);
		number.insert(8);
		System.out.println(number.indexOf(1));
		number.print();
	}

}
