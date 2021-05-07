package com.ssafy.happyhouse.repository.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.repository.dto.AptDealDto;
import com.ssafy.happyhouse.repository.dto.PageDto;
import com.ssafy.happyhouse.repository.dto.SearchDto;

public interface AptDealMapper {
	public List<AptDealDto> selectAptDeal(PageDto pageDto) throws SQLException;
	public List<AptDealDto> selectAptDealBySearch(SearchDto searchDto) throws SQLException;
	public String selectDongName(String dongcode) throws SQLException;
	public int selectAptCount() throws SQLException;
	public int selectAptCountBySearch(SearchDto searchDto) throws SQLException;
}
