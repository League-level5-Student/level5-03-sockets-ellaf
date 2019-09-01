package _02_Chat_Application;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import _00_Click_Chat.networking.Client;
import _00_Click_Chat.networking.Server;

/*
 * Using the Click_Chat example, write an application that allows a server computer to chat with a client computer.
 */

public class ChatApp extends JFrame implements ActionListener{

	CAServer caserv;
	CAClient cacli;
	JTextField textInput1 = new JTextField();
	JTextField textInput2 = new JTextField();
	JPanel panel = new JPanel();
	JLabel label = new JLabel("Type a message for Client:");
	JButton button1 = new JButton("Send");
	JButton button2 = new JButton("Send");

	public static void main(String[] args) {
		new ChatApp();
	}
	
	public ChatApp() {
		
		int response = JOptionPane.showConfirmDialog(null, "Would you like to host a connection?", "Buttons!", JOptionPane.YES_NO_OPTION);
		if(response == JOptionPane.YES_OPTION){
			caserv = new CAServer(4545);
			setTitle("Server");
			JOptionPane.showMessageDialog(null, "Server Hosted At: \nIP - " + caserv.getIPAddress() + "\nPort - " + caserv.getPort());
			setSize(400,100);
			textInput1.setPreferredSize(new Dimension(300,50));
			panel.add(textInput1);
			panel.add(button1);
			button1.addActionListener(this);
			add(panel);
			pack();
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			caserv.start();
			
		}else{
			setTitle("Client");
			String ipStr = JOptionPane.showInputDialog("Enter the IP address:");
			String prtStr = JOptionPane.showInputDialog("Enter the port number:");
			int port = Integer.parseInt(prtStr);
			cacli = new CAClient(ipStr, port);
			add(textInput2);
			;
			setVisible(true);
			setSize(400,100);
			textInput2.setPreferredSize(new Dimension(300,50));
			panel.add(textInput2);
			panel.add(button2);
			button2.addActionListener(this);
			add(panel);
			pack();
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			cacli.start();
			
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(button1)) {
			String a = textInput1.getText();
			caserv.sendChat(a);
			textInput1.setText("");
		}
		if(e.getSource().equals(button2)) {
		String b = textInput2.getText();
		cacli.sendChat(b);
		textInput2.setText("");
		}
	}

	

	

}
