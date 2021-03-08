package com.datastructure;

import java.util.ArrayList;

public class Tree {

	private class Node {
		private int value;
		private Node leftChild;
		private Node rightChild;

		public Node(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return " " + value;
		}
	}

	private Node root;

	public void insert(int value) {
		var node = new Node(value);
		if (root == null) {
			root = new Node(value);
			return;
		}

		var current = root;
		while (true) {
			if (value < current.value) {
				if (current.leftChild == null) {
					current.leftChild = node;
					break;
				}
				current = current.leftChild;
			}

			else {
				if (current.rightChild == null) {
					current.rightChild = node;
					break;
				}
				current = current.rightChild;
			}
		}
	}

	public boolean find(int value) {
		var current = root;
		while (current != null) {
			if (value < current.value) {
				current = current.leftChild;
			} else if (value > current.value) {
				current = current.rightChild;
			} else
				return true;
		}
		return false;
	}

	public void traversePreOrder() {
		traversePreOrder(root);
	}
	public void traverseInOrder() {
		traverseInOrder(root);
	}
	public void traversePostOrder() {
		traversePostOrder(root);
	}
	private void traversePreOrder(Node root) {
		if(root == null) return;
		System.out.print(" "+root);
		traversePreOrder(root.leftChild);
		traversePreOrder(root.rightChild);
		
	}
	private void traverseInOrder(Node root) {
		if(root == null) return;
		
		traversePreOrder(root.leftChild);
		System.out.print(" "+root);
		traversePreOrder(root.rightChild);
		
	}
	private void traversePostOrder(Node root) {
		if(root == null) return;
		
		traversePreOrder(root.leftChild);		
		traversePreOrder(root.rightChild);
		System.out.print(" "+root);
	}
//postorder in action
	public int height() {
		return height(root);
	}
	private int height(Node root) {
		if(root == null) return -1;
		if(isLeaf(root)) return 0;
		return 1 + Math.max(height(root.leftChild), height(root.rightChild));
	}

	private boolean isLeaf(Node root) {
		return root.leftChild ==null && root.rightChild == null;
	}
//	O(log(n))
	public int min() {
		if(root == null) throw new IllegalStateException();
	
		var current = root;
		var last = current;
//		if when binary search tree
		while(current != null) {
			last = current;
			current = current.leftChild;
		}
		return last.value;
	}
//	O(n) Only when binary tree
	private int min(Node root) {
		if(isLeaf(root)) return root.value;
		var left = min(root.leftChild);
				var right = min(root.rightChild);
		return Math.min(Math.min(left, right),root.value);
	}

	public boolean equals(Tree other) {
		if(other == null) return false;
		return equals(root,other.root);
	}
//	preorder in action
	private boolean equals(Node first,Node second) {
		if(first == null && second == null) return true;
		if(first != null && second != null) 
			return first.value == second.value 
			&& equals(first.leftChild,second.leftChild) 
			&& equals(first.rightChild,second.rightChild);
		
		return false;
	}

	public boolean isBinarySearchTree() {
		return isBinarySearchTree(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	private boolean isBinarySearchTree(Node root,int min,int max) {
		if(root == null) return true;
		if(root.value < min || root.value > max) return false;
		return isBinarySearchTree(root.leftChild, min, root.value-1) 
		    && isBinarySearchTree(root.rightChild, root.value + 1, max);
	}
	
public void swapRoot() {
	var temp = root;
	root.leftChild = root.rightChild;
	root.rightChild = temp;
}
public ArrayList<Integer> getNodesAtDistance(int distance) {
	var list =new ArrayList<Integer>();
	getNodesAtDistance(root, distance,list);
	return list;
}

private void getNodesAtDistance(Node root,int distance,ArrayList<Integer> list) {
	if(root == null) return;
	if(distance == 0) { 
		list.add(root.value);
//		System.out.println(root.value);
		return;}
	getNodesAtDistance(root.leftChild,distance-1,list);
	getNodesAtDistance(root.rightChild,distance-1,list);
}

public void traverseLevelOrder() {
   for(var i = 0; i<= height();i++) {
	 for(var value : getNodesAtDistance(i)) {
		 System.out.println(value);
	 }
   }	
}
}
