package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import aopTest.Calculator;
import aopTest.ImpeCalculator;
import aopTest.RecCalculator;
import aspect.ExeTimeAspect2;

//@Configuration 를 사용한 자바 설정 방식
@Configuration
@EnableAspectJAutoProxy
public class JavaConfig {
	@Bean
	public ExeTimeAspect2 exeTimeAspect() {
		return new ExeTimeAspect2();
	}
	
	@Bean
	public Calculator getCalculator() {
//		return new RecCalculator();
		return new ImpeCalculator();
	}
}
