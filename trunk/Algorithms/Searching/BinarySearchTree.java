package com.practice.prep.algorithms;

/**
 * https://www.edureka.co/blog/java-binary-tree
 * https://www.includehelp.com/data-structure-tutorial/deletion-in-binary-search-tree-bst.aspx
 * Binary Search Trie: Trie with two node, so, left node, right node and the
 * node value left node is always have smaller value and right node will always
 * have higher value Insertion some value: if value is higher, insert to right
 * node, if smaller, insert to left node and if root dont have vaue, assigns to
 * root Deletion: If value to be deleted, is present in trie, do comparison and
 * perform deletion
 * 
 * Depth First Search: is type of traversal of trie. InOrder Traversal: left ->
 * root -> right order PreOrder : root -> left -> right PostOrder : left ->
 * right -> root
 **/
public class BinarySearchTree {

	public static void main(String[] args) {
		Node node = new Node(7);
		System.out.println("Building The Trie with root value " + node.value);
		insertToBST(node, 4);
		insertToBST(node, 2);
		insertToBST(node, 8);
		insertToBST(node, 11);
		insertToBST(node, 6);
		insertToBST(node, 9);
		insertToBST(node, 12);
		insertToBST(node, 5);

		traverseInOrder(node);
		System.out.println();
		traversePreOrder(node);
		System.out.println();
		traversePostOrder(node);
		System.out.println();
		
		System.out.println("Node value 5, found in trie : "+searchValueInTrie(node, 5));
		System.out.println("Node value 10, found in trie : "+searchValueInTrie(node, 10));
		Node updatedNode = removeFromBST(node, 5);
		System.out.println("Node value 5, found in trie : "+searchValueInTrie(updatedNode, 5));
	}

	static class Node {
		int value;
		Node leftLeaf;
		Node rightLeaf;

		Node(int nodeValue) {
			//System.out.println("Trie created with root : " + nodeValue);
			this.value = nodeValue;
			leftLeaf = null;
			rightLeaf = null;
		}
	}

	private static void insertToBST(Node node, int data) {
		if (data < node.value) {
			if (node.leftLeaf != null) {
				insertToBST(node.leftLeaf, data);
			} else {
				System.out.println("Value " + data + " Added as left node of "+node.value);
				node.leftLeaf = new Node(data);
			}
		} else if (data > node.value) {
			if (node.rightLeaf != null) {
				insertToBST(node.rightLeaf, data);
			} else {
				System.out.println("Value " + data + " Added as right node of "+node.value);
				node.rightLeaf = new Node(data);
			}
		} /*
			 * else { node.value = value; System.out.println("Parent node value added"); }
			 */
	}

	private static Node removeFromBST(Node node, int data) {
		if (searchValueInTrie(node, data)) {
			if (node.value == data) {
				node = null;
				System.out.println("Data removed from Trie");
				return node;
			} else if (data > node.value) {
				removeFromBST(node.rightLeaf, data);
			} else if (data < node.value) {
				removeFromBST(node.leftLeaf, data);
			}
		} else {
			System.out.println("Invalid node value to delete");
		}
		
		return null;
	}

	private static boolean searchValueInTrie(Node root, int data) {
		if (root == null) {
			return false;
		} else if (root.value == data) {
			return true;
		} else if (data > root.value) {
			return searchValueInTrie(root.rightLeaf, data);
		} else if (data < root.value) {
			return searchValueInTrie(root.leftLeaf, data);
		}

		return false;
	}

	private static void traverseInOrder(Node root) {
		if (root != null) {
			traverseInOrder(root.leftLeaf);
			System.out.print(" " + root.value);
			traverseInOrder(root.rightLeaf);
		}
	}

	private static void traversePreOrder(Node root) {
		if (root != null) {
			System.out.print(" " + root.value);
			traversePreOrder(root.leftLeaf);
			traversePreOrder(root.rightLeaf);
		}
	}

	private static void traversePostOrder(Node root) {
		if (root != null) {
			traversePostOrder(root.leftLeaf);
			traversePostOrder(root.rightLeaf);
			System.out.print(" " + root.value);
		}
	}
}
