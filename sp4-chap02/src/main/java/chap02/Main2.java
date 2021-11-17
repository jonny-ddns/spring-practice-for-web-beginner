package chap02;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main2 {
	public static void main(String[] args) {
		GenericApplicationContext container = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		Greeter g1 = container.getBean("greeter", Greeter.class);
		Greeter g2 = container.getBean("greeter", Greeter.class);
		System.out.println("객체 동등성 확인 = "+ (g1 == g2));
		container.close();		
	}
}
