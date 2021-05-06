package com.ssafy.happyhouse.hospital.service;

import java.util.List;

import com.ssafy.happyhouse.hospital.dto.HospitalDto;

public interface HospitalService {
	public List<HospitalDto> select();
	public List<HospitalDto> select(String addr);
}
