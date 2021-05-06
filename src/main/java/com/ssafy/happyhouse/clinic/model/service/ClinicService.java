package com.ssafy.happyhouse.clinic.model.service;

import java.util.List;

import com.ssafy.happyhouse.clinic.model.dto.ClinicDto;

public interface ClinicService {
	public List<ClinicDto> selectClinic();
	public List<ClinicDto> selectClinic(String addr);
}
