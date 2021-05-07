package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.repository.dao.AptDealDaoImpl;
import com.ssafy.happyhouse.repository.dao.AptDealMapper;
import com.ssafy.happyhouse.repository.dto.AptDealDto;
import com.ssafy.happyhouse.repository.dto.PageDto;
import com.ssafy.happyhouse.repository.dto.PageResultDto;
import com.ssafy.happyhouse.repository.dto.SearchDto;

public class AptDealServiceImpl implements AptDealService {
	private AptDealMapper aptDealDao;
	
	public AptDealServiceImpl() {
		super();
		this.aptDealDao = new AptDealDaoImpl();
	}

	@Override
	public Map<String, Object> selectAptDeal(PageDto pageDto) throws SQLException {
		Map<String, Object> map = new HashMap<>();
		map.put("list", aptDealDao.selectAptDeal(pageDto));
		
		int count = aptDealDao.selectAptCount();
		//System.out.println("0카운트 갯수 : " + count);
		PageResultDto prd = new PageResultDto(pageDto.getPageNo(), count, pageDto.getListSize());
		map.put("pageResult", prd);
		return map;
	}

	@Override
	public Map<String, Object> selectAptDeal(SearchDto searchDto, PageDto pageDto) throws SQLException {
		// 동 코드로 동이름 가져오기
		String dongName = aptDealDao.selectDongName(searchDto.getDongcode());
		searchDto.setDongname(dongName);
		searchDto.setPageNo(pageDto.getPageNo());
		// 동 이름으로 검색
		Map<String, Object> map = new HashMap<>();
		map.put("list", aptDealDao.selectAptDeal(searchDto));
		
		// 게시물 전체 갯수
		int count = aptDealDao.selectAptCount(searchDto);
		//System.out.println("1카운트 갯수 : " + count);
		PageResultDto prd = new PageResultDto(pageDto.getPageNo(), count, pageDto.getListSize());
		
		map.put("pageResult", prd);
		return map;
	}

}
