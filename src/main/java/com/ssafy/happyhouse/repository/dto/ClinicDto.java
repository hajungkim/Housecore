package com.ssafy.happyhouse.repository.dto;

public class ClinicDto {
	private int no;
	private String datetime;
	private String sample_collection;
	private String city;
	private String gugun;
	private String clinic_title;
	private String address;
	private String daily_operating_time;
	private String sat_operating_time;
	private String sun_operating_time;
	private String tel;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getSample_collection() {
		return sample_collection;
	}
	public void setSample_collection(String sample_collection) {
		this.sample_collection = sample_collection;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getClinic_title() {
		return clinic_title;
	}
	public void setClinic_title(String clinic_title) {
		this.clinic_title = clinic_title;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDaily_operating_time() {
		return daily_operating_time;
	}
	public void setDaily_operating_time(String daily_operating_time) {
		this.daily_operating_time = daily_operating_time;
	}
	public String getSat_operating_time() {
		return sat_operating_time;
	}
	public void setSat_operating_time(String sat_operating_time) {
		this.sat_operating_time = sat_operating_time;
	}
	public String getSun_operating_time() {
		return sun_operating_time;
	}
	public void setSun_operating_time(String sun_operating_time) {
		this.sun_operating_time = sun_operating_time;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
