package com.ssafy.happyhouse.controller;

import java.sql.SQLException;
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
	
	// {dongcode}
	// @PathVariable String dongcode,
	@GetMapping("")
	public String list(@RequestParam(defaultValue = "1") int pageNo, Model model ) {
		PageDto pageDto = new PageDto();
		pageDto.setPageNo(pageNo);
		
		SearchDto searchDto = new SearchDto();
		//searchDto.setDongcode(dongcode);
		searchDto.setPageNo(pageNo);
		
		try {
			model.addAttribute("result", aptDealService.selectAptDeal(pageDto));
			//model.addAttribute("dongcode", dongcode);
			model.addAttribute("dongcode", "");
			return "boardResult";
		} catch (SQLException e) {
			return "index";
		}
	}
	
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
			model.addAttribute("dongcode", "");
			return "boardResult";
		} catch (SQLException e) {
			return "index";
		}
	}
}
