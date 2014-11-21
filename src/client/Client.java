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
	
	//Client Echo
    public static void main(String[] args) throws Exception {
    	Client test = new Client();
    	
    	
        String serverHostname = new String ("127.0.0.1");

        if (args.length > 0)
           serverHostname = args[0];
        System.out.println ("Attemping to connect to host " +
        serverHostname + " on port 10007.");

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket(serverHostname, 10009);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                                        echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                               + "the connection to: " + serverHostname+e.getMessage());
           
            System.exit(1);
        }

    BufferedReader stdIn = new BufferedReader(
                                   new InputStreamReader(System.in));
    String userInput;

    System.out.println(test.p.printFunction());
    System.out.println("\nVeuillez choisir en inscrivant le nom de fonctionnalité :");
    String inputLine = "";
    while (!(userInput = stdIn.readLine()).equals("END")) {
    	LinkedList<String> res = (LinkedList<String>) test.lancerMethode(test.p, null, userInput);
    	res.add("END");
    	System.out.println(res);
    	while(!res.isEmpty()) {
    		out.println(res.pop());
    	}
    	
    	//System.out.println(in.toString());
	    //System.out.println("echo: " + in.readLine());
		while (!(inputLine = in.readLine()).equals("END")) {
			System.out.println(inputLine);
		
		}
    }
    out.println("END");
    out.close();
    in.close();
    stdIn.close();
    echoSocket.close();
    }
}
