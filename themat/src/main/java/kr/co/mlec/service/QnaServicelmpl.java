package kr.co.mlec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mlec.mapper.QnaMapper;
import kr.co.mlec.vo.PageVO;
import kr.co.mlec.vo.QnaCommentVO;
import kr.co.mlec.vo.QnaVO;

@Service("qnaService")
public class QnaServicelmpl implements QnaService{

	@Autowired
	private QnaMapper mapper;
	
	@Override
	public QnaVO detail(int bno) throws Exception {
		return mapper.selectBoardByNo(bno);
	}

	@Override
	public void delete(int bno) throws Exception {
		 mapper.delete(bno);
	}

	@Override
	public void write(QnaVO qnavo) throws Exception {
		mapper.write(qnavo);
	}

	@Override
	public void update(QnaVO qnavo) throws Exception {
		mapper.update(qnavo);
		
	}
	
	//페이징 카운트
	@Override
	public int selectCount(PageVO page) throws Exception {
		return mapper.selectCount(page);
	}

	@Override
	public List<QnaVO> list(PageVO page) throws Exception {
		return mapper.selectBoard(page);
	}

	@Override
	public List<QnaCommentVO> commentList(int no) throws Exception {
		
		return mapper.selectBoardCommentByNo(no) ;
	}

	@Override
	public List<QnaCommentVO> commentRegist(QnaCommentVO comment) throws Exception {
		mapper.insertBoardComment(comment);
		return mapper.selectBoardCommentByNo(comment.getNo());
	}

	@Override
	public List<QnaCommentVO> commentDelete(QnaCommentVO comment) throws Exception {
		mapper.deleteBoardComment(comment.getCommentNo());
		System.out.println("서비스 ");
		return mapper.selectBoardCommentByNo(comment.getNo());
	}

}
