package com.ssafy.happyhouse.repository.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.repository.dto.NoticeDto;
import com.ssafy.happyhouse.repository.dto.PageDto;

public interface NoticeMapper {
	int selectNoticeCount() throws SQLException;
	List<NoticeDto> selectNotices() throws SQLException;
	NoticeDto selectNoticeByNo(int articleNo) throws SQLException; // 번호로 조회
	List<NoticeDto> selectNoticeByPageNum(PageDto pageDto) throws SQLException;
	void increaseViewCnt(int articleNo) throws SQLException; // 조회수 증가
	void insertNotice(NoticeDto noticeDto);
	void updateNotice(NoticeDto noticeDto);
	void deleteNotice(int no);
}

