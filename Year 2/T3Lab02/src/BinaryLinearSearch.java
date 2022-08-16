import java.security.SecureRandom;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Assessment: lab02 
 * Duedate: Sept 19th 2021
 * Professor Name: James Mwangi
 * Student Name: Kyle Thomas    
 * Description: Program used to randomly generate an array and then perform specific searches.     
 * @see Lab02Main
 */
public class BinaryLinearSearch {
	/**
	 * Holds the 30 element array value.
	 */
	private static int[] arrayB;

	/**
	 * Instantiates the array to a value of 30.
	 */
	public BinaryLinearSearch() {

		arrayB = new int[30];

	}

	/**
	 * the main menu. In this menu, a large amount of the work takes place. Displays
	 * menu, once an option is chosen specific actions occur Upon performing a
	 * search, the time it took to record is done then printed along with the result
	 */
	public static void mainMenu() {

		Scanner input = new Scanner(System.in);
		BinaryLinearSearch a = new BinaryLinearSearch();

		boolean quit = false;

		while (!quit) {

			System.out.println("Select an option");
			System.out.println("1. Initialize and populate an array with 30 random integers.");
			System.out.println("2. Perform recursive binary and linear search.");
			System.out.println("3. Perform iterative binary and linear search.");
			System.out.println("4. Exit Program");
			try {

				int option = input.nextInt(); // determines which case is run

				switch (option) {

				case 1:
					a.generateRandomInts(); // generates the 30 random values to fill up the 30 element array

					break;

				case 2:

					// add something limiting input between 10 and 100. everything else prompts to
					// search for a new number

					int max = arrayB.length -1;

					System.out.println("What Number are you searching for?");
					int search = input.nextInt(); // Asks and accept the input value to be searched for in the array.
					long startC = System.nanoTime(); // Time recording begins here
					long startD = System.currentTimeMillis(); // also records times
					int position = recursivelinearSearch(arrayB, search, 0); // calls the method with the input and a
																				// minimum of 0
					int position2 = recursiveBinarySearch(arrayB, 0, max, search); // also calls the method

					if (position == -1) { // if the returned value in the linear search is -1 (searched value isn't present) then this is printed
						System.out.println(
								"The Number " + search + " Was not found in the array: Recursive Linear Search ");
						long end5 = System.nanoTime(); // ends time recording to perform action
						long end6 = System.currentTimeMillis(); // also ends time
						System.out.println("Time taken in nano seconds: " + (end5 - startC)); // subtracts end time with start time to calculate total execution time
						System.out.println("Time taken in Milliseconds: " + (end6 - startD)); // same calculation but in milliseconds
					}
					if (position != -1) {
						System.out.println("The Number " + search + " Was found at index of " + position
								+ ": Recursive Linear Search"); // Printed if the searched value is present in the array
						long end5 = System.nanoTime(); //acts the same as the above nanotime
 						long end6 = System.currentTimeMillis(); // //
						System.out.println("Time taken in nano seconds: " + (end5 - startC)); 
						System.out.println("Time taken in Milliseconds: " + (end6 - startD));
					}
					if (position2 == -1) {
						System.out.println( //this set of actions performs the same as the above statements.  
								"The Number " + search + " Was not found in the array: Recursive Binary Search"); // for these it's for the recursive binary search
						long end7 = System.nanoTime();
						long end8 = System.currentTimeMillis();
						System.out.println("Time taken in nano seconds: " + (end7 - startC));
						System.out.println("Time taken in Milliseconds: " + (end8 - startD));
						System.out.println("");

					} else if (position2 != -1) { // same as before, nothing new.
						System.out.println("The Number " + search + " Was found at index of " + position2
								+ ": Recursive Binary Search");
						long end7 = System.nanoTime();
						long end8 = System.currentTimeMillis();
						System.out.println("Time taken in nano seconds: " + (end7 - startC));
						System.out.println("Time taken in Milliseconds: " + (end8 - startD));
						System.out.println("");
					}

					break;

				case 3:
					// this set of actions perform the same as case 2. 
					// however rather than recursive methods, these apply for the interative searches of binary and linear

					System.out.println("What Number are you searching for?");
					int search2 = input.nextInt(); // holds the value for the int being searched for
					long startA = System.nanoTime(); // starts time recording
					long startB = System.currentTimeMillis(); // also starts time recording
					int position3 = interativeLinearSearch(arrayB, search2); // calls the linear search
					int position4 = interativeBinarySearch(arrayB, search2); // calls binary search

					if (position3 == -1) {
						System.out.println(
								"The Number " + search2 + " Was not found in the array: Interative Linear Search");
						long end1 = System.nanoTime();
						long end2 = System.currentTimeMillis();
						System.out.println("Time taken in nano seconds: " + (end1 - startA));
						System.out.println("Time taken in Milliseconds: " + (end2 - startB));

					}
					if (position3 != -1) {
						System.out.println("The Number " + search2 + " Was found at index of " + position3
								+ ": Interative Linear Search");
						long end1 = System.nanoTime();
						long end2 = System.currentTimeMillis();
						System.out.println("Time taken in nano seconds: " + (end1 - startA));
						System.out.println("Time taken in Milliseconds: " + (end2 - startB));

					}
					if (position4 == -1) {
						System.out.println(
								"The Number " + search2 + " Was not found in the array: Interative Binary Search");
						long end3 = System.nanoTime();
						long end4 = System.currentTimeMillis();
						System.out.println("Time taken in nano seconds: " + (end3 - startA));
						System.out.println("Time taken in Milliseconds: " + (end4 - startB));
						System.out.println("");

					} else if (position4 != -1) {
						System.out.println("The Number " + search2 + " Was found at index of " + position4
								+ ": Interative Binary Search");
						long end3 = System.nanoTime();
						long end4 = System.currentTimeMillis();
						System.out.println("Time taken in nano seconds: " + (end3 - startA));
						System.out.println("Time taken in Milliseconds: " + (end4 - startB));
						System.out.println("");
					}

					break;

				case 4:
					quit = true; // quits program
					input.close(); // closes input
					break;
				default:
					System.err.println("Choose option 1 through 4");
					System.out.println(); // if user fails to enter 1-4 this is shown

				}
			} catch (InputMismatchException imp) {

				input.nextLine();
				System.err.println("You must insert a number");  //prints out if a number is not placed into the response
				System.out.println();
			}

		}
		System.out.println("Cya");

	}

	/**
	 * A method to generate random ints for the array being worked upon. 
	 */
	public void generateRandomInts() { 
		int upperBound = 100; // holds the max generatable value by the secure random
		int lowerBound = 10; // holds lowest value generatable by secure random
		SecureRandom random = new SecureRandom();

		for (int i = 0; i < arrayB.length; i++) {

			arrayB[i] = random.nextInt(upperBound - lowerBound + 1) + lowerBound; // a little but of math play in order to get the generator to exclude values 0 through 9
		

		}
		System.out.println("The Unsorted array of random values:");
		toString(); // prints the unsorted list of values
		System.out.println("The Sorted array random values:");
		arraySort(); // calls the sort method to sort the array

	}

	/**
	 * A method to take the unsorted array and sort the values from lowest to highest
	 */

	public void arraySort() {

		boolean swapDone = true;

		while (swapDone) { // keeps the loop going

			swapDone = false; // placed in order to escape from the while loop when the sort has been completed
			// if it was already in order it knows it doesn't need to swap anything

			for (int i = 0; i < arrayB.length - 1; i++) {
				if (arrayB[i] > arrayB[i + 1]) {
					swapDone = true; //sets to true once again so the loop continues as "something swapped"
					int temp = arrayB[i]; // a 3 way movement of values happens here
					arrayB[i] = arrayB[i + 1]; //  in order to work correctly You need a third variable so a temp one is used to shift element locations
					arrayB[i + 1] = temp; // if no temp value, then generated elements would just be getting deleted/overwritten

				}

			}

		}
		toString(); // prints sorted array

	}

	/** prints out the elements in the array
	 * this is used during the binary searches to show array elements without dropped portions
	 * 
	 * @param arrayB the array holding the element values
	 * @param min minimum bound of the array
	 * @param max maximum bound of the array
	 */
	public static void remainingElements(int[] arrayB, int min, int max) {

		for (int i = min; i < max; i++) { // the parameters change depending on the method so setting the 			
			System.out.print(arrayB[i] + " "); // increment to be based on the value of the max is appropriate
		}

	}

	/** Performs a Interative binary Search on the array
	 * 
	 * @param arrayB The array holding element values
	 * @param search The value which is being searched for	 
	 * @return -1 states that the value being searched for is not present
	 */
	public static int interativeBinarySearch(int[] arrayB, int search) {

		int min = 0; // minimum bound
		int max = arrayB.length - 1; // accounts for 0
		while (min <= max) {
			int mid = min + (max - min) / 2; // determines the mid element value 

			if (arrayB[mid] == search) { // if the mid value = the searched for value then it is printed in the switch case
				remainingElements(arrayB, min, max + 1); // prints out the array at this point
				System.out.println("");
				return mid; // returns the result
			}

			if (arrayB[mid] < search) {
				remainingElements(arrayB, min, max + 1); // prints out the array at this point
				System.out.println("");
				min = mid + 1; // if the searched for value is on the right side of the array this is used
			}

			else {
				remainingElements(arrayB, min, max + 1); // prints out the array at this point
				System.out.println("");
				max = mid - 1; // used of searched for value is on the left side of the array
			}

		}
		return -1; // if searched for element is not present

	}

	/**Performs a Interative Linear search
	 * 
	 * @param arrayB holds the element values
	 * @param search the number being searched for in the array
	 * @return -1 states that the value being searched for is not present 
	 */
	public static int interativeLinearSearch(int arrayB[], int search) {

		int max = arrayB.length;
		for (int i = 0; i < max;) { // goes through each value individually with nothing special
			if (arrayB[i] == search) {// if the value = searched value it is returned. Else it moves onto the next one until the end
				return i;
			}
			if (arrayB[i] != search) {
				i++;
			}
		}

		return -1; // if searched for element is not present
	}

	/** recursive linear search - performs a linear search recursively
	 *  
	 * @param arrayB holds the element values
	 * @param search the number being searched for in the array
	 * @param initialindex Basically a counter that moves up each time the method is called
	 * @return the method its self as it is recursive
	 */
	public static int recursivelinearSearch(int arrayB[], int search, int initialindex) {

		if (initialindex >= arrayB.length) { // if searched for element is not present
			System.out.println("");
			return -1;
		}
		if (arrayB[initialindex] == search) { // goes through each value individually with nothing special
			System.out.println("");// if the value = searched value it is returned. Else it moves onto the next one until the end
			return initialindex;
		}
		return recursivelinearSearch(arrayB, search, initialindex + 1); // calls the method its self to move along index

	}

	/**Recursively performs a Binary Search on the array
 	 * 
	 * @param arrayB The array holding the elements
	 * @param min minimum bound of the array
	 * @param max maximum bound of the array
	 * @param search the number being searched for through the array
	 * @return the method its self as it is recursive. 
	 */
	public static int recursiveBinarySearch(int arrayB[], int min, int max, int search) {

		// if (search > max) {
		// return -1;
		// }		

		if (max >= min) {

			int mid = (min + max) / 2; // calculates the mid point as a start point
			remainingElements(arrayB, min, max); // prints out the array at this point
			if (search == arrayB[mid]) { // if the value = searched value it is returned. Else it moves onto the next one until the end
				System.out.println("");
				return mid;
			}

			else if (search < arrayB[mid]) { // triggers if the searched for value is below the mid point, thus in the lower half of the array 
				System.out.println("");
				return recursiveBinarySearch(arrayB, min, mid - 1, search); // calls the method its self to move along index
			}
			System.out.println("");
			return recursiveBinarySearch(arrayB, mid + 1, max, search); // calls the method its self to move along index if the searched for value is above the mid point

		}

		return -1; // if searched for element is not present

	}

	/**
	 * Prints out the array
	 */
	@Override
	public String toString() {
		for (int i = 0; i < arrayB.length; i++) {

			System.out.print(arrayB[i] + " ");
		}
		System.out.println("");

		return "";
	}

}
