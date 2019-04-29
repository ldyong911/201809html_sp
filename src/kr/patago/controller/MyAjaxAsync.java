package kr.patago.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/MyAjaxAsync","/myajaxasync"}) //url 맵핑
public class MyAjaxAsync extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String param1 = request.getParameter("param1");
		System.out.println("param1: " + param1);
		
//		response.setContentType("application/json"); //환경에 따라 존재유무에 따라 동작이 될수도 안될수도 있음
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		out.print("{\"message\":\"ok\"}");
//		out.flush(); //통신환경에 따라 flush() 존재유무에 따라 데이터가 전송될수도 안될수도 있음
		System.out.println("doGet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
	}

}