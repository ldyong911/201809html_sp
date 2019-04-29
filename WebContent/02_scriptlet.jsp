<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>patagonia</title>
</head>
<!-- response가 html 형태로 응답해야하기때문에 ASP, PHP, JSP가 사용됨 -->
<body>
	<!-- <% %>은 스크립틀릿이라고 하며 안에 자바문법을 기술한다 -->
	<%
		System.out.print("콘솔창에 출력");
		out.print("html로 출력"); //html로 출력하는 방법
	%>
	
	<%="Good Morning" %> <!-- out.print와 같은 역할 -->
</body>
</html>