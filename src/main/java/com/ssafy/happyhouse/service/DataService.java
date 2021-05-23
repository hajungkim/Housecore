package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.repository.dto.DongScoreDto;
import com.ssafy.happyhouse.repository.dto.GuScoreDto;
import com.ssafy.happyhouse.repository.dto.MacInfoDto;
import com.ssafy.happyhouse.repository.dto.StarInfoDto;
import com.ssafy.happyhouse.repository.dto.StationInfoDto;

public interface DataService {

	public MacInfoDto selectMacInfo(int no) throws SQLException;
	public StarInfoDto selectStarInfo(int no) throws SQLException;
	public StationInfoDto selectStationInfo(int no) throws SQLException;

	public List<GuScoreDto> selectGugunScore() throws SQLException;
	public List<DongScoreDto> selectDongScore() throws SQLException;
}
