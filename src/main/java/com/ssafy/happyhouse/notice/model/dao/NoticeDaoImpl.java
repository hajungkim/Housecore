package com.ssafy.happyhouse.notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.happyhouse.common.dto.PageDto;
import com.ssafy.happyhouse.notice.model.dto.NoticeDto;
import com.ssafy.happyhouse.util.DBUtil;


public class NoticeDaoImpl implements NoticeMapper {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public List<NoticeDto> selectNotices() throws SQLException {
		List<NoticeDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from notice \n");
			sql.append("order by articleNo desc \n");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeDto noticeDto = new NoticeDto();
				
				noticeDto.setArticleno(rs.getInt("articleNo"));
				noticeDto.setSubject(rs.getString("subject"));
				noticeDto.setUserid(rs.getString("userid"));
				noticeDto.setViewcnt(rs.getInt("viewCnt"));
				noticeDto.setContent(rs.getString("content"));
				noticeDto.setRegtime(rs.getTimestamp("regtime"));
				
				list.add(noticeDto);
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		
		return list;
	}
	

	@Override
	public void insertNotice(NoticeDto noticeDto) {
		StringBuilder sql = new StringBuilder("insert into notice (subject, userid, viewCnt, content)\n");
		sql.append(" values (?,?,?,?)");
		try {
			DBUtil.update(sql.toString(), new Object [] {noticeDto.getSubject(), noticeDto.getUserid(), noticeDto.getViewcnt(), noticeDto.getContent()});
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateNotice(NoticeDto noticeDto) {
		StringBuilder sql = new StringBuilder("update notice set subject = ?, content = ? where articleNo = ?\n");
		try {
			DBUtil.update(sql.toString(), new Object [] {noticeDto.getSubject(), noticeDto.getContent(), noticeDto.getArticleno()});
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteNotice(int no) {
		StringBuilder sql = new StringBuilder("delete from notice \n");
		sql.append(" where articleno = ?");
		try {
			DBUtil.update(sql.toString(), new Object [] {no});
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public NoticeDto selectNoticeByNo(int articleNo) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeDto noticeDto = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from notice \n");
			sql.append("where articleNo = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, Integer.toString(articleNo));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				noticeDto = new NoticeDto();
				
				noticeDto.setArticleno(rs.getInt("articleNo"));
				noticeDto.setSubject(rs.getString("subject"));
				noticeDto.setUserid(rs.getString("userid"));
				noticeDto.setViewcnt(rs.getInt("viewCnt"));
				noticeDto.setContent(rs.getString("content"));
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return noticeDto;
	}


	@Override
	public void increaseViewCnt(int articleNo) throws SQLException {
		StringBuilder sql = new StringBuilder("update notice set viewCnt = viewCnt + 1 \n");
		sql.append(" where articleNo = ?");
		DBUtil.update(sql.toString(), new Object [] {articleNo});
	}


	@Override
	public int selectNoticeCount() throws SQLException {
		try ( // auto closable
				Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						    "SELECT count(*) "
						  + " FROM notice "
				);
		) { // try 블록 시작
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		}
	}


	@Override
	public List<NoticeDto> selectNoticeByPageNum(PageDto pageDto) throws SQLException {
		List<NoticeDto> list = new ArrayList<>();
		try (
				Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						    "SELECT "
						  + "	* "
						  + "FROM "
						  + "	notice "
						  + "ORDER BY "
						  + "	articleNo desc "
						  + " LIMIT ?, ? "
				);
		) {
				int index = 1;
				pstmt.setInt(index++, pageDto.getBegin());
				pstmt.setInt(index++, pageDto.getListSize());
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					NoticeDto noticeDto = new NoticeDto();
					noticeDto.setArticleno(rs.getInt("articleNo"));
					noticeDto.setSubject(rs.getString("subject"));
					
					noticeDto.setUserid(rs.getString("userid"));
					// 이거 문제 되는지 확인
					noticeDto.setRegtime(rs.getTimestamp("regTime"));
					noticeDto.setViewcnt(rs.getInt("viewCnt"));
					noticeDto.setContent(rs.getString("content"));
					list.add(noticeDto);
				}
				return list;
		}
	}
}


