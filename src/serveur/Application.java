package serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Application {
	
	public static final String END_APP = "END";
	
	/**
	   * Mise en place du protocole
	   * @param res
	   * @return
	   */
	  public static LinkedList<String>appError(String msg) {
		  LinkedList<String> ret = new LinkedList<String>();
		  
		 ret.add("NO"); 
		  ret.add(msg);
		  ret.add(Application.END_APP);
		  return ret;
	 }
	  
	  public static LinkedList<String>appValid() {
		  LinkedList<String> ret = new LinkedList<String>();
		 ret.add("OK"); 
		  ret.add("Operation effectuée");
		  ret.add(Application.END_APP);
		  return ret;
	  }
	  public static LinkedList<String>application(LinkedList<String> list) {
		  LinkedList<String> ret = new LinkedList<String>();
			  ret.addAll(list);
			  ret.add(Application.END_APP);
			  return ret;
	  }
	  public static LinkedList<String>application(String msg) {
		  LinkedList<String> ret = new LinkedList<String>();
		 
			  ret.add(msg);
			  ret.add(Application.END_APP);
			  return ret;
	  }
		/**
	   * 
	   * @return Recupère l'entrée dans un String
	   * @throws IOException
	   */
	  public static String lireClavier() throws IOException
	  {
		  BufferedReader entree = new BufferedReader( new InputStreamReader(System.in));
		  String ligne = entree.readLine();
		  return ligne;
	  }
}
