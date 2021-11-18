package spring;

public class RegisterRequest {
	
	private String email;
	private String password;
	private String confirmPw;
	private String name;

	public String getEmail() {
		return email;
	}
	public RegisterRequest setEmail(String email) {
		this.email = email;
		return this;		
	}
	public String getPassword() {
		return password;
	}
	public RegisterRequest setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getConfirmPw() {
		return confirmPw;
	}
	public RegisterRequest setConfirmPw(String confirmPw) {
		this.confirmPw = confirmPw;
		return this;
	}
	public String getName() {
		return name;
	}
	public RegisterRequest setName(String name) {
		this.name = name;
		return this;
	}
	
	public boolean isPwEqualToConfirmPw() {
		return password.equals(confirmPw);
	}
}
