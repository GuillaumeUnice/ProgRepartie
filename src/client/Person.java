package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import exception.NewNameAlreadyExist;
import exception.OldNameAlreadyExist;

public class Person {
	
	private Application a= new Application();
	/**
	   *
	   * @return Renvoie le nom de la fonction que l'on est en train d'executer
	   */
	  private static String getMethodeName()
	  {
	          Throwable t = new Throwable();
	          t.fillInStackTrace();
	          StackTraceElement e = t.getStackTrace()[1];
	          String functionName = e.getMethodName();
	          return functionName ;
	  }
	  
	 
	  public List<String> listNickNameByName() throws IOException {
		  	LinkedList<String> res = new LinkedList<String>();
		  	res.add(this.getMethodeName());
		  	System.out.println("Obtenir la liste des surnoms de quelle personne : ");
			Scanner in = new Scanner(System.in);
			res.add(a.lireClavier());
			return a.application(res);
	  }
	  
	  public List<String> test() throws IOException {
		  	LinkedList<String> res = new LinkedList<String>();
		  	res.add(this.getMethodeName());
		  	res.add("Julie");
			return a.application(res);
	  }
	  
	  public List<String> listNickNameByAlph() {
		  LinkedList<String> res = new LinkedList<String>();
		  res.add(this.getMethodeName());
			return a.application(res);
	  }
	  
	  public List<String> listNameByAlph() {
		  LinkedList<String> res = new LinkedList<String>();
		  res.add(this.getMethodeName());
			return a.application(res);
	  }
	  
	public List<String>addNickName() throws IOException {
		LinkedList<String> res = new LinkedList<String>();
		res.add(this.getMethodeName());
		System.out.println("A quelle personne voulez vous ajouter un surnom : ");
		Scanner in = new Scanner(System.in);
		res.add(a.lireClavier());
		System.out.println("Quelle surnom : ");
		res.add(a.lireClavier());	
		return a.application(res);
	}
	
	public List<String>delName() throws IOException {
		LinkedList<String> res = new LinkedList<String>();
		res.add(this.getMethodeName());
		System.out.println("Quelle nom voulez vous supprimer : ");
		Scanner in = new Scanner(System.in);
		res.add(a.lireClavier());
		return a.application(res);
	}
	public List<String>delNickName() throws IOException {
		LinkedList<String> res = new LinkedList<String>();
		res.add(this.getMethodeName());
		System.out.println("Quelle surnom voulez vous supprimer : ");
		Scanner in = new Scanner(System.in);
		res.add(a.lireClavier());
		return a.application(res);
	}
	
	public List<String>quit() throws IOException {
		LinkedList<String> res = new LinkedList<String>();
		return a.application(res);
	}
	
	public List<String>whatPerson() throws IOException {
		LinkedList<String> res = new LinkedList<String>();
		res.add(this.getMethodeName());
		System.out.println("Sur quel surnom voulez vous rechercher les personnes : ");
		Scanner in = new Scanner(System.in);
		res.add(a.lireClavier());	
		return a.application(res);
	}
	public  List<String> updateName() throws IOException {
		LinkedList<String> res = new LinkedList<String>();
		res.add(this.getMethodeName());
		System.out.println("Quelle nom de personne voulez vous modifier : ");
		Scanner in = new Scanner(System.in);
		res.add(a.lireClavier());
		System.out.println("Quelle sera son nouveau nom : ");
		res.add(a.lireClavier());
		return a.application(res);
	}
	public  List<String> updateNickName() throws IOException {
		LinkedList<String> res = new LinkedList<String>();
		res.add(this.getMethodeName());
		System.out.println("Quelle est le nom de la personne dont vous voulez modifier l'un de ses surnoms : ");
		Scanner in = new Scanner(System.in);
		res.add(a.lireClavier());
		System.out.println("Quelle est le surnom a modifier : ");
		res.add(a.lireClavier());
		System.out.println("Quelle est le nouveau surnom : ");
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
		String res = "--------------------------------------\n";
			  res += "------Liste des fonctionnalitées------\n";
			  res += "--------------------------------------\n";
		for (int i = 0; i < tab.length; i++) {
			if(!(tab[i].getName().equals(this.getMethodeName()))) 
				 if(!(tab[i].getName().equals("getMethodeName")))		
					 res += tab[i].getName() + separateur;
		}
		res = res.substring(0,(res.length()>=1)? res.length()-separateur.length(): 0);
		
			return res;
	}

}
