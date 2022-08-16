package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Model.SudokuClient;
import Model.SudokuClient.ClientActions;
import Model.SudokuServer;
import Model.SudokuServer.Actions;

public class ServerActions implements ActionListener {

	public ServerActions() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == Actions.START.name()) {
			try {
				SudokuServer.createServerSocket();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			SudokuServer.endButton.setEnabled(false);
		}else if(e.getActionCommand() == Actions.END.name()) {
			SudokuServer.box.append("this works i swear\n");
		}else if(e.getActionCommand() == Actions.RESULTS.name()) {
			SudokuServer.box.append("this works i swear\n");
		}else if(e.getActionCommand() == ClientActions.PLAY.name()) {
			SudokuClient.box.append("this works i swear\n");
		}else if(e.getActionCommand() == ClientActions.NEWGAME.name()) {
			SudokuClient.box.append("this works i swear\n");
		}else if(e.getActionCommand() == ClientActions.RECGAME.name()) {
			SudokuClient.box.append("this works i swear\n");
		}else if(e.getActionCommand() == ClientActions.SENDDATA.name()) {
			SudokuClient.box.append("this works i swear\n");
		}else if(e.getActionCommand() == ClientActions.SENDGAME.name()) {
			SudokuClient.box.append("this works i swear\n");
		}else if(e.getActionCommand() == ClientActions.END2.name()) {
			SudokuClient.adjustPostEnd();
			SudokuClient.box.append("this works i swear\n");
		}else if(e.getActionCommand() == ClientActions.START2.name()) {
			SudokuClient.adjustPostConnect();
		//	SudokuClient.createClientSocket();
			SudokuClient.box.append("this works i swear\n");
		
		}
		
		
	}
}
