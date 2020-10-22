package org.cloud.mvn.spring.ioc;

public class HelloWorld {
	private String message;
	private String message2;

	public void setMessage(String message) {
		this.message = message;
	}
	public void setMessage2(String message2) {
		this.message2 = message2;
	}
	public void getMessage() {
		System.out.println("Your Message : " + message);
	}
	public void getMessage2() {
		System.out.println("Your Message2 : " + message2);
	}
	
	public void init() {
		System.out.println("Bean is going through init.");
	}
	public void destroy() {
		System.out.println("Bean will destroy now.");
	}
}
