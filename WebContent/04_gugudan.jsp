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
		String mydan = request.getParameter("dan");
		int int_dan = Integer.parseInt(mydan); //String을 int로 형변환
// 		for(int i=1; i<=9; i++){
// 			out.print(int_dan + "*" + i + "=" + int_dan*i+"<br>");
// 		}
	%>
	
	<%for(int i=1; i<=9; i++){ %>
	<%=int_dan + "*" + i + "=" + int_dan*i+"<br>" %>
	<%} %>
	
</body>
</html>