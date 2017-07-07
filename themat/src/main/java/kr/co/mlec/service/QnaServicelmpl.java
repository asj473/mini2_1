package kr.co.mlec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mlec.mapper.QnaMapper;
import kr.co.mlec.vo.QnaVO;

@Service("qnaService")
public class QnaServicelmpl implements QnaService{

	@Autowired
	private QnaMapper mapper;
	
	@Override
	public List<QnaVO> list() throws Exception {
		return mapper.selectBoard();
	}
	
	@Override
	public QnaVO detail(int bno) throws Exception {
		return mapper.selectBoardByNo(bno);
		
	}

}
