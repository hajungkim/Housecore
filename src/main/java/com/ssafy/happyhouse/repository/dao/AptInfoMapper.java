package com.ssafy.happyhouse.repository.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.repository.dto.AptInfoDto;

public interface AptInfoMapper {
	List<AptInfoDto> selectAptInfo() throws SQLException;
}
