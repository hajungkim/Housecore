package com.ssafy.happyhouse.repository.dto;

public class AirEnvDto {
	private int no;
	private long datetime;
	private String area;
	private String gugun;
	private int fine_dust;
	private double ultrafine_dust;
	private double ozone;
	private double no_ppm;
	private double co_ppm;
	private double so2_ppm;
	private String airenv_grade;
	private int total_grade;
	private String matter;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public long getDatetime() {
		return datetime;
	}
	public void setDatetime(long datetime) {
		this.datetime = datetime;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public int getFine_dust() {
		return fine_dust;
	}
	public void setFine_dust(int fine_dust) {
		this.fine_dust = fine_dust;
	}
	public double getUltrafine_dust() {
		return ultrafine_dust;
	}
	public void setUltrafine_dust(double ultrafine_dust) {
		this.ultrafine_dust = ultrafine_dust;
	}
	public double getOzone() {
		return ozone;
	}
	public void setOzone(double ozone) {
		this.ozone = ozone;
	}
	public double getNo_ppm() {
		return no_ppm;
	}
	public void setNo_ppm(double no_ppm) {
		this.no_ppm = no_ppm;
	}
	public double getCo_ppm() {
		return co_ppm;
	}
	public void setCo_ppm(double co_ppm) {
		this.co_ppm = co_ppm;
	}
	public double getSo2_ppm() {
		return so2_ppm;
	}
	public void setSo2_ppm(double so2_ppm) {
		this.so2_ppm = so2_ppm;
	}
	public String getAirenv_grade() {
		return airenv_grade;
	}
	public void setAirenv_grade(String airenv_grade) {
		this.airenv_grade = airenv_grade;
	}
	public int getTotal_grade() {
		return total_grade;
	}
	public void setTotal_grade(int total_grade) {
		this.total_grade = total_grade;
	}
	public String getMatter() {
		return matter;
	}
	public void setMatter(String matter) {
		this.matter = matter;
	}
}
