package com.ssafy.happyhouse.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
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
	
	@GetMapping("/introduce")
	public String introduce() {
		return "introduce";
	}

	@GetMapping("/neighbor")
	public String neighborInfo() {
		return "neighborInfo";
	}
	
	@GetMapping("/environment")
	public String environmentInfo() {
		return "environmentinfo";
	}
}
