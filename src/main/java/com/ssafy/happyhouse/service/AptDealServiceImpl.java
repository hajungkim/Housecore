package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.repository.dao.AptDealMapper;
import com.ssafy.happyhouse.repository.dto.AptDealDto;
import com.ssafy.happyhouse.repository.dto.PageDto;
import com.ssafy.happyhouse.repository.dto.PageResultDto;
import com.ssafy.happyhouse.repository.dto.SearchDto;

@Service
public class AptDealServiceImpl implements AptDealService {
	
	@Autowired
	private AptDealMapper aptDealMapper;

	@Override
	public List<AptDealDto> selectAptDeal(int no) throws SQLException {
		return aptDealMapper.selectAptDeal(no);
	}

}
