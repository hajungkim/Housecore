package com.ssafy.happyhouse.airenv.model.dao;

import com.ssafy.happyhouse.airenv.model.dto.AirEnvDto;

public interface AirEnvDao {
	public AirEnvDto selectEnv(String gugun);
}
