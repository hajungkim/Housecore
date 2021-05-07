package com.ssafy.happyhouse.repository.dao;

import com.ssafy.happyhouse.repository.dto.AirEnvDto;

public interface AirEnvMapper {
	public AirEnvDto selectEnv(String gugun);
}
