package com.ssafy.happyhouse.repository.dao;

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

public interface DataMapper {
	List<MacDto> selectMac() throws SQLException;
	void insertMacInfo(MacInfoDto macInfoDto);

	List<StarDto> selectStar() throws SQLException;
	void insertStarInfo(StarInfoDto starInfoDto);
	
	List<StationDto> selectStation() throws SQLException;
	void insertStationInfo(StationInfoDto stationInfoDto);
	
	List<MacInfoDto> selectMacInfo() throws SQLException;
	
	List<StarInfoDto> selectStarInfo() throws SQLException;

	List<StationInfoDto> selectStationInfo() throws SQLException;
	
	List<GuDto> selectGugun() throws SQLException;
	void insertGugunScore(GuScoreDto guScoreDto);

	List<DongDto> selectDong() throws SQLException;
	void insertDongScore(DongScoreDto dongScoreDto);
	
	List<GuScoreDto> selectGugunScore() throws SQLException;
	List<DongScoreDto> selectDongScore() throws SQLException;
	void updateAptInfoScore(ScoreDto scoreDto);
}
