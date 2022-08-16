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
	
	/**Builds a Vegetable through reading a file
	 * 
	 * @param itemCode The itemCode of the object
	 * @param itemName Item name of the object
	 * @param itemQuantityInStock Amount of the object
	 * @param itemCost cost of the object
	 * @param itemPrice Price of the object
	 * @param farmName Name of the supplier
	 */

	Vegetable(int itemCode, String itemName, int itemQuantityInStock, float itemCost, float itemPrice,
			String farmName) {

		super(itemCode, itemName, itemQuantityInStock, itemCost, itemPrice);
		this.farmName = farmName;

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
	/**
	 * Formats the output which is being printed onto the text file generated. Adds a char so it can be read properly into the program
	 */
			
	@Override
	public String outputItem() {
		return "v\n " + super.outputItem() + farmName;
	}

}
