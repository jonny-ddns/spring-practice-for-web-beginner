package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import aopTest.Calculator;
import config.JavaConfig;

public class MainJavaAspect {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		Calculator calculator = ctx.getBean("getCalculator", Calculator.class);
		int num = 5;
		long result = calculator.factororial(num);
		System.out.println("계산결과 = " + result);		
		ctx.close();
	}
}
