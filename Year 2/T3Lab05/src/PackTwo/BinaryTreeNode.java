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
 *
 */

public class BinaryTreeNode {
	private int data;
	private BinaryTreeNode left;
	private BinaryTreeNode right;

	/**
	 * Construct new tree node using these contents
	 * @param data contents of node
	 */
	public BinaryTreeNode(int data) {
		left = null;
		right = null;
		this.data = data;
	}

	/**
	 * retrieve the contents of the node
	 * @return contents of node
	 */
	public int getData() {
		return data;
	}

	/**
	 * retrieve the reference to the left hand subtree
	 * @return reference to left subtree
	 */
	public BinaryTreeNode getLeft() {
		return left;
	}

	/**
	 * retrieve the reference to the right hand subtree
	 * @return reference to right subtree
	 */
	public BinaryTreeNode getRight() {
		return right;
	}

	/**
	 * create new node and insert it in the proper location 
	 * using BST logic
	 * @param newData contents of node which will be inserted
	 */
	public void insert(int newData) {
		if (newData < data) {
			if (left == null)
				left = new BinaryTreeNode(newData); // assign to empty left node on current root value
			else
				left.insert(newData);
		} else if (newData > data) {
			if (right == null)
				right = new BinaryTreeNode(newData); // assign to empty right node on current root value
			else
				right.insert(newData);
		} else
			System.out.println("Duplicate ? not adding" + newData);
	}// insert()
		
	
	

}// class