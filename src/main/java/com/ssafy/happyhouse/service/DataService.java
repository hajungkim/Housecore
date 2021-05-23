package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;

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

public interface DataService {
	public List<MacDto> selectMac() throws SQLException;
	public void insertMacInfo(MacInfoDto macInfoDto);
	
	public List<StarDto> selectStar() throws SQLException;
	public void insertStarInfo(StarInfoDto starInfoDto);

	public List<StationDto> selectStation() throws SQLException;
	public void insertStationInfo(StationInfoDto stationInfoDto);
	
	public List<MacInfoDto> selectMacInfo() throws SQLException;
	public List<StarInfoDto> selectStarInfo() throws SQLException;
	public List<StationInfoDto> selectStationInfo() throws SQLException;
	
	public List<GuDto> selectGugun() throws SQLException;
	public void insertGugunScore(GuScoreDto guScoreDto);

	public List<DongDto> selectDong() throws SQLException;
	public void insertDongScore(DongScoreDto dongScoreDto);
	
	public List<GuScoreDto> selectGugunScore() throws SQLException;
	public List<DongScoreDto> selectDongScore() throws SQLException;
	public void updateAptInfoScore(ScoreDto scoreDto);
}
