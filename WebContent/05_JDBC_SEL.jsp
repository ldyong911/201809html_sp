<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>patagonia</title>
</head>
<body>
	<%
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "patagonia";
		String password = "q1w2e3r4";

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from pata");
	%>
	<table border="1">
		<tr>
			<td>사번</td>
			<td>이름</td>
			<td>연봉</td>
		</tr>
		<%
			while (rs.next()) {
				String col1 = rs.getString(1);
				String col2 = rs.getString(2);
				String col3 = rs.getString(3);
		%>
		<tr>
			<td><%=col1%></td>
			<td><%=col2%></td>
			<td><%=col3%></td>
		</tr>
		<%
			}

			rs.close();
			stmt.close();
			con.close();
		%>
	</table>
</body>
</html>