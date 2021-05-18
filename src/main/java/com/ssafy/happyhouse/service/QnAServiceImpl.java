package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.repository.dao.QnAMapper;
import com.ssafy.happyhouse.repository.dto.QnADto;

@Service
public class QnAServiceImpl implements QnAService{
	
	@Autowired
	private QnAMapper qnaMapper;
	
	@Override
	public List<QnADto> selectQnAs() throws SQLException {
		return qnaMapper.selectQnAs();
	}
	
	@Override
	public List<QnADto> selectQnA(String userId) throws SQLException {
		return qnaMapper.selectQnA(userId);
	}
	
	@Override
	public QnADto selectOneQnA(int no) throws SQLException {
		return qnaMapper.selectOneQnA(no);
	}

	@Override
	public void insertQnA(QnADto qnaDto) {
		qnaMapper.insertQnA(qnaDto);
	}

	@Override
	public void updateQnA(QnADto qnaDto) {
		System.out.println("dsdsasddsadsdsa");
		qnaMapper.updateQnA(qnaDto);
	}

	@Override
	public void deleteQnA(int no) {
		qnaMapper.deleteQnA(no);
	}

	
}
