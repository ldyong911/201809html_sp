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
	function fn_delete(){
		//confirm창으로 확인, 취소 중 선택이 가능함(반환값은 boolean형)
		var flag = confirm("삭제된 데이터는 복구할 수 없습니다. 진행하시겠습니까?");
		
		//취소누를경우
		if(!flag){
			return;
		}
		
		//form태그에 id값을 지정할경우 document.getElementById(id값);로 form태그에 접근하지만,
		//form태그에 name을 지정할경우 document.name으로도 form태그에 접근가능
		document.frm.submit(); //submit버튼 실행
	}
	
	function fn_update(){
		document.frm.action = "13_EMP_UPD.jsp"; //form태그에 action값을 바꿔줄 수 있음
		document.frm.submit();
	}
</script>
<body>
	상세화면
	<%
		String sawon_id = request.getParameter("sawon_id");
	
		EmpVO paramVO = new EmpVO();
		paramVO.setSawon_id(sawon_id);
		
		EmpDao dao = new EmpDao();
		EmpVO resultVO = dao.detailEmp(paramVO);
	%>
	
<form id="frm" name="frm" method="POST" action="13_EMP_DEL_ACT.jsp">
	<!-- 사용자가 입력하거나 선택하는 정보는 아니지만 폼 전송이 같이 전송해줘야 하는 정보를 담기 위해서 히든 필드(Hidden Field)를 사용 -->
	<!-- 즉, 화면상에 폼에는 보이지 않지만, 폼을 서버로 전송할 때 함께 전송되는 요소 -->
	<!-- input type이 라디오,체크박스, text, hidden 등 정도만 파라미터가 넘어감(button은 파라미터를 넘기지않음) -->
	<!-- name은 page 안에서 중복되어 사용이 가능하며 action에 해당하는 페이지로 전달하는 파라미터로 사용 -->
	<!-- value는 고유 값으로서, 다음 페이지로 전달되는 실제 값입니다. -->
	<!-- name=value 형태로 전달됨 -->
	<!-- form태그는 submit버튼을 클릭해야 action에 해당하는 페이지로 넘어감 -->
	<input type="hidden" name="sawon_id" value="<%=resultVO.getSawon_id() %>" />
	<table border="1">
		<tr>
			<td>사번</td>
			<td><%=resultVO.getSawon_id() %></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><%=resultVO.getSawon_name() %></td>
		</tr>
		<tr>
			<td>휴대전화</td>
			<td><%=resultVO.getMobile() %></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><%=resultVO.getEmail() %></td>
		</tr>
		<tr>
			<td>InsertDate</td>
			<td><%=resultVO.getIns_date() %></td>
		</tr>
		<tr>
			<td>InsertID</td>
			<td><%=resultVO.getIns_id() %></td>
		</tr>
		<tr>
			<td>UpdateDate</td>
			<td><%=resultVO.getUpd_date() %></td>
		</tr>
		<tr>
			<td>UpdateID</td>
			<td><%=resultVO.getUpd_id() %></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" onclick="fn_delete()" value="삭제"/>
				<input type="button" onclick="fn_update()" value="수정"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>