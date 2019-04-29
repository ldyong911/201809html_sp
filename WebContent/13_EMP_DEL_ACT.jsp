<%@page import="com.patagonia.model.EmpVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.patagonia.dao.EmpDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	String sawon_id = request.getParameter("sawon_id");

	EmpVO paramVO = new EmpVO();
	paramVO.setSawon_id(sawon_id);
	
	EmpDao dao = new EmpDao();
	int cnt = dao.delEmp(paramVO);
%>

<!doctype html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>patagonia</title>
</head>
<script type="text/javascript">
	var cnt = <%=cnt %>
	
	if(cnt == 1){
		location.href = "13_EMP_SEL.jsp";
	}else{
		history.go(-1);
	}
</script>
<body>
	삭제실행화면
</body>
</html>