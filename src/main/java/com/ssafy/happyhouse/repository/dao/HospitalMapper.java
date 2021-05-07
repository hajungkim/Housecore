package com.ssafy.happyhouse.repository.dao;

import java.util.List;

import com.ssafy.happyhouse.repository.dto.HospitalDto;

public interface HospitalMapper {
	public List<HospitalDto> select();
	public List<HospitalDto> select(String addr);
}
