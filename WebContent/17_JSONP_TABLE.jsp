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
	function fn_ajax(){
		$.ajax({
			type : "get",
// 			url : "MyAjaxTable", //상대경로
			url : "http://127.0.0.1/SP/MyJsonpTable", //절대경로
			data : {param1: 'merryChrismax'},
			//크로스도메인 해결법은 dataType을 jsonp로 변경, jsonpCallback : "원하는이름"을 추가해준다
			//그리고 Servlet파일에서 jsonpCallback에 적은 이름으로 감싸줘야한다.
			dataType : "jsonp",
			jsonpCallback : "myCallback",

			success : function(data) {
				renderTable(data);
			},

			error : function(xhr, status, error) {
				console.log("에러!: " + error);
			},

		});
	}
	
	function renderTable(data){
		var text = "";
		for(var i=0; i<data.length; i++){
			text += "<tr>";
			text += "	<td>"+data[i].sawon_id+"</td>";
			text += "	<td>"+data[i].sawon_name+"</td>";
			text += "</tr>";
		}
		
		$("#my_tbody").html(text);
	}
</script>
<body>
	<a href="javascript:fn_ajax()">flickering X</a>
	
	<table>
		<tr>
			<td>사원ID</td>
			<td>사원명</td>
		</tr>
		<tbody id="my_tbody">
			<tr>
				<td>1</td>
				<td>홍길동</td>
			</tr>
		</tbody>
	</table>
</body>
</html>