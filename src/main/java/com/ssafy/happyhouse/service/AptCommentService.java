package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.repository.dto.AptCommentDto;

public interface AptCommentService {
	public List<AptCommentDto> selectComments(int aptNo) throws SQLException;
}
