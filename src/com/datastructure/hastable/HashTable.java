package com.datastructure.hastable;

// Chaining => pass key to hasing function => return index at which item to be stored
// linear probing => hasing key + i => (hash(key) + i) % table_size until find empty slot
// quadratic probing => (hash(key) + i^2) % table_size
// double hashing => (hash1(key) + i * hash2(key)) % table_size
//				  =>  hash2(key) = prime - (key%prime)
import java.util.LinkedList;

public class HashTable {
// create object of entry
	private class Entry {
		private int key;
		private String value;

		public Entry(int key, String value) {

			this.key = key;
			this.value = value;
		}

	}

	private LinkedList<Entry>[] entries = new LinkedList[5];

	public void put(int key, String value) {

		var entry = getEntry(key);
//		if entry exist or not
		if (entry != null) {
//			update value
			entry.value = value;
			return;
		}

		getOrCreateBucket(key).add(new Entry(key, value));

	}

	public String get(int key) {
		var entry = getEntry(key);
		return (entry == null) ? null : entry.value;

	}

	public void remove(int key) {
		var entry = getEntry(key);
		if (entry == null)
			throw new IllegalStateException();
		getBucket(key).remove(entry);
	}

	private LinkedList<Entry> getBucket(int key) {
//		return the bucket which itself a linkedlist
		return entries[hash(key)];
	}

	private LinkedList<Entry> getOrCreateBucket(int key) {
//		alway create new bucket or return bucket
		var index = hash(key);
		var bucket = entries[index];
		if (bucket == null) {
			entries[index] = new LinkedList<>();
		}
		return bucket;
	}

	private Entry getEntry(int key) {
		var bucket = getBucket(key);
//      check bucket is present or not
		if (bucket != null) {
			for (var entry : bucket) {
//				if present enturn entry
				if (entry.key == key) {
					return entry;
				}
			}

		}
		return null;
	}

	private int hash(int key) {
//		return the index to which to store item
		return key % entries.length;
	}

	public static void main(String[] args) {
		HashTable table = new HashTable();
		table.put(1, "A");
		table.put(2, "B");

		table.put(3, "C+");
		table.remove(2);
		System.out.println(table.get(2));
	}

}
