package com.datastructure.graph;

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
			return "Node " + value;
		}
	}

	private Node root;

	public void insert(int value) {
//		Create new node
		var node = new Node(value);
//		if tree doesn't exist then first node as new node 
		if (root == null) {
			root = node;
			return;
		}
//      kept root as current
		var current = root;
//		untill there no node
		while (true) {
//			if value is less than current node value or not
			if (value < current.value) {
//				if current node has leftchild or not
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
//		lookup till current exists
		while (current != null) {
//			check if value exists in left or right and to return if value found
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

//	preorder
	private void traversePreOrder(Node root) {
		if (root == null)
			return;
		System.out.print(" " + root);
		traversePreOrder(root.leftChild);
		traversePreOrder(root.rightChild);

	}

	private void traverseInOrder(Node root) {
		if (root == null)
			return;

		traversePreOrder(root.leftChild);
		System.out.print(" " + root);
		traversePreOrder(root.rightChild);

	}

	private void traversePostOrder(Node root) {
		if (root == null)
			return;

		traversePreOrder(root.leftChild);
		traversePreOrder(root.rightChild);
		System.out.print(" " + root);
	}

//postorder in action
	public int height() {
		return height(root);
	}

	private int height(Node root) {
		if (root == null)
			return -1;
		if (isLeaf(root))
			return 0;
		return 1 + Math.max(height(root.leftChild), height(root.rightChild));
	}

	private boolean isLeaf(Node root) {
		return root.leftChild == null && root.rightChild == null;
	}

//	O(log(n)) when given binary search tree
	public int min() {
		if (root == null)
			throw new IllegalStateException();

		var current = root;
		var last = current;
//		if when binary search tree
		while (current != null) {
			last = current;
			current = current.leftChild;
		}
		return last.value;
//		min(root) => for binary tree call only this
	}

//	O(n) Only when binary tree
	private int min(Node root) {
		if (isLeaf(root))
			return root.value;
		var left = min(root.leftChild);
		var right = min(root.rightChild);
		return Math.min(Math.min(left, right), root.value);
	}

	public boolean equals(Tree other) {
		if (other == null)
			return false;
		return equals(root, other.root);
	}

//	preorder in action
	private boolean equals(Node first, Node second) {
		if (first == null && second == null)
			return true;
		if (first != null && second != null)
			return first.value == second.value && equals(first.leftChild, second.leftChild)
					&& equals(first.rightChild, second.rightChild);

		return false;
	}

	public boolean isBinarySearchTree() {
		return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBinarySearchTree(Node root, int min, int max) {
		if (root == null)
			return true;
//		value not in range
		if (root.value < min || root.value > max)
			return false;
//		value is in range ;calling leftchild with atleast less than max value;
//		calling right with atmost greater than max value
		return isBinarySearchTree(root.leftChild, min, root.value - 1)
				&& isBinarySearchTree(root.rightChild, root.value + 1, max);
	}

	public void swapRoot() {
		var temp = root;
		root.leftChild = root.rightChild;
		root.rightChild = temp;
	}

	public ArrayList<Integer> getNodesAtDistance(int distance) {
		var list = new ArrayList<Integer>();
		getNodesAtDistance(root, distance, list);
		return list;
	}

// node at kth distances with parameter root node,distance and add that to list
	private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {
		if (root == null)
			return;
		if (distance == 0) {
			list.add(root.value);
//		System.out.println(root.value);
			return;
		}
//		recusrive call to decrease distance by 1
		getNodesAtDistance(root.leftChild, distance - 1, list);
		getNodesAtDistance(root.rightChild, distance - 1, list);
	}

	public void traverseLevelOrder() {
		for (var i = 0; i <= height(); i++) {
			for (var value : getNodesAtDistance(i)) {
				System.out.println(value);
			}
		}
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.insert(7);
		tree.insert(4);
		tree.insert(9);
		tree.insert(1);
		tree.insert(6);
		tree.insert(8);
		tree.insert(10);

		Tree tree2 = new Tree();
		tree2.insert(7);
		tree2.insert(4);
		tree2.insert(9);
		tree2.insert(1);
		tree2.insert(6);
		tree2.insert(8);
		tree2.insert(10);
		tree.traverseLevelOrder();
		tree.traversePreOrder();
		var list = tree.getNodesAtDistance(1);
		for (var integer : list) {
			System.out.println(integer);
		}
		tree.swapRoot();
		System.out.println(tree.isBinarySearchTree());
		System.out.println(tree.find(10));
	}
}
