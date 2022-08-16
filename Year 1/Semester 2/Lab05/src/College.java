import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Represents the College
 * 
 * @author Kyle Thomas
 * @version 2.1
 * @since 1.0
 * 
 * 
 */
public class College {

	private static Scanner input;
	String collegeName;
	// Student[] students;
	private ArrayList<Student> StudArray;

	/**
	 * Represents the College. This is where we choose it's name
	 * 
	 * @param numStudents The number of students attending the college
	 * @param students    A variable of students representing a student array
	 */
	College(String collegeName, int numStudents) {
		this.collegeName = collegeName;
		// students = new Student[numStudents];
		StudArray = new ArrayList<Student>(numStudents);
		// int numStudents - whatever is placed in that value will be the array size
		// we show this from Student[numStudents]. for the student array.

	}

	/**reads college name
	 * 
	 * @param collegeName Name of college
	 */
	public void printTitle() {

		System.out.println(collegeName + " - List of Students");
		System.out.println("************************************");
		System.out.println(
				"     Program|Student #|          Name|             Email|        Phone|  GPA|    Fees|  Credits|");
		// was once upon a time on a single line but the format assistant LOVES to place
		// this like this.
		// prints out the title

	}

	/**reads student details
	 * 
	 * @param input input
	 * @param typeOfStudent holds the value assigning the student
	 */
	public void readStudentDetails(Scanner input) {

		System.out.println("Enter Details of Student " + (StudArray.size() + 1));
		System.out.println("===========================");
		System.out.print("1 - Full time student\n2 - Part Time student\n");
		System.out.print("Enter student type: ");		
		int typeOfStudent = input.nextInt();
		// asks user for a number

		// after inserted number, chooses an action based on that number.

		if (typeOfStudent == 1) {

			Student newStudent = new FullTimeStudent();
			newStudent.readInfo(input);
			StudArray.add(newStudent);

		}

		if (typeOfStudent == 2) {

			Student newStudent = new PartTimeStudent();
			newStudent.readInfo(input);
			StudArray.add(newStudent);

		}

		else if (typeOfStudent != 1 || typeOfStudent != 2) {

			System.out.println("That's not a student type");

		}

	}

	/**
	 * Prints the Student Details
	 */
	public void printStudentDetails() {

		for (Student info : StudArray) {

			info.printInfo();
		}

	}
/**
 * Opens a specific file on the users computer. 
 */
	public static void openFile() {

		try {

			input = new Scanner(Paths.get("C:\\CST8116 Homework\\Eclipse Homework\\.metadata\\Lab05\\students.txt"));
		} catch (IOException ioe) {
			System.err.println("Something broke");
		}

	}

	/**reads the information stored on the file opened through openFile()
	 * using the read data, a FullTimeStudent or a PartTimeStudent will be made
	 * The type of student is determined by the f or p at the beginning of each line. 
	 */
	public void fileStudDeets() {

		try {

			while (input.hasNextLine()) {

				if (input.next().equals("f")) {
					// reading the file inputs/lines to create a fulltimestudent

					int studentNumber = input.nextInt();
					String firstName = input.next();
					String lastName = input.next();
					String emailId = input.next();
					long phoneNumber = input.nextLong();
					String programName = input.next();
					double gpa = input.nextDouble();
					double tuitionFees = input.nextDouble();

					Student newStudent = new FullTimeStudent(studentNumber, firstName, lastName, emailId, phoneNumber,
							programName, gpa, tuitionFees);
					StudArray.add(newStudent);

					

				}

				if (input.next().equals("p")) {
					//reading the file lines to create a parttimestudent

					int studentNumber = input.nextInt();
					String firstName = input.next();
					String lastName = input.next();
					String emailId = input.next();
					long phoneNumber = input.nextLong();
					String programName = input.next();
					double gpa = input.nextDouble();
					double courseTotal = input.nextDouble();
					double credits = input.nextDouble();

					Student newStudent = new PartTimeStudent(studentNumber, firstName, lastName, emailId, phoneNumber,
							programName, gpa, courseTotal, credits);
					StudArray.add(newStudent);

					

				}

			}

		} catch (Exception e) {
			
		}

	}
/**
 * closes the file input
 * could cause issues if a file is not properly closed
 */

	public static void closeFile() {

		input.close();
	}

}