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

}
