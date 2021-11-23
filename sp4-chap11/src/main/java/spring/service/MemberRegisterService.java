package spring.service;

import java.util.Date;
import spring.dao.MemberDao;
import spring.exception.AlreadyExistingMemberException;
import spring.vo.Member;
import spring.vo.RegisterRequest;

public class MemberRegisterService {
	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void regist(RegisterRequest req) {
		System.out.println("MemberRegisterService.regist");
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null) {
			throw new AlreadyExistingMemberException("dup email" + req.getEmail());
		}
		
		Member newMember = new Member(
				req.getEmail()
				, req.getPassword()
				, req.getName()
				, new Date()
		);
		
		memberDao.insert(newMember);
	}
}
