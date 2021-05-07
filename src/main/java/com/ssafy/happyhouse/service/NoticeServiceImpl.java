package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.repository.dao.NoticeDaoImpl;
import com.ssafy.happyhouse.repository.dao.NoticeMapper;
import com.ssafy.happyhouse.repository.dto.NoticeDto;
import com.ssafy.happyhouse.repository.dto.PageDto;
import com.ssafy.happyhouse.repository.dto.PageResultDto;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeMapper noticeDao;
	
//	public NoticeServiceImpl() {
//		super();
//		this.noticeDao = new NoticeDaoImpl();
//	}

	@Override
	public List<NoticeDto> selectNotices() throws SQLException {
		return noticeDao.selectNotices();
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
	public NoticeDto selectNoticeByNo(int articleNo) throws SQLException {
		noticeDao.increaseViewCnt(articleNo);
		return noticeDao.selectNoticeByNo(articleNo);
	}

	@Override				   
	public Map<String, Object> selectNoticeByPageNum(PageDto pageDto) throws Exception {
		// 게시물 목록 데이터 조회
		List<NoticeDto> list = noticeDao.selectNoticeByPageNum(pageDto);
		// 페이징을 위해서 게시물 전체 개수              
		int count = noticeDao.selectNoticeCount();
		
		PageResultDto prd = new PageResultDto(pageDto.getPageNo(), count);
		Map<String, Object> result = new HashMap<>();
		result.put("list", list);
		result.put("pageResult", prd);
		return result;
	}
}
