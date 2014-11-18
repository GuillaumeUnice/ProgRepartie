package exception;

public class NameNotExist extends ApplicationException{
	public String msg() {
		return "Le nom rechercher n'a pu être trouvé";
	}
}
