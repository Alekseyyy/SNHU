
package assignment;

import java.util.*;

/*
 * Program class that includes the driver code and main logic of the 
 *   entire application to demonstrate the "MyBinaryTree" data structure.
 * What is needed here is a menu to give the end-user options to navigate
 *   the binary search tree, and  
 *    
 * @author Alexander Ahmann <alexander.ahmann@snhu.edu>
 */
public class Program {
	
	static MyBinaryTree.Tree bstInstance;

	/* entry point of the "Driver" to demonstrate 
	 * MyBinaryTree.java no arguments needed to be  
	 *  entered into the command line for this utility 
	 *  to work ...
	 * 
	 * @param: args    Command line arguments. note that this
	 *                 application does not take in arguments, 
	 *                 this is here for good Java coding practice.
	 */
	public static void main(String[] args) {
		
		// Housekeeping stuff ...
		Scanner getInput = new Scanner(System.in);
		welcome();
		printMenu();
		
		// Main Logic ...
		
		boolean done = false;
		while (!done) {
		/* 
		 * As per "Study.com" (n.d.-c)'s assignment prompt, I am to present a menu
		 * of seven options: To
		 *   1. Create a new binary search tree with the initial values
		 *     1, 2, 3, 4, 5, 6, 7
		 *   2. Add a node
		 *   3. Delete a node
		 *   4. Print Nodes in In-Order Traversal
		 *   5. Print Nodes in Pre-Order Traversal
		 *   6. Print Nodes in Post-Order Traversal
		 *   7. Exit the application
		 *   
		 *   I accomplish this by having the software enter a while loop that
		 *     is conditional on a boolean "done" variable being false. After the
		 *     end-user requests option 7 to exit the application, the while loop
		 *     is broken, and the application ends. 
		 *   
		 *   The Scanner class is used to request input and parse them as integers
		 *     (and if a non-integer is entered in, an exception is thrown). Then,
		 *     the Scanner will parse the option into an integer readOption, and then
		 *     use the "switch" operator to perform a task conditional on the end-
		 *     -user's selected option.
		 *   
		 *   In the event of adding or deleting nodes from the binary search tree,
		 *     the main logic might ask for more data, and then use the Scanner to
		 *     parse it into an integer "readData", which will then be passed into
		 *     the appropriate method for the binary search tree.
		 */
			try {
				System.out.print("Enter an option (an integer): ");
				int readData;
				int readOption = getInput.nextInt();
				
				switch (readOption) {
				case 1: /* Create a binary search tree
					Specifically, create a binary search tree with
					  the initial node values: 1, 2, 3, 4, 5, 6, 7 */
					bstInstance = new MyBinaryTree.Tree();
					for (int key = 1; key <= 7; key++)
						bstInstance.insert(key);
					System.out.println("Successfully initialised a new Binary Search Tree with default values 1,2,3,4,5,6,7!");
					break;
				case 2: //Add a node
					System.out.print("Enter data to be inserted to the BST: ");
					readData = getInput.nextInt();
					bstInstance.insert(readData);
					System.out.printf("Successfully added %d to the BST!\n", readData);
					break;
				case 3: //Delete a node
					System.out.print("Enter data to be deleted from the BST: ");
					readData = getInput.nextInt();
					bstInstance.delete(readData);
					System.out.printf("Successfully deleted %d from the BST!\n", readData);
					break;
				case 4: //Print nodes by In-Order traversal
					System.out.print("In-Order Traversal Sort: ");
					bstInstance.printInOrder();
					System.out.printf("\n");
					break;
				case 5: //Print nodes by Pre-Order traversal
					System.out.print("Pre-Order Traversal Sort: ");
					bstInstance.printPreOrder();
					System.out.printf("\n");
					break; 
				case 6: //Print nodes by Post-Order traversal
					System.out.print("Post-Order Traversal Sort: ");
					bstInstance.printPostOrder();
					System.out.printf("\n");
					break;
				case 7: //Exit application
					getInput.close(); // close scanner for good practice ;-)
					done = true;
					break;
				default:
					System.out.println("Option does not exist.");
				}
				
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			} // Exception handling is used to handle what I may not have 
			 // anticipated the user to input or request.
		}
	}
	
	// Prints out a "welcome sign" saying the assignment title and author
	private static void welcome() {
		System.out.println("\n=================================");
		System.out.println("= Binary Search Tree Assignment =");
		System.out.println("=      By Alexander Ahmann      =");
		System.out.println("=================================");
	}
	
	// Prints out a menu of options that the end-user can employ to use
	//   the MyBinaryTree object. 
	private static void printMenu() {
		System.out.println("\nOptions:\n");
		System.out.println("1) Create a binary search tree");
		System.out.println("2) Add a node");
		System.out.println("3) Delete a node");
		System.out.println("4) Print nodes by InOrder");
		System.out.println("5) Print nodes by PreOrder");
		System.out.println("6) Print nodes by PostOrder");
		System.out.println("7) Exit program");
	}
}
