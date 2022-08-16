import java.util.Scanner;

/**
 * Represents the College
 * 
 * @author Kyle Thomas
 * @version 1.1
 * @since 1.0
 * 
 * 
 */
public class College {
	
	

	String collegeName;
	Student[] students;

	/** Represents the College. This is where we choose it's name
	 * @param numStudents The number of students attending the college
	 * @param students A variable of students representing a student array
	 */
	College(String collegeName, int numStudents) {
		this.collegeName = collegeName;
		students = new Student[numStudents];
		// int numStudents - whatever is placed in that value will be the array size
		// we show this from Student[numStudents]. for the student array.

	}

	/**Prints out the College name followed by the layout template
	 * @param collegeName The name of the College
	 * 
	 */
	public void printTitle() {

		System.out.println(collegeName + " - List of Students");
		System.out.println("************************************");
		System.out.println(
				"     Program|Student #|          Name|             Email|        Phone|  GPA|    Fees|  Credits|");
		// was once upon a time on a single line but the format assistant LOVES to place this like this. 
		//prints out the title

	}

	/**Navigator method which directs the program based on user input 
	 * @param typeOfStudent Variable used to direct which method is executed
	 * 
	 */  
	public void readStudentDetails() {
		Scanner input = new Scanner(System.in);

		for (int i = 0; i < students.length; i++) {
			int typeOfStudent;
			System.out.println("Enter Details of Student " + (i + 1));
			System.out.println("===========================");
			System.out.print("1 - Full time student\n2 - Part Time student\n");
			System.out.print("Enter student type: ");
			typeOfStudent = input.nextInt();
			// asks user for a number
			
			//after inserted number, chooses an action based on that number.
			switch (typeOfStudent) {
			case 1:
				students[i] = new FullTimeStudent();
				students[i].readInfo();
				break;

			case 2:
				students[i] = new PartTimeStudent();
				students[i].readInfo();
				break;
			default:
				System.out.print("Wrong student type");
				i--;
				// DId play around with IF statements but it may have broke. Could have been due to the issue 
				// that i solved later on from a 1 instead of an i but i'm too lazy to switch it back and delete all the //
				

			}
			// input.close();
//
//			System.out.println("Enter details of student: " + (i + 1));
//			System.out.println("===============================");
//			System.out.println("1 - Fulltime Student \n2 - Parttime Student");
//			int typeOfStudent = input.nextInt();
//			if (typeOfStudent == 1) {
//				students[i] = new FullTimeStudent();
//				students[i].readInfo();
//			}
//
//			if (typeOfStudent == 2) {
//				students[i] = new PartTimeStudent();
//				students[i].readInfo();
//			}
//			if (typeOfStudent != 1 || typeOfStudent != 2) {
//				System.out.println("Incorrect Student option");
//				System.out.println();
//				i--;
//			}
		}

		// something in my For loop is breaking my program.
		// the i++ i had previously was making things funky
	}

	/**
	 * Prints the Student Details
	 */
	public void printStudentDetails() {

		for (Student info : students) {

			info.printInfo();
		}

	}

}
