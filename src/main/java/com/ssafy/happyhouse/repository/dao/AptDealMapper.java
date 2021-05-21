package com.ssafy.happyhouse.repository.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.repository.dto.AptDealDto;
import com.ssafy.happyhouse.repository.dto.PageDto;
import com.ssafy.happyhouse.repository.dto.SearchDto;

public interface AptDealMapper {
	List<AptDealDto> selectAptDeal(int no) throws SQLException;
}
