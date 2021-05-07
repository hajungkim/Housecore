package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.happyhouse.repository.dto.AptDealDto;
import com.ssafy.happyhouse.repository.dto.PageDto;
import com.ssafy.happyhouse.repository.dto.SearchDto;
import com.ssafy.happyhouse.service.AptDealService;
import com.ssafy.happyhouse.service.AptDealServiceImpl;

@WebServlet("/aptDeal")
public class AptDealController extends HttpServlet {
	
	private AptDealService aptDealService;
	
	public void init() throws ServletException {
		super.init();
		aptDealService = new AptDealServiceImpl();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String act = req.getParameter("act");
		if("list".equals(act)) {
			//System.out.println(req.getParameter("dongcode"));
			if(req.getParameter("dongcode") == null)
				showList(req, resp);
			else
				searchedList(req,resp);
		} else if( "searchbylist".equals(act)) {
			//System.out.println(req.getParameter("dongcode"));
			if(req.getParameter("dongcode") == "")
				showList(req, resp);
			else
				searchedList(req,resp);
		}
	}

	private void searchedList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String dongcode = req.getParameter("dongcode");
		PageDto pageDto = new PageDto();
		int pageNo = 1;
		try {
			pageDto.setPageNo(Integer.parseInt(req.getParameter("pageNo")));
		}catch (Exception e) {} 
		SearchDto searchDto = new SearchDto();
		searchDto.setDongcode(dongcode);
		searchDto.setPageNo(pageNo);
		
		try {
			req.setAttribute("result", aptDealService.selectAptDealBySearch(searchDto, pageDto));
			req.setAttribute("dongcode", dongcode);

			req.getRequestDispatcher("/view/boardResult.jsp").forward(req, resp);;
		} catch (SQLException e) {
			// 에러 페이지 연결
			e.printStackTrace();
		}
	}
	private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PageDto pageDto = new PageDto();
		try {
			pageDto.setPageNo(Integer.parseInt(req.getParameter("pageNo")));
		}catch (Exception e) {} 
		try {
			req.setAttribute("result", aptDealService.selectAptDeal(pageDto));
			req.setAttribute("dongcode", "");
			req.getRequestDispatcher("/view/boardResult.jsp").forward(req, resp);
		} catch (SQLException e) {
			// 에러 페이지 연결
			e.printStackTrace();
		}
		
	}

	
}
