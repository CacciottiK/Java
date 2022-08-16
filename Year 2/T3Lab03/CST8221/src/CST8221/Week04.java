package CST8221;

import javax.swing.JOptionPane;

import CST8221.week04.ButtonDemo;
import CST8221.week04.ButtonFXDemo;
import CST8221.week04.CheckBoxDemo;
import CST8221.week04.CheckBoxDemoFX;
import CST8221.week04.RadioButtonDemo;
import CST8221.week04.RadioButtonDemoFX;
import CST8221.week04.SplashScreenDemo;
import CST8221.week04.SplashScreenDemoFX;

public class Week04 {

	// Error message
	String errorMessage = "";

	/**
	 * Week 04 Labs - Events examples
	 * 
	 * @param lab
	 * @param usesJFX
	 * @param args
	 */
	public void invokeWeek04(int lab, boolean usesJFX, String[] args) {
		switch (lab) {
		case 1:
			example_w41(); // Swing splash
			break;
		case 2:
			if (usesJFX)
				example_w42(args); // JavaFX splash
			else {
				errorMessage = "Unable to run JavaFX...";
				JOptionPane.showMessageDialog(null, errorMessage);
			}
			break;
		case 3:
			example_w43(); // Swing Checkbox events
			break;
		case 4:
			if (usesJFX)
				example_w44(args); // JavaFX Checkbox events
			else {
				errorMessage = "Unable to run JavaFX...";
				JOptionPane.showMessageDialog(null, errorMessage);
			}
			break;
		case 5:
			example_w45(); // Swing Radiobutton events
			break;
		case 6:
			if (usesJFX)
				example_w46(args); // JavaFX Radio Button events
			else {
				errorMessage = "Unable to run JavaFX...";
				JOptionPane.showMessageDialog(null, errorMessage);
			}
			break;
		case 7:
			example_w47(args); // Swing splash
			break;
		case 8:
			if (usesJFX)
				example_w48(args); // JavaFX splash
			else {
				errorMessage = "Unable to run JavaFX...";
				JOptionPane.showMessageDialog(null, errorMessage);
			}
			break;
		default: // invalid lab
			errorMessage = "No valid Lab 4";
			JOptionPane.showMessageDialog(null, errorMessage);
		}
	}

	// WEEK 04 ..........................................

	/**
	 * Method for week 4 - example 1 - Button Events
	 */
	public void example_w41() {
		ButtonDemo.execute();
	}

	/**
	 * Method for week 4 - example 2 - Splash FX
	 */
	public void example_w42(String[] args) {
		ButtonFXDemo eventDemo = new ButtonFXDemo();
		eventDemo.execute(args);
	}

	/**
	 * Method for week 4 - example 3 - Swing CheckBox Events
	 */
	public void example_w43() {
		CheckBoxDemo eventDemo = new CheckBoxDemo();
		eventDemo.execute();
	}

	/**
	 * Method for week 4 - example 4 - JavaFX CheckBox Events
	 */
	public void example_w44(String[] args) {
		CheckBoxDemoFX eventDemo = new CheckBoxDemoFX();
		eventDemo.execute(args);
	}

	/**
	 * Method for week 4 - example 5 - RadioButton Events
	 */
	public void example_w45() {
		RadioButtonDemo eventDemo = new RadioButtonDemo();
		eventDemo.execute();
	}

	/**
	 * Method for week 4 - example 5 - RadioButton Events
	 */
	public void example_w46(String[] args) {
		RadioButtonDemoFX eventDemo = new RadioButtonDemoFX();
		eventDemo.execute(args);
	}

	/**
	 * Method for week 4 - example 7 - Swing Splash
	 */
	public void example_w47(String[] args) {
		SplashScreenDemo.execute(args);
	}

	/**
	 * Method for week 4 - example 8 - Splash FX
	 */
	public void example_w48(String[] args) {
		SplashScreenDemoFX.execute(args);
	}

}
