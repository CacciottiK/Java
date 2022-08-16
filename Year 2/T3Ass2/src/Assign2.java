import java.util.Scanner;
/**
 * Assessment: Assignment 2
 * Duedate: October 17th 2021 
 * Professor Name: James Mwangi 
 * Student Name: Kyle Thomas
 * Description: A Store management program with the ability to import and export inventories 
 * 
 * @see Preserve
 * @see Vegetable
 * @see Fruit
 * @see Assign2
 * @see Inventory
 * @see FoodItem
 */
/**
 * Main method
 */
public class Assign2 {
/**
 * 
 *  Prints the main menu, and in overall Starts the program.
 *  
 *  @param args The Method Main for the program. The Head honcho.
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Scanner creation
		 */
		Scanner input = new Scanner(System.in);
		/**
		 * Calls the main menu/program
		 */
		Inventory.mainMenu(input);
		
		

	}

}