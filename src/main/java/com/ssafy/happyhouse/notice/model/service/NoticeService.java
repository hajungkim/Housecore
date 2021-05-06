package com.ssafy.happyhouse.notice.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.common.dto.PageDto;
import com.ssafy.happyhouse.notice.model.dto.NoticeDto;

public interface NoticeService {
	public List<NoticeDto> selectNotices() throws SQLException;
	public void insertNotice(NoticeDto noticeDto);
	public void updateNotice(NoticeDto noticeDto);
	public void deleteNotice(int no);
	public NoticeDto selectNoticeByNo(int articleNo) throws SQLException;
	
	Map<String, Object> test(PageDto pageDto) throws Exception;
}

