package com.netprise;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddToCartServlet extends HttpServlet {

	
	
	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		HttpSession session=request.getSession(false);
		
		
		if(session==null) {
			
			request.setAttribute("MSG","Session is destroyed");
		}else {
			
			String productname=request.getParameter("pname");
			System.out.println(productname);
			//adding the client selected product to sesion
			
			session.setAttribute(productname, productname);
			
			
			request.setAttribute("ADDED",productname+" "+":is added to the cart successfully");
			
			
			
			
		}
		
		
		RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
		
	}
	
	
}
