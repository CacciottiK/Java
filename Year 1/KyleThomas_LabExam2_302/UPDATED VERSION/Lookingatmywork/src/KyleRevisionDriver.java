/* Assessment: LabExam01
 * Student Name: Kyle Thomas
 * Due Date: Feb 17th 2021 
 * Professor Name: David Haley
 * Description: Driver to print out information in the sandwiches class file
 */
public class KyleRevisionDriver {
	
	public static void main(String[] args) {
	
		KyleRevision Pastry1 = new KyleRevision();
			// this is my no argument constructor
	System.out.println("Testing No argument Contructor, Get, Set Methods:");
	System.out.println("Initial Object State");
	System.out.println("Bread Name:" + Pastry1.getBT());
	System.out.println("Filling: "+ Pastry1.getFill());
	System.out.println("Calories: " + Pastry1.getCal() + " \n");
	
	KyleRevision Pastry2 = new KyleRevision();
	// This Calls to my default Constructor
	
	Pastry1.setBT("Whole-Wheat");
	Pastry1.setFill("Tuna");
	Pastry1.setCal(250.50);
	int x = 5;
	
	System.out.println("Setting Bread name: Whole-Wheat, Filling: Tuna, Calories: 250.50");
	System.out.println("Bread Name: " +Pastry1.getBT());
	System.out.println("Filling: " +Pastry1.getFill());
	System.out.println("Calories: " +Pastry1.getCal() + " \n");
	System.out.println(x * 2);
	
	KyleRevision Pastry3 = new KyleRevision("Rye" , "Chicken" , 300.25);
	// This calls to my overloaded Constructor
	System.out.println("Testing Overloaded Contructor Bread name: Rye, Filling: Chicken, calories 300.25");
	System.out.println("Bread Name: " +Pastry3.getBT());
	System.out.println("Filling: " +Pastry3.getFill());
	System.out.println("Calories: "+ Pastry3.getCal() +" \n");
	
	System.out.println("Program by Kyle Thomas");
	
	
		}
}
