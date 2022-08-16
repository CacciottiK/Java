import java.util.Scanner;
/**
 * Assessment: Assignment 1
 * Duedate: October 3rd 2021
 * Professor Name: James Mwangi
 * Student Name: Kyle Thomas    
 * Description: A simple store inventory manager program
 * @see Preserve
 * @see Vegetable
 * @see Fruit
 * @see Assign1
 * @see Inventory
 * @see FoodItem
 */
public class Vegetable extends FoodItem {
/**
 * Holds farm supplier name
 */
	private String farmName;
/**
 * a veggie
 */
	Vegetable() {

	}
/**
 * Additional information asked from when creating a vegetable object
 */
	@Override
	public boolean addItem(Scanner input) {

		boolean boo = false;

		if (super.addItem(input)) {
			
			input.nextLine();

			System.out.println("Enter the name of the supplier: ");
			farmName = input.nextLine(); // asks and holds farm name			
			return true;

		} else

			return boo;
	}
/**
 * Additional information printed when creating a vegetable object
 */
	@Override
	public String toString() {
		String supName = "";
		supName = " Supplier: " + farmName;
		return super.toString() + supName; // calls the previous tostring. Adds this to it. 
	}

}
