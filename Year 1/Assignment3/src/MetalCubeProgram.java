/* Assessment: Assignment 03
 * Student Name: Kyle Thomas
 * Due Date: March 28th 2021 
 * Professor Name: David Haley
 * Description: Program uses user inputs to measure whether the inputed cube is within tolerance of EPSILON (0.1)
 */
public class MetalCubeProgram {

	public static void main(String[] args) {
		final int ENTER_DATA = 1;
		final int REPORT = 2;
		final int EXIT = 0;
		int proceedProgram = 0;
		MetalCubeAnalyzer analyzer = new MetalCubeAnalyzer();
				
		
		do {
			
			// asks user for inputs				
	    System.out.println("Enter 1 for Cube entry:");
	    System.out.println("Enter 2 to Show report:");
        System.out.println("Enter 0 to Exit Program:");
		
        proceedProgram = UserInput.inputInteger();
        System.out.println();
			
       
        
	    if (proceedProgram == ENTER_DATA) {	// is user input is 1 then enterCube() method begins.
			analyzer.enterCube();	
			System.out.println();
		}
		
		if (proceedProgram == REPORT) { // if user input is REPORT (2) then print report
			System.out.println();
			analyzer.printReport();
			System.out.println();
		}
        if (proceedProgram > REPORT) {// if user input is greater than valid options it resets.
			
			System.out.println("Invalid menu option.");
			System.out.println();
			
		}              
		
		
		
		}
		while (proceedProgram != EXIT);
		
		System.out.println("Thanks for using the program");
		System.out.println("Program by Kyle Thomas");
		
		
			
		
	}

}
