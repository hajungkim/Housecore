package com.ssafy.happyhouse.repository.dto;

public class MacInfoDto {
	private int no;
	private String branch;
	private String lng;
	private String lat;
	private String dis;
	private String gu;
	private String dong;
	
	public MacInfoDto() {}
	
	public MacInfoDto(int no, String branch, String lng, String lat, String dis, String gu, String dong) {
		super();
		this.no = no;
		this.branch = branch;
		this.lng = lng;
		this.lat = lat;
		this.dis = dis;
		this.gu = gu;
		this.dong = dong;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public String getDis() {
		return dis;
	}
	public void setDis(String dis) {
		this.dis = dis;
	}
	public String getGu() {
		return gu;
	}
	public void setGu(String gu) {
		this.gu = gu;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	
}
