package com.ssafy.happyhouse.repository.dao;

import com.ssafy.happyhouse.repository.dto.MemberDto;

public interface MemberMapper {

	public MemberDto selectMember(String userid) throws Exception;
	
	public void insertMember(MemberDto memberDto) throws Exception;
	
	public void updateMember(MemberDto memberDto) throws Exception;
	
	public void deleteMember(MemberDto memberDto) throws Exception;
	
	public MemberDto login(MemberDto memberDto) throws Exception;
}
