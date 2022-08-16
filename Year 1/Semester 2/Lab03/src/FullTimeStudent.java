import java.util.Scanner;
/**Represents a fulltimestudent, which is a type of student
 * 
 * @author Kyle Thomas
 * @version 1.1
 * @since 1.0
 * 
 * 
 */
public class FullTimeStudent extends Student {
	
	/**
	 * @param tuitionFees Displays a number amount of money the student unfortunately has to pay once school is complete which is very well known to cause mental health issues. 
	 */
	
	
	double tuitionFees;
	
	/**Reads the info specific to a Full Time Student if this method has been selected
	 *  
	 */
	//@Override
	public void readInfo() { // if a Full time student is selected, this method is called. 
		Scanner input = new Scanner(System.in);
		//super.readInfo();
		System.out.println("Enter Tuition Fees: ");
		tuitionFees = input.nextDouble();
		//input.close();
		
						
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
