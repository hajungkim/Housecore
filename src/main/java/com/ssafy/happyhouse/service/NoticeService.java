package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.repository.dto.NoticeDto;
import com.ssafy.happyhouse.repository.dto.PageDto;

public interface NoticeService {
	public List<NoticeDto> selectNotices() throws SQLException;
	public void insertNotice(NoticeDto noticeDto);
	public void updateNotice(NoticeDto noticeDto);
	public void deleteNotice(int no);
	public NoticeDto selectNoticeByNo(int articleNo) throws SQLException;
	public Map<String, Object> selectNoticeByPageNum(PageDto pageDto) throws Exception;
}

