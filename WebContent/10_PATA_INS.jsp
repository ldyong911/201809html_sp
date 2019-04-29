<%@page import="com.patagonia.model.PataVO"%>
<%@page import="com.patagonia.dao.PataDao"%>
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
		String col1 = request.getParameter("col1");
		String col2 = request.getParameter("col2");
		String col3 = request.getParameter("col3");
		
		PataDao dao = new PataDao();
		
		PataVO vo = new PataVO();
		vo.setCol1(col1);
		vo.setCol2(col2);
		vo.setCol3(col3);
		
		int cnt = dao.insPata(vo);
	%>
	
	<%=cnt %>개의 행이 추가되었습니다.
</body>
</html>