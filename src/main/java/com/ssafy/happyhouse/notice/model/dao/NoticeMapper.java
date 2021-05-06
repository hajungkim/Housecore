package com.ssafy.happyhouse.notice.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.common.dto.PageDto;
import com.ssafy.happyhouse.notice.model.dto.NoticeDto;

public interface NoticeMapper {
	public int selectNoticeCount() throws SQLException;
	public List<NoticeDto> selectNotices() throws SQLException;
	public NoticeDto selectNoticeByNo(int articleNo) throws SQLException; // 번호로 조회
	public List<NoticeDto> selectNoticeByPageNum(PageDto pageDto) throws SQLException;
	public void increaseViewCnt(int articleNo) throws SQLException; // 조회수 증가
	public void insertNotice(NoticeDto noticeDto);
	public void updateNotice(NoticeDto noticeDto);
	public void deleteNotice(int no);
}

