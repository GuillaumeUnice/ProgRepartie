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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import exception.ApplicationException;
import exception.NameNotExist;
import exception.NewNameAlreadyExist;
import exception.OldNameAlreadyExist;

public class Server {
	
	private Model model;
	
	public Server() {
		model = new Model();
		model.initialise();
	}
	
	public Model getModel() {
		return model;
	}
	
	List<String> receiveReq(String inputLine, BufferedReader in) throws IOException {
		
		LinkedList<String> req = new LinkedList<String>();
		String rep = "--------------------------------------\n";
		  	  rep += "----------Requête du client----------\n";
		  	  rep += "--------------------------------------\n";
		System.out.println(rep);
		
		req.add(inputLine);
		
		while (!(inputLine = in.readLine()).equals(Application.END_APP)) {
			System.out.println(inputLine);
			req.add(inputLine);
		}
		
		return req;
	}
	Object lancerMethode(Object obj, List<String> res, String nomMethode) throws Exception
	{

		
	   Class[] paramTypes = null;
	   Object[]args = null;
	
	   if(res != null)
	   {
	      // Type de paramêtre de la méthode appelé
		  paramTypes = new Class[res.size()];
	      
	      for(int i=0;i<res.size();++i)
	      {
	         paramTypes[i] = res.get(i).getClass();
	         System.out.println(paramTypes[i]);
	      }
	      
	      // Passage des arguments effectifs à la méthode
	      args = new Object[res.size()];
	      for(int i=0;i<res.size();++i)
	      {
	    	  args[i] = (Object) res.get(i);
	
	      }
	   }
	   
	   // Recupération et appelle dynamique de la méthode
	   Method m = obj.getClass().getMethod(nomMethode,paramTypes);
	   return m.invoke(obj,args);
	}
	
	public static void main(String[] args) throws Throwable {
		ServerSocket serverSocket = null;
		int port = 10009;
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			System.err.println("Le serveur ne peut écouter sur le port : " + port);
			System.exit(1);
		}

		Socket clientSocket = null;
		System.out.println("En attente de connexion...");

		try {

			clientSocket = serverSocket.accept();
		} catch (IOException e) {
			
			System.err.println("Acceptation du client à echoué.");
			System.exit(1);
		}

		System.out.println("La connexion est réussie.");
		System.out.println("En attente de requête client...");

		// Mise en place des I/O client-server
		BufferedReader in = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		
		String inputLine;
		Server server = new Server();
		LinkedList<String> res = new LinkedList<String>();
		
		
		
		while (!(inputLine = in.readLine()).equals(Application.END_APP)) {
			
			
			res = (LinkedList<String>) server.receiveReq(inputLine, in);
			
			System.out.println("fin du reçu");
			
			try {
				res = (LinkedList<String>) server.lancerMethode(server.getModel(), res, res.pop());
			} catch (InvocationTargetException e) { 
				  try { throw e.getCause(); }
				  catch(ApplicationException err) { res = Application.appError(err.msg()); }
				  
			}
			
			//LinkedList<String> ret = server.model.listNickNameByName("Julien");
			
			//ret.add(Application.END_APP);
			while(!res.isEmpty())
				out.println(res.pop());

			System.out.println("Fin envoie");
							
		}
			
		System.out.println("Fin.......................");
		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();
	}


}
