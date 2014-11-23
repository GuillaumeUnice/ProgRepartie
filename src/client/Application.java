package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Application {
	  
	public static final String END_APP = "END";
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
	  
	  /**
	   * Mise en place du protocole
	   * @param res
	   * @return
	   */
	  public static LinkedList<String>application(LinkedList<String> res) {
		  res.add(Application.END_APP);
		  return res;
	  }
	  
	  
}
