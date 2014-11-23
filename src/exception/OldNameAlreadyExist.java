package exception;

public class OldNameAlreadyExist extends ApplicationException{
	public String msg() {
		return "Le nouveau nom existe deja";
	}
}