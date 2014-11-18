package serveur;

import java.util.ArrayList;

public class Personne {
	
	private String name;
	private ArrayList<String> listNickName;
	
	public Personne(String name, ArrayList<String> listNickName) {
		this.name = name;
		this.listNickName = listNickName;
	}
	public Personne(String name) {
		this.name = name;
		this.listNickName = new ArrayList<String>();
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public boolean equals(Object obj) {
		Personne that = (Personne) obj;
		return this.name.equals(that.name);
	}
	
	public String getName() {
		return name;
	}

	public ArrayList<String> getListNickName() {
		return listNickName;
	}
	
	
	
}
