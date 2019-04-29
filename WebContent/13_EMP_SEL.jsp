<%@page import="com.patagonia.model.EmpVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.patagonia.dao.EmpDao"%>
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
		location.href = "13_EMP_INS.jsp";
	}
</script>
<body>
	메인화면
	<table border="1">
		<tr>
			<td>사번</td>
			<td>이름</td>
			<td>휴대전화</td>
			<td>이메일</td>
			<td>InsertDate</td>
			<td>InsertID</td>
			<td>UpdateDate</td>
			<td>UpdateID</td>
		</tr>
	<%
		EmpDao dao = new EmpDao();
		ArrayList<EmpVO> list = dao.selEmp();
		
		for(int i=0; i<list.size(); i++){
			String sawon_id = list.get(i).getSawon_id();
			String sawon_name = list.get(i).getSawon_name();
			String mobile = list.get(i).getMobile();
			String email = list.get(i).getEmail();
			String ins_date = list.get(i).getIns_date();
			String ins_id = list.get(i).getIns_id();
			String upd_date = list.get(i).getUpd_date();
			String upd_id = list.get(i).getUpd_id();
	%>
		<tr>
			<td>
				<!-- 사번을 클릭하면 디테일화면으로 넘어감 -->
				<!-- ?sawon_id=<%=sawon_id %>로 사원id를 파라미터로 넘겨줌 -->
				<a href="13_EMP_DETAIL.jsp?sawon_id=<%=sawon_id %>"><%=sawon_id %></a>
			</td>
			<td><%=sawon_name %></td>
			<td><%=mobile %></td>
			<td><%=email %></td>
			<td><%=ins_date %></td>
			<td><%=ins_id %></td>
			<td><%=upd_date %></td>
			<td><%=upd_id %></td>
		</tr>
	<%
		}
	%>
		<tr>
			<td colspan="8"><input type="button" onclick="fn_insert()" value="사원등록"/></td>
		</tr>
	</table>
</body>
</html>