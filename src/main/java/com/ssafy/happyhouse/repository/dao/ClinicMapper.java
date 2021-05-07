package com.ssafy.happyhouse.repository.dao;

import java.util.List;

import com.ssafy.happyhouse.repository.dto.ClinicDto;

public interface ClinicMapper {
	public List<ClinicDto> selectClinic();
	public List<ClinicDto> selectClinic(String addr);	
}
