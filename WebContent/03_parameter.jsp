<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>patagonia</title>
</head>
<body>
	<%
		String myname = request.getParameter("name"); //request에서 파라미터를 받아오는 방법(url창에 ?name=값 을 입력해야함)
// 		out.println("myname: " + myname);
	%>
	
	<%="myname: " + myname %>>
</body>
</html>