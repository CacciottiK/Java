/**Represents the policies of a students grades
 * 
 * @author Kyle Thomas
 * @version 2.1
 * @since 1.0
 * 
 * 
 */
public interface Policies {
	/**
	 * @param maxMarks Max marks possible for a student
	 * @param maxGpa Max GPA total for a student
	 * 	
	 */
	final double maxMarks = 100;
	final double maxGpa = 4.0;
	/**
	 * @param array a constructor that calls an array which contains some student GPA values. 
	 */
	void calculateGPA(double[] array);
	

}

