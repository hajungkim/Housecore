package com.ssafy.happyhouse.service;


import java.util.Map;

import com.ssafy.happyhouse.repository.dto.MemberDto;

public interface MemberService {
	
	public MemberDto selectMember(String userId) throws Exception;
	
	public void insertMember(MemberDto memberDto) throws Exception;
	
	public void updateMember(MemberDto memberDto) throws Exception;
	
	public void deleteMember(MemberDto memberDto) throws Exception;
	
	MemberDto login(Map<String, String> map) throws Exception;
}
