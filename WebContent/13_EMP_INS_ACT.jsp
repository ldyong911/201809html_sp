<%@page import="com.patagonia.model.EmpVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.patagonia.dao.EmpDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	String sawon_id = request.getParameter("sawon_id");
	String sawon_name = request.getParameter("sawon_name");
	String mobile = request.getParameter("mobile");
	String email = request.getParameter("email");

	EmpVO paramVO = new EmpVO();
	paramVO.setSawon_id(sawon_id);
	paramVO.setSawon_name(sawon_name);
	paramVO.setMobile(mobile);
	paramVO.setEmail(email);
	
	EmpDao dao = new EmpDao();
	int cnt = dao.insEmp(paramVO);
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
	등록실행화면
</body>
</html>