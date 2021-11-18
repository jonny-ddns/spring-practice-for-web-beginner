package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberPrinter;

@Configuration
public class ConfigPart02 {
	
	//MemberDao 타입의 빈을 ConfigPart1.class 파일에 정리
	//-> @Autowired 애노테이션을 이용해 주입할 객체로 가져온다
	@Autowired
	MemberDao MemberDao;

	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberInfoPrinter memberInfoPrinter(MemberDao memberDao, MemberPrinter memberPrinter) {
		MemberInfoPrinter memberInfoPrinter = new MemberInfoPrinter();
		//MemberDao -> 필드값을 @Autowired 지정해 자동주입되도록 설정
		memberInfoPrinter.setMemberDao(memberDao);
		memberInfoPrinter.setMemberPrinter(memberPrinter);
		return memberInfoPrinter;
	}
}
