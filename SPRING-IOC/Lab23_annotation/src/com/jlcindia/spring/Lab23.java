package com.jlcindia.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Lab23 {

	
	public static void main(String args[]) {
ApplicationContext ctx=new AnnotationConfigApplicationContext(JlcConfig.class);

System.out.println("spring container is ready");
System.out.println("------------------------");

Hello h=(Hello)ctx.getBean("hello");
h.show();
	
}
}