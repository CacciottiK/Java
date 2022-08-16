package Model;

import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controller.ServerActions;

public class SudokuClient {

	public static JButton newGame, sendGame, recGame, sendData, playBut, connectButton, endButton;
	static int portNumber, PORT = 1000;
	public static String hostName, HOSTNAME, userName;
	public static JTextField userText, serverText, portText;
	public static JTextArea box;

	public static enum ClientActions {
		NEWGAME, SENDGAME, RECGAME, SENDDATA, PLAY, START2, END2
	}

	public SudokuClient() {
		createFrame();
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
		ImageIcon image = new ImageIcon("CLIENTIMAGE.png");
		JLabel vector = new JLabel("", image, JLabel.CENTER);
		imagePanel.setPreferredSize(new Dimension(800, 50));
		imagePanel.add(vector);

		// Creating the Button Pane

		JLabel userLabel = new JLabel("User:");
		JLabel serverLabel = new JLabel("Server:");
		userText = new JTextField();
		serverText = new JTextField();
		userText.setColumns(6);
		serverText.setColumns(6);

		newGame = new JButton("New Game");
		sendGame = new JButton("Send Game");
		recGame = new JButton("Receive Game");
		sendData = new JButton("Send Data");
		playBut = new JButton("Play");

		newGame.setEnabled(false);
		sendGame.setEnabled(false);
		recGame.setEnabled(false);
		sendData.setEnabled(false);
		playBut.setEnabled(false);

		portText = new JTextField();
		JLabel portLab = new JLabel("Port:");
		connectButton = new JButton("Connect");
		
		endButton = new JButton("End");
		
		
		portText.setColumns(6);
		buttonPanel.add(userLabel);
		buttonPanel.add(userText);
		buttonPanel.add(serverLabel);
		buttonPanel.add(serverText);
		buttonPanel.add(portLab);
		buttonPanel.add(portText);
		buttonPanel.add(connectButton);
	
		buttonPanel.add(endButton);

		buttonPanel.add(newGame);
		buttonPanel.add(sendGame);
		buttonPanel.add(recGame);
		buttonPanel.add(sendData);
		buttonPanel.add(playBut);
		textPanel.setBackground(Color.blue);
		textPanel.setPreferredSize(new Dimension(800, 10));
		box = new JTextArea(15, 55);
		box.setLineWrap(true);
		box.setWrapStyleWord(true);
		textPanel.add(box);

		connectButton.setActionCommand(ClientActions.START2.name());
		connectButton.addActionListener(instance);		
		endButton.setActionCommand(ClientActions.END2.name());
		endButton.addActionListener(instance);
		newGame.setActionCommand(ClientActions.NEWGAME.name());
		newGame.addActionListener(instance);
		sendGame.setActionCommand(ClientActions.SENDGAME.name());
		sendGame.addActionListener(instance);
		recGame.setActionCommand(ClientActions.RECGAME.name());
		recGame.addActionListener(instance);
		sendData.setActionCommand(ClientActions.SENDDATA.name());
		sendData.addActionListener(instance);
		playBut.setActionCommand(ClientActions.PLAY.name());
		playBut.addActionListener(instance);

		mainPanel.add(imagePanel);
		mainPanel.add(buttonPanel);
		mainPanel.add(textPanel);

		clientFrame.pack();
		clientFrame.setVisible(true);

	}
	
	public static void adjustPostConnect() {
		playBut.setEnabled(true);
		sendData.setEnabled(true);
		recGame.setEnabled(true);
		sendGame.setEnabled(true);
		newGame.setEnabled(true);
		connectButton.setEnabled(false);		
	}
	public static void adjustPostEnd() {
		playBut.setEnabled(false);
		sendData.setEnabled(false);
		recGame.setEnabled(false);
		sendGame.setEnabled(false);
		newGame.setEnabled(false);
		connectButton.setEnabled(true);		
	}
	

	public static void createClientSocket() {

		if (portText.getText().equals("") || userText.getText().equals("") || serverText.getText().equals("")) {
			box.append("Can't start with empty Fields\n");
		} else {

			hostName = serverText.getText();			
			portNumber = Integer.parseInt(portText.getText());
			userName = userText.getText();

			System.out.println("User: " + userName + " Is Connecting with server on " + hostName + " at port " + portNumber);

			try (Socket echoSocket = new Socket(hostName, portNumber);
					PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
					BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
					BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
				String userInput;
				while ((userInput = stdIn.readLine()) != null) {
					out.println(userInput);
					System.out.println("echo: " + in.readLine());
				}
			} catch (UnknownHostException e) {
				System.err.println("Don't know about host " + hostName);
				System.exit(1);
			} catch (IOException e) {
				System.err.println("Couldn't get I/O for the connection to " + hostName);
				System.exit(1);
			}

		}

	}

}
