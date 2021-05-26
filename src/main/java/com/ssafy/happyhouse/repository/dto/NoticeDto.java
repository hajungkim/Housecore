package com.ssafy.happyhouse.repository.dto;
import java.sql.Timestamp;
public class NoticeDto {
    private int no;
    private String userid;
    private String subject;
    private Timestamp regtime;
    private String content;

    public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setSubject(String subject) { 
        this.subject = subject;
    }

    public String getSubject() { 
        return subject;
    }

    public void setRegtime(Timestamp regtime) { 
        this.regtime = regtime;
    }

    public Timestamp getRegtime() { 
        return regtime;
    }

    public void setContent(String content) { 
        this.content = content;
    }

    public String getContent() { 
        return content;
    }
}