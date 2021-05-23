package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.repository.dao.DataMapper;
import com.ssafy.happyhouse.repository.dto.DongDto;
import com.ssafy.happyhouse.repository.dto.DongScoreDto;
import com.ssafy.happyhouse.repository.dto.GuDto;
import com.ssafy.happyhouse.repository.dto.GuScoreDto;
import com.ssafy.happyhouse.repository.dto.MacDto;
import com.ssafy.happyhouse.repository.dto.MacInfoDto;
import com.ssafy.happyhouse.repository.dto.ScoreDto;
import com.ssafy.happyhouse.repository.dto.StarDto;
import com.ssafy.happyhouse.repository.dto.StarInfoDto;
import com.ssafy.happyhouse.repository.dto.StationDto;
import com.ssafy.happyhouse.repository.dto.StationInfoDto;

@Service
public class DataServiceImpl implements DataService {
	
	@Autowired
	private DataMapper dataMapper;

	@Override
	public List<MacDto> selectMac() throws SQLException {
		return dataMapper.selectMac();
	}

	@Override
	public void insertMacInfo(MacInfoDto macInfoDto) {
		dataMapper.insertMacInfo(macInfoDto);
	}

	@Override
	public List<StarDto> selectStar() throws SQLException {
		return dataMapper.selectStar();
	}

	@Override
	public void insertStarInfo(StarInfoDto starInfoDto) {
		dataMapper.insertStarInfo(starInfoDto);
	}

	@Override
	public List<StationDto> selectStation() throws SQLException {
		return dataMapper.selectStation();
	}

	@Override
	public void insertStationInfo(StationInfoDto stationInfoDto) {
		dataMapper.insertStationInfo(stationInfoDto);
	}


	@Override
	public List<MacInfoDto> selectMacInfo() throws SQLException {
		return dataMapper.selectMacInfo();
	}

	@Override
	public List<StarInfoDto> selectStarInfo() throws SQLException {
		return dataMapper.selectStarInfo();
	}

	@Override
	public List<StationInfoDto> selectStationInfo() throws SQLException {
		return dataMapper.selectStationInfo();
	}
	
	@Override
	public List<GuDto> selectGugun() throws SQLException {
		return dataMapper.selectGugun();
	}
	
	@Override
	public void insertGugunScore(GuScoreDto guScoreDto) {
		dataMapper.insertGugunScore(guScoreDto);
	}

	@Override
	public List<DongDto> selectDong() throws SQLException {
		return dataMapper.selectDong();
	}

	@Override
	public void insertDongScore(DongScoreDto dongScoreDto) {
		dataMapper.insertDongScore(dongScoreDto);
	}

	@Override
	public List<GuScoreDto> selectGugunScore() throws SQLException {
		return dataMapper.selectGugunScore();
	}

	@Override
	public List<DongScoreDto> selectDongScore() throws SQLException {
		return dataMapper.selectDongScore();
	}

	@Override
	public void updateAptInfoScore(ScoreDto scoreDto) {
		dataMapper.updateAptInfoScore(scoreDto);
	}
}
