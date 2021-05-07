package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.happyhouse.repository.dto.MemberDto;
import com.ssafy.happyhouse.repository.dto.NoticeDto;
import com.ssafy.happyhouse.repository.dto.PageDto;
import com.ssafy.happyhouse.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController extends HttpServlet{
	
	@Autowired
	private NoticeService noticeService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		doGet(req, resp);
	}
	
	@GetMapping("")
	public String noticeList(@RequestParam(defaultValue = "1") int pageNo,  Model model) throws Exception {
		PageDto pageDto = new PageDto();
		pageDto.setPageNo(pageNo);
		model.addAttribute("result", noticeService.selectNoticeByPageNum(pageDto));
		Map<String, Object> map = noticeService.selectNoticeByPageNum(pageDto);
		return "noticeList";
	}
	
	@GetMapping("/{articleno}")
	public String noticeDetail(@PathVariable("articleno") int articleno, Model model) {
		try {
			NoticeDto noticeDto = noticeService.selectNoticeByNo(articleno);
			model.addAttribute("notice", noticeDto);
			return "noticeWatch";
		} catch (Exception e) {
			e.printStackTrace();
			return "index";
		}
	}
	
	@GetMapping("/updateForm/{articleno}")
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
	
	@PostMapping("/update/{articleno}")
	private String modify(@PathVariable("articleno") int articleno, HttpSession session,
						@RequestParam int viewcnt, @RequestParam String subject, @RequestParam String content) throws IOException {
		NoticeDto noticeDto = new NoticeDto();
        MemberDto memberDto = (MemberDto)session.getAttribute("userinfo");
        noticeDto.setArticleno(articleno);
        noticeDto.setSubject(subject);
        noticeDto.setContent(content);
        noticeDto.setUserid(memberDto.getUserid());
        noticeDto.setViewcnt(viewcnt);
        noticeService.updateNotice(noticeDto);
        return "redirect:/notice/" + articleno; 
	}
	
	@GetMapping("/delete/{articleno}")
	public String delete(@PathVariable("articleno") int articleno) {
		noticeService.deleteNotice(articleno);
		return "redirect:/notice";
	}
	
	@GetMapping("/write")
	public String writeForm() {
		return "noticeWrite";
	}
	
	@PostMapping("/regist")
	public String regist(@RequestParam String subject, @RequestParam String content, HttpSession session) {
		// 생성자 확인
		NoticeDto noticeDto = new NoticeDto();
        noticeDto.setContent(content);
        noticeDto.setSubject(subject);
        noticeDto.setViewcnt(0); 
        MemberDto memberDto = (MemberDto)session.getAttribute("userinfo");
        noticeDto.setUserid(memberDto.getUserid());
        noticeService.insertNotice(noticeDto);
        return "redirect:/notice"; // mybatis 글번호가져와서 글 확인 창 띄우는 걸로 변경해야함 
	}
}


