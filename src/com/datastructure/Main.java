package com.datastructure;

import java.util.HashMap;
import java.util.Map;


   
    public class Main {
	
	public static void isPalindrome(String word) {
		
//		char[] arrayword = word.toCharArray();
//		char[] reverseWord = new char[arrayword.length];
//
//		for (int i = arrayword.length - 1; i >= 0; i--) {
//			reverseWord[arrayword.length - 1 - i] = arrayword[i];
//		}
//		System.out.println(arrayword);
//		System.out.println(reverseWord);
//
//		if (Arrays.equals(arrayword, reverseWord)) {
//			System.out.println("Palindrome");
//		}
//
//		else {
//			System.out.println("Not Palindrome");
//		}
		
//	StringBuilder input = new StringBuilder(word);
//	if(input.reverse().toString().equals(word)) {
//		System.out.println("Palindrome");
//	}
//	else
//		System.out.println("Not Palindrome");
		
	}

	public static void main(String[] args) {
		for (int i = 0;i< args.length;i++) {
			System.out.println("THis ine: " + args[i]);
		}
//		Stack  abc = new Stack();
//		abc.add(10);
//		System.out.println(abc);
		
//		 File file = new File("D:\\input.txt"); 
//		 BufferedReader br = null;
//		  try {
//			br = new BufferedReader(new FileReader(file));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		  
//		  String st; 
//		  try {
//			  BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\output.txt"));
//			while ((st = br.readLine()) != null) {
//			
//				if(st.contains("Ubuntu, ") && !st.endsWith(st.valueOf("12.04"))) {
//					
//					    writer.write("\n"+"Ubuntu");
//					    
//					   
//				}
//				
//			}
//			 writer.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
 		Name[] names = {new Name("Navin", "Kabra"),
                new Name("Amit", "Paranjape"),
                new Name("NAVIN", "KABRA"),
                new Name("AMIT", "paranjape"),
                new Name("Navin", "Kotkar"),
                new Name("Gaurav", "Kotkar"),
                new Name("Gaurav", "KOTKAR")};
 Map<Name,Integer> hash = new HashMap<Name,Integer>();
 for(Name n: names) {
    Integer numOccurrences = hash.get(n);
    if (numOccurrences != null) {
        hash.put(n, numOccurrences + 1);
    } else {
        hash.put(n,1);
    }
 }
 System.out.println(hash.toString()+"\n");
 for (Name name : names) {
	System.out.println(name);
}
// printDuplicates(hash);

//		int[] numbers = new int[3];
//		numbers[0]=10;
//		int[] numbers = { 10, 20, 30 };
//		System.out.println(numbers.length);
//		System.out.println(Arrays.toString(numbers));
//		Array number = new Array(3);
//		var list = new LinkedList();
//		list.addLast(10);
//		list.addLast(20);
//		list.addLast(30);
//		list.removeLast();
//		System.out.println();
//		System.out.println(list.contains(10));
//		list.removeLast();
//		System.out.println(list.size());
//		var array = list.toArray();
//		System.out.println(Arrays.toString(array));
//
//		CharFinder finder = new CharFinder();
//		var ch = finder.findFirstNonRepeatingChar("a green apple");
//		System.out.println(ch);
//
//		var chr = finder.findFirstRepeatingChar("green apple");
//		System.out.println(chr);
//		String str = "orange";
//		System.out.println(hash(str));
//		
//		HashTable table = new HashTable();
//		table.put(1, "A");
//		table.put(2, "B");
//
//		table.put(3, "C+");
//		table.remove(2);
//System.out.println(table.get(2));

//String str = "(1+2)";
//StringReverser reverser = new StringReverser();
//Expression exp = new Expression();
//var result = exp.isBalanced(str);
//System.out.println(result);

//		Stack stack = new Stack();
//		stack.push(10);
//		stack.push(20);
//		stack.push(30);
//		stack.pop();
//		
//		System.out.println(stack.peek());
//		stack.pop();

//ArrayQueue queue = new ArrayQueue(5);
//queue.enqueue(10);
//queue.enqueue(20);
//queue.enqueue(30);
//queue.enqueue(40);
//queue.dequeue();
//queue.dequeue();
//queue.enqueue(50);
//queue.enqueue(60);
//queue.dequeue();
//queue.enqueue(70);
//queue.enqueue(80);
//queue.dequeue();
//queue.enqueue(90);
//System.out.println(queue.toString());

//QueueWithTwoStack queue = new QueueWithTwoStack();
//queue.enqueue(10);
//queue.enqueue(20);
//queue.enqueue(30);
//queue.enqueue(40);
//queue.dequeue();
//var first = queue.dequeue();
//System.out.println(first);

//System.out.println(queue.toString());
//queue.dequeue();
//		PriorityQueue queue = new PriorityQueue();
//		queue.add(5);
//		queue.add(3);
//		queue.add(6);
//		queue.add(1);
//		queue.add(4);
//		var removexd = queue.remove();
//		System.out.println(removexd);
//		System.out.println(queue);
//		while (!queue.isEmpty()) {
//			System.out.println(queue.toString());
//			
//
//		}
//		Tree tree = new Tree();
//		tree.insert(7);
//		tree.insert(4);
//		tree.insert(9);
//		tree.insert(1);
//		tree.insert(6);
//		tree.insert(8);
//		tree.insert(10);

//		Tree tree2 = new Tree();
//		tree2.insert(7);
//		tree2.insert(4);
//		tree2.insert(9);
//		tree2.insert(1);
//		tree2.insert(6);
//		tree2.insert(8);
//		tree2.insert(10);
//		tree.traverseLevelOrder();
//		tree.traversePreOrder();
//		var list = tree.getNodesAtDistance(1);
//		for (var integer : list) {
//			System.out.println(integer);
//		}
//		tree.swapRoot();
//		System.out.println(tree.isBinarySearchTree());
//		System.out.println(tree.find(10));

//		System.out.println(factorial(4));
//		int[] numbers = { 7, 5, 2, 3, 1, 8 };
//		var sorter = new BubbleSort();
//		sorter.sort(numbers);
//		System.out.println(Arrays.toString(numbers));

//		var sorter = new BucketSort();
//		sorter.sort(numbers, 3);
//		System.out.println(Arrays.toString(numbers));

//		int[] numbers = { 1,3,5,6,8,9 };
//		var search = new Search();
//		var index = search.exponentialSearch(numbers, 5);
//		System.out.println(index);
//var count = StringUtils.isPalindrome("");
//System.out.println(count);
//		Main.isPalindrome("bnanb");
//		String reversed = StringUtils.reverse("boy");
//	System.out.println(reversed);
	}

	public static int hash(String key) {
		int hash = 0;
		for (var ch : key.toCharArray())
			hash += ch;
		return hash % 100;

	}

	public static int factorial(int n) {
		if (n == 0)
			return 1;
		return n * factorial(n - 1);
//		var factorial = 1;
//		for (int i = n; i > 1; i--) {
//			factorial *= i;
//		}
//		return factorial;
	}
	public static void printDuplicates(Map<Name,Integer> names) {
	    for(Map.Entry<Name,Integer> entry: names.entrySet()) {
	        if (entry.getValue() > 1) {
	            System.out.println(entry.getKey());
	        }
	    }
	}

}
