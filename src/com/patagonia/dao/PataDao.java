package com.patagonia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.patagonia.model.PataVO;


public class PataDao {
	//데이터베이스 연결시 필수값(CRUD에서 모두 사용되기 때문에 전역변수로 설정)
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe"; //1521과 xe는 오라클에서 접속세부정보를 확인할 수 있음
	String user = "patagonia";
	String pw = "q1w2e3r4";
	
	//Select문
	public ArrayList<PataVO> selPata() throws Exception {
		ArrayList<PataVO> list = new ArrayList<>();

		Class.forName(driver); //드라이버클래스 로딩
		Connection conn = DriverManager.getConnection(url, user, pw); //DB연결된 상태(세션)을 담은 객체
		Statement stmt = conn.createStatement(); //SQL 문을 나타내는 객체
		ResultSet rs = stmt.executeQuery("select * from pata"); //쿼리문을 날린것에 대한 반환값을 담을 객체
																//DB에서 데이터수정하고 commit 필수
																//select문는 executeQuery
																//나머지는 executeUpdate
		
		while(rs.next()){
			String col1 = rs.getString(1); //비쥬얼베이직과 ResultSet인터페이스는(DB) 인덱스번호가 1부터 시작한다.
			String col2 = rs.getString(2);
			String col3 = rs.getString(3);
			
			PataVO vo = new PataVO();
			vo.setCol1(col1); //세팅
			vo.setCol2(col2);
			vo.setCol3(col3);
			list.add(vo);
		}
		
		//Connection, Statement, ResultSet은 사용한후 항상 닫아야함(메모리가 남을 가능성이 있기때문에 계속누적되면 언젠간죽음)
		// 매트리스개념 스택구조로 오픈했을때와 반대 순서로 닫아줘야함(원래 각각 트라이캐치를 적용해줘야 하는데 교육입장-야매)
		rs.close();
		stmt.close();
		conn.close();
		
		return list;
	}
	
	//Insert문
	public int insPata(PataVO vo) throws Exception{
		String query = "insert into pata(col1, col2, col3) values ('"+vo.getCol1()+"', '"+vo.getCol2()+"', '"+vo.getCol3()+"')";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pw);
		Statement stmt = conn.createStatement();
		int cnt = stmt.executeUpdate(query);
		System.out.println("cnt: " + cnt);
		
		stmt.close();
		conn.close();
		
		return cnt;
	}
	
	//Update문
	public int updPata(PataVO vo) throws Exception{
		String query = "update pata set col1='"+vo.getCol1()+"', col2='"+vo.getCol2()+"', col3='"+vo.getCol3()+"' where col1='"+vo.getCol1()+"'";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pw);
		Statement stmt = conn.createStatement();
		int cnt = stmt.executeUpdate(query);
		
		stmt.close();
		conn.close();
				
		return cnt;
	}
	
	//Delete문
	public int delPata(PataVO vo) throws Exception{
		String query = "delete from pata where col1='"+vo.getCol1()+"'";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pw);
		Statement stmt = conn.createStatement();
		
		int cnt = stmt.executeUpdate(query);
		
		stmt.close();
		conn.close();
		
		return cnt;
	}

	public static void main(String[] args) throws Exception {
//		//Select문
//		PataDao dao = new PataDao();
//		ArrayList<PataVO> list = dao.selPata();
//
//		for (int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i).getCol1() + list.get(i).getCol2() + list.get(i).getCol3());
//		}
		
//		//Insert문
//		PataDao dao = new PataDao();
//		PataVO vo = new PataVO();
//		vo.setCol1("1001");
//		vo.setCol2("와나나");
//		vo.setCol3("100억");
//		
//		int cnt = dao.insPata(vo);
//		System.out.println(cnt + "개 적용되었습니다.");
		
//		//Update문
//		PataDao dao = new PataDao();
//		PataVO vo = new PataVO();
//		vo.setCol1("9999");
//		vo.setCol2("와나나");
//		vo.setCol3("999999");
//		
//		int cnt = dao.updPata(vo);
//		System.out.println(cnt + "개 적용되었습니다.");
		
		//Delete문
		PataDao dao = new PataDao();
		PataVO vo = new PataVO();
		vo.setCol1("1");
		
		int cnt = dao.delPata(vo);
		System.out.println(cnt + "개 삭제되었습니다.");
	}
}