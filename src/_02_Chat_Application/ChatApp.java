package _02_Chat_Application;

import _00_Click_Chat.networking.Client;
import _00_Click_Chat.networking.Server;

/*
 * Using the Click_Chat example, write an application that allows a server computer to chat with a client computer.
 */

public class ChatApp {

	
	
	public static void main(String[] args) {
		
		Server server = new Server(3478);
		int port = server.getPort();
		String ip = server.getIPAddress();
		Client client = new Client(ip, port);
		
		
	}
}
