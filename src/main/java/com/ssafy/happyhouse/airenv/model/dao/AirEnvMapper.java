package com.ssafy.happyhouse.airenv.model.dao;

import com.ssafy.happyhouse.airenv.model.dto.AirEnvDto;

public interface AirEnvMapper {
	public AirEnvDto selectEnv(String gugun);
}
