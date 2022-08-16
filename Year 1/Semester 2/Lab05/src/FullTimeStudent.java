import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a fulltimestudent, which is a type of student
 * 
 * @author Kyle Thomas
 * @version 2.1
 * @since 1.0
 * 
 * 
 */
public class FullTimeStudent extends Student {

	/**
	 * @param tuitionFees Displays a number amount of money the student
	 *                    unfortunately has to pay once school is complete which is
	 *                    very well known to cause mental health issues.
	 */

	double tuitionFees;

	/**
	 * empty constructor
	 */
	public FullTimeStudent() {

	}

	/**constructor specifically for the data incoming through reading the file
	 * 
	 * @param studentNumber student number
	 * @param firstName name
	 * @param lastName last name
	 * @param emailId email of student
	 * @param phoneNumber phone number
	 * @param programName name of program 
	 * @param gpa gps of student
	 * @param tuitionFees how much money they are losing
	 */
	public FullTimeStudent(int studentNumber, String firstName, String lastName, String emailId, long phoneNumber,
			String programName, double gpa, double tuitionFees) {

		// this.scrap = charAt;
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.programName = programName;
		this.gpa = gpa;
		this.tuitionFees = tuitionFees;

	}

	/**
	 * Reads the info specific to a Full Time Student if this method has been
	 * selected
	 * 
	 */
	// @Override
	public void readInfo(Scanner input) { // if a Full time student is selected, this method is called.

		super.readInfo(input);
		System.out.println("Enter Tuition Fees: ");
		tuitionFees = input.nextDouble();

	}

	/**
	 * Prints the info specific to a full time student
	 */
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.printf(" %7.2f|         |\n", tuitionFees);
		// prints fees

	}

}
