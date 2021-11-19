package main;

import org.springframework.context.support.GenericXmlApplicationContext;
import spring.Client2;

public class Main2 {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:springConfig2.xml");
		Client2 client2 = ctx.getBean("client2", Client2.class);
		client2.send();
		ctx.close();
	}
}
