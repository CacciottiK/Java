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
public class Fruit extends FoodItem {
	/**
	 * Holds the Name of the supplier
	 */
	private String orchardName;
		/**
		 * 	a fruit 
		 */
	Fruit() {	
		
	}
	/**
	 * Additional information asked from when creating a fruit object
	 */
	@Override
	public boolean addItem(Scanner input) {

		boolean boo = false;

		if (super.addItem(input)) {
			
			input.nextLine();

			System.out.println("Enter the name of the supplier: ");
			orchardName = input.nextLine();  //asks and holds the supplier name
			return true;
			

		} else

			return boo;
	}
	/**
	 * Additional information to print when creating a fruit object. 
	 */
	@Override
	public String toString()
	{
		String supName = "";
		supName = " Supplier: " + orchardName;
		return super.toString() + supName; // calls the previous tostring. Adds this to it. 
	}
	
	

}
