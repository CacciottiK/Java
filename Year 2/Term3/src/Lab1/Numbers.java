package Lab1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class contains the dynamically allocated array and it's processing
 * 
 * Student Name: Kyle Thomas	
 * Student Number: 040733617
 * Course: CST8130 - Data Structures CET-CS-Level 3
 * 
 * @author Kyle Thomas
 * 
 */

public class Numbers {
	/**
	 * Stores Float values.
	 */
	private Float[] numbers;

	/**
	 * Store the number of items currently in the array.
	 */	
	private int numItems = 5;
	
	/**
	 * Counter
	 */
	int i = 0;

	/**
	 * Default Constructor
	 */
	public Numbers() {
		// TODO Write code here to initialize a "default" array since this is the
		// default constructor

		numbers = new Float[numItems];
		// for (int i = 0; i < numbers.length; i++)
		// numbers[i] = (float) 0.0;

	}

	/**
	 * Constructor that initializes the numbers array.
	 * 
	 * @param size - Max size of the numbers array
	 */
	public Numbers(int size) {
		// Scanner input = new Scanner(System.in);
		// TODO Write code here to initialize the numbers array of max 'size'
		numbers = new Float[size];

	}
	
	/**
	 * A check for the Array. Determines if an extra element can be added to the array or not
	 * @return Boolean result
	 */
	
	public boolean valueCheck() {

		for (int i = 0; i < numbers.length; i++) {

			if (numbers[i] == null) {
				return false;// checks if array is full. If not, then it continues without issue.
			}

		}
		System.out.println("The Array is currently full");
		System.out.println();
		return true;

	}

	/**
	 * Adds a value in the array
	 * 
	 * @param keyboard - Scanner object to use for input
	 */
	public void addValue(Scanner keyboard) {
		// TODO Write code here to add the values in the array
		boolean error = true;

		if (!valueCheck()) {
			System.out.println("Enter A value to the array");
			while (error) {
				try {
					numbers[i] = keyboard.nextFloat();
					i++;
				} catch (InputMismatchException try2) {
					keyboard.nextLine();
					System.out.println("Next time, Enter a Float Value"); //if the input is not a number then this is thrown. 
					System.out.println("");
					// addValue(keyboard);
				}
				error = false;
			}

		}

	}

	/**
	 * Calculates the average of all the values in the numbers array.
	 * 
	 * @return float value that represents the average
	 */
	public float calcAverage() {
		// TODO Write code to return the average of the values in the array
		int isNotNull = 0;
		double sum = 0.0;

		if (numbers[0] != null) {

			for (int i = 0; i < numbers.length; i++) {

				if (numbers[i] != null) {
					sum += numbers[i];
					isNotNull++; // counter for the division. number of elements present
				}

			}
			double avg = sum / isNotNull;
			System.out.println("The Average is: " + avg);
			minValue();
			maxValue();

		} else if (numbers[0] == null) {
			System.out.println("Array is empty");
			System.out.println();
		}

		return (float) 0.0;

	}

	/**
	 * checks array for min
	 * @return minimum value inside of the array
	 */
	public float minValue() {

		float min = numbers[0];
		try {
			for (int i = 0; i < numbers.length; i++) {//checks for min. If no elements, the method returns to menu

				if (numbers[i] != null) {

					if (numbers[i] < min) {

						min = numbers[i];

					}
				} else if (numbers[i] == null) {

					break;
				}

			}

			System.out.println("The Minimum is: " + min);

		} catch (Exception except) {
			System.err.println("stuff1 happened");
		}

		return min;

	}

	/**
	 * checks array for max
	 * @return maximum value in the array
	 */
	public float maxValue() {

		float max = numbers[0];

		try {

			for (int i = 0; i < numbers.length; i++) { // checks for max. If no max, returns to menu

				if (numbers[i] != null) {

					if (numbers[i] > max) {

						max = numbers[i];

					}
				} else if (numbers[i] == null) {

					break;

				}

			}
			System.out.println("The Maximum is: " + max);
			System.out.println("");
		} catch (Exception except) {
			System.err.println("stuff happened");
		}

		return max;
	}
	
	/**
	 * prints out the array values
	 */

	@Override
	public String toString() {
		System.out.println("The Numbers Are:"); // prints array values
		for (int i = 0; i < numbers.length; i++)
			if (numbers[i] != null) {
				System.out.println(numbers[i]);
			}
		System.out.println("");

		return "";
	}

}