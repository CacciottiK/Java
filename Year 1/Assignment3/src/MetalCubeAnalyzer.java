/* Assessment: Assignment 03
 * Student Name: Kyle Thomas
 * Due Date: March 28th 2021 
 * Professor Name: David Haley
 * Description: Program uses user inputs to measure whether the inputed cube is within tolerance of EPSILON (0.1)
 */
public class MetalCubeAnalyzer {
	private int countGoodCubes = 0;
	private int countBadCubes = 0;		
	double value = 0.0;
	MetalCube cube = new MetalCube(value, value, value);	
	
	public void enterCube() {
					// accepts and sets user data into a cube							
		System.out.println("Please enter cube Length(cm): ");
		value = UserInput.inputDouble();		
		cube.setLength(value);
		System.out.println("Please enter cube Width(cm): ");
		value = UserInput.inputDouble();
		cube.setWidth(value);
		System.out.println("Please enter cube Height(cm): ");
		value = UserInput.inputDouble();
		cube.setHeight(value);
		
				// counts good and bad cubes
		if (cube.isWithinTolerance()) {
			countGoodCubes++;
		}
		else countBadCubes++;
			
	}				
	
	
		
	public void printReport() {				// A method which prints the total counts of good and bad cubes.
		double totalCubes = (countBadCubes + countGoodCubes);	  		
        if (totalCubes == 0) {
			// if no cubes have been entered before printing, a line stating no cubes have been entered prints
			System.out.println("You have not entered any cubes");
			System.out.println("Nothing to report");
        }	
		
        if (totalCubes != 0) {
         
		System.out.println("Good Cubes: " + Math.abs(countGoodCubes));
		System.out.println("Bad Cubes: " + Math.abs(countBadCubes));
		System.out.println("Total Cubes: " + Math.abs(countGoodCubes + countBadCubes));	
		System.out.println("Percent Good Cubes: " + Math.abs(countGoodCubes * 100 / totalCubes));
		System.out.println("Percent Bad Cubes: " + Math.abs(countBadCubes * 100 / totalCubes));
		
		// to format the % to two decimal places i have to %.2f 
		// currently not limiting the sig figs so 33% ends up as 33.333333333333%
        }
            
        
        
        
        
        
        
		
	}	
	


	
}