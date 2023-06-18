package com;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DemoServer {
	
	DataInputStream dia,disi;
	DataOutputStream dos;
	ServerSocket ss;
	Socket fromServer;
	
	public DemoServer() {
		// TODO Auto-generated constructor stub
		
		try {
			ss = new ServerSocket(2000);
			

			System.out.println("Serevr Started");
			
			fromServer = ss.accept();
			System.out.println("Request Accepted");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void talk()
	{
		while(true)
		{
		try {
			disi = new DataInputStream(System.in);
			String data = disi.readLine();
			
			dos = new DataOutputStream(fromServer.getOutputStream());
			dos.writeUTF(data);
			
			disi = new DataInputStream(fromServer.getInputStream());
			String message = disi.readUTF();
			
			System.out.println("From Client "+message);

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 DemoServer Ds=new DemoServer();
		 Ds.talk();
	}

}
