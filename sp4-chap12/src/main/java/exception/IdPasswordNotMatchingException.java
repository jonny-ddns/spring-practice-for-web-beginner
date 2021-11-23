package exception;

public class IdPasswordNotMatchingException extends RuntimeException {
	private static final long serialVersionUID = 482996047805570393L;

	public IdPasswordNotMatchingException() {
		this("id-pw 불일치합니다");
	}
	
	public IdPasswordNotMatchingException(String message) {
		super(message);		
	}
}
