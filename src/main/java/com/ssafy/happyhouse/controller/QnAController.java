package com.ssafy.happyhouse.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.repository.dto.QnADto;
import com.ssafy.happyhouse.service.QnAService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/qna")
public class QnAController {
	
	@Autowired
	private QnAService qnaService;
	
	@GetMapping // 모든 qna 목록 반환
	public ResponseEntity<List<QnADto>> qnaAllList() throws SQLException {
		return new ResponseEntity<List<QnADto>>(qnaService.selectQnAs(), HttpStatus.OK);
	}
	
	@GetMapping("list/{userId}") // 고객의 모든 qna 목록 반환
	public ResponseEntity<List<QnADto>> qnaList(@PathVariable String userId) throws SQLException {
		return new ResponseEntity<List<QnADto>>(qnaService.selectQnA(userId), HttpStatus.OK);
	}
	
	@GetMapping("{no}") // read
	public ResponseEntity<QnADto> getQnA(@PathVariable int no) throws SQLException {
		return new ResponseEntity<QnADto> (qnaService.selectOneQnA(no), HttpStatus.OK);
	}
	
	@PostMapping // create
	public ResponseEntity<String> writeQnA(@RequestBody QnADto qnaDto) {
		System.out.println(qnaDto);
		if (qnaService.insertQnA(qnaDto))
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return new ResponseEntity<String>("FAIL", HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("{no}") // update
	public ResponseEntity<String> updateQnA(@RequestBody QnADto qnaDto) {
		if(qnaService.updateQnA(qnaDto))
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return new ResponseEntity<String>("FAIL", HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("{no}") // delete
	public ResponseEntity<String> deleteQnA(@PathVariable int no) {
		if(qnaService.deleteQnA(no))
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return new ResponseEntity<String>("FAIL", HttpStatus.NO_CONTENT);
			
	}
}
