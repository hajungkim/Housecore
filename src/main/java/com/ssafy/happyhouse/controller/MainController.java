package com.ssafy.happyhouse.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String act = req.getParameter("act");
		
		if("mvIntroduce".equals(act)) {
			resp.sendRedirect(req.getContextPath() + "/view/introduce.jsp");
		} else if("mvNoticeList".equals(act)) {
			resp.sendRedirect(req.getContextPath() + "/notice?act=mvnoticelist");
		} else if("mvNeighborInfo".equals(act)) {
			resp.sendRedirect(req.getContextPath() + "/view/neighborInfo.jsp");
		}  else if("mvEnvironmentInfo".equals(act)) {
			resp.sendRedirect(req.getContextPath() + "/view/environmentinfo.jsp");
		} 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		doGet(req,resp);
	}

	
}
