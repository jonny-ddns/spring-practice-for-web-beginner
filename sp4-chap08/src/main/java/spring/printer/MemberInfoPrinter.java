package spring.printer;

import spring.dao.MemberDao;
import spring.vo.Member;

public class MemberInfoPrinter {
	private MemberDao memberDao;
	private MemberPrinter memberPrinter;
	
	//setter 로 파라미터 설정하기
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

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
