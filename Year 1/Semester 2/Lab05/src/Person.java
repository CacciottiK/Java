import java.util.Scanner;

/**Represents a person
 * 
 * @author Kyle Thomas
 * @version 2.1
 * @since 1.0
 * 
 * 
 */
public abstract class Person {
	
	/**	 
	 * @param firstName The first name of the student
	 * @param lastName The last name of the student
	 * @param emailId The email of which the student desires to be contacted on
	 * @param phoneNumber The phone number of the student
	 * 
	 */
	
	protected String firstName;
	protected String lastName;
	protected String emailId;
	protected long phoneNumber;
	/**Reads readInfo from the desired object that was called
	 * 
	 */
	abstract void readInfo(Scanner input); 
	/**Prints printInfo of the desired object when called
	 *
	 */	
	abstract void printInfo();	
	

}
