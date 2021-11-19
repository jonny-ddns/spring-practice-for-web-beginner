package main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import spring.Client2;

public class Main3 {
	public static void main(String[] args) {

//		GenericXmlApplicationContext ctx;
		AbstractApplicationContext ctx;
		ctx = new GenericXmlApplicationContext("classpath:springConfig2.xml");
		
		Client2 test01 = ctx.getBean("client2", Client2.class);
		Client2 test02 = ctx.getBean("client2", Client2.class);
		//객체 동등성 확인
		System.out.println(test01.equals(test02));
		System.out.println(test01.toString());
		System.out.println(test02.toString());
		ctx.close();
	}
}
