package com.patagonia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.patagonia.model.EmpVO;

public class EmpDao {
	// 데이터베이스 연결시 필수값(CRUD에서 모두 사용되기 때문에 전역변수로 설정)
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "patagonia";
	String pw = "q1w2e3r4";
	
	//회원1명의 값만 select
	public EmpVO detailEmp(EmpVO vo) throws Exception{
		String query = "";
		query += "select ";
		query += "	  sawon_id, ";
		query += "    sawon_name, ";
		query += "	  mobile, ";
		query += "	  email, ";
		query += "	  ins_date, ";
		query += "	  ins_id, ";
		query += "	  upd_date, ";
		query += "	  upd_id ";
		query += "from ";
		query += "	  emp ";
		query += "where ";
		query += "	  sawon_id='"+vo.getSawon_id()+"' ";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pw);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		EmpVO resultVo = new EmpVO();
		while(rs.next()){
			String sawon_id = rs.getString(1);
			String sawon_name = rs.getString(2);
			String mobile = rs.getString(3);
			String email = rs.getString(4);
			String ins_date = rs.getString(5);
			String ins_id = rs.getString(6);
			String upd_date = rs.getString(7);
			String upd_id = rs.getString(8);
			
			resultVo.setSawon_id(sawon_id);
			resultVo.setSawon_name(sawon_name);
			resultVo.setMobile(mobile);
			resultVo.setEmail(email);
			resultVo.setIns_date(ins_date);
			resultVo.setIns_id(ins_id);
			resultVo.setUpd_date(upd_date);
			resultVo.setUpd_id(upd_id);
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		return resultVo;
	}
	
	public ArrayList<EmpVO> selEmp() throws Exception{
		String query = "";
		query += "select ";
		query += "	  sawon_id, ";
		query += "    sawon_name, ";
		query += "	  mobile, ";
		query += "	  email, ";
		query += "	  ins_date, ";
		query += "	  ins_id, ";
		query += "	  upd_date, ";
		query += "	  upd_id ";
		query += "from ";
		query += "	  emp ";
		
		ArrayList<EmpVO> list = new ArrayList<>();
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pw);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()){
			String sawon_id = rs.getString(1);
			String sawon_name = rs.getString(2);
			String mobile = rs.getString(3);
			String email = rs.getString(4);
			String ins_date = rs.getString(5);
			String ins_id = rs.getString(6);
			String upd_date = rs.getString(7);
			String upd_id = rs.getString(8);
			
			EmpVO vo = new EmpVO();
			vo.setSawon_id(sawon_id);
			vo.setSawon_name(sawon_name);
			vo.setMobile(mobile);
			vo.setEmail(email);
			vo.setIns_date(ins_date);
			vo.setIns_id(ins_id);
			vo.setUpd_date(upd_date);
			vo.setUpd_id(upd_id);
			list.add(vo);
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		return list;
	}
	
	public int insEmp(EmpVO vo) throws Exception{
		String query = "";
		query += "insert into emp ";
		query += "( ";
		query += "sawon_id, sawon_name, mobile, email, ";
		query += "ins_date, ins_id, upd_date, upd_id ";
		query += ") ";
		query += "values ";
		query += "( ";
		query += "'"+vo.getSawon_id()+"', '"+vo.getSawon_name()+"', '"+vo.getMobile()+"', '"+vo.getEmail()+"', ";
		query += "sysdate, '"+vo.getSawon_id()+"', sysdate, '"+vo.getSawon_id()+"' ";
		query += ") ";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pw);
		Statement stmt = conn.createStatement();
		int cnt = stmt.executeUpdate(query);
		System.out.println("cnt: " + cnt);
		
		stmt.close();
		conn.close();
		
		return cnt;
	}
	public int updEmp(EmpVO vo) throws Exception{
		String query = "";
		query += "update emp ";
		query += "set ";
		query += "sawon_name='"+vo.getSawon_name()+"', ";
		query += "mobile='"+vo.getMobile()+"', ";
		query += "email='"+vo.getEmail()+"', ";
		query += "upd_date=sysdate, ";
		query += "upd_id='"+vo.getSawon_id()+"' ";
		query += "where ";
		query += "sawon_id='"+vo.getSawon_id()+"' ";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pw);
		Statement stmt = conn.createStatement();
		int cnt = stmt.executeUpdate(query);
		System.out.println("cnt: " + cnt);
		
		stmt.close();
		conn.close();
		
		return cnt;
	}
	public int delEmp(EmpVO vo) throws Exception{
		String query = "";
		query += "delete ";
		query += "from ";
		query += "emp ";
		query += "where ";
		query += "sawon_id='"+vo.getSawon_id()+"' ";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pw);
		Statement stmt = conn.createStatement();
		int cnt = stmt.executeUpdate(query);
		System.out.println("cnt: " + cnt);
		
		stmt.close();
		conn.close();
		
		return cnt;
	}
	
	public static void main(String[] args) throws Exception{
//		//Select문
//		EmpDao dao = new EmpDao();
//		
//		ArrayList<EmpVO> list = dao.selEmp();
//		
//		for(int i=0; i<list.size(); i++){
//			System.out.println(list.get(i).getSawon_id() + " " + list.get(i).getSawon_name() + " "
//							   + list.get(i).getMobile() + " " + list.get(i).getEmail() + " "
//							   + list.get(i).getIns_date() + " " + list.get(i).getIns_id() + " "
//							   + list.get(i).getUpd_date() + " " + list.get(i).getUpd_id());
//		}
		
//		//Insert문
//		EmpDao dao = new EmpDao();
//		EmpVO vo = new EmpVO();
//		
//		vo.setSawon_id("1");
//		vo.setSawon_name("와나나");
//		vo.setMobile("017123456789");
//		vo.setEmail("daum.net");
//		vo.setIns_id(vo.getSawon_id());
//		vo.setUpd_id(vo.getSawon_id());
//		
//		int cnt = dao.insEmp(vo);
//		
//		System.out.println(cnt +"개 적용되었습니다.");
		
//		//Update문
//		EmpDao dao = new EmpDao();
//		EmpVO vo = new EmpVO();
//		
//		vo.setSawon_id("1");
//		vo.setSawon_name("자나나");
//		vo.setMobile("0101234");
//		vo.setEmail("daum.net");
//		vo.setUpd_id(vo.getSawon_id());
//		
//		int cnt = dao.updEmp(vo);
//		
//		System.out.println(cnt + "개 적용되었습니다.");
		
//		//Delete문
//		EmpDao dao = new EmpDao();
//		EmpVO vo = new EmpVO();
//		
//		vo.setSawon_id("1");
//		
//		int cnt = dao.delEmp(vo);
//		
//		System.out.println(cnt + "개 삭제되었습니다.");
	}
}