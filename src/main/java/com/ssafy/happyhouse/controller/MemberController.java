package com.ssafy.happyhouse.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.happyhouse.repository.dto.MemberDto;
import com.ssafy.happyhouse.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	MemberService memberService;
	
	@GetMapping(value = "/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping(value = "/login")
	public String login(@RequestParam String userid, @RequestParam String passwd, Model model, HttpSession session, HttpServletResponse response) {
		System.out.println(userid);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("passwd", passwd);
		try {
			MemberDto memberDto = memberService.login(map);
			if (memberDto != null) {
				session.setAttribute("userinfo", memberDto);
			} else {
				model.addAttribute("msg", "로그인 중 문제가 발생했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "로그인 중 문제가 발생했습니다.");
			return "error";
		}

		return "index";
	}
	
	@GetMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping(value = "/select")
	public String select() {
		return "";
	}
	
	@PostMapping(value = "/insert")
	public String insert(MemberDto memberDto, Model model) {
		try {
			memberService.insertMember(memberDto);
			return "index";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "회원가입 중 문제가 발생했습니다.");
			return "error";
		}
	}
	
	@PostMapping(value = "/update")
	public String update(MemberDto memberDto, Model model) {
		try {
			memberService.updateMember(memberDto);
			return "index";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "회원정보 수정 중 문제가 발생했습니다.");
			return "error";
		}
	}
	
	@GetMapping(value = "/delete")
	public String delete(MemberDto memberDto, Model model) {
		try {
			memberService.deleteMember(memberDto);
			return "index";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "회원정보 삭제 중 문제가 발생했습니다.");
			return "error";
		}
	}

}

