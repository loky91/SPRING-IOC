<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp">
<jsp:param value="java learning center" name="cname"/>
</jsp:include>

<form action="test.jsp">

<h1>SELECT THE BRANCH</h1>

<select name="branch">
<option value="MKR">Mathiker</option>
<option value="BTM">BTM LAYOUT</option>
</select>

<input type="submit" value="SUBMIT"/>

<jsp:include page="footer.jsp">
<jsp:param value="java learning center" name="cname"/>
</jsp:include>

</form>


</body>
</html>