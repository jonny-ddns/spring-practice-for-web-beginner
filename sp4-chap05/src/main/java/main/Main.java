package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigPart11;
import config.ConfigPart12;
import spring.MemberInfoPrinter;
import spring.MemberRegisterService;
import spring.RegisterRequest;

public class Main {
	public static void main(String[] args) {
		
		//스프링 컨테이너
		AnnotationConfigApplicationContext ctx;
		
		//자바 설정파일 지정해 읽어오기
//		ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
//		ctx = new AnnotationConfigApplicationContext(JavaConfig2.class);
//		ctx = new AnnotationConfigApplicationContext(JavaConfig3.class);
//		ctx = new AnnotationConfigApplicationContext(ConfigPart01.class, ConfigPart02.class);
		ctx = new AnnotationConfigApplicationContext(ConfigPart11.class, ConfigPart12.class);
		
		//빈으로 가져오기 -> 빈이름 지정시 메서드명과 동일하도록 설정
		MemberRegisterService memberRegisterService	= ctx.getBean("memberRegisterService", MemberRegisterService.class);
		MemberInfoPrinter memberInfoPrinter			= ctx.getBean("memberInfoPrinter", MemberInfoPrinter.class);
		
		RegisterRequest registerRequest = new RegisterRequest();
		
		String email = "test@email.com";
		String name = "홍길동";
		String passwd = "1234";
		registerRequest.setEmail(email)
			.setName(name)
			.setPassword(passwd)
			.setConfirmPw(passwd);
		memberRegisterService.regist(registerRequest);
		memberInfoPrinter.printMemberInfo(email);
		
		ctx.close();
	}
}
