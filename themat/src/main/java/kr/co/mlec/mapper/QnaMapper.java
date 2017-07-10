package kr.co.mlec.mapper;

import java.util.List;

import kr.co.mlec.vo.PageVO;
import kr.co.mlec.vo.QnaCommentVO;
import kr.co.mlec.vo.QnaVO;

public interface QnaMapper {
	
	public QnaVO selectBoardByNo(int no) throws Exception;
	public void delete(int no) throws Exception;
	public void write(QnaVO qnavo) throws Exception;
	public void update(QnaVO qnavo) throws Exception;
	
	// 리스트  엔  페이징 카운트 
	public List<QnaVO> selectBoard(PageVO qnavo) throws Exception;
	public int selectCount(PageVO qnavo) throws Exception;
	
	
	// 댓글처리 
	public List<QnaCommentVO> selectBoardCommentByNo(int no) throws Exception;
	public void insertBoardComment(QnaCommentVO comment) throws Exception;
	public void deleteBoardComment(int commentNo) throws Exception;
	public void updateBoardComment(QnaCommentVO comment) throws Exception;
	
}
