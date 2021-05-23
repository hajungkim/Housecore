package com.ssafy.happyhouse.repository.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.repository.dto.AptCommentDto;

public interface AptCommentMapper {
	List<AptCommentDto> selectComments(int aptNo) throws SQLException;
}
