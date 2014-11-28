package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedList;

public class Client {
	
	private Person p = new Person();
	
	void choiceFunc() {
		System.out.println(p.printFunction());
	    System.out.println("\nVeuillez choisir en inscrivant le nom de fonctionnalité :");
	}

	Object lancerMethode(Object obj, Object[] args, String nomMethode) throws Exception
	{
	   Class[] paramTypes = null;
	   if(args != null)
	   {
	      paramTypes = new Class[args.length];
	      for(int i=0;i<args.length;++i)
	      {
	         paramTypes[i] = args[i].getClass();
	      }
	   }
	   Method m = obj.getClass().getMethod(nomMethode,paramTypes);
	   return m.invoke(obj,args);
	}
	
	void sendReq(LinkedList<String> reqClient, PrintWriter out) {
		while(!reqClient.isEmpty()) {
    		out.println(reqClient.pop());
    	}
	}
	
	void receiveReq(BufferedReader in) throws IOException {
		String rep = "--------------------------------------\n";
		  	  rep += "----------Réponse du serveur----------\n";
		  	  rep += "--------------------------------------\n";
		System.out.println(rep);
		
		String serverOutput = "";
		while (!(serverOutput = in.readLine()).equals(Application.END_APP)) {
			System.out.println(serverOutput);
		
		}
	}
	
    public static void main(String[] args) throws Exception {
    	Client test = new Client();
    	
    	
        String serverHostname = new String ("127.0.0.1");

        int serverPort = 10009;
        if (args.length > 0)
           serverHostname = args[0];
        System.out.println ("En attente de connexion sur le serveur " +
        serverHostname + " sur le port " + serverPort);

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket(serverHostname, serverPort);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                                        echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Connexion impossible avec : " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Erreur lors de la mise en place des flux d'entrée/sortie : "
            		+ serverHostname+e.getMessage());
           
            System.exit(1);
        }
	
	    BufferedReader stdIn = new BufferedReader(
	                                   new InputStreamReader(System.in));
	    String userInput;
	
	    test.choiceFunc();
	    
	    while (!(userInput = stdIn.readLine()).equals("quit")) {
	
	    	try {
	    		
	    		LinkedList<String> reqClient = new LinkedList<String>();
	    	
	    		reqClient = (LinkedList<String>) test.lancerMethode(test.p, null, userInput);
	
		    	test.sendReq(reqClient, out);
		    	test.receiveReq(in);
		    	
		    	test.choiceFunc();
		    	
	    	} catch (NoSuchMethodException e) {
	    		System.out.println("Cette fonctionnalité n'existe pas : " + e.getMessage());
	    		test.choiceFunc();
	    	} catch (IOException e) {
	    		System.out.println("Erreur de lecture d'entrée : " + e.getMessage());
	    		test.choiceFunc();
	    	}
	    }
	    
	    out.println(Application.END_APP);
	    System.out.println("Session est close");
	    out.close();
	    in.close();
	    stdIn.close();
	    echoSocket.close();
    }
}