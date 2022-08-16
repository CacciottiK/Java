/*Assessment: LAB exam 02
 * Student Name: KYLE THOMAS
 * Due Date: april 14th 2021
 * Professor Name: DAVID HAYLEY
 * Description:  Main method asking the user for an inputted sandwich 
 */
public class SammyProgram {
	
	
	public static void main(String[] args) {
		
			
		final int UPDATE_SANDWICH = 203;
		final int REPORT_SANDWICH = 204;
		final int QUIT_SANDWICH = 205;
		int sammyContinue = 0;		
		Sandwich sammysam = new Sandwich();
			
		
		do { 
			
			System.out.println("Enter Option");
		    System.out.println("Enter 203 to update sandwich");
	        System.out.println("Enter 204 to view sandwich report::");
	        System.out.println("Enter 205 to quit program:");
			
			sammyContinue = SammyInput.inputInteger();
			System.out.println();
			
			
			
			if (sammyContinue == UPDATE_SANDWICH) {
				sammysam.enterASandwich();				
			}
			
			if (sammyContinue == REPORT_SANDWICH) {
				System.out.println();
				sammysam.createReport();				
			}
			if ((sammyContinue > 205) || (sammyContinue < 203) ) {
				
				System.out.println("Invalid menu option, please try again");
				
			}		
			
			System.out.println("Program by Kyle Thomas");
			
		}
		while (sammyContinue != QUIT_SANDWICH);
		
		System.out.println("Program Quits");
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
