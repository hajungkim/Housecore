package com.ssafy.happyhouse.hospital.dao;

import java.util.List;

import com.ssafy.happyhouse.hospital.dto.HospitalDto;

public interface HospitalMapper {
	public List<HospitalDto> select();
	public List<HospitalDto> select(String addr);
}
