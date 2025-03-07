
package assignment;

public class MyBinaryTree {
/*
 * "MyBinaryTree" is a class that implements a simple binary
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
 * MyBinaryTree "super-class", and Node and Tree classes
 * are taken after "Study.com" (n.d.).
 * 
 * @author: Alexander Ahmann <alexander.ahmann@snhu.edu>
*/
	
	/* 
	 * A "Node" class constitutes the base "parts" that make up
	 * the whole binary search tree. The Node structure is taken
	 * after the one shown in "Study.com" (n.d.).
	 * 
	 * @param entry    this is the first piece of data to be
	 *                 put into the BST; the "root" of the tree.
	 */
	public static class Node {
		int data;
		Node left, right;
		
		public Node(int key) {
			data = key;
			left = right = null;
		}
	}
	
	/*
	 * "Tree" is a class that builds off of the node to make them into
	 * the whole binary search tree. This class consists of procedures
	 * to retrieve, add and delete nodes from the binary tree.
	 * 
	 * @param key    this is the initial piece of data that is
	 *               to be inserted into the binary search tree
	 */
	public static class Tree {
	// Tree Structure after "Study.com" (n.d.-b). 
		Node root;
		Tree(int key) {
			this.root = new Node(key);
		}
		
		Tree() {
			this.root = null;
		}
		
		/*
		 * Wrapper method to be called by external method to
		 *   add data to the binary search tree.
		 * 
		 * @param key    the piece of data to be inserted
		 *               into the binary search tree
		 */
		public void insert(int key) {
			this.root = insertNode(this.root, key);
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
			
			if (key <= node.data) // when inserting nodes, the tree is kept balanced
				                // by ensuring that child nodes on the left have data
				                // values *less than or equal to* its parent node ...
				node.left = insertNode(node.left, key);
			else if (key > node.data) // ... and values on the right being *greater
				                     // than* the value of its parent node.
				node.right = insertNode(node.right, key);
			return node;
		} // insert and insertNode to BST method 
		//   after "Study.com" (n.d.-b).
		
		/*
		 * Wrapper method to be called from an external method to
		 *   delete a datum from the binary search tree.
		 * 
		 * @param key    the datum to be deleted.
		 */
		public void delete(int key) {
			deleteNode(this.root, key);
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
		}
		
		/*
		 * Wrapper method to be called by an external method
		 *   to print keys in the binary search tree with an
		 *   In-Order traversal method.
		 */
		public void printInOrder() {
			traverseInOrder(this.root);
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
			traversePreOrder(this.root);
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
			traversePostOrder(this.root);
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
		 * Wrapper method to find the node of a piece of data in the 
		 * binary search tree. 
		 * 
		 * @param key    the data value to search the binary
		 *               search tree for.
		 * @returns a Node object of the data
		 */
		public Node find(int key) {
			Node data = findNode(this.root, key);
			return data;
		}
		
		/*
		 * This is the main procedure for finding a node with
		 *   a particular data value. It works by recursively calling
		 *   itself until it locates the node with the particular "key"
		 *   --- the "key" representing the data kind of interest.
		 *   
		 * @param node    this is the binary search tree of interest
		 * @param key     this is the target key to locate
		 * 
		 * @returns the node with the data type of interest
		 */
		private Node findNode(Node node, int key) {
			if (key == node.data)
				return node;
			
			if (key < node.data) 
				return findNode(node.left, key);
			else if (key > node.data)
				return findNode(node.right, key);

			return null;
		} /* Code for "finding" an entry in the binary search
		 * tree. After "Study.com" (n.d.-b)
		 *  
		 * NOTE that: while the assignment does not require
		 * a "find" method, I implemented one for reference.
		 * These "find" and "findNode" methods are not called
		 * by the Driver code.
		 */
	}
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
 */
