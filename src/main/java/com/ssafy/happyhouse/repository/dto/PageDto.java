package com.ssafy.happyhouse.repository.dto;

public class PageDto {
	private int pageNo; // 현재 페이지
	private int listSize; // 보여줄 사이즈
	

	public PageDto() {
		this(1, 10);
	}
	
	public PageDto(int pageNo) {
		this(pageNo, 10);
	}
	
	public PageDto(int pageNo, int listSize) {
		this.pageNo = pageNo;
		this.listSize = listSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
	public int getBegin() {
		return listSize * (pageNo - 1);
	}
}
