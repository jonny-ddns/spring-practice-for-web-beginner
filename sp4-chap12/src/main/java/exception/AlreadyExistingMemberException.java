package exception;

public class AlreadyExistingMemberException extends RuntimeException{
	private static final long serialVersionUID = 8764535041191326039L;

	public AlreadyExistingMemberException() {
		this("이미 존재하는 아이디입니다");
	}

	public AlreadyExistingMemberException(String message) {
		super(message);	
	}
}
