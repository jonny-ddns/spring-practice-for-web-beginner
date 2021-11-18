package spring;

public class AlreadyExistingMemberException extends RuntimeException{
	
	public AlreadyExistingMemberException() {
		this("이미 존재하는 아이디입니다");
	}

	public AlreadyExistingMemberException(String message) {
		super(message);	
	}
}
