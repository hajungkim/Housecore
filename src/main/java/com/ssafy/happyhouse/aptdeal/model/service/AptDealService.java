package com.ssafy.happyhouse.aptdeal.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.aptdeal.model.dto.AptDealDto;
import com.ssafy.happyhouse.common.dto.PageDto;
import com.ssafy.happyhouse.common.dto.SearchDto;

public interface AptDealService {
	public Map<String, Object> selectAptDeal(PageDto pageDto) throws SQLException;
	public Map<String, Object> selectAptDeal(SearchDto searchDto, PageDto pageDto) throws SQLException;
}
