package serveur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import exception.NameNotExist;
import exception.NewNameAlreadyExist;
import exception.oldNameAreadyExist;

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
	/*public List<String> listNameByAlph() throws NameNotExist{
		Collections.sort(listPer);
	}*/
	
	public LinkedList<String> listNickNameByName(String name) throws NameNotExist{
		if(!alreadyExist(name)) throw new NameNotExist();
		Personne Per = new Personne(name);
		int rang = listPer.indexOf(Per);
		LinkedList<String> list = new LinkedList<String>(listPer.get(rang).getListNickName());
		
		return app.application(list);
	}
	
	public List<String> addName(String name) throws NewNameAlreadyExist {
		
		if(alreadyExist(name)) throw new NewNameAlreadyExist();
		
		Personne newPer = new Personne(name);
		listPer.add(newPer);
		return app.appValid();
		
	}
	
	public  List<String> updateName(String oldName, String newName) throws oldNameAreadyExist, NewNameAlreadyExist {
		
		if(alreadyExist(oldName)) {
			if(!alreadyExist(newName)) {
				Personne oldPer = new Personne(oldName);
				int rang = listPer.indexOf(oldPer);
				listPer.get(rang).setName(newName);
				
				return app.appValid();
			} else {
				throw new oldNameAreadyExist();
			}
		} else {
			throw new NewNameAlreadyExist();
		}
			
		
	}
	
	public boolean alreadyExist(String name) {
		Personne Per = new Personne(name);
		if(listPer.contains(Per)) System.out.println("OK");
		else System.out.println("NO");
		return listPer.contains(Per);
		
	}
	
	
	
	
}
