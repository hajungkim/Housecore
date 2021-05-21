package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.repository.dto.AptDealDto;

public interface AptDealService {
	public List<AptDealDto> selectAptDeal(int no) throws SQLException;
}
