package PackOne;
import PackTwo.BinaryTree;
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
public class BinaryTreeTest {

	/**
	 * main() method to test features of BinaryTree
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		
		int toBe[] = {26, 38, 34, 33, 70, 11, 25, 72, 14, 51,
				13, 77,  6, 40, 95, 84, 50, 35, 31, 54, 
				88, 74, 46, 86, 57, 39, 85, 80, 19, 92};
		
		for(int i = 0; i<toBe.length;i++) { // inserts all array values
			tree.insertInTree(toBe[i]);
		}
		System.out.println("Tree Display Using In-Order Traversal:");
		tree.displayInOrder();
		System.out.println("\n");
		System.out.println("Tree Display using Pre-Order Traversal:");		
		tree.displayPreOrder();		
		System.out.println("\n");		
		
		//search portion
				
		tree.search(26);
		tree.search(11);
		tree.search(38);
		tree.search(100);
	}//main()

}// class
