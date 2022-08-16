import java.util.InputMismatchException;
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
public class Inventory {
	/**
	 * MAX Amount of Food item objects
	 */
	private final int MAX = 20;
	/**
	 *  Used as a return type constant to say something does not exist
	 */
	private final int DOES_NOT_EXIST = -1;
	/**
	 * Holds the food item objects
	 */
	private FoodItem[] inventory;
	/**
	 * Stores the number of items count
	 */
	private int numItems = 0;

	/**
	 * initializes an inventory array when making a new inventory
	 */
	Inventory() {

		inventory = new FoodItem[MAX];

	}

	/**
	 * Accepts the food item object and iterates through the inventory array
	 * checking through the isEqual method if the food item code exists already or
	 * not.
	 * 
	 * @param FoodItem accepts the food item object
	 * @return returns the i (index) of the object location or DOES_NOT_EXIST (-1)
	 *         if the object does not exist in the array
	 */
	public int alreadyExists(FoodItem FoodItem) {

		for (int i = 0; i < numItems; i++) {

			if (inventory[i].isEqual(FoodItem)) { // runs through the array checking Food item codes. If true, then the index is returned
				return i;
			}
		}
		return DOES_NOT_EXIST; // if code does not exist -1 or DOES_NOT_EXIST is returned. 

	}

	/**
	 * A sub menu to the main menu which asks the user what type of food item they
	 * wish to create calls the appropriate addItem method after choice
	 * 
	 * @param input user input
	 * @return returns true if the transaction works. False if there is no inventory available to sell. 
	 */
	public boolean addItem(Scanner input) {

		int ab = 0; // random temp variable to cause trouble :D
		FoodItem food = null; // food item.
		
		while (ab != 1) {

			System.out.println("Do you wish to add a Fruit(f), Vegetable(v) or Preservative(p)?");

			char choice = input.next().charAt(0);

			if (choice == 'f' || choice == 'F') { // Creates a Fruit
				input.nextLine();
				food = new Fruit();
				food.addItem(input);
				ab = 1;
				break;

			}

			if (choice == 'v' || choice == 'V') { // creates a Vegetable
				input.nextLine();
				food = new Vegetable();
				food.addItem(input);
				ab = 1;
				break;

			}

			if (choice == 'p' || choice == 'P') { //creates a Preservative
				input.nextLine();
				food = new Preserve();
				food.addItem(input);
				ab = 1;
				break;

			}

			else if (choice != 'f' || choice != 'F' || choice != 'v' || choice != 'V' || choice != 'p'
					|| choice != 'P') { // If anything other than f/v/p are entered then it loops.
				System.err.println("Invaled Menu Option");
				System.out.println();

			}

		}

		if (alreadyExists(food) == DOES_NOT_EXIST) {
			inventory[numItems] = food; // if the item doesn't exist it adds the item to the array
			numItems++; // increases index for the next item to come along.
			return true;

		} else {
			System.out.println("You wasted your time creating something which already exists. \n");
			return false; // if it exists it scraps everything.
		}

	}

	/**
	 * Method which Updates starts the process for the quantity update. Prompts the
	 * user for the code which they are searching for, then uses said code in the
	 * alreadyexists method to check if the code already exists. If the code does
	 * not exist then the method stops there and returns to menu
	 * 
	 * 
	 * @param input     user input
	 * @param buyOrSell a conditional statement to guide the method through a
	 *                  selling process or a buying process
	 * @return true to continue and perform the update or false to deny the update.
	 */
	public boolean updateQuantity(Scanner input, boolean buyOrSell) {

		FoodItem food = new FoodItem(); //creates temp variable for checking if an id exists or not
		int shift = 0; // holds the value being sold or bought
		int currentCheck = 0; // also temp value

		food.inputCode(input); //assigns temp variable to code number

		currentCheck = alreadyExists(food); // checks code number 

		if (currentCheck == DOES_NOT_EXIST) { // if code number does not exist it's terminated
			System.out.println("Code Does not exist");
			System.out.println();
			return false;
		}
		input.nextLine();
		while (true) { // if code exists, a loop asking for a buy/sell number is asked. 

			System.out.println("Enter a Valid Number:");
			if (!input.hasNextInt()) { // prevents non ints
				System.err.println("That's not a valid number \n");
				input.nextLine();
			} else {
				shift = input.nextInt(); //assigns the number to shift
				if (shift > 0) {
					break; // checks for negative numbers
				} else {
					System.err.println("A negative number is not valid: \n");
					input.nextLine();
				}
			}

		}

		if (buyOrSell == true) { // buy action

			if (inventory[currentCheck].updateItem(shift)) { // adds the shift value to the item count value
				System.out.println("Quantity Has been Updated.");
				System.out.println();
				return true;
			} else {
				return false; // since there is really no cap this is just here for formalities. 
			}
		}

		else { // sell action
			input.nextLine();

			if (inventory[currentCheck].updateItem(-shift)) { // subtracts the shift value from the item count value
				System.out.println("Quantity Has been Updated.");
				System.out.println();
				return true;
			} else {
				System.out.println("Not Enough Stock to Sell \n"); // If not enough stock to sell, returns false
				return false;
			}
		}

	}

	/**
	 * Main menu to the program. Acts like a director based on user choice
	 * 
	 * @param input User input into the menu
	 */
	public static void mainMenu(Scanner input) {

		Inventory inventory = new Inventory();
		boolean quit = false;		

		while (!quit) {

			System.out.println("Select one of the Following ");
			System.out.println("1. Add item to the Inventory ");
			System.out.println("2. Display Current Inventory ");
			System.out.println("3. Buy Item(s) ");
			System.out.println("4. Sell Item(s) ");
			System.out.println("5. Exit the Program. ");
			
			try {

				int option = input.nextInt();	// determines which case is run

				switch (option) {

				case 1:

					inventory.addItem(input);

					break;

				case 2:

					System.out.println("Inventory:");
					System.out.println(inventory); //prints inventory made possible from string builder

					break;
					
				case 3:							
					
					boolean is = true;
					for ( int i = 0; i < inventory.inventory.length; i++) {
					if(inventory.inventory[i] != null) {						
						inventory.updateQuantity(input, true); // calls method with a true, stating it's for buying
						is = false;
						break;
					  }
					}
					if (is) { //checks if array is empty
						System.out.println("You're Broke. You have no Stock...\n");
					}
					
				//	inventory.updateQuantity(input, true);
					// calls method with a true, stating it's for buying

					break;

				case 4:
					
					boolean isa = true;
					for ( int i = 0; i < inventory.inventory.length; i++) {
					if(inventory.inventory[i] != null) {						
						inventory.updateQuantity(input, false); // calls method with a false, stating it's for selling.
						isa = false;
						break;
					  }
					}
					if (isa) { // checks if array is empty
						System.out.println("You're Broke. You have no Stock...\n");
					}

					//inventory.updateQuantity(input, false); // calls method with a false, stating it's for selling.

					break;

				case 5:
					quit = true; // quits program
					input.close(); // closes input
					break;

				default:
					System.err.println("Choose option 1 through 5");
					System.out.println(); // if user fails to enter 1-4 this is shown

				}
			} catch (InputMismatchException imp) {

				input.nextLine();
				System.err.println("An input Mismatch Error Has Occured"); // prints out if a number is not placed into
																			// the response				
				System.out.println();
			}

		}
		System.out.println("Cya");

	}

	/**
	 * Prints out the entire array. This is the super(). Prints out the added
	 * information specific to each object on their lines.
	 */	
	public String toString() {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numItems; i++) {
			sb.append(inventory[i] + "\n"); // iterates through array. Prints out objects.
		}

		return sb.toString();
	}

}
