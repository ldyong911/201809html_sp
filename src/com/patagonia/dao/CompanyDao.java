package com.patagonia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.patagonia.model.CompanyVO;

public class CompanyDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "patagonia";
	String pw = "q1w2e3r4";
	
	public CompanyVO select(CompanyVO vo) throws Exception{
		String query = "";
		query += "select ";
		query += "    com.co_id, ";
		query += "    com.co_name, ";
		query += "    com.manager_id, ";
		query += "    com.stock_yn, ";
		query += "    com.co_tel, ";
		query += "    com.co_ceo_name, ";
		query += "    com.intime, ";
		query += "    com.inid, ";
		query += "    com.uptime, ";
		query += "    com.upid, ";
		query += "    e.sawon_name as manager_name ";
		query += "from ";
		query += "    company com, ";
		query += "    emp e ";
		query += "where ";
		query += "    com.manager_id = e.sawon_id ";
		query += "and com.co_id = '"+vo.getCo_id()+"'";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pw);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		CompanyVO tCompanyVO = null; //데이터가 존재하지 않을땐 null 반환해주기위해
		while(rs.next()){
			String co_id = rs.getString(1);
			String co_name = rs.getString(2);
			String manager_id = rs.getString(3);
			String stock_yn = rs.getString(4);
			String co_tel = rs.getString(5);
			String co_ceo_name = rs.getString(6);
			String intime = rs.getString(7);
			String inid = rs.getString(8);
			String uptime = rs.getString(9);
			String upid = rs.getString(10);
			String manager_name = rs.getString(11);
			
			tCompanyVO = new CompanyVO();
			
			tCompanyVO.setCo_id(co_id);
			tCompanyVO.setCo_name(co_name);
			tCompanyVO.setManager_id(manager_id);
			tCompanyVO.setStock_yn(stock_yn);
			tCompanyVO.setCo_tel(co_tel);
			tCompanyVO.setCo_ceo_name(co_ceo_name);
			tCompanyVO.setIntime(intime);
			tCompanyVO.setInid(inid);
			tCompanyVO.setUptime(uptime);
			tCompanyVO.setUpid(upid);
			tCompanyVO.setManager_name(manager_name);
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		return tCompanyVO;
	}
	
	public ArrayList<CompanyVO> selectList(CompanyVO vo) throws Exception{
		String query = "";
		query += "select ";
		query += "    com.co_id, ";
		query += "    com.co_name, ";
		query += "    com.manager_id, ";
		query += "    com.stock_yn, ";
		query += "    com.co_tel, ";
		query += "    com.co_ceo_name, ";
		query += "    com.intime, ";
		query += "    com.inid, ";
		query += "    com.uptime, ";
		query += "    com.upid, ";
		query += "    e.sawon_name as manager_name ";
		query += "from ";
		query += "    company com, ";
		query += "    emp e ";
		query += "where ";
		query += "    com.manager_id = e.sawon_id ";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pw);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		ArrayList<CompanyVO> list = new ArrayList<>();
		while(rs.next()){
			String co_id = rs.getString(1);
			String co_name = rs.getString(2);
			String manager_id = rs.getString(3);
			String stock_yn = rs.getString(4);
			String co_tel = rs.getString(5);
			String co_ceo_name = rs.getString(6);
			String intime = rs.getString(7);
			String inid = rs.getString(8);
			String uptime = rs.getString(9);
			String upid = rs.getString(10);
			String manager_name = rs.getString(11);
			
			CompanyVO tCompanyVO = new CompanyVO();
			tCompanyVO.setCo_id(co_id);
			tCompanyVO.setCo_name(co_name);
			tCompanyVO.setManager_id(manager_id);
			tCompanyVO.setStock_yn(stock_yn);
			tCompanyVO.setCo_tel(co_tel);
			tCompanyVO.setCo_ceo_name(co_ceo_name);
			tCompanyVO.setIntime(intime);
			tCompanyVO.setInid(inid);
			tCompanyVO.setUptime(uptime);
			tCompanyVO.setUpid(upid);
			tCompanyVO.setManager_name(manager_name);
			
			list.add(tCompanyVO);
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		return list;
	}
	
	public int insert(CompanyVO vo) throws Exception{
		String query = "";
		query += "insert into company ";
		query += "( ";
		query += "co_id, ";
		query += "co_name, ";
		query += "manager_id, ";
		query += "stock_yn, ";
		query += "co_tel, ";
		
		query += "co_ceo_name, ";
		query += "intime, ";
		query += "inid, ";
		query += "uptime, ";
		query += "upid ";
		
		query += ") ";
		query += "values ";
		query += "( ";
		query += "'"+vo.getCo_id()+"', ";
		query += "'"+vo.getCo_name()+"', ";
		query += "'"+vo.getManager_id()+"', ";
		query += "'"+vo.getStock_yn()+"', ";
		query += "'"+vo.getCo_tel()+"', ";
		
		query += "'"+vo.getCo_ceo_name()+"', ";
		query += "sysdate, ";
		query += "'"+vo.getManager_id()+"', ";
		query += "sysdate, ";
		query += "'"+vo.getManager_id()+"' ";
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
	
	public int update(CompanyVO vo) throws Exception{
		String query = "";
		query += "update company ";
		query += "set ";
		query += "co_name='"+vo.getCo_name()+"', ";
		query += "manager_id='"+vo.getManager_id()+"', ";
		query += "stock_yn='"+vo.getStock_yn()+"', ";
		query += "co_tel='"+vo.getCo_tel()+"', ";
		query += "co_ceo_name='"+vo.getCo_ceo_name()+"', ";
		
		query += "uptime=sysdate, ";
		query += "upid='"+vo.getManager_id()+"' ";
		
		query += "where ";
		query += "co_id='"+vo.getCo_id()+"' ";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pw);
		Statement stmt = conn.createStatement();
		int cnt = stmt.executeUpdate(query);
		System.out.println("cnt: " + cnt);
		
		stmt.close();
		conn.close();
		
		return cnt;
	}
	
	public int delete(CompanyVO vo) throws Exception{
		String query = "";
		query += "delete ";
		query += "from ";
		query += "company ";
		query += "where ";
		query += "co_id='"+vo.getCo_id()+"' ";
		
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
//		//Insert문
//		CompanyDao dao = new CompanyDao();
//		CompanyVO vo = new CompanyVO();
//		
//		vo.setCo_id("2");
//		vo.setCo_name("naver");
//		vo.setManager_id("999");
//		vo.setStock_yn("Y");
//		vo.setCo_tel("01098765432");
//		vo.setCo_ceo_name("Wanana");
//		vo.setInid(vo.getManager_id());
//		vo.setUpid(vo.getManager_id());
//		
//		int cnt = dao.insert(vo);
//		
//		System.out.println(cnt +"개 적용되었습니다.");
		
//		//Update문
//		CompanyDao dao = new CompanyDao();
//		CompanyVO vo = new CompanyVO();
//		
//		vo.setCo_id("2");
//		vo.setCo_name("daum");
//		vo.setManager_id("999");
//		vo.setStock_yn("Y");
//		vo.setCo_tel("01098765432");
//		vo.setCo_ceo_name("Wanana");
//		vo.setUpid(vo.getManager_id());
//		
//		int cnt = dao.update(vo);
//		
//		System.out.println(cnt + "개 적용되었습니다.");
		
//		//Delete문
//		CompanyDao dao = new CompanyDao();
//		CompanyVO vo = new CompanyVO();
//		
//		vo.setCo_id("2");
//		
//		int cnt = dao.delete(vo);
//		
//		System.out.println(cnt + "개 삭제되었습니다.");
		
//		//전체 Select문
//		CompanyDao dao = new CompanyDao();
//		
//		ArrayList<CompanyVO> list = dao.selectList(null);
//		
//		for(int i=0; i<list.size(); i++){
//			System.out.println(list.get(i).getCo_id() + " " + list.get(i).getCo_name() + " "
//							   + list.get(i).getManager_id() + " " + list.get(i).getStock_yn() + " "
//							   + list.get(i).getCo_tel() + " " + list.get(i).getCo_ceo_name() + " "
//							   + list.get(i).getIntime() + " " + list.get(i).getInid()+ " "
//							   + list.get(i).getUptime() + " " + list.get(i).getUpid());
//		}
		
		//1명 Select문
		CompanyDao dao = new CompanyDao();
		CompanyVO vo = new CompanyVO();
		vo.setCo_id("1");
		
		CompanyVO rvo = dao.select(vo);
		System.out.println(rvo.getCo_name());
		
	}
}