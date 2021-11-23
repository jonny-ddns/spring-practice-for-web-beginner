package service;

import org.springframework.transaction.annotation.Transactional;

import dao.MemberDao;
import exception.MemberNotFoundException;
import vo.Member;

//비밀번호 변경 서비스
public class ChangePasswordService {
	private MemberDao memberDao;
	
	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	//트랜잭션
	//트랜잭션 등록시 쿼리가 묶여서 커밋됨, 실패시 롤백
	@Transactional
	public void changePassword(String email, String oldpw, String newpw) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			throw new MemberNotFoundException();
		}
		member.changePassword(oldpw, newpw);
		memberDao.update(member);
	}
}
