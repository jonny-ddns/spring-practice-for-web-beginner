package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;

@Configuration
public class JavaConfig {
	
	/*
	 * 메서드가 리턴한 객체를 빈 객체로 사용하도록 지정
	 * xml 설정시 스프링 컨테이너가 빈 객체를 생성한다
	 * 자바 설정시 자바 코드(new)로 직접 객체를 생성한다
	 * 대신 @Bean 애노테이션을 붙여 스프링에 알려준다
	 */
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	/*
	 * 의존객체 주입시 메서드를 찾아 직접 주입한다
	 */
	@Bean
	public MemberRegisterService memberRegisterService() {
		return new MemberRegisterService(memberDao());
	}
	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberInfoPrinter memberInfoPrinter() {
		MemberInfoPrinter memberInfoPrinter = new MemberInfoPrinter();
		memberInfoPrinter.setMemberDao(memberDao());
		memberInfoPrinter.setMemberPrinter(memberPrinter());
		return memberInfoPrinter;
	}
}
