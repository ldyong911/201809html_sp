package com.patagonia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.patagonia.dao.CompanyDao;
import com.patagonia.model.CompanyVO;

@WebServlet("/MyAjaxCheck")
public class MyAjaxCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "ng";
		String co_id = request.getParameter("co_id");
		System.out.println("co_id: " + co_id);
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		CompanyVO vo = new CompanyVO();
		vo.setCo_id(co_id);
		
		CompanyDao dao = new CompanyDao();
		try {
			CompanyVO rVO = dao.select(vo);
			if(rVO == null){
				message = "ok";
			}
			System.out.println(rVO);
			System.out.println(message);
			out.print("{\"message\":\""+message+"\"}");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("doGet");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}