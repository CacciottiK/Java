package PackTwo;


/**
 * CET - CS Academic Level 3
 * Course: CST8130 - Data Structures
 * Professor: George Krieger
 *  
 * @author Algonquin College
 * @author Kyle Thomas 
 * SN: 040733617
 * Date: November 14th 2021 
 */
public class BinaryTree {	
	BinaryTreeNode root = null;

	/**
	 * create new node with these contents and insert in the proper location
	 * using BST logic
	 * @param newData The value being inserted into the tree
	 */

	public void insertInTree(int newData) {
		if (root == null) // if there is no present root, make it the value of newData
			root = new BinaryTreeNode(newData);
		else
			root.insert(newData); // if root exists, place it where it needs to be. 
	}

	/**
	 * Display tree contents using inorder traversal
	 */
	public void displayInOrder() {
		displayInOrder(root);
	}

	/**
	 * Start at subtree and display tree contents using inorder traversal
	 * @param subRoot starting location in tree
	 */
	private void displayInOrder(BinaryTreeNode subRoot) {
		if (subRoot == null)
			return;
		
		displayInOrder(subRoot.getLeft());		
		System.out.print(" " + subRoot.getData() + " ");		
		displayInOrder(subRoot.getRight());
	}
	
	/**
	 * Begins the display of the PreOrder traversal.
	 * Calls the method with the current Root Value
	 */
	
	public void displayPreOrder() {
		displayPreOrder(root); //Starts the display of pre-order with the root value as the first value. 
	}
	
	/**Displays the tree values in the PreOrder value. 
	 * 
	 * @param subRoot The starting location of the tree we are traversing
	 */
	
	private void displayPreOrder(BinaryTreeNode subRoot) {
		if (subRoot == null)
			return;	
			
		System.out.print(" " + subRoot.getData() + " ");
		displayPreOrder(subRoot.getLeft());	
		displayPreOrder(subRoot.getRight());
	}
	/**Using the same logic as the previous methods of Pre and in order displays. 
	 * In order to save the creation of another temp node variable, a method which calls the same method holding the root value.   
	 *  
	 * @param key The value which the user is searching for.
	 */
	
	public void search(int key) {
		search(key,root); // kinda recursion? :D
	}
	/**Searching the binary tree values using iteration.
	 * If the value is present in the tree, it is printed and returned true.
	 * else, not found and returns false.
	 * 
	 * @param key The value which is being searched for
	 * @param root the starting location of the tree. Adjusts as the search progresses to the subtrees. 
	 * @return Returns True if present, False if not. 
	 */
	
	public boolean search(int key, BinaryTreeNode root) {
		
		// BinaryTreeNode check = root;	
		
		while(root != null) { //begins the iteration
			
			if (key > root.getData()) { // if key is greater than root of current looked at tree portion. Assigns root to right node value. 
				root = root.getRight();				
			}
			
			else if (key < root.getData()) { // if key is smaller than root of current looked at tree portion then assigns root to left node value. 
				root = root.getLeft();		
			}
			else {	// if key = root.getData() then it's printed. 
				System.out.println("Searching for: " + key + " Found");
				return true;
			}
		}		
		System.out.println("Searching for: " + key + " Not Found");
		return false;
		
		
	}

}// class