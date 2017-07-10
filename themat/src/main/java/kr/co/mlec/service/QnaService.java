package kr.co.mlec.service;

import java.util.List;

import kr.co.mlec.vo.PageVO;
import kr.co.mlec.vo.QnaCommentVO;
import kr.co.mlec.vo.QnaVO;

public interface QnaService {
	
	public QnaVO detail(int bno) throws Exception; 
	public void delete(int bno) throws Exception;
	public void write(QnaVO qnavo) throws Exception;
	public void update(QnaVO qnavo) throws Exception;
	
	//리스트  엔  페이징 카운트 
	public List<QnaVO> list(PageVO page)throws Exception;
	public int selectCount(PageVO page) throws Exception;
	
	//댓글
	public List<QnaCommentVO> commentList(int no) throws Exception;
	public List<QnaCommentVO> commentRegist(QnaCommentVO comment) throws Exception;
	public List<QnaCommentVO> commentDelete(QnaCommentVO comment) throws Exception;
	public List<QnaCommentVO> commentUpdate(QnaCommentVO comment) throws Exception;
	
}
