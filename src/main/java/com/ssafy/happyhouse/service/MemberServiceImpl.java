package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.repository.dao.MemberDaoImpl;
import com.ssafy.happyhouse.repository.dao.MemberMapper;
import com.ssafy.happyhouse.repository.dto.MemberDto;


public class MemberServiceImpl implements MemberService {
	private MemberMapper memberDao;
	private static MemberServiceImpl memberServiceImpl;
	
	private MemberServiceImpl() {
		memberDao = MemberDaoImpl.getMemberDaoImpl();
	}
	
	public static MemberServiceImpl getMemberServiceImpl() {
		if (memberServiceImpl == null)
			memberServiceImpl = new MemberServiceImpl();
		return memberServiceImpl;
	}
	
	@Override
	public MemberDto selectMember(String userId) throws Exception {
		return memberDao.selectMember(userId);
	}

	@Override
	public void insertMember(MemberDto memberDto) throws Exception {
		memberDao.insertMember(memberDto);
	}

	@Override
	public void updateMember(MemberDto memberDto) throws Exception {
		memberDao.updateMember(memberDto);
	}

	@Override
	public void deleteMember(MemberDto memberDto) throws Exception {
		memberDao.deleteMember(memberDto);
	}

	@Override
	public MemberDto login(MemberDto memberDto) throws Exception {
		return memberDao.login(memberDto);
	}
}
