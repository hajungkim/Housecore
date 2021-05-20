package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.repository.dao.AptInfoMapper;
import com.ssafy.happyhouse.repository.dto.AptInfoDto;

@Service
public class AptInfoServiceImpl implements AptInfoService {
	
	@Autowired
	private AptInfoMapper aptInfoMapper;

	@Override
	public List<AptInfoDto> selectAptInfo() throws SQLException {
		return aptInfoMapper.selectAptInfo();
	}

}
