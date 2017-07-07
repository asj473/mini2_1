package kr.co.mlec.mapper;

import java.util.List;

import kr.co.mlec.vo.QnaVO;

public interface QnaMapper {
	
	public List<QnaVO> selectBoard() throws Exception;
	public QnaVO selectBoardByNo(int no) throws Exception;
	
	
}