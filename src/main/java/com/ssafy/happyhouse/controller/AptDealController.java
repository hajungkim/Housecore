package com.ssafy.happyhouse.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.repository.dto.AptDealDto;
import com.ssafy.happyhouse.service.AptDealService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/aptdeal")
public class AptDealController {
	
	@Autowired
	private AptDealService aptDealService;
	
	@GetMapping("{no}")
	public ResponseEntity<List<AptDealDto>> aptDealList(@PathVariable("no") int no) throws SQLException {
		return new ResponseEntity<List<AptDealDto>>(aptDealService.selectAptDeal(no), HttpStatus.OK);
	}
	
}
