package com.ssafy.happyhouse.repository.dto;
import java.sql.Timestamp;
public class MemberDto {
    private String userid;
    private String passwd;
    private String username;
    private String nickname;
    private String interarea;
    private String email;
    private Timestamp regidate;
    
    @Override
	public String toString() {
		return "MemberDto [userid=" + userid + ", passwd=" + passwd + ", username=" + username + ", nickname="
				+ nickname + ", interarea=" + interarea + ", email=" + email + ", regidate=" + regidate + "]";
	}

    public MemberDto() {}
    public MemberDto(String userid, String passwd, String username, String nickname, String interarea, String email) {
    	this.userid = userid;
    	this.passwd = passwd;
    	this.username = username;
    	this.nickname = nickname;
    	this.interarea = interarea;
    	this.email = email;
    }
    
    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserid() {
        return userid;
    }

    public void setPasswd(String passwd) { 
        this.passwd = passwd;
    }

    public String getPasswd() { 
        return passwd;
    }

    public void setUsername(String username) { 
        this.username = username;
    }

    public String getUsername() { 
        return username;
    }

    public void setNickname(String nickname) { 
        this.nickname = nickname;
    }

    public String getNickname() { 
        return nickname;
    }

    public void setInterarea(String interarea) { 
        this.interarea = interarea;
    }

    public String getInterarea() { 
        return interarea;
    }

    public void setEmail(String email) { 
        this.email = email;
    }

    public String getEmail() { 
        return email;
    }
    
    public void setRegidate(Timestamp regidate) { 
        this.regidate = regidate;
    }

    public Timestamp getRegidate() { 
        return regidate;
    }
}