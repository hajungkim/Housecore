package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.repository.dto.ClinicDto;

public interface ClinicService {
	public List<ClinicDto> selectClinic();
	public List<ClinicDto> selectClinic(String addr);
}
