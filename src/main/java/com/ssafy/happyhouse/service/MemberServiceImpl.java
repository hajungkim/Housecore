package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.repository.dao.MemberMapper;
import com.ssafy.happyhouse.repository.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {
	
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public List<MemberDto> selectAllMember() throws SQLException {
		return memberMapper.selectAllMember();
	}
	
	@Override
	public MemberDto selectMember(String userId) throws Exception {
		return memberMapper.selectMember(userId);
	}

	@Override
	public void insertMember(MemberDto memberDto) throws Exception {
		memberMapper.insertMember(memberDto);
	}

	@Override
	public void updateMember(MemberDto memberDto) throws Exception {
		memberMapper.updateMember(memberDto);
	}

	@Override
	public void deleteMember(String userId) throws Exception {
		memberMapper.deleteMember(userId);
	}

	@Override
	public MemberDto login(MemberDto memberDto) throws Exception {
		if (memberDto.getUserid() == null || memberDto.getPasswd() == null) {
			return null;
		}
		return memberMapper.login(memberDto);
	}

}
