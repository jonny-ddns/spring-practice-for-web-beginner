package spring;

import java.util.Date;

public class Member {

	private Long id;
	private String email;
	private String password;
	private String name;
	private Date registerDate;
	
	public Member(String email, String password, String name, Date registerDate) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDate = registerDate;
	}

	public Long getId() {
		return id;
	}

	public Member setId(Long id) {
		this.id = id;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Member setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public Member setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getName() {
		return name;
	}

	public Member setName(String name) {
		this.name = name;
		return this;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public Member setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
		return this;
	}
	
	public void changePassword(String oldpw, String newpw) {
		if(!oldpw.equals(newpw)) {
			this.password = newpw;
		}
	}
}
