package serveur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import exception.NameNotExist;
import exception.NewNameAlreadyExist;
import exception.NickNameAlreadyExist;
import exception.NickNameNotExist;
import exception.OldNameAlreadyExist;

public class Model {
	
	private ArrayList<Personne> listPer = new ArrayList<Personne>();
	private Application app = new Application();
	
	/*
	 * Permet une initialisation de base du model
	 */
	void initialise() {
		Personne newPer1 = new Personne("Paul",new ArrayList<String>());
		ArrayList<String> nickName2 = new ArrayList<String>();
		nickName2.add("nickName1");
		nickName2.add("nickName2");
		
		Personne newPer2 = new Personne("Julien",nickName2);
		listPer.add(newPer1);
		listPer.add(newPer2);
	}
	
	public List<String> listNameByAlph() throws NameNotExist{
		Collections.sort(listPer);
		LinkedList<String> list = new LinkedList<String>(); 
		for (Personne per : listPer) {
			list.add(per.getName());
		}
		return app.application(list);
	}
	
	public List<String> listNickNameByAlph() {
		LinkedList<String> list = new LinkedList<String>();
		
		for (Personne p : listPer) {
			list.addAll(p.getListNickName());
		}
		Collections.sort(list);
		
		return app.application(list);
		
	}
	
	public LinkedList<String> test(String name) throws NameNotExist{
		if(!nameAlreadyExist(name)) throw new NameNotExist();
		Personne Per = new Personne(name);
		int rang = listPer.indexOf(Per);
		LinkedList<String> list = new LinkedList<String>(listPer.get(rang).getListNickName());
		
		return app.application(list);
	}
	public LinkedList<String> listNickNameByName(String name) throws NameNotExist{
		if(!nameAlreadyExist(name)) throw new NameNotExist();
		Personne Per = new Personne(name);
		int rang = listPer.indexOf(Per);
		LinkedList<String> list = new LinkedList<String>(listPer.get(rang).getListNickName());
		
		return app.application(list);
	}
	
	
	public List<String> addNickName(String name, String nickName) throws NameNotExist, NickNameAlreadyExist {
		
		if(!nameAlreadyExist(name)) throw new NameNotExist();
		if(nickNameAlreadyExist(nickName)) throw new NickNameAlreadyExist();
		
		Personne per = new Personne(name);
		int rang = listPer.indexOf(per);
		listPer.get(rang).getListNickName().add(nickName);
		return app.appValid();
		
	}
	public List<String>delNickName(String nickName) throws NickNameNotExist {
		if(!nickNameAlreadyExist(nickName)) throw new NickNameNotExist();
		for (Personne p : listPer) {
			if(p.getListNickName().contains(nickName)) {
				int rang = p.getListNickName().indexOf(nickName);
				p.getListNickName().remove(rang);
				break;
				
			}
		}
		return app.appValid();
	}
	
	public  List<String> updateNickName(String name, String oldNickName, String newNickName) throws IOException, NameNotExist, NickNameNotExist {
		if(!nameAlreadyExist(name)) throw new NameNotExist();
		if(!nickNameAlreadyExist(oldNickName)) throw new NickNameNotExist();
		Personne per = new Personne(name);
		int rangName = listPer.indexOf(per);
		int rangNickName = listPer.get(rangName).getListNickName().indexOf(oldNickName);
		listPer.get(rangName).getListNickName().set(rangNickName, newNickName);
		
		return app.appValid();
	}
	public List<String> whatPerson(String nickName) throws NickNameNotExist{
		if(!nickNameAlreadyExist(nickName)) throw new NickNameNotExist();
		
		for (Personne p : listPer) {
			if(p.getListNickName().contains(nickName)) {
				LinkedList<String> list = new LinkedList<String>();
				list.add(p.getName());
				return app.application(list);
			}
		}
		return app.appError("Erreur");
	}
	public List<String> addName(String name) throws NewNameAlreadyExist {
		
		if(nameAlreadyExist(name)) throw new NewNameAlreadyExist();
		
		Personne newPer = new Personne(name);
		listPer.add(newPer);
		return app.appValid();
		
	}
	public List<String>delName(String name) throws NameNotExist {
		if(!nameAlreadyExist(name)) throw new NameNotExist();
		Personne per = new Personne(name);
		int rang = listPer.indexOf(per);
		listPer.remove(rang);
		return app.appValid();
	}
	public  List<String> updateName(String oldName, String newName) throws OldNameAlreadyExist, NewNameAlreadyExist {
		
		if(nameAlreadyExist(oldName)) {
			if(!nameAlreadyExist(newName)) {
				Personne oldPer = new Personne(oldName);
				int rang = listPer.indexOf(oldPer);
				listPer.get(rang).setName(newName);
				
				return app.appValid();
			} else {
				throw new OldNameAlreadyExist();
			}
		} else {
			throw new NewNameAlreadyExist();
		}
			
		
	}
	
	public boolean nameAlreadyExist(String name) {
		Personne Per = new Personne(name);
		return listPer.contains(Per);
		
	}
	
	public boolean nickNameAlreadyExist(String nickName) {
		for (Personne p : listPer) {
			if(p.getListNickName().contains(nickName)) return true;
		}
		return false;
	}
	
	
	
}
