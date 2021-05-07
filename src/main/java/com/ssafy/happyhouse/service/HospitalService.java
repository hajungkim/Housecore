package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.repository.dto.HospitalDto;

public interface HospitalService {
	public List<HospitalDto> select();
	public List<HospitalDto> select(String addr);
}
