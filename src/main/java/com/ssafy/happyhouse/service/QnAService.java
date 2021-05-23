package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;
import com.ssafy.happyhouse.repository.dto.QnADto;

public interface QnAService {
	List<QnADto> selectQnAs() throws SQLException;
	List<QnADto> selectQnA(String userId) throws SQLException;
	QnADto selectOneQnA(int no) throws SQLException;
	boolean insertQnA(QnADto qnaDto);
	boolean updateQnA(QnADto qnaDto);
	boolean deleteQnA(int no);
}
