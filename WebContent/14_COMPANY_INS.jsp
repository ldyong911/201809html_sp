<%@page import="com.patagonia.model.EmpVO"%>
<%@page import="com.patagonia.dao.EmpDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>patagonia</title>
</head>
<script src="jquery-1.12.4.js"></script>
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
		
		//전화번호 정규표현식
		var regExp = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
		if (!regExp.test(co_tel.value)) {
			alert("잘못된 휴대폰 번호입니다. 숫자, - 를 포함한 숫자만 입력하세요.");
			co_tel.focus();
			return;
		}

		document.frm.submit();
	}

	function fn_check() {
		var co_id = $("input[name=co_id]").val();

		if (co_id == "") {
			alert("협력사 번호는 입력되어야 합니다.");
			$("input[name=co_id]").focus();
			return;
		}

		//jquery에서 숫자체크
// 		var flag = $.isNumeric(co_id);
		//javasricpt에서 숫자체크
		var int_co_id = Number(co_id);
		var flag = Number.isInteger(int_co_id);
		if (!flag) {
			alert("협력사 번호는 숫자 타입이어야 합니다.")
			return;
		}

		$.ajax({
			type : "get",
			url : "MyAjaxCheck",
			data : {
				co_id : co_id
			},
			dataType : "json",

			success : function(data) {
				console.log(data.message);
				if (data.message == "ok") {
					$("input[name=co_id]").attr("readonly", true);
					alert("사용할 수 있습니다.");
				} else {
					$("input[name=co_id]").val("");
					$("input[name=co_id]").focus();
					alert("사용할 수 없습니다.");
				}
			},

			error : function(xhr, status, error) {
				console.log("에러!: " + error);
			},

		});
	}
</script>
<body>
	등록화면
<form id="frm" name="frm" method="POST" action="14_COMPANY_INS_ACT.jsp">
	<table border="1">
		<tr>
			<td>협력사ID</td>
			<td>
				<input type="text" name="co_id" value="" />
				<input type="button" value="중복체크" onclick="fn_check()" />
			</td>
		</tr>
		<tr>
			<td>협력사명</td>
			<td><input type="text" name="co_name" value=""/></td>
		</tr>
		<tr>
			<td>담당자ID</td>
			<td>
				<select name="manager_id">
					<option value="">-----</option>
					<%
						EmpDao dao = new EmpDao();
						ArrayList<EmpVO> listCombo = dao.selEmp();
						
						for(int i=0; i<listCombo.size(); i++){
					%>
					<option value="<%=listCombo.get(i).getSawon_id() %>"><%=listCombo.get(i).getSawon_name() %></option>
					<%} %>
				</select>
			</td>
		</tr>
		<tr>
			<td>주식회사여부</td>
			<td>
				<input type="radio" name="stock_yn" value="Y" checked/>주식회사
				<input type="radio" name="stock_yn" value="N"/>기타
			</td>
		</tr>
		<tr>
			<td>회사연락처</td>
			<td><input type="text" name="co_tel" value=""/></td>
		</tr>
		<tr>
			<td>회사대표자</td>
			<td><input type="text" name="co_ceo_name" value=""/></td>
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