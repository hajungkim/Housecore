package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.repository.dto.NoticeDto;
import com.ssafy.happyhouse.service.NoticeService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/notice")
public class NoticeController{
	
	@Autowired
	private NoticeService noticeService;

	@ApiOperation(value = "모든 리스트 반환", response = List.class)
	@GetMapping
	public ResponseEntity<List<NoticeDto>> noticeList() throws SQLException {
		return new ResponseEntity<List<NoticeDto>>(noticeService.selectNotices(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "리스트 자세히 보기", response = List.class)
	@GetMapping("{no}")
	public ResponseEntity<NoticeDto> noticeDetail(@PathVariable("no") int no) throws SQLException {
		return new ResponseEntity<NoticeDto>(noticeService.selectNoticeByNo(no), HttpStatus.OK);
	}
	
	@ApiOperation(value = "글 등록하기")
	@PostMapping
	public void regist(@RequestBody NoticeDto noticeDto) {
		noticeService.insertNotice(noticeDto);
	}
	
	@ApiOperation(value = "수정하기")
	@PutMapping
	private void noticeUpdate(@RequestBody NoticeDto noticeDto) throws IOException {
		noticeService.updateNotice(noticeDto);
	}
	
	@ApiOperation(value = "삭제하기")
	@DeleteMapping("{no}")
	public void noticeDelete(@PathVariable("no") int no) {
		noticeService.deleteNotice(no);
	}
	
}


