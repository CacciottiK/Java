package CST8221;

import javax.swing.JOptionPane;

import CST8221.hybrid.Week03.BasePane;
import CST8221.hybrid.Week03.LayoutDemo;
import CST8221.hybrid.Week04.LayeredPaneDemo;
import CST8221.hybrid.Week04.TextAreaDemo;
import CST8221.hybrid.Week04.TextAreaDemoFX;
import CST8221.hybrid.Week04.TextFieldDemo;
import CST8221.hybrid.Week04.TextFieldDemoFX;
import CST8221.hybrid.week02.GlassPaneDemo;
import CST8221.hybrid.week02.JavaFXAppLifeCycle;
import CST8221.hybrid.week02.MultipleStages;
import CST8221.hybrid.week02.OpacityDemo;

public class Week00_Hybrid {

	// Error Message
	String errorMessage = "";
	
	/**
	 * Week 0 Labs - Hybrid activities
	 * 
	 * @param lab
	 * @param usesJFX
	 * @param args
	 */
	public void invokeHybrid(int lab, boolean usesJFX, String[] args) {
		switch (lab) {			

		// Week 2 Hybrid examples ................................................
		case 21:
			hybrid21();
			break;
		case 22:
			hybrid22();
			break;
		case 23:
			if (usesJFX)
				hybrid23(args);
			else {
				errorMessage = "Unable to run JavaFX...";
				JOptionPane.showMessageDialog(null, errorMessage);
			}
			break;
		case 24:
			if (usesJFX)
				hybrid24(args);
			else {
				errorMessage = "Unable to run JavaFX...";
				JOptionPane.showMessageDialog(null, errorMessage);
			}
			break;

			// Week 3 Hybrid examples ................................................
			case 31:
				hybrid31(); // Layout Test (Prof. Daniel)
				break;
			case 32:
				if (usesJFX)
					hybrid32(args); // Base Pane Test (Prof. Daniel)
				else {
					errorMessage = "Unable to run JavaFX...";
					JOptionPane.showMessageDialog(null, errorMessage);
				}
				break;

				// Week 4 Hybrid examples ................................................
				case 41:
					hybrid41(); // TextField
					break;
				case 42:
					hybrid42(); // TextArea
					break;
				case 43:
					if (usesJFX)
						hybrid43(args); // TextField
					else {
						errorMessage = "Unable to run JavaFX...";
						JOptionPane.showMessageDialog(null, errorMessage);
					}
					break;
				case 44:
					if (usesJFX)
						hybrid44(args); // TextArea
					break;
				case 45:
					hybrid45(); // Layers
					break;

		// Default ................................................
		default: // invalid lab
			errorMessage = "No valid Hybrid";
			JOptionPane.showMessageDialog(null, errorMessage);
		}

	}
	

	// HYBRID (WEEK 2) ..................................................

	/**
	 * Hybrid 1 - Week 2 - Code 1 - GlassPaneDemo
	 */
	public void hybrid21() {
		GlassPaneDemo Hybrid21 = new GlassPaneDemo();
		Hybrid21.execute();
	}

	/**
	 * Hybrid 1 - Week 2 - Code 2 - OpacityDemo
	 */
	public void hybrid22() {
		OpacityDemo Hybrid22 = new OpacityDemo();
		Hybrid22.execute();
	}

	/**
	 * Hybrid 1 - Week 2 - Code 3 - JavaFXAppLifeCycle
	 */
	public void hybrid23(String[] args) {
		JavaFXAppLifeCycle.execute(args);
	}

	/**
	 * Hybrid 1 - Week 2 - Code 4 - MultipleStages
	 */
	public void hybrid24(String[] args) {
		MultipleStages.execute(args);
	}


	// HYBRID (WEEK 3) ..................................................

	/**
	 * Method for week 3 - Hybrid for Layouts - Prof. Daniel
	 */
	public void hybrid31() {
		LayoutDemo.execute();
	}

	/**
	 * Method for week 3 - Base Pane (for test) - Prof. Daniel
	 */
	public void hybrid32(String[] args) {
		BasePane pane = new BasePane();
		pane.execute(args);
	}


	// HYBRID (WEEK 4) ..................................................

	/**
	 * Method for week 4 - Hybrid 1: TextField - Prof. Daniel
	 */
	public void hybrid41() {
		TextFieldDemo text = new TextFieldDemo();
		text.execute();
	}

	/**
	 * Method for week 4 - Hybrid 2: TextArea - Prof. Daniel
	 */
	public void hybrid42() {
		TextAreaDemo text = new TextAreaDemo();
		text.execute();
	}

	/**
	 * Method for week 4 - Hybrid 3: TextField - Prof. Daniel
	 */
	public void hybrid43(String[] args) {
		TextFieldDemoFX text = new TextFieldDemoFX();
		text.execute(args);
	}

	/**
	 * Method for week 4 - Hybrid 4: TextArea - Prof. Daniel
	 */
	public void hybrid44(String[] args) {
		TextAreaDemoFX text = new TextAreaDemoFX();
		text.execute(args);
	}

	/**
	 * Method for week 4 - Hybrid 5: Layers (Oracle)
	 */
	public void hybrid45() {
		LayeredPaneDemo layers = new LayeredPaneDemo();
		layers.execute();
	}

	// NEW WEEKS TO COME ...............................................
	
}
