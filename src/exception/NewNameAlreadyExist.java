package exception;

public class NewNameAlreadyExist extends ApplicationException {
	public String msg() {
		
		return "Le nouveau nom existe deja";
	}
}
