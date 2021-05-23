package com.ssafy.happyhouse.repository.dto;

public class MacDto {
	private String code;
	private String name;
	private String branch;
	private String lng;
	private String lat;
	public MacDto() {}
	public MacDto(String code, String name, String branch, String lng, String lat) {
		super();
		this.code = code;
		this.name = name;
		this.branch = branch;
		this.lng = lng;
		this.lat = lat;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	
}
