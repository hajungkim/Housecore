package com.ssafy.happyhouse.repository.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.happyhouse.repository.dto.MemberDto;
import com.ssafy.happyhouse.util.DBUtil;

public class MemberDaoImpl implements MemberMapper {
	private static MemberDaoImpl memberDaoImpl;
	
	private MemberDaoImpl() {}
	public static MemberDaoImpl getMemberDaoImpl() {
		if (memberDaoImpl == null) {
			memberDaoImpl = new MemberDaoImpl();
		}
		return memberDaoImpl;
	}
	@Override
	public MemberDto selectMember(String userId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto memberDto = null;
		try {
			conn = DBUtil.getConnection();
			// 사용자 이름, 이메일 정보 조회
			String sql = "select userid, passwd, username, nickname, address, addressdetail, interarea, email, phone from member \n";
			sql += "where userid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setUserid(rs.getString("userid"));
				memberDto.setPasswd(rs.getString("passwd"));
				memberDto.setUsername(rs.getString("username"));
				memberDto.setNickname(rs.getString("nickname"));
				memberDto.setAddress(rs.getString("address"));
				memberDto.setAddressdetail(rs.getString("addressdetail"));
				memberDto.setInterarea(rs.getString("interarea"));
				memberDto.setEmail(rs.getString("email"));
				memberDto.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			memberDto = null;
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return memberDto;
	}

	@Override
	public void insertMember(MemberDto memberDto) throws Exception {
		
		System.out.println(memberDto.getAddressdetail());
		System.out.println(memberDto.getAddressdetail());
		System.out.println(memberDto.getAddressdetail());
		DBUtil.update(
				
				"insert into member (userid, passwd, userName, nickName, address, addressDetail, interArea, email, phone) values (?, ?, ?, ?, ?, ?, ?, ?, ?)", 
				new Object [] {memberDto.getUserid(),
						memberDto.getPasswd(),
						memberDto.getUsername(),
						memberDto.getNickname(),
						memberDto.getAddress(),
						memberDto.getAddressdetail(),
						memberDto.getInterarea(),
						memberDto.getEmail(),
						memberDto.getPhone()
				});
//						
//}
//				memberDto.getUserid(),
//				memberDto.getPasswd(),
//				memberDto.getUsername(),
//				memberDto.getNickname(),
//				memberDto.getAddress(),
//				memberDto.getAddressdetail(),
//				memberDto.getInterarea(),
//				memberDto.getEmail(),
//				memberDto.getPhone());
	}

	@Override
	public void updateMember(MemberDto memberDto) throws Exception {
		System.out.println("dao : " + memberDto.getUserid());
		DBUtil.update(
				// update 쿼리로 변경
				"update member set passwd = ?, userName = ?, nickName = ?, address = ?, addressDetail = ?, interArea = ?, email = ?, phone = ? where userid = ?",
				memberDto.getPasswd(),
				memberDto.getUsername(),
				memberDto.getNickname(),
				memberDto.getAddress(),
				memberDto.getAddressdetail(),
				memberDto.getInterarea(),
				memberDto.getEmail(),
				memberDto.getPhone(),
				memberDto.getUserid());
	}

	@Override
	public void deleteMember(MemberDto memberDto) throws Exception {
		DBUtil.update(
				"delete from member where userid = ?", 
				memberDto.getUserid());
	}
	
	@Override
	public MemberDto login(MemberDto memberDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto result = null;
		try {
			conn = DBUtil.getConnection();
			// 사용자 이름, 이메일 정보 조회
			String sql = "select userid, passwd, username, nickname, address, addressdetail, interarea, email, phone from member \n";
			sql += "where userid = ? and passwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getUserid());
			pstmt.setString(2, memberDto.getPasswd());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new MemberDto();
				result.setUsername(rs.getString("userid"));
				result.setUsername(rs.getString("passwd"));
				result.setUsername(rs.getString("username"));
				result.setNickname(rs.getString("nickname"));
				result.setAddress(rs.getString("address"));
				result.setAddressdetail(rs.getString("addressdetail"));
				result.setInterarea(rs.getString("interarea"));
				result.setEmail(rs.getString("email"));
				result.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			memberDto = null;
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return result;
	}

}
