package com.greatllearning.dsa.assignment.q2.main;

import java.util.Scanner;

import com.greatllearning.dsa.assignment.q2.bst.BstCreation;
import com.greatllearning.dsa.assignment.q2.bst.BstCreation.Node;

public class Main {
	
	static Node prevNode = null;
	static Node headNode = null;

	static void toRightSkewed(Node root) {

		if (root == null) {
			return;
		}
		
		Main.toRightSkewed(root.getLeft());
		
		Node rightNode = root.getRight();

		
		if (headNode == null) {
			headNode = root;
			root.setLeft(null);
			prevNode = root;
		} else {
			prevNode.setRight(root);
			root.setLeft(null);
			prevNode = root;
		}
		

		Main.toRightSkewed(rightNode);
	}

	static void traverseRightSkewed(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.getKey() + " ");
		traverseRightSkewed(root.getRight());
	}


	public static void main(String[] args) {
		//       50
		//      /  \
		//     30  60
		//     /   /
		//    10  55
		
		int num=-1;
		int value=0;
		Node root = null;
		Node result = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter total no of values: ");
		num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			System.out.print("Insert value at " + (i + 1) + ": ");
			value = sc.nextInt();
			if (root == null) {
				root = BstCreation.insert(root, value);
			} else {
				result = BstCreation.insert(root, value);
				if (result.getKey() == value)
					i -= 1;
			}	
		}
		
		System.out.println("\nInorder traversal of this BST");
		BstCreation.inOrderTraversal(root);

		toRightSkewed(root);
		
		// output
		System.out.println("\n\nBinary search tree after converting to right skewed BST");
		traverseRightSkewed(headNode);
		System.out.println("\n\n***** Program completed successfully *****");
		
		root = null;
		sc.close();
	}
}
