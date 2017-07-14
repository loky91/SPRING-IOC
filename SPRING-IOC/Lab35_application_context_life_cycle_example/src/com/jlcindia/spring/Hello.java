package com.jlcindia.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.*;

import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.*;

public class Hello  implements InitializingBean,DisposableBean,BeanNameAware,BeanFactoryAware,ApplicationContextAware{

	
	int x;
	String str;
	String msg;
	String bname;
	
	
	
	@Autowired
	A aobj;
	B bobj;
	
	ApplicationContext ctx1;
	BeanFactory factory1;
	
	
	
	@Autowired
	ApplicationContext ctx2;
	
	@Autowired
	BeanFactory factory2;
	
	static {
		
		System.out.println("Hello-S.B");
	}
	
	
	
	
	public Hello(int x) {
		System.out.println("Hello-int-x");
		this.x=x;
		
	}
	
	
	
	
	public void setStr(String str) {
		System.out.println("Hello-setStr");
		this.str=str;
	}
	
	
	
	public void setBobj(B bobj) {
		System.out.println("Hello-setBobj");
		this.bobj=bobj;
	}
	
	
	
	
	@PostConstruct
	public void init1() {
		
		System.out.println("Hello-init1");
		msg="Welcome to jlc";
		if(str==null)
			str="Hai guyss";
		str="Hai Guyss";
	}
	
	
	
	
	@PostConstruct
	public void init2() {
		
		System.out.println("Hello-init2");
		msg="welcome to jlc";
		if(str==null)
			str="hai guyys";
	}
	
	
	
	
	@Override//InitializingBean
	public void afterPropertiesSet() throws Exception {
		System.out.println(" using-InitializingBean");
		msg="welcome to jlc";
		if(str==null)
			str="hai guyys";
	}
	
	
	
	public void myInit() {
		
		System.out.println("Hello-myInit()");
		msg="welcome to JLC";
		if(str==null)
		{
			str="hai -guyzz";
		}
	}
	@Override//BeanNameAware
	public void setBeanName(String bname) {
		System.out.println(" using-BeanNameAware");
		this.bname=bname;
		
	}
	@Override
	public void setBeanFactory(BeanFactory factory1) throws BeansException {

		System.out.println(" using-BeanFactoryAware");
		this.factory1=factory1;
		
	}
	@Override
	public void setApplicationContext(ApplicationContext ctx1) throws BeansException {
		System.out.println(" using-ApplicationContextAware");
		this.ctx1=ctx1;
	}
	
	
	
	@PreDestroy
	public void cleanup() {
	System.out.println("Hello-cleanup");
	
	}
	
	
	public void destroy() throws Exception{
		System.out.println("Hello-destroy");	
	}
	
	
	
	
	public void mycleanup() {
		
		System.out.println("Hello-mycleanup");
	}
	
	
	public void show() {
		
		System.out.println("Hello-show");
		System.out.println(x);
		System.out.println(str);
		System.out.println(msg);
		System.out.println(aobj);
		System.out.println(bobj);
		System.out.println("bean name is"+bname);
		System.out.println(factory1);
		System.out.println(ctx1);
		System.out.println(factory2);
		System.out.println(ctx2);
		System.out.println(ctx1==ctx2);
		System.out.println(factory1==factory2);
		
		
		
	}
	
	
}
