package com;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class DemoClient {

	String data;
	DataInputStream dia,disi;
	DataOutputStream dos;
	Socket fromClient;
	public DemoClient() {
		// TODO Auto-generated constructor stub
		try {
			fromClient = new Socket(InetAddress.getLocalHost(),2000);
			
			System.out.println("Request Send");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			disi = new DataInputStream(fromClient.getInputStream());
			String message = disi.readUTF();
			
			System.out.println("From Server "+message);
			
			disi = new DataInputStream(System.in);
			String data = disi.readLine();
			
			dos = new DataOutputStream(fromClient.getOutputStream());
			
			dos.writeUTF(data);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 DemoClient Dc =new DemoClient();
		 Dc.talk();

	}

}
