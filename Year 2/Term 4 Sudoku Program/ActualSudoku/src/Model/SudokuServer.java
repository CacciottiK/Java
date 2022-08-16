package Model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controller.ServerActions;

public class SudokuServer {

	public static JButton startButton, endButton, resultsButton;
	public static JTextField portText;
	static int PORT, portNumber;
	public static JTextArea box;
	// public static ServerSocket serverSocket;
	
	Socket ASocket;

	public static enum Actions {
		START, RESULTS, FINALIZE, END
	}

	public SudokuServer() {
		createFrame();
	}
	
	public static void createServer() {
		
		if (portText.getText().equals("")) {
			box.append("Can't have an empty Port\n");
		}
		String host = portText.getText();
		//Socket ASocket = new Socket(host, portNumber);
	}

	public static void createFrame() {
		ServerActions instance = new ServerActions();
		JFrame clientFrame = new JFrame();
		clientFrame.setPreferredSize(new Dimension(800, 800));
		clientFrame.setResizable(false);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		clientFrame.add(mainPanel);

		JPanel imagePanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JPanel textPanel = new JPanel();

		// adding to image pane
		ImageIcon image = new ImageIcon("SERVERIMAGE.png");
		JLabel vector = new JLabel("", image, JLabel.CENTER);
		imagePanel.setPreferredSize(new Dimension(800, 50));
		imagePanel.add(vector);

		// Creating the Button Pane

		portText = new JTextField();
		JLabel portLab = new JLabel("Port:");
		startButton = new JButton("Start");
		resultsButton = new JButton("Results");
		JRadioButton finalize = new JRadioButton("Finalize");
		endButton = new JButton("End");
		portText.setColumns(6);
		buttonPanel.add(portLab);
		buttonPanel.add(portText);
		buttonPanel.add(startButton);
		buttonPanel.add(resultsButton);
		buttonPanel.add(finalize);
		buttonPanel.add(endButton);
		textPanel.setBackground(Color.blue);
		textPanel.setPreferredSize(new Dimension(800, 10));
		box = new JTextArea(15, 55);
		box.setLineWrap(true);
		box.setWrapStyleWord(true);
		textPanel.add(box);

		mainPanel.add(imagePanel);
		mainPanel.add(buttonPanel);
		mainPanel.add(textPanel);

		startButton.setActionCommand(Actions.START.name());
		startButton.addActionListener(instance);
		resultsButton.setActionCommand(Actions.RESULTS.name());
		resultsButton.addActionListener(instance);
		endButton.setActionCommand(Actions.END.name());
		endButton.addActionListener(instance);

		clientFrame.pack();
		clientFrame.setVisible(true);

	}

	public static void createServerSocket() throws IOException{

		if (portText.getText().equals("")) {
			box.append("Can't have an empty Port\n");
		} else {

			portNumber = Integer.parseInt(portText.getText());

			System.out.println("Starting EchoServer on port " + portNumber);

			ServerSocket serverSocket = new ServerSocket(portNumber);
			Socket clientSocket = serverSocket.accept();
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			DataInputStream aa  = new DataInputStream(clientSocket.getInputStream());		
					
			out.println(aa.readUTF());
			

		}

	}

}
