package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.repository.dto.MemberDto;
import com.ssafy.happyhouse.repository.dto.NoticeDto;
import com.ssafy.happyhouse.service.JwtService;
import com.ssafy.happyhouse.service.MemberService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private JwtService jwtService;

	@Autowired
	MemberService memberService;
	
	@ApiOperation(value = "jwt 토큰 이용해 로그인")
	@PostMapping("login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody MemberDto memberDto) {
		System.out.println(memberDto.getPasswd());
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			MemberDto loginUser = memberService.login(memberDto);
			
			if(loginUser != null) {
				String token = jwtService.create(loginUser);
				resultMap.put("auth-token", token);
				resultMap.put("user-id", loginUser.getUserid());
				resultMap.put("user-name", loginUser.getUsername());
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", "로그인 실패");
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@ApiOperation(value = "아이디로 회원정보 가져오기")
	@GetMapping("{userId}")
	public ResponseEntity<MemberDto> select(@PathVariable("userId") String userId) throws Exception {
		return new ResponseEntity<MemberDto>(memberService.selectMember(userId), HttpStatus.OK);
	}
	
	@ApiOperation(value = "회원가입시 멤버 추가")
	@PostMapping("insert")
	public void insert(@RequestBody MemberDto memberDto) throws Exception {
		memberService.insertMember(memberDto);
	}
	
	@ApiOperation(value = "회원정보 업데이트")
	@PutMapping
	public void update(@RequestBody MemberDto memberDto) throws Exception {
		memberService.updateMember(memberDto);
	}
	
	@ApiOperation(value = "회원정보 삭제(탈퇴)")
	@DeleteMapping
	public void delete(@RequestBody MemberDto memberDto) throws Exception {
		memberService.deleteMember(memberDto);
	}

}

