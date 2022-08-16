package Model;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

import Controller.KeyControl;

import java.util.Random;
/**
 * 
 * @author Kyle Thomas
 *Class to manipulate the grid/game
 */
public class SudGrid extends JPanel {

	/**
	 * Serial id
	 */
	private static final long serialVersionUID = 1L;
/**
 * sudoku grid array
 */
	public static JTextField[][] sudGrid;
	
	/**
	 * copy of sudoku array to compare progres of puzzle
	 */
	public static JTextField[][] sudGridCopy;

	private JPanel gridPanel = new JPanel();

	/**
	 *default construct 
	 */
	public SudGrid() {

	}
	
	
/**constructs the grid to the required parameters and then adds it to the appropriate panel
 * 
 * @param currentsize dimension of the grid. Determines size of game board
 */
	public SudGrid(int currentsize) {

		int gridSize = currentsize;
		int x, y, dimControl;

		// initializing arrays
		sudGrid = new JTextField[gridSize][gridSize];
		sudGridCopy = new JTextField[gridSize][gridSize];

		
		//important to calculate when to highlight boxes
		if (currentsize == 16) {
			dimControl = 4;
		} else if (currentsize == 9) {
			dimControl = 3;
		} else {
			dimControl = 2;
		}
		
		//applies grid layout
		gridPanel.setLayout(new GridLayout(gridSize, gridSize));
		Dimension notSudokuForAnts = new Dimension(50, 50);
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				sudGrid[i][j] = new JTextField();
				sudGridCopy[i][j] = new JTextField();
				sudGrid[i][j].setFont(new Font("ARIAL", Font.BOLD, 28));
				sudGrid[i][j].setForeground(Color.BLACK);
				sudGrid[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				sudGrid[i][j].addKeyListener(new KeyControl());
				sudGrid[i][j].setPreferredSize(notSudokuForAnts); //something i'll need to fix here later. Moveing to another class
				//made my grid go super tiny and not have a constant size.
				gridPanel.add(sudGrid[i][j]);
			}
		}

		//Colors the grids
		for (x = 0; x < gridSize; x++) {
			for (y = 0; y < gridSize; y++) {

				if ((x / dimControl + y / dimControl) % 2 == 0) {

					sudGrid[x][y].setBackground(Color.YELLOW);

				}

			}

		}
		SudokuDriver.Current_Dimension = currentsize;
		// ColorGrid(sudGrid);
		fillGrid(currentsize, 1); // calls the grid filling method with a default difficulty of 1 (easy)

		// while (a == 0) {
		// if (checkIfValid(sudGrid) == true) {
		// System.out.println("THIS BOARD IS SOLVEABLE");
		// a++;
		// }
		// fillGrid(currentsize, 1);
		// System.out.println("THIS BOARD IS UNSOLVEABLE");

		// }

		this.add(gridPanel);
	}
	/**Fills the grid with the appropriate amount of values and then removes a set amount of values depending on the difficulty level.
	 * 
	 * @param currentDimension dimension of the grid. Determines size of game board
	 * @param diff difficulty of the puzzle
	 */

	public static void fillGrid(int currentDimension, int diff) {

		String usedPresetGrid = null;
		int randomX, randomY, difficultyModifier = 0, dimensionModifier = 0, count = 0;

		for (int i = 0; i < SudokuDriver.Current_Dimension; i++) {
			for (int j = 0; j < SudokuDriver.Current_Dimension; j++) {

				if (currentDimension == 16) {
					usedPresetGrid = PresetGrids.largeGrid1[i][j];
				} else if (currentDimension == 9) {
					usedPresetGrid = PresetGrids.mediumGrid1[i][j];
				} else if (currentDimension == 4) {
					usedPresetGrid = PresetGrids.smallGrid1[i][j];
				} else {
					System.out.println("If you see this, you have an issue P1 of fillgrid");
				}
				//Sets the main arrray and the copy to the value(s) of the preset grid in the presetgrids class
				// the goal is to have it randomize between several preset grids to further "randomize" but it's tiring to type out those grids let me tell ya
				sudGrid[i][j].setText(usedPresetGrid);
				sudGrid[i][j].setEditable(false);
				sudGridCopy[i][j].setText(usedPresetGrid);
			}

		}
		
		//random
		Random randomValue = new Random();

		
		//manipulating the amount of values removed from puzzle to simulate difficulty
		if (currentDimension == 16) {
			dimensionModifier = 130;
		} else if (currentDimension == 9) {
			dimensionModifier = 40;
		} else if (currentDimension == 4) {
			dimensionModifier = 4;
		} else {
			System.out.println("If you see this, you have an issue p2 of fill grid");
		}
		if (diff == 1) { // easy
			difficultyModifier = 0;
		} else if (diff == 2) { // medium
			if (currentDimension == 9) {
				difficultyModifier = 10;
			} else if (currentDimension == 16) {
				difficultyModifier = 30;
			} else {
				difficultyModifier = 2;
			}
		} else if (diff == 3) { // hard
			if (currentDimension == 9) {
				difficultyModifier = 20;
			} else if (currentDimension == 16) {
				difficultyModifier = 40;
			} else {
				difficultyModifier = 4;
			}
		} else {
			System.out.println("If you see this, you have an issue p2 of fill grid");
		}
		
		// removing values

		while (count < difficultyModifier + dimensionModifier) {
			randomX = randomValue.nextInt(currentDimension);
			randomY = randomValue.nextInt(currentDimension);
			if (sudGrid[randomX][randomY].getText().equals("")) {
				count--;//ensures the proper amount of values are removed
			}
			sudGrid[randomX][randomY].setText("");
			sudGrid[randomX][randomY].setEditable(true);
			count++;

		}

	}
	/**Former method scrapped for now, the goal was to generate random boards on my own without a preset but the algorithm didn't create solvable boards. leaving in for possible rework
	 * 
	 * @param currentDimension dimension of the grid. Determines size of game board
	 * @param diff Difficulty
	 */

	public static void ffillGrid(int currentDimension, int diff) {

		String viableChars = null, stringConvert;
		char chosenChar;
		int difficultyModifier, dimensionModifier = 0, randomX, randomY, randomChar, count = 0;

		if (currentDimension == 16) {
			viableChars = "123456789ABCDEFG";
			dimensionModifier = 200;
		} else if (currentDimension == 9) {
			viableChars = "123456789";
			dimensionModifier = 50;
		} else if (currentDimension == 4) {
			viableChars = "1234";
			count = 80;
		} else {
			System.out.println("If you see this, you have an issue");
		}

		if (diff == 3) {
			difficultyModifier = -25;
		} else if (diff == 2) {
			difficultyModifier = -15;
		} else {
			difficultyModifier = 0;
		}

		Random randomValue = new Random();

		while (count < 100 + difficultyModifier + dimensionModifier) {
			randomX = randomValue.nextInt(currentDimension);
			randomY = randomValue.nextInt(currentDimension);
			randomChar = randomValue.nextInt(currentDimension);
			chosenChar = viableChars.charAt(randomChar);
			stringConvert = String.valueOf(chosenChar);
			if (SudGrid.sudokuRuleCheck(randomX, stringConvert, randomY) == true) {
				sudGrid[randomX][randomY].setText(String.valueOf(chosenChar));
				// sudGridCopy[randomX][randomY].setText(String.valueOf(chosenChar));
				sudGrid[randomX][randomY].setFont(new Font("Arial Black", Font.BOLD, 28));
				sudGrid[randomX][randomY].setEditable(false);
			} else {
				sudGrid[randomX][randomY].setText("");
				sudGrid[randomX][randomY].setEditable(true);
			}
			count++;
		}

		// for (int i = 0; i < currentDimension; i++)
		// for (int j = 0; j < currentDimension; j++) {
		// randomX = randomValue.nextInt(currentDimension);
		// randomY = randomValue.nextInt(currentDimension);
		// randomChar = randomValue.nextInt(currentDimension);
		// chosenChar = viableChars.charAt(randomChar);
		// stringConvert = String.valueOf(chosenChar);
		// if (SudGrid.sudokuRuleCheck(randomX, stringConvert, randomY) == true) {
		// sudGrid[randomX][randomY].setText(String.valueOf(chosenChar));
		// sudGrid[randomX][randomY].setFont(new Font("Arial Black", Font.BOLD, 28));
		// sudGrid[randomX][randomY].setEditable(false);
		// }
		// else {
		// sudGrid[randomX][randomY].setText("");
		// sudGrid[randomX][randomY].setEditable(true);
		// }

		// }

	}
	/**Another scrapped method, was going to be used to confirm if values entered were valid.
	 * 
	 * @param board the working board passed into method
	 * @return true or false
	 */

	public static boolean checkIfValid(JTextField[][] board) {

		String viableChars = null, stringConvert = null;
		char chosenChar;

		if (SudokuDriver.Current_Dimension == 16) {
			viableChars = "123456789ABCDEFG";
		} else if (SudokuDriver.Current_Dimension == 9) {
			viableChars = "123456789";
		} else if (SudokuDriver.Current_Dimension == 4) {
			viableChars = "1234";
		} else {
			System.out.println("If you see this, you have an issue");
		}

		for (int i = 0; i < sudGrid.length; i++) {
			for (int j = 0; j < sudGrid.length; j++) {
				if (board[i][j].getText().equals("")) {
					for (int k = 1; k < sudGrid.length; k++) {
						chosenChar = viableChars.charAt(k);
						stringConvert = String.valueOf(chosenChar);
						if (SudGrid.sudokuRuleCheck(i, stringConvert, j)) {
							board[i][j].setText(stringConvert);
							if (checkIfValid(board)) {
								System.out.println(stringConvert);
								return true;
							} else {
								System.out.println(sudGrid.length);
								board[i][j].setText(stringConvert);
								// board[i][j].setEditable(true);
							}
						}
					}
					return false;
				}
			}
		}
		return true;

	}
	
	/**
	 * Clears the grid and allows all fields to be edited
	 */
	public static void clearGrid() {
		int x, y;
		for (x = 0; x < SudokuDriver.Current_Dimension; x++) {
			for (y = 0; y < SudokuDriver.Current_Dimension; y++) {
				sudGrid[x][y].setEditable(true);
				sudGrid[x][y].setText("");
			}
		}

	}
	/**checks if value is in row
	 * 
	 * @param row row value of input
	 * @param input string value entered(being checked)
	 * @param col column value of input
	 * @return true if value exists in row
	 */
	public static boolean rowCheck(int row, String input, int col) {
		for (int i = 0; i < sudGrid.length; i++) {
			System.out.println("in row");
			if (i != col) { //skips the coordinate where the value is entered. It was flagging this as existing constantly if this was not here
				if (sudGrid[row][i].getText().equals(input)) {
					System.out.println("EQUALS ROW");
					return true;
				}
			}
		}
		return false;
	}
	
	/**checks in value is in column
	 * 
	 * @param row row value of input
	 * @param input string value entered(being checked)
	 * @param col column value of input
	 * @return true if value exists in col
	 */

	public static boolean columnCheck(int row, String input, int col) {
		for (int i = 0; i < sudGrid.length; i++) {
			System.out.println("in col");
			if (i != row) {  //skips the coordinate where the value is entered. It was flagging this as existing constantly if this was not here
				if (sudGrid[i][col].getText().equals(input)) {
					System.out.println("EQUALS COL");

					return true;
				}
			}
		}
		return false;
	}
	/**checks if value is in box
	 * 
	 * @param row row value of input
	 * @param input string value entered(being checked)
	 * @param col column value of input
	 * @return true if value exists in box
	 */
	public static boolean boxCheck(int row, String input, int col) {
		int bounds = 0;

		if (SudokuDriver.Current_Dimension == 16) {
			bounds = (int) Math.sqrt(SudokuDriver.Current_Dimension);
		} else if (SudokuDriver.Current_Dimension == 9) {
			bounds = (int) Math.sqrt(SudokuDriver.Current_Dimension);
		} else if (SudokuDriver.Current_Dimension == 4) {
			bounds = (int) Math.sqrt(SudokuDriver.Current_Dimension);
		} else {
			System.out.println("Error if you see this line");
		}
		
		//complicated mathy stuff
		// honestly had to look up this algorithm, not smart enough for this tbh
		// the below stuff..
		
		int BoxBoxRow = row - row % bounds;
		int BoxBoxColumn = col - col % bounds;

		for (int i = BoxBoxRow; i < BoxBoxRow + bounds; i++) {
			for (int j = BoxBoxColumn; j < BoxBoxColumn + bounds; j++) {
				if (i != row && j != col) { // ignore value original input location
					if (sudGrid[i][j].getText().equals(input)) {
						System.out.println("EQUALS!");

						return true;
					}
				}

			}
		}
		return false;
	}
	
	/**checks if the value entered passes all the sudoku rules
	 * 
	 * @param row row value of input
	 * @param input string value entered(being checked)
	 * @param col column value of input
	 * @return true if value is value and doesn't exist in row/col/box
	 */

	public static boolean sudokuRuleCheck(int row, String input, int col) {
		if (!rowCheck(row, input, col) && !columnCheck(row, input, col) && !boxCheck(row, input, col)) {
			return true;
		}
		return false;

	}
	
	/** 
	 * Checks for a game win
	 * @return false if the board is not complete
	 */

	public static boolean checkGameWin() {
		for (int i = 0; i < SudGrid.sudGrid.length; i++) { // i = x or row
			for (int j = 0; j < SudGrid.sudGrid.length; j++) {
				if (!(sudGrid[i][j].getText().equals(sudGridCopy[i][j].getText()))) {
					return false;
				}
			}
		}
		System.out.println("You Win!");
		JWindow window2 = new JWindow(); // creating a splash screen by having a disposable window
		window2.getContentPane().add(
		    new JLabel(new ImageIcon("C:\\CST8116 Homework\\Eclipse Homework\\.metadata\\ActualSudoku\\sudoku_winner.png")), SwingConstants.CENTER);
		window2.setBounds(945, 500, 600, 300); // please note that these opening dimensions are based on my monitor which is 1440p.
		window2.setVisible(true);
		try {
		    Thread.sleep(3000); // Keeps the window open for 3000ms
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}				
		window2.dispose();// closes/destroys the splash window before starting the Sudoku program.	
		JOptionPane.showMessageDialog(null,"TEMPORARY VICTORY POPUP AS MY PLANNED WINDOW ISN'T SHOWING AND IT'S 10PM JULY 24TH -- I ALSO WANT TO HAVE POINTS DISPLAYED HERE IN THIS POPUP");
		return true;
	}	
	
}
