package spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Client implements InitializingBean, DisposableBean {

	private String host;	
	
	public String getHost() {
		return host;
	}

	public void setHost(String host) {		
		this.host = host;
		System.out.printf("설정된 host = [%s]\n", getHost());
	}

	public void send() {
		System.out.printf("Client.send to [%s]\n", getHost());
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(this + " afterPropertiesSet()");		
	}	

	@Override
	public void destroy() throws Exception {
		System.out.println(this + " destroy()");
	}
}
