package serveur;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;

public class Server {
	
	public Model model;
	
	public Server() {
		model = new Model();

	}
	Object lancerMethode(Object obj, LinkedList<String> res, String nomMethode) throws Exception
	{
		System.out.println(nomMethode);
	   Class[] paramTypes = null;
	   if(res != null)
	   {
	      paramTypes = new Class[res.size()];
	      for(int i=0;i<res.size();++i)
	      {
	         paramTypes[i] = res.get(i).getClass();
	         System.out.println(paramTypes[i]);
	      }
	   }
	   Method m = obj.getClass().getMethod(nomMethode,paramTypes);
	   System.out.println("jjjjjjjjjjj");
	   return m.invoke(obj,res);
	}
	
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket(10009);
		} catch (IOException e) {
			System.err.println("Could not listen on port: 10007.");
			System.exit(1);
		}

		Socket clientSocket = null;
		System.out.println("Waiting for connection.....");

		try {

			clientSocket = serverSocket.accept();
		} catch (IOException e) {
			System.err.println("Accept failed.");
			System.exit(1);
		}

		System.out.println("Connection successful");
		System.out.println("Waiting for input.....");

		//PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));

		String inputLine;
		Server test = new Server();
		LinkedList<String> res = new LinkedList<String>();
		
		BufferedWriter p = new BufferedWriter(new OutputStreamWriter(
				clientSocket.getOutputStream()));
		//PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		PrintWriter outt = new PrintWriter(System.out, true);
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		
		while (!(inputLine = in.readLine()).equals("END")) {
			//inputLine = in.readLine();
			/*
			res.add(inputLine);*/
			
			System.out.println(inputLine);
			while (!(inputLine = in.readLine()).equals("END")) {
				System.out.println(inputLine);
			
			}

			
			
			System.out.println("fin du reçu");
			LinkedList<String> ret = test.model.listNickNameByName("Julien");
			
			
			
			//re = ret.pop();
			//System.out.println(re);
			ret.add("END");
			while(!ret.isEmpty())
				out.println(ret.pop());
			//outt.println(re);

			System.out.println("Fin envoie");
			/*String re = "";
			while(!ret.isEmpty()) {
				re = ret.pop();
				re= "test";
				System.out.println(re);
				outt.println(re);
				
				inputLine = in.readLine();
				System.out.println(inputLine);
	    	}*/
			
			//outt.println("test");
			//while((inputLine = in.readLine()) != "quit") System.out.println("ppppp");;

		//	in.reset();
	
				
		}
			
		System.out.println("Fin.......................");
		//out.close();
		in.close();
		clientSocket.close();

		serverSocket.close();
	}
}
