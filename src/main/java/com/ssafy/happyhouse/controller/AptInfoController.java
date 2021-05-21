package com.ssafy.happyhouse.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.repository.dto.AptInfoDto;
import com.ssafy.happyhouse.service.AptInfoService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/aptinfo")
public class AptInfoController {
	
	@Autowired
	private AptInfoService aptInfoService;
	
	@GetMapping   // houseinfo(위도,경도 포함) 전체 리스트
	public ResponseEntity<List<AptInfoDto>> aptInfoList() throws SQLException {
		return new ResponseEntity<List<AptInfoDto>>(aptInfoService.selectAptInfo(), HttpStatus.OK);
	}
	
}
