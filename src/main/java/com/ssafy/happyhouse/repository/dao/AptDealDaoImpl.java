package com.ssafy.happyhouse.repository.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.happyhouse.repository.dto.AptDealDto;
import com.ssafy.happyhouse.repository.dto.PageDto;
import com.ssafy.happyhouse.repository.dto.SearchDto;
import com.ssafy.happyhouse.util.DBUtil;

public class AptDealDaoImpl implements AptDealMapper {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<AptDealDto> selectAptDeal(PageDto pageDto) throws SQLException {
		List<AptDealDto> list = new ArrayList<AptDealDto>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from housedeal \n");
			sql.append("order by no desc \n");
			sql.append("limit ?, 9 \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, (pageDto.getPageNo() - 1) * 9);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AptDealDto aptDealDto = new AptDealDto();

				aptDealDto.setNo(rs.getInt("no"));
				aptDealDto.setDong(rs.getString("dong"));
				aptDealDto.setAptName(rs.getString("AptName"));
				aptDealDto.setCode(rs.getString("code"));
				aptDealDto.setDealAmount(rs.getString("dealAmount"));
				aptDealDto.setBuildYear(rs.getString("buildYear"));
				aptDealDto.setDealYear(rs.getString("dealYear"));
				aptDealDto.setDealMonth(rs.getString("dealMonth"));
				aptDealDto.setDealDay(rs.getString("dealDay"));
				aptDealDto.setArea(rs.getString("area"));
				aptDealDto.setFloor(rs.getString("floor"));
				aptDealDto.setJibun(rs.getString("jibun"));
				aptDealDto.setType(rs.getString("type"));
				aptDealDto.setRentMoney(rs.getString("rentMoney"));

				list.add(aptDealDto);
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}

		return list;
	}

	@Override
	public List<AptDealDto> selectAptDealBySearch(SearchDto searchDto) throws SQLException {
		List<AptDealDto> list = new ArrayList<AptDealDto>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			if (searchDto.getDongname() != null) {
				conn = DBUtil.getConnection();
				StringBuilder sql = new StringBuilder();
				sql.append("select * from housedeal\n");
				sql.append("where dong = ?");
				sql.append("order by no desc \n");
				sql.append("limit ?, 9 \n");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, searchDto.getDongname());
				pstmt.setInt(2, (searchDto.getPageNo() - 1) * 9);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					AptDealDto aptDealDto = new AptDealDto();

					aptDealDto.setNo(rs.getInt("no"));
					aptDealDto.setDong(rs.getString("dong"));
					aptDealDto.setAptName(rs.getString("AptName"));
					aptDealDto.setCode(rs.getString("code"));
					aptDealDto.setDealAmount(rs.getString("dealAmount"));
					aptDealDto.setBuildYear(rs.getString("buildYear"));
					aptDealDto.setDealYear(rs.getString("dealYear"));
					aptDealDto.setDealMonth(rs.getString("dealMonth"));
					aptDealDto.setDealDay(rs.getString("dealDay"));
					aptDealDto.setArea(rs.getString("area"));
					aptDealDto.setFloor(rs.getString("floor"));
					aptDealDto.setJibun(rs.getString("jibun"));
					aptDealDto.setType(rs.getString("type"));
					aptDealDto.setRentMoney(rs.getString("rentMoney"));

					list.add(aptDealDto);
				}
			} else {
				conn = DBUtil.getConnection();
				StringBuilder sql = new StringBuilder();
				sql.append("select * from housedeal \n");
				sql.append("order by no desc \n");
				sql.append("limit ?, 9 \n");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setInt(1, (searchDto.getPageNo() - 1) * 9);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					AptDealDto aptDealDto = new AptDealDto();

					aptDealDto.setNo(rs.getInt("no"));
					aptDealDto.setDong(rs.getString("dong"));
					aptDealDto.setAptName(rs.getString("AptName"));
					aptDealDto.setCode(rs.getString("code"));
					aptDealDto.setDealAmount(rs.getString("dealAmount"));
					aptDealDto.setBuildYear(rs.getString("buildYear"));
					aptDealDto.setDealYear(rs.getString("dealYear"));
					aptDealDto.setDealMonth(rs.getString("dealMonth"));
					aptDealDto.setDealDay(rs.getString("dealDay"));
					aptDealDto.setArea(rs.getString("area"));
					aptDealDto.setFloor(rs.getString("floor"));
					aptDealDto.setJibun(rs.getString("jibun"));
					aptDealDto.setType(rs.getString("type"));
					aptDealDto.setRentMoney(rs.getString("rentMoney"));

					list.add(aptDealDto);
				}
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}

		return list;
	}

	@Override
	public String selectDongName(String dongcode) throws SQLException {
		String dongName = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select dong from dongcode \n");
			sql.append("where dongcode = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dongcode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dongName = rs.getString("dong");
				break;
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}

		return dongName;
	}

	@Override
	public int selectAptCount() throws SQLException {
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn
						.prepareStatement("SELECT " + "	COUNT(*) " + "FROM " + "	housedeal a ");) {
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		}
	}
	@Override
	public int selectAptCountBySearch(SearchDto searchDto) throws SQLException {
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn
						.prepareStatement("SELECT " + "	COUNT(*) " + "FROM " + " housedeal a where dong = ?");) {
			pstmt.setString(1, searchDto.getDongname());
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		}
	}
}
