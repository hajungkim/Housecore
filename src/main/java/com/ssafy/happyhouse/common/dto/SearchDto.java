package com.ssafy.happyhouse.common.dto;

public class SearchDto {
	private int pageNo;
	private String dongcode;
	private String dongname;
	
	public int getPageNo() {
		return pageNo;
	}
	public String getDongname() {
		return dongname;
	}
	public void setDongname(String dongname) {
		this.dongname = dongname;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public String getDongcode() {
		return dongcode;
	}
	public void setDongcode(String dongcode) {
		this.dongcode = dongcode;
	}
	
}
