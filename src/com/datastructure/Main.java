package com.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.println("THis ine: " + args[i]);
		}

		ArrayList<String> list = new ArrayList<>();

		// Adding elements of list
		list.add("Geeks");
		list.add("for");
		list.add("Geeks");
		list.add("Gaurav");

		// printing initial value ArrayList
		System.out.println("ArrayList: " + list);

		// print size of ArrayList
		System.out.println("Size of ArrayList = " + list.size());

		// remove all elements using clear() method
		list.clear();

		// printing ArrayList
		System.out.println("\nAfter clear\n\n" + "ArrayList: " + list);
		System.out.println("Hello World");

		String s = "Hello";
		s.concat("world");
		System.out.println(s);

		String str = "orange";
		System.out.println(hash(str));

		String[] array = { "abc", "2", "10", "0" };
		List<String> list3 = Arrays.asList(array);
//		sorting using collections
		Collections.sort(list3);
		System.out.println(list3);

		@SuppressWarnings("rawtypes")
		List list2 = new ArrayList<>();
		list2.add("abc");
		list2.add(2);
		list2.add("kaustubh");
		list2.add("Kaveri");
		list2.add("rakesh");
		Collections.sort(list2);

//		sorting other way
		list2.stream().sorted((s1, s2) -> ((String) s1).compareTo((String) s2)).collect(Collectors.toList());

		list2.sort(Comparator.comparing(String::toString));

		System.out.println(list2.get(0) instanceof Object);
		System.out.println(list2.get(1) instanceof Integer);

		String abc = "abd";
		long intStream = abc.chars().mapToLong(i -> i).sum();
		abc.chars().mapToLong(i -> i).forEach(System.out::println);

		// try playing with try-catch block and observe output
		try {
			System.out.println("hello");
			return;
//			 throw new Exception("Exception Throw");
//			 System.exit(0);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("es here");
		}

	}

	public static int hash(String key) {
		int hash = 0;
		for (var ch : key.toCharArray())
			hash += ch; // augmented addtion convert string to integer
		return hash % 100;

	}

}
