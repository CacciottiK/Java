/**
 * 
 */
package CST8221;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author paulo
 *
 */
public class Main extends JFrame implements ActionListener {

	public static final int WEEK = 0; // 0, 6, 0
	public static final int LAB = 105; // 92, 62, 91
	public static final boolean USESJAVAFX = true;

	int week = WEEK;
	int lab = LAB;
	boolean usesJFX = USESJAVAFX;

	// Basic
	static final long serialVersionUID = 1L;
	JLabel weekLabel = new JLabel("Week:");
	JTextField weekText = new JTextField(10);
	JLabel labLabel = new JLabel("Lab:");
	JTextField labText = new JTextField(10);
	JButton execButton = new JButton("Execute");
	JPanel mainPanel = new JPanel();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main mainFrame = new Main();
		int week, lab;
		boolean usesJFX = false, debug = false;
		if (args.length > 0) {
			if (debug) {
				for (int i = 0; i < args.length; i++) {
					System.out.println("Par[" + i + "]=" + args[i]);

				}
			}
			week = Integer.parseInt(args[0]);
			lab = Integer.parseInt(args[1]);
			System.out.println("Week: " + week + " - Lab: " + lab);
			mainFrame.invokeLab(week, lab, usesJFX, args);
		} else {
			mainFrame.configure();
		}
	}

	/**
	 * Configuration
	 */
	public void configure() {
		weekText.setText("0");
		labText.setText("0");
		execButton.addActionListener(this);
		mainPanel.add(weekLabel);
		mainPanel.add(weekText);
		mainPanel.add(labLabel);
		mainPanel.add(labText);
		mainPanel.add(execButton);
		add(mainPanel);
		setTitle("LabDemos - JAP (Fall 2021)");
		week = getWeek();
		lab = getLab();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	/**
	 * @param args    - String parameters
	 * @param week    - Week number
	 * @param lab     - lab number
	 * @param usesJFX - boolean value to use JavaFX
	 */
	public void invokeLab(int week, int lab, boolean usesJFX, String[] args) {
		switch (week) {
		case 0: // Hybrid
			System.out.println("Starting Hybrid!");
			Week00_Hybrid labhybrid = new Week00_Hybrid();
			labhybrid.invokeHybrid(lab, usesJFX, args);
			break; // week 1
		case 1: // Week 1
			System.out.println("Starting Week 01 Examples!");
			Week01 labweek01 = new Week01();
			labweek01.invokeWeek01(lab, usesJFX, args);
			break; // week 1
		case 2: // Week 2
			System.out.println("Starting Week 02 Examples!");
			Week02 labweek02 = new Week02();
			labweek02.invokeWeek02(lab, usesJFX, args);
			break;
		case 3: // Week 3
			System.out.println("Starting Week 03 Examples!");
			Week03 labweek03 = new Week03();
			labweek03.invokeWeek03(lab, usesJFX, args);
			break;
		case 4: // Week 4
			System.out.println("Starting Week 04 Examples!");
			Week04 labweek04 = new Week04();
			labweek04.invokeWeek04(lab, usesJFX, args);
			break;
		default: // invalid week
			String errorMessage = "No valid week!";
			displayErrorMessage(errorMessage);
			System.out.println(errorMessage);
		}
	}

	public int getWeek() {
		return Integer.parseInt(weekText.getText());
	}

	public int getLab() {
		return Integer.parseInt(labText.getText());
	}

	void addListener(ActionListener listenLab) {
		execButton.addActionListener(listenLab);
	}

	void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			week = getWeek();
			lab = getLab();
			boolean usesJFX = true;
			String[] args = {};
			invokeLab(week, lab, usesJFX, args);
		} catch (NumberFormatException ex) {
			displayErrorMessage("Enter a valid Week and a valid the Lab!");
		}
	}

}
