<%@page import="com.patagonia.model.EmpVO"%>
<%@page import="com.patagonia.dao.EmpDao"%>
<%@page import="com.patagonia.dao.CompanyDao"%>
<%@page import="com.patagonia.model.CompanyVO"%>
<%@page import="java.util.ArrayList"%>
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
		var co_name = document.getElementsByName("co_name")[0];
		if(co_name.value == ""){
			alert("협력사명은 기입하셔야 합니다.");
			co_name.focus(); //해당하는것에 포커스 주기
			return;
		}
		
		var manager_id = document.getElementsByName("manager_id")[0];
		if(manager_id.value == ""){
			alert("담당자ID는 선택하셔야 합니다.");
			manager_id.focus();
			return;
		}
		
		var co_tel = document.getElementsByName("co_tel")[0];
		if(co_tel.value == ""){
			alert("회사연락처는 기입하셔야 합니다.");
			co_tel.focus();
			return;
		}
		
		var co_ceo_name = document.getElementsByName("co_ceo_name")[0];
		if(co_ceo_name.value == ""){
			alert("회사대표자는 기입하셔야 합니다.");
			co_ceo_name.focus();
			return;
		}
		
		
		var regExp = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
		if (!regExp.test(co_tel.value)) {
			alert("잘못된 휴대폰 번호입니다. 숫자, - 를 포함한 숫자만 입력하세요.");
			co_tel.focus();
			return;
		}
		
		document.frm.submit();
	}
</script>
<body>
	수정화면
	<%
		String co_id = request.getParameter("co_id");
	
		CompanyVO paramVO = new CompanyVO();
		paramVO.setCo_id(co_id);
		
		CompanyDao dao = new CompanyDao();
		CompanyVO resultVO = dao.select(paramVO);
	%>
	
<form id="frm" name="frm" method="POST" action="14_COMPANY_UPD_ACT.jsp">
	<table border="1">
		<tr>
			<td>협력사ID</td>
			<!-- readonly는 읽기전용속성이며 파라미터를 넘기지만 diabled는 수정불가속성이며 파라미터를 넘기지않음 -->
			<td><input type="text" name="co_id" value="<%=resultVO.getCo_id() %>" readonly/></td>
		</tr>
		<tr>
			<td>협력사명</td>
			<td><input type="text" name="co_name" value="<%=resultVO.getCo_name() %>"/></td>
		</tr>
		<tr>
			<td>담당자ID</td>
			<td>
				<select name="manager_id">
					<option value="">-----</option>
					<%	EmpDao daoCombo = new EmpDao();
						ArrayList<EmpVO> listCombo = daoCombo.selEmp();
						
						for(int i=0; i<listCombo.size(); i++){
					%>
					<option value="<%=listCombo.get(i).getSawon_id() %>"
						<%if(listCombo.get(i).getSawon_id().equals(resultVO.getManager_id())){ %>
							selected
						<%} %>
					>
						<%=listCombo.get(i).getSawon_name() %>
					</option>
					<%} %>
				</select>
			</td>
		</tr>
		<tr>
			<td>주식회사여부</td>
			<td>
				<input type="radio" name="stock_yn" value="Y"
				<%if(resultVO.getStock_yn().toUpperCase().equals("Y")){ %>
					checked
				<%} %>
				/>주식회사
				<input type="radio" name="stock_yn" value="N"
				<%if(!resultVO.getStock_yn().toUpperCase().equals("Y")){ %>
					checked
				<%} %>
				/>기타
			</td>
		</tr>
		<tr>
			<td>회사연락처</td>
			<td><input type="text" name="co_tel" value="<%=resultVO.getCo_tel() %>"/></td>
		</tr>
		<tr>
			<td>회사대표자</td>
			<td><input type="text" name="co_ceo_name" value="<%=resultVO.getCo_ceo_name() %>"/></td>
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