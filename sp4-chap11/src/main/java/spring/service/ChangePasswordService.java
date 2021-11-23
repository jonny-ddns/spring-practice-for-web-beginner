package spring.service;

import org.springframework.transaction.annotation.Transactional;

import spring.dao.MemberDao;
import spring.exception.MemberNotFoundException;
import spring.vo.Member;

/*
 * 트랜잭션 범위를 지정해 쿼리가 묶여서 진행되게 함
 */
public class ChangePasswordService {
	private MemberDao memberDao;
	
	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	//필요한 메서드에 트랜잭션 처리
	@Transactional
	public void changePw(String email, String oldpw, String newpw) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			throw new MemberNotFoundException();
		}
		member.changePassword(oldpw, newpw);
		memberDao.update(member);
	}
}
