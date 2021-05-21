package com.ssafy.happyhouse.controller;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.repository.dto.AptInfoDto;
import com.ssafy.happyhouse.service.AptInfoService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/aptinfo")
public class AptInfoController {
	
	@Autowired
	private AptInfoService aptInfoService;
	
	@ApiOperation(value = "모든 리스트 반환", response = List.class)
	@GetMapping
	public ResponseEntity<List<AptInfoDto>> AptInfoList() throws SQLException {
		return new ResponseEntity<List<AptInfoDto>>(aptInfoService.selectAptInfo(), HttpStatus.OK);
	}
	
}
