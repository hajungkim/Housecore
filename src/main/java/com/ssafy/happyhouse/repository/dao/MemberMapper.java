package com.ssafy.happyhouse.repository.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.repository.dto.MemberDto;

public interface MemberMapper {
	
	MemberDto login(MemberDto memberDto) throws SQLException;
	
	List<MemberDto> selectAllMember() throws SQLException;
	
	MemberDto selectMember(String userid) throws SQLException;
	
	void insertMember(MemberDto memberDto) throws SQLException;
	
	void updateMember(MemberDto memberDto) throws SQLException;
	
	void deleteMember(String userid) throws SQLException;
	
}
