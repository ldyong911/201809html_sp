package com.patagonia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcTest03Upd {
	public static void main(String[] args) throws Exception{
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "patagonia";
		String pw = "q1w2e3r4";
		String query = "update pata set col2='5', col3='5' where col2='1'";

		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pw);
		Statement stmt = conn.createStatement();
		int cnt = stmt.executeUpdate(query);
		System.out.println("cnt: " + cnt);
		
		stmt.close();
		conn.close();
	}
}