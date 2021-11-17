package assembler;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

//객체를 생성하고 의존 객체를 주입하는 기능
//객체가 필요한 곳에 객체 제공
public class Assembler {
	private MemberDao memberDao;	
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	//의존객체를 수정할 수 있도록 설정
	public Assembler() {
		this.memberDao = new MemberDao();
		this.regSvc = new MemberRegisterService(memberDao);
		this.pwdSvc = new ChangePasswordService(memberDao);
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getMemberRegisterService() {
		return regSvc;
	}

	public ChangePasswordService getChangePwService() {
		return pwdSvc;
	}
}
