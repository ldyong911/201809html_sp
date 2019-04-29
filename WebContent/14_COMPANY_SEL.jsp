<%@page import="com.patagonia.model.CompanyVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.patagonia.dao.CompanyDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>patagonia</title>
</head>
<script type="text/javascript">
	function fn_insert(){
		location.href = "14_COMPANY_INS.jsp";
	}
</script>
<body>
	메인화면
	<table border="1">
		<tr>
			<td>협력사ID</td>
			<td>협력사명</td>
			<td>담당자ID</td>
			<td>주식회사여부</td>
			<td>회사연락처</td>
			<td>회사대표자</td>
			<td>담당자명</td>
		</tr>
	<%
		CompanyDao dao = new CompanyDao();
		ArrayList<CompanyVO> list = dao.selectList(null);
		
		for(int i=0; i<list.size(); i++){
			String co_id = list.get(i).getCo_id();
			String co_name = list.get(i).getCo_name();
			String manager_id = list.get(i).getManager_id();
			String stock_yn = list.get(i).getStock_yn();
			String co_tel = list.get(i).getCo_tel();
			String co_ceo_name = list.get(i).getCo_ceo_name();
			String manager_name = list.get(i).getManager_name();
	%>
		<tr>
			<td>
				<!-- 사번을 클릭하면 디테일화면으로 넘어감 -->
				<!-- ?co_id=<%=co_id %>로 사원id를 파라미터로 넘겨줌 -->
				<a href="14_COMPANY_DETAIL.jsp?co_id=<%=co_id %>"><%=co_id %></a>
			</td>
			<td><%=co_name %></td>
			<td><%=manager_id %></td>
			<td><%=stock_yn %></td>
			<td><%=co_tel %></td>
			<td><%=co_ceo_name %></td>
			<td><%=manager_name %></td>
		</tr>
	<%
		}
	%>
		<tr>
			<td colspan="8"><input type="button" onclick="fn_insert()" value="협력사등록"/></td>
		</tr>
	</table>
</body>
</html>