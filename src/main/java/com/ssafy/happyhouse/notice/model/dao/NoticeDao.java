package com.ssafy.happyhouse.notice.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.common.dto.PageDto;
import com.ssafy.happyhouse.notice.model.dto.NoticeDto;

public interface NoticeDao {
	public List<NoticeDto> selectNotice() throws SQLException;
	public void insertNotice(NoticeDto noticeDto);
	public void updateNotice(NoticeDto noticeDto);
	public void deleteNotice(int no);
	public NoticeDto selectNotice(int articleNo) throws SQLException; // 번호로 조회
	public void increaseViewCnt(int articleNo) throws SQLException; // 조회수 증가
	
	int selectNoticeCount() throws SQLException;
	List<NoticeDto> selectNotice(PageDto pageDto) throws SQLException;
}

