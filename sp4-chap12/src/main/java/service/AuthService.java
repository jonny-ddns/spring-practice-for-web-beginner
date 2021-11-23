package service;

import dao.MemberDao;
import exception.MemberNotFoundException;
import vo.AuthInfo;
import vo.Member;

//이메일과 비밀번호가 일치시 AuthInfo 객체를 생성하는 역할
public class AuthService {
	
	private MemberDao memberDao;

	public AuthService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public AuthInfo authenticate(String email, String password) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			throw new MemberNotFoundException();
		}
		
		//불일치//
		if(!member.getPassword().equals(password)) {
			System.out.println(this + " 입력한 비밀번호 불일치");
			throw new MemberNotFoundException();
		}
		return new AuthInfo(member.getId(), member.getEmail(), member.getName());		
	}	
}
