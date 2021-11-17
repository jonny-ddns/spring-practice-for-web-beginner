package spring;

import java.util.Collection;

public class MemberListPrinter {
	private MemberDao memberDao;
	private MemberPrinter memberPrinter;
	
	//생성자로 파라미터 주입하기
	public MemberListPrinter(MemberDao memberDao, MemberPrinter memberPrinter) {
		this.memberDao = memberDao;
		this.memberPrinter = memberPrinter;
	}
	
	//setter 로 파라미터 설정하기
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void setMemberPrinter(MemberPrinter memberPrinter) {
		this.memberPrinter = memberPrinter;
	}	
	
	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		for(Member member : members) {
			memberPrinter.print(member);
		}		
	}
}
