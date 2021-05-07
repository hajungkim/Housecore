package com.ssafy.happyhouse.repository.dto;
import java.sql.Timestamp;
public class NoticeDto {
    private int articleno;
    private String subject;
    private String userid;
    private Timestamp regtime;
    private int viewcnt;
    private String content;


    public void setArticleno(int articleno) { 
        this.articleno = articleno;
    }

    public int getArticleno() { 
        return articleno;
    }

    public void setSubject(String subject) { 
        this.subject = subject;
    }

    public String getSubject() { 
        return subject;
    }

    public void setUserid(String userid) { 
        this.userid = userid;
    }

    public String getUserid() { 
        return userid;
    }

    public void setRegtime(Timestamp regtime) { 
        this.regtime = regtime;
    }

    public Timestamp getRegtime() { 
        return regtime;
    }

    public void setViewcnt(int viewcnt) { 
        this.viewcnt = viewcnt;
    }

    public int getViewcnt() { 
        return viewcnt;
    }

    public void setContent(String content) { 
        this.content = content;
    }

    public String getContent() { 
        return content;
    }
}