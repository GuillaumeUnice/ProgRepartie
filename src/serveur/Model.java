package serveur;

import java.util.ArrayList;
import java.util.HashSet;

public class Model {
	
	private ArrayList<Personne> listPer = new ArrayList<Personne>();
	private Application app = new Application();
	
	public Model() {
		Personne newPer1 = new Personne("Paul",new ArrayList<String>());
		ArrayList<String> nickName2 = new ArrayList<String>();
		nickName2.add("nickName1");
		nickName2.add("nickName2");
		
		Personne newPer2 = new Personne("Julien",nickName2);
		listPer.add(newPer1);
		listPer.add(newPer2);
	}
	private boolean isName(String name) {
		for (Personne p : listPer) {
			if(p.getName() == name) {
				return true;
			}
		}
		return false;
	}
	public boolean addName(String name) {
		if(!this.isName(name)) return false;
		Personne newPer = new Personne(name,null);
		listPer.add(newPer);
		return true;
		
	}
	
	public boolean updateName(String oldName, String newName) {
		//if(!this.isName(oldName)) return false;
		//if(this.isName(newName)) return false;
		
		Personne test = new Personne("Julien", null);
		System.out.println("sfs");
		
		HashSet<Personne> hashList = new HashSet<Personne>();
		//hashList.
		if(listPer.contains("Julien"))
			System.out.println("Ca marche");
		else System.out.println("Ca ne marche pas!!");
		
	//	listPer.contains(new Personne());
		//Personne newPer = new Personne(name,null);
		//listPer.add(newPer);
		return true;
	}
	
	
}
