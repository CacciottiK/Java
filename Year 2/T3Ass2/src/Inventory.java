import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
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
public class Inventory {
	/**
	 * MAX Amount of Food item objects
	 */
	private final int MAX = 20;
	/**
	 * Used as a return type constant to say something does not exist
	 */
	private final int DOES_NOT_EXIST = -1;
	/**
	 * Holds the food item objects
	 */
	private ArrayList<FoodItem> inventory;
	/**
	 * Stores the number of items count
	 */
	private int numItems = 0;

	/**
	 * initializes an inventory array when making a new inventory
	 */
	Inventory() {

		inventory = new ArrayList<FoodItem>();

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

		for (int i = 0; i < inventory.size(); i++) {

			if (inventory.get(i).isEqual(FoodItem)) { // runs through the array checking Food item codes. If true, then
														// the index is returned
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
	 * @return returns true if the transaction works. False if there is no inventory
	 *         available to sell.
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

			if (choice == 'p' || choice == 'P') { // creates a Preservative
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
			inventory.add(food);
			// inventory[numItems] = food; // if the item doesn't exist it adds the item to
			// the array
			// numItems++; // increases index for the next item to come along.
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

		FoodItem food = new FoodItem(); // creates temp variable for checking if an id exists or not
		int shift = 0; // holds the value being sold or bought
		int currentCheck = 0; // also temp value

		food.inputCode(input); // assigns temp variable to code number

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
				shift = input.nextInt(); // assigns the number to shift
				if (shift > 0) {
					break; // checks for negative numbers
				} else {
					System.err.println("A negative number is not valid: \n");
					input.nextLine();
				}
			}

		}

		if (buyOrSell == true) { // buy action

			if (inventory.get(currentCheck).updateItem(shift)) { // adds the shift value to the item count value
				System.out.println("Quantity Has been Updated.");
				System.out.println();
				return true;
			} else {
				return false; // since there is really no cap this is just here for formalities.
			}
		}

		else { // sell action
			input.nextLine();

			if (inventory.get(currentCheck).updateItem(-shift)) { // subtracts the shift value from the item count value
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
			System.out.println("5. Search for Item ");
			System.out.println("6. Save Inventory to File ");
			System.out.println("7. Read Inventory from File ");
			System.out.println("8. Exit the Program. ");

			try {

				int option = input.nextInt(); // determines which case is run

				switch (option) {

				case 1:

					inventory.addItem(input);

					break;

				case 2:

					Collections.sort(inventory.inventory, new FoodItem());
					System.out.println("Inventory:");
					System.out.println(inventory); // prints inventory made possible from string builder

					break;

				case 3:

					boolean is = true;
					for (int i = 0; i < inventory.inventory.size(); i++) {
						if (inventory.inventory.get(i) != null) {
							inventory.updateQuantity(input, true); // calls method with a true, stating it's for buying
							is = false;
							break;
						}
					}
					if (is) { // checks if array is empty
						System.out.println("You're Broke. You have no Stock...\n");
					}

					// inventory.updateQuantity(input, true);
					// calls method with a true, stating it's for buying

					break;

				case 4:

					boolean isa = true;
					for (int i = 0; i < inventory.inventory.size(); i++) {
						if (inventory.inventory.get(i) != null) {
							inventory.updateQuantity(input, false); // calls method with a false, stating it's for
																	// selling.
							isa = false;
							break;
						}
					}
					if (isa) { // checks if array is empty
						System.out.println("You're Broke. You have no Stock...\n");
					}

					// inventory.updateQuantity(input, false); // calls method with a false, stating
					// it's for selling.

					break;

				case 5:

					System.out.println("Enter an Item Code to search for: ");

					int searching = input.nextInt(); // searching for an item code

					int position = linearSearch(inventory.inventory, searching);

					if (position == -1) { // if the returned value in the linear search is -1 (searched value isn't
											// present) then this is printed
						System.out.println(
								"The Number " + searching + " Was not found in the inventory, maybe search again?\n ");
					} else
						//System.out.println("The ItemCode " + searching + " Was found at the index of " + position);
					
					
					

					break;

				case 6:

					Collections.sort(inventory.inventory, new FoodItem()); // sorts the inventory before printing it out
																			// to a file

					inventory.createOutputFile(input); // prints to a file
					break;

				case 7:

					inventory.openFile(input); // reads from file

					break;

				case 8:
					quit = true; // quits program
					input.close(); // closes input
					break;

				default:
					System.err.println("Choose option 1 through 8");
					System.out.println(); // if user fails to enter 1-8 this is shown

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
		for (int i = 0; i < inventory.size(); i++) {
			sb.append(inventory.get(i) + "\n"); // iterates through array. Prints out objects.
		}

		return sb.toString();
	}

	/**
	 * 
	 * A method to choose the name of a file for which the inventory data is
	 * exported to
	 * 
	 * @param input Accepts the user input. looks for file name
	 */

	public void createOutputFile(Scanner input) {

		if (inventory.isEmpty()) { // a standard check to see if the inventory array is empty
			System.out.println("Can't print an empty array to a file\n");
		} else {

			String fileName;
			FileWriter outputStuff = null;

			System.out.println("Enter a name of the file you wish to create: ");
			fileName = input.next(); // chooses file name

			try {

				outputStuff = new FileWriter(fileName + ".txt"); // adds .txt to the end so user doesn't have to type
																	// it.
				saveToFile(outputStuff); // passes the file name into the savetofilemethod.

			} catch (IOException ae) {

				System.out.println("The File name " + fileName + " Could not be created"); // if there is an error this
																							// is printed

			}

		}
	}

	/**
	 * Writes the inventory array data into a text file.
	 * 
	 * @param outputStuff accepts the file name entered from CreateOutputFile
	 *                    method.
	 */

	public void saveToFile(FileWriter outputStuff) {

		try {

			for (int i = 0; i < inventory.size(); i++) { // loops

				outputStuff.append(inventory.get(i).outputItem() + "\n"); //
			}
			outputStuff.close();

		} catch (IOException iE) {

			System.err.println("Error With File Writing Somewhere");

		}

	}

	/**
	 * A method to accept an input which chooses the file name which is needed to be
	 * opened and then read from the opened file generates information into the
	 * program.
	 * 
	 * @param input user input for file name entered
	 */

	public void openFile(Scanner input) {

		String fileBeingOpened;
		Scanner loadedFile = null;

		System.out.println("Enter the name of the text file you want to extract information from");
		fileBeingOpened = input.next(); // choose file name which we're taking data from
		try {

			File tempFile = new File(fileBeingOpened); // makes a temp file. Breaks without it.
			if (tempFile.exists()) { // checks if file name chosen exists

				loadedFile = new Scanner(tempFile); // if file name exists then a new scanner is made

				if (loadedFile.hasNextLine()) { // checks if file is empty. If not, then the scanner reads the lines and
												// imports them

					readFromFile(loadedFile); // passes the file name into the readFromFile method
					loadedFile.close(); // closes the reader. Else nothing is saved.
				} else
					System.out.println("You can't load an empty file dummy \n");

			} else {
				System.out.println(fileBeingOpened + " Could Not be Found.");
			}

		} catch (Exception a) {

		}

	}

	/**
	 * Reads from a file if it's in the specific format. The data is entered into
	 * the inventory array in the format similar to how a new object is created.
	 * 
	 * @param input Accepts the inputed file name from then openFile method
	 */

	public void readFromFile(Scanner input) {

		FoodItem datFood = null; // all variables are initialized.
		char itemType;
		int itemCode = 0;
		int itemQuantityInStock = 0;
		float itemCost = 0f;
		float itemPrice = 0;
		String itemName = null;

		try {

			while (input.hasNextLine()) { // if there is a line ton read then it continues. BUilds as many objects as
											// there are lines which are fulfilled.

				itemType = input.next().charAt(0); // builds a spcific object based on this char value.
				itemCode = input.nextInt(); // each input is read from file and builds the object properties.
				itemName = input.nextLine() + input.nextLine();
				itemQuantityInStock = input.nextInt();
				itemCost = input.nextFloat();
				itemPrice = input.nextFloat();

				if (itemType == 'p') { // if char is p, then a preserve is created from file

					int jarSize = 0;

					if (input.hasNextInt()) // accepts the specific property to a preserve
						jarSize = input.nextInt();

					datFood = new Preserve(itemCode, itemName, itemQuantityInStock, itemCost, itemPrice, jarSize);

					if (alreadyExists(datFood) == DOES_NOT_EXIST) {
						// if the item doesn't exist it adds the item to the array
						inventory.add(datFood); // adds the item to inventory

					} else if (alreadyExists(datFood) != DOES_NOT_EXIST){ // if it doesn't equal this constant then the ID already exists. Terminates method if false. 
						
						System.out.println("Seems to be an item with this ID already in the inventory\n");
						break;
					}
					

				}

				if (itemType == 'f') { // if char is f, then a fruit is created from file

					String orchardName = null;

					if (input.hasNextLine()) // accepts the specific property to a fruit
						orchardName = input.nextLine() + input.nextLine();

					datFood = new Fruit(itemCode, itemName, itemQuantityInStock, itemCost, itemPrice, orchardName);

					if (alreadyExists(datFood) == DOES_NOT_EXIST) {
						// if the item doesn't exist it adds the item to the array
						inventory.add(datFood); // adds the item to inventory

					} else if (alreadyExists(datFood) != DOES_NOT_EXIST){ // if it doesn't equal this constant then the ID already exists. Terminates method if false. 
						
						System.out.println("Seems to be an item with this ID already in the inventory\n");
						break;
					}

				}

				if (itemType == 'v') { // if char is v, then a vegetable is created from file

					String farmName = null;

					if (input.hasNextLine()) // accepts the specific property to a vegetable
						farmName = input.nextLine() + input.nextLine();

					datFood = new Vegetable(itemCode, itemName, itemQuantityInStock, itemCost, itemPrice, farmName);
					if (alreadyExists(datFood) == DOES_NOT_EXIST) {
						// if the item doesn't exist it adds the item to the array
						inventory.add(datFood); // adds the item to inventory

					} else if (alreadyExists(datFood) != DOES_NOT_EXIST){ // if it doesn't equal this constant then the ID already exists. Terminates method if false. 
						
						System.out.println("Seems to be an item with this ID already in the inventory\n");
						break;
					}

				}
			}

		} catch (Exception b) {

		}

	}

	/**
	 * A linear search method to find a specific item code ID the user is searching
	 * for.
	 * 
	 * @param array  Accepts the inventory arraylist as a param
	 * @param search the itemCode which the user inputted to search for
	 * @return returns either the index of the item code in the inventory or -1
	 *         indicating that the itemCode is not in the inventory.
	 */

	public static int linearSearch(ArrayList<FoodItem> array, int search) {

		int i = 0;
		for (FoodItem check : array) { // runs through the array

			if (check.getID() == search) {// checks id to the search value
				System.out.println(check);
				return i;
			}
			i++; // increments the index.
		}

		return -1; // if searched for element is not present
	}

}
