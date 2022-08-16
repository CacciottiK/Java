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
	/**Builds a Fruit through reading a file
	 * 
	 * @param itemCode The itemCode of the object
	 * @param itemName Item name of the object
	 * @param itemQuantityInStock Amount of the object
	 * @param itemCost cost of the object
	 * @param itemPrice Price of the object
	 * @param orchardName Name of the supplier
	 */
	
	Fruit(int itemCode, String itemName, int itemQuantityInStock, float itemCost, float itemPrice, String orchardName) {
		
		super(itemCode,itemName,itemQuantityInStock,itemCost,itemPrice);
		this.orchardName = orchardName;
		
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
	
	/**
	 * Formats the output which is being printed onto the text file generated. Adds a char so it can be read properly into the program
	 */
	
	@Override
	public String outputItem() {
		return "f\n " + super.outputItem() + orchardName;
	}
	
	

}