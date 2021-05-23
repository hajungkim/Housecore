package com.ssafy.happyhouse.repository.dto;

import java.sql.Timestamp;

public class QnADto {
	private int no;
	private String customerId;
	private String content;
	private String adminId;
	private String category;
	private String title;
	private Timestamp registTime;
	
	public QnADto(String customerId, String content, String adminId, String category, String title) {
		super();
		this.customerId = customerId;
		this.content = content;
		this.adminId = adminId;
		this.category = category;
		this.title = title;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getRegistTime() {
		return registTime;
	}

	public void setRegistTime(Timestamp registTime) {
		this.registTime = registTime;
	}

	@Override
	public String toString() {
		return "QnADto [no=" + no + ", customerId=" + customerId + ", content=" + content + ", adminId=" + adminId
				+ ", category=" + category + ", title=" + title + ", registTime=" + registTime + "]";
	}
	
	
	
}
