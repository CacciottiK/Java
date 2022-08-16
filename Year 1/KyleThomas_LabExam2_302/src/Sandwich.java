/* 
 * CST8116 Lab Exam 2 (21W) Starter Code
 * (c) 2021 Algonquin College All Rights Reserved
 */

/* Class Sandwich, represents a sandwich */
public class Sandwich {
	private String name; // bread name
	private String filling; // ham, beef, etc
	private double calories;

	/*
	 * Sets name and filling to empty strings, calories to 0.0
	 */
	public Sandwich() {
		this("", "", 0.0);
	}

	/* Overloaded constructor */
	public Sandwich(String name, String filling, double calories) {
		setName(name);
		setFilling(filling);
		setCalories(calories);
	}

	/* accessor for name */
	public String getName() {
		return name;
	}

	/* mutator for name */
	public void setName(String name) {
		this.name = name;
	}

	/* accessor for filling */
	public String getFilling() {
		return filling;
	}

	/* mutator for filling */
	public void setFilling(String filling) {
		this.filling = filling;
	}

	/* accessor for calories */
	public double getCalories() {
		return calories;
	}

	/* mutator for calories */
	public void setCalories(double calories) {
		this.calories = calories;
	}

	/* creates a report with class name and field details */
	public String createReport() {		
		System.out.printf("Sandwich: " +getName());
		System.out.printf("Filling: " +getFilling());
		System.out.println("calories: " +getCalories());
		
		String format = "Sandwich: name %s, filling %s, calories %.2f";
		return String.format(format, getName(), getFilling(), getCalories());

	}

	public void enterASandwich() {

		double input = 0.0;
		String info = "";

		System.out.println("Enter Sandwich Name: ");
		info = SammyInput.inputText();
		setName(info);
		System.out.println("Enter sandwich filling: ");
		info = SammyInput.inputText();
		setFilling(info);
		System.out.println("Enter sandwich calories: ");
		input = SammyInput.inputDouble();
		setCalories(input);

	}

}
