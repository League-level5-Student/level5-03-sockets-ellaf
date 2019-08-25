package _02_Chat_Application;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import _00_Click_Chat.networking.Client;
import _00_Click_Chat.networking.Server;

/*
 * Using the Click_Chat example, write an application that allows a server computer to chat with a client computer.
 */

public class ChatApp extends JFrame{

	CAServer caserv;
	CAClient cacli;
	JTextField textInput = new JTextField();
	JLabel label = new JLabel("Type a message for Client:");

	public static void main(String[] args) {
		new ChatApp();
	}
	
	public ChatApp() {
		
		int response = JOptionPane.showConfirmDialog(null, "Would you like to host a connection?", "Buttons!", JOptionPane.YES_NO_OPTION);
		if(response == JOptionPane.YES_OPTION){
			caserv = new CAServer(4545);
			setTitle("Server");
			JOptionPane.showMessageDialog(null, "Server Hosted At: \nIP - " + caserv.getIPAddress() + "\nPort - " + caserv.getPort());
			add(label);
			add(textInput);
			pack();
			setVisible(true);
			setSize(200, 300);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			caserv.start();
			
		}else{
		
			
			
		}
		
	}
}
