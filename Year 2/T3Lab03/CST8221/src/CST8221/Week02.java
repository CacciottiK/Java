package CST8221;

import javax.swing.JOptionPane;

import CST8221.week02.BordersDemoFX;
import CST8221.week02.JFXDemoW2;
import CST8221.week02.SwingDemoW2;
import CST8221.week02.SwingBordersDemo;

public class Week02 {

	// Error message
	String errorMessage = "";

	/**
	 * Week 02 Labs - Basic about Borders
	 * 
	 * @param lab
	 * @param usesJFX
	 * @param args
	 */
	public void invokeWeek02(int lab, boolean usesJFX, String[] args) {
		switch (lab) {
		case 1:
			example_w21();
			break;
		case 2:
			if (usesJFX)
				example_w22(args);
			else {
				errorMessage = "Unable to run JavaFX...";
				JOptionPane.showMessageDialog(null, errorMessage);
			}
			break;
		case 3:
			example_w23();
			break;
		case 4:
			if (usesJFX)
				example_w24(args);
			else {
				errorMessage = "Unable to run JavaFX...";
				JOptionPane.showMessageDialog(null, errorMessage);
			}
			break;
		default: // invalid lab
			errorMessage = "No valid Lab 2";
			JOptionPane.showMessageDialog(null, errorMessage);
		}
	}
	

	// WEEK 02 ...........................................................

	/**
	 * Method for week 2 - example 1 - Border
	 */
	public void example_w21() {
		SwingBordersDemo ExampleW21 = new SwingBordersDemo();
		ExampleW21.execute();
	}

	/**
	 * Method for week 2 - example 3 - Borders JFX
	 */
	public void example_w22(String[] args) {
		BordersDemoFX.execute(args);
	}

	/**
	 * Method for week 2 - example 3 - Hello Swing
	 */
	public void example_w23() {
		SwingDemoW2 d1 = new SwingDemoW2();
		d1.show();
	}
	
	/**
	 * Method for week 2 - example 4 - Hello JFX
	 */
	public void example_w24(String[] args) {
		JFXDemoW2 d2 = new JFXDemoW2();
		d2.execute(args);
	}

	
}
