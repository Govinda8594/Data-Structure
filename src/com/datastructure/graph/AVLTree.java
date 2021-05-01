package com.datastructure.graph;

public class AVLTree {
	private class AVLNode {
		private int value;
		private AVLNode leftChild;
		private AVLNode rightChild;
		private int height;

		public AVLNode(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "value= " + this.value;
		}
	}

	private AVLNode root;

	public void insert(int value) {
		root = insert(root, value);
	}

	private AVLNode insert(AVLNode root, int value) {
//		if tree exits or not
		if (root == null)
			return new AVLNode(value);

		if (value < root.value)
			root.leftChild = insert(root.leftChild, value);
		else
			root.rightChild = insert(root.rightChild, value);
//		revalute height
		setHeight(root);

//		balance the binary tree
		return balance(root);

	}

	private AVLNode balance(AVLNode root) {
//		tree is left heavy or not
		if (isLeftHeavy(root)) {
//			balance left subtree => L and LR rotation
			if (balanceFactor(root.leftChild) > 0)
//				rotate left and assign to left child
				root.leftChild = rotateLeft(root.leftChild);
			return rotateRight(root);

		} else if (isRightHeavy(root)) {
//			balance right subtree  => R and RL rotation
			if (balanceFactor(root.rightChild) < 0)
//				rotate right and assign to right child
				root.rightChild = rotateRight(root.rightChild);
			return rotateLeft(root);
		}
		return root;
	}

// left rotate the subtree/tree
	private AVLNode rotateLeft(AVLNode root) {
		var newRoot = root.rightChild;
		root.rightChild = newRoot.leftChild;
		newRoot.leftChild = root;
		setHeight(root);
		setHeight(newRoot);
		return newRoot;
	}

// right rotate the subtree/tree
	private AVLNode rotateRight(AVLNode root) {
		var newRoot = root.leftChild;
		root.leftChild = newRoot.rightChild;
		newRoot.rightChild = root;
		setHeight(root);
		setHeight(newRoot);
		return newRoot;
	}

// set height of tree
	private void setHeight(AVLNode node) {
		node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;
	}

//	check for leftheavy
	private boolean isLeftHeavy(AVLNode node) {
		return balanceFactor(node) > 1;
	}

//	check for rightheavy
	private boolean isRightHeavy(AVLNode node) {
		return balanceFactor(node) < -1;
	}

//	calculate balance factor of node
	private int balanceFactor(AVLNode node) {
		return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
	}

// calculate height of tree
	private int height(AVLNode node) {
		return (node == null) ? -1 : node.height;
	}
}
