package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.happyhouse.repository.dto.MemberDto;
import com.ssafy.happyhouse.repository.dto.NoticeDto;
import com.ssafy.happyhouse.repository.dto.PageDto;
import com.ssafy.happyhouse.service.NoticeService;
//@WebServlet("/notice")
@Controller
@RequestMapping("/notice")
public class NoticeController extends HttpServlet{
	
	@Autowired
	private NoticeService noticeService;
	
	// ---
//	public void init() throws ServletException {
//		super.init();
//		noticeService = new NoticeServiceImpl();
//	}
	
	// ---
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		doGet(req, resp);
	}
	
	@GetMapping("")
	public String notice(@RequestParam(defaultValue = "1") int pageNo,  Model model) throws Exception {
		PageDto pageDto = new PageDto();
		pageDto.setPageNo(pageNo);
		model.addAttribute("result", noticeService.selectNoticeByPageNum(pageDto));
		Map<String, Object> map = noticeService.selectNoticeByPageNum(pageDto);
		return "noticeList";
	}
	
	@GetMapping("/{articleno}")
	public String detail(@PathVariable("articleno") int articleno, Model model) {
		System.out.println(articleno);
		try {
			NoticeDto noticeDto = noticeService.selectNoticeByNo(articleno);
			model.addAttribute("notice", noticeDto);
			return "noticeWatch";
		} catch (Exception e) {
			e.printStackTrace();
			return "index";
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String root = req.getContextPath();
		String act = req.getParameter("act");
		if("list".equals(act)) {
			//showList(req,resp);
		} else if("write".equals(act)) {
			register(req, resp);
		} else if("modify".equals(act)) {
			modify(req, resp);
		} else if("delete".equals(act)) {
			delete(req, resp);
		} else if("mvnoticewrite".equals(act)) {
			resp.sendRedirect(root+"/view/noticeWrite.jsp");
		} else if("mvnoticewatch".equals(act)) {
			moveWatchNotice(req, resp);
		} else if("mvnoticemodify".equals(act)) {
			moveModifyNotice(req, resp);
		} else if("mvnoticelist".equals(act)) {
			//showList(req, resp);
		} 
	}

	private void moveModifyNotice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/index.jsp";
		int articleno = Integer.parseInt(req.getParameter("articleno"));
		
		try {
			NoticeDto noticeDto = noticeService.selectNoticeByNo(articleno);
			req.setAttribute("notice", noticeDto);
			path = "/view/noticeModify.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			path = "/view/index.jsp";
		}
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	private void moveWatchNotice(HttpServletRequest req, HttpServletResponse resp/*, int no*/) throws ServletException, IOException {
		String path = "/index.jsp";
		int articleno = Integer.parseInt(req.getParameter("articleno"));
		
		try {
			NoticeDto noticeDto = noticeService.selectNoticeByNo(articleno);
			req.setAttribute("notice", noticeDto);
			path = "/view/noticeWatch.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			path = "/view/index.jsp";
		}
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		noticeService.deleteNotice(Integer.parseInt(req.getParameter("articleno")));
		resp.sendRedirect(req.getContextPath() + "/view/index.jsp");
	}

	private void modify(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		NoticeDto noticeDto = new NoticeDto();
        HttpSession session = req.getSession();
        MemberDto memberDto = (MemberDto)session.getAttribute("userinfo");
        noticeDto.setArticleno(Integer.parseInt(req.getParameter("articleno")));
        noticeDto.setContent(req.getParameter("content"));
        noticeDto.setSubject(req.getParameter("subject"));
        noticeDto.setUserid(memberDto.getUserid());
        noticeDto.setViewcnt(Integer.parseInt(req.getParameter("viewcnt")));
        noticeService.updateNotice(noticeDto);
        resp.sendRedirect(req.getContextPath() + "/view/index.jsp");
	}

	private void register(HttpServletRequest req, HttpServletResponse resp) throws NumberFormatException, IOException {
		NoticeDto noticeDto = new NoticeDto();
        HttpSession session = req.getSession();
        MemberDto memberDto = (MemberDto)session.getAttribute("userinfo");
        noticeDto.setContent(req.getParameter("content"));
        noticeDto.setSubject(req.getParameter("subject"));
        noticeDto.setUserid(memberDto.getUserid());
        noticeDto.setViewcnt(0);
        noticeService.insertNotice(noticeDto);
        resp.sendRedirect(req.getContextPath() + "/notice?act=mvnoticelist");
	}
	
	
	/*
	private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PageDto pageDto = new PageDto();
		// 
		try {
			System.out.println(req.getParameter("pageNo"));
			pageDto.setPageNo(Integer.parseInt(req.getParameter("pageNo"))); 
		} catch (NumberFormatException nfe) {}
				
		try {
			req.setAttribute("result", noticeService.selectNoticeByPageNum(pageDto));
			req.getRequestDispatcher("/view/noticeList.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		 기존 코드 
//		try {
//			List<NoticeDto> list = noticeService.selectNotice();
//			req.setAttribute("noticeList", list);
//			req.getRequestDispatcher("/view/noticeList.jsp").forward(req, resp);
//		} catch (SQLException e) {
//			// 에러 페이지 연결
//			e.printStackTrace();
//		}
	}
	*/
}


