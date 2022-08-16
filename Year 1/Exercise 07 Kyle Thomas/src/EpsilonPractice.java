/*Assessment: LabExercise07
 * Student Name: KYLE THOMAS
 * Due Date: MAR 26th 2021
 * Professor Name: DAVID HAYLEY
 * Description: A program made to test the difference absolute difference between two numbers
 */
public class EpsilonPractice {

	// ToDo: Created some code to print the difference between numbers that first
	// goes through a loop prompting the user to run
	// if the user wants out they can stop the test.
	public static void main(String[] args) {

		EpsilonTester epsilonTester = new EpsilonTester();
		final int CONTINUE_PROGRAM = 1; // use this for the loop
		int continueProgram = 0; // for user entry regarding continue program
		String report = ""; // used for outputs

		do {

			epsilonTester.interactWithUserForFieldValues();

			System.out.println();
			report = epsilonTester.compareWithEquality();
			System.out.println(report);

			System.out.println();
			report = epsilonTester.compareWithEpsilon();
			System.out.println(report);
			// The reporting of the epsilon tester created in the epsilonTester class
			System.out.println("Enter 1 to run a test:");
			System.out.println("Enter 0 to exit the program:");
			continueProgram = User.inputInteger();
			System.out.println("Program by Kyle Thomas");

			// Tells the user how to run the program, or exit the program.
		} while (continueProgram == CONTINUE_PROGRAM);

		System.out.println("Program has exited"); // after loop exits
	}

}
