package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Person {
	
	/**
	   *
	   * @return Renvoie le nom de la fonction que l'on est en trai d'executer
	   */
	  public static String getMethodeName()
	  {
	          Throwable t = new Throwable();
	          t.fillInStackTrace();
	          StackTraceElement e = t.getStackTrace()[1];
	          String functionName = e.getMethodName();
	          return functionName ;
	  }
	  public static String lireClavier() throws IOException
	  {
		  BufferedReader entree = new BufferedReader( new InputStreamReader(System.in));
		  String ligne = entree.readLine();
		  return ligne;
	  }
	public LinkedList<String>addNickName(String name, String nickName) throws IOException {
		LinkedList<String> res = new LinkedList<String>();
		res.add(this.getMethodeName());
		System.out.println("A quelle personne voulez vous ajouter un surnom : ");
		Scanner in = new Scanner(System.in);
		res.add(this.lireClavier());
		System.out.println("Quelle surnom : ");
		res.add(this.lireClavier());	
		return res;
		
	}
	
}
