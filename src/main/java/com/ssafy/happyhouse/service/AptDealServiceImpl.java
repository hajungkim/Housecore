package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.repository.dao.AptDealDaoImpl;
import com.ssafy.happyhouse.repository.dao.AptDealMapper;
import com.ssafy.happyhouse.repository.dto.PageDto;
import com.ssafy.happyhouse.repository.dto.PageResultDto;
import com.ssafy.happyhouse.repository.dto.SearchDto;

@Service
public class AptDealServiceImpl implements AptDealService {
	
	@Autowired
	private AptDealMapper aptDealMapper;

	@Override
	public Map<String, Object> selectAptDeal(PageDto pageDto) throws SQLException {
		Map<String, Object> map = new HashMap<>();
		map.put("list", aptDealMapper.selectAptDeal(pageDto));
		
		int count = aptDealMapper.selectAptCount();
		PageResultDto prd = new PageResultDto(pageDto.getPageNo(), count, pageDto.getListSize());
		map.put("pageResult", prd);
		return map;
	}

	@Override
	public Map<String, Object> selectAptDealBySearch(SearchDto searchDto, PageDto pageDto) throws SQLException {
		// 동 코드로 동이름 가져오기
		String dongName = aptDealMapper.selectDongName(searchDto.getDongcode());
		
		if (dongName == null) return null;	// 검색한 동이름이 DB에 없을 경우
		
		searchDto.setDongname(dongName);
		searchDto.setPageNo(pageDto.getPageNo());
		// 동이름으로 검색
		Map<String, Object> map = new HashMap<>();
		map.put("list", aptDealMapper.selectAptDealBySearch(searchDto));
		
		// 게시물 전체 갯수
		int count = aptDealMapper.selectAptCountBySearch(searchDto);
		PageResultDto prd = new PageResultDto(pageDto.getPageNo(), count, pageDto.getListSize());
		
		map.put("pageResult", prd);
		return map;
	}

}
