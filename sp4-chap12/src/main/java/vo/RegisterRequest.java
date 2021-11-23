package vo;

//등록정보 vo
public class RegisterRequest {
	
	private String email;
	private String password;
	private String confirmPassword;
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public RegisterRequest setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
		return this;
	}
	public String getName() {
		return name;
	}
	public RegisterRequest setName(String name) {
		this.name = name;
		return this;
	}	
	
	//비밀번호-확인 일치여부
	public boolean isPwEqualToConfirmPw() {
		return password.equals(confirmPassword);
	}
}
