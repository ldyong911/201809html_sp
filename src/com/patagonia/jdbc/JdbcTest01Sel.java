package com.patagonia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest01Sel {
	public static void main(String[] args) throws Exception{
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //1521과 xe는 오라클에서 접속세부정보를 확인할 수 있음
		String user = "patagonia";
		String pw = "q1w2e3r4";

		Class.forName(driver); //드라이버클래스 로딩
		Connection conn = DriverManager.getConnection(url, user, pw); //DB연결된 상태(세션)을 담은 객체
		Statement stmt = conn.createStatement(); //SQL 문을 나타내는 객체
		ResultSet rs = stmt.executeQuery("select * from pata"); //쿼리문을 날린것에 대한 반환값을 담을 객체
																//DB에서 데이터수정하고 commit 필수
		
		while(rs.next()){
			String col1 = rs.getString(1); //DB에서 컬럼번호는 1부터 시작
			String col2 = rs.getString(2);
			String col3 = rs.getString(3);
			
			System.out.println("col1: " + col1);
			System.out.println("col2: " + col2);
			System.out.println("col3: " + col3);
		}
		
		
		//Connection, Statement, ResultSet은 사용한후 항상 닫아야함
		rs.close();
		stmt.close();
		conn.close();
	}
	
//	public static void main(String[] args) {
//		String driver = "oracle.jdbc.driver.OracleDriver";
//		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //1521과 xe는 오라클에서 접속세부정보를 확인할 수 있음
//		String user = "patagonia";
//		String pw = "q1w2e3r4";
//		
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		
//		try {
//			Class.forName(driver);
//			System.out.println("jdbc driver 로딩 성공");
//			DriverManager.getConnection(url, user, pw);
//			System.out.println("오라클 연결 성공");
//			
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, user, pw);
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery("select * from pata"); //db에서 데이터수정하고 commit 필수
//			
//			while(rs.next()){
//				String col1 = rs.getString(1);
//				String col2 = rs.getString(2);
//				String col3 = rs.getString(3);
//				
//				System.out.println("col1: " + col1);
//				System.out.println("col2: " + col2);
//				System.out.println("col3: " + col3);
//			}
//		} catch (ClassNotFoundException cnfe) {
//			System.out.println("jdbc driver 로딩 실패:" + cnfe.toString());
//		} catch (SQLException sqle) {
//			System.out.println("오라클 연결 실패: " + sqle.toString());
//		} catch (Exception e) {
//			System.out.println("Unkonwn error");
//			e.printStackTrace();
//		}finally{
//			try {
//				rs.close();
//				stmt.close();
//				conn.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//	}
}