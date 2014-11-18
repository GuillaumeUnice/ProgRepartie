package exception;

public class oldNameAreadyExist extends ApplicationException{
	public String msg() {
		return "Le nouveau nom existe deja";
	}
}
