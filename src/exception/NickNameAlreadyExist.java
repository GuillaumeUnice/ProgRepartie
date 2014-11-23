package exception;

public class NickNameAlreadyExist extends ApplicationException {
	public String msg() {
		
		return "Le nouveau surnom est déjà affilier à une autre personne";
	}
}