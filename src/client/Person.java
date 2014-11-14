package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Scanner;

public class Person {
	
	private Application a= new Application();
	/**
	   *
	   * @return Renvoie le nom de la fonction que l'on est en train d'executer
	   */
	  public static String getMethodeName()
	  {
	          Throwable t = new Throwable();
	          t.fillInStackTrace();
	          StackTraceElement e = t.getStackTrace()[1];
	          String functionName = e.getMethodName();
	          return functionName ;
	  }
	  
	 
	  public LinkedList<String> listNickNameByName() throws IOException {
		  	LinkedList<String> res = new LinkedList<String>();
		  	res.add(this.getMethodeName());
		  	System.out.println("Obtenir la liste des surnoms de quelle personne : ");
			Scanner in = new Scanner(System.in);
			res.add(a.lireClavier());
			return a.application(res);
	  }
	  
	  public LinkedList<String> listNickNameByAlph() {
		  LinkedList<String> res = new LinkedList<String>();
		  res.add(this.getMethodeName());
			return a.application(res);
	  }
	  
	  public LinkedList<String> listNameByAlph() {
		  LinkedList<String> res = new LinkedList<String>();
		  res.add(this.getMethodeName());
			return a.application(res);
	  }
	  
	public LinkedList<String>addNickName() throws IOException {
		LinkedList<String> res = new LinkedList<String>();
		res.add(this.getMethodeName());
		System.out.println("A quelle personne voulez vous ajouter un surnom : ");
		Scanner in = new Scanner(System.in);
		res.add(a.lireClavier());
		System.out.println("Quelle surnom : ");
		res.add(a.lireClavier());	
		return a.application(res);
	}
	
	public LinkedList<String>quit() throws IOException {
		LinkedList<String> res = new LinkedList<String>();
		res.add(this.getMethodeName());
		res.add(a.lireClavier());	
		return a.application(res);
	}
	
	public LinkedList<String>whatPerson() throws IOException {
		LinkedList<String> res = new LinkedList<String>();
		res.add(this.getMethodeName());
		System.out.println("Sur quel surnom voulez vous rechercher les personnes : ");
		Scanner in = new Scanner(System.in);
		res.add(a.lireClavier());	
		return a.application(res);
	}
	/**
	 * 
	 * @return String contenant l'ensemble des actions/fonctionnalité applicable au serveur
	 */
	public String printFunction() {
		Method[] tab = this.getClass().getDeclaredMethods() ;
		String separateur = " | ";
		String res = "Liste des fonctionnalitées : ";
		for (int i = 0; i < tab.length; i++) {
			res = tab[i].getName() + separateur;
		}
		res = res.substring(0,(res.length()>=1)? res.length()-separateur.length(): 0);
		
			return res;
	}

}
