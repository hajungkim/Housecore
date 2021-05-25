package com.ssafy.happyhouse.repository.dao;

import java.sql.SQLException;
import java.util.Map;

import com.ssafy.happyhouse.repository.dto.MemberDto;

public interface MemberMapper {
	
	MemberDto login(MemberDto memberDto) throws SQLException;

	MemberDto selectMember(String userid) throws SQLException;
	
	void insertMember(MemberDto memberDto) throws SQLException;
	
	void updateMember(MemberDto memberDto) throws SQLException;
	
	void deleteMember(MemberDto memberDto) throws SQLException;
	
}
