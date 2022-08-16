package CST8221.week02;

import javax.swing.JFrame;

	import javax.swing.*;
	import java.awt.*;
	
	/**
	 * DemoClass
	 * @author sousap
	 *
	 */
	public class SwingDemoW2 extends JFrame{
		/**
		 *  Hash map
		 */
		private static final long serialVersionUID = 1L;

		public void show() {
	        JFrame frame = new JFrame("Hello World Java Swing");
	        frame.setMinimumSize(new Dimension(100, 100));
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        JLabel lblText = new JLabel("Hello World!", SwingConstants.CENTER);
	        frame.getContentPane().add(lblText);
	        frame.pack();
	        frame.setVisible(true);
	    }
	}
