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
public class Preserve extends FoodItem {
/**
 * 	holds the jar size of a preserve object
 */
	private int jarSize;
	/**
	 * a preservative
	 */
	Preserve(){	
		
	}
	/**Builds a Preserve through reading a file
	 * 
	 * @param itemCode The itemCode of the object
	 * @param itemName Item name of the object
	 * @param itemQuantityInStock Amount of the object
	 * @param itemCost cost of the object
	 * @param itemPrice Price of the object
	 * @param jarSize Size of the jar holding the Preserve
	 */
	
    Preserve(int itemCode, String itemName, int itemQuantityInStock, float itemCost, float itemPrice, int jarSize) {
		
		super(itemCode,itemName,itemQuantityInStock,itemCost,itemPrice);
		this.jarSize = jarSize;
		
	}
	/**
	 * Additional information asked when creating a preservative object
	 */
	
	@Override
	public boolean addItem(Scanner input) {
		
		boolean boo = false;
		
		if (super.addItem(input)) {
			
			System.out.println("Enter size of the jar in milliliters: ");
			jarSize = input.nextInt(); // asks for size			
			return true;
			
		}else		
		
		return boo;		// returns false
		
	}
	/**
	 * Additional print information when creating a preserve object.
	 */
	
	@Override
	public String toString()
	{
		String size = ""; 
		size = " Size of jar: " + jarSize + "mL";
		return super.toString() + size; // calls the previous tostring. Adds this to it. 
	}
	
	/**
	 * Formats the output which is being printed onto the text file generated. Adds a char so it can be read properly into the program
	 */
	@Override
	public String outputItem() {
		return "p\n " + super.outputItem() + jarSize;
	}

}