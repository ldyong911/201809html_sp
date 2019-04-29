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
	function fn_save(){
		document.frm.submit();
	}
</script>
<body>
	수정화면
	<%
		String sawon_id = request.getParameter("sawon_id");
	
		EmpVO paramVO = new EmpVO();
		paramVO.setSawon_id(sawon_id);
		
		EmpDao dao = new EmpDao();
		EmpVO resultVO = dao.detailEmp(paramVO);
	%>
	
<form id="frm" name="frm" method="POST" action="13_EMP_UPD_ACT.jsp">
	<table border="1">
		<tr>
			<td>사번</td>
			<!-- readonly는 읽기전용속성이며 파라미터를 넘기지만 diabled는 수정불가속성이며 파라미터를 넘기지않음 -->
			<td><input type="text" name="sawon_id" value="<%=resultVO.getSawon_id() %>" readonly/></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="sawon_name" value="<%=resultVO.getSawon_name() %>"/></td>
		</tr>
		<tr>
			<td>휴대전화</td>
			<td><input type="text" name="mobile" value="<%=resultVO.getMobile() %>"/></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email" value="<%=resultVO.getEmail() %>"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" onclick="fn_save()" value="저장"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>