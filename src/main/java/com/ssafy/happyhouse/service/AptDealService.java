package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.repository.dto.AptDealDto;
import com.ssafy.happyhouse.repository.dto.PageDto;
import com.ssafy.happyhouse.repository.dto.SearchDto;

public interface AptDealService {
	public Map<String, Object> selectAptDeal(PageDto pageDto) throws SQLException;
	public Map<String, Object> selectAptDealBySearch(SearchDto searchDto, PageDto pageDto) throws SQLException;
}
