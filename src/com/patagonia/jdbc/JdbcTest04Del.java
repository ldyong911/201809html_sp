package com.patagonia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcTest04Del {
	public static void main(String[] args) throws Exception{
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "patagonia";
		String pw = "q1w2e3r4";
		String query = "delete from pata where col1='3'";

		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pw);
		Statement stmt = conn.createStatement();
		int cnt = stmt.executeUpdate(query);
		System.out.println("cnt: " + cnt);
		
		stmt.close();
		conn.close();
	}
}