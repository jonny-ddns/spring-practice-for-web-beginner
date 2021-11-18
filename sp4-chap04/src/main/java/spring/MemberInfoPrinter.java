package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {
	
	//자동주입. 필드
	@Autowired
	private MemberDao memberDao;
	private MemberPrinter memberPrinter;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	//자동주입. setter
	@Autowired
	public void setMemberPrinter(MemberPrinter memberPrinter) {
		this.memberPrinter = memberPrinter;
	}	
	
	public void printMemberInfo(String email) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			System.out.println("해당 이메일로 조회되는 회원 없음");
			return;
		}
		memberPrinter.print(member);
		System.out.println();		
	}
}
