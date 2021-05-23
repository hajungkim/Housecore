package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.repository.dto.AptInfoDto;
import com.ssafy.happyhouse.repository.dto.DataDto;
import com.ssafy.happyhouse.repository.dto.DongScoreDto;
import com.ssafy.happyhouse.repository.dto.GuScoreDto;
import com.ssafy.happyhouse.repository.dto.MacInfoDto;
import com.ssafy.happyhouse.repository.dto.StarInfoDto;
import com.ssafy.happyhouse.repository.dto.StationInfoDto;
import com.ssafy.happyhouse.service.AptInfoService;
import com.ssafy.happyhouse.service.DataService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/scoredetail")
public class DataController {
	@Autowired
	DataService dataService;

	@Autowired
	AptInfoService aptInfoService;
	
	@ApiOperation(value = "아파트 no을 파라미터로 보내면 디테일 정보 반환", response = DataDto.class)
	@GetMapping("{no}")
	public ResponseEntity<DataDto> scoreDetail(@PathVariable("no") int no) throws Exception {
		DataDto dataDto = new DataDto();
		MacInfoDto macInfoDto = dataService.selectMacInfo(no);
		StarInfoDto starInfoDto = dataService.selectStarInfo(no);
		StationInfoDto stationInfoDto = dataService.selectStationInfo(no);
		dataDto.setMacBranch(macInfoDto.getBranch());
		dataDto.setMacLat(macInfoDto.getLat());
		dataDto.setMacLng(macInfoDto.getLng());
		dataDto.setMacDistance(macInfoDto.getDis());
		dataDto.setStarBranch(starInfoDto.getBranch());
		dataDto.setStarLat(starInfoDto.getLat());
		dataDto.setStarLng(starInfoDto.getLng());
		dataDto.setStarDistance(starInfoDto.getDis());
		dataDto.setStLine(stationInfoDto.getLine());
		dataDto.setStName(stationInfoDto.getName());
		dataDto.setStLat(stationInfoDto.getLat());
		dataDto.setStLng(stationInfoDto.getLng());
		dataDto.setStDistance(stationInfoDto.getDis());
		
		List<GuScoreDto> guScoreList = dataService.selectGugunScore();
		List<DongScoreDto> dongScoreList = dataService.selectDongScore();
		List<AptInfoDto> aptList = aptInfoService.selectAptInfo();
		String gu= "", dong="";
		for (AptInfoDto aid : aptList) {
			System.out.println(aid.getGugun());
			if (aid.getNo() == no) {
				gu = aid.getGugun();
				dong = aid.getDong();
				break;
			}
		}
		for (GuScoreDto gsd : guScoreList) {
			if (gsd.getGugun().equals(gu)) {
				dataDto.setGuGun(gu);
				dataDto.setGuMacAvg(Double.toString(gsd.getMacavg()));
				dataDto.setGuStarAvg(Double.toString(gsd.getStaravg()));
				dataDto.setGuStAvg(Double.toString(gsd.getStavg()));
				break;
			}
		}
		for (DongScoreDto dsd : dongScoreList) {
			if (dsd.getDong().equals(dong)) {
				dataDto.setDong(dong);
				dataDto.setDongMacAvg(Double.toString(dsd.getMacavg()));
				dataDto.setDongStarAvg(Double.toString(dsd.getStaravg()));
				dataDto.setDongStAvg(Double.toString(dsd.getStavg()));
			}
		}
		
		return new ResponseEntity<DataDto>(dataDto, HttpStatus.OK);
	}

}



