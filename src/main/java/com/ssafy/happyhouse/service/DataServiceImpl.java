package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.repository.dao.DataMapper;
import com.ssafy.happyhouse.repository.dto.DongScoreDto;
import com.ssafy.happyhouse.repository.dto.GuScoreDto;
import com.ssafy.happyhouse.repository.dto.MacInfoDto;
import com.ssafy.happyhouse.repository.dto.StarInfoDto;
import com.ssafy.happyhouse.repository.dto.StationInfoDto;

@Service
public class DataServiceImpl implements DataService {
	
	@Autowired
	private DataMapper dataMapper;

	@Override
	public MacInfoDto selectMacInfo(int no) throws SQLException {
		return dataMapper.selectMacInfo(no);
	}

	@Override
	public StarInfoDto selectStarInfo(int no) throws SQLException {
		return dataMapper.selectStarInfo(no);
	}

	@Override
	public StationInfoDto selectStationInfo(int no) throws SQLException {
		return dataMapper.selectStationInfo(no);
	}

	@Override
	public List<GuScoreDto> selectGugunScore() throws SQLException {
		return dataMapper.selectGugunScore();
	}
	
	@Override
	public List<DongScoreDto> selectDongScore() throws SQLException {
		return dataMapper.selectDongScore();
	}
	
}
