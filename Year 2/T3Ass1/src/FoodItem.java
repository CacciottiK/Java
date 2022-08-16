import java.util.Scanner;

/**
 * Assessment: Assignment 1 
 * Duedate: October 3rd 2021 
 * Professor Name: James Mwangi 
 * Student Name: Kyle Thomas 
 * Description: A simple store inventory manager program * 
 * @see Preserve
 * @see Vegetable
 * @see Fruit
 * @see Assign1
 * @see Inventory
 * @see FoodItem
 */
public class FoodItem {
	/**
	 * Item Code unique to each food object
	 */
	private int itemCode;
	/**
	 * Name of Item(s)
	 */
	private String itemName;
	/**
	 * Cost of Item From Vendor
	 */
	private float itemPrice;
	/**
	 * Count of items in stock after purchase
	 */
	private int itemQuantityInStock;
	/**
	 * Cost of items being sold
	 */
	private float itemCost;

	/**
	 * Builds the skeleton of a food item. a food item has these properties
	 */
	FoodItem() {
		itemCode = 0;
		itemName = "";
		itemPrice = 0.0f;
		itemQuantityInStock = 0;
		itemCost = 0.0f;

	}

	/**
	 * Method created to update the item quantity of a created FoodItem object. As
	 * this method is boolean, it has two parts which one returns true, and the
	 * other returns false. A false can only be triggered in the case where the
	 * Itemquantityinstock is LESS than what is being sold (subtracted) Since, well
	 * you can't have a negative inventory for this program. Maybe in the future it
	 * could mean pre-orders or something.
	 * 
	 * Anyways, methods returns true if no errors occur. Since there are no quantity
	 * caps, no matter how high the quantity is it will always return true.
	 * 
	 * @param amount the amount of stock being either added or subtracted from the
	 *               stock count
	 * @return returns whether the action was able to be complete (true) or not
	 *         (false)
	 */
	public boolean updateItem(int amount) {
		if (amount < 0) {
			if (Math.abs(amount) <= itemQuantityInStock) // accounts for removing stock the method that calls this
															// portion changes the number to negative
			{
				itemQuantityInStock += amount; // adds the values - selling portion
				return true;
			} else {
				return false;
			}
		} else {
			itemQuantityInStock += amount; // adds the values - Buying portion
			return true;
		}

	}

	/**
	 * checks if the inputed user item code is the same the checked item code. If
	 * the code is the same, true is returned. else false.
	 * 
	 * @param foodItem Checks the food item object for the item codes
	 * @return returns true if the item code exists or false if it does not.
	 */
	public boolean isEqual(FoodItem foodItem) {

		if (foodItem.itemCode == this.itemCode) { // checks if the code received is the same as the the it's comparing
													// to.
			return true; // true if same.
		}
		return false; // if false then it's not the same.

	}

	/**
	 * Receives user input information to create a food item object.
	 * 
	 * called as a super() and it changes based on what object type is being made.
	 * 
	 * @param input the user input
	 * @return returns true if nothing fails
	 */
	public boolean addItem(Scanner input) {

		while (true) {
			System.out.print("Enter the code for the item: ");

			if (!input.hasNextInt()) {
				System.err.println("You Need to Enter a Proper Number \n");

				input.nextLine();
			} else {
				itemCode = input.nextInt();
				break;

			}
		}

		System.out.println("Enter the name for the item: ");
		input.nextLine(); // gets and set the item name
		itemName = input.nextLine();

		while (true) {

			System.out.println("Enter the Quantity for the item: ");

			if (!input.hasNextInt()) { // checks for int

				System.err.println("Need to Enter a Proper Number \n");

				input.nextLine();

			} else {
				itemQuantityInStock = input.nextInt();
				
				if (itemQuantityInStock < 0) {
					System.out.println("You can't have a negative Quantity\n");
					input.nextLine();
				} else
				
				break;
			}

		}

		while (true) {

			System.out.println("Enter cost of the Item: ");

			if (!input.hasNextFloat()) { // checks for float

				System.err.println("Need to Enter a Proper Number \n");

				input.nextLine();

			} else {
				itemCost = input.nextFloat();
				
				if (itemCost < 0) {
					System.out.println("You can't have a negative Item Cost\n");
					input.nextLine();
				}else
					
				break;
			}

		}

		while (true) {

			System.out.println("Enter the sales price of the Item: ");

			if (!input.hasNextFloat()) {// checks for float

				System.err.println("Need to Enter a Proper Number \n");

				input.nextLine();

			} else {
				itemPrice = input.nextFloat();
				
				if (itemPrice < 0) {
					System.out.println("You can't have a negative Price\n");
					input.nextLine();
				}else
					
				break;
			}

		}

		return true;

	}

	/**
	 * method to accept the input of a Code for an item not sure why this exists tbh
	 * 
	 * @param input user input
	 * @return If code is value return true, else false.
	 */
	public boolean inputCode(Scanner input) {

		System.out.println("Enter a Valid Item Code: ");
		if (input.hasNextInt()) { // checks for int
			itemCode = input.nextInt();
			return true;
		} else {
			input.nextLine();

		}
		return false;

	}

	/**
	 * simply prints out a formatted version of the information. called by super()
	 * by other tostring to throw on additional printable properties
	 */
	public String toString() {
		String name = "";
		String price = String.format(" price: $%.2f", itemPrice);
		name = "FoodItemCode: " + itemCode + " Name: " + itemName + " ItemCost: " + itemCost + " StockCount: "
				+ itemQuantityInStock + price;
		return name; // formats the object information
	}

}
