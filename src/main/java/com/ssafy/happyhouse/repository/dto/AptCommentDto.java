package com.ssafy.happyhouse.repository.dto;

import java.sql.Timestamp;

public class AptCommentDto {
	private int no;
	private int aptno;
	private String nickname;
	private String content;
	private Timestamp regtime;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getAptno() {
		return aptno;
	}
	public void setAptno(int aptno) {
		this.aptno = aptno;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getRegtime() {
		return regtime;
	}
	public void setRegtime(Timestamp regtime) {
		this.regtime = regtime;
	}
	
}
