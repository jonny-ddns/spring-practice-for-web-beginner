package main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import spring.exception.IdPasswordNotMatchingException;
import spring.exception.MemberNotFoundException;
import spring.service.ChangePasswordService;

public class MainForCPS {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		ChangePasswordService cps = ctx.getBean("changePasswordService", ChangePasswordService.class);
		
		try {
			String email = "test@test.com";
			String oldpw = "1234";
			String newpw = "5678";
			cps.changePw(email, oldpw, newpw);
			System.out.println("암호변경 완료");
		} catch (MemberNotFoundException mnfe) {
			System.out.println("일치하는 회원정보 없음");
		} catch (IdPasswordNotMatchingException idpwe) {
			System.out.println("비밀번호 불일치");
		}
		ctx.close();
	}
}
