package chap02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		Greeter greeter = container.getBean("greeter", Greeter.class);
		String msg = greeter.greet("스프링");
		System.out.println(msg);
		container.close();				
	}
}
