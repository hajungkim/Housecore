package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.repository.dto.AptInfoDto;

public interface AptInfoService {
	List<AptInfoDto>  selectAptInfo() throws SQLException;
}
