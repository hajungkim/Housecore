package com.ssafy.happyhouse.aptdeal.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.aptdeal.model.dto.AptDealDto;
import com.ssafy.happyhouse.common.dto.PageDto;
import com.ssafy.happyhouse.common.dto.SearchDto;

public interface AptDealDao {
	public List<AptDealDto> selectAptDeal(PageDto pageDto) throws SQLException;
	public List<AptDealDto> selectAptDeal(SearchDto searchDto) throws SQLException;
	public String selectDongName(String dongcode) throws SQLException;
	public int selectAptCount() throws SQLException;
	public int selectAptCount(SearchDto searchDto) throws SQLException;
}
