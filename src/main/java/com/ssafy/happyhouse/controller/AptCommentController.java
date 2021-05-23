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

import com.ssafy.happyhouse.repository.dto.AptCommentDto;
import com.ssafy.happyhouse.service.AptCommentService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/comment")
public class AptCommentController {
	
	@Autowired
	private AptCommentService aptCommentService;
	
	@ApiOperation(value = "aptinfo no에 따라 코멘트 리스트 반환", response = List.class)
	@GetMapping("{aptNo}")
	public ResponseEntity<List<AptCommentDto>> aptCommentList(@PathVariable("aptNo") int aptNo) throws SQLException {
		return new ResponseEntity<List<AptCommentDto>>(aptCommentService.selectComments(aptNo), HttpStatus.OK);
	}
	
}
