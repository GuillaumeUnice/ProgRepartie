package serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Application {
	/**
	   * Mise en place du protocole
	   * @param res
	   * @return
	   */
	  public static LinkedList<String>application(boolean res, String msg) {
		  LinkedList<String> ret = new LinkedList<String>();
		  if(res) ret.add("OK");
		  else ret.add("NO");
		  
		  ret.add(msg);
		  ret.add(null);
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