package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.repository.dao.AptCommentMapper;
import com.ssafy.happyhouse.repository.dto.AptCommentDto;

@Service
public class AptCommentServiceImpl implements AptCommentService {
	
	@Autowired
	private AptCommentMapper aptCommentMapper;

	@Override
	public List<AptCommentDto> selectComments(int aptNo) throws SQLException {
		return aptCommentMapper.selectComments(aptNo);
	}

}
