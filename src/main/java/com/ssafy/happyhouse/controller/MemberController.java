package com.ssafy.happyhouse.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.repository.dto.MemberDto;
import com.ssafy.happyhouse.service.MemberService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@ApiOperation(value = "로그인 미완성 ~~")
	@PostMapping(value = "/login")
	public void login(@RequestParam String userid, @RequestParam String passwd) {
		System.out.println(userid);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("passwd", passwd);
		
	}
	
	@ApiOperation(value = "회원가입시 멤버 추가")
	@PostMapping(value = "/insert")
	public void insert(MemberDto memberDto) throws Exception {
		memberService.insertMember(memberDto);
	}
	
	@ApiOperation(value = "회원정보 업데이트")
	@PostMapping(value = "/update")
	public void update(MemberDto memberDto) throws Exception {
		memberService.updateMember(memberDto);
	}
	
	@ApiOperation(value = "회원정보 삭제(탈퇴)")
	@GetMapping(value = "/delete")
	public void delete(MemberDto memberDto, Model model) throws Exception {
		memberService.deleteMember(memberDto);
	}

}

