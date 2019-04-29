<%@page import="com.patagonia.dao.CompanyDao"%>
<%@page import="com.patagonia.model.CompanyVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	String co_id = request.getParameter("co_id");
	String co_name = request.getParameter("co_name");
	String manager_id = request.getParameter("manager_id");
	String stock_yn = request.getParameter("stock_yn");
	String co_tel = request.getParameter("co_tel");
	String co_ceo_name = request.getParameter("co_ceo_name");

	CompanyVO paramVO = new CompanyVO();
	paramVO.setCo_id(co_id);
	paramVO.setCo_name(co_name);
	paramVO.setManager_id(manager_id);
	paramVO.setStock_yn(stock_yn);
	paramVO.setCo_tel(co_tel);
	paramVO.setCo_ceo_name(co_ceo_name);
	
	CompanyDao dao = new CompanyDao();
	int cnt = dao.insert(paramVO);
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
		location.href = "14_COMPANY_SEL.jsp";
	}else{
		history.go(-1);
	}
</script>
<body>
	등록실행화면
</body>
</html>