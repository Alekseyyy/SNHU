
/*
 * "MyBST" is a class that implements a simple binary
 * search tree, where its main functionality is in accordance
 * with the requirements outlined in "Study.com" (n.d.-c).
 * 
 * Such requirements include:
 *   1. The creation of a binary search tree
 *   2. The ability to add nodes to the BST given its data value
 *   3. The ability to delete nodes from the BST given its data value
 *   4. To print out nodes in the following manner:
 *     4a. In-Order Traversal
 *     4b. Pre-Order Traversal
 *     4c. Post-Order Traversal
 *   5. BONUS: while not in the requirements, I included methods to
 *     find a node given its data value, mainly for reference.
 * 
 * MyBST "super-class", and Node classes are taken from
 * "Study.com" (n.d.).
 * 
 * @author: Alexander Ahmann <alexander.ahmann@snhu.edu>
*/

package assignment;

import java.util.Arrays;

public class MyBST {
	
	/* 
	 * A "Node" constitutes the base "parts" that make up
	 * the whole binary search tree. The Node structure is taken
	 * after the one shown in "Study.com" (n.d.).
	 * 
	 * @param entry    this is the first piece of data to be
	 *                 put into the BST; the "root" of the tree.
	 */
	private class Node {
		int data;
		Node left, right;
		
		public Node(int key) {
			this.data = key;
			this.left = null;
			this.right = null;
		}
	}
	
	private Node tree; 
	
	/*
	 * "MyBST" constructor
	 * It takes in a list, sorts it, and then works out
	 *   its midpoint element. It then inserts said mid-
	 *   -point element into the root of the tree, and 
	 *   then proceeds to insert other elements.
	 * 
	 * @param initData    an array of integers to be 
     *                    initialized by the BST.
     * @returns a new "MyBST" data structure
	 */
	public MyBST(int[] initData) {
		// First, sort the list
		Arrays.sort(initData); /*I cited the Java SE 8
		  Documentation (n.d.) for this bit of code */
		
		/*
		 * Next, I will initialize the "tree" Node construct
		 *   by using a custom "makeBalancedTree" method (after
		 *   "Geeks4Geeks", c.a. Feb. 5, 2025) to populate the
		 *   tree with the initial values:
		 */
		tree = this.makeBalancedTree(initData, 0, initData.length - 1);
	}
	
	/*
	 * Wrapper method to be called by external method to
	 *   add data to the binary search tree.
	 * 
	 * @param key    the piece of data to be inserted
	 *               into the binary search tree
	 */
	public void insert(int key) {
		tree = insertNode(tree, key);
	} 
	
	/*
	 * Main logic for inserting a new piece of data
	 * to the binary search tree.
	 * 
	 * @param node    the binary search tree to insert
	 *                  new data into.
	 * @param key     the actual data to be inserted
	 *                  into the binary search tree.
	 * @returns a new version of the binary search 
	 *   tree where the new key has been inserted.
	 */
	private Node insertNode(Node node, int key) {
		if (node == null) {
			node = new Node(key);
			return node;
		}
		
		if (key < node.data)
			node.left = insertNode(node.left, key);
		if (key > node.data)
			node.right = insertNode(node.right, key);
		return node;
	} // insert and insertNode to BST  
	  // method after "Study.com" (n.d.-b)
	
	/*
	 * Wrapper method to be called from an external method to
	 *   delete a datum from the binary search tree.
	 * 
	 * @param key    the datum to be deleted.
	 */
	public void delete(int key) {
		deleteNode(tree, key);
	}
	
	/*
	 * Main logic for deleting a piece of data from
	 *   the binary search tree. It works by a recursive
	 *   method
	 *   
	 * @param node    the binary search tree to
	 *                delete the selected datum from.
	 * @param key     the target piece of data to
	 *                delete from the binary search tree.
	 * @returns a new version of the binary search tree
	 *   where the specified data is deleted.
	 */
	private Node deleteNode(Node node, int key) {
		if (node == null)
			return node;
		
		if (node.data > key)
			node.left = deleteNode(node.left, key);
		else if (node.data < key)
			node.right = deleteNode(node.right, key);
		else {
			if (node.left == null)
				return node.right;
			if (node.right == null)
				return node.left;
			
			Node successor = node.right;
			while (successor != null && successor.left != null) 
				successor = successor.left;
			
			node.data = successor.data;
			node.right = deleteNode(node.right, successor.data);
		}
		
		return node;
	} // delete and deleteNode to BST method 
	  // after "Study.com" (n.d.-b) and
	  // "Geeks4Geeks" (c.a. Dec. 5, 2024).
	
	/*
	 * Wrapper method to be called by an external method
	 *   to print keys in the binary search tree with an
	 *   In-Order traversal method.
	 */
	public void printInOrder() {
		traverseInOrder(tree);
	}
	
	/*
	 * Main logic to print out keys in the binary search
	 *   tree with an In-Order traversal method.
	 *   
	 * @param node    the binary search tree to print
	 *                out the values from.
	 */
	private void traverseInOrder(Node node) {
		if (node == null)
			return;
		
		traverseInOrder(node.left);
		System.out.print(node.data + ",");
		traverseInOrder(node.right);
	} /* printInOrder() and traverseInOrder() methods
	   after "Geeks4Geeks" (c.a. Oct. 21, 2024). */
	
	/*
	 * Wrapper method to be called by an external method
	 *   to print keys in the binary search tree with an
	 *   Pre-Order traversal method.
	 */
	public void printPreOrder() {
		traversePreOrder(tree);
	}
	
	/*
	 * Main logic to print out keys in the binary search
	 *   tree with an Pre-Order traversal method.
	 *   
	 * @param node    the binary search tree to print
	 *                out the values from.
	 */
	private void traversePreOrder(Node node) {
		if (node == null)
			return;
		
		System.out.print(node.data + ",");
		traversePreOrder(node.left);
		traversePreOrder(node.right);
	} /* printPreOrder() and traversePreOrder(Node)
	   methods after "Geeks4Geeks" (Oct. 31, 2024) */
	
	/*
	 * Wrapper method to be called by an external method
	 *   to print keys in the binary search tree with an
	 *   Post-Order traversal method.
	 */
	public void printPostOrder() {
		traversePostOrder(tree);
	}
	
	/*
	 * Main logic to print out keys in the binary search
	 *   tree with an Post-Order traversal method.
	 *   
	 * @param node    the binary search tree to print
	 *                out the values from.
	 */
	private void traversePostOrder(Node node) {
		if (node == null)
			return;
		
		traversePostOrder(node.left);
		traversePostOrder(node.right);
		System.out.print(node.data + ",");
	} /* printPostOrder() and traversePostOrder(Node)
	   methods after "Geeks4Geeks" (Oct. 31, 2024) */
	
	/*
	 * Method to balance a binary search tree, given a 
	 *   sorted array. After "Geeks4Geeks" (c.a. Feb.
	 *   5, 2025).
	 *   
	 * @param initData     sorted array of integers.
	 * @param start        index of the first item in the
	 *                     sorted array.
	 * @param finish       index of the last item in the
	 *                     sorted array.
	 */
	private Node makeBalancedTree(int[] initData, int start, int finish) {
		
		if (start > finish)
			return null;
		
		int midpoint = (start + finish) / 2; /* this calculation
		  (in part) borrows from "TutorialsPoint" (n.d.) */
		Node node = new Node(initData[midpoint]);
		
		node.left = this.makeBalancedTree(initData, start, midpoint - 1);
		node.right = this.makeBalancedTree(initData, midpoint + 1, finish);
		
		return node;
	} /* This method is after "Geeks4Geeks" (n.d.). */
}

/*
 * References
 * 1. "Study.com" (n.d.). Binary Trees: Applications & Implementation. Retrieved on
 *   Mar. 6, 2025 from: https://study.com/academy/lesson/binary-trees-applications-implementation.html
 * 2. "Study.com" (n.d.-b). Practical Application for Data Structures: Search Trees. Retrieved on
 *   Mar. 6, 2025 from: https://study.com/academy/lesson/practical-application-for-data-structures-search-trees.html
 * 3. "Study.com" (n.d.-c). Computer Science 201 - Assignment 1: Creating a Binary Search Tree. 
 *   Retrieved on Mar. 7, 2025 from: 
 *   https://study.com/academy/lesson/data-structures-algorithms-assignment-array-sorting-and-hashmaps.html
 * 3. "Geeks4Geeks" (c.a. Oct. 21, 2024). Inorder Traversal of Binary Tree. Retrieved on 
 *   Mar. 6, 2025 from: https://www.geeksforgeeks.org/inorder-traversal-of-binary-tree/
 * 4. "Geeks4Geeks" (c.a. Oct. 30, 2024). Preorder Traversal of Binary Tree. Retrieved
 *   on Mar. 6, 2025 from: https://www.geeksforgeeks.org/preorder-traversal-of-binary-tree/
 * 5. "Geeks4Geeks" (c.a. Oct. 21, 2024b). Postorder Traversal of Binary Tree. Retrieved 
 * on Mar. 6, 2025 from: https://www.geeksforgeeks.org/postorder-traversal-of-binary-tree/
 * 6. "Geeks4Geeks" (c.a. Dec. 5, 2024). Deletion in Binary Search Tree (BST). Retrieved on
 *   Mar. 7, 2025 from: https://www.geeksforgeeks.org/deletion-in-binary-search-tree/
 * 7. Java SE 8 Documentation (n.d.).  Arrays. Retrieved on Mar. 11, 2025 from:
 *   https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html#sort-byte:A-
 * 8. "TutorialsPoint.com" (n.d.). Find the Middle Element of an array in JAVA. Retrieved on Mar.
 *   11, 2025 from: https://www.tutorialspoint.com/find-the-middle-element-of-an-array-in-java
 * 9. "Geeks4Geeks" (c.a. Feb. 5, 2025). Balance a Binary Search Tree. Retrieved on Mar. 12, 2025
 *   from: https://www.geeksforgeeks.org/convert-normal-bst-balanced-bst/
 */
