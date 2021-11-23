package command;

//로그인 처리 객체
public class LoginCommand {
	private String email;
	private String password;
	private boolean rememberEmail;	//이메일 기억여부
	
	public String getEmail() {
		return email;
	}
	public LoginCommand setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public LoginCommand setPassword(String password) {
		this.password = password;
		return this;
	}
	public boolean isRememberEmail() {
		return rememberEmail;
	}
	public LoginCommand setRememberEmail(boolean rememberEmail) {
		this.rememberEmail = rememberEmail;
		return this;
	}	
}
