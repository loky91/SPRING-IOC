<!DOCTYPE html>
<html>



<body>

<%
Object obj=request.getAttribute("EMSG");
String msg="";
if(obj!=null){
	
	msg=obj.toString();
	
}
String un="";
String pw="";

Cookie cks[]=request.getCookies();
if(cks!=null){
	for(Cookie ck:cks){
		String cn=ck.getName();
		if(cn.equals("UNC"))
			un=ck.getValue();
		if(cn.equals("PWC"))
			pw=ck.getValue();
		
		
	}
	
	
}

%>


<font color="green"><%=msg%></font>


<form action="test.jlc">
<table border="2">

<tr>
<td align="center" colspan="2">
LOGIN FORM

</td>
</tr>

<tr><td>USERNAME</td><td> <input type="text" name="username" value="<%=un%>"/> </td></tr>
<tr><td>PASSWORD</td><td><input type="password" name="password" value="<%=pw%>"></td></tr>
<tr> <td colspan="2" align="center"> <input type="checkbox" name="rememberme">REMEMBER ME <input type="submit" value="login"> </td> </tr>


</table>

</form>

</body>
</html>