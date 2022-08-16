package Lab1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * CET - CS Academic Level 3 This class contains the dynamically allocated array
 * and it's processing Student Name: Student Number: Course: CST8130 - Data
 * Structures
 * 
 * @author Kyle Thomas
 * 
 */

public class Lab1 {

	/**
	 * method main
	 * @param args method main
	 */
	public static void main(String[] args) {

		/**
		 * Scanner
		 */
		Scanner input = new Scanner(System.in);
		/**
		 * controls loop
		 */
		boolean quit = false;
		Numbers a = new Numbers();

		while (!quit) {

			System.out.println("Select an option");
			System.out.println("1. Initialize Default Array");
			System.out.println("2. Specify Max size of the Array");
			System.out.println("3. Add Value to the Array");
			System.out.println("4. Display Array Values");
			System.out.println("5. Display Average of the values, Minimum Values, Maximum values");
			System.out.println("6. Exit Program");
			try {

				int option = input.nextInt();

				switch (option) {

				case 1:

					a = new Numbers();
					break;

				case 2:

					System.out.println("Enter an integer for array size");
					int size = input.nextInt();
					a = new Numbers(size);
					break;

				case 3:
					//a.valueCheck(input);
					a.addValue(input);
					break;
				case 4:
					a.toString();
					break;
				case 5:
					a.calcAverage();
					// a.minValue();
					// a.maxValue();
					break;
				case 6:
					quit = true;
					input.close();
					break;
					

				}
			} catch (InputMismatchException imp) {

				input.nextLine();
				System.out.println("You must insert a number");
				System.out.println();
			}

		}
		System.out.println("Cya");

	}
}
