package View;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Model.SudGrid;
import Model.SudokuDriver;
/**
 * 
 * @author Kyle Thomas
 *
 */
public class Skeleton extends JFrame {

	/**
	 * Serial ID? :D
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Names the JFrame and initializes it
	 */
	private JFrame mainPanel = new JFrame("Kyle Thomas - 040733617  - Sudoku");
	/**
	 * Side panel declaration
	 */
	private JPanel sidePanel;

	/**
	 * Possible difficulties
	 */
	final String difficulty[] = { "Easy", "Medium", "Hard" };
	
	/**
	 * board sizes
	 */
	final String size[] = { "2x2", "3x3", "4x4" };
	/**
	 * label for timer
	 */
	JLabel newTimer = new JLabel();
	
	int timePast,minutes,seconds;
	
	/**
	 * Creating a new timer and applying it
	 */
	
	Timer timer = new Timer(1000, new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {			
			timePast=timePast+1000;				
			minutes = (timePast/60000) % 60;
			seconds = (timePast/1000) % 60;
			String showsec = String.format("%02d", seconds);
			String showmin = String.format("%02d", minutes);				
			newTimer.setText(showmin+":"+showsec);
			//applies the timer values to the Jlabel created.
			
		}
		
	});
	
	/**the skeleton of the project, calls/creates the main panel and gets the game going
	 * 
	 * @param dimension size of the board
	 */
	public Skeleton(int dimension) {

		// int check = dimension;
		mainPanel.setSize(800, 750);
		mainPanel.setResizable(false);
		mainPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.add(new SudGrid(dimension), BorderLayout.WEST); // adds grid -

		// Defining the Menu bar which holds the game and help options
		Menu();
		//adding the side panel to the main frame
		mainPanel.add(theSidePanel(), BorderLayout.EAST);
		SudokuDriver.Current_Dimension = dimension;
		mainPanel.pack();
		// setGrid(check);
		mainPanel.setVisible(true);

	};		
	
	/**
	 * starts the timer
	 */
	public void start() {
		timer.start();
	}
	
	/**
	 * stops the timer
	 */
	
	public void stop() {
		timer.stop();
	}
	
	public void resetTime() {
		timer.stop();
		timePast = 0;
		minutes = 0;
		seconds = 0;		
	}
	/**
	 * builds the menu bar at the top opf the program. This will allows the use of features such as about/color chooser/a solution generator(maybe) and creating a new game
	 */
	public void Menu() {

		JMenuBar newBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu helpMenu = new JMenu("Help");

		//loading up the icons for the menu
		ImageIcon imagenewgame = new ImageIcon(
				"C:\\CST8116 Homework\\Eclipse Homework\\.metadata\\ActualSudoku\\piciconnew.gif");
		ImageIcon imagesolution = new ImageIcon(
				"C:\\CST8116 Homework\\Eclipse Homework\\.metadata\\ActualSudoku\\piciconsol.gif");
		ImageIcon imageexit = new ImageIcon(
				"C:\\CST8116 Homework\\Eclipse Homework\\.metadata\\ActualSudoku\\piciconext.gif");
		ImageIcon imagecolors = new ImageIcon(
				"C:\\CST8116 Homework\\Eclipse Homework\\.metadata\\ActualSudoku\\piciconcol.gif");
		ImageIcon imageabout = new ImageIcon(
				"C:\\CST8116 Homework\\Eclipse Homework\\.metadata\\ActualSudoku\\piciconabt.gif");

		//creating menu items
		JMenuItem newgame = new JMenuItem("New", imagenewgame);
		JMenuItem solution = new JMenuItem("Solution", imagesolution);
		JMenuItem exit = new JMenuItem("Exit", imageexit);
		JMenuItem colors = new JMenuItem("Colors", imagecolors);
		JMenuItem about = new JMenuItem("About", imageabout);

		fileMenu.add(newgame);
		fileMenu.add(solution);
		fileMenu.add(exit);
		helpMenu.add(colors);
		helpMenu.add(about);

		//adding the items to the menu bar
		newBar.add(fileMenu);
		newBar.add(helpMenu);

		//when new game is pressed, clears grid and then fills board
		newgame.addActionListener((ActionEvent e) -> {

			SudGrid.clearGrid();
			SudGrid.fillGrid(SudokuDriver.Current_Dimension, 1);

		});
		//genrates solution (maybe one day)
		solution.addActionListener((ActionEvent e) -> {
			JOptionPane.showMessageDialog(null,
					"Currently not implimented. Need to have my Sudoku generation algorithm correct before i can create a solution",
					"Sudoku By Kyle Thomas 040733617", JOptionPane.INFORMATION_MESSAGE);

		});
		
		// exits the program unethically
		exit.addActionListener((ActionEvent e) -> {

			mainPanel.dispose();

		});
		//allows the user to change the colors of the grid
		colors.addActionListener((ActionEvent e) -> {
			JColorChooser colorChooser = new JColorChooser();
			int dimControl;

			Color color = JColorChooser.showDialog(null, "Choose a Color for your board", Color.yellow);

			if (SudokuDriver.Current_Dimension == 16) {
				dimControl = 4;
			} else if (SudokuDriver.Current_Dimension == 9) {
				dimControl = 3;
			} else {
				dimControl = 2;
			}
			//applying the colors to the grid
			for (int x = 0; x < SudokuDriver.Current_Dimension; x++) {
				for (int y = 0; y < SudokuDriver.Current_Dimension; y++) {
					if ((x / dimControl + y / dimControl) % 2 == 0) {
						SudGrid.sudGrid[x][y].setBackground(color);
					}
				}
			}
		});
		
		// displays an about message
		about.addActionListener((ActionEvent e) -> {

			JOptionPane.showMessageDialog(null,
					"This Is a Sudoku game, The goal is to have each box with 1 of each value as well as each Row + Column with only one of each value. It's up to you to figure out this puzzle!",
					"Sudoku By Kyle Thomas 040733617", JOptionPane.INFORMATION_MESSAGE);

		});

		mainPanel.setJMenuBar(newBar);
	}
	
	/**Creates the side panel for the sudoku program
	 * 
	 * @return the created Jpanel
	 */

	public JPanel theSidePanel() {

		this.sidePanel = new JPanel();
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
		
		sidePanel.setBackground(Color.yellow);
		sidePanel.setPreferredSize(new Dimension(200, 100));
		
		
		ImageIcon image = new ImageIcon("C:/CST8116 Homework/Eclipse Homework/.metadata/ProjectSudoku/sudoku_logo.png");
		// Need to fix this massive thing lol
		// okay at the time it was wayyyyy too big, was using the wrong image

		JLabel picLabel = new JLabel("", image, JLabel.CENTER);
		picLabel.setBounds(40, 40, 40, 40);

		JRadioButton optionPlay = new JRadioButton("Play");
		JRadioButton optionCreate = new JRadioButton("Create");

		JLabel optionLabel = new JLabel("Current Mode: ");
		JLabel difficultyLabel = new JLabel("Current Difficulty: ");
		JLabel currentTimePast = new JLabel("Amount of Time Past: ");
		// need to set the background colors to match the JPanel background
		ButtonGroup bGroup = new ButtonGroup();
		bGroup.add(optionCreate);
		bGroup.add(optionPlay);
		optionPlay.setSelected(true);
		// Sets the default option to play
		// May need to throw this into the Action listener portion.
		
		
		//creating my Jcombo boxes (drop down menus)
		JComboBox<String> pickDiff = new JComboBox<>(difficulty);
		JComboBox<String> pickSize = new JComboBox<>(size);
		pickDiff.setMaximumSize(new Dimension(100, 25));
		pickSize.setMaximumSize(new Dimension(100, 25));
		// pickSize.addItem(4);
		// pickSize.addItem(9);
		// pickSize.addItem(16);

		JLabel buttonLabel = new JLabel("Board Size: ");
		// buttonLabel.setBounds(30,20,20,20);
		buttonLabel.setHorizontalAlignment(JLabel.LEFT);
		buttonLabel.setOpaque(false);
		buttonLabel.setForeground(Color.BLACK);
		
		// adding to the side panel
		sidePanel.add(picLabel);
		sidePanel.add(optionLabel);
		sidePanel.add(optionCreate);
		sidePanel.add(optionPlay);

		//JButton button = new JButton("Set to 4x4");
		//JButton button2 = new JButton("Set to 3x3");
		//JButton button3 = new JButton("Set to 2x2");
		//JButton button4 = new JButton("Submit");

		// ActionListener ok = new Control(null);

		// button.addActionListener(ok);
		// button2.addActionListener(ok);
		// button3.addActionListener(ok);
		// button4.addActionListener(ok);
		
		

		sidePanel.add(buttonLabel);
		sidePanel.add(pickSize);
		//sidePanel.add(button);
		sidePanel.add(difficultyLabel);
		sidePanel.add(pickDiff);
	//	sidePanel.add(button2);
		//sidePanel.add(button3);
		//sidePanel.add(button4);
		
		
		//adding the time to the Jpanel
		sidePanel.add(currentTimePast);
		sidePanel.add(newTimer);
		start();

		
		// Now i'm pretty sure you DIDN'T want this stuff here, but i'm just rolling with it.
		//Listens for the slection of board size.
		pickSize.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				@SuppressWarnings("unchecked") // Will Eventually fix..
				JComboBox<String> combo = (JComboBox<String>) e.getSource();
				String s = (String) combo.getSelectedItem();
				if (s.equals("2x2")) {
					mainPanel.dispose();
					mainPanel.getContentPane().removeAll();
					mainPanel.getContentPane().add(new Skeleton(4));
					mainPanel.pack();
				} else if (s.equals("3x3")) {
					mainPanel.dispose();
					mainPanel.getContentPane().removeAll();
					mainPanel.getContentPane().add(new Skeleton(9));
					mainPanel.pack();
				} else if (s.equals("4x4")) {
					mainPanel.dispose();
					mainPanel.getContentPane().removeAll();
					mainPanel.getContentPane().add(new Skeleton(16));
					mainPanel.pack();
				}

			}

		});

		
		//Listens for the selection of difficulty.
		pickDiff.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				@SuppressWarnings("unchecked") // Will Eventually fix..
				JComboBox<String> combo = (JComboBox<String>) e.getSource();
				String s = (String) combo.getSelectedItem();
				if (s.equals("Easy")) {
					resetTime();
					SudGrid.clearGrid();
					//SudGrid.testFill(SudokuDriver.Current_Dimension);
					SudGrid.fillGrid(SudokuDriver.Current_Dimension, 1);
					start();
				} else if (s.equals("Medium")) {
					resetTime();
					SudGrid.clearGrid();
					SudGrid.fillGrid(SudokuDriver.Current_Dimension, 2);
					start();
				} else if (s.equals("Hard")) {
					resetTime();
					SudGrid.clearGrid();
					SudGrid.fillGrid(SudokuDriver.Current_Dimension, 3);
					start();
				}

			}

		});

		// These are only here this way as a temporary measure.
		// It will be properly done in the action performed method below later
		optionPlay.addActionListener((ActionEvent e) -> {			
			SudGrid.clearGrid();
			SudGrid.fillGrid(SudokuDriver.Current_Dimension, 1);
			difficultyLabel.setVisible(true);
			pickDiff.setVisible(true);
			start();

		});

		optionCreate.addActionListener((ActionEvent e) -> {
			resetTime();
			SudGrid.clearGrid();
			difficultyLabel.setVisible(false);
			pickDiff.setVisible(false);
			
		});

		//button.addActionListener((ActionEvent e) -> {
			// printGrid(sudGrid);
		//	mainPanel.dispose();
		//	mainPanel.getContentPane().removeAll();
		//	mainPanel.getContentPane().add(new Skeleton(16));
		//	mainPanel.pack();
		//});
		//button2.addActionListener((ActionEvent e) -> {
		//	mainPanel.dispose();
		//	mainPanel.getContentPane().removeAll();
		//	mainPanel.getContentPane().add(new Skeleton(9));
		//	mainPanel.pack();
		//});
		//button3.addActionListener((ActionEvent e) -> {
		//	mainPanel.dispose();
		//	mainPanel.getContentPane().removeAll();
		//	mainPanel.getContentPane().add(new Skeleton(4));
		//	mainPanel.pack();
		//});
	//	button4.addActionListener((ActionEvent e) -> {
			// SudGrid.clearGrid();
		//	SudGrid.checkIfValid(SudGrid.sudGrid);
		//});

		return sidePanel;
	}
	
	/**Was supposed to create a image icon but i believe i did it incorrectly. scrapped for now.
	 * 
	 * @param path image URL
	 * @return return the image URL
	 */

	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = Skeleton.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

}