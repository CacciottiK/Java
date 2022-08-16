import java.util.Scanner;
/**Represents a parttimestudent, which is a type of student
 * 
 * @author Kyle Thomas
 * @version 1.1
 * @since 1.0
 * 
 * 
 */
public class PartTimeStudent extends Student {
	/**
	 * @param courseTotal Displays the amount of courses the student is enrolled in
	 * @param credits Displays the number of credits the student has
	 * 
	 */
	double courseTotal;
	double credits;
	
	/**
	 * Reads the info specific to a part time student if this method as been selected
	 * @param courseTotal Displays the amount of courses the student is enrolled in
	 * @param credits Displays the number of credits the student has
	 *  
	 * 
	 */
	@Override
	public void readInfo() { // if a part time student is selected, then this method id called
		Scanner input = new Scanner(System.in);
		super.readInfo();
		System.out.println("Enter Total course fees: ");
		courseTotal = input.nextDouble();
		System.out.println("Enter Credit Hours: ");
		credits = input.nextDouble();
		//input.close();
	}
	/**
	 * Prints the Info of a Part time Student
	 * 	 
	 */
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.printf("%8.1f| %8.1f|\n",courseTotal,credits);
		//hopefully prints out to the format we want
		
	}

}
