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
	int cnt = dao.updEmp(paramVO);
%>

<!doctype html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>patagonia</title>
</head>
<script type="text/javascript">
	var cnt = <%=cnt %>
	
	//location.href와 history.go(-1)의 차이는 서버를 실행하는것과 현재페이지에서 뒤로가기 차이
	if(cnt == 1){
		location.href = "13_EMP_SEL.jsp";
	}else{
		history.go(-1); //전페이지로 넘어가는 구문 => history.back()과 같음
	}
</script>
<body>
	수정실행화면
</body>
</html>