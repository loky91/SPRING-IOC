<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@page import="java.util.*" %>
<html>
<body>
<center>
<h1>JLC BOOK STORE</h1>
<h2>BOOK SEARCH</h2>
</center><br/>
<font color="green" size="7">${ADDED}</font>

<%
Object obj=request.getAttribute("MSG");
if(obj!=null){
%>
<center>
<font color="red">
<%=obj%>
</font>

<a href="index.jsp">GO TO SEARCH PAGE</a>
</center>


<%
}else{

obj=session.getAttribute("BOOKS");
ArrayList<String> blist=(ArrayList<String>)obj;

for(String bnm:blist){
	
%>


<form action="addtocart.jlc" method="post">
<table border="2">
<tr>
<td>
<input type="hidden" name="bname" value="<%=bnm%>">
<font>
<%=bnm %>
</td>
<td>
<input type="submit" value="ADD TO CART"/>
</font>
</td>
</tr>
</table>
</form>
<%} %>
<form action="showcart.jlc">
<input type="submit" value="SHOW CART"/>
</form>


<% } %>
</body>
</html>