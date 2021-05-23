package com.ssafy.happyhouse.repository.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.repository.dto.DongScoreDto;
import com.ssafy.happyhouse.repository.dto.GuScoreDto;
import com.ssafy.happyhouse.repository.dto.MacInfoDto;
import com.ssafy.happyhouse.repository.dto.StarInfoDto;
import com.ssafy.happyhouse.repository.dto.StationInfoDto;

public interface DataMapper {

	MacInfoDto selectMacInfo(int no) throws SQLException;
	StarInfoDto selectStarInfo(int no) throws SQLException;
	StationInfoDto selectStationInfo(int no) throws SQLException;
	
	List<GuScoreDto> selectGugunScore() throws SQLException;
	List<DongScoreDto> selectDongScore() throws SQLException;
}
