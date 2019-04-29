package kr.patago.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.patago.service.OmokServiceImpl;
import kr.patago.vo.OmokVO;

@WebServlet({ "/MyOmok", "/myomok" })
public class MyOmok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("application/json"); //환경에 따라 존재유무에 따라 동작이 될수도 안될수도 있음
		response.setCharacterEncoding("UTF-8");
		
		String historys = request.getParameter("historys");
		String winner = request.getParameter("winner");
		System.out.println("historys: " + historys);
		System.out.println("winner: " + winner);
		
		String[] arr_history = historys.split(",");
		
		OmokServiceImpl service = OmokServiceImpl.getInstance();
		OmokVO maxVO = service.selectMax();
		
		String pan = maxVO.getPan();
		
		int count = 0;
		for(int i=0; i<arr_history.length; i++){
			String pan_order = ""+(i+1);
			String history = arr_history[i];
			
			OmokVO pVO = new OmokVO();
			pVO.setPan(pan);
			pVO.setPan_order(pan_order);
			pVO.setHistory(history);
			pVO.setWinner(winner);
			
			count += service.insert(pVO);
		}
		
		String msg = "ok" + "," + pan;
		if(arr_history.length != count){
			msg = "ng";
		}
		
		PrintWriter out = response.getWriter();
		out.print("{\"message\":\"msg\"}");
//		out.flush(); //통신환경에 따라 flush() 존재유무에 따라 데이터가 전송될수도 안될수도 있음
		System.out.println("doPost");
	}
	
}