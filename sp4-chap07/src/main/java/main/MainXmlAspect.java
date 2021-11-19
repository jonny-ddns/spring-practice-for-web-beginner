package main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import aopTest.Calculator;

public class MainXmlAspect {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:aopAspect.xml");
		Calculator cal01 = ctx.getBean("impeCalculator", Calculator.class);
		Calculator cal02 = ctx.getBean("recCalculator", Calculator.class);
		ctx.close();

		int num = 20;
		long result1 = cal01.factororial(num);
		long result2 = cal02.factororial(num);
		System.out.println(result1 == result2);
		System.out.println("계산결과 = " + result1);
	}
}
