/* Assessment: Assignment 03
 * Student Name: Kyle Thomas
 * Due Date: March 28th 2021 
 * Professor Name: David Haley
 * Description: Program uses user inputs to measure whether the inputed cube is within tolerance of EPSILON (0.1)
 */
public class MetalCube {
	private double length; // centimeter
	private double width; // centimeter
	private double height; // centimeter
	
	// EPSILON is set at one-tenth of a centimeter, i.e. 
	// less-than-or-equal-to one millimeter.
	private static final double EPSILON = 0.1; 
	private static final double TOLERANCE = 10.0;
	public MetalCube() {
		this(10,10,10);
	}	
	
	public MetalCube(double length, double width, double height) {
		setLength(length);
		setWidth(width);
		setHeight(height);
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {		
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public boolean isWithinTolerance() {
		boolean resultboo;		
// boolean expression to calculate if cube entered is within tolerance
		resultboo = (Math.abs(length - TOLERANCE) <= EPSILON) && (Math.abs(width - TOLERANCE) <= EPSILON) && (Math.abs(height - TOLERANCE) <= EPSILON);

		return resultboo;
		
		// tolerance - length or length - tolerance generate the same issue but opposite
		// anything smaller than 0.1 automatically setting off the boolean as true.... ex. 9.89 - 10.0 = - 0.11 but applies true when it should be false. 
		
	}
	
}
