import java.io.IOException;
import java.lang.annotation.AnnotationTypeMismatchException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main Method of the program
 * 
 * @author Kyle Thomas
 * @author Thom1044 - 040733617
 * @version 2.1
 * @since 1.1
 * @see Person
 * @see Policies
 * @see Student
 * @see College
 * @see FullTimeStudent
 * @see PartTimeStudent
 */
public class CollegeSystemTest {
	/**
	 * Main Method which run the program
	 * 
	 * @param args .
	 * 
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Enter Name of College: ");
		String name = input.nextLine();

		System.out.println("Enter number of Students: ");

		int n = input.nextInt();

		College c1 = new College(name, n);

		while (true) {// infinite loop which prompts the user to make a decision.
			System.out.println("1. Read Student Info from Keyboard");
			System.out.println("2. Read Student Info from A Text File");
			System.out.println("3. Print Details of all Students");
			System.out.println("4. Exit");
			System.out.println("What would you like to do?: ");

			int thisLabIsAMess = input.nextInt();

			if (thisLabIsAMess == 1) {
				// makes a Student

				c1.readStudentDetails(input);

			} else if (thisLabIsAMess == 2) {

				College.openFile();
				if (input != null)
					c1.fileStudDeets();
				College.closeFile();

			} else if (thisLabIsAMess == 3) {
				// Displays all Students

				c1.printTitle();
				c1.printStudentDetails();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();

			} else if (thisLabIsAMess == 4) {
				// exits the program

				System.out.print(" Cya ");
				break;

			}

		}

	}

}
