package kr.co.mlec.service;

import java.util.List;

import kr.co.mlec.vo.QnaVO;

public interface QnaService {
	
	public List<QnaVO> list()throws Exception;
	public QnaVO detail(int bno) throws Exception; 
	public void delete(int bno) throws Exception;
	public void write(QnaVO qnavo) throws Exception;
	public void update(QnaVO qnavo) throws Exception;
}
