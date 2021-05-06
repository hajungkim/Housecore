package com.ssafy.happyhouse.notice.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.common.dto.PageDto;
import com.ssafy.happyhouse.common.dto.PageResultDto;
import com.ssafy.happyhouse.notice.model.dao.NoticeDao;
import com.ssafy.happyhouse.notice.model.dao.NoticeDaoImpl;
import com.ssafy.happyhouse.notice.model.dto.NoticeDto;

public class NoticeServiceImpl implements NoticeService {
	private NoticeDao noticeDao;
	
	public NoticeServiceImpl() {
		super();
		this.noticeDao = new NoticeDaoImpl();
	}

	@Override
	public List<NoticeDto> selectNotice() throws SQLException {
		return noticeDao.selectNotice();
	}

	@Override
	public void insertNotice(NoticeDto noticeDto) {
		noticeDao.insertNotice(noticeDto);
	}

	@Override
	public void updateNotice(NoticeDto noticeDto) {
		noticeDao.updateNotice(noticeDto);
	}

	@Override
	public void deleteNotice(int no) {
		noticeDao.deleteNotice(no);
	}

	@Override
	public NoticeDto selectNotice(int articleNo) throws SQLException {
		noticeDao.increaseViewCnt(articleNo);
		return noticeDao.selectNotice(articleNo);
	}

	@Override
	public Map<String, Object> test(PageDto pageDto) throws Exception {
		// 게시물 목록 데이터 조회
		List<NoticeDto> list = noticeDao.selectNotice(pageDto);
		// 페이징을 위해서 게시물 전체 개수
		int count = noticeDao.selectNoticeCount();
		
		PageResultDto prd = new PageResultDto(pageDto.getPageNo(), count);
		Map<String, Object> result = new HashMap<>();
		result.put("list", list);
		result.put("pageResult", prd);
		return result;
	}
}
