package com.ssafy.happyhouse.service;


import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.repository.dto.MemberDto;

public interface MemberService {
	
	public MemberDto login(MemberDto memberDto) throws Exception;
	
	public List<MemberDto> selectAllMember() throws SQLException;
	
	public MemberDto selectMember(String userId) throws Exception;
	
	public void insertMember(MemberDto memberDto) throws Exception;
	
	public void updateMember(MemberDto memberDto) throws Exception;
	
	public void deleteMember(String userId) throws Exception;
	
}
