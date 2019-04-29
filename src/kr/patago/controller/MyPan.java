package kr.patago.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.patago.service.OmokServiceImpl;
import kr.patago.vo.OmokVO;

@WebServlet({ "/MyPan", "/mypan" })
public class MyPan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String pans = request.getParameter("pan");
		
		OmokVO vo = new OmokVO();
		vo.setPan(pans);
		
		OmokServiceImpl service = OmokServiceImpl.getInstance();
		
		try {
			ArrayList<OmokVO> list = (ArrayList<OmokVO>)service.selectListPans(vo); //Exception 예외를 발생시키지만 현재 클래스가 HttpServlet를 상속받기때문에 try로 처리해야함
			
			//자바스크립트에서는 배열을 []로 감싼다
			String text_pre = "[";
			String text = "";
			String text_post = "]";
			
			for(int i=0; i<list.size(); i++){
				String pan = list.get(i).getPan();
				String pan_order = list.get(i).getPan_order();
				String history = list.get(i).getHistory();
				String winner = list.get(i).getWinner();
				
				text += "{\"pan\":\""+pan+"\",\"pan_order\":\""+pan_order+"\",\"history\":\""+history+"\",\"winner\":\""+winner+"\"},";
			}
			
			if(list.size() > 0){
				text = text.substring(0, text.length()-1); //String을 모두 더한 text에서 마지막에 ,를 잘라내기위해
			}
			
			out.print(text_pre);
			out.print(text);
			out.print(text_post);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}