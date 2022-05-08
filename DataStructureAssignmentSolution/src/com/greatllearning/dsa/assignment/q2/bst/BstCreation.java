package com.greatllearning.dsa.assignment.q2.bst;

public class BstCreation {

	// BST node
	public static class Node {
		private int key;
		private Node left;
		private Node right;
		
		public int getKey() {
			return key;
		}
		
		public Node getLeft() {
			return left;
		}
		
		public void setLeft(Node left) {
			this.left = left;
		}
		
		public Node getRight() {
			return right;
		}
		
		public void setRight(Node right) {
			this.right = right;
		}
	};

	// creation of new node
	public static Node newNode(int data) {
		Node temp = new Node();
		temp.key = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}

	public static Node insert(Node root, int key) {
		Node newnode = newNode(key);
		Node x = root;
		Node y = null; // y maintains pointer to x
		while (x != null) {
			y = x;
			if (key < x.key)
				x = x.left;
			else if (key > x.key)
				x = x.right;
			else {
				System.out.println("Value already exists!!!");
				return newnode;
			}
		}
		// If the root is null, the tree is empty.
		if (y == null) {
			y = newnode;
		}
		// assign new node node to the left child
		else if (key < y.key) {
			y.left = newnode;
		}
		// assign the new node to the right child
		else {
			y.right = newnode;
		}
		// return pointer to new node
		return y;
	}

	
	public static void inOrderTraversal(Node root) {
		if (root == null)
			return;
		else {
			inOrderTraversal(root.left);
			System.out.print(root.key + " ");
			inOrderTraversal(root.right);
		}
	}
}