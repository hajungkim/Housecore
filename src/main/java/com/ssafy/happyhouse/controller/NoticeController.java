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

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/notice")
public class NoticeController{
	
	@Autowired
	private NoticeService noticeService;

	@GetMapping  // 모든목록
	public ResponseEntity<List<NoticeDto>> noticeList() throws SQLException {
		System.out.println("ok");
		return new ResponseEntity<List<NoticeDto>>(noticeService.selectNotices(), HttpStatus.OK);
	}
	
	@GetMapping("{articleno}")  // 글자세히
	public ResponseEntity<NoticeDto> noticeDetail(@PathVariable("articleno") int articleno, Model model) throws SQLException {
		return new ResponseEntity<NoticeDto>(noticeService.selectNoticeByNo(articleno), HttpStatus.OK);
	}
	
	@PostMapping  // 글쓰기
	public void regist(@RequestBody NoticeDto noticeDto) {
		noticeService.insertNotice(noticeDto);
	}
	
	@PutMapping("{articleno}")  // 수정
	private void noticeUpdate(@RequestBody NoticeDto noticeDto) throws IOException {
		noticeService.updateNotice(noticeDto);
	}
	
	@DeleteMapping("{articleno}")  // 삭제
	public void noticeDelete(@PathVariable("articleno") int articleno) {
		noticeService.deleteNotice(articleno);
	}
	
	@GetMapping("updateForm/{articleno}")  // 이거뭐지..?
	public String noticeUpdate(@PathVariable("articleno") int articleno, Model model) {
		try {
			NoticeDto noticeDto = noticeService.selectNoticeByNo(articleno);
			model.addAttribute("notice", noticeDto);
			return "noticeModify";
		} catch (Exception e) {
			e.printStackTrace();
			return "index";
		}
	}
	
}


