import java.util.Scanner;

/**
 * Represents a parttimestudent, which is a type of student
 * 
 * @author Kyle Thomas
 * @version 2.1
 * @since 1.0
 * 
 * 
 */
public class PartTimeStudent extends Student {
	/**
	 * @param courseTotal Displays the amount of courses the student is enrolled in
	 * @param credits     Displays the number of credits the student has
	 * 
	 */
	double courseTotal;
	double credits;
/**
 * empty constructor
 */
	PartTimeStudent() {

	}
/**constructor specifically for the data incoming through reading the file
 * 
 * @param studentNumber studentnumber of student
 * @param firstName firstname
 * @param lastName lastname
 * @param emailId email of student
 * @param phoneNumber phone number of student
 * @param programName course they are taking
 * @param gpa gpa of student
 * @param courseTotal how many courses are being taken
 * @param credits how well did they do
 */
	public PartTimeStudent(int studentNumber, String firstName, String lastName, String emailId, long phoneNumber,
			String programName, double gpa, double courseTotal, double credits) {

		// this.scrap = charAt;
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.programName = programName;
		this.gpa = gpa;
		this.courseTotal = courseTotal;
		this.credits = credits;

	}

	/**
	 * Reads the info specific to a part time student if this method as been
	 * selected
	 * 
	 * @param courseTotal Displays the amount of courses the student is enrolled in
	 * @param credits     Displays the number of credits the student has
	 * 
	 * 
	 */
	@Override
	public void readInfo(Scanner input) { // if a part time student is selected, then this method id called
		super.readInfo(input);
		System.out.println("Enter Total course fees: ");
		courseTotal = input.nextDouble();
		System.out.println("Enter Credit Hours: ");
		credits = input.nextDouble();

	}

	/**
	 * Prints the Info of a Part time Student
	 * 
	 */
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.printf("%8.1f| %8.1f|\n", courseTotal, credits);
		// hopefully prints out to the format we want

	}

}
