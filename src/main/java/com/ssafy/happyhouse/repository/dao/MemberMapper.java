package com.ssafy.happyhouse.repository.dao;

import java.sql.SQLException;
import java.util.Map;

import com.ssafy.happyhouse.repository.dto.MemberDto;

public interface MemberMapper {

public MemberDto selectMember(String userid) throws SQLException;
	
	public void insertMember(MemberDto memberDto) throws SQLException;
	
	public void updateMember(MemberDto memberDto) throws SQLException;
	
	public void deleteMember(MemberDto memberDto) throws SQLException;
	
	public MemberDto login(Map<String, String> map) throws SQLException;
	
}
