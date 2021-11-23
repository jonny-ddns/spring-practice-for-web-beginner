package exception;

public class MemberNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1581462338396373665L;

	public MemberNotFoundException() {
		this("회원을 찾을 수 없습니다");
	}

	public MemberNotFoundException(String message) {
		super(message);	
	}
}
