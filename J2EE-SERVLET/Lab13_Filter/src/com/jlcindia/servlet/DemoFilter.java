package com.jlcindia.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;




public class DemoFilter implements Filter {


	public void init(FilterConfig fc) throws ServletException {
	
		System.out.println("demo-filter-init");
		String ci=fc.getInitParameter("city");
		System.out.println(ci);
		
	}
   
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("demo-filter-do filter before");
		
		
		
		String nm=request.getParameter("name");
		String em=request.getParameter("email");
		String ip=request.getRemoteAddr();
		
		System.out.println(nm);
		System.out.println(em);
		System.out.println(ip);
		
		
		
		chain.doFilter(request, response);
		
		
		System.out.println("demo-filter-do filter after");
		
		Object obj=request.getAttribute("MSG");
		System.out.println(obj);
		
		String msg=obj.toString();
		System.out.println(msg);
		
		
	}

	public void destroy() {
		
		System.out.println("Demo-filter-destroy");
	}

}