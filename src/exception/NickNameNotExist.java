package exception;

public class NickNameNotExist extends ApplicationException{
	public String msg() {
		return "Le surnom rechercher n'a pu être trouvé";
	}
}
