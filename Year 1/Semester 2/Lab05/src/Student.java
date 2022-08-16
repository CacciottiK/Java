import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Represents the students as a whole
 * 
 * 
 * @author Kyle Thomas
 * @version 2.1
 * @since 1.0
 * 
 * 
 */
public class Student extends Person implements Policies {

	/**
	 * @param programName   The program of which the student is participating in
	 * @param studentNumber The students unique ID
	 * @param gpa           The Grade Point Average of the student
	 */

	private static Scanner input;
	int studentNumber;
	String programName;
	double gpa;
	

	/** A Constructor which accepts input values to build a student. */
	@Override
	public void readInfo(Scanner input) {

		System.out.println("Enter Program name: ");
		programName = input.next();
		System.out.println("Enter Student Number: ");
		studentNumber = input.nextInt();
		System.out.println("Enter First Name: ");
		firstName = input.next();
		System.out.println("Enter Last Name: ");
		lastName = input.next();
		System.out.println("Enter email ID: ");
		emailId = input.next();
		System.out.println("Enter Phone Number: ");
		phoneNumber = input.nextLong();
		// after the initial inputs to create the student
		// readMarks is placed after to initiate the acquisition of marks to calculate
		// the GPA
		readMarks(input);
		// input.close();

	}

	private void readMarks(Scanner input) {

		int courseNumber;
		System.out.println("Enter Number of Courses: ");
		courseNumber = input.nextInt();
		double[] markCount = new double[courseNumber];
		for (int i = 0; i < markCount.length; i++) {
			System.out.println("Enter Mark  " + (i + 1) + ":");
			markCount[i] = input.nextDouble();
			// stores the mark values into an array which is equal to the amount of
			// classes of which the student is participating in

		}

		calculateGPA(markCount); // calculates the gpa according to the mark count
		// input.close();

	}

	/**
	 * Prints the info stored inside of the variables which are unique to each
	 * student
	 */
	@Override
	public void printInfo() {

		System.out.printf("%12s|%9d|%14s|%18s|%13d|%5.2f|", programName, studentNumber, firstName + " " + lastName,
				emailId, phoneNumber, gpa);
		// formatting is a pain in the ass

	}

	/**
	 * Calculates the GPA of a student based on their course count and marks
	 * 
	 * @param deArray A Double array implemented from the policies interface. Length
	 *                is based on the mark count entered for a student
	 */
	// sum and average were producing errors if i @param them. So i'm assuming they
	// aren't supposed to be there
	// sum/average take the sum and averages of the marks entered per student.
	@Override
	public void calculateGPA(double[] deArray) {
		double average = 0;
		double sum = 0;
		for (int i = 0; i < deArray.length; i++) {
			// was fan having a 1 instead of a i here. took me a bit to see it.
			sum += deArray[i];
			average = sum / deArray.length;
		}

		gpa = ((average * Policies.maxGpa) / Policies.maxMarks);
		// calculates the GPA of a student

	}

}