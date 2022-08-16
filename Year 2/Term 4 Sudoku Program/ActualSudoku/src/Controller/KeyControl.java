package Controller;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import Model.SudGrid;
import Model.SudokuDriver;

/**
 * @author Kyle Thomas The Key controller Class, this class holds the code which
 *         triggers when a keyboard character is entered
 */

public class KeyControl implements KeyListener {

	public KeyControl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

		// int dim = SudokuDriver.Current_Dimension;
		JTextField textEnteredInBox = (JTextField) e.getSource(); // Gets the value out of the textfield
		textEnteredInBox.setText(textEnteredInBox.getText().toUpperCase()); // converts the uppercase variety :)
		String src = textEnteredInBox.getText(); // converts the JTExtfield to a string

		// Determines the dimension of the board and applies the sudocu character rules
		// should the entered value not meet the requirements
		if (SudokuDriver.Current_Dimension == 4) {
			if (!src.equals("1") && !src.equals("2") && !src.equals("3") && !src.equals("4")) {
				textEnteredInBox.setText("");
			}
		} else if (SudokuDriver.Current_Dimension == 9) {
			if (!src.equals("1") && !src.equals("2") && !src.equals("3") && !src.equals("4") && !src.equals("5")
					&& !src.equals("6") && !src.equals("7") && !src.equals("8") && !src.equals("9")) {
				// 9 inner if
				textEnteredInBox.setText("");
			}
		} else if (SudokuDriver.Current_Dimension == 16) {
			if (!src.equals("1") && !src.equals("2") && !src.equals("3") && !src.equals("4") && !src.equals("5")
					&& !src.equals("6") && !src.equals("7") && !src.equals("8") && !src.equals("9") && !src.equals("a")
					&& !src.equals("b") && !src.equals("c") && !src.equals("d") && !src.equals("e") && !src.equals("f")
					&& !src.equals("g") && !src.equals("A") && !src.equals("B") && !src.equals("C") && !src.equals("D")
					&& !src.equals("E") && !src.equals("F") && !src.equals("G")) {
				// 16 inner if
				textEnteredInBox.setText("");
			}

		} else {
			System.out.println("Something is wrong if you see this");
		}
		// Checks the value entered
		for (int i = 0; i < SudGrid.sudGrid.length; i++) { // i = x or row
			for (int j = 0; j < SudGrid.sudGrid.length; j++) { // j = y or col
				if (SudGrid.sudGrid[i][j].equals(textEnteredInBox)) { // needed as it prevents checking everything every
																		// time...
					// essentially finds the value entered.
					if (SudGrid.sudokuRuleCheck(i, src, j) == false) { // checks the entered value into the sudoku
																		// ruleset and returns false if the value
																		// already exists in the row/col/box
						SudGrid.sudGrid[i][j].setForeground(Color.red);
					} else {
						SudGrid.sudGrid[i][j].setForeground(Color.magenta); // notifies user that the value entered is a
																			// viable placement
					}
				}

			}
		}
		
		//Checks for a game win 
	//	System.out.println("outputtest");
		SudGrid.checkGameWin();

	}

}
