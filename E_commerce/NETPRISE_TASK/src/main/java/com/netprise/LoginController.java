package com.netprise;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.netprise.*;
/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService=new UserService();
		
		
		String un=request.getParameter("username");
		String pw=request.getParameter("password");
		String rem=request.getParameter("remember");
		System.out.println(rem);
		int x=userService.verifyUser(un, pw);
		
		HttpSession session=request.getSession();
		String result="";
		
		if(x==1) {
			request.setAttribute("UN",un);
			result="home.jsp";
			
			
			
			
			
			
		}else {
			
			String msg="INVALID Username or password";
			request.setAttribute("MSG",msg);
			result="login.jsp";
			
			 }
	
		RequestDispatcher rd=request.getRequestDispatcher(result);
		rd.forward(request, response);
		
		
	}

}