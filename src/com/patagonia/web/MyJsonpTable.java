package com.patagonia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.patagonia.dao.EmpDao;
import com.patagonia.model.EmpVO;

@WebServlet({ "/MyJsonpTable" })
public class MyJsonpTable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		EmpDao dao = new EmpDao();
		try {
			ArrayList<EmpVO> list = dao.selEmp(); //Exception 예외를 발생시키지만 현재 클래스가 HttpServlet를 상속받기때문에 try로 처리해야함
			
			//자바스크립트에서는 배열을 []로 감싼다
			String text_pre = "[";
			String text = "";
			String text_post = "]";
			
			for(int i=0; i<list.size(); i++){
				String sawon_id = list.get(i).getSawon_id();
				String sawon_name = list.get(i).getSawon_name();
				
				text += "{\"sawon_id\":\""+sawon_id+"\",\"sawon_name\":\""+sawon_name+"\"},";
			}
			
			if(list.size() > 0){
				text = text.substring(0, text.length()-1); //String을 모두 더한 text에서 마지막에 ,를 잘라내기위해
			}
			
			//크로스도메인을 해결하기위해 jsp파일에서 jsonpCallback에 적은 값의 이름으로 감싸줘야함 myCallback()
			out.print("myCallback(");
			out.print(text_pre);
			out.print(text);
			out.print(text_post);
			out.print(")");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}