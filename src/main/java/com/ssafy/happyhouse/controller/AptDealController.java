package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.happyhouse.repository.dto.PageDto;
import com.ssafy.happyhouse.repository.dto.SearchDto;
import com.ssafy.happyhouse.service.AptDealService;

@Controller
@RequestMapping("/aptDeal")
public class AptDealController {
	
	@Autowired
	private AptDealService aptDealService;
	
	@GetMapping("{dongcode}")
	public String list(@PathVariable String dongcode, @RequestParam(defaultValue = "1") int pageNo, Model model ) {
		PageDto pageDto = new PageDto();
		pageDto.setPageNo(pageNo);
		
		SearchDto searchDto = new SearchDto();
		searchDto.setDongcode(dongcode);
		searchDto.setPageNo(pageNo);
		
		try {
			model.addAttribute("result", aptDealService.selectAptDeal(pageDto));
			model.addAttribute("dongcode", dongcode);
			return "boardResult";
		} catch (SQLException e) {
			return "index";
		}
	}
	
	// 이 아래에서 부터는 새로 짜는게 나을듯
	
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
