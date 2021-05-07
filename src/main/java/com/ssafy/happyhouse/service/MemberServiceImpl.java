package com.ssafy.happyhouse.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.repository.dao.MemberMapper;
import com.ssafy.happyhouse.repository.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
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
	public void deleteMember(MemberDto memberDto) throws Exception {
		memberMapper.updateMember(memberDto);
	}

	@Override
	public MemberDto login(Map<String, String> map) throws Exception {
		if (map.get("userid") == null || map.get("passwd") == null) {
			return null;
		}
		return memberMapper.login(map);
	}
}
