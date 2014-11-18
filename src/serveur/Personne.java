package serveur;

import java.util.ArrayList;

public class Personne {
	
	private String name;
	private ArrayList<String> listNickName;
	
	public Personne(String name, ArrayList<String> listNickName) {
		this.name = name;
		this.listNickName = listNickName;
	}
	@Override
	public boolean equals(Object obj) {
		Personne that = (Personne) obj;
		return this.name.equals(that.name);
	}
	public boolean equals(String str) {
		System.out.println("plop");
		return this.name.equals(str);
	}
	public String getName() {
		return name;
	}

	public ArrayList<String> getListNickName() {
		return listNickName;
	}
	
	
	
}
