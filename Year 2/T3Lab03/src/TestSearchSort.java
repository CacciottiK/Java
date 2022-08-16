import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Assessment: lab03 
 * Duedate: Sept 25th 2021
 * Professor Name: James Mwangi
 * Student Name: Kyle Thomas    
 * Description: Program used to randomly generate several arrays to perform searches and sorting method tests.    
 * @see BinaryLinearSearch
 * @see TestSearchSort
 * @see SortingAlgorithms
 */

public class TestSearchSort {
/**
 * 
 */
	static int newstuff = BinaryLinearSearch.arrayB.length; // creates a temp variable which holds the length of the array we're copying
	static int[] bubbleArray = Arrays.copyOf(BinaryLinearSearch.arrayB, newstuff); // <-- This and next 4 are all perform the same. 
	static int[] insertArray = Arrays.copyOf(BinaryLinearSearch.arrayB, newstuff); // creates a clone of the array with randomized numbers
	static int[] selectArray = Arrays.copyOf(BinaryLinearSearch.arrayB, newstuff); // 5 clones with 5 different names
	static int[] mergeArray = Arrays.copyOf(BinaryLinearSearch.arrayB, newstuff);
	static int[] quickArray = Arrays.copyOf(BinaryLinearSearch.arrayB, newstuff);

	/**The sub menu which is shown when the user decides to select it from the main Menu.
	 * this menu decides which sorting method to use and tracks the time it takes to complete said sort.
	 * 
	 * @param input accepts the user input in order to select an option in the switch case
	 */
	public static void subMenu(Scanner input) {		

		boolean quit = false;

		while (!quit) {

			System.out.println("Select a sorting algorithm  to start the data array"); // output of main menu
			System.out.println();
			System.out.println("B. Bubble Sort");
			System.out.println("I. Insertion Sort");
			System.out.println("S. Selection Sort");
			System.out.println("M. Merge sort");
			System.out.println("Q. Quick Sort");
			System.out.println("R. Return to Main Menu"); // returns to the previous menu

			try {

				String option = input.nextLine(); // determines which case is run

				switch (option) {

				case "B":
				case "b":
					long startA = System.nanoTime(); // Time recording begins here
					long startB = System.currentTimeMillis(); // also records times
					printArray(bubbleArray);					
					bubbleSort(bubbleArray);					
					System.out.println("Bubble Sort: Simple sorting algorithm  - O(n2) Complexity   -  \n");
					printArray(bubbleArray);					
					long end1 = System.nanoTime(); // ends time recording to perform action
					long end2 = System.currentTimeMillis(); // also ends time
					System.out.println("Time taken in nano seconds: " + (end1 - startA)); // subtracts end time with start time to calculate total execution time
					System.out.println("Time taken in Milliseconds: " + (end2 - startB)); // same calculation but in milliseconds
					System.out.println("");
					break;

				case "I":
				case "i":
					long startC = System.nanoTime(); // Time recording begins here
					long startD = System.currentTimeMillis(); // also records times
					printArray(insertArray);					
					insertSort(insertArray);					
					System.out.println("Insertion Sort: Simple sorting algorithm  - O(n2) Complexity  - \n");
					printArray(insertArray);					
					long end3 = System.nanoTime(); //acts the same as the above nanotime
					long end4 = System.currentTimeMillis(); // //
					System.out.println("Time taken in nano seconds: " + (end3 - startC)); 
					System.out.println("Time taken in Milliseconds: " + (end4 - startD));
					System.out.println("");
					break;

				case "s":
				case "S":
					long startE = System.nanoTime(); // Time recording begins here
					long startF = System.currentTimeMillis(); // also records times
					printArray(selectArray);					
					selectSort(selectArray);
					System.out.println("Selection Sort: Simple sorting algorithm  - O(n2) Complexity  - \n");
					printArray(selectArray);					
					long end5 = System.nanoTime(); //acts the same as the above nanotime
					long end6 = System.currentTimeMillis(); // //
					System.out.println("Time taken in nano seconds: " + (end5 - startE)); 
					System.out.println("Time taken in Milliseconds: " + (end6 - startF));
					System.out.println("");
					break;

				case "m":
				case "M":
					long startH = System.nanoTime(); // Time recording begins here
					long startI = System.currentTimeMillis(); // also records times
					printArray(mergeArray);
					System.out.println("Merge Sort: Recursive Divide-And-Conquer - O(n log n) Complexity - \n");
					mergeSort(mergeArray);
					printArray(mergeArray);					
					long end7 = System.nanoTime(); //acts the same as the above nanotime
					long end8 = System.currentTimeMillis(); // //
					System.out.println("Time taken in nano seconds: " + (end7 - startH)); 
					System.out.println("Time taken in Milliseconds: " + (end8 - startI));
					System.out.println("");
					break;

				case "Q":
				case "q":
					long startJ = System.nanoTime(); // Time recording begins here
					long startK = System.currentTimeMillis(); // also records times
					printArray(quickArray);
					System.out.println("Quick Sort: Recursive Divide-And-Conquer - O(n log n) Complexity - \n");
					quickSort(quickArray, 0 , 999);
					printArray(quickArray);					
					long end9 = System.nanoTime(); //acts the same as the above nanotime
					long end10 = System.currentTimeMillis(); // 
					System.out.println("Time taken in nano seconds: " + (end9 - startJ)); 
					System.out.println("Time taken in Milliseconds: " + (end10 - startK));
					System.out.println("");
					break;
				case "r":
				case "R":
					System.out.println(" ------  Returning to Main Menu ------");
					System.out.println("");
					quit = true;
					break;

				default:
					System.err.println("Choose option B, I, S, M, Q or R to quit");
					System.out.println(); // if user fails to enter appropriate Letter, this is shown. Keeps up the
											// loop.

				}

			} catch (InputMismatchException IM) {
				input.nextLine();
				System.err.println("You must insert a number"); // prints out if a number is not placed into the
																// response
				System.out.println();
			}

		}

	}
/** A method to take the unsorted array and sort the values from lowest to highest.
 * in order to achieve this, some play with the variables is done.
 * a temporary variable is created and used to hold values to "switch" the positions of elements if the fit the required terms.
 * 
 * 
 * @param array the array which we are working with. In this Case, it's the bubbleArray
 */
	private static void bubbleSort(int[] array) {

		boolean swapDone = true;

		while (swapDone) { // keeps the loop going

			swapDone = false; // placed in order to escape from the while loop when the sort has been
								// completed
			// if it was already in order it knows it doesn't need to swap anything

			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					swapDone = true; // sets to true once again so the loop continues as "something swapped"
					int temp = array[i]; // a 3 way movement of values happens here
					array[i] = array[i + 1]; // in order to work correctly You need a third variable so a temp one is
												// used to shift element locations
					array[i + 1] = temp; // if no temp value, then generated elements would just be getting
											// deleted/overwritten

				}

			}

		}

	}
/** This Method sorts an array by constantly looking for the lowest element value out of the unsorted portion of the array.
 * What goes on is that the it finds the lowest value in the array, places it at the front which is now the current portion of the "sorted array"
 * Then goes on to look for the next smallest element and does the same thing. 
 * 
 * @param array the array which we are working with. In this Case, it's the selectArray
 */
	private static void selectSort(int[] array) {

		int arrL = array.length;

		for (int i = 0; i < arrL - 1; i++) {
			int min = i; // sets first element as the minimum
			for (int j = i + 1; j < arrL; j++) { 
				if (array[j] < array[min]) { //compares the first element to the next in line element
					min = j; // if it's smaller then it sets that number as the minimum
				}

			}
			int temp = array[min]; // swaps the positions of the found min and next to be looked at element in the array
			array[min] = array[i];
			array[i] = temp;

		}

	}
/**A method which essentially Sorts one number at a time and is quite inefficient when compared to some other methods to sort.
 * What it does, is take one element and compare it to the largest element in the sorted portion of the array. If smaller then it finds the correct portion
 * if larger, then it goes at the end of the sorted portion.
 * 
 * @param array the array which we are working with. In this Case, it's the insertArray
 */
	private static void insertSort(int[] array) {

		int arrL = array.length;

		for (int i = 1; i < arrL; i++) {
			int key = array[i]; // key is the element being moved/Looked to be placed.
			int currentHigh = i - 1; // is the current highest number in the sub-array/sorted array

			while (currentHigh >= 0 && array[currentHigh] > key) { // if the element being looked at is larger then the largest in the sorted portion of the array
				array[currentHigh + 1] = array[currentHigh];       // then it's placed the position of the current largest +1.
				currentHigh = currentHigh - 1; // sets position of the current highest element
			}
			array[currentHigh + 1] = key; // time to look at next element.
		}

	}
/** Is a recursive sorting algorithm. Starting with an unsorted array, it's divided into two. Left side and right side.
 * From there it's divided again and again until each element is on its own. After each element is on its own the elements form back together in the numerical order of the fragments
 * To which it basically "merges" with its self before the left and right side actually merge. 
 * 
 * @param array the array which we are working with. In this Case, it's the mergeArray
 */
	private static void mergeSort(int[] array) {

		int arrL = array.length;

		if (arrL < 2) { // you cannot split an array that has less than 2 values and arrays of just 1 length are "already sorted"			
			return;
		}

		int index = arrL / 2; // the middle of the array
		int[] leftSide = new int[index]; // first split of the array, holding the left half of the array
		int[] rightSide = new int[arrL - index]; // holds the right half of the array and accounts for uneven numbers

		for (int i = 0; i < index; i++) {
			leftSide[i] = array[i]; // Assigns the left side of array to be sorted to the temporary array holding the left side
		}

		for (int i = index; i < arrL; i++) { // Assigns the right side of array to be sorted to the temporary array holding the right side
			rightSide[i - index] = array[i]; 
		}

		mergeSort(leftSide); // keeps calling left/right side 
		mergeSort(rightSide); // eventually results in "sorted" arrays

		merge(array, leftSide, rightSide); // calls the method to sort the array

	}
/**the "merge" portion of the mergeSort method. Split up to keep the code clean.
 * This is where the values of the temporary arrays are assigned to the proper indexes of the array to be sorted.
 * 
 * @param array the array which we are working with. In this Case, it's the mergeArray
 * @param leftSide held/holds the left portion of the array
 * @param rightSide held/holds the right portion of the array
 */
	private static void merge(int[] array, int[] leftSide, int[] rightSide) {

		int leftSize = leftSide.length;
		int rightSize = rightSide.length;

		int i = 0; //iterators for each portion of the array i = left side
		int j = 0; // j = right side
		int k = 0; // k is for merge array

		while (i < leftSize && j < rightSize) { // compares the left and right side of the merged array fragments.
			if (leftSide[i] <= rightSide[j]) { // loops until we have no elements in left and or right arrays
				array[k] = leftSide[i]; // compares one array to another, if it is <= then it places into the proper array in order
				i++; // to look at next i element in array
			} else {
				array[k] = rightSide[j]; // j is actually smaller so j is added
				j++; // to look at next j element.
			}
			k++; // move to next step in main array
		}
		while (i < leftSize) { // this is here for clean up
			array[k] = leftSide[i]; //  adds in left over numbers that were left over
			i++; // if the left array had nothing left over then this whole method is skipped anyways.
			k++;
		}
		while (j < rightSize) {// also here for clean up
			array[k] = rightSide[j];  //  adds in left over numbers that were left over
			j++;
			k++;
		}

	}
/** A sorting algorithm which divides the array into sub arrays to speed up the process of sorting.
 * TO begin it selects a pivot point. Using this pivot point, it splits the array into two. One holding points larger than the pivot, the other less.
 * The left and right sides are also split using the same approach. Recursively applying this splitting technique. It continues until each element is alone
 * or better said, in it's own array. At this point the arrays are already sorted and just mashed into a single array.
 * 
 * 
 * @param array the array which we are working with. In this Case, it's the quickArray
 * @param start left most value in the array
 * @param end right most value in the array
 */
	private static void quickSort(int[] array, int start, int end) {
		
		if (start < end) { // start = low, end = high
			int index = partition(array, start, end);		 // elements smaller than pivot are on left, larger on right.
			
			quickSort(array, start, index-1); // right side - calls the method again and again
			quickSort(array,index+1,end); // left side
			
		}
		
		
	}
	/**this method is used to find the partition position each time its called
	 * 
	 * @param array the array which we are working with. In this Case, it's the quickArray
	 * @param start left most value in the array
	 * @param end right most value in the array
	 * @return index value + 1
	 */
	private static int partition(int[] array, int start, int end) {
		int pivot = array[end]; // chooses the right most element as the pivot
		int i = (start - 1); // 
		
		
		for (int j = start; j < end; j++) {// compares each element to the pivot
			if (array[j] <= pivot) { // swaps element if the element at j is smaller than the pivot
				i++;
				
				int temp = array[i]; // swaps the element at i with the element hanging out at j.
				array[i] = array[j];
				array[j] = temp;
			}
		}
		int temp = array[i + 1]; // swaps the pivot element with the greater value
		array[i + 1] = array[end];
		array[end] = temp;
		
		return i + 1; // returns the position where the partition was done
	}
	
	/**simply prints out the required array upon request
	 * 
	 * @param numbers holds/accepts any array
	 */

	private static void printArray(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println("");
		System.out.println("");
	}	

}
