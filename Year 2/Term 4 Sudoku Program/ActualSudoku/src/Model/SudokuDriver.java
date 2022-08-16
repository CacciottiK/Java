package Model;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

import View.Skeleton;

/**
 * 
 * @author Kyle Thomas
 *
 */

public class SudokuDriver{
	
	/**
	 * Default value for grid on startup, changes as the games go
	 */	
	public static int Current_Dimension = 9;
	public static String openOptions[] = { "SudokuGame", "Open Client", "Open Server"};
	
	
	SudokuDriver(){				
		
	}; 
	
	public static void chooseToOpen() {
		JFrame menuFrame = new JFrame();
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		menuFrame.getContentPane().setSize(400,400);
		menuFrame.setResizable(false);
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JComboBox<String> whatToOpen = new JComboBox<>(openOptions);
		whatToOpen.setMaximumSize(new Dimension(100,25));
		
		ImageIcon image = new ImageIcon("CHOOSE.png");
		JLabel vector = new JLabel("",image, JLabel.CENTER);
		
		panel.add(vector, BorderLayout.WEST);
		panel.add(whatToOpen, BorderLayout.EAST);
		
		menuFrame.add(panel);
		
		
		whatToOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				@SuppressWarnings("unchecked") // Will Eventually fix..
				JComboBox<String> combo = (JComboBox<String>) e.getSource();
				String s = (String) combo.getSelectedItem();
				if (s.equals("SudokuGame")) {
					int start = Current_Dimension;
					new Skeleton(start);					
				} else if (s.equals("Open Client")) {
					new SudokuClient();					
				} else if (s.equals("Open Server")) {
					new SudokuServer();
				}

			}

		});
		
		
		
		
		
		menuFrame.pack();
		menuFrame.setVisible(true);
	}

	
	/**
	 * 
	 * @param args Method main
	 */
		public static void main(String[] args) {
			
			
			JWindow window = new JWindow(); // creating a splash screen by having a disposable window
			window.getContentPane().add(
			    new JLabel(new ImageIcon("sudsplash.png")), SwingConstants.CENTER);
			window.setBounds(945, 500, 600, 300); // please note that these opening dimensions are based on my monitor which is 1440p.
			window.setVisible(true);
			try {
			    Thread.sleep(2000); // Keeps the window open for 3000ms
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}				
			window.dispose();// closes/destroys the splash window before starting the Sudoku program.
			chooseToOpen();
			
		
		}

	
}

