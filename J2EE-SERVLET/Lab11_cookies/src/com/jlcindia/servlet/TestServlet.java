package com.jlcindia.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;

import javax.servlet.http.*;
import java.util.*;

public class TestServlet extends HttpServlet{

	
	protected void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		
		HttpSession sess=req.getSession();
		PrintWriter out=res.getWriter();
		
		Cookie cks[]=req.getCookies();
		out.println("<h1>"+cks);
		
	boolean	jsidflag=false;
	boolean jlcflag=false;
	
	
	if(cks==null || cks.length==0) {
		out.println("<h1>NO COOKIES</h1>");
		
	}else {
		
	for(Cookie ck:cks) {
		String cn=ck.getName();
		String cv=ck.getValue();
		
		out.println("<h1>"+cn+""+cv+"</h1>");
	
	if	(cn.equals("JSESSIONID")){
			jsidflag=true;
			
		}
	if(cn.equals("JLC")) {
		jlcflag=true;
		ck.setMaxAge(0);
		res.addCookie(ck);
		
	}
		
	}	
		
	}
	
	
	if(jsidflag) 
		
		
		out.println("JSESSIONID Cookie is found");
		else
	out.println("JSESSIONID cookie is not found");
	
	if(jlcflag)
		out.println("<h1>jlc cookie is found");
	else
		out.println("<h1>jlc cookie is not found");
	
	
	
	
	Cookie c1=new Cookie("JLC","WELCOME TO JLC");
	res.addCookie(c1);
	Cookie c2=new Cookie("EM","sri@jlc");
		res.addCookie(c2);
		
		Cookie c3=new Cookie("PH","9999");
		res.addCookie(c3);
	}
}
