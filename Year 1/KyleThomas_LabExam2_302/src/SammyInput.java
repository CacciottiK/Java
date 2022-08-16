/*Assessment: LAB exam 02
 * Student Name: KYLE THOMAS
 * Due Date: april 14th 2021
 * Professor Name: DAVID HAYLEY
 * Description:  Class that hold the users inputs
 */



import java.util.Scanner;

public class SammyInput {

	private static Scanner sammyscan = new Scanner(System.in);	
	
	public static double inputDouble() {
		double value = 0.0;
		while( ! sammyscan.hasNextDouble() ) {
			System.out.println("That's not a double");			
			sammyscan.nextLine(); // clean out bad data
		}
		value = sammyscan.nextDouble();
		sammyscan.nextLine(); // clean up the input stream
		return value;
	}
	
	public static String inputText() {
		return sammyscan.nextLine();
	}
	
	
	public static int inputInteger() {
		int result = 0;
		while( ! sammyscan.hasNextInt() ) { // verify if user input is an integer
			System.out.println("That's not an integer");			
			sammyscan.nextLine();
		}	
		result = sammyscan.nextInt();
		sammyscan.nextLine(); // clean up the input stream
		return result;
	}
	
}
