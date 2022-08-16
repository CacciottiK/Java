import java.util.Scanner;
/**Main Method of the program
 * 
 * @author Kyle Thomas
 * @author Thom1044 - 040733617
 * @version 1.1
 * @since 1.0
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
	 * @param args .
	 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Name of College: ");
		String name = input.nextLine();
		
		System.out.println("Enter number of Students: ");
		int n = input.nextInt();
		College c1 = new College(name, n);
		
		c1.readStudentDetails();
		c1.printTitle();
		c1.printStudentDetails();
		input.close();
						
		
	}

}
