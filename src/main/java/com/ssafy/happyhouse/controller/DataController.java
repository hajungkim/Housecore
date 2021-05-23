/* 위도, 경도 계산 페이지 */

package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.repository.dto.AptInfoDto;
import com.ssafy.happyhouse.repository.dto.DongDto;
import com.ssafy.happyhouse.repository.dto.DongScoreDto;
import com.ssafy.happyhouse.repository.dto.GuDto;
import com.ssafy.happyhouse.repository.dto.GuScoreDto;
import com.ssafy.happyhouse.repository.dto.MacInfoDto;
import com.ssafy.happyhouse.repository.dto.ScoreDto;
import com.ssafy.happyhouse.repository.dto.StarInfoDto;
import com.ssafy.happyhouse.repository.dto.StationInfoDto;
import com.ssafy.happyhouse.service.AptInfoService;
import com.ssafy.happyhouse.service.DataService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/data")
public class DataController {
	@Autowired
	DataService dataService;

	@Autowired
	AptInfoService aptInfoService;
	
	@GetMapping(value = "/aptscore")
	public void aptscore() throws Exception {
		List<GuScoreDto> guScoreList = dataService.selectGugunScore();
		List<DongScoreDto> dongScoreList = dataService.selectDongScore();
		List<AptInfoDto> aptList = aptInfoService.selectAptInfo();
		List<StarInfoDto> starList = dataService.selectStarInfo();
		List<MacInfoDto> macList = dataService.selectMacInfo();
		List<StationInfoDto> stationList = dataService.selectStationInfo();
		
		for (AptInfoDto aid : aptList) {
			Double starDis = 0.0, macDis = 0.0, stDis = 0.0;
			for (StarInfoDto sid : starList) {
				if (aid.getNo() == sid.getNo()) starDis = Double.parseDouble(sid.getDis());
			}
			for (MacInfoDto mid : macList) {
				if (aid.getNo() == mid.getNo()) macDis = Double.parseDouble(mid.getDis());
			}
			for (StationInfoDto stid : stationList) {
				if (aid.getNo() == stid.getNo()) stDis = Double.parseDouble(stid.getDis());
			}
			Double starGuScore = 0.0, macGuScore = 0.0, stGuScore = 0.0;
			for (GuScoreDto gsd : guScoreList) {
				if (gsd.getGugun().equals(aid.getGugun())) {
					Double starmid1 = (gsd.getStaravg() + gsd.getStarmin()) / 2.0;
					Double starmid2 = (gsd.getStarmax() + gsd.getStaravg()) / 2.0;
					Double macmid1 = (gsd.getMacavg() + gsd.getMacmin()) / 2.0;
					Double macmid2 = (gsd.getMacmax() + gsd.getMacavg()) / 2.0;
					Double stmid1 = (gsd.getStavg() + gsd.getStmin()) / 2.0;
					Double stmid2 = (gsd.getStmax() + gsd.getStavg()) / 2.0;
					if (starDis >= gsd.getStarmin() && starDis < starmid1) {
						starGuScore = 5.0;
					} else if (starDis >= starmid1 && starDis < gsd.getStaravg()) {
						starGuScore = 4.0;
					} else if (starDis >= gsd.getStaravg() && starDis < starmid2) {
						starGuScore = 3.0;
					} else if (starDis >= starmid2 && starDis < gsd.getStarmax()) {
						starGuScore = 2.0;
					} else {
						starGuScore = 1.0;
					}
					
					if (macDis >= gsd.getMacmin() && macDis < macmid1) {
						macGuScore = 5.0;
					} else if (macDis >= macmid1 && macDis < gsd.getMacavg()) {
						macGuScore = 4.0;
					} else if (macDis >= gsd.getMacavg() && macDis < macmid2) {
						macGuScore = 3.0;
					} else if (macDis >= macmid2 && macDis < gsd.getMacmax()) {
						macGuScore = 2.0;
					} else {
						macGuScore = 1.0;
					}
					
					if (stDis >= gsd.getStmin() && stDis < stmid1) {
						stGuScore = 5.0;
					} else if (stDis >= stmid1 && stDis < gsd.getStavg()) {
						stGuScore = 4.0;
					} else if (stDis >= gsd.getStavg() && stDis < stmid2) {
						stGuScore = 3.0;
					} else if (stDis >= stmid2 && stDis < gsd.getStmax()) {
						stGuScore = 2.0;
					} else {
						stGuScore = 1.0;
					}
				}
			}
			
			Double starDongScore = 0.0, macDongScore = 0.0, stDongScore = 0.0;
			for (DongScoreDto dsd : dongScoreList) {
				if (dsd.getDong().equals(aid.getDong())) {
					Double starmid1 = (dsd.getStaravg() + dsd.getStarmin()) / 2.0;
					Double starmid2 = (dsd.getStarmax() + dsd.getStaravg()) / 2.0;
					Double macmid1 = (dsd.getMacavg() + dsd.getMacmin()) / 2.0;
					Double macmid2 = (dsd.getMacmax() + dsd.getMacavg()) / 2.0;
					Double stmid1 = (dsd.getStavg() + dsd.getStmin()) / 2.0;
					Double stmid2 = (dsd.getStmax() + dsd.getStavg()) / 2.0;
					
					if (starDis >= dsd.getStarmin() && starDis < starmid1) {
						starDongScore = 5.0;
					} else if (starDis >= starmid1 && starDis < dsd.getStaravg()) {
						starDongScore = 4.0;
					} else if (starDis >= dsd.getStaravg() && starDis < starmid2) {
						starDongScore = 3.0;
					} else if (starDis >= starmid2 && starDis < dsd.getStarmax()) {
						starDongScore = 2.0;
					} else {
						starDongScore = 1.0;
					}
					
					if (macDis >= dsd.getMacmin() && macDis < macmid1) {
						macDongScore = 5.0;
					} else if (macDis >= macmid1 && macDis < dsd.getMacavg()) {
						macDongScore = 4.0;
					} else if (macDis >= dsd.getMacavg() && macDis < macmid2) {
						macDongScore = 3.0;
					} else if (macDis >= macmid2 && macDis < dsd.getMacmax()) {
						macDongScore = 2.0;
					} else {
						macDongScore = 1.0;
					}
					
					if (stDis >= dsd.getStmin() && stDis < stmid1) {
						stDongScore = 5.0;
					} else if (stDis >= stmid1 && stDis < dsd.getStavg()) {
						stDongScore = 4.0;
					} else if (stDis >= dsd.getStavg() && stDis < stmid2) {
						stDongScore = 3.0;
					} else if (stDis >= stmid2 && stDis < dsd.getStmax()) {
						stDongScore = 2.0;
					} else {
						stDongScore = 1.0;
					}
					
				}
				
			}
			
			// total 계산
			Double totalScore = 0.0, totalStarScore = 0.0, totalMacScore = 0.0, totalStScore = 0.0;
			totalStarScore = (starGuScore + starDongScore) / 2.0;
			totalMacScore = (macGuScore + macDongScore) / 2.0;
			totalStScore = (stGuScore + stDongScore) / 2.0;
			totalScore = Math.round(((totalStarScore + totalMacScore + totalStScore) / 3.0) * 100) / 100.0;
			
			ScoreDto scoreDto = new ScoreDto();
			scoreDto.setNo(aid.getNo());
			scoreDto.setScore(Double.toString(totalScore));
			dataService.updateAptInfoScore(scoreDto);
		}
		
	}
	
	@GetMapping(value = "/guscore")
	public void guscore() throws Exception {
		List<StarInfoDto> starList = dataService.selectStarInfo();
		List<MacInfoDto> macList = dataService.selectMacInfo();
		List<StationInfoDto> stationList = dataService.selectStationInfo();
		List<GuDto> guList = dataService.selectGugun();
		for (GuDto gu : guList) {
			GuScoreDto result = new GuScoreDto();
			result.setGugun(gu.getName());
			Double avg = 0.0, cnt = 0.0, min = Double.MAX_VALUE, max = 0.0;
			for (StarInfoDto sid : starList) {
				if (gu.getName().equals(sid.getGu())) {
					avg += Double.parseDouble(sid.getDis());
					cnt += 1.0;
					if (Double.parseDouble(sid.getDis()) < min) min = Double.parseDouble(sid.getDis());
					if (Double.parseDouble(sid.getDis()) > max) max = Double.parseDouble(sid.getDis());					
				}
			}
			avg = Math.round((avg / cnt) * 100) / 100.0;
			min = Math.round(min * 100) / 100.0;
			max = Math.round(max * 100) / 100.0;
			result.setStaravg(avg);
			result.setStarmin(min);
			result.setStarmax(max);
			
			avg = 0.0; cnt = 0.0; min = Double.MAX_VALUE; max = 0.0;
			for (MacInfoDto mid : macList) {
				if (gu.getName().equals(mid.getGu())) {
					avg += Double.parseDouble(mid.getDis());
					cnt += 1.0;
					if (Double.parseDouble(mid.getDis()) < min) min = Double.parseDouble(mid.getDis());
					if (Double.parseDouble(mid.getDis()) > max) max = Double.parseDouble(mid.getDis());					
				}
			}
			avg = Math.round((avg / cnt) * 100) / 100.0;
			min = Math.round(min * 100) / 100.0;
			max = Math.round(max * 100) / 100.0;
			result.setMacavg(avg);
			result.setMacmin(min);
			result.setMacmax(max);
			
			avg = 0.0; cnt = 0.0; min = Double.MAX_VALUE; max = 0.0;
			for (StationInfoDto stid : stationList) {
				if (gu.getName().equals(stid.getGu())) {
					avg += Double.parseDouble(stid.getDis());
					cnt += 1.0;
					if (Double.parseDouble(stid.getDis()) < min) min = Double.parseDouble(stid.getDis());
					if (Double.parseDouble(stid.getDis()) > max) max = Double.parseDouble(stid.getDis());					
				}
			}
			avg = Math.round((avg / cnt) * 100) / 100.0;
			min = Math.round(min * 100) / 100.0;
			max = Math.round(max * 100) / 100.0;
			result.setStavg(avg);
			result.setStmin(min);
			result.setStmax(max);
			
			dataService.insertGugunScore(result);
		}
		
	}
	
	@GetMapping(value = "/dongscore")
	public void dongscore() throws Exception {
		List<StarInfoDto> starList = dataService.selectStarInfo();
		List<MacInfoDto> macList = dataService.selectMacInfo();
		List<StationInfoDto> stationList = dataService.selectStationInfo();
		List<DongDto> dongList = dataService.selectDong();
		for (DongDto dong : dongList) {
			DongScoreDto result = new DongScoreDto();
			result.setDongcode(dong.getDongcode());
			result.setDong(dong.getName());
			Double avg = 0.0, cnt = 0.0, min = Double.MAX_VALUE, max = 0.0;
			for (StarInfoDto sid : starList) {
				if (dong.getName().equals(sid.getDong())) {
					avg += Double.parseDouble(sid.getDis());
					cnt += 1.0;
					if (Double.parseDouble(sid.getDis()) < min) min = Double.parseDouble(sid.getDis());
					if (Double.parseDouble(sid.getDis()) > max) max = Double.parseDouble(sid.getDis());					
				}
			}
			avg = Math.round((avg / cnt) * 100) / 100.0;
			min = Math.round(min * 100) / 100.0;
			max = Math.round(max * 100) / 100.0;
			result.setStaravg(avg);
			result.setStarmin(min);
			result.setStarmax(max);
			
			avg = 0.0; cnt = 0.0; min = Double.MAX_VALUE; max = 0.0;
			for (MacInfoDto mid : macList) {
				if (dong.getName().equals(mid.getDong())) {
					avg += Double.parseDouble(mid.getDis());
					cnt += 1.0;
					if (Double.parseDouble(mid.getDis()) < min) min = Double.parseDouble(mid.getDis());
					if (Double.parseDouble(mid.getDis()) > max) max = Double.parseDouble(mid.getDis());					
				}
			}
			avg = Math.round((avg / cnt) * 100) / 100.0;
			min = Math.round(min * 100) / 100.0;
			max = Math.round(max * 100) / 100.0;
			result.setMacavg(avg);
			result.setMacmin(min);
			result.setMacmax(max);
			
			avg = 0.0; cnt = 0.0; min = Double.MAX_VALUE; max = 0.0;
			for (StationInfoDto stid : stationList) {
				if (dong.getName().equals(stid.getDong())) {
					avg += Double.parseDouble(stid.getDis());
					cnt += 1.0;
					if (Double.parseDouble(stid.getDis()) < min) min = Double.parseDouble(stid.getDis());
					if (Double.parseDouble(stid.getDis()) > max) max = Double.parseDouble(stid.getDis());					
				}
			}
			avg = Math.round((avg / cnt) * 100) / 100.0;
			min = Math.round(min * 100) / 100.0;
			max = Math.round(max * 100) / 100.0;
			result.setStavg(avg);
			result.setStmin(min);
			result.setStmax(max);
			
			dataService.insertDongScore(result);
		}
		
	}
	
//	@GetMapping(value = "/mac")
//	public void mac() throws Exception {
//		List<MacDto> macList = dataService.selectMac();
//		List<AptInfoDto> aptList = aptInfoService.selectAptInfo();
//		MacInfoDto result = new MacInfoDto();
//		for (AptInfoDto aid : aptList) {
//			Double lat1 = Double.parseDouble(aid.getLat());
//			Double lng1 = Double.parseDouble(aid.getLng());
//			Double min = Double.MAX_VALUE;
//			MacDto macDto = new MacDto();
//			for (MacDto md : macList) {
//				Double lat2 = Double.parseDouble(md.getLat());
//				Double lng2 = Double.parseDouble(md.getLng());
//				if (distance(lat1, lng1, lat2, lng2) < min) {
//					min = distance(lat1, lng1, lat2, lng2);
//					macDto.setCode(md.getCode());
//					macDto.setName(md.getName());
//					macDto.setBranch(md.getBranch());
//					macDto.setLat(md.getLat());
//					macDto.setLng(md.getLng());
//				}
//			}
//			result.setNo(aid.getNo());
//			result.setBranch(macDto.getBranch());
//			result.setLat(macDto.getLat());
//			result.setLng(macDto.getLng());
//			result.setDis(Double.toString(min));
//			result.setGu(aid.getGugun());
//			result.setDong(aid.getDong());
//			dataService.insertMacInfo(result);
//		}
//	}
	
//	@GetMapping(value = "/star")
//	public void star() throws Exception {
//		List<StarDto> starList = dataService.selectStar();
//		List<AptInfoDto> aptList = aptInfoService.selectAptInfo();
//		StarInfoDto result = new StarInfoDto();
//		for (AptInfoDto aid : aptList) {
//			Double lat1 = Double.parseDouble(aid.getLat());
//			Double lng1 = Double.parseDouble(aid.getLng());
//			Double min = Double.MAX_VALUE;
//			StarDto starDto = new StarDto();
//			for (StarDto sd : starList) {
//				Double lat2 = Double.parseDouble(sd.getLat());
//				Double lng2 = Double.parseDouble(sd.getLng());
//				if (distance(lat1, lng1, lat2, lng2) < min) {
//					min = distance(lat1, lng1, lat2, lng2);
//					starDto.setCode(sd.getCode());
//					starDto.setName(sd.getName());
//					starDto.setBranch(sd.getBranch());
//					starDto.setLat(sd.getLat());
//					starDto.setLng(sd.getLng());
//				}
//			}
//			result.setNo(aid.getNo());
//			result.setBranch(starDto.getBranch());
//			result.setLat(starDto.getLat());
//			result.setLng(starDto.getLng());
//			result.setDis(Double.toString(min));
//			result.setGu(aid.getGugun());
//			result.setDong(aid.getDong());
//			dataService.insertStarInfo(result);
//		}
//	}
	
//	@GetMapping(value = "/station")
//	public void star() throws Exception {
//		List<StationDto> stationList = dataService.selectStation();
//		List<AptInfoDto> aptList = aptInfoService.selectAptInfo();
//		StationInfoDto result = new StationInfoDto();
//		for (AptInfoDto aid : aptList) {
//			Double lat1 = Double.parseDouble(aid.getLat());
//			Double lng1 = Double.parseDouble(aid.getLng());
//			Double min = Double.MAX_VALUE;
//			StationDto stationDto = new StationDto();
//			for (StationDto sd : stationList) {
//				Double lat2 = Double.parseDouble(sd.getLat());
//				Double lng2 = Double.parseDouble(sd.getLng());
//				if (distance(lat1, lng1, lat2, lng2) < min) {
//					min = distance(lat1, lng1, lat2, lng2);
//					stationDto.setLine(sd.getLine());
//					stationDto.setName(sd.getName());
//					stationDto.setCode(sd.getCode());
//					stationDto.setLat(sd.getLat());
//					stationDto.setLng(sd.getLng());
//				}
//			}
//			result.setNo(aid.getNo());
//			result.setLine(stationDto.getLine());
//			result.setName(stationDto.getName());
//			result.setLat(stationDto.getLat());
//			result.setLng(stationDto.getLng());
//			result.setDis(Double.toString(min));
//			result.setGu(aid.getGugun());
//			result.setDong(aid.getDong());
//			dataService.insertStationInfo(result);
//		}
//	}
	
	private double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1609.344;
        return (dist);
    }
     
    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }
    
    private double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }
}



