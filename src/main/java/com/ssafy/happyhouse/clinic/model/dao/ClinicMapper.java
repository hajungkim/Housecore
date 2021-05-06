package com.ssafy.happyhouse.clinic.model.dao;

import java.util.List;

import com.ssafy.happyhouse.clinic.model.dto.ClinicDto;

public interface ClinicMapper {
	public List<ClinicDto> selectClinic();
	public List<ClinicDto> selectClinic(String addr);	
}
