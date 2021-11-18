package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.MemberInfoPrinter;
import spring.MemberPrinter;

@Configuration
public class ConfigPart12 {
	
	
	@Autowired
	private ConfigPart11 configPart11;

	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberInfoPrinter memberInfoPrinter() {
		MemberInfoPrinter memberInfoPrinter = new MemberInfoPrinter();
		memberInfoPrinter.setMemberDao(configPart11.memberDao());
		memberInfoPrinter.setMemberPrinter(memberPrinter());
		return memberInfoPrinter;
	}
}
