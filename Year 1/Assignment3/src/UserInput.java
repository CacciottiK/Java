/* Assessment: Assignment 03
 * Student Name: Kyle Thomas
 * Due Date: March 28th 2021 
 * Professor Name: David Haley
 * Description: Program uses user inputs to measure whether the inputed cube is within tolerance of EPSILON (0.1)
 */
import java.util.Scanner;

public class UserInput {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public String inputText() {
		return scanner.nextLine();
	}
	
	public static double inputDouble() {
		double result = 0.0;
		while( ! scanner.hasNextDouble() ) { //verify if user input is a double
			System.out.println("Expects Double");
			System.out.println("Didn't enter a double, enter a double:");
			scanner.nextLine();
		}				
		result = scanner.nextDouble();
		scanner.nextLine(); // clean up the input stream
		return result;
		
	}
	
	public static int inputInteger() {
		int result = 0;
		while( ! scanner.hasNextInt() ) { // verify if user input is an integer
			System.out.println("Expects integer");
			System.out.println("Didn't enter a int, please enter one:");
			scanner.nextLine();
		}	
		result = scanner.nextInt();
		scanner.nextLine(); // clean up the input stream
		return result;
		
		
			}

}
